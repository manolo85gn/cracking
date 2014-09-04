package codility;

public class Pid {
 
  public static void main(String[] args) {
    Pid p = new Pid();
    int result1 = p.solution( new int[]{ 0, 1, 3, -2, 0, 1, 0, -3, 2, 3 });
    int result2 = p.solution( new int[]{ 0 } );
    int result3 = p.solution( new int[]{ -5, 0 } );
    int result4 = p.solution( new int[]{ -5, -1, -3 } );
    int result5 = p.solution( new int[]{ -5, -1, -3, -5, 0 } );
   
    int arr6Length = 210000;
    int[] arr6 = new int[arr6Length];
    java.util.Random r = new java.util.Random();

    for( int i = 0; i < arr6.length; i++){
      arr6[i] = r.nextInt(100000000);
    }
    int result6 = p.solution(arr6);

    System.out.println(">>>> Result: " + result1);
    System.out.println(">>>> Result: " + result2);
    System.out.println(">>>> Result: " + result3);
    System.out.println(">>>> Result: " + result4);
    System.out.println(">>>> Result: " + result5);
    System.out.println(">>>> Result: " + result6);
  }

  int solution(int[] A) {
    if( A != null && A.length >= 3){	  
      return solutionAux(A, 0, -1);  
    }

    return -1;
  }

  int solutionAux(int[] A, int start, int depth) {
    	  
    int indexP = findPosibleP(A, start);
    int indexQ = findPosibleQ(A, indexP);
    int indexR = indexQ + 1;
    while( indexR < A.length && A[indexR] > A[indexR - 1 ] ){
        int depthTmp = calculateDepth(A[indexP], A[indexQ], A[indexR] );
        if( depthTmp > depth ) {
          depth = depthTmp;
        }
        //System.out.println( "(" + indexP + " , " + indexQ + " , " + indexR + ") --> " + calculateDepth(A[indexP], A[indexQ], A[indexR]) );
        indexR++;
    }
    
    if( indexQ < A.length -2 ){
        return solutionAux(A, indexQ, depth);
    } 

    return depth;
  }

  int findPosibleP(int[] A, int start){
    //System.out.println(">>>> Start: " + start);	  
    //int i = start;	  
    
    while( start < (A.length -2) && A[start+1] > A[start] ){
      start++;
    }

    return start;
  }

  int findPosibleQ(int[] A, int start) {
    start += 1;
    while( start < (A.length -1) && A[start+1] < A[start] ) {
      start++;   
    }
    return start;
  }
   

  int calculateDepth(int p, int q, int r) {
    int result = 0;	  
    int sum1 = p - q;
    int sum2 = r - q;
    if ( sum1 < sum2 )
	result = sum1;
    else
	result = sum2;    

    return result;
  }
}
