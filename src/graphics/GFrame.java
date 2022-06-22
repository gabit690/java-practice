package graphics;

import javax.swing.JFrame;

import java.awt.Toolkit;

import java.awt.Dimension;

import java.awt.Image;

public class GFrame {
	
  public static void main(String[] args) {
    
	Canva myFrame = new Canva();
	
	myFrame.setVisible(true);
  }
}

class Canva extends JFrame {
	
	public Canva() {
		
	  Toolkit deviceScreen = Toolkit.getDefaultToolkit();
	  
	  Dimension screenSize = deviceScreen.getScreenSize();
	  
	  int width = screenSize.width;
	  
	  int height = screenSize.height;
	  
	  setBounds(width / 4, height / 4, width / 2, height / 2);
	  
	  setTitle("Presentation");
	  
	  Image icon = deviceScreen.getImage("src/graphics/icon.png");
	  
	  setIconImage(icon);
	}
}