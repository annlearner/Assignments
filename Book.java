package com.java1995;

public class Book {
	
	int size;
	int price;
	// Why?
	//String name should be initialized first.
	String name;
	/**
	 * @param size
	 */
	//
	public Book(int size) {
		this.size = size;
		
	}
	/**
	 * @param price
	 */
	//the constructor only can take one "size" OR "price",so the constructor above and below are conflicting.
	public Book(int price) {
		this.price = price;
	}
	/**
	 * @param size
	 * @param price
	 * @param name
	 */
	public Book(int size, int price, String name) {
		super();
		this.size = size;
		this.price = price;
		this.name = name;
	}
	
	
	
	// line35 is wrong. If it is a constructor, the name of it should be the name of class,and there should be no "return/void".
	//  If it is a method, it should be clarified the return type after"public" (such as "String" here).
	public setName(String name){
		return name;
	}
	}
