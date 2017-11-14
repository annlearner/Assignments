package assginment7;

   public class ReverseHello {
//structure your program such that the threads print their greetings in reverse order
	   public static void main(String[] args) throws InterruptedException {
		   thread1 nt = new thread1(1);
		    nt.start();
		  
	    }
}
   class thread1 extends Thread{
    	static int n = 1;
        static String print = "Hello from Thread";
    	public thread1(int n){
    		this.n = n;
    	}
    	public void run(){
    		 if(n <= 50){
    			 System.out.println(print + (51 - n));
    	    		thread1 thread2 = new thread1(++n);
    				thread2.start();
				}	
    		}
    		}
    	
		
		
   

