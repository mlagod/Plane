package pl.edu.wat.wcy.pz;


import javax.swing.JPanel;

public class Landings extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6511651075959335776L;
	
	private int id;
	private int x;
	private int y;
	
	public Landings(){
		
		super();
		
		setOpaque(false);
		setVisible(true);
		
		
	}
	
	public void setID(int _id){
		id = _id;
	}
	
	public void setX(int _x){
		x = _x;
	}
	
	public void setY(int _y){
		y = _y;
	}
	
	public int getXparam(){
		return x;
	}
	
	public int getYparam(){
		return y;
	}
	
	public int getId(){
		return id;
	}

}
