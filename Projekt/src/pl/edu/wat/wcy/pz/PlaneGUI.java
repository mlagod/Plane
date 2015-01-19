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
	
	protected int idInList;
	
	//static int x = 100;
	//static int y = 100;
	
	String path = "C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\unnamed.png";
	
	public PlaneGUI(int _idInList){
		
		super();
		setLayout(null);
		
		File imageFile = new File(path);
	        
		idInList = _idInList;
		
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
	        
	     //   setBounds(Setup.planes.get(0).getXPosition(), Setup.planes.get(0).getYPosition(), 100, 100);
	       // setBounds(x,y,100,100);
	   //     System.out.println("X = " + x + " Y = " + y + " id in list = " + idInList);
	     //   x +=100;
	     //   y += 100;
	}

public void paintComponent(Graphics g){
	 	double width = (double) getPreferredSize().getWidth()/2;
	 	double height = (double) getPreferredSize().getHeight()/2;

	 	
	 	
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Setup.planes.get(idInList).getPlaneDirection(),width,height);
       // setBounds(Setup.planes.get(idInList).getXPosition(), Setup.planes.get(idInList).getYPosition(), 100, 100);
     //   super.paintComponent(g);
        updatePosition();
        g2d.drawImage(image,0,0,this);
        
        
        
     //  System.out.println("PlaneGUI"+Setup.planes.get(0).getXPosition()+" " + Setup.planes.get(0).getYPosition());
        
     //  System.out.println(""+ setPlaneDirection()+ " "+ Math.toDegrees(setPlaneDirection()));
    //  System.out.println(width+ " " + height);
       
        
}


public void updatePosition(){
	
	setBounds(Setup.planes.get(idInList).getXPosition(), Setup.planes.get(idInList).getYPosition(), 100, 100);

}

}
