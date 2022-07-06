package graphics;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Image;
import java.awt.SystemColor;

class PersonalCard extends JFrame {
	
	private int _width = 700;
	
	private int _height = 400;
	
	public PersonalCard() {
	
		this.onInit();
	}
	
	private void onInit() {

		Toolkit deviceScreen = Toolkit.getDefaultToolkit();
		  
		Dimension screenSize = deviceScreen.getScreenSize();
	  
		setTitle("Personal Card");
	  
		setSize(this._width, this._height);
	  
		setLocation((screenSize.width - this._width) / 2, (screenSize.height - this._height) / 2);
	  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
		setResizable(false);
		
		// Icon 
		Image icon = Toolkit.getDefaultToolkit().getImage("src/graphics/img/icon.png");
		  
		setIconImage(icon);
		
		// Canva
		Canva myCanva = new Canva();

		add(myCanva);
		
	}
	
	public void showCard() {
		
		this.setVisible(true);
	}
}
