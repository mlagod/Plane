package pl.edu.wat.wcy.pz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 154975759789328192L;

	BufferedImage image;
	
	String path = "C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\map_of_europe.jpg";
	
	public Background(){
        
        super();
        setLayout(null);
        File imageFile = new File(path);
        
        try{
                image = ImageIO.read(imageFile);
                
        }catch (IOException e) {
                
                System.err.println("Nie mozna otworzyc obrazka");
                e.printStackTrace();
        }
        
        Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
        setPreferredSize(dimension);
}


public void paintComponent(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image,0,0,this);
}
}
