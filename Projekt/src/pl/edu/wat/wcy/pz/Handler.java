package pl.edu.wat.wcy.pz;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

public class Handler implements MouseListener{

	int portId;
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		Object o = e.getSource();	
		
		
		for(int i = 0; i < 26; i++){
			
		
		if(o == Setup.landings[i]){
			
		Database.cityId = "" + Setup.landings[i].id ;
		System.out.println(Database.cityId);
		
		}
		}
		SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				
				new Infogui();
				
			}
			
		});
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
