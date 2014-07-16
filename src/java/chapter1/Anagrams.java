package chapter1;

public class Anagrams {

  public static void main(String args[]) {
    if(args != null && args.length == 2) {
      Anagrams anagrams = new Anagrams();
      boolean result = anagrams.isAnagram(args[0], args[1]);
      if (result) {
        System.out.printf("Las cadenas %s y %s SI son anagramas\n", args[0], args[1]);
      } else {
        System.out.printf("Las cadenas %s y %s No son anagramas\n", args[0], args[1]);
      }
    } else {
      System.err.println("Bad number of arguments");
    }
    
  }

  public boolean isAnagram(String input1, String input2) {
    if( input1.length() != input2.length() ) {
      return false;
    } else if( input1.length() > 0 ) {
      
      Character head1 = input1.charAt(0);
      String tail1 = input1.substring( 1, input1.length() );
      String inputAux  = removeChar(head1, input2);

      return isAnagram( tail1, inputAux );
    } else {
      return true;
    }
  }

  public String removeChar(Character c, String input) {
    if ( input.length() > 0 ) {
      Character head = input.charAt(0);
      String tail = input.substring(1, input.length() );
      if( c == head ) {
        return tail;
      } else {
        return  head + removeChar(c, tail);
      }
    } else {
      return "";
    }
  }

}

