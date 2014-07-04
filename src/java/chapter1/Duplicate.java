package chapter1;

public class Duplicate {

  public static void main(String args[]) {

    if( args != null && args.length > 0) {
      Duplicate duplicate = new Duplicate();
      String result = duplicate.removeDuplicated(args[0]);
      System.out.printf(
	"El resultado de la cadena %s es: \n '%s' \n",
            args[0], result);
    }
	    
  }

  public String removeDuplicated(String input) {
    if( input != null && input.length() > 0 ) {
      Character head = input.charAt(0);
      String tail = input.substring(1, input.length());
      return isDuplicated(head, tail) ? removeDuplicated(tail): 
	      ( head + removeDuplicated(tail) );
    } else {
      return input;	    
    }
  }	    

  public boolean isDuplicated(Character c, String input) {
    for(int i = 0; i < input.length(); i++) {
      Character current = input.charAt(i);	    
      if (current == c) {
	return true;      
      }
    }

    return false;    
  }

}

