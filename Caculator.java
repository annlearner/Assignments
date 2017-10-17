package com.java1995;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;
//scan输入类型总结
public class Caculator {
	static double res;
	static String operator1;
	static String operator2;
	static String[] eqa;
	static String res1;
	public static void main(String args[]){
		//Put in numbers
		System.out.print("please enter the number:");
		 try (Scanner scan=new Scanner(System.in)){
			 String[] eqa = {"3","x","^","+","-4","x","+","5"};
		double x = scan.nextDouble();
		res = x;
		//scanner接收运算符
		 operator1 = scan.next();
		double y = scan.nextDouble();
		operator2 = scan.next();
		System.out.println("The answer is: " + Caculator(x,y));
		quadraticEquation(eqa);
	}}
	        // For method, the first character should be lowercase
		public static double Caculator(double res,double y){
		while( operator2.equals("=")){
		switch(operator1){
		case "+":
			res = res + y;
			break;
		case "-":
			res = res - y;
			break;
		case "*":
			res = res * y;
			break;
		case "/":
			res = res / y;
			break;
		case "squreRoot":
			res = Math.sqrt(res);
			break;
		case "cube":
			res = Math.pow(res,3);
			break;
		case"PutfahrenheitGetCelsius":
			res = 32+1.8*res;
			break;
		case"PutCelsiusGetfahrenheit":
			res =(res-32)/1.8;
			break;
		case"PutFeetGetInch":
			res = res*12;
			break;
		case"PutInchGetFeet":
			res = res/12;
			break;
		// Better to have a default case to catch invalid operator
		}
		break;
		}
		return res;
		
		}
	        // You have to return the solutions for ax^2 + bx + c
		public static void quadraticEquation(String eqa[]){
			//将res转化为数组(char/string)
			ArrayList<String> bin = new ArrayList<String>(); 
			//进行遍历
			for(String p:eqa){
				if(p != "x" && p != "^" && p != "+" && p != "-"){
					bin.add(p);
				}
			}
				
		String[] res = (String[])bin.toArray(new String[bin.size()]); 
		for(int i=0;i<bin.size();i++){ 
			System.out.print(res[i]); 
			} 
				
		
	
	}}


