/**
 * 
 */
package no.uib.info216.facebook;

import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

import java.util.ArrayList;

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
		return this.model;

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
			Resource res = m.createResource(name);
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
			ArrayList<FacebookUser> users = rug.createUserWithRandomInterests(10, data.getIr()); //Creates 10 "Fake" users.
			this.model = createmodel(users);
		}else{
			this.model = this.readFacebookTurtle();
		}
		return this.model;
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
	public boolean checkIfKeyExists(){
		return !data.getAccessToken().equals("");
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

		Model model = cm.parse(); //cm.readFacebookTurtle();
		rdfHandler.addModel(model);
		//rdfHandler.saveModel("FacebookFriends.ttl", model);
		String queryString =
				"PREFIX schema: <http://schema.org/>" +
				"SELECT  * " +
						"WHERE {" +
						"       ?name ?property \"Mirrors\"  " + //<Maggy_Kallestad>

						"      }" +
						"ORDER BY ASC(?o) ";
		String user = QueryFactory.AllInsterestsFromUser("Seborg_Mathiasen");
		String category = QueryFactory.AllFromOneCategory("Game");
		String interest = QueryFactory.UserInterestsFromOneCategory("Hearthstone");
		String userCategory = QueryFactory.UserInterestsFromOneCategory("Seborg_Mathiasen", "Game");
		rdfHandler.runSparql(userCategory);

	}



	//And so on... This does not nessesarily need to be static.
}
