/**
 * 
 */
package no.uib.info216.facebook;

import no.uib.info216.RDF.Queries.FacebookQueries;
import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.sparql.vocabulary.FOAF;

import java.util.ArrayList;

/**
 * @author mariuslillevik
 *
 *         This class will be creating an RDF file that represents the users and
 *         their interests. Nothing yet.
 */
public class CreateModels {

	public ArrayList<Resource> friendResource = new ArrayList<Resource>();


	//Fields
	FacebookData data = new FacebookData();
	RandomUserGeneration rug = new RandomUserGeneration();
	FacebookUser user;


	private Model model = ModelFactory.createDefaultModel();
	private Model userModel = ModelFactory.createDefaultModel();




	//Properties
	private Property tvShow = model.createProperty("http://schema.org/TVSeries");
	private Property movie = model.createProperty("http://schema.org/Movie");
	private Property music = model.createProperty("http://schema.org/MusicRecording");
	private Property book = model.createProperty("http://schema.org/Book");
	private Property games = model.createProperty("http://schema.org/Game");
	private Property events = model.createProperty("http://schema.org/Event");
	private Property likes = model.createProperty("http://schema.org/UserLikes"); //This URI is not exactly what we're looking for, but it works for now.
	
	/**
	 * This is the constructor for the CreateModels Class
	 */
	public CreateModels() {
		setUpFacebookUser();
		parse();
	}

	/**
	 * This method creates an rdf model using a list
	 * of FacebookUser object and their interests.
	 * @param users - A list of FacebookUser objects
     */
	public Model createmodel(ArrayList<FacebookUser> users){
		for(FacebookUser u : users){
			addRes(u.getEvents(), events, model, u.getName() + "_" + u.getLastName());
			addRes(u.getTvShows(), tvShow, model, u.getName() + "_" + u.getLastName());
			addRes(u.getMovies(), movie, model, u.getName() + "_" + u.getLastName());
			addRes(u.getMusic(), music, model, u.getName() + "_" + u.getLastName());
			addRes(u.getGames(), games, model, u.getName() + "_" + u.getLastName());
			addRes(u.getBook(), book, model, u.getName() + "_" + u.getLastName());
			addRes(u.getLikes(), likes, model, u.getName() + "_" + u.getLastName());
		}
		//this.createUserModelKnowns();
		return this.model;
	}

	/**
	 * Creates the user model for the RDF model
	 * Based on the random generated user URIs
	 */
	private void createUserModelKnowns(String name) {
		Resource res = this.userModel.createResource(name, FOAF.Person);
		for (Resource s: this.friendResource) {
			this.userModel.add(res, FOAF.knows, s);
		}
	}

	public Model createUserModel(FacebookUser u){
		String uri = "http://uib.no/info216/User/";
			addResUserModel(u.getEvents(), events, userModel, u.getName());
			addResUserModel(u.getTvShows(), tvShow, userModel, u.getName());
			addResUserModel(u.getMovies(), movie, userModel, u.getName());
			addResUserModel(u.getMusic(), music, userModel, u.getName());
			addResUserModel(u.getGames(), games, userModel, u.getName());
			addResUserModel(u.getBook(), book, userModel, u.getName());
			addResUserModel(u.getLikes(), likes, userModel, u.getName());
		this.createUserModelKnowns(uri);
		return this.userModel;
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
		String uri = "http://uib.no/info216/person/"+name;
		Resource res = m.createResource(uri, FOAF.Person);
		res.addProperty(FOAF.name, name);
		this.friendResource.add(res);
		for (String s : a) {
			res.addProperty(p, s);
		}
	}

	public void addResUserModel(ArrayList<String> a, Property p, Model m, String name){
		String uri = "http://uib.no/info216/User/";
		Resource res = m.createResource(uri, FOAF.Person);
		res.addProperty(FOAF.name, name);
		for (String s : a) {
			res.addProperty(p, s);
		}
	}

	/**
	 * This model creates a list of random FacebookUsers and
	 * creates a model with each of these users interests.
	 * @return model - An rdf model
     */
	public Model parse(){
		if(checkIfKeyExists()) {
			this.data.setupUser();
			ArrayList<FacebookUser> users = rug.createUserWithRandomInterests(10, data.getIr());
			this.model = createmodel(users);
			this.userModel = createUserModel(user);
			new RDFHandler().saveModel("FacebookFiles/FacebookFriends.ttl", model);
			new RDFHandler().saveModel("FacebookFiles/FacebookUser.ttl", userModel);
		}else{
			this.model = this.readFacebookTurtle("FacebookFiles/FacebookFriends.ttl");
			this.userModel = this.readFacebookTurtle("FacebookFiles/FacebookUser.ttl");

		}
		return this.model;
	}

	public void addFacebookToFinalModel(Model model){
		model.add(this.model);
		model.add(this.userModel);
	}


	/**
	 * This method reads a .ttl file and sets the model to
	 * this .ttl file with its content.
	 * @return Model - An rdf model.
	 */
	public Model readFacebookTurtle(String fileName){
		Model model = ModelFactory.createDefaultModel();
		model.read(fileName, "TURTLE");
		return model;
	}

	public void setUpFacebookUser(){
		Interests ir = data.getIr();
		this.user = new FacebookUser(
				ir.getTvShows(),
				ir.getMovies(),
				ir.getMusic(),
				ir.getBook(),
				ir.getGames(),
				ir.getEvents(),
				ir.getLikes());
		user.setName("Bruker_Brukersen");
	}

	/**
	 * This met
	 * @return
     */
	public boolean checkIfKeyExists(){
		return !data.getAccessToken().equals("");
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

		Model model = ModelFactory.createDefaultModel();
		cm.addFacebookToFinalModel(model);
		rdfHandler.addModel(model);
		rdfHandler.saveModel("FacebookFiles/FacebookModel.ttl", model);

		fq.sameInterests();
	}
}
