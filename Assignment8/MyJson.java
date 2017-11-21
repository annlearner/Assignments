package assignment8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyJson {
	
	public static void main(String[] args) throws IOException{
	    File file = new File("E:\\Eclipse\\Assignment8\\src\\assignment8\\Camino");
	    ArrayList<Vehicle> vehicles = readAndGetVehicles(file);
	    String s = getJsonString(vehicles);
	    writeToFile(s, file.getParent());
	}
	private static ArrayList<Vehicle> readAndGetVehicles(File file) throws IOException{
	  //read from the file
	  FileReader fr = new FileReader(file);
	  BufferedReader  bf =new BufferedReader(fr);
	  ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
	  String line;
	  bf.readLine();
	  //the first line is title should be jump through
	  while((line = bf.readLine())!=null){
	  String[] arr =  line.split("~");
	  //create vehicle objects
	  vehicles.add(new Vehicle(arr));
	  }
	  fr.close();
	  bf.close();
      //add them to an arrayList and return the arrayList.
      return vehicles;
	}
	public static String getJsonString(ArrayList<Vehicle> vehicles){
		//take the vehicle objects of the particular dealer 
		StringBuilder sb = new StringBuilder();
		sb.append("{"+"\n");
		sb.append("\""+ vehicles.get(0).webId +"\""+ ":" + "["+"\n");
		for(int i = 0; i < vehicles.size();i++){
	   //convert its content to a json string and return it
			sb.append("{"+"\n");
		sb.append("\""+"id"+ "\"" +":" + "\"" + vehicles.get(i).id + "\"" + ","+"\n");
		sb.append("\""+"category" + "\"" +":"+ "\""  + vehicles.get(i).category+ "\""+","+"\n");
		sb.append("\"" +"year" + "\"" + ":"+ "\""  +vehicles.get(i).year+ "\"" + ","+"\n");
		sb.append("\"" +"make" + "\"" +":" + "\""+ vehicles.get(i).make+ "\"" + ","+"\n");
		sb.append("\"" +"model" + "\"" +":" + "\""+  vehicles.get(i).model+ "\"" + ","+"\n");
		sb.append("\"" +"trim" + "\"" +":" + "\""+ vehicles.get(i).trim + "\""+","+"\n");
		sb.append("\"" +"type" + "\"" + ":"+ "\"" + vehicles.get(i).type + "\""+ ","+"\n");
		sb.append("\"" +"price"+  "\"" +":" + "\""+vehicles.get(i).price+ "\""+ ","+"\n");
		sb.append("\"" +"photo"+  "\"" +":" + "\""+vehicles.get(i).photo+ "\""+ ","+"\n");
		sb.append("},"+"\n");
			}
		sb.append("]"+"\n"+"}");
		return sb.toString();
		}

	public static void writeToFile(String inputToWrite, String filePath) throws IOException{
		PrintWriter fos = new PrintWriter(new FileWriter(new File (filePath+"\\Test6")));
		fos.print(inputToWrite);
		fos.close();
	}
}
