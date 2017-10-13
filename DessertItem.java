package assignment5;

public abstract class DessertItem{
	/**
	 * @param name
	 */
	public DessertItem(String name) {
		super();
		this.name = name;
	}
	String name;

	public String getName(){
		return name;
	}
	abstract int getCost();
    
    
	
}
