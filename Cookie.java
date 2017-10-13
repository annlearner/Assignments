package assignment5;

class Cookie extends DessertItem{
	int number;
	int pricePerDozen;
	int res;
    /**
	 * @param name
	 * @param number
	 * @param pricePerDozen
	 */
	static Cookie cookie =new Cookie("Oatmeal Raisin Cookies", 4, 399);
    public static void main(String[] args) {
    	 System.out.println(cookie.getCost());
    }
	public Cookie(String name, int number, int pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}
	 
	int getCost(){
		double  temp= number*pricePerDozen/12;
		if(temp - (int)temp >= 0.5){
	    	 res =  (int)temp+1;
	     }else{
	    	 res =  (int)temp;
	     }
		return res;	
		
	}
	
}
