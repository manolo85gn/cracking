package chapter1

object Reverse extends App {
  
  def apply(input: Seq[Char]) : String = {
    applyAux(input, "")
  }

  def applyAux(input: Seq[Char], acc: String) : String = {
    input match {
      case Nil => acc
      case x +: xs => applyAux(xs, x + acc)  
    }
  }


  if( args.length > 0 && args(0) != null) {
    Console.println( "Resultado: " + apply(args(0).toSeq) )
  } else {
    Console.println("Argumentos inválidos")
  }
}
