package assginment7;

public class MaxValue extends Thread{

	private int lo, hi;
    private int[] arr;
    private int ans = Integer.MIN_VALUE;
	
    public MaxValue(int[] arr, int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
        this.arr = arr;
    }
	 public void run(){
		 for (int i = lo; i < hi; i++) {
	            if(ans < arr[i]){
	            	ans = arr[i];
	            }
	            	
	        }
	   
	 }
	 
	 public static int sort(int[] arr) throws InterruptedException {
		    int len = arr.length;
	        int ans = Integer.MIN_VALUE;
	        
	        // Create and start 4 threads.
	        MaxValue[] mx = new MaxValue[4];
	        for (int i = 0; i < 4; i++) {
	        	mx[i] = new MaxValue(arr, (i * len) / 4, ((i + 1) * len / 4));
	        	mx[i].start();
	        }
	        for (int i = 0; i < 4; i++) {
	            mx[i].join();//start if each of the thread end
	            if(mx[i].ans > ans){
	            ans = mx[i].ans;
	            }
	        }
	        
	        return ans;
	    }
//finds the maximum value in an array of  using 4 threads
	 
	 public static void main(String[] args) throws InterruptedException {
	        int[] arr = new int[20];
	        System.out.println("orignal array: ");
	        for (int i = 0; i < arr.length; i++) {
	            arr[i] = (int)(Math.random()*20) + 1;
	            System.out.println(arr[i]);
	        }
	        
	         int res = sort(arr);
	         System.out.println("The max value in the array are : " + res); 
	         
	    }
}
