package pl.edu.wat.wcy.pz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Plane extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978872754690496467L;

	BufferedImage image;
	
	String path = "C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\unnamed.png";
	
	public Plane(){
		
		super();
		setLayout(null);
		
		File imageFile = new File(path);
	        
	        try{
	                image = ImageIO.read(imageFile);
	                
	                ImageIcon imgIcon = new ImageIcon(image);
	               setIcon(imgIcon);
	                
	        }catch (IOException e) {
	                
	                System.err.println("Nie mozna otworzyc obrazka");
	                e.printStackTrace();
	        }
	        
	        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
	        setPreferredSize(dimension);
	}

public void paintComponent(Graphics g){
	 	int width = getWidth() /5;
	 	int height = getHeight() /5;
	 	
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.PI / 1, width, height);
        g2d.drawImage(image,0,0,this);
        
       
       
       // super.paintComponent(g);
}
}
