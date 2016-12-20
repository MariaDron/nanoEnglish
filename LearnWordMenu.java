package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LearnWordMenu extends JFrame{
	public LearnWordMenu() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		WordMenuPanel panel = new WordMenuPanel();
		contentPane.add(panel);
	}
	
	public LearnWordMenu(int count) throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		ResultOfLearning panel = new ResultOfLearning(count);
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
		
		JLabel labelTitle = new JLabel("���������� �������");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setBackground(new Color(145,157,177));
		add(labelTitle).setBounds(0,10,550,40);
		
		ImageIcon icon1 = new ImageIcon("Image/menu-icon.png");
		Image img = icon1.getImage() ;  
		Image newimg = img.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg );
		JButton menu_button = new JButton(icon1);
		menu_button.setBackground(new Color(145,157,177));
		menu_button.setFocusPainted(false);
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
		
		JButton translate = new JButton("�����-�������");
		JButton constructor = new JButton("�����������");
		JButton word = new JButton("�������-�����");
		
		translate.setBackground(new Color(99,123,162));
		translate.setForeground(Color.BLACK);
		translate.setFocusPainted(false);
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
		constructor.setFocusPainted(false);
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
		word.setFocusPainted(false);
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

class ResultOfLearning extends JPanel{
	private BufferedImage cong;
	
	public ResultOfLearning(int count){
		setBackground(new Color(224,232,245));
		setLayout(null);
		
		try {                
			cong = ImageIO.read(new File("Image/congratulations.png"));
		} catch (IOException ex) {}
		
		JLabel labelTitle = new JLabel("���������� ������� "+count+" �� 8");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setForeground(Color.BLACK);
		labelTitle.setBackground(new Color(145,157,177));
		add(labelTitle).setBounds(0,400,550,40);
		
		JButton returning = new JButton("��");
		returning.setBackground(new Color(99,123,162));
		returning.setForeground(Color.BLACK);
		returning.setFocusPainted(false);
		add(returning).setBounds(245, 480,70,35);
		returning.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					LearnWordMenu frame = new LearnWordMenu();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}				
			}
		});
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(cong, 20, 80, 490, 280, this);
	}
}