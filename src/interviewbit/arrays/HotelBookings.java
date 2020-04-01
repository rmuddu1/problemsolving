package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class HotelBookings {

	public static void main(String[] args) {
		HotelBookings bookings = new HotelBookings();
		boolean result = bookings.hotel(
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)),
				new ArrayList<Integer>(Arrays.asList(10, 2, 6, 14)), 2);
		System.out.println(result);
	}

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart,
			int K) {
		HashMap<Integer, Integer> arriveMap = null;
		HashMap<Integer, Integer> departMap = null;
		int bookingCount = 0;
		int count = 0;
		if (arrive == null || depart == null || arrive.size() == 0
				|| depart.size() == 0 || K == 0) {
			return false;
		}

		arriveMap = new HashMap<>();
		for (int i = 0; i < arrive.size(); i++) {
			if (arriveMap.containsKey(arrive.get(i))) {
				count = arriveMap.get(arrive.get(i)) + 1;
				arriveMap.put(arrive.get(i), count);
			} else {
				arriveMap.put(arrive.get(i), 1);
			}
		}

		departMap = new HashMap<>();
		for (int j = 0; j < depart.size(); j++) {
			if (departMap.containsKey(depart.get(j))) {
				count = departMap.get(depart.get(j)) + 1;
				departMap.put(depart.get(j), count);
			} else {
				departMap.put(depart.get(j), 1);
			}
		}

		arrive.addAll(depart);
		Collections.sort(arrive);
		for (int m = 0; m < arrive.size(); m++) {
			if (arriveMap.containsKey(arrive.get(m))
					&& arriveMap.get(arrive.get(m)) > 0) {
				bookingCount++;
				count = arriveMap.get(arrive.get(m)) - 1;
				arriveMap.put(arrive.get(m), count);
				if ((bookingCount > K)
						&& (!(departMap.containsKey(arrive.get(m))) || ((departMap
								.containsKey(arrive.get(m))) && (departMap
								.get(arrive.get(m)) <= 0)))) {
					return false;
				}
			} else if (departMap.containsKey(arrive.get(m))
					&& departMap.get(arrive.get(m)) > 0) {
				bookingCount--;
				count = departMap.get(arrive.get(m)) - 1;
				departMap.put(arrive.get(m), count);
			}
		}
		return true;
	}
}
