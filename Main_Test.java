package nanoEnglish;

import java.awt.EventQueue;
import java.util.HashMap;
import javax.swing.*;

public class Main_Test {
	static JFrame frame;
	static User user;
	static HashMap<String,User> Base_of_Data = new HashMap<String,User>();// каждый раз новый. Сделать вн. файл
	
	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				try {
					frame = new RegistrationFrame("Окно регистрации");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
