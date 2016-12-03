package nanoEnglish;

import java.util.*;

public class Autentification {
	HashMap<String,User> Base_of_Data = new HashMap<String,User>();
	User room;
	
	public Autentification(HashMap<String,User> Base_of_Data){
		this.Base_of_Data = Base_of_Data;
	}
	
	public Autentification(User room, HashMap<String,User> Base_of_Data){
		this.room = room;
		this.Base_of_Data = Base_of_Data;
	}
	
	public boolean addToBase(User room, HashMap<String,User> Base_of_Data){
		if (Base_of_Data.isEmpty()){
			Base_of_Data.put(room.nick, room);
			return true;
		}
		int numb = 0;
		for (String key : Base_of_Data.keySet()) {
			if (key==room.nick) 
				numb++;
		}
		if (numb == 0) {
			Base_of_Data.put(room.nick, room);
			 return true;
		 }
		 else
			 return false;
	}
	
	public boolean checkNick(String nick, HashMap<String,User> Base_of_Data){
		for (String key : Base_of_Data.keySet()) {
			if (key==nick) 
				return true;
		}
		return false;
	}
}
