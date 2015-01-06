package pl.edu.wat.wcy.pz;

import javax.swing.JFrame;
import java.awt.event.*;

public class Gui {

	JFrame frame = new JFrame("Firma lotnicza - projekt - Mateusz Lagod I2A3S1");
	
	Background background = new Background();
	
	Handler handler = new Handler();
	
	PlaneGUI plane = new PlaneGUI(0);
	
	
	//Landings landings = new Landings();
	
	
	public void setup(){
		
		frame.setSize(1200,860);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.add(background);
		
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
	
	public void setPlanes(){	// nie dziala z niewiadomych przyczyn cos nie tak z planesGUI
		
		for(int i = 0; i < Setup.planesGUI.size(); i++){
			
		//	Setup.setupPlanes();
			Setup.planesGUI.get(i).setBounds(Setup.planes.get(i).getXPosition(), Setup.planes.get(i).getYPosition(), 100, 100);
			background.add(Setup.planesGUI.get(i));
			
		}
		
	}
}
