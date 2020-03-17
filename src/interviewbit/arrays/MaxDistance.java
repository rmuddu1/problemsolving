package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxDistance {
	public static void main(String[] args) {
		MaxDistance maxDist = new MaxDistance();
		int result = maxDist.calMaxDistance(new ArrayList<Integer>(Arrays.asList(3,5,4,2)));
		System.out.println(result);
	}
	//A = [3 5 4 2]
	public int calMaxDistance(ArrayList<Integer> A) {
		int maxDistance=-1;
		int pair1 = 0;
		int pair2 = 0;
		int size = 0;
		if(A==null || size ==0) {
			return maxDistance;
		}
		size = A.size();
		for(int i=0; i<size-1;i++) {
			for(int j=i+1; j<size;j++) {
				if(A.get(j)>=A.get(i)) {
					if((j-i)>maxDistance) {
						maxDistance = j-i;
						pair1=A.get(i);
						pair2=A.get(j);
					}
				}
			}
		}
		System.out.println("pair: (" + pair1 + "," + pair2 + ")");
		return maxDistance;
	}
}