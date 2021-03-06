package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RegistrationFrame extends JFrame{

	public RegistrationFrame(String window) throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		RegistrationPanel panel = new RegistrationPanel(window);
		contentPane.add(panel);
	}
}

class RegistrationPanel extends JPanel{

	private BufferedImage back, logo;
	static JFrame frame1;
	JLabel msg;
	String up = "������������������";
	String in = "����� � �������";
	static String nickname;
	String s=" nick";
	String s1=" nick";
	String s2="";
	String s3="";
	String s4;

	public RegistrationPanel(String window){
		setLayout(null);
		try {                
			back = ImageIO.read(new File("Image/background.png"));
			logo = ImageIO.read(new File("Image/logo.png"));
		} catch (IOException ex) {}
		msg = new JLabel();
		msg.setForeground(Color.red);
		add(msg);
		if (window.equals("���� �����������")) {
			JTextField n = new JTextField(15);
			add(n).setBounds(0, 0, 0, 0);
			JTextField nick = new JTextField(20);
			add(nick).setBounds(115, 300, 300, 35);
			//nick.setFocusable(false);
			JTextField email = new JTextField(15);
			add(email).setBounds(115, 350, 300, 35);

			JPasswordField password = new JPasswordField(15);
			add(password).setBounds(115, 400, 300, 35);
			nick.setText(s);
			email.setText(" email");
			password.setText(" password");
			nick.setForeground(Color.LIGHT_GRAY);
			email.setForeground(Color.LIGHT_GRAY);
			password.setForeground(Color.LIGHT_GRAY);
			char password1 = 0;
			char password2 = '�';

			String ss=email.getText();
			password.setEchoChar(password1);

			nick.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					nick.setForeground(Color.BLACK);
					if (s1==s){
						nick.setText("");;
						s2="";
					}			    	 
				}
				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					s4=nick.getText();
					if ((s4=="")){
						nick.setText("!!");
					}
					else{
						nick.setText(s4);	
						s1="";
					}
				} });

			email.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					email.setForeground(Color.BLACK);
					email.setText("");;
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					s4=email.getText();
					if ((s4=="")){
						email.setText("!!");
					}
					else{
						email.setText(s4);	
						s1="";
					}
				} });

			password.addFocusListener(new FocusListener() {
				public void focusGained(FocusEvent e) {
					password.setForeground(Color.BLACK);
					password.setEchoChar(password2);
					password.setText("");;
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					password.setEchoChar(password1);
					s4=password.getText();
					if ((s4=="")){
						password.setText("!!");
					}
					else{
						password.setText(s4);	
						password.setEchoChar(password2);
						s1="";
					}
				} });

			JButton sign_up = new JButton(up);
			sign_up.setForeground(Color.WHITE);
			sign_up.setBackground(new Color(191,157,153));
			add(sign_up).setBounds(165, 450, 200, 50);
			JLabel label = new JLabel("��� ������ �������?");
			add(label).setBounds(210,535,200,20);
			JButton sign_in = new JButton(in);
			sign_in.setForeground(Color.WHITE);
			sign_in.setBackground(new Color(191,157,153));
			add(sign_in).setBounds(165, 565, 200, 50);
			getInformation(sign_up, nick, email, password, up);
			sign_in.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//Main_Test.frame.dispose();	
					try{
						Main_Test.frame = new RegistrationFrame("���� ����� � �������");
						Main_Test.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Main_Test.frame.setVisible(true);

					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		else{
			JTextField nick = new JTextField(20);
			add(nick).setBounds(115, 320, 300, 45);
			JPasswordField password = new JPasswordField(15);
			add(password).setBounds(115, 385, 300, 45);

			JButton sign_in = new JButton(in);
			sign_in.setForeground(Color.WHITE);
			sign_in.setBackground(new Color(102, 	0, 	255));
			add(sign_in).setBounds(165, 450, 200, 50);
			JLabel label = new JLabel("� ��� ��� ���� ��������? �����������������");
			add(label).setBounds(135,535,270,20);
			JButton sign_up = new JButton(up);

			sign_up.setForeground(Color.WHITE);
			sign_up.setBackground(new Color(102, 	0, 	255));
			add(sign_up).setBounds(165, 565, 200, 50);
			getInformation(sign_in, nick, null, password, in);
			sign_up.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//Main_Test.frame.dispose();	
					try{
						Main_Test.frame = new RegistrationFrame("���� �����������");
						Main_Test.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Main_Test.frame.setVisible(true);

					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		}		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, 550, 700, this);
		g.setColor(new Color(255,245,230));
		g.fillRect(60, 60, 410, 575);
		g.setColor(Color.white);
		g.fillOval(130, 10, 270, 270);
		g.drawImage(logo, 160, 20, 210, 210, this);
	}

	public void getInformation(JButton button, JTextField nick, JTextField email, JPasswordField password, String doing){
		if (doing.equals(up)) {
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String nick_text = nick.getText();
					nickname = nick_text;
					String email_text = email.getText();
					char[] pass= password.getPassword();
					String password_text = "";
					for (int i=0; i<pass.length; i++){
						password_text = password_text + pass[i];
					}
					if (nick_text.equals("") |nick_text.equals(" nick") | email_text.equals("") | email_text.equals(" email") |password_text.equals("")|password_text.equals(" password")){
						JLabel msg = new JLabel("��������� ��� ����!!!");
						msg.setForeground(Color.red);
						add(msg).setBounds(200, 500, 200, 30);
					}
					else{
						User user = new User(nick_text, email_text, password_text);
						Autentification aut = new Autentification(user, Main_Test.Base_of_Data);
						aut.reading();
						boolean result = aut.createBase();
						if (result == true){
							Main_Test.frame.dispose();	
							try{
								frame1 = new LevelTest();
								frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame1.setVisible(true);

							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						else{
							JLabel msg = new JLabel("���� ����� ��� ����! ���������� ������ ������� ������");
							msg.setForeground(Color.red);
							add(msg).setBounds(165, 500, 200, 30);
							nick.setText("");
							email.setText("");
							password.setText("");
						}
					}
				}
			});
		}
		else{
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String nick_text = nick.getText();
					String password_text = password.getText();
					if (nick_text.equals("") | password_text.equals("")){
						msg.setText("��������� ��� ����!!!");
						msg.setBounds(200, 500, 200, 30);
					}
					else{
						Autentification aut = new Autentification(nick_text, Main_Test.Base_of_Data);
						aut.reading();
						boolean result = aut.checkNick();
						if (result == true){
							Main_Test.frame.dispose();	
							try{
								frame1 = new LevelTest();
								frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								frame1.setVisible(true);

							} catch (ClassNotFoundException e1) {
								e1.printStackTrace();
							}
						}
						else{
							msg.setText("������ ������� �� ������. ���������� ��� ���");
							msg.setBounds(125, 500, 300, 30);
						}
					}
				}
			});
		}

	}

}