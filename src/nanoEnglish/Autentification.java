package nanoEnglish;

import java.util.*;

public class Autentification {
	HashMap<Integer,User> Base_of_Data = new HashMap<Integer,User>();
	int pin;
	
	public Autentification(int pin, HashMap<Integer,User> Base_of_Data){
		this.pin = pin;
		this.Base_of_Data = Base_of_Data;
	}
	
	public boolean addToBase(String name, int level){
		if (Base_of_Data.isEmpty()){
			Base_of_Data.put(pin, new User(name,level));
			return true;
		}
		int numb = 0;
		for (Integer key : Base_of_Data.keySet()) {
			if (key==pin) 
				numb++;
		}
		if (numb == 0) {
			Base_of_Data.put(pin, new User(name,level));
			 return true;
		 }
		 else
			 return false;
	}
}
