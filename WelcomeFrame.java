package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomeFrame extends JFrame{
	public WelcomeFrame() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		WelcomePanel panel = new WelcomePanel();
		contentPane.add(panel);
	}
}

class WelcomePanel extends JPanel{
	BufferedImage logo;

	public WelcomePanel(){
		setLayout(null);
		setBackground(new Color(255,239,213));
		try {                
			logo = ImageIO.read(new File("logo.png"));
		} catch (IOException ex) {}

		Font font = new Font("TimesRoman", Font.PLAIN, 28);
		JLabel msg = new JLabel("hrufghjnn" + ", добро пожаловать :)");
		msg.setFont(font);
		add(msg).setBounds(50, 350, 500, 50);

		JLabel title = new JLabel("nanoEnglish");
		title.setFont(font);
		add(title).setBounds(200, 10, 200, 50);

		ImageIcon icon1 = new ImageIcon("menu-icon.png");
		Image img = icon1.getImage() ;  
		Image newimg = img.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		JButton menu_button = new JButton(icon1);
		menu_button.setBackground(new Color(157,111,135));
		add(menu_button).setBounds(0,0,60,60);

		menu_button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try{
					MenuFrame newframe = new MenuFrame();

					newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					newframe.setVisible(true);

				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});


		ImageIcon icon = new ImageIcon("dictionary.png");
		Image img1 = icon.getImage() ;  
		Image newimg1 = img1.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg1 );
		JButton dictionary = new JButton(icon);
		dictionary.setBackground(new Color(255,239,213));
		add(dictionary).setBounds(430,590,80,80);

		dictionary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Dictionary frame;
				frame = new Dictionary();
				frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(157,111,135));
		g.fillRect(0, 0, 550, 60);
		g.setColor(Color.white);
		g.fillOval(150, 100, 250, 250);
		g.drawImage(logo, 175, 110, 195, 195, this);
	}
}

