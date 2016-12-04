package nanoEnglish;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class LevelTest extends JFrame{

 public LevelTest() throws ClassNotFoundException{
  setSize(550,730);
  Container contentPane = getContentPane();
  LevelTestPanel panel = new LevelTestPanel();
  panel.setBackground(new Color(255,  218,  185));//������
  //panel.setBackground(new Color(255,  250,  205));//�����-����
  //panel.setBackground(new Color(199,  252,  236));//�������
  //panel.setBackground(new Color(216,  191,  216));//����������
  contentPane.add(panel);
 }
}
class LevelTestPanel extends JPanel{
 
 static JFrame frame2;
 JFrame newFrame;
 private BufferedImage speak;
 private BufferedImage read;
 private BufferedImage write;
 private BufferedImage listen;
 private BufferedImage vocabulary;
 private String s="������";
 private String sa="Pictures/speak.jpg";
 private String pic="Pictures/write.jpg";
 private String B1 ="����� � �������� ������������ \n"
                       + "�� ����� ����";
 static int low;
 static int middle;
 static int high;
 
public LevelTestPanel(){
 setLayout(null); 
 try {               
        speak = ImageIO.read(new File("Pictures/speak.jpg"));
        write = ImageIO.read(new File("Pictures/write.jpg"));
        read = ImageIO.read(new File("Pictures/read.jpg"));
        listen = ImageIO.read(new File("Pictures/listen.jpg"));
        vocabulary = ImageIO.read(new File("Pictures/vocabulary.jpg"));
     } catch (IOException ex) {}
 
 JRadioButton Button1 = new JRadioButton("�� ���� ��������, �� ���� ��������� ���� ���� � ����");
 JRadioButton Button2 = new JRadioButton("� ��������, �� ������ �� ����� ����");
 JRadioButton Button3 = new JRadioButton(B1);//
 
 JRadioButton Button4 = new JRadioButton("�� ���� ������, ��� ���� �������� ��������� ���� � ����");
 JRadioButton Button5 = new JRadioButton("��������� ������� ���� ������� ������, ������� � �����");
 JRadioButton Button6 = new JRadioButton("�������� � �������� ���� ������ ��������� ������");//
 
 JRadioButton Button7 = new JRadioButton("�� ���� ������ ��� ����� ��������� ���� � ����");
 JRadioButton Button8 = new JRadioButton("����� �� ������ ������� ������ � ������");
 JRadioButton Button9 = new JRadioButton("�������� ����� ����� ���������� � ���������");//
 
 JRadioButton Button10 = new JRadioButton("�� ������� �� ���� ��� ������� ���� �������� �����");
 JRadioButton Button11 = new JRadioButton("������� ���� �� ����� ����, ����� ����� �����, �� �������� ���");
 JRadioButton Button12 = new JRadioButton("�������� ������� ���� �������� ����� ");//
 
 JRadioButton Button13 = new JRadioButton("���� ����� ��������� ���������� ����");
 JRadioButton Button14 = new JRadioButton("���� ���������� ���� ��� �� �������� �� ����� ����");
 JRadioButton Button15 = new JRadioButton("���� ����� ����, � ��� ����� �� ����������� �������� � �����");//
 
 
 Button1.setBackground(new Color(255,  218,  185));
 Button2.setBackground(new Color(255,  218,  185));
 Button3.setBackground(new Color(255,  218,  185));
 Button4.setBackground(new Color(255,  218,  185));
 Button5.setBackground(new Color(255,  218,  185));
 Button6.setBackground(new Color(255,  218,  185));
 Button7.setBackground(new Color(255,  218,  185));
 Button8.setBackground(new Color(255,  218,  185));
 Button9.setBackground(new Color(255,  218,  185));
 Button10.setBackground(new Color(255,  218,  185));
 Button11.setBackground(new Color(255,  218,  185));
 Button12.setBackground(new Color(255,  218,  185));
 Button13.setBackground(new Color(255,  218,  185));
 Button14.setBackground(new Color(255,  218,  185));
 Button15.setBackground(new Color(255,  218,  185));
 
 Button1.setFocusPainted(false);
 Button4.setFocusPainted(false);
 Button7.setFocusPainted(false);
 Button10.setFocusPainted(false);
 Button13.setFocusPainted(false);
 
 Font font = new Font("Verdana", Font.PLAIN, 14); 
 Font font1 = new Font("Verdana", Font.PLAIN, 12); 
 Button1.setFont(font);
 Button2.setFont(font);
 Button3.setFont(font);
 Button4.setFont(font1);
 Button5.setFont(font1);
 Button6.setFont(font1);
 Button7.setFont(font);
 Button8.setFont(font);
 Button9.setFont(font);
 Button10.setFont(font1);
 Button11.setFont(font1);
 Button12.setFont(font1);
 Button13.setFont(font1);
 Button14.setFont(font1);
 Button15.setFont(font1);
 
 add(Button1).setBounds(30,405,450,50);
 add(Button2).setBounds(30,465,450,50);
 add(Button3).setBounds(30,525,450,50);
 
 add(Button4).setBounds(30,405,450,50);
 add(Button5).setBounds(30,465,450,50);
 add(Button6).setBounds(30,525,450,50);
 
 add(Button7).setBounds(30,405,450,50);
 add(Button8).setBounds(30,465,450,50);
 add(Button9).setBounds(30,525,450,50);
 
 add(Button10).setBounds(30,405,450,50);
 add(Button11).setBounds(30,465,450,50);
 add(Button12).setBounds(30,525,450,50);
 
 add(Button13).setBounds(30,405,450,50);
 add(Button14).setBounds(30,465,450,50);
 add(Button15).setBounds(30,525,450,50);
 
 Button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button1.setSelected(true);
         Button2.setSelected(false);
         Button3.setSelected(false);
        }
    });
 Button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button1.setSelected(false);
         Button2.setSelected(true);
         Button3.setSelected(false);
        }
    });
 
 Button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button1.setSelected(false);
         Button2.setSelected(false);
         Button3.setSelected(true);
        }
    });
 
 Button4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button4.setSelected(true);
         Button5.setSelected(false);
         Button6.setSelected(false);
        }
    });
 Button5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button4.setSelected(false);
         Button5.setSelected(true);
         Button6.setSelected(false);
        }
    });
 
 Button6.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button4.setSelected(false);
         Button5.setSelected(false);
         Button6.setSelected(true);
        }
    });
 
 Button7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button7.setSelected(true);
         Button8.setSelected(false);
         Button9.setSelected(false);
        }
    });
 Button8.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button7.setSelected(false);
         Button8.setSelected(true);
         Button9.setSelected(false);
        }
    });
 
 Button9.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button7.setSelected(false);
         Button8.setSelected(false);
         Button9.setSelected(true);
        }
    });
 
 Button10.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button10.setSelected(true);
         Button11.setSelected(false);
         Button12.setSelected(false);
        }
    });
 Button11.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button10.setSelected(false);
         Button11.setSelected(true);
         Button12.setSelected(false);
        }
    });
 
 Button12.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button10.setSelected(false);
         Button11.setSelected(false);
         Button12.setSelected(true);
        }
    });
 
 Button13.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button13.setSelected(true);
         Button14.setSelected(false);
         Button15.setSelected(false);
        }
    });
 Button14.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button13.setSelected(false);
         Button14.setSelected(true);
         Button15.setSelected(false);
        }
    });
 
 Button15.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         Button13.setSelected(false);
         Button14.setSelected(false);
         Button15.setSelected(true);
        }
    });
 
 JButton nextButton = new JButton("NEXT");
 add(nextButton).setBounds(400,640,100,35);
 JButton backButton = new JButton("BACK");
 add(backButton).setBounds(35,640,100,35);
 JButton nextButton1 = new JButton("NEXT");
 add(nextButton1).setBounds(400,640,100,35);
 JButton backButton1 = new JButton("BACK");
 add(backButton1).setBounds(35,640,100,35);
 JButton nextButton2 = new JButton("NEXT");
 add(nextButton2).setBounds(400,640,100,35);
 JButton backButton2 = new JButton("BACK");
 add(backButton2).setBounds(35,640,100,35);
 JButton nextButton3 = new JButton("NEXT");
 add(nextButton3).setBounds(400,640,100,35);
 JButton backButton3 = new JButton("BACK");
 add(backButton3).setBounds(35,640,100,35);
 JButton nextButton4 = new JButton("NEXT");
 add(nextButton4).setBounds(400,640,100,35);
 JButton backButton4 = new JButton("BACK");
 add(backButton4).setBounds(35,640,100,35);
 
 nextButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (Button1.isSelected()==true){
           	 low++;
            }
            if (Button2.isSelected()==true){
           	 middle++;
            }
            if (Button3.isSelected()==true){
           	 high++;
            }
         s="����";
         Button1.setVisible(false);
         Button2.setVisible(false);
         Button3.setVisible(false);
         Button4.setVisible(true);
         Button5.setVisible(true);
         Button6.setVisible(true);
         
         nextButton.setVisible(false);
         nextButton1.setVisible(true);
         backButton.setVisible(false);
         backButton1.setVisible(true);
         
        }
    });
 nextButton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (Button4.isSelected()==true){
           	 low++;
            }
            if (Button5.isSelected()==true){
           	 middle++;
            }
            if (Button6.isSelected()==true){
           	 high++;
            }
         s="�����";
         Button4.setVisible(false);
         Button5.setVisible(false);
         Button6.setVisible(false);
         Button7.setVisible(true);
         Button8.setVisible(true);
         Button9.setVisible(true);
         
         nextButton1.setVisible(false);
         nextButton2.setVisible(true);
         backButton1.setVisible(false);
         backButton2.setVisible(true);
        }
    });
 nextButton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (Button7.isSelected()==true){
           	 low++;
            }
            if (Button8.isSelected()==true){
           	 middle++;
            }
            if (Button9.isSelected()==true){
           	 high++;
            }
         s="������� �� ����";
         Button7.setVisible(false);
         Button8.setVisible(false);
         Button9.setVisible(false);
         Button10.setVisible(true);
         Button11.setVisible(true);
         Button12.setVisible(true);
         
         nextButton2.setVisible(false);
         nextButton3.setVisible(true);
         backButton2.setVisible(false);
         backButton3.setVisible(true);
        }
    });
 nextButton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	if (Button10.isSelected()==true){
           	 low++;
            }
            if (Button11.isSelected()==true){
           	 middle++;
            }
            if (Button12.isSelected()==true){
           	 high++;
            }
         s="���� �����";
         Button10.setVisible(false);
         Button11.setVisible(false);
         Button12.setVisible(false);
         Button13.setVisible(true);
         Button14.setVisible(true);
         Button15.setVisible(true);
         
         nextButton3.setVisible(false);
         nextButton4.setVisible(true);
         backButton3.setVisible(false);
         backButton4.setVisible(true);
        }
    });
 
 nextButton4.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent e) {
		 if (Button13.isSelected()==true){
           	 low++;
            }
            if (Button14.isSelected()==true){
           	 middle++;
            }
            if (Button15.isSelected()==true){
           	 high++;
            } 
            if ((low>=middle)&&(low>high)){
            	LevelResultFrame.level1=1;
            	try{
            	       frame2 = new LevelResultFrame();
            	       
            	       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	       frame2.setVisible(true);
            	       
            	       } catch (ClassNotFoundException e1) {
            	        e1.printStackTrace();
            	       }
            }
            if ((middle>=low)&&(middle>high)){
            	LevelResultFrame.level1=2;
            	try{
            	       frame2 = new LevelResultFrame();
            	       
            	       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	       frame2.setVisible(true);
            	       
            	       } catch (ClassNotFoundException e1) {
            	        e1.printStackTrace();
            	       }
            
            }
            if ((high>=middle)&&(high>low)){
            	LevelResultFrame.level1=3;
            	try{
            	       frame2 = new LevelResultFrame();
            	       
            	       frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	       frame2.setVisible(true);
            	       
            	       } catch (ClassNotFoundException e1) {
            	        e1.printStackTrace();
            	       }
            
            }
            RegistrationPanel.frame1.dispose();
	 }
 });

 backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         JFrame frame;
         RegistrationPanel.frame1.dispose(); 
         try {
    frame = new RegistrationFrame("���� �����������");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
   } catch (ClassNotFoundException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
   
        }
    });
 backButton1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         s="������";
         Button4.setVisible(false);
         Button5.setVisible(false);
         Button6.setVisible(false);
         Button1.setVisible(true);
         Button2.setVisible(true);
         Button3.setVisible(true);
         
         nextButton1.setVisible(false);
         nextButton.setVisible(true);
         backButton1.setVisible(false);
         backButton.setVisible(true);
         
        }
    });
 backButton2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         s="����";
         Button7.setVisible(false);
         Button8.setVisible(false);
         Button9.setVisible(false);
         Button4.setVisible(true);
         Button5.setVisible(true);
         Button6.setVisible(true);
         
         nextButton2.setVisible(false);
         nextButton1.setVisible(true);
         backButton2.setVisible(false);
         backButton1.setVisible(true);
        }
    });
 backButton3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         s="�����";
         Button10.setVisible(false);
         Button11.setVisible(false);
         Button12.setVisible(false);
         Button7.setVisible(true);
         Button8.setVisible(true);
         Button9.setVisible(true);
         
         nextButton3.setVisible(false);
         nextButton2.setVisible(true);
         backButton3.setVisible(false);
         backButton2.setVisible(true);
        }
    });
 backButton4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         s="������� �� ����";
         Button13.setVisible(false);
         Button14.setVisible(false);
         Button15.setVisible(false);
         Button10.setVisible(true);
         Button11.setVisible(true);
         Button12.setVisible(true);
         
         nextButton4.setVisible(false);
         nextButton3.setVisible(true);
         backButton4.setVisible(false);
         backButton3.setVisible(true);
         RegistrationPanel.frame1.dispose(); 
   try{
   newFrame = new LevelTest();
   newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   newFrame.setVisible(true);
   
   } catch (ClassNotFoundException e1) {
    e1.printStackTrace();
   }
        }
    });
 
}

public void paint(Graphics g){
 super.paint(g);
 Font font = new Font("Verdana", Font.BOLD, 16); 
 g.setFont(font);
 if (s=="������� �� ����" || s=="���� �����"){
  g.drawString(s, 200, 375);
 }
 else{
 g.drawString(s, 235, 375);
 }
    font = new Font("Verdana", Font.BOLD, 16); 
 g.setFont(font);
 g.drawString("������� ���� ������ �����", 131, 50);
 repaint();
}

public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
 g2.setStroke(new BasicStroke(3.0f));
    g.setColor(Color.BLACK); 
    g.drawOval(144, 80, 253, 253);
    g.setColor(Color.white);
    g.fillOval(144, 80, 253, 253);
    g.drawImage(write, 183, 125, 175, 175, this);
    g.drawImage(speak, 183, 125, 175, 175, this);
    
}
}

