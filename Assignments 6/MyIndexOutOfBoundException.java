package assignment6;

public class MyIndexOutOfBoundException extends Exception{
	static int index;
	int lowerBound;
	int upperBound;
public static void main(String[] args) {
	int index = 10;
	try{
		if(index <= 9 && index >= 0){
	    	  System.out.println(index+",³ÌÐò²»±¨´í");
	       }else{
	    	   throw new MyIndexOutOfBoundException(0, 9, index);
	       }
	       }catch(MyIndexOutOfBoundException e){
	    	   e.printStackTrace();
			
			}
}
    public MyIndexOutOfBoundException(int lowerBound, int upperBound, int index){
    	this.index = index;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
     }

	public String toString() {
		return "Error Message: Index:"+ index +", but Lower bound:" + lowerBound +", Upper bound:" + upperBound;
		}
	 
	}


