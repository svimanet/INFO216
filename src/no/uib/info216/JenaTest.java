package no.uib.info216;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Created by svimanet on 23/02/16.
 */
public class JenaTest {

    private File file = new File("varsel.xml");
    private ArrayList<String> nametag = new ArrayList<String>();
    private ArrayList<String> fromtag = new ArrayList<String>();
    private ArrayList<String> totag = new ArrayList<String>();
    private ArrayList<String> windDirection = new ArrayList<String>();
    private ArrayList<String> windDirectionName = new ArrayList<>();
    private ArrayList<String> windSpeed = new ArrayList<String>();
    private ArrayList<String> windSpeedName = new ArrayList<String>();
    private ArrayList<String> temprature = new ArrayList<String>();

    public ArrayList<HashMap<String,String>> dataStruct = new ArrayList<>();

    public void makeSymbolList(){

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;

        try {
            dBuilder = dbFactory.newDocumentBuilder();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        }

        Document doc = null;

        try {
            doc = dBuilder.parse(file);

        } catch (SAXException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Element nodelist = (Element)doc.getElementsByTagName("tabular").item(0);

        NodeList timeNodeList = nodelist.getElementsByTagName("time");

        for (int i = 0; i < timeNodeList.getLength(); i++) {
            HashMap<String,String> obj = new HashMap<>();

            Node node = timeNodeList.item(i);
            Element eElement = (Element) node;

            Node symbolNode = eElement.getElementsByTagName("symbol").item(0);
            Element symbolElement = (Element)  symbolNode;

            Node windDirectionNode = eElement.getElementsByTagName("windDirection").item(1);
            Element directionElement = (Element)  windDirectionNode;

            Node windSpeedNode = eElement.getElementsByTagName("windSpeed").item(2);
            Element windSpeedElement = (Element)  windSpeedNode;

            Node tempNode = eElement.getElementsByTagName("temperature").item(3);
            Element tempElement = (Element)  tempNode;

            obj.put("name", symbolElement.getAttribute("name"));
            obj.put("from", eElement.getAttribute("from"));
            obj.put("to", eElement.getAttribute("to"));

            nametag.add(symbolElement.getAttribute("name"));
            fromtag.add(eElement.getAttribute("from"));
            windDirection.add(directionElement.getAttribute("deg"));
            windDirectionName.add(directionElement.getAttribute("name"));
            windSpeed.add(windSpeedElement.getAttribute("mps"));
            windSpeedName.add(windSpeedElement.getAttribute("name"));
            temprature.add(tempElement.getAttribute("value"));

            System.out.println("WIND DIR: " + windDirection);
            System.out.println("WIND DIRNAME: " + windDirectionName);
            System.out.println("WIND SPEED: " + windSpeed);
            System.out.println("WIND SPEEDNAME: " + windSpeedName);
            System.out.println("TEMP TEMP: " + temprature);
            this.dataStruct.add(obj);

        }
    }

    public JenaTest(){
        makeSymbolList();

    }

    public ArrayList<String> getNametag() {
        return nametag;
    }

    public ArrayList<String> getFromtag() {
        return fromtag;
    }

    public ArrayList<HashMap<String, String>> getDataStruct() {
        return dataStruct;
    }
}