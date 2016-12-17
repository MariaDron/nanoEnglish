package nanoEnglish;

import java.io.*;
import java.util.ArrayList;

public class ReadDictionary {
	
	String filename;
	
	/*public static void main(String[] args) throws ClassNotFoundException {
		ReadDictionary frame = new ReadDictionary("FirstLevelDictionary.txt");
		ArrayList<Dickt> arr = frame.reading();
		for (int i=0; i<arr.size(); i++){
			System.out.println("Слово: " + arr.get(i).word + " Перевод: " + arr.get(i).trans1);
		}
	}*/
	
	public ReadDictionary (String filename){
		this.filename = filename;
	}
	
	public ArrayList<Dickt> reading () throws ClassNotFoundException{
		ArrayList<Dickt> arr = new ArrayList<Dickt>();
		try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            Dickt comp = new Dickt();
            String line = reader.readLine();
            comp = breakLine(line);
            while (line != null) {
            	comp = breakLine(line);
                arr.add(comp);
                line = reader.readLine();
            }
            reader.close();
        } 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
		
		
		return arr;
	}
	
	public Dickt breakLine(String line){
		Dickt comp = new Dickt();
		int i =1;
		for (String word : line.split("@")) {
			if (i==1)
				comp.word = word;
			if (i==2)
				comp.trans1 = word;
			if (i==3)
				comp.trans2 = word;
			if (i==4)
				comp.trans3 = word;
			if (i==5)
				comp.trans4 = word;
			if (i==6)
				comp.trans5 = word;
			i++;
		}
		return comp;
	}
}
