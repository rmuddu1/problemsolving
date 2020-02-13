package interviewbit.arrays;

import java.util.ArrayList;
import java.util.List;

public class MissingAndRepeatingNumber {
	    // DO NOT MODIFY THE LIST
	    public ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        long length = a.size();
	        long sum = ((length)*(length+1))/2;
	        long sumOfSquares = ((length)*(length+1)*((2*length)+1))/6;
	        long actualSum = 0;
	        long actualSumOfSquares = 0;
	        long k1=0;
	        long k2=0;
	        long k3 = 0;
	        for(int i=0;i<a.size();i++) {
	            actualSum = actualSum + a.get(i);
	            actualSumOfSquares = actualSumOfSquares + (long)Math.pow(a.get(i), 2);
	        }
	        
	        k1= actualSum-sum; //actualSum = sum - repeatedNo + missingNo, k1 = x-y
	        k2 = actualSumOfSquares-sumOfSquares; //,  k2 = x2-y2
	        k3 = k2/k1; // k3 = x+y
	        list.add((int)(k3+k1)/2);
	        list.add((int)(k3-k1)/2);
	        return list;
	        
	    }

}
