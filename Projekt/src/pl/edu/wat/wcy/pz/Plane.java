package pl.edu.wat.wcy.pz;

public class Plane extends Thread {

	
	private int id;
	private int fromLanding;
	private int toLanding;
	private int xPosition;
	private int yPosition;
	private double planeDirection;
	
	private int idInList;
	
	public Plane(int _id, int _fromLanding, int _toLanding, int _idInList){
		
		id = _id;
		fromLanding = _fromLanding;
		toLanding = _toLanding;
		idInList = _idInList;
		
		
		
		testXML();
		
		//setPlaneDirection(fromLanding, toLanding);
		setStartPosition();
		testDirection();

	}
	
	public void setXPosition(int _xPosition){
		xPosition = _xPosition;
	}
	
	public void setYPosition(int _yPosition){
		yPosition = _yPosition;
	}
	
	public int getXPosition(){
		return xPosition;
	}
	
	public int getYPosition(){
		return yPosition;
	}
	
	public int getPlaneId(){
		return id;
	}
	
	public int getFromLanding(){
		return fromLanding;
	}
	
	public int getToLanding(){
		return toLanding;
	}
	
	public int getIdInList(){
		return idInList;
	}
	
	public void testXML(){
		System.out.println("");
		System.out.println("Samolot id =" + id);
		System.out.println("Samolot from = " + fromLanding);
		System.out.println("Samolot to = " + toLanding);
	}
	
	public void testDirection(){
		
		System.out.println(""+ planeDirection);
	}
	
	public int findLanding(int id){	// zwraca id w tablicy lotnisk poszukiwanego lotniska
		
		int x = -1; //zadne lotnisko nie ma id = -1
		int index = -1;
		
		for(int i = 0; x != id; i++){
			
			if(id == Setup.landings[i].getId()){
				x = Setup.landings[i].getId();
				index = i;
			}
		}
		return index;
	}
	
	public double getPlaneDirection(){
		return planeDirection;
	}
	
	public void setStartPosition(){
		
		setXPosition(Setup.landings[findLanding(fromLanding)].getXparam());
		setYPosition(Setup.landings[findLanding(fromLanding)].getYparam());
		System.out.println("X = " + Setup.landings[findLanding(fromLanding)].getXparam());
		System.out.println("Y = " + Setup.landings[findLanding(fromLanding)].getYparam());
		
	}

	@Override
	public void run() {
		
		//System.out.println("Watek");
		move();
		
	}
	
	public void waitForMove(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showMove(){
		
		Gui.background.validate();
		waitForMove();
		//this.setPlaneDirection(idA, idB);
		Setup.planesGUI.get(idInList).repaint();
	}
	
	public void move(){
		
		int start = findLanding(fromLanding);
		int end = findLanding(toLanding);
		
		int xA = Setup.landings[start].getXparam();
		int yA = Setup.landings[start].getYparam();
		
		int xB = Setup.landings[end].getXparam();
		int yB = Setup.landings[end].getYparam();
		
		float distance = (float)Math.sqrt( (xA-xB) * (xA-xB) + (yA-yB) * (yA-yB) );
		
		float dx = (xB - xA) / distance;
		float dy = (yB - yA) / distance;
		
		planeDirection = (float)Math.acos(-dy) * (dx < 0 ? -1 : 1);
		
		for (int i = 0; i < distance; i++) {
			xPosition = (int) (xA + i * dx);
			yPosition = (int) (yA + i * dy);
			showMove();
		}
		
	}
}
