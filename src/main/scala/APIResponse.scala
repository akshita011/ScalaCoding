import akka.actor.ActorSystem
import akka.http.scaladsl.model.{HttpMethods, HttpRequest, HttpResponse}
import akka.http.scaladsl.unmarshalling._
import akka.http.scaladsl.{ConnectionContext, Http}
import akka.stream.ActorMaterializer
import sttp.monad.syntax.MonadErrorOps

import java.security.cert.X509Certificate
import javax.net.ssl.{KeyManager, SSLContext, X509TrustManager}
import scala.concurrent.Await
import scala.concurrent.duration.Duration
object APIResponse{

  private val trustfulSslContext: SSLContext = {
    object NoCheckX509TrustManager extends X509TrustManager {
      override def checkClientTrusted(chain: Array[X509Certificate], authType: String): Unit = ()
      override def checkServerTrusted(chain: Array[X509Certificate], authType: String): Unit = ()
      override def getAcceptedIssuers: Array[X509Certificate] = Array[X509Certificate]()
    }
    val context = SSLContext.getInstance("TLS")
    context.init(Array[KeyManager](), Array(NoCheckX509TrustManager), null)
    context
  }

  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem()
    implicit val mat: ActorMaterializer = ActorMaterializer()
    val http = Http()
    val req = HttpRequest(uri = "https://catfact.ninja/fact", method = HttpMethods.GET)
    val noCertificateCheckContext = ConnectionContext.https(trustfulSslContext)
    val res: HttpResponse = Await.result(http.singleRequest(req, noCertificateCheckContext), Duration.Inf)
    Unmarshal(res).map(x => println(x))

  }}