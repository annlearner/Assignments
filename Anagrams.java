package com.java1995;

import java.util.Arrays;

public class Anagrams {
	public static String S1 = "finish";
	public static String S2 = "inishf";
	public static int pos = 1;
	public static void main(String[] args){
		System.out.print(checkIfTwoStringsAreAnagrams(S1,S2));	
	}
	public static boolean  checkIfTwoStringsAreAnagrams(String S1,String S2){
		//string to arrayList
		if(S1 == null ||S2 == null )
			return false;
		String[] S11 = S1.toLowerCase().split(",");
		String[] S22 = S2.toLowerCase().split(",");
		if(S11.length ==S22.length){
		   Arrays.sort(S11);
		   System.out.print(S11);
		   Arrays.sort(S22);
		   System.out.print(S22);
		   String res1 = String.valueOf(S11);
	        String res2 = String.valueOf(S22);
		        if(res1.equals(res2)){
			      return true;
		        }
		}
	return false;
	}
		
		
		}
	


