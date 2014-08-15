package codility;

public class Period {
  public static void main(String args[]) {
    Period period = new Period();
    assert period.solution(955) == 4;
    assert period.solution(205) == -1;
    System.out.println("955(" + Integer.toBinaryString(955) + ") ---> " + period.solution(955));
    System.out.println("205:(" + Integer.toBinaryString(205) + ") ---> " + period.solution(205));
  }


  int solution(int number) {
    String word = Integer.toBinaryString(number);
    for( int i = word.length() - 1; i >= 0; i--) {
	int p = findPeriod(word, i);
	if( p != -1 ){
		return p;
	}
    }

    return -1;
  }

  int findPeriod(String word, int index) {
      int wordLength = word.length();	  
      int maxIndex = index * 2;	  
      
      if( wordLength > 0 && index > 0 && index < wordLength && maxIndex < wordLength && maxIndex >= index ) {
        String head = word.substring(0, index);
	String tail = word.substring(index, maxIndex);
        String rest = word.substring(maxIndex, wordLength);

        if(head.equals(tail) && head.contains(rest) ) {
		return index;
	}
      }

      return -1;
  }
}


