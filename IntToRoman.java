package com.java1995;

public class IntToRoman {
	public static void main(String args[]){
		int num=1500;
		System.out.println(intToRoman(num));
		
	}
	
	 public static String intToRoman(int num) {
	        StringBuilder sb = new StringBuilder();
	        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	        String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	        for(int i=0;i<value.length;i++){
	          while(num >= value[i]){
	             sb.append(rom[i]);
	              num-=value[i];
	          }
	        }return sb.toString();
	        
	    }
}
