package interviewbit.arrays;

import java.util.PriorityQueue;

public class KthLargestNumberUsingMinHeap {
	public static void main(String[] args) {
		int[] nums = {1,15,37,23,41,21,76,98,11,4};
		int k = 5;
		KthLargestNumberUsingMinHeap heap = new KthLargestNumberUsingMinHeap();
		int kLargestNum = heap.findKthLargest(nums, k);
		System.out.println(kLargestNum);
	}
	
	public int findKthLargest(int[] nums, int k) {
	    PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
	    for(int i: nums){
	        q.offer(i);
	 
	        if(q.size()>k){
	            q.poll();
	        }
	    }
	 
	    return q.peek();
	}
}
