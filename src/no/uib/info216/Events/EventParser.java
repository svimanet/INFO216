package no.uib.info216.Events;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by fox on 4/30/16.
 */
public class EventParser {

    public String fakeDate(){
        // Random day
        Random rand = new Random();
        String n = Integer.toString(rand.nextInt(31) + 1);
        if(n.length() == 1)
            n = "0"+n;
        Calendar cal = Calendar.getInstance();
        String date = new SimpleDateFormat("YYYY-MM").format(cal.getTime());
        return date+"-"+n;
    }

    public Model parse(){
        Model model = ModelFactory.createDefaultModel();

        JSONParser parser = new JSONParser();

        Object obj = null;
        try {
            obj = parser.parse(new FileReader("./etrigg.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ArrayList<HashMap<String, String>> jsonObject = (ArrayList<HashMap<String, String>>) obj;
        System.out.println(jsonObject.toString());


        Property name = model.createProperty("http://schema.org/name");
        Property location = model.createProperty("http://schema.org/location");
        Property description = model.createProperty("http://schema.org/description");
        Property url = model.createProperty("http://schema.org/url");
        Property startDate = model.createProperty("http://schema.org/startDate");
        Property Category = model.createProperty("http://schema.org/category");
        Property eventProp = model.createProperty("http://schema.org/Event");

        Resource eventResource = model.createResource("http://schema.org/Event");


        Resource event;
        for(HashMap<String, String> item: jsonObject){
            event = model.createResource(item.get("id"), eventResource)
                    .addProperty(name, item.get("Name"))
                    .addProperty(location, item.get("Addr"))
                    .addProperty(description, item.get("Desc"))
                    .addProperty(Category, item.get("Category"))
                    .addProperty(startDate, this.fakeDate());
        }


       return model;
    }
}
