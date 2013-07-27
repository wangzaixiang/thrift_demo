package demo

case class Operation(val value: Int) extends AnyVal
object Operation {
  val ADD = Operation(1)
  val SUBSTRACT = Operation(2)
  val MULTIPLY = Operation(3)
  val DIVIDE = Operation(4)
}
  
class Work {
  
  @Protocol.Field(tag = 1)
  var num1: Int = 0
  
  @Protocol.Field(tag = 2)
  var num2: Int = _
  
  @Protocol.Field(tag = 3)
  var op:  Operation = _
  
  @Protocol.Field(tag = 4, optional = true)
  var comment: String = _
}

trait Calculator {
  
  def ping
  
  def add(num1: Int, num2: Int): Int
  
  def calculate(logId: Int, work: Work): Int
  
  def zip
}

object Tutorial {

}