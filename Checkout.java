package assignment5;

import java.awt.List;
import java.util.ArrayList;
import java.util.Vector;

public class Checkout{
	
	static ArrayList<DessertItem> list = new ArrayList<DessertItem>();
	public Checkout() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void enterItem(DessertItem N){
		
		list.add(N);
	}
	 double numberOfItems(){
		return list.size();
		
	}
	 public void clear(){
		 list.clear();
	 }
	 static int totalCost(){
		int totalCost = 0;
		for(int i =0; i<list.size();i++){
		totalCost = totalCost+list.get(i).getCost();
		}
		return totalCost;
	}
	static double totalTax(){
		double tax = totalCost()*0.065;
		int res;
		if(tax - (int)tax >= 0.5){
			res =  (int)tax+1;
	     }else{
	    	 res =  (int)tax;
	     }
		return res;	
	}
	public String toString(){
		Vector<String> v1  = new Vector();
		String shopName = "M & M Dessert Shoppe";
		v1.addElement(shopName+"\n");
		for(int i =0; i<list.size();i++){
			v1.addElement(list.get(i).getName()+" "+DessertShoppe.cents2dollarsAndCents(list.get(i).getCost())+"\n");	
		} 
		v1.addElement(("totalTax"+"  "+DessertShoppe.cents2dollarsAndCents((int) totalTax()))+"\n");
		v1.addElement("totalCost"+"  "+DessertShoppe.cents2dollarsAndCents((int) (totalCost()+totalTax())));
		String[] temp = v1.toString().split(",");
		StringBuffer sb = new StringBuffer();
	      for(int i = 0;i<temp.length;i++){
	    	  sb. append(temp[i]);  	  
	}
	      String checkOut = sb.toString();
	      return checkOut;
}
}	
