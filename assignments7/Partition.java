package assginment7;

public class Partition {
	static int[] arr = {1, 5, 11, 5};
	public static void main(String[] args) {
		System.out.print(partition(arr));
	}
	
	public static boolean partition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum % 2) != 0) return false;
        sum = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
       dp[0][0] = true;
        for(int i = 1 ;i <= n ; i++){
            dp[i][0] = true;
        }
        for(int i = 1 ; i <= sum; i++){
            dp[0][i] = false;
        }
         for(int i = 1 ;i <= n ; i++){
             for(int j = 1 ; j <= sum; j++){
                dp[i][j] = dp[i - 1][j];
                    if(j >= nums [i - 1]){
                        dp[i][j] = dp[i][j] || dp[i - 1][j -nums [i - 1] ];
                    }
        }
         }
        return dp[n][sum];
    }
}
