package nanoEnglish;

import java.awt.EventQueue;
import java.util.HashMap;
import javax.swing.*;

public class Main_Test {
	static JFrame frame;
	static User user;
	static HashMap<String,User> Base_of_Data = new HashMap<String,User>();// ������ ��� �����. ������� ��. ����
	
	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				
				try {
					frame = new RegistrationFrame("���� �����������");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
