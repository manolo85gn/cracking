package codility;

public class LargestSlice {

  public static void main(String[] args) {
    LargestSlice ls = new LargestSlice();
    int result1 = ls.solution( new int[]{ 1, 0, -1, 1, -1, 1, -1}, 2);
    //int result2 = ls.solution( new int[]{ 1, 0, -1, 1, 1, -1, -1} , 5);
  //  int result3 = ls.solution( new int[]{ } , 0);
    //int result4 = ls.solution( new int[]{ 1 } , 1);
    //int result5 = ls.solution( new int[]{ 1 } , 2);
    //int result6 = ls.solution( new int[]{ 1, 0 } , 1);
    //int result7 = ls.solution( new int[]{ 1, 0 } , 2);
    

    System.out.println("Largest Slide1: " + result1);
    //System.out.println("Largest Slide2: " + result2);
    //System.out.println("Largest Slide3: " + result3);
    //System.out.println("Largest Slide4: " + result4);
    //System.out.println("Largest Slide5: " + result5);
    //System.out.println("Largest Slide6: " + result6);
    //System.out.println("Largest Slide6: " + result7);


    int[] arr8 = new int[100000];
    for(int i = 0; i < arr8.length; i++) {
	    arr8[i] = 1;
    }

    //int result8 = ls.solution(arr8, 1);
    //System.out.println("Largest Slice8 " + result8);
    

  }	

  public int solution(int[] A, int S) {
   
   if(S > A.length ) return -1;	  
	  
   int result = -1; 
   int x = 0;
   int y = A.length;
   while( y > 0 ){
     System.out.println("y: " + y);
     if( S > y) return -1;

     if( isFound(A, x, y, S) ){
       return y;
     }
     y--;
   }	  

    return result;
  }

  boolean isFound(int[] A, int x, int y, int S) {
    int totalSum = sumArr(A, x, y);
    System.out.println( "(" + x + " , " + (y-1) + ") --> " + totalSum);
    if( S == totalSum ){
      return true;
    } else if ( y == A.length ){
      return false;
    } else {
      return isFound(A, x + 1, y + 1, S);
    }
  
  }
  
  int sumArr(int[] A, int from, int to){
    int total = 0;
    for( int i = from; i < to; i++ ){
      total += A[i];
    }
    return total;
  }
}
