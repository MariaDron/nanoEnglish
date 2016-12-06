package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.swing.*;

public class ReadingMaterialsFrame extends JFrame{
	public ReadingMaterialsFrame() throws ClassNotFoundException{
		setSize(550,730);
		ReadingMaterialsPanel panel = new ReadingMaterialsPanel(1);
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane).setBounds(0, 0, 550, 730);;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					ReadingMaterialsFrame frame = new ReadingMaterialsFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class ReadingMaterialsPanel extends JPanel{
	String filename_level1[] = {"Christmas Cards", "Hit the Floor!", "Learning foreign languages", "The jackal and the elephant", "Traveling around the USA"};
	String filename_level2[] = {};
	String filename_level3[] = {};
	int y;
	int level;

	public ReadingMaterialsPanel(int level) throws ClassNotFoundException{
		
		setLayout(null);
		setPreferredSize(new Dimension(550, 2660));
		setBackground(new Color(123,31,31));
		y = 20;
		if (level==1){
			for (int i=0; i<5; i++){
				addText(filename_level1[i],y);
				
				y = y+280;
				
			}
		}
		if (level==2){
			for (int i=0; i<filename_level2.length; i++){
				addText(filename_level2[i],y);
				repaint();
				y = y+280;
			}
		}
		if (level==3){
			for (int i=0; i<filename_level3.length; i++){
				addText(filename_level3[i],y);
				repaint();
				y = y+280;
			}
		}
	}
	
	public void addText(String filename, int y) throws ClassNotFoundException{
		repaint();
		JLabel labelTitle = new JLabel(filename);
		//labelTitle.setVerticalAlignment(JLabel.TOP);
		labelTitle.setHorizontalAlignment(JLabel.CENTER);
		labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
		labelTitle.setBackground(Color.white);
		add(labelTitle).setBounds(0,y+10,550,40);
		
	/*	String text = reading(filename+".txt");
		JTextArea textArea = new JTextArea(text);
        textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
		add(textArea).setBounds(45,y+25,440,150);*/
        
		ImageIcon icon = new ImageIcon("next.png");
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		JButton button = new JButton(icon);
		button.setBackground(new Color(210,149,149));
		add(button).setBounds(500,y+225,30,30);
		
	}
	
	public String reading (String filename) throws ClassNotFoundException{
		String text = "";
		try {
            FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
            	text = text + line;
                line = reader.readLine();
            }
            reader.close();
        } 
		catch (FileNotFoundException e) {} 
		catch (IOException e) {}
		return text;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(20, y, 480, 260);
		g.setColor(new Color(210,149,149));
		g.fillRect(20, y+220, 480, 40);
	}
}