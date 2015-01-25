package pl.edu.wat.wcy.pz;

import java.awt.EventQueue;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s;
		GetProperties p = new GetProperties();
		try {
			Database.connection += p.getValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
