package chapter1

object UniqueCharacter extends App {
	
	def contains(c: Char, input: Seq[Char]) : Boolean = {
		input match {
			case head+:tail => c != head && contains(c, tail)
			case Nil => true
		}
	}

	def isUniqueCharacter(input: Seq[Char]) : Boolean = {
		input match {
			case head+:tail => contains(head, tail) && isUniqueCharacter(tail)
			case Nil => true 	
		}
	}

	if( args.length > 0 && args(0) != null) {
	  Console.println( "Resultado: " + isUniqueCharacter(args(0).toSeq) )
	} else {
		Console.println("Argumentos inválidos")
	}

}
