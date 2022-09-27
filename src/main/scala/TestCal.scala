package Cal
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.{convertToAnyShouldWrapper, equal}
import org.scalatest.prop.{TableDrivenPropertyChecks, TableFor2}

class TestCal extends AnyFlatSpec with TableDrivenPropertyChecks  {

  val cases: TableFor2[Int, Int] = Table(
    ("operation", "expectedOutput"),
    (Cal.calc('+', 4, 2), 6),
    (Cal.calc('-', 4, 2), 2),
    (Cal.calc('*', 4, 2), 8),
    (Cal.calc('/', 4, 2), 2)
  )

  forAll(cases) { (Operation, ExpectedOutput) =>
    Operation should equal (ExpectedOutput)
    println(Operation + "Successful")
    }
//put
}
