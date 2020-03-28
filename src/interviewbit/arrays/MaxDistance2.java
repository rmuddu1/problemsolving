package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxDistance2 {
	public static void main(String[] args) {
		MaxDistance2 maxDist = new MaxDistance2();
		int result = maxDist.calMaxDistance(new ArrayList<Integer>(Arrays
				.asList(3, 5, 4, 2)));
		System.out.println(result);
	}

	// A = [3 5 4 2]
	public int calMaxDistance(ArrayList<Integer> A) {
		int maxDistance = -1;
		Map<Integer, Integer> numToIndex = new HashMap<>();
		if (A == null || A.size() == 0) {
			return maxDistance;
		}
		int numSize = A.size();
		// O(n)
		for (int i = 0; i < numSize; i++) {
			numToIndex.put(A.get(i), i); // 3-0, 5-1, 4-2, 2-3
		}
		// O(nlogn)
		Collections.sort(A); // [2,3,4,5]
		// O(n)
		for (int i = 1; i < numSize; i++) {
			int indexSum = numToIndex.get(A.get(i))
					- numToIndex.get(A.get(i - 1)); // 0-3, 2-0, 1-2 =>2
			if (indexSum > maxDistance) {
				maxDistance = indexSum;
			}
		}
		return maxDistance;
	}
}
