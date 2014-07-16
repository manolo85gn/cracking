package chapter1;

public class UniqueCharacter {

  public static void main( String args[]) {	
    UniqueCharacter uniqueCharacter = new UniqueCharacter();
    if (args.length > 0 && args[0] != null && !args[0].trim().equals("") ) {
      System.out.println("Input: "+ args[0]);	    
      Boolean result = uniqueCharacter.determineUnique(args[0]);	    
      System.out.println("Result for the String " + args[0] + " is " + result);
    } else {
      System.err.println("Missing argument");    
    }

  }

  Boolean determineUnique(String input) {
    if( input.equals("") ) {
      return true;	    
    } else {
      Character head = input.charAt(0);
      String tail = input.substring(1, input.length() );
      Boolean result = determineUniqueAux(head, tail);
      if( result ) {
        return determineUnique(tail);
      } else {
        return false;	    
      }
    }
  }

  Boolean determineUniqueAux(Character pattern, String input) {
    for( int i = 0; i < input.length(); i++)  {
      if(pattern == input.charAt(i)) {
	return false;
      }      
    }
    return true;
  }

}
