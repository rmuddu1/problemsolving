package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxNonNegativeSubArray {
	
		public static void main(String[] args) {
			MaxNonNegativeSubArray sub = new MaxNonNegativeSubArray();
			ArrayList<Integer> result = sub.maxset(new ArrayList<Integer>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368)));
			if(result !=null && result.size()>0) {
				for (int i=0;i<result.size();i++) {
					System.out.println(result.get(i));
				}
			}
		}
		
	    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
	        int startIndexFinal =0;
	        int endIndexFinal = 0;
	        int subArrayLengthFinal = 0;
	        int currentStartIndex = 0;
	        int currentIncrement = 0;
	        double maxSum=0;
	        double curSum =0;
	        int length = 0;
	        if(A==null || A.size()==0) {
	            return null;
	        }
	        length = A.size();
	        for(int i=0;i<length;i++) {
	            if(A.get(i)>=0) {
	                currentIncrement++;
	                if(currentIncrement ==1) {
	                    currentStartIndex =i;
	                }
	                curSum+=A.get(i);
	                if( (((i+1)<length) && A.get(i+1)<0) || (i==(length-1)) ) {
	                    if(curSum>maxSum) {
	                        maxSum=curSum;
	                        startIndexFinal = currentStartIndex;
	                        endIndexFinal = i;
	                        subArrayLengthFinal = currentIncrement;
	                    } else if( (curSum==maxSum) && (currentIncrement>subArrayLengthFinal)) {
	                        startIndexFinal = currentStartIndex;
	                        endIndexFinal = i;
	                        subArrayLengthFinal = currentIncrement;
	                    }
	                    curSum = 0;
	                    currentStartIndex = 0;
	                    currentIncrement = 0;
	                }
	            }
	        }
	        if(A.get(startIndexFinal)<0) {
	        	return new ArrayList<Integer>(0);
	        }
	        return new ArrayList<Integer>(A.subList(startIndexFinal,endIndexFinal+1));
	    }
}
