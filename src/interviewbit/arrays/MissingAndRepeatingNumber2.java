package interviewbit.arrays;

import java.util.*;

public class MissingAndRepeatingNumber2 {
	    // DO NOT MODIFY THE LIST. IT IS READ ONLY
	    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
	        //Using HashMaps
	        int length = A.size();
	        int repeatingNumber = 0;
	        int missingNumber = 0;
	        long sumOfGivenList = 0;
	        long sumOfNNumbers = 0;
	        Map<Integer,Integer> noOccurences = new HashMap<>();
	        for(int i=0;i<length;i++) {
	            if(noOccurences.containsKey(A.get(i))) {
	                repeatingNumber = A.get(i);
	                break;
	            } else {
	                noOccurences.put(A.get(i),1);
	            }
	        }
	        for(int i=0;i<length;i++) {
	            sumOfGivenList+= A.get(i);
	        }
	        for(int i=1;i<=length;i++) {
	            sumOfNNumbers+= i; 
	        }
	        missingNumber = (int) (sumOfNNumbers-(sumOfGivenList-repeatingNumber));
	        return new ArrayList<Integer>(Arrays.asList(repeatingNumber,missingNumber));
	    }
}
