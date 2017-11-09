package starters;

import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
     static String[] list = {"aaa","star","begin","eeeeeend"};
	 static int random = (int) (Math.random ()*4);//在范围内随机取数
	 static String choice = list[random];
	 static String temp = "";
	 static int num = choice.length();
	 static ArrayList<Character> cho = new ArrayList<Character>();
	 static ArrayList<Integer> index = new ArrayList<Integer>();
	 static int incorrect = 0;
	 static int guess = 0;
	 static int notMatch = 0;
	 static StringBuilder dashes = new StringBuilder();

     public static void main(String args[]){
    	 //打印破折号
    	 for(int i = 0; i<=num-1;i++){
    		 dashes.append("-"); 
    		 temp = dashes.toString();
    	 }
         System.out.println(temp);
       //把做成一个数组，猜中一个在下次的搜寻数组中就减少一个，防止重复出现
  	   for(int i = 0; i<num;i++){
  	   cho.add(choice.toCharArray()[i]); 
  	   }
         //输入猜测字母
	 // How your code handle the invalid input like 12si or ~!j9, maybe you should give some feedback to users
         while(incorrect<8){ 
         System.out.print("please guess the letter: ");
    	 Scanner scan = new Scanner(System.in);
    	 String input = scan.next();
    	//输出结果,小心notMatch的累加错误
    	 notMatch = 0;
    	 guess(input);
    	 if(guess == num)
    		 break;
    	  
    	}
     }
     
     static void guess(String input){
    	
    	 char s =input.charAt(0);
    	 for(int i =0 ;i<num;i++){
    		 if(cho.get(i)==s){
    			index.add(i);
    			guess++;
    		  }else{
    				notMatch++;	 
    		     }
    	 }
	 
	 if(notMatch == num){
	 incorrect ++ ;
	 System.out.println("and your incorrect point is " + incorrect);
	  }else{
		  for(int j =0 ;j<index.size();j++){
		    	dashes.replace(index.get(j), index.get(j)+1, input);
		    	 }
		 
		 System.out.println("currently your win " + guess+ " points");
		 
	 }
	 index.clear();

	 
	 temp = dashes.toString();
	 System.out.println(temp);
     } 
     }

