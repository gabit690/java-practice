package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canva extends JPanel {
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;
		
		try {
			
			File filePath = new File("src/graphics/img/profilePhoto.png");
			
			Image image = ImageIO.read(filePath);
			
			g2.drawImage(image, 40, 25, 202, 202, null);
			
			g2.setStroke(new BasicStroke(4));
			
			g2.setColor(new Color(173, 181, 189));
			
			g2.draw(new Ellipse2D.Double(34, 18, 214, 214));
			
		} catch(IOException e) {
			
			System.out.println("Image does not exist.");
		}
		
		this.addName("Valeriano, Juan Gabriel", g2);
		
		this.addProfession("Software developer", g2);
		
		this.addAddress("Flores, CABA", g2);
		
		// SOCIAL INFO
		
		this.addMailInfo("jgvaleriano690@gmail.com", g2);
		
		this.addPhoneInfo("1140500656", g2);
		
		this.addPortfolioInfo("portfolio-gabit.netlify.app", g2);
		
		this.addGithubInfo("github.com/gabit690", g2);
		
		this.addLinkedinInfo("linkedin.com/in/jg-valeriano", g2);
	}
	
	private void addName(String name, Graphics2D g2) {
		
		g2.setFont(new Font("Arial", Font.BOLD, 20));
		
		g2.setColor(Color.BLACK);
		
		g2.drawString(name, 32, 265);
	}
	
	private void addProfession(String profession, Graphics2D g2) {
		
		g2.setFont(new Font("Arial", Font.ITALIC, 16));
		
		g2.setColor(Color.BLACK);
		
		g2.drawString(profession, 74, 295);
	}
	
	private void addAddress(String address, Graphics2D g2) {
		
		try {
			
			File filePath = new File("src/graphics/img/markIcon.png");
			
			Image image = ImageIO.read(filePath);
			
			g2.drawImage(image, 70, 312, 20, 35, null);
			
		} catch(IOException e) {
			
			System.out.println("Image does not exist.");
		}
		
		g2.setFont(new Font("Arial", Font.PLAIN, 18));
		
		g2.setColor(Color.BLACK);
		
		g2.drawString(address, 105, 335);
	}
	
	private void addMailInfo(String mail, Graphics2D g2) {
		
		this.drawLabelContainer(mail, new ShapeColor(Color.WHITE, new Color(134, 136, 138)), new Point(350, 25), g2);
		
		this.drawIconContainer("src/graphics/img/mailIcon.png", new ShapeColor(new Color(234, 67, 53), new Color(187, 0, 27)), new Point(290, 10), g2);
	}
	
	private void addPhoneInfo(String phone, Graphics2D g2) {
		
		this.drawLabelContainer(phone, new ShapeColor(Color.WHITE, new Color(134, 136, 138)), new Point(350, 95), g2);
		
		this.drawIconContainer("src/graphics/img/phoneIcon.png", new ShapeColor(new Color(32, 201, 151), new Color(25, 135, 84)), new Point(290, 80), g2);	
	}
	
	private void addPortfolioInfo(String url, Graphics2D g2) {
		
		this.drawLabelContainer(url, new ShapeColor(Color.WHITE, new Color(134, 136, 138)), new Point(350, 165), g2);
		
		this.drawIconContainer("src/graphics/img/portfolioIcon.png", new ShapeColor(new Color(173, 181, 189), Color.BLACK), new Point(290, 150), g2);
	}
	
	private void addGithubInfo(String url, Graphics2D g2) {
		
		this.drawLabelContainer(url, new ShapeColor(Color.WHITE, new Color(134, 136, 138)), new Point(350, 235), g2);
		
		this.drawIconContainer("src/graphics/img/githubIcon.png", new ShapeColor(new Color(158, 123, 181), new Color(110, 84, 148)), new Point(290, 220), g2);
	}
	
	private void addLinkedinInfo(String url, Graphics2D g2) {
		
		this.drawLabelContainer(url, new ShapeColor(Color.WHITE, new Color(134, 136, 138)), new Point(350, 305), g2);
		
		this.drawIconContainer("src/graphics/img/linkedinIcon.png", new ShapeColor(new Color(0, 119, 181), new Color(0, 160, 220)), new Point(290, 290), g2);
	}
	
	private GeneralPath createPolygon(Point[] points) {
		
		int pairsOfPoints = points.length;
		
		GeneralPath polygon = new GeneralPath();
		
		polygon.moveTo(points[0].getX(), points[0].getY());
		
		for(int index = 1; index < pairsOfPoints; index++) {
			
			polygon.lineTo(points[index].getX(), points[index].getY());
		}
		
		return polygon;
	}
	
	private void drawIconContainer(String iconPath, ShapeColor colors, Point position, Graphics2D g2) {
		
		Point[] points = this.basicOctagonPoints((int)position.getX(), (int)position.getY());
			
		GeneralPath polygon = this.createPolygon(points);
		
		this.paintPolygonalContainer(polygon, colors, g2);
		
		this.paintPolygonalContainerIcon(iconPath, new Point((int)position.getX() + 15, (int)position.getY() + 15), g2);
	}
	
	private Point[] basicOctagonPoints(int positionX, int positionY) {
		
		Point[] points = {
				new Point(positionX += 15, positionY),
				new Point(positionX += 30, positionY),
				new Point(positionX += 15, positionY += 15),
				new Point(positionX, positionY += 30),
				new Point(positionX -= 15, positionY += 15),
				new Point(positionX -= 30, positionY),
				new Point(positionX -= 15, positionY -= 15),
				new Point(positionX, positionY -= 30),
				new Point(positionX += 15, positionY -= 15)
			};
		
		return points;
	}
	
	private void paintPolygonalContainer(GeneralPath shape, ShapeColor colors, Graphics2D g2) {
		
		g2.setColor(colors.getInner());
		
		g2.fill(shape);
		
		g2.setColor(colors.getOuter());
		
		g2.draw(shape);
	}
	
	private void paintPolygonalContainerIcon(String path, Point position, Graphics2D g2) {
		
		try {
			
			File filePath = new File(path);
			
			Image image = ImageIO.read(filePath);
			
			g2.drawImage(image, (int)position.getX(), (int)position.getY(), 30, 30, null);
			
		} catch(IOException e) {
			
			System.out.println("Image does not exist.");
		}
	}
	
	private void drawLabelContainer(String content, ShapeColor colors, Point position, Graphics2D g2) {
		
		Point[] points = this.basicLabelPoints((int)position.getX(), (int)position.getY());
		
		GeneralPath polygon = this.createPolygon(points);
		
		this.paintPolygonalContainer(polygon, colors, g2);
		
		int halfOfContainer = 150;
		
		Point textPosition = new Point((int)position.getX() + halfOfContainer - (g2.getFontMetrics().stringWidth(content) / 2), (int)position.getY() + 23);
		
		this.paintPolygonalContainerText(content, new FontStyle("Arial", Font.PLAIN, 20, Color.BLACK), textPosition, g2);
	}
	
	private Point[] basicLabelPoints(int positionX, int positionY) {
		
		Point[] points = {
				new Point(positionX, positionY),
				new Point(positionX += 300, positionY),
				new Point(positionX += 10, positionY += 15),
				new Point(positionX -= 10, positionY += 15),
				new Point(positionX -= 300, positionY)
			};
		
		return points;
	}
	
	private void paintPolygonalContainerText(String content, FontStyle styles, Point position, Graphics2D g2) {
		
		g2.setFont(new Font(styles.getName(), styles.getStyle(), styles.getSize()));
		
		g2.setColor(styles.getColor());
		
		g2.drawString(content, (int)position.getX(), (int)position.getY());
	}
}
