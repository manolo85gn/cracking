package codility;

public  class Slice {

        public static void main(String[] args){
	  Slice s = new Slice();
	  int result = s.solution( new int[]{2, -4, 6, -3, 9});
	  System.out.println("Result: " + result);
	}

	int solution(int[] A) {	
          int currentSlide = -1;
          int totalSumAux = sumArr(A, 0, A.length -1);
	  for( int i = 0; i < A.length; i++ ) {
	    int totalSum = 0;	  
	    if( i == 0 ) {
	      totalSum = totalSumAux;
	    } else {
	      totalSumAux -= A[i - 1];	    
	      totalSum = totalSumAux;
	    }	  
	    //int totalSum = i == 0 ? totalSum : (totalSumAux - A[ i - 1]);
	    int moduleAux = module(totalSum);
	    currentSlide = currentSlide != -1 && currentSlide < moduleAux ? currentSlide : moduleAux;
	    System.out.println("First slice: " + moduleAux);
	    for(int j = A.length - 1; j > i; j--){
	      totalSum =  i == (j - 1) ? A[i]: (totalSum - A[j]);
	      int slice = module(totalSum);
	      if( currentSlide > slice ){
		  currentSlide = slice;
	      }

	      if(currentSlide == 0){
	        return 0;
	      }

	      System.out.println( "Current Slide: " + slice + " -- (" + i + " , " + (j - 1 ) + ")");
	    }
	  }

	  return currentSlide;
	}

	int module(int a){ 
	   if( a < 0){
	     return -a;
	   } else {
             return a;		   
	   }

	}

	int sumArr(int[] A, int from, int to){
	  int total = 0;
	  for( int i = from; i <= to; i++){
	    total += A[i];
	  }
	  return total;
	}


}
