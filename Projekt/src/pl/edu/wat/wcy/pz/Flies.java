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

	
	public void getFlies(){
	try {
		 
		File xmlFile = new File("C:\\Users\\Mateusz\\Documents\\GitHub\\Plane\\Projekt\\loty.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
	 
		//optional, but recommended
		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
		doc.getDocumentElement().normalize();
	 
		//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	 
		NodeList nList = doc.getElementsByTagName("plane");
	 
		System.out.println("----------------------------");
	 
		for (int temp = 0; temp < nList.getLength(); temp++) {
	 
			Node nNode = nList.item(temp);
	 
		//	System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
	 
				//planes.add(new Plane());
				//planes.get(temp).setId(Integer.parseInt(""+eElement.getAttribute("id")));
				//planes.get(temp).setFromLanding(Integer.parseInt(""+eElement.getElementsByTagName("fromId").item(0).getTextContent()));
				int planeId = Integer.parseInt(eElement.getAttribute("id"));
				int planeFrom = Integer.parseInt(eElement.getElementsByTagName("fromId").item(0).getTextContent());
				int planeTo = Integer.parseInt(eElement.getElementsByTagName("toId").item(0).getTextContent());
				
				Setup.planes.add(new Plane(planeId, planeFrom, planeTo));
			//	System.out.println("Plane id : " + eElement.getAttribute("id") +"or = " + planeId);
			//	System.out.println("First Name : " + eElement.getElementsByTagName("fromId").item(0).getTextContent() + "or = " + planeFrom);
			//	System.out.println("Last Name : " + eElement.getElementsByTagName("toId").item(0).getTextContent() + "or + " + planeTo);
	 
			}
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
}
