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

public class PlaneGUI extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4978872754690496467L;

	BufferedImage image;
	
	String path = "C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\unnamed.png";
	
	public PlaneGUI(){
		
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
	 	double width = (double) getPreferredSize().getWidth()/2;
	 	double height = (double) getPreferredSize().getHeight()/2;

	 	
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Setup.planes.get(2).getPlaneDirection(),width,height);						// todo: setPlaneDirection Setup.planes.get(0).getPlaneDirection();
        g2d.drawImage(image,0,0,this);
        
     //  System.out.println(""+ setPlaneDirection()+ " "+ Math.toDegrees(setPlaneDirection()));
    //  System.out.println(width+ " " + height);
       
      //  super.paintComponent(g);
}

/*
public double setPlaneDirection(){
	
	int x1 = Setup.landings[0].id;
	int y1 = Setup.yParam[2];
	
	int x2 = Setup.xParam[25];
	int y2 = Setup.yParam[25];
	
	double x = (double)Math.abs(x2-x1);
	double y = (double)Math.abs(y2-y1);
	
	System.out.println(x+","+y);
	double alpha = Math.atan(y/x);
	return alpha;
}
*/
}
