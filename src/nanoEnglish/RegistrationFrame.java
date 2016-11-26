package nanoEnglish;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RegistrationFrame extends JFrame{

	public RegistrationFrame() throws ClassNotFoundException{
		setSize(550,700);
		Container contentPane = getContentPane();
		RegistrationPanel panel = new RegistrationPanel();
		contentPane.add(panel);
	}
}

class RegistrationPanel extends JPanel{
	
	private BufferedImage image;
	
	public RegistrationPanel(){
		try {                
	          image = ImageIO.read(new File("background.png"));
	       } catch (IOException ex) {}
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 550, 700, this);
    }
}
