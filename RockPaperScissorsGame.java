package com.java1995;

public class RockPaperScissorsGame {
	public static void main(String args[]){

		Scissors s = new Scissors(5);
	       
		Paper p = new Paper(7);

		Rock r = new Rock(15);

		System.out.println(s.fight(p) + " , "+ p.fight(s) );

		System.out.println(p.fight(r) + " , "+ r.fight(p) );

		System.out.println(r.fight(s) + " , "+ s.fight(r) );

		}
}

class Tool {
	
	protected int strength;
	protected char type;
	
	public void setStrength(int x){
		this.strength = x;
	}
	
	static int compare = 0;
	boolean res;
	static int str=0;
	
	public boolean fight(Tool x){
	  return compare>str?true:false;
		 }
}

/*

Implement class Scissors
*/
      class Scissors extends Tool {

/**
 * @param strength
 */
      public Scissors(int str) {
	     super();
	     type = 'p';
	    strength = str;
       }

      boolean fight(Paper p) {
	// TODO Auto-generated method stub
	 compare =  strength*2;
	 str = p.strength;
	return compare>=str?true:false;
       }
      boolean fight(Rock r) {
	// TODO Auto-generated method stub
	 compare = strength;
	 str = r.strength;
	return compare>=str?true:false;
       }
     }
      /*

  	Implement class Paper

  	*/
    class Paper extends Tool {
  	/**
  	 * @param strength
  	 */
  	
  	public Paper(int str) {
  		super();
  		type = 'p';
  		strength=str;
  	}
  	
  	boolean fight(Scissors s) {
  		// TODO Auto-generated method stub
  		 compare = strength/2;
  		 str = s.strength;
  		return compare>=str?true:false;
  	}
  	boolean fight(Rock r) {
  		// TODO Auto-generated method stub
  		 compare = strength*2;
  		 str = r.strength;
  		return compare>=str?true:false;
  	}
  }	
    
    /*

	Implement class Rock

	*/
   class Rock extends Tool {
	/**
	 * @param strength
	 */
	public Rock(int str) {
		super();
		type = 'r';
		strength=str;
	}
	
	public boolean fight(Paper p){
		compare = strength/2;
	    str = p.strength;
    return compare>=str?true:false;
			}
     public boolean fight(Scissors s){
    	   compare = 2*strength;
			 str = s.strength;	 
       return compare>=str?true:false; 
		 }
		
   }
