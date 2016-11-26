package nanoEnglish;

import java.awt.EventQueue;
import java.util.HashMap;
import javax.swing.*;

public class Main_Test {
	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				JFrame frame;
				try {
					frame = new RegistrationFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		//int pin = 
		HashMap<Integer,User> Base_of_Data = new HashMap<Integer,User>();
		//Autentification registration = new Autentification(pin,Base_of_Data);
	}
}
