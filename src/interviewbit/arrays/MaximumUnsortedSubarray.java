package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaximumUnsortedSubarray {
	public static void main(String[] args) {
		MaximumUnsortedSubarray mx = new MaximumUnsortedSubarray();
		ArrayList<Integer> result = mx.subUnsort(new ArrayList<>(Arrays.asList(1,3,2,4,5,9,5,6,7,9,10,8)));
		for(int i=0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
	}
	
	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        int length = 0;
        boolean isSorted = true;
        int endIndex=0;
        int startIndex=0;
        int max=0;
        int minAfterStart=0;
        int flag=0;
        if(A==null || A.size()==0) {
            return new ArrayList<Integer>(0);
        }
        length = A.size();
        max=A.get(0);
        for(int i=length-1;i>0;i--) {
            if(A.get(i)<A.get(i-1)) {
                isSorted = false;
                break;
            }
        }
        if(isSorted) {
            return new ArrayList<Integer>(Arrays.asList(-1));
        }
        for(int i=1;i<length;i++) {
            if(max<A.get(i)) {
                max=A.get(i);
            }
            if(A.get(i)<A.get(i-1) || A.get(i)<max) {
                if(flag==0) {
                    minAfterStart = A.get(i);
                }
                else if(minAfterStart>A.get(i)) {
                    minAfterStart = A.get(i);
                }
                endIndex =i;
                flag++;
            }
        }
        for(int i=0;i<length;i++) {
            if(A.get(i)>minAfterStart) {
                startIndex = i;
                break;
            } else if(A.get(i)==minAfterStart) {
                if((i+1)<length && !(A.get(i+1)==minAfterStart)) {
                    startIndex =i+1;
                    break;
                }
            }
        }
        return new ArrayList<Integer>(Arrays.asList(startIndex,endIndex));
    }
}
