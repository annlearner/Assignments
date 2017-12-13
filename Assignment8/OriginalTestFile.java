package assignment8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class OriginalTestFile {
	public static void main(String[] args) throws IOException{
    File file = new File("E:\\Eclipse\\Assignment8\\src\\assignment8\\Test6");
    File file1 = new File("E:\\Eclipse\\Assignment8\\src\\assignment8\\Test7");
    ArrayList<Vehicle> vehicles = getVehicles(file);
    String s = getOriginalTest(vehicles);
    writeToFile(s, file1);
    
	}

	private static ArrayList<Vehicle> getVehicles(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		br.readLine();
		String line = br.readLine();
		String[] temp = line.split("\"");
		int i = 0;
	while(true){
		String t = br.readLine();
		if(t==null||t.contains("]"))break;
		String[] arr = new String[10];
		arr[1] = temp[1];
		i = 0;
		while(i <= 9){
			if(i == 1){
				i++;
				continue;
			}
			line = br.readLine();
			String[] arr1 = line.split("\"");
			if(i==2){
				arr[i++] = arr1[3].toLowerCase();
			}
			else if (i < 10){
				arr[i++] = arr1[3];
			}
		}
	
				vehicles.add(new Vehicle(arr));
				br.readLine();
		}
	return vehicles;
	}
	
		// TODO Auto-generated method stub
		

	private static String getOriginalTest(ArrayList<Vehicle> vehicles) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < vehicles.size(); i++){
			sb.append(vehicles.get(i).id+"~");
			sb.append(vehicles.get(i).webId +"~");
			
			sb.append(vehicles.get(i).category+"~");
			sb.append(vehicles.get(i).year+"~");
			sb.append(vehicles.get(i).make+"~");
			sb.append(vehicles.get(i).model+"~");
			sb.append(vehicles.get(i).trim+"~");
			sb.append(vehicles.get(i).type+"~");
			sb.append(vehicles.get(i).price+"~");
			sb.append(vehicles.get(i).photo+"\n");
		}
		return sb.toString();
	}
	public static void writeToFile(String inputToWrite, File f) throws IOException{
		PrintWriter fos = new PrintWriter(new FileWriter(f));
		fos.print(inputToWrite);
		fos.close();
	}
} 
