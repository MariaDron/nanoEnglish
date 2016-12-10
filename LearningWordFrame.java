package nanoEnglish;

import java.awt.*;
import javax.swing.*;

public class LearningWordFrame extends JFrame{
	public LearningWordFrame() {
		setSize(550,730);
		Container contentPane = getContentPane();
		MenuPanel panel = new MenuPanel();
		contentPane.add(panel);
	}
}

class LearningWordPanel extends JPanel{
	public LearningWordPanel(){
		
	}
}
