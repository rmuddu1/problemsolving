package interviewbit.arrays;

import java.util.HashMap;
import java.util.Map;

public class Flip {
	public static void main(String[] args) {
//		Flip flip = new Flip();
//		int[] result = flip.flipTwoDigitsInBinaryNum("010");
//		if(result !=null && result.length>0) {
//			System.out.println(result[0] + " " + result[1]);
//		}
		Map<String,String> nums = new HashMap<>();
		nums.put("1", "Hi");
		System.out.println(nums.get("2"));
		System.out.println(nums.get("1"));
	}
	
	public int[] flipTwoDigitsInBinaryNum(String binaryNum) {
		if(binaryNum == null || binaryNum.length()==0) {
			return new int[0];
		}
		int lenOfBinary = binaryNum.length();
		int countOfZeros =0;
		int countOfOnes=0;
		for(int i=0;i<lenOfBinary;i++) {
			if(binaryNum.charAt(i)=='1') {
				countOfOnes++;
			} else if(binaryNum.charAt(i)=='0'){
				countOfZeros++;
			} else {
				return new int[0];
			}
		}
		int[] zeroPositions = null;
		if(countOfOnes==lenOfBinary || countOfZeros==0) {
			return new int[0];
		} else if( countOfZeros==1 && lenOfBinary==1) {
				return new int[]{1,1};
		} else if(countOfZeros>1) {
			zeroPositions = new int[countOfZeros];
			int k=0;
			for(int i=0;i<lenOfBinary;i++) {
				if(binaryNum.charAt(i)=='0') {
					zeroPositions[k] = i;
					k++;
				}
			}
		}
		
		return new int[]{zeroPositions[0],zeroPositions[1]};
	}
}
