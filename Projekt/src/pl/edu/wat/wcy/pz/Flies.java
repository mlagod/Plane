package pl.edu.wat.wcy.pz;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Flies {

	static int iterator = 0; // sluzy do przypisania indeksow do idInList, iterowany przy dopisywaniu samolotu do arrayList
	
	public void getFlies(){
	try {
		 
		File xmlFile = new File("C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\loty.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
	 
		
		doc.getDocumentElement().normalize();
	 
	 
		NodeList nList = doc.getElementsByTagName("plane");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
	 
				
				int planeId = Integer.parseInt(eElement.getAttribute("id"));
				int planeFrom = Integer.parseInt(eElement.getElementsByTagName("fromId").item(0).getTextContent());
				int planeTo = Integer.parseInt(eElement.getElementsByTagName("toId").item(0).getTextContent());
				
				Setup.planes.add(new Plane(planeId, planeFrom, planeTo,iterator));
				Setup.planesGUI.add(new PlaneGUI(iterator));
				iterator++;
				
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
}
