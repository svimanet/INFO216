/**
 * 
 */
package no.uib.info216.facebook;

import java.util.ArrayList;

import no.uib.info216.RDF.FacebookQueries;
import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;

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

	/**
	 * This is the constructor for the CreateModels Class
	 */
	public CreateModels() {

	}

	/**
	 * This method creates an rdf model using a list
	 * of FacebookUser object and their interests.
	 * @param users - A list of FacebookUser objects
     */
	public void createmodel(ArrayList<FacebookUser> users){
		for(FacebookUser u : users){
			addRes(u.getEvents(), events, model, u.getName() + "_" + u.getLastName());
			addRes(u.getTvShows(), tvShow, model, u.getName() + "_" + u.getLastName());
			addRes(u.getMovies(), movie, model, u.getName() + "_" + u.getLastName());
			addRes(u.getMusic(), music, model, u.getName() + "_" + u.getLastName());
			addRes(u.getGames(), games, model, u.getName() + "_" + u.getLastName());
			addRes(u.getBook(), book, model, u.getName() + "_" + u.getLastName());
			addRes(u.getLikes(), likes, model, u.getName() + "_" + u.getLastName());
		}

	}

	/**
	 * This methid Creates resources for each element in an arrayList
	 * and adds properties to the resourse.
	 * @param a - The arrayList
	 * @param p - The property
	 * @param m - The model
     * @param name - The name
     */
	public void addRes(ArrayList<String> a, Property p, Model m, String name){
		for (String s : a) {
			m.createResource(name/*, FOAF.Person*/)
				.addProperty(p, s);
		}
	}

	/**
	 * This model creates a list of random FacebookUsers and
	 * creates a model with each of these users interests.
	 * @return model - An rdf model
     */
	public Model parse(){
		ArrayList<FacebookUser> users = rug.createUserWithRandomInterests(10, data.getIr()); //Creates 10 "Fake" users.
		createmodel(users);
		return model;
	}


	/**
	 * This method reads a .ttl file and sets the model to
	 * this .ttl file with its content.
	 * @return Model - An rdf model.
     */
	public Model readFacebookTurtle(){
		Model model = ModelFactory.createDefaultModel();
			model.read("FacebookFriends.ttl", "TURTLE");

		this.model = model;
		return model;
	}

	/**
	 * This met
	 * @return
     */
	public Model checkIfKeyExists(){
		Model model = ModelFactory.createDefaultModel();
		if(data.getAccessToken() != ""){
			model = parse();
		} else{
			model = readFacebookTurtle();
		}
		this.model = model;
		return model;
	}


	/**
	 * Getter for the jena rdf model.
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}


	/**
	 * This is a test main method for the facebookUsers and
	 * turtle files.
	 * @param args
	 */
	public static void main(String[] args){
		RDFHandler rdfHandler = new RDFHandler();
		FacebookQueries fq = new FacebookQueries(rdfHandler);
		CreateModels cm = new CreateModels();

		Model model = cm.checkIfKeyExists(); //cm.readFacebookTurtle();
		rdfHandler.addModel(model);
		rdfHandler.saveModel("FacebookFriends.ttl", model);

		fq.AllInsterestsFromUser("Maggy_Valle");
		fq.AllFromOneCategory("Game");
		fq.UserInterestsFromOneCategory("Hearthstone");
		fq.UserInterestsFromOneCategory("Maggy_Valle", "Game");

	}



}
