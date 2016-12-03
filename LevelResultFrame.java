package nanoEnglish;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class LevelResultFrame extends JFrame{

	public LevelResultFrame() throws ClassNotFoundException{
		setSize(550,730);
		Container contentPane = getContentPane();
		LevelResultPanel panel = new LevelResultPanel(2);
		contentPane.add(panel);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					LevelResultFrame frame = new LevelResultFrame();
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}
}

class LevelResultPanel extends JPanel{
	
	String text_lev1 = "Вам придется хорошо поработать над собой и своими знаниями";
	String text_lev2 = "Вам необходимо улучшить уровень знания английского языка";
	String text_lev3 = "Вы хорошо знаете английский язык, но практика никогда не бывает лишней";
	
	public LevelResultPanel(int level){
		setLayout(null);
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
		textArea.setBackground(Color.pink);
        textArea.setFont(new Font("Dialog", Font.ROMAN_BASELINE, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
		add(textArea).setBounds(150,405,230,115);
		
		JButton ok = new JButton("Перейти к обучению");
		ok.setForeground(Color.black);
		ok.setBackground(Color.MAGENTA);
		add(ok).setBounds(165, 560, 200, 50);
		
		if (level == 1) {
			res.setText("Низкий");
			textArea.setText(text_lev1);
		}
		if (level == 2) {
			res.setText("Средний");
			textArea.setText(text_lev2);
		}
		if (level == 3) {
			res.setText("Высокий");
			textArea.setText(text_lev3);
		}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.pink);
        g.fillRect(60, 60, 410, 575);
        g.setColor(Color.white);
        g.fillOval(105, 140, 80, 80);
        g.fillOval(225, 140, 80, 80);
        g.fillOval(345, 140, 80, 80);
        g.setColor(Color.black);
        g.drawRect(125, 390, 280, 145);
        g.setColor(Color.pink);
        g.fillRect(126, 391, 279, 144);
    }
}
