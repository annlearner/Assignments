package com.java1995;

import java.util.ArrayList;

/*�ַ����ַ���,array,Arraylist,֮���ת��,
 * char[] star = input.toCharArray();
    Arraylist��ʹ��*/
public class RemoveVowels {
	static String input = "finish";
	static String res;
	public static void main(String[] args){
		removeVowelsFromString(input);	
	}
	
	public static void removeVowelsFromString(String input){
		//��inputת��Ϊ����(char/string)
		char[] star = input.toCharArray();
		ArrayList<Character> bin = new ArrayList<Character>(); 
		//���б���
		for(char p:star){
			if(p != 'a' && p != 'e' && p != 'i' && p != 'o' && p !='u')
				bin.add(p);
			res = bin.toString();
	     }
		System.out.println(res);
	}
	
	}
