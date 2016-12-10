package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LevelResultFrame extends JFrame{

	public LevelResultFrame(int level) throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		LevelResultPanel panel = new LevelResultPanel(level);
		contentPane.add(panel);
	}
}

class LevelResultPanel extends JPanel{

	String text_lev1 = "Вам придется хорошо поработать над собой и своими знаниями";
	String text_lev2 = "Вам необходимо улучшить уровень знания английского языка";
	String text_lev3 = "Вы хорошо знаете английский язык, но практика никогда не бывает лишней";
	String filename;
	Color Red = (Color.red);
	Color TransRed = new Color(250, 	218, 	221);
	Color Yellow = new Color(255, 	255, 	0);
	Color TransYellow = new Color(255, 	250, 	205);
	Color Green = new Color(0, 	255, 	0);
	Color TransGreen = new Color(208, 240, 192);
	static Color color1;
	static Color color2;
	static Color color3;
	static Color color4;
	static Color color5;
	static Color color6;
	BufferedImage back;
	static JLabel res;
	static JTextArea textArea;
	static public ArrayList<Dickt> dictionary;
	int level;

	public LevelResultPanel(int level){
		this.level = level;
		setLayout(null);
		try {                
			back = ImageIO.read(new File("background.png"));
		} catch (IOException ex) {}
		Font font = new Font("TimesRoman", Font.PLAIN, 17);
		JLabel msg = new JLabel("Ваш уровень знания английского");
		msg.setFont(font);
		//msg.setForeground();  темнее чем фон
		add(msg).setBounds(130, 260, 300, 50);

		JLabel res = new JLabel();
		Font resfont = new Font("TimesRoman", Font.BOLD, 24);
		res.setFont(resfont);
		add(res).setBounds(210, 320, 200, 50);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255,226,223));
		textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 16));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		add(textArea).setBounds(150,405,230,115);

		JButton ok = new JButton("Перейти к обучению");
		ok.setForeground(Color.black);
		ok.setBackground(new Color(191,157,153));
		add(ok).setBounds(165, 560, 200, 50);

		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {			
				try{
					WelcomeFrame newframe = new WelcomeFrame();
					newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					newframe.setVisible(true);
					
				} catch (ClassNotFoundException e2) {
					e2.printStackTrace();
				}
			}
		});

		if (level == 1) {
			res.setText("Низкий");
			textArea.setText(text_lev1);
			color1=Red;
			color2=TransYellow;
			color3=TransGreen;
			color4=Red;
			color5=Yellow;
			color6=Green;
		}
		if (level == 2) {
			res.setText("Средний");
			textArea.setText(text_lev2);
			color1=TransRed;
			color2=Yellow;
			color3=TransGreen;
			color4=Red;
			color5=Yellow;
			color6=Green;
		}
		if (level == 3) {
			res.setText("Высокий");
			textArea.setText(text_lev3);
			color1=TransRed;
			color2=TransYellow;
			color3=Green;
			color4=Red;
			color5=Yellow;
			color6=Green;
		}
		
		if (level==1){
			filename = "FirstLevelDictionary.txt";
		}
		if (level==2){
			filename = "SecondLevelDictionary.txt";
		}
		if (level==1){
			filename = "ThirdLevelDictionary.txt";
		}
		try {
			ReadDictionary rd = new ReadDictionary(filename);
			dictionary = rd.reading();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(back, 0, 0, 550, 700, this);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(1.0f));
		g.setColor(new Color(255,245,230));
		g.fillRect(60, 60, 410, 575);
		g.setColor((color1));
		g.fillOval(105, 140, 80, 80);
		g.setColor((color4));
		g.drawOval(105, 140, 80, 80);
		g.setColor((color2));
		g.fillOval(225, 140, 80, 80);
		g.setColor((color5));
		g.drawOval(225, 140, 80, 80);
		g.setColor((color3));
		g.fillOval(345, 140, 80, 80);
		g.setColor((color6));
		g.drawOval(345, 140, 80, 80);
		g.setColor(new Color(163,145,142));
		g.drawRect(125, 390, 280, 145);
		g.setColor(new Color(255,226,223));
		g.fillRect(126, 391, 279, 144);
	}
}
