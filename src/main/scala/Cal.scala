package Cal
object Cal extends App{
   var result: Int = 0
   def calc(ch: Char, num1: Int, num2: Int): Int ={
     ch match {
       case '+' => result = num1 + num2
       case '-' => result = num1 - num2
       case '*' => result = num1 * num2
       case '/' => result = num1 / num2
       case _ => println("Invalid Operation")
     }
     result
   }
  println("Choose the operation to perform (+, -, *, /): ")
  val ch: Char = scala.io.StdIn.readChar()
  println("Enter the 1st number: ")
  val num1: Int = scala.io.StdIn.readInt()
  println("Enter the 2nd number: ")
  val num2: Int = scala.io.StdIn.readInt()
  calc(ch, num1, num2)
}
