package pl.edu.wat.wcy.pz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Infogui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4959975175429986171L;

	Database database = new Database();
	
	JLabel[] atributes = new JLabel[3];  // przechowuje labelki do wyswietlenia jaki kraj, jakie miasto i jaki port lotniczy

	
	JPanel p = new JPanel();
	
	
	
	public Infogui(){
		
		setTitle("Informacja o porcie lotniczym");
		
		setSize(300,130);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		for(int i = 0; i < 3; i++){
			
			database.setConnection(database.queries[i], Database.cityId);
			atributes[i] = new JLabel(Database.data);
			
		}
	
		createGui();
		
		add(p);
		setVisible(true);
	}
	
	private void createGui(){
		
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBackground(new Color(0,179,230));
		for(int i = 0; i < 3; i++){
			
			p.add(atributes[i]);
			atributes[i].setAlignmentX(atributes[i].CENTER_ALIGNMENT);
		
		}
	}
}
