package assignment5;

public class Sundae extends IceCream{
	
	String topName;
	int topPrice;
	static int res = 0;
    static Sundae sundae =new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50);
    public static void main(String[] args) {
    	 System.out.println(sundae.getCost());
    }
	/**
	 * @param name
	 * @param cost
	 * @param topName
	 * @param topPrice
	 */
	public Sundae(String name, int cost, String topName, int topPrice) {
		super(name, cost);
		this.topName = topName;
		this.topPrice = topPrice;
	}
	int getCost(){
		int res= topPrice + cost ;
		return res;
	}
}
