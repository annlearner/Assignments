package assignment6;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Atm {
	double availableAmountInMachine;
	double transactionFee;
	//String in HashMap is the bankAccount
	static HashMap<String,Userdata> map = new  HashMap<String,Userdata>();
	static int i = 0;
	
	static double base = 0;
	static ArrayList<String>Trans = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception{
		Atm atm = new Atm(2, 0.04,new  HashMap<String,Userdata>());
		ArrayList<String> source = BufferedInputFile.read("E:/Eclipse/Assignment6/src/assignment6/testSource");
		for(String s : source){
            String[] temp = s.split(",");
            int availableAmountInMachine = Integer.parseInt(temp[0]);
            Double transactionFee = Double.parseDouble(temp[1]);
            
            String name = temp[2];
            int age = Integer.parseInt(temp[3]);
            String address = temp [4];
            String phoneNumber = temp[5];
            String bankAccountNumber = temp[6];
            String password = temp[7];
            Double avaliableBalance = Double.parseDouble(temp[8]);
           
            User user = new User(name,age, address,phoneNumber,bankAccountNumber);
    		Userdata p1 = new Userdata(user,password,avaliableBalance);
            atm.map.put(bankAccountNumber,p1);
            atm.availableAmountInMachine = availableAmountInMachine;
            atm.transactionFee = transactionFee;
        } 
		System.out.println("currently atm has "+atm.map.size()+" customers");
		entrance();
	}
	
	static void entrance() {
		System.out.println("If you are a new user, please type \"yes\". Or please type \"no\":");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		//this is used to test the current user situation
		User ben = new User("ben", 27, "26 southeast", "437-323-2356", "2563 5786 1523 5787");
		Userdata p2 = new Userdata(ben,"012345",500);
		map.put("2563 5786 1523 5787", p2);
		
		if(input.equals("yes")){
			createAccount();
		}else{
			login();
		}
	}
	static void createAccount(){
		System.out.println("please enter your bankAccountNumber:");
		Scanner scan0 = new Scanner(System.in);
		String input = scan0.nextLine();
		
		System.out.println("please enter your name:");
		Scanner scan1 = new Scanner(System.in);
		String input1 = scan1.nextLine();
		
		System.out.println("please enter your age:");
		Scanner scan2 = new Scanner(System.in);
		int input2 = scan2.nextInt();
		
		System.out.println("please enter your address:");
		Scanner scan3 = new Scanner(System.in);
		String input3 = scan3.nextLine();
		
		System.out.println("please enter your phoneNumber:");
		Scanner scan4 = new Scanner(System.in);
		String input4 = scan4.nextLine();
	
		System.out.println("please set your password(six number in total)");
		Scanner scan = new Scanner(System.in);
		String input5 = scan.nextLine();
		
		System.out.println("how much is your base fund in your account");
		Scanner scan5 = new Scanner(System.in);
		base = scan5.nextDouble();
		
		User user = new User(input1,input2, input3,input4,input);
		Userdata p1 = new Userdata(user,input5,base);
		map.put(input, p1);

		login();
	}
	static void login() {
		System.out.println("welcome to the login page!");
		System.out.println("please type your AccountNumber");
		Scanner scan3 = new Scanner(System.in);
		String AccountNumber = scan3.nextLine();
		System.out.println("please type your password");
		Scanner scan4 = new Scanner(System.in);
		String password = scan4.nextLine();
		if(map.containsKey(AccountNumber)){
				if(map.get(AccountNumber).password.equals(password) ){
					successfullyLoging();
					return;
				}
				    System.out.println("password is incorrect");
			}
			System.out.println("AccountNumber is not found");
			System.out.println("If you forget your password, please enter 1604");
			Scanner scan = new Scanner(System.in);
			int code = scan.nextInt();
			if(code == 1604){
				resettedPassword();
			}
		}
		
	
	static void successfullyLoging() {
		System.out.println("please type the number of function:1.deposit;2.withdraw;3.recentTransactions();4.availableBalance;5.EXIT");
		Scanner scan = new Scanner(System.in);
		int choose = scan.nextInt();
			switch(choose){
			case 1:
		System.out.println("please tell me how much you want to put in");
			Scanner scan1 = new Scanner(System.in);
			double input = scan1.nextDouble();
				deposit(input);
				successfullyLoging();
				break;
			case 2:
		System.out.println("please tell me how much you want to withdraw");
		   Scanner scan2 = new Scanner(System.in);
			double take = scan2.nextDouble();
				withdraw(take);
				successfullyLoging();
				break;
			case 3:
				recentTransactions();
				successfullyLoging();
				break;
			case 4:
				availableBalance();
				successfullyLoging();
				break;
			case 5:
				resettedPassword();
				break;
			case 6:
				System.out.println("Bye! Have a good day");
				entrance();
				break;
		}
		
	}
	 static void availableBalance(){
		 System.out.println(base);
	}
	
	static void deposit(double put) {
		
		Trans.add("deposit +" + put);
		i++;
		base = put + base - transactionFee(put);
		System.out.println("currently you have " + base + " in you account");
		
	}
	private static double transactionFee(double count) {
		double res = 0.03*count;
		return res;
	}
	private static void withdraw(double take) {
		if(take > base){
			try{
				throw new Exception();
			}catch(Exception e){
				System.out.print("Sorry, you can not withdrawal more amount than your available Balance ");
			}
		}else{
			Trans.add("withDrawal +" + take);
			i++;
			base = base - take - transactionFee(base);
			System.out.println("currently you have" + base + "in you account");
			
		}
	
		
	}
	/**
	 * @param availableAmountInMachine
	 * @param transactionFee
	 * @param map
	 */
	static void recentTransactions(){
		if(i>=0 && i<10){
			System.out.println(Trans);
		}else{
			for(int j = i;j >= 0; j--){
				System.out.println(Trans.get(j));
			}
		}
		
	}
	static void resettedPassword(){
		
		System.out.println("please enter your name:");
		Scanner scan1 = new Scanner(System.in);
		String name = scan1.nextLine();
		
		System.out.println("please enter your age:");
		Scanner scan2 = new Scanner(System.in);
		int age = scan2.nextInt();
		
		System.out.println("please enter your address:");
		Scanner scan3 = new Scanner(System.in);
		String address = scan3.nextLine();
		
		System.out.println("please enter your phoneNumber:");
		Scanner scan4 = new Scanner(System.in);
		String phoneNumber = scan4.nextLine();
	
		System.out.println("please enter your bankAccountNumber:");
		Scanner scan0 = new Scanner(System.in);
		String input = scan0.nextLine();
		
		if(map.containsKey(input)){
			if(map.get(input).user.name.equals(name) && map.get(address).user.name.equals(address) && map.get(phoneNumber).user.name.equals(phoneNumber) && map.get(address).user.age == age){
				System.out.println("please resset your password (6 numbers in total)");
				Scanner scan10 = new Scanner(System.in);
				map.get(input).password = scan10.nextLine();
				return;
			}
			    System.out.println("password is incorrect");
		}
		
		
	}
	
	public Atm(int availableAmountInMachine, double transactionFee,HashMap<String,Userdata> map){
		this.availableAmountInMachine = availableAmountInMachine;
		this.transactionFee = transactionFee;
		this.map = map;
	}

}
