package no.uib.info216.WeatherData;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.base.Sys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created 23/02/16.
 * Class for recieving data from Yr.no and parsing it to a local document aswell as
 * arrays to be used for creating the rdf.
 */
public class Yr{

    private File file = new File("varsel.xml");

    private ArrayList<String> nametag = new ArrayList<String>();
    private ArrayList<String> fromtag = new ArrayList<String>();
    private ArrayList<Integer> periodTag = new ArrayList<Integer>();
    private ArrayList<String> windSpeedName = new ArrayList<String>();
    private ArrayList<String> temprature = new ArrayList<String>();
    private ArrayList<Integer> idList = new ArrayList<Integer>();

    long diff = new Date().getTime() - file.lastModified();

    public ArrayList<HashMap<String,String>> dataStruct = new ArrayList<HashMap<String, String>>();

    /**
     * Checks the varsel.xml file on startup.
     * If the file is older than one day,
     * it updates the file directly
     * from yr.no's weatherapi.
     * Link to api can be found in URL weatherAPI.
     *
     * else if it is not older than one day,
     * it does nothing to the file.
     */
    public void getWeatherAPI(){
        System.out.print("Updating API ... ");

        if(diff > 24 * 60 * 60 * 1000){
            try {
                URL weatherAPI = new URL("http://www.yr.no/sted/Norge/Hordaland/Bergen/Bergen/varsel.xml");
                ReadableByteChannel rbc = Channels.newChannel(weatherAPI.openStream());
                FileOutputStream fos = new FileOutputStream(file);
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
                System.out.print("API successfully updated from:\n" + weatherAPI +"\n");

            } catch (Exception e) {
                System.out.print("Couldn't find URL to API.");
            }

        } else {
            System.out.print("Already up to date!\n");
        }
    }

    /**
     * Lifts the xml to arraylists
     * which are sent to Weather.java class
     * to be used in .ttl file.
     */
    public void makeSymbolList(){

        System.out.print("Building lists from API ... ");

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
        Element tempNodeList = (Element)doc.getElementsByTagName("temperature").item(0);

        for (int i = 0; i < timeNodeList.getLength(); i++) {
            HashMap<String, String> obj = new HashMap<String, String>();
            Node node = timeNodeList.item(i);
            Element eElement = (Element) node;

            Node symbolNode = eElement.getElementsByTagName("symbol").item(0);
            Element symbolElement = (Element) symbolNode;

            Node tempNode = eElement.getElementsByTagName("temperature").item(0);
            Element tempElement = (Element) tempNode;

            obj.put("name", symbolElement.getAttribute("name"));
            obj.put("from", eElement.getAttribute("from"));
            obj.put("period", eElement.getAttribute("period"));

            nametag.add(symbolElement.getAttribute("name"));
            fromtag.add(StringUtils.left(eElement.getAttribute("from"), 10));
            periodTag.add(Integer.parseInt(eElement.getAttribute("period")));
            temprature.add(tempElement.getAttribute("value"));
            idList.add(1+i);


            this.dataStruct.add(obj);

        }
        System.out.print("Success!\n");
    }

    public Yr(){
        getWeatherAPI();
        makeSymbolList();

    }

    /**
     * nametag is an ArrayList<String>
     * filled with the names of the types
     * of weather that occurs on a specific day.
     * @return
     */
    public ArrayList<String> getNametag() {
        return nametag;
    }

    /**
     * the fromtab is and ArrayList
     * filled with a ceretain date.
     * The weather cast consists of two times and dates.
     * Time and date from, name of weather, time and date to.
     * to specify the duration of the weather.
     * The time and date TO is the next time and date
     * in line in this array.
     * @return
     */
    public ArrayList<String> getFromtag() {
        return fromtag;
    }

    /**
     * The windspeed name is an arraylist filled with the
     * names of the windtypes that occur,
     * such as "Orkan", "Storm", etc.
     * @return
     */
    public ArrayList<String> getWindSpeedName() {
        return windSpeedName;
    }


    /**
     * Getter for the periodTag arrayList
     * which is a list containing 0-3 periods of the day.
     * It is used to limit the weather to one day on mid day.
     * @return
     */
    public ArrayList<Integer> getPeriodTag() {
        return periodTag;
    }

    /**
     * The temprature arraylist is an array
     * containting all the temeratures of the day
     * in celsius.
     * @return
     */
    public ArrayList<String> getTemprature() {
        return temprature;
    }

    /**
     * the datastruct is a cleaner way of displaying the data stored
     * in the lists if you want to see it in the terminal output.
     * @return
     */
    public ArrayList<HashMap<String, String>> getDataStruct() {
        return dataStruct;
    }

    public ArrayList<Integer> getIdList() {
        return idList;
    }
}