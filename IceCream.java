package assignment5;

public class IceCream extends DessertItem{
	 
	int cost;
	static int res = 0;
    static IceCream iceCream =new IceCream("Vanilla Ice Cream", 105);
    public static void main(String[] args) {
    	 System.out.println(iceCream.getCost());
    }

	/**
	 * @param name
	 * @param cost
	 */
	public IceCream(String name, int cost) {
		super(name);
		this.cost = cost;
	}
  int getCost(){
	 return cost;
 }
	
}
