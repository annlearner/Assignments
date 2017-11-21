package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;


public class LyricAnalyzer {
	private HashMap<String, ArrayList<Integer>> map;
	TreeSet<String> ts;
	int count = 0;
	
	public LyricAnalyzer(){
		this.map = new HashMap<String, ArrayList<Integer>>();
	}
	public static void main(String[] args) throws IOException{
        LyricAnalyzer l = new LyricAnalyzer();
        File f = new File("E:\\Eclipse\\Assignment8\\src\\assignment8\\Test3");
        l.read(f);
        l.displayWords();
        l.writeLyrics(new File("E:\\Eclipse\\Assignment8\\src\\assignment8\\Test5"));
    }
	public void read(File file) throws FileNotFoundException, IOException{
		FileReader fls = new FileReader(file);
		BufferedReader br = new BufferedReader(fls);
		String line;
		while((line = br.readLine()) != null){
			String[] words = line.split(" ");
			for(int i = 0; i < words.length ;i++){
				if(i == words.length - 1){
					add(words[i], 0 - (count++));	
				}else{
					add(words[i], count++);
				}
			}
			
		}
		ts = new TreeSet<>(map.keySet());
		fls.close();
		br.close();
		
	}
	private void add(String lyricWord, int wordPosition){
		if(!map.containsKey(lyricWord.toLowerCase())){
			ArrayList list = new ArrayList<Integer>();
			list.add(wordPosition);
			map.put(lyricWord.toLowerCase(), list);
		}else{
			map.get(lyricWord.toLowerCase()).add(wordPosition);
			// Remember to negate the word position if the word is at the end of a line in the lyrics.
		}
	}
	
	 
	public void displayWords(){
		//把map中key全部取出；排序；按顺序打印 
		//using one of the sort methods from the Java API.
       for(String word : ts){
    	   System.out.print(word.toUpperCase() + ":");
    	   for(int i = 0; i <map.get(word).size(); i++){   
    		   System.out.print(map.get(word).get(i) + ",");
    	   	}
    	   System.out.println();
       }
		}


	public void writeLyrics(File file) throws IOException{
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		TreeSet<String> ts = new TreeSet<>(map.keySet());
		String[] lyrics = new String[count];
		//Initialize this array with empty strings (not null).
		for(String word : ts){
			for(int i = 0; i < map.get(word).size(); i++){
				if(map.get(word).get(i) > 0){
					lyrics[map.get(word).get(i)] = word+" ";
				}else{
					lyrics[Math.abs(map.get(word).get(i))] = word + "\n";
				}
			}
		}
		for(int i = 0; i < lyrics.length; i++){
		pw.print(lyrics[i]);
		}
		fw.close();
		pw.close();
	}
	public int count(){
		return map.size();
	}
	public String mostFrequentWord(){
		TreeSet<String> mfw= new TreeSet<>(map.keySet());
		int longest = Integer.MIN_VALUE;
		String word = "";
		for(String part : mfw){
				if(map.get(part).size()> longest){
					word = part;	
					longest = map.get(part).size();
			}
		}
		return word;
	}
}
