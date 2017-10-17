package com.java1995;

import java.util.ArrayList;

/*字符，字符串,array,Arraylist,之间的转化,
 * char[] star = input.toCharArray();
    Arraylist的使用*/
public class RemoveVowels {
	static String input = "finish";
	static String res;
	public static void main(String[] args){
		removeVowelsFromString(input);	
	}
	
	public static void removeVowelsFromString(String input){
		//将input转化为数组(char/string)
		char[] star = input.toCharArray();
		ArrayList<Character> bin = new ArrayList<Character>(); 
		//进行遍历
		for(char p:star){
			// Consider upper case vowel AEIOU
			if(p != 'a' && p != 'e' && p != 'i' && p != 'o' && p !='u')
				bin.add(p);
			res = bin.toString();
	     }
		System.out.println(res);
	}
	
	}
