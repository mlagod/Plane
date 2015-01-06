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
		
		setStartPosition();
		
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
	
	public int getXPosition(){
		return xPosition;
	}
	
	public int getYPosition(){
		return yPosition;
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
		
		double alpha = 0;
		
		if(xB == xA && yA > yB ){
			alpha = Math.toRadians(0);
		}else if(xB > xA && yB < yA){
			alpha = Math.atan(x/y);
		}else if(xB > xA && yB == yA){
			alpha = Math.toRadians(90);
		}else if(xB > xA && yB > yA){
			alpha = Math.toRadians(180);
			alpha = alpha - Math.atan(x/y);
		}else if(xB == xA && yB > yA){
			alpha = Math.toRadians(180);
		}else if(xB < xA && yB > yA){
			alpha = Math.toRadians(180);
			alpha = alpha + Math.atan(x/y);
		}else if(xB < xA && yB == yA){
			alpha = Math.toRadians(270);
		}else if(xB < xA && yB < yA){
			alpha = (-1) * Math.atan(x/y);
		}
		//System.out.println("alfa = " + alpha);
		planeDirection = alpha;
		
	}
	
	public double getPlaneDirection(){
		return planeDirection;
	}
	
	public void setStartPosition(){
		
		setXPosition(Setup.landings[findLanding(fromLanding)].x);
		setYPosition(Setup.landings[findLanding(fromLanding)].y);
	}

	@Override
	public void run() {
		
		System.out.println("Watek");
		move();
		
	}
	
	public void move(){
		
		int start = findLanding(fromLanding);
		int end = findLanding(toLanding);
		
		int xA = Setup.landings[start].x;
		int yA = Setup.landings[start].y;
		
		int xB = Setup.landings[end].x;
		int yB = Setup.landings[end].y;
		
		if(xB == xA && yA > yB ){
			while(yA > yB){
			yPosition--;
			Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(0);
		}else if(xB > xA && yB < yA){
			
			while(xB > xA && yB < yA){
				xPosition++;
				yPosition--;
				Setup.planesGUI.get(0).repaint();
			}
			
			if(xB == xA){
				while(yB != yA){
				yPosition--;
				Setup.planesGUI.get(0).repaint();
				}
			}else if(yB == yA){
				xPosition++;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.atan(x/y);
		}else if(xB > xA && yB == yA){
			
			while( xB > xA){
				xPosition++;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(90);
		}else if(xB > xA && yB > yA){
			
			while(xB > xA && yB > yA){
				xPosition++;
				yPosition++;
				//System.out.println("x =" + xPosition + " y = " + yPosition);
				
				Setup.planesGUI.get(0).repaint();
				
			}
			
			if(xB == xA){
				yPosition++;
				Setup.planesGUI.get(0).repaint();
			}else if(yB == yA){
				xPosition++;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(180);
			//alpha = alpha - Math.atan(x/y);
		}else if(xB == xA && yB > yA){
			
			while(yB > yA){
				yPosition++;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(180);
		}else if(xB < xA && yB > yA){
			
			while(xB < xA && yB > yA){
				xPosition--;
				yPosition++;
				Setup.planesGUI.get(0).repaint();
			}
			if(xB == xA){
				yPosition++;
				Setup.planesGUI.get(0).repaint();
			}else if(yB == yA){
				xPosition--;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(180);
			//alpha = alpha + Math.atan(x/y);
		}else if(xB < xA && yB == yA){
			
			while(xB < xA){
				xPosition--;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = Math.toRadians(270);
		}else if(xB < xA && yB < yA){
			
			while(xB < xA && yB < yA){
				xPosition--;
				yPosition--;
				Setup.planesGUI.get(0).repaint();
			}
			if(xB == xA){
				yPosition--;
				Setup.planesGUI.get(0).repaint();
			}else if(yB == yA){
				xPosition--;
				Setup.planesGUI.get(0).repaint();
			}
			//alpha = (-1) * Math.atan(x/y);
		}
		
	}
}
