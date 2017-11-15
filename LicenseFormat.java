package com.java1995;

public class LicenseFormat {
	public static void main(String args[]){
		int k = 4;
		// Should contain '-'
		String s = "1rwtafgh54";
		licenseFormat(s,k);
		}
   public static void licenseFormat(String s,int k){
	   String result = "";
	   String temp ="";
	   int len = s.length();
	   while(len != 0){
		   if(len < k){
			   //len = len + k;
			   System.out.println(len);
			    temp = s.substring(0,len)+temp;
			    len =0;
			    break;
		   }
		   temp ="-"+ s.substring(len-k,len)+temp;
		   System.out.println(temp);
		   len = len - k;
		   System.out.println(len);
		   
	}
	     
		System.out.println(temp);
  }
}
