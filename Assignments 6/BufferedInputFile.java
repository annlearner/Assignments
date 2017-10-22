package assignment6;

import java.awt.List;
import java.io.*;
import java.util.ArrayList;

public class BufferedInputFile {


    public static ArrayList<String> read(String filename) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(filename));

        String s;

        ArrayList<String> result = new ArrayList<>();

        while ((s = in.readLine()) != null)

        	result.add(s + "\n");

        in.close();

        return result;
    }

}

