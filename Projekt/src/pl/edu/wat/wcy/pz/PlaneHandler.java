package pl.edu.wat.wcy.pz;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class PlaneHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();	
		
		
		for(int i = 0; i < Setup.planesGUI.size(); i++){
			
		
		if(o == Setup.planesGUI.get(i)){
			
			
		Database.planeId = "" + Setup.planes.get(i).getPlaneId() ;
		Database.planeIdInList =  Setup.planes.get(i).getIdInList();
		System.out.println("samolot " + Setup.planes.get(i).getPlaneId());
		
		}
		}
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				new PlaneInfoGui();
			
				
			}
			
		});
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
