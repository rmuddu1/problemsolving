package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveNumber {

	public static void main(String[] args) {
		WaveNumber wn = new WaveNumber();
		ArrayList<Integer> result = wn.wave(new ArrayList<Integer>(Arrays
				.asList(1, 0, 0, 0)));
		System.out.println(result);
	}

	public ArrayList<Integer> wave(ArrayList<Integer> A) {
		int temp = 0;
		int length = 0;
		if (A == null | A.size() == 0) {
			return null;
		}
		length = A.size();
		Collections.sort(A);
		for (int i = 0; i < length; i += 2) {
			if (i + 1 >= length) {
				break;
			}
			temp = A.get(i + 1);
			A.set(i + 1, A.get(i));
			A.set(i, temp);
		}
		return A;
	}
}
