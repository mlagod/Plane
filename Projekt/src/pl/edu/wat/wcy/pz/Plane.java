package pl.edu.wat.wcy.pz;

public class Plane {

	private int id;
	private int fromLanding;
	private int toLanding;
	private int xPosition;
	private int yPosition;
	private double planeDirection;
	
	public Plane(int _id, int _fromLanding, int _toLanding){
		
		id = _id;
		fromLanding = _fromLanding;
		toLanding = _toLanding;
		
		testXML();
		
		setPlaneDirection(fromLanding, toLanding);
		testDirection();
	}
	
	public void setXPosition(int _xPosition){
		xPosition = _xPosition;
	}
	
	public void setYPosition(int _yPosition){
		yPosition = _yPosition;
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
			
			if(id == Setup.landings[i].id){
				x = Setup.landings[i].id;
				index = i;
			}
		}
		return index;
	}
	
	public void setPlaneDirection(int idA, int idB){
	
		int indexA = findLanding(idA);
		int indexB = findLanding(idB);
		
		int xA = Setup.landings[indexA].x;
		int yA = Setup.landings[indexA].y;
		
		int xB = Setup.landings[indexB].x;
		int yB = Setup.landings[indexB].y;
		
		double x = (double)Math.abs(xB-xA);
		double y = (double)Math.abs(yB-yA);
		
		double alpha = Math.atan(y/x);
		//System.out.println("alfa = " + alpha);
		planeDirection = alpha;
		
	}
	
//	public void setDir(){
//		planeDirection = setPlaneDirection(fromLanding, toLanding);
//	}

	public double getPlaneDirection(){
		return planeDirection;
	}
	
}
