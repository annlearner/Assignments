package assginment7;

import java.util.ArrayList;
import java.util.List;

public class PrintPascalTriangle {
	int line;
	public PrintPascalTriangle(int line){
		this.line = line;
	}
	
	public static void main(String[] args) {
		printPascalTriangle(7);
	}
 public static void printPascalTriangle(int line){
	 List<List<Integer>> res = new ArrayList<List<Integer>>();
     
	 if(line <= 0){
		 return;
	 }
	 for(int i = 0; i < line; i++){
		
			 List<Integer> list = new ArrayList<Integer>();
			 if(i == 0){
				 list.add(1);
				 res.add(list);
			 }else if(i == 1){
				 list.add(1);
				 list.add(1);
				 res.add(list);
			 }else{
			  for(int j = 0; j <= i;j++){
			       if(j == 0 || j == i){
				      list.add(1);
			       }else{
				      list.add(res.get(i - 1).get(j-1) + res.get(i - 1).get(j)); 
			       }
				 }
			 res.add(list); 
		 }
	 }
	 for(int i = 0; i < line; i++){
			 System.out.println(res.get(i));
		 }
 }
}
