package codility;

import java.math.BigInteger;

public class Multiplicative {
  public static void main(String[] args){
	Multiplicative m = new Multiplicative();
        int result = m.solution( 
		new int[]{0, 1000, 1000, 2, 3, 5}, 
		new int[]{500000, 999999, 999999, 0, 0, 20000}  );
	
	System.out.println(">>>>>> Result: " + result);	
  }

  public static final int F = 1000000;

  int solution(int[] A, int[] B) {
     int pairs = 0;
     int length = A.length;

     for(int i = 0; i < length - 1; i++){
       int[] vectorA = new int[]{ A[i], B[i] };
       for( int j = i + 1; j < length; j++) {
           int[] vectorB = new int[]{ A[j], B[j]};
           if( isValidPair( vectorA, vectorB )  ) {
	      //System.out.println( "(" + vectorA[0] + " , " + vectorA[1] + ") -- (" + vectorB[0] + " , " + vectorB[1] + ")");   
              pairs++;
           }
       }
     }
    
     return pairs;
  }

  long[] sum(int[] vectorA, int[] vectorB) {
    long fractionTotal = vectorA[1] + vectorB[1];
    long fraction = fractionTotal > F ? (fractionTotal % F) : fractionTotal;
    long carrier = (fractionTotal - fraction) / F;	    
    long integerPart = vectorA[0] + vectorB[0] + carrier;
    //System.out.println( "+++++ integerPart: " + integerPart + " -- fraction: " + fraction);
    return new long[]{integerPart, fraction};
  }
/*
  long[] mult(int[] vectorA, int[] vectorB) {
    BigInteger fractionTotal = BigInteger.valueOf( (vectorA[0] * F + vectorA[1]) ).multiply( BigInteger.valueOf( ( vectorB[0] * F + vectorB[1]) ));
    System.out.println(fractionTotal);
    fractionTotal = fractionTotal.divide(BigInteger.valueOf(F));
    
    //System.out.println( "(" + vectorA[0] + " , " + vectorA[1] + ") -- (" + vectorB[0] + " , " + vectorB[1] + ")");   
    BigInteger fraction = fractionTotal.remainder(BigInteger.valueOf(F));
    BigInteger integerPart = fractionTotal.subtract(fraction).divide(BigInteger.valueOf(F) );	    
    //System.out.println( ">>>>> integerPart: " + integerPart + " -- fraction: " + fraction);
    return new long[]{integerPart.longValue(), fraction.longValue()};
  }*/

  long[] mult(int[] vectorA, int[] vectorB) {
    BigInteger bigF = BigInteger.valueOf(F);	  
    //long fractionTmp = vectorA[1] * (vectorB[0]*F + vectorB[1]) + (vectorA[0] * F * vectorB[1] );
    BigInteger f1 = BigInteger.valueOf(vectorA[1]).multiply( BigInteger.valueOf(vectorB[0]).multiply(bigF).add( BigInteger.valueOf(vectorB[1]) )   );
    BigInteger f2 = BigInteger.valueOf(vectorA[0]).multiply( bigF ).multiply( BigInteger.valueOf(vectorB[1]) );
    BigInteger fractionTmp = f1.add(f2);
    BigInteger fraction = fractionTmp.remainder( bigF.multiply(bigF) );
    BigInteger carrier = fractionTmp.subtract(fraction).divide( bigF.multiply(bigF)  );
    BigInteger integerPart = BigInteger.valueOf(vectorA[0] * vectorB[0]).add(carrier);
    return new long[]{ integerPart.longValue(), fraction.divide(bigF).longValue()};
  }

/*
  long[] mult(int[] vectorA, int[] vectorB) {
    double a = vectorA[0] + vectorA[1]/F;
    double b = vectorB[0] + vectorB[1]/F;
    BigDecimal product = new BigDecimal(a).multiply( new BigDecimal(b) );
    long fractional = product.reminder();
    long integerPart = product.
  }*/

  Boolean isValidPair(int[] vectorA, int[] vectorB) {
    if( vectorA[0] < 1 || vectorB[0] < 1 ) {
       return false;
    } else {	  
    	long[] totalSum = sum(vectorA, vectorB);
    	long[] totalMult = mult(vectorA, vectorB);
        
        System.out.println( "(" + vectorA[0] + " , " + vectorA[1] + ") -- (" + vectorB[0] + " , " + vectorB[1] + ")");   
	System.out.println( " Sum = " + totalSum[0] + " -- " + totalSum[1] );
	System.out.println( " Mult = " + totalMult[0] + " -- " + totalMult[1] );
	
    	return totalMult[0]  > totalSum[0] || (totalMult[0] == totalSum[0] && totalMult[1] >= totalSum[1] );
    }
  }
}
