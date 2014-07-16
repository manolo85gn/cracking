package chapter1;

public class Reverse {
  
	public static void main(String args[]) {
	  if( args.length > 0 ) {
	    Reverse reverse = new Reverse();
            String result = reverse.apply(args[0]);
	    System.out.println("Result: " + result);
	  } else {
	    System.err.println("Error: missing parameters");
	  }
	}

	public String apply(String input) {
	  return applyAux(input, "");
	}

	public String applyAux(String input, String acc) {
	  if( input.equals("") ){
	    return acc;	
	  } else {
	    Character head = input.charAt(0);
            String tail = input.substring(1, input.length() );
	    return applyAux(tail, (head + acc) );
	  }
	}

}


