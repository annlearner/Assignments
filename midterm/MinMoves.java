package midterm;

import java.util.Arrays;

public class MinMoves {
	static int[] nums = {1,2,3};
	public static void main(String[] args) {
	System.out.println(minMoves(nums));
	}
	 public static int minMoves(int[] nums) {
	        int sum = 0;
	        Arrays.sort(nums);
	        for(int i = 1; i < nums.length ;i++){
	          sum = sum + (nums[i] - nums[0]);
	        }
	         return sum;
	    }
	}
