package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.*;
import javax.swing.*;

public class ConstructorWord extends JFrame{
	ReadDictionary myreader;
	
	public ConstructorWord(ArrayList<Dickt> dictionary) throws ClassNotFoundException {
		Random random = new Random();
		ArrayList<Dickt> training = new ArrayList<Dickt>();
		for (int i = 0; i<8; i++){
			Dickt word = dictionary.get(random.nextInt(dictionary.size()));//)
			training.add(word);
		}

		setSize(550,730);
		Container contentPane = getContentPane();
		ConstructorWordPanel panel = new ConstructorWordPanel(training);
		contentPane.add(panel);
	}
}

class ConstructorWordPanel extends JPanel{
	boolean addflag = false;
	boolean colorG = false;
	boolean colorR = false;
	int red = 0;
	int count = 0;
	Dickt word;
	ArrayList<Dickt> training;
	Random random;
	JLabel WordTitle; 
	JLabel labelTitle, ans;
	JButton question;
	String new_word = "";

	public ConstructorWordPanel(ArrayList<Dickt> training){
		setBackground(new Color(157,111,111));
		setLayout(null);
		this.word = training.remove(0);
		this.training = training;
		random = new Random();
		int c;

		ImageIcon icon = new ImageIcon("Image/audio.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JButton audio = new JButton(icon);
		audio.setBackground(Color.WHITE);
		add(audio).setBounds(385,330,32,32);

		ImageIcon icon1 = new ImageIcon("Image/question.png");
		Image img1 = icon1.getImage() ;  
		Image newimg1 = img1.getScaledInstance( 30, 30,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon1 = new ImageIcon( newimg1 );
		question = new JButton(icon1);
		question.setBackground(new Color(157,111,111));
		add(question).setBounds(450,390,35,42);

		ImageIcon icon2 = new ImageIcon("Image/next.png");
		Image img2 = icon2.getImage() ;  
		Image newimg2 = img2.getScaledInstance( 60, 60,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon2 = new ImageIcon( newimg2 );
		JButton next = new JButton(icon2);
		next.setBackground(new Color(157,111,111));
		add(next).setBounds(430,600,60,60);

		labelTitle = new JLabel("Соберите слово из букв");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelTitle.setForeground(new Color(82,21,21));
		labelTitle.setBackground(Color.WHITE);
		add(labelTitle).setBounds(90,150,350,30);
		
		ans = new JLabel("");
		ans.setHorizontalAlignment(JLabel.CENTER);
		ans.setFont(new Font("Verdana", Font.PLAIN, 26));
		ans.setForeground(new Color(82,21,21));
		ans.setBackground(Color.WHITE);
		add(ans).setBounds(90,150,350,30);
		ans.setVisible(false);

		WordTitle = new JLabel(word.trans1);
		WordTitle.setHorizontalAlignment(JLabel.CENTER);
		WordTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
		WordTitle.setForeground(Color.BLACK);
		WordTitle.setBackground(Color.WHITE);
		add(WordTitle).setBounds(90,240,350,50);
		
		make_char_button(word.word);

		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!training.isEmpty()){
					word = training.remove(0);
					WordTitle.setText(word.trans1);
					labelTitle.setVisible(true);
					ans.setVisible(false);
					new_word = "";
					make_char_button(word.word);
					red = 0;
					colorG = false;
					colorR = false;
					repaint();
				}
				else{
					try {
						LearnWordMenu frame = new LearnWordMenu(count);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

	public void make_char_button(String word){
		char c;
		int x;
		int y=430;
		int num = word.length();
		if (num<=5){
			x= (550 - num*50 - (num-1)*20)/2;
		}
		else {
			x=100;
		}
		ArrayList ind = new ArrayList();
		for (int i=0; i<num; i++){
			ind.add(i);
		}
		for (int i=0; i<word.length(); i++){
			int index = (int) ind.remove(random.nextInt(ind.size()));
			c = word.charAt(index);
			Font font = new Font("Verdana", Font.PLAIN, 19);
			JButton b = new JButton(String.valueOf(c));
			b.setBackground(Color.white);
			b.setFont(font);
			add(b).setBounds(x, y, 50, 50);
			x = x + 70;
			if ((i==4) || (i==9)){
				y = 500;
				String tmp = word.substring(i, word.length());
				if (tmp.length()<=5){
					x= (550 - tmp.length()*50 - (tmp.length()-1)*20)/2;
				}
				else x=100;
			}
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if ((new_word + b.getText()).equals(word)) {
						question.setVisible(false);
						if (red>0) colorR=true;
						else{
							count ++;
							colorG = true;
						}
						repaint();
						remove(b);
					}
					if ((new_word + b.getText()).equals(word.substring(0, new_word.length()+1))){
						labelTitle.setVisible(false);
						ans.setVisible(true);
						new_word = new_word + b.getText();
						ans.setText(new_word);
						b.setVisible(false);
						remove(b);
					}
					else{
						red++;
					}
				}
			});
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		g2.setStroke(new BasicStroke(4.0f));
		g.setColor(Color.WHITE);
		g.fillRect(90, 70, 350, 300);
		if (addflag == true){
			g.setColor(Color.black);
			g.drawString(new_word, 100, 200);
		}
		if (colorG == true){
			g.setColor(Color.GREEN);
			g.drawRect(88, 68, 353, 303);
		}
		if (colorR == true) {
			g.setColor(Color.RED);
			g.drawRect(88, 68, 353, 303);
		}
		
	}
}
