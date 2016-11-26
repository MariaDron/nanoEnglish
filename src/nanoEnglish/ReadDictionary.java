package nanoEnglish;

import java.io.*;
import java.util.ArrayList;

public class ReadDictionary {
	
	String filename;
	
	public ReadDictionary (String filename){
		this.filename = filename;
	}
	
	public String reading () throws ClassNotFoundException{
		ArrayList<Dictionary_Structure> dict = new ArrayList<Dictionary_Structure>();
		try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
            }
            reader.close();
        } 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
		return "";
	}
}
