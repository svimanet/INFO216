package no.uib.info216;

import java.io.*;
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

            obj.put("name", symbolElement.getAttribute("name"));
            obj.put("from", eElement.getAttribute("from"));
            obj.put("to", eElement.getAttribute("to"));

            nametag.add(symbolElement.getAttribute("name"));
            fromtag.add(eElement.getAttribute("from"));

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