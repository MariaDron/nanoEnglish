package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*;

public class LearnWordMenu extends JFrame{
	public LearnWordMenu() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		WordMenuPanel panel = new WordMenuPanel();
		contentPane.add(panel);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		LearnWordMenu frame = new LearnWordMenu();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class WordMenuPanel extends JPanel{
	public WordMenuPanel() throws ClassNotFoundException{

		setLayout(null);
		setBackground(new Color(224,232,245));
		
		ReadDictionary rd = new ReadDictionary("FirstLevelDictionary.txt");
		ArrayList<Dickt> arr = rd.reading();
		for (int i=0; i<arr.size(); i++){
			System.out.println("Слово: " + arr.get(i).word + " Перевод: " + arr.get(i).trans1);
		}
		
		JLabel labelTitle = new JLabel("Тренировка лексики");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setBackground(new Color(145,157,177));
		add(labelTitle).setBounds(0,10,550,40);
		
		ImageIcon icon1 = new ImageIcon("menu-icon.png");
		Image img = icon1.getImage() ;  
		Image newimg = img.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		JButton menu_button = new JButton(icon1);
		menu_button.setBackground(new Color(145,157,177));
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
		
		JButton translate = new JButton("Слово-перевод");
		JButton constructor = new JButton("Конструктор");
		JButton word = new JButton("Перевод-слово");
		
		translate.setBackground(new Color(99,123,162));
		translate.setForeground(Color.BLACK);
		add(translate).setBounds(175, 260,130,30);
		translate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					WordTranslation frame = new WordTranslation(arr);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		constructor.setBackground(new Color(66,82,108));
		constructor.setForeground(Color.BLACK);
		add(constructor).setBounds(116, 420,145,30);
		constructor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					ConstructorWord frame = new ConstructorWord(arr);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}				
			}
		});
		
		word.setBackground(new Color(157,182,225));
		word.setForeground(Color.BLACK);
		add(word).setBounds(294, 370,135,30);
		word.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					TranslationWord frame = new TranslationWord(arr);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}				
			}
		});
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(145,157,177));
		g.fillRect(0, 0, 550, 60);
		g.setColor(Color.black);
		Graphics2D g2 = (Graphics2D) g; 
		g2.setStroke(new BasicStroke(3.0f));
		
		g.drawOval(140, 175, 200, 200);
		g.setColor(new Color(99,123,162));
		g.fillOval(141, 176, 199, 199);
		
		g.setColor(Color.black);
		g.drawOval(95, 335, 200, 200);
		g.setColor(new Color(66,82,108));
		g.fillOval(96, 336, 199, 199);
		
		g.setColor(Color.black);
		g.drawOval(255, 285, 200, 200);
		g.setColor(new Color(157,182,225));
		g.fillOval(256, 286, 199, 199);
	}
}