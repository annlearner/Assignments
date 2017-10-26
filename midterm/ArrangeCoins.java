package midterm;

public class ArrangeCoins {
	static int count = 0;
	public static void main(String[] args){
		int n = 2;
		System.out.print("the result is "+arrangeCoins(n));
		}
	 public static int arrangeCoins(int n) {
		        if(n == 0 || n == 1){
		            return n;
		        }
		        int res = 0;
		        // When  sum = (1 + x)*x/2 <= n, x is the res below;
		        double x = (Math.sqrt(8.0*n + 1) - 1) / 2;
		        res = (int)x;
		        return res;
			  
		   }
   }

