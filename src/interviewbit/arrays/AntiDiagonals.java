package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonals {
	
		public static void main(String[] args) {
			AntiDiagonals antiDiag = new AntiDiagonals();
			ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
			A.add(new ArrayList<>(Arrays.asList(1,2,3)));
			A.add(new ArrayList<>(Arrays.asList(4,5,6)));
			A.add(new ArrayList<>(Arrays.asList(7,8,9)));
			ArrayList<ArrayList<Integer>> result = antiDiag.diagonal(A);
			for(List<Integer> antiDiagonal: result) {
				System.out.println(antiDiagonal);
			}
		}
		 public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		        String direction = null;
		        int top=0;
		        int left=0;
		        int right=0;
		        int bottom=0;
		        int trackPos =0;
		        ArrayList<ArrayList<Integer>> result = null;
		        if(A==null || A.size()==0) {
		            return null;
		        }
		        result = new ArrayList<ArrayList<Integer>>();
		        top=0;
		        bottom = A.size()-1;
		        left=0;
		        right = A.get(0).size()-1;
		        for(int i=1;i<=((A.size()*2)-1);i++) {
		            result.add(new ArrayList<Integer>());
		        }
		        while(top<=bottom && left<=right) {
		            direction="right";
		            ArrayList<Integer> temp = new ArrayList<>();
		            if(direction.equals("right")) {
		                for(int i=left;i<=right;i++) {
		                    temp.add(A.get(top).get(i));
		                }
		            }
		            direction = "bottom";
		            top++;
		            if(direction.equals("bottom")) {
		                for(int i=top;i<=bottom;i++) {
		                    temp.add(A.get(i).get(right));
		                }
		            }
		            right--;
		            trackPos=top-1;
		            for(int i=0;i<temp.size();i++) {
		                result.get(trackPos).add(temp.get(i));
		                trackPos++;
		            }
		        }
		        return result;
		    }
}
