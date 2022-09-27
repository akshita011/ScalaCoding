object Animals extends App{

  trait Creature { val noLegs : Int }

  case class Dog(bark:Boolean, noLegs:Int=4) extends Creature{}
  case class Human(think: Boolean, noLegs:Int=2) extends Creature{}
  case class Octopus(bite: Boolean, noLegs:Int=8) extends Creature{}

  val List1: List[Creature] = List(Dog(true), Dog(true), Dog(true), Dog(true), Human(true), Human(true), Octopus(true), Octopus(true), Octopus(true))
  println(List1)
  def unapply(X:Creature): Option[Creature] = {
    X match {
      case Dog(_, _) => Some(X)
      case _ => None
    }
  }
  val List2: List[Creature] = List1.flatMap(unapply)
  println(List2)
}
