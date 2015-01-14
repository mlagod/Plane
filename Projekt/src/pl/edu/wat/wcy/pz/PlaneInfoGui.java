package pl.edu.wat.wcy.pz;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlaneInfoGui extends JFrame{

	JLabel[] attributes = new JLabel[4];
	
	public PlaneInfoGui(){
		
		setTitle("Informacja o samolocie");
		setSize(300,130);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
