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
		
		ImageIcon icon = new ImageIcon("Image/prev.png");
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
		
		
		
		//LevelResultPanel.dictionary
		JTextArea textArea = new JTextArea(); //JTextPane
		textArea.setFont(new Font("Dialog", Font.BOLD, 14));//ROMAN_BASELINE
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(224,232,245));
		JScrollPane scrollPane = new JScrollPane(textArea);
		//scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//add(scrollPane).setBounds(20,80,492,593);
		add(scrollPane).setBounds(0,60,533,635);
		String t = " \n";
		String s = "";
		
				try {
					File file = new File("FirstLevelDictionary.txt");
			        FileReader fr;
			        fr = new FileReader(file);
	                BufferedReader reader = new BufferedReader(fr);
	        /*String line = reader.readLine();
	        t=t+line+"\n";
	        textArea.setText(t);*/
	        String line3;
            int x=0;
           while (( line3 = reader.readLine()) != null) {
           // for (int j=0; j<9;j++){
            //line3 = reader.readLine();
            	String[] words = line3.split("@");
            	/*for(int i=0;i<1;i++){
            		t=t+words[i]+"\n";
            	}*/
            	//s=words[0];//+words[1];
            	t=t+"    "+words[1]+"\n";
            	t=t+"    "+words[2]+"\n";
            	t=t+"________________________________________________________________ \n";
            }
           textArea.setText(t);
            line3 = reader.readLine();  
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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
		
		JLabel labelTitle = new JLabel("");         ///!!!!!!!!!!!!!!!!!!!
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
		
		JButton myDictionary = new JButton("Мой словарь");  ///!!!!!!!!!!!!!!!!!!!
		JButton dontKnow = new JButton("Неизученные слова");///!!!!!!!!!!!!!!!!!!!
		JButton alreadyKnow = new JButton("Изученные слова");///!!!!!!!!!!!!!!!!!!!
		
		/*myDictionary.setFont(new Font("Verdana", Font.BOLD, 10));
		dontKnow.setFont(new Font("Verdana", Font.BOLD, 10));
		alreadyKnow.setFont(new Font("Verdana", Font.BOLD, 10));*/
		
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
