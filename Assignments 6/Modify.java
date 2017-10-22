package assignment6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Modify {
	static File file;
	 public static void main(String[] args) throws Exception {
		 
		parse(file);
	        }
	 public static void parse(File file){
	      RandomAccessFile input = null;
	      String line = null;
	      
	      try {
	          input = new RandomAccessFile(file, "r");
	          while ((line = input.readLine()) != null) {
	              System.out.println(line);
	          }
	     }catch(Exception e){
	    	 System.out.println("Exception exist");
	    	 return;
	      } finally {
	            if (input != null) {
	              try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	        }
	  }  

}
