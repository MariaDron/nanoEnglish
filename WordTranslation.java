package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.util.*;

import javax.swing.*;

public class WordTranslation extends JFrame{
	ReadDictionary myreader;

	public WordTranslation(ArrayList<Dickt> dictionary) throws ClassNotFoundException {
		ArrayList<Integer> y = new ArrayList();
		Random random = new Random();
		y.add(430);
		y.add(490);
		y.add(550);
		y.add(610);		
		ArrayList<Dickt> training = new ArrayList<Dickt>();
		for (int i = 0; i<8; i++){
			Dickt word = dictionary.get(random.nextInt(dictionary.size()));
			training.add(word);
		}

		setSize(550,730);
		Container contentPane = getContentPane();
		WordTranslationdPanel panel = new WordTranslationdPanel(training,y,dictionary);
		contentPane.add(panel);
	}
}

class WordTranslationdPanel extends JPanel{
	boolean colorR = false;
	boolean colorG = false;
	Dickt word;
	int count = 0;
	ArrayList<Dickt> training;
	Random random;
	JLabel WordTitle, labelTitle; 
	JButton question,answer1,answer2,answer3,answer4;
	ActionListener [] act1, act2, act3, act4;

	public WordTranslationdPanel(ArrayList<Dickt> training, ArrayList<Integer> y, ArrayList<Dickt> dictionary){
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

		labelTitle = new JLabel("Выберите правильный ответ");
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 12));
		labelTitle.setForeground(new Color(82,21,21));
		labelTitle.setBackground(Color.WHITE);
		add(labelTitle).setBounds(90,280,350,30);

		WordTitle = new JLabel(word.word);
		WordTitle.setHorizontalAlignment(JLabel.CENTER);
		WordTitle.setFont(new Font("Verdana", Font.PLAIN, 30));
		WordTitle.setForeground(Color.BLACK);
		WordTitle.setBackground(Color.WHITE);
		add(WordTitle).setBounds(90,150,350,50);

		ArrayList<Dickt> otherWord = random_answers(dictionary);
		c = y.remove(random.nextInt(y.size()));
		answer1 =  make_answer_button(word.trans1, c);
		c = y.remove(random.nextInt(y.size()));
		Dickt new_word = otherWord.remove(0);
		answer2 =  make_answer_button(new_word.trans1, c);
		c = y.remove(random.nextInt(y.size()));
		new_word = otherWord.remove(0);
		answer3 =  make_answer_button(new_word.trans1, c);
		c = y.remove(random.nextInt(y.size()));
		new_word = otherWord.remove(0);
		answer4 =  make_answer_button(new_word.trans1, c);

		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(!training.isEmpty()){
					word = training.remove(0);
					WordTitle.setText(word.word);
					ArrayList<Dickt> otherWord = random_answers(dictionary);
					otherWord.add(word);
					Dickt d = otherWord.remove(random.nextInt(otherWord.size()));
					answer1.setText(d.trans1);
					d = otherWord.remove(random.nextInt(otherWord.size()));
					answer2.setText(d.trans1);
					d = otherWord.remove(random.nextInt(otherWord.size()));
					answer3.setText(d.trans1);
					d = otherWord.remove(random.nextInt(otherWord.size()));
					answer4.setText(d.trans1);
					question.setVisible(true);
					Font font = new Font("Verdana", Font.PLAIN, 12);
					labelTitle.setFont(font);
					labelTitle.setText("Выберите правильный ответ");
					colorR = false;
					colorG = false;
					answer1.addActionListener(act1[0]);
					answer2.addActionListener(act2[0]);
					answer3.addActionListener(act3[0]);
					answer4.addActionListener(act4[0]);
					repaint();
				}
				else{
					LearnWordMenu frame;
					try {
						frame = new LearnWordMenu(count);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		revalidate();
		repaint();
	}

	public ArrayList<Dickt> random_answers(ArrayList<Dickt> dictionary){
		ArrayList<Dickt> arr = new ArrayList<Dickt>();
		for(int i =0; i<3;i++){
			while(true){
				int j=0;
				Dickt d = dictionary.get(random.nextInt(dictionary.size()));
				for(int k =0; k<arr.size();k++){
					if (d.word == word.word) j++;
				}
				if (j==0){
					arr.add(d);
					break;
				}
			}
		}
		return arr;
	}

	public JButton make_answer_button(String button_name, int y){
		Font font = new Font("Verdana", Font.PLAIN, 20);
		JButton answer = new JButton(button_name);
		answer.setBackground(Color.white);
		answer.setFont(font);
		add(answer).setBounds(140, y, 250, 40);

		answer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				question.setVisible(false);
				Font font = new Font("Verdana", Font.PLAIN, 23);
				labelTitle.setFont(font);
				labelTitle.setText(word.trans1);
				if (answer.getText() != word.trans1){
					colorR = true;
					colorG = false;
				}
				else{
					colorR = false;
					colorG = true;
					count ++;
				}
				act1 = answer1.getActionListeners();
				answer1.removeActionListener(act1[0]);
				act2 = answer2.getActionListeners();
				answer2.removeActionListener(act2[0]);
				act3 = answer3.getActionListeners();
				answer3.removeActionListener(act3[0]);
				act4 = answer4.getActionListeners();
				answer4.removeActionListener(act4[0]);
				repaint();
			}
		});
		return answer;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g; 
		g2.setStroke(new BasicStroke(4.0f));
		g.setColor(Color.WHITE);
		g.fillRect(90, 70, 350, 300);
		if (colorG == true){
			g.setColor(Color.GREEN);
			g.drawRect(88, 68, 353, 303);
		}
		if (colorR == true){
			g.setColor(Color.RED);
			g.drawRect(88, 68, 353, 303);
		}
	}
}