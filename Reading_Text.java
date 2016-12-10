package nanoEnglish;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class Reading_Text extends JFrame{
		public Reading_Text(String text, String name){
			setSize(550,730);
			Reading_TextPanel panel = new Reading_TextPanel(text, name);			
			add(panel).setBounds(0, 0, 550, 730);
		}
	}

	class Reading_TextPanel extends JPanel{

		public Reading_TextPanel(String text, String name){
			setLayout(null);
			setBackground(new Color(232,202,217));
			
			JLabel labelTitle = new JLabel(name);
			labelTitle.setHorizontalAlignment(JLabel.CENTER);
			labelTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
			labelTitle.setBackground(Color.white);
			add(labelTitle).setBounds(0,7,550,40);
			
			JTextArea textArea = new JTextArea(text); //JTextPane
			textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 14));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			add(scrollPane).setBounds(10,60,515,622);
			
			ImageIcon icon = new ImageIcon("prev.png");
			Image img = icon.getImage() ;  
			Image newimg = img.getScaledInstance( 60, 55,  java.awt.Image.SCALE_SMOOTH ) ;  
			icon = new ImageIcon( newimg );
			JButton prev = new JButton(icon);
			prev.setBackground(new Color(157,111,135));
			add(prev).setBounds(7,5,50,40);
			
			prev.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(157,111,135));
			g.fillRect(0, 0, 550, 50);
		}
	}