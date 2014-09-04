package codility;

import java.math.BigInteger;

public class Factorial {

	public static void main(String[] args) {

	  Factorial f = new Factorial();
	  int result1 = f.solution(Integer.parseInt(args[0]));

	  System.out.println("Result1: " + result1);
	}

	public int solution(int N) {
          if( N == 0 || N == 1){
	    return 1;
	  }
	  	
	  BigInteger f = getFactorial(N, BigInteger.valueOf(N) );
          System.out.println("Factorial N: " + N + " --> " + f);
	  return sum(f);
	}

	BigInteger getFactorial(int N, BigInteger acc){
          if(N == 1) {
	    return acc;
	  } else {
 	    BigInteger nAux = BigInteger.valueOf(N - 1);	  
	    acc = acc.multiply(nAux);
	    //System.out.println( "accAux: " + N + "  *  " + nAux + " =  " + acc );
	    return getFactorial( N-1, acc );
	  }
	}

	int sum(BigInteger f){
	  int total = 0; 	
	  String factorialString = f.toString();
	  int length = factorialString.length();
	  for( int i = 0; i < length; i++) {
	    total += Character.getNumericValue( factorialString.charAt(i) );
	  }
	  return total;
	}

}
