import scala.util.Random
object Filter37 extends App{
  case class Employee(name: String, age: Int)  {}
  val age1 = 30
  val List1 = List.fill(50)(Employee(name=Random.alphanumeric.take(8).mkString , age=age1+Random.nextInt(30)))
  println("Printing list before changes")
  println(List1)
  println("Printing list after changes")
  val List2: List[Employee] = List1.map(x => x.copy(x.name.toUpperCase())).filter(_.age > 37)
  println(List2)
}

