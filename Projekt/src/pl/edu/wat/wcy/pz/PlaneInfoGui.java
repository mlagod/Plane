package pl.edu.wat.wcy.pz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlaneInfoGui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3439157440030886748L;


	String[] data = {"Samolot :", "Z : ", "Do :"};
	
	JLabel plane = new JLabel(data[0]);
	JLabel from = new JLabel(data[1]);
	JLabel to = new JLabel(data[2]);
	
	JPanel bcg = new JPanel();
	
	Database database = new Database();
	
	JButton pilots = new JButton("Piloci");
	JButton stewards = new JButton("Stewardzi");
	
	
	public PlaneInfoGui(){
		
		setTitle("Informacja o samolocie");
		setSize(350,230);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		setData();
		setGui();
		
		setVisible(true);
	}
	
	private void setData(){
		
		
		for(int i = 0; i < 3; i++){
			
			database.setConnection(database.planeQueries[i], Database.planeId);
			data[0] += " " + Database.data;
		}
		
		plane.setText(data[0]);
		
		for(int i = 0; i < 3; i++){
			
			database.setConnection(database.planeLandingQueries[i], ""+Setup.planes.get(Database.planeIdInList).getFromLanding());
			data[1] += " " + Database.data;
			
			database.setConnection(database.planeLandingQueries[i], ""+Setup.planes.get(Database.planeIdInList).getToLanding());
			data[2] += " " + Database.data;
		}
		
		from.setText(data[1]);
		to.setText(data[2]);
	}
	
	
	
	private void setGui(){
		
		//bcg.setLayout(new BoxLayout(bcg, BoxLayout.Y_AXIS));
		bcg.setLayout(new FlowLayout());
		bcg.setBackground(new Color(0,179,230));
		bcg.add(plane);
		bcg.add(from);
		bcg.add(to);
		
		//bcg.setLayout(new FlowLayout());
		bcg.add(pilots);
		bcg.add(stewards);
	
		
		this.add(bcg);
		
	}
}
