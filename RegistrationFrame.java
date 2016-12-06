package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	String up = "Зарегистрироваться";
	String in = "Зайти в аккаунт";
	static String nickname;
	
	public RegistrationPanel(String window){
		setLayout(null);
		try {                
	          back = ImageIO.read(new File("background.png"));
	          logo = ImageIO.read(new File("logo.png"));
	       } catch (IOException ex) {}
		msg = new JLabel();
		msg.setForeground(Color.red);
		add(msg);
		if (window.equals("Окно регистрации")) {
			JTextField nick = new JTextField(20);
			add(nick).setBounds(115, 300, 300, 35);
			JTextField email = new JTextField(15);
			add(email).setBounds(115, 350, 300, 35);
			JTextField password = new JTextField(15);
			add(password).setBounds(115, 400, 300, 35);
			
			JButton sign_up = new JButton(up);
			sign_up.setForeground(Color.WHITE);
			sign_up.setBackground(new Color(102, 	0, 	255));
			add(sign_up).setBounds(165, 450, 200, 50);
			JLabel label = new JLabel("Уже имеете аккаунт?");
			add(label).setBounds(210,535,200,20);
			JButton sign_in = new JButton(in);
			sign_in.setForeground(Color.WHITE);
			sign_in.setBackground(new Color(102, 	0, 	255));
			add(sign_in).setBounds(165, 565, 200, 50);
			getInformation(sign_up, nick, email, password, up);
			sign_in.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					//Main_Test.frame.dispose();	
					try{
						Main_Test.frame = new RegistrationFrame("Окно входа в аккаунт");
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
			JTextField password = new JTextField(15);
			add(password).setBounds(115, 385, 300, 45);
			
			JButton sign_in = new JButton(in);
			sign_in.setForeground(Color.WHITE);
			sign_in.setBackground(new Color(102, 	0, 	255));
			add(sign_in).setBounds(165, 450, 200, 50);
			JLabel label = new JLabel("У вас еще нету аккаунта? Зарегестрируйтесь");
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
						Main_Test.frame = new RegistrationFrame("Окно регистрации");
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
        g.setColor(Color.pink);
        g.fillRect(60, 60, 410, 575);
        g.setColor(Color.white);
        g.fillOval(130, 10, 270, 270);
        g.drawImage(logo, 160, 20, 210, 210, this);
    }
	
	public void getInformation(JButton button, JTextField nick, JTextField email, JTextField password, String doing){
		if (doing.equals(up)) {
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					String nick_text = nick.getText();
					nickname = nick_text;
					String email_text = email.getText();
					String password_text = password.getText();
					if (nick_text.equals("") | email_text.equals("") | password_text.equals("")){
						JLabel msg = new JLabel("Зополните все поля!!!");
						msg.setForeground(Color.red);
						add(msg).setBounds(200, 500, 200, 30);
					}
					else{
						User user = new User(nick_text, email_text, password_text);
						//Main_Test.user = user;
						Autentification aut = new Autentification(user, Main_Test.Base_of_Data);
						boolean result = aut.addToBase(user, Main_Test.Base_of_Data);
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
							JLabel msg = new JLabel("Шото такое уже есть! Попробуйте ввести другоие данные");
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
						msg.setText("Зополните все поля!!!");
						msg.setBounds(200, 500, 200, 30);
					}
					else{
						Autentification aut = new Autentification(Main_Test.Base_of_Data);
						boolean result = aut.checkNick(nick_text, Main_Test.Base_of_Data);
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
							msg.setText("Данный аккаунт не найден. Попробуйте еще раз");
							msg.setBounds(125, 500, 300, 30);
						}
					}
			    }
			});
		}
		
	}
}
