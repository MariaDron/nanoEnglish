package nanoEnglish;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Autentification {
	HashMap<String,User> Base_of_Data = new HashMap<String,User>();
	User user;
	String nick;
	
	public Autentification(User room, HashMap<String,User> Base_of_Data){
		user = room;
		this.Base_of_Data = Base_of_Data;
	}
	
	public Autentification(String nick, HashMap<String,User> Base_of_Data){
		this.nick = nick;
		this.Base_of_Data = Base_of_Data;
	}

	public void writting(){
		try {
			FileWriter fr = new FileWriter("Data Base.txt");
			BufferedWriter writer = new BufferedWriter(fr);
			writer.write(user.email+"@"+user.nick+"@"+user.password);
			writer.newLine();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void reading (){
		try {
            FileReader fr = new FileReader("Data Base.txt");
            BufferedReader reader = new BufferedReader(fr);
            User room = new User();
            String line = reader.readLine();
            room = breakLine(line);
            while (line != null) {
            	room = breakLine(line);
            	Base_of_Data.put(room.nick, room);
                line = reader.readLine();
            }
            reader.close();
        } 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
	}

	public boolean createBase(){		
		if (Base_of_Data.isEmpty()){
			Base_of_Data.put(user.nick, user);
			writting();
			return true;
		}
		else{
			int numb = 0;
			for (String key : Base_of_Data.keySet()) {
				if (key==user.nick) 
					numb++;
			}
			if (numb == 0) {
				Base_of_Data.put(user.nick, user);
				writting();
				return true;
			}
			else return false;
		}
	}
	
	public User breakLine(String line){
		User user = new User();
		int i =1;
		for (String word : line.split("@")) {
			if (i==1)
				user.email = word;
			if (i==2)
				user.nick = word;
			if (i==2)
				user.password = word;
			i++;
		}
		return user;
	}

	public boolean checkNick(){
		for (String key : Base_of_Data.keySet()) {
			if (key==nick) 
				return true;
		}
		return false;
	}
}
