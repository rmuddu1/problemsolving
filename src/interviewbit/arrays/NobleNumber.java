package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NobleNumber {
	public int solve(ArrayList<Integer> A) {
		if (A == null || A.size() == 0) {
			return -1;
		}

		int size = A.size();
		if (A.size() == 1) {
			if (A.get(0) == 0) {
				return 1;
			}
			return -1;
		}

		// Sort
		Collections.sort(A);
		for (int i = 0; i < size; i++) {
			if (A.get(i) != 0) {
				if (((i + 1) < size)
						&& (A.get(i) != A.get(i + 1))
						&& ((A.get(i) > 0 ? A.get(i) : -A.get(i)) == (size - (i + 1)))) {
					return 1;
				}
			} else {
				if (i == (size - 1)) {
					return 1;
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		NobleNumber n = new NobleNumber();
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-4, -2, 0));
		int i = n.solve(A);
		System.out.println(i);
	}
}
