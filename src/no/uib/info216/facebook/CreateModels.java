/**
 * 
 */
package no.uib.info216.facebook;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.DCTerms;

/**
 * @author mariuslillevik
 *
 *         This class will be creating an RDF file that represents the users and
 *         their interests. Nothing yet.
 */
public class CreateModels {

	//Fields
	FacebookData data = new FacebookData();
	RandomUserGeneration rug = new RandomUserGeneration();


	private Model model = ModelFactory.createDefaultModel();
	//Properties
	private Property tvShow = model.createProperty("https://schema.org/TVSeries");
	private Property movie = model.createProperty("http://schema.org/Movie");
	private Property music = model.createProperty("https://schema.org/MusicRecording");
	private Property book = model.createProperty("https://schema.org/Book");
	private Property games = model.createProperty("http://schema.org/Game");
	private Property events = model.createProperty("http://schema.org/Event");
	private Property likes = model.createProperty("https://schema.org/UserLikes"); //This URI is not exactly what we're looking for, but it works for now.

	public void createmodel(ArrayList<FacebookUser> users){
		for(FacebookUser user : users){
			addRes(user.getEvents(), events, model, user.getName()/* + "_" + user.getId()*/);
			addRes(user.getTvShows(), tvShow, model, user.getName()/* + "_" + user.getId()*/);
			addRes(user.getMovies(), movie, model, user.getName()/* + "_" + user.getId()*/);
			addRes(user.getMusic(), music, model, user.getName()/* + "_" + user.getId()*/);
			addRes(user.getGames(), games, model, user.getName()/* + "_" + user.getId()*/);
			addRes(user.getBook(), book, model, user.getName() /* + "_" + user.getId()*/);
			addRes(user.getLikes(), likes, model, user.getName()/* + "_" + user.getId()*/);
		}

	}


	public void addRes(ArrayList<String> a, Property p, Model m, String name){
		for (String s : a) {
			Resource res = m.createResource(name);
			res.addProperty(p, s);
		}
	}

	public Model parse(){
		ArrayList<FacebookUser> users = rug.createUserWithRandomInterests(10, data.getIr()); //Creates 10 "Fake" users.
		createmodel(users);

		return model;
	}

	


	/**
	 * @return the model
	 */
	public Model getModel() {

		return model;
	}


	public static void main(String[] args){
		RDFHandler rdfHandler = new RDFHandler();
		CreateModels cm = new CreateModels();

		Model model = cm.parse();
		rdfHandler.addModel(model);
		rdfHandler.saveModel("FacebookFriends.ttl", model);
		String queryString =
				"PREFIX schema: <http://schema.org/>" +
				"SELECT  * " +
						"WHERE {" +
						"       ?name schema:Event ?title " +
						"      }";
		rdfHandler.runSparql(queryString);
	}

}
