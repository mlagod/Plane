package pl.edu.wat.wcy.pz;

import java.util.ArrayList;
import java.util.List;



public class Setup {

	 static Landings[] landings = new Landings[26];
	 static List<Plane> planes = new ArrayList<Plane>();
	 static List<PlaneGUI> planesGUI = new ArrayList<PlaneGUI>();
	 
	 static Handler h = new Handler();
	
	static int[] xParam = {300,789,208,877,565,533,672,661,507,376,564,724,424,217,91,86,641,751,752,255,447,419,734,493,947,552};
	static int[] yParam = {390,740,665,770,585,520,565,803,332,378,196,418,309,397,659,753,342,165,492,470,448,671,645,217,537,386};
	static int[] id_s = {0,1,4,5,6,10,9,14,23,25,27,30,32,37,39,40,43,47,50,51,55,59,63,66,69,75};
	
	
	
	public static void setupLandings(){
		
		for(int i = 0; i < 26; i++){
			
			landings[i] = new Landings();
			landings[i].setX(xParam[i]);
			landings[i].setY(yParam[i]);
			landings[i].setID(id_s[i]);
			
			landings[i].addMouseListener(h);
			//h.portId = landings[i].id;
		}
				
		
		}
/*	
	public static void setupPlanes(){
		
		for(int i = 0; i < Setup.planes.size(); i++){
			
		//	planesGUI.add(new PlaneGUI(i));
		}
	}
	*/
	public static int getId(int x){
		
		return id_s[x];
	}

}
