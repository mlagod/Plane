package pl.edu.wat.wcy.pz;

import javax.swing.JFrame;
import java.awt.event.*;

public class Gui {

	JFrame frame = new JFrame("Firma lotnicza - projekt - Mateusz Lagod I2A3S1");
	
	Background background = new Background();
	
	Handler handler = new Handler();
	
	Plane plane = new Plane();
	
	//Landings landings = new Landings();
	
	
	public void setup(){
		
		frame.setSize(1200,860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.add(background);
		background.add(plane);
		plane.setBounds(100,100,100,100);
		plane.setBounds(300, 300, 100, 100);
		setLandings();
		frame.setVisible(true);
	}
	
	private void setLandings(){
		
		
		Setup.setupLandings();

		for(int i = 0; i < 26; i++){
			Setup.landings[i].setBounds(Setup.landings[i].x, Setup.landings[i].y, 20, 20);
			
		background.add(Setup.landings[i]);
		
		}
	}
}
