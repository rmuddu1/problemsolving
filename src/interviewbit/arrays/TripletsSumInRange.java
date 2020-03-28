package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TripletsSumInRange {

	public int solve(ArrayList<String> A) {

		if (A == null || A.size() < 3) {
			return 0;
		}
		Collections.sort(A); // O(logn)
		int size = A.size();
		int endIndex = size - 1;
		for (int i = 0; i < size; i++) {
			if (Double.parseDouble(A.get(i)) >= 2.0) {
				endIndex = i - 1;
				break;
			}
		}
		int startIndex = 0;
		int middleIndex = endIndex - 1;
		Double sum = null;
		while (startIndex < middleIndex && middleIndex < endIndex) {
			sum = Double.parseDouble(A.get(startIndex))
					+ Double.parseDouble(A.get(middleIndex))
					+ Double.parseDouble(A.get(endIndex));
			if (sum >= 2) {
				if ((middleIndex - 1) == startIndex) {
					endIndex--;
				} else {
					middleIndex--;
				}

			} else if (sum <= 1) {
				if ((startIndex + 1) == middleIndex) {
					startIndex++;
					middleIndex++;
				} else {
					startIndex++;
				}
			} else {
				return 1;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		TripletsSumInRange tpr = new TripletsSumInRange();
		int result = tpr.solve(new ArrayList<String>(Arrays.asList("0.6",
				"0.7", "0.8", "1.2", "0.4")));
		System.out.println(result);
	}
}
