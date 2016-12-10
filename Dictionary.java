package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Dictionary extends JFrame{

	public Dictionary(String text) throws ClassNotFoundException{
		setSize(550,730);
		CertainDictionary panel = new CertainDictionary(text);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane).setBounds(0, 0, 550, 730);
	}

	public Dictionary(){
		setSize(550,730);
		ChoseDictionary panel = new ChoseDictionary();
		add(panel).setBounds(0, 0, 550, 730);
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException {
				Dictionary frame = new Dictionary();
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
	}*/
}

class CertainDictionary extends JPanel{

	public CertainDictionary(String filename) throws ClassNotFoundException{
		setLayout(null);
		setBackground(new Color(224,232,245));
		
		JLabel labelTitle = new JLabel(filename);
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setBackground(new Color(145,157,177));
		add(labelTitle).setBounds(0,10,550,40);
		
		ImageIcon icon = new ImageIcon("prev.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 60, 55,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JButton prev = new JButton(icon);
		prev.setBackground(new Color(145,157,177));
		add(prev).setBounds(7,5,50,50);
		
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Dictionary newframe = new Dictionary();
				newframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				newframe.setVisible(true);				
			}
		});
		
		/*LevelResultPanel.dictionary
		JTextArea textArea = new JTextArea(text); //JTextPane
		textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 14));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scrollPane).setBounds(20,80,492,593);*/
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(145,157,177));
		g.fillRect(0, 0, 550, 60);
	}
}

class ChoseDictionary extends JPanel{

	public ChoseDictionary(){

		setLayout(null);
		setBackground(new Color(224,232,245));
		
		JLabel labelTitle = new JLabel("Мои Словари");
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
		
		JButton myDictionary = new JButton("Мой словарь");
		JButton dontKnow = new JButton("Слова на изучение");
		JButton alreadyKnow = new JButton("Изученые слова");
		
		myDictionary.setBackground(new Color(99,123,162));
		myDictionary.setForeground(Color.BLACK);
		add(myDictionary).setBounds(175, 260,130,30);
		buttonAction(myDictionary);
		
		dontKnow.setBackground(new Color(66,82,108));
		dontKnow.setForeground(Color.BLACK);
		add(dontKnow).setBounds(116, 420,145,30);
		buttonAction(dontKnow);
		
		alreadyKnow.setBackground(new Color(157,182,225));
		alreadyKnow.setForeground(Color.BLACK);
		add(alreadyKnow).setBounds(294, 370,135,30);
		buttonAction(alreadyKnow);
	}
	
	public void buttonAction(JButton button){		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String button_text = button.getText();
				try {
					Dictionary frame = new Dictionary(button_text);
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

class Word extends JPanel{

	public Word (String filename){
		setLayout(null);
		setPreferredSize(new Dimension(550, 2840));
		setBackground(Color.white);
	}
}
