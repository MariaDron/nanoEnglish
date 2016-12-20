package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MenuFrame extends JFrame{
	public MenuFrame() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		MenuPanel panel = new MenuPanel();
		contentPane.add(panel);
	}
}

class MenuPanel extends JPanel{
	Color RedOxide = new Color(82,21,21);
	Color FaluRed = new Color(123,31,31);
	Color CopperRose = new Color(157,111,111);
	Color PetiteOrchid = new Color(210,149,149);

	public MenuPanel(){
		setLayout(null);
		setBackground(new Color(205,92,92));
		
		Font font = new Font("TimesRoman", Font.PLAIN, 28);
		JLabel title = new JLabel("nanoEnglish");
		title.setFont(font);
		title.setForeground(Color.WHITE);
		add(title).setBounds(200, 10, 200, 50);
		
		addButton("Image/reading.png", "Читать материалы", RedOxide, 0,60,320,335);
		addButton("Image/word.png", "Учить слова", FaluRed, 320,60,230,335);
		addButton("Image/dictionary.png", "Мои словари", CopperRose, 0,395,200,335);
		addButton("Image/gramma.png", "Учить грамматику", PetiteOrchid, 200,395,350,335);
	}
	
	public void addButton(String iconName, String buttonName, Color c, int x, int y, int w, int h){
		ImageIcon icon = new ImageIcon(iconName);
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		Font font = new Font("TimesRoman", Font.PLAIN, 18);
		JButton button = new JButton(buttonName, icon);
		button.setFont(font);
		button.setBackground(c);
		button.setForeground(Color.white);
		add(button).setBounds(x,y,w,h);
		
		if(buttonName.equals("Читать материалы")){
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try{
						ReadingMaterialsFrame newframe = new ReadingMaterialsFrame();
						newframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						newframe.setVisible(true);
					} catch (ClassNotFoundException e2) {
						e2.printStackTrace();
					}
				}
			});
		}
		
		if(buttonName.equals("Мои словари")){
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					Dictionary frame = new Dictionary();
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setVisible(true);
				}
			});
		}
		
		if(buttonName.equals("Учить слова")){
			button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					try {
						LearnWordMenu frame = new LearnWordMenu();
						frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			});
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(61,15,15));
		g.fillRect(0, 0, 550, 60);
	}
}
		
