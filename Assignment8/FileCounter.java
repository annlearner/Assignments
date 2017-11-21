package assignment8;

import java.io.IOException;
import java.util.Scanner;

public class FileCounter{
	   private int characterCount, wordCount, lineCount;
	   
	   public FileCounter(){
	      
	   }

	   /**
	      Processes an input source and adds its character, word, and line
	      counts to the respective variables.
	      @param in the scanner to process
	   */
	   void read(Scanner in) throws IOException {
	    // your code
		   
		   while(in.hasNextLine()){
			   String temp = in.nextLine();
			   lineCount++;
			   String[] word = temp.split(" |,|\\.");
			   wordCount += word.length; 
			   for(int i = 0; i < word.length;i++){
				   characterCount += word[i].length();
			   }
		   }
		   
	   }
	   int getWordCount(){
		   return wordCount;
	   }
	    int getLineCount(){
		   return lineCount;
	   }
	   int getCharacterCount(){
		   return characterCount;
	   }
	   
}
