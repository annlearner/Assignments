package assignment5;

public class Candy extends DessertItem{
	double weight;
    int pricePerPound;
    static int res = 0;
    static Candy candy =new Candy("Peanut Butter Fudge", 2.25, 399);
    public static void main(String[] args) {
    	 System.out.println(candy.getCost());
    }
	/**
	 * @param name
	 * @param weight
	 * @param pricePerPound
	 */
	public Candy(String name, double weight, int pricePerPound) {
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}
	
    
    int getCost(){
	     double temp = 0;
	     temp = weight*pricePerPound;
	     if(temp - (int)temp >= 0.5){
	    	 res =  (int)temp+1;
	     }else{
	    	 res =  (int)temp;
	     }
		return res;	
	}
   
	
	}

