package com.java1995;

import java.awt.List;
import java.util.ArrayList;

public class RegistrationSystem {
	private static String name;
	private static int id;
	public static void main(String[] args) {
		Student a = new Student("alice", 3120);
		System.out.println(Course.registerStudent (a));
	}

}
	class Student{
		
		String name;
		int id;
		public Student(String name, int id){
			this.name = name;
			this.id = id;
		}
	}
	
	class Course{
		
		String name; 
		static int numberOfStudent;
		static ArrayList<String> members = new ArrayList<String>();
		static Student a = new Student("alice", 3120); 
		
		static boolean isFull(){
			if(numberOfStudent>10) 
				return true;
			return false;
		}
        
		static ArrayList<String> registerStudent (Student a){
			if(!isFull()){
				members.add(a.name);
			}
			return members;
		}
		static ArrayList<String> getStudents(){
			registerStudent (a);
			return members;
		}
        
	}
	


