package no.uib.info216.Events;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by fox on 4/30/16.
 */
public class EventParser {
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



        Resource event;
        for(HashMap<String, String> item: jsonObject){
            event = model.createResource(item.get("id"))
                    .addProperty(name, item.get("Name"))
                    .addProperty(location, item.get("Addr"))
                    .addProperty(description, item.get("Desc"))
                    .addProperty(startDate, item.get("start date"));
        }


       return model;
    }
}
