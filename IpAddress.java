package com.java1995;

public class IpAddress {
	static int res = 0;
	String ip = "";
	public IpAddress(String ip) {
		this.ip = ip;
		// TODO Auto-generated constructor stub
		
		
	}
	
	
	public static void main(String args[]){

		IpAddress ip = new IpAddress("216.27.6.136");
	
		System.out.println(ip.getDottedDecimal()); 
		System.out.println(ip.getOctet(4));
		System.out.println(ip.getOctet(1)); 
		System.out.println(ip.getOctet(3)); 
		System.out.println(ip.getOctet(2));

		}
	public String getDottedDecimal(){
		return ip;
		
	}
      public int getOctet(int x){
		String[] list = ip.split("\\.");
		   res = Integer.valueOf(list[x-1]);
		   return res;
	}


}
