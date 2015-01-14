package pl.edu.wat.wcy.pz;

import java.awt.EventQueue;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 EventQueue.invokeLater(new Runnable()
	        {
	            public void run()
	            {
	            		
	            	
	        		
		Gui gui = new Gui();
		gui.setup();
		
		Flies f = new Flies();
		f.getFlies();
		
		gui.setPlanes();
		//Database database = new Database();
		//database.setConnection();
		 System.out.println(Setup.planes.size());
		 System.out.println("planesGUI = "+Setup.planesGUI.size());
		 
		 for(int i = 0; i < Setup.planes.size(); i++){
		 Setup.planes.get(i).start();
		 }
	            }
	        });
		 
		
	}

}
