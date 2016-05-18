/**
 * 
 */
package no.uib.info216.facebook;

import no.uib.info216.RDF.FacebookQueries;
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

	//Fields
	FacebookData data = new FacebookData();
	RandomUserGeneration rug = new RandomUserGeneration();

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

	public Model createUserModel(){
		Interests ir = data.getIr();
			addRes(ir.getEvents(), events, userModel, "Ole");
			addRes(ir.getTvShows(), tvShow, userModel, "Ole");
			addRes(ir.getMovies(), movie, userModel, "Ole");
			addRes(ir.getMusic(), music, userModel, "Ole");
			addRes(ir.getGames(), games, userModel, "Ole");
			addRes(ir.getBook(), book, userModel, "Ole");
			addRes(ir.getLikes(), likes, userModel, "Ole");
		return this.userModel;
	}

	/**
	 * This method Creates resources for each element in an arrayList
	 * and adds properties to the resourse.
	 * @param a - The arrayList
	 * @param p - The property
	 * @param m - The mode to be used
     * @param name - The name
     */
	public void addRes(ArrayList<String> a, Property p, Model m, String name){
		Resource res = m.createResource(name, FOAF.Person);
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
			ArrayList<FacebookUser> users = rug.createUserWithRandomInterests(10, data.getIr()); //Creates 10 "Fake" users.
			this.model = createmodel(users);
			this.userModel = createUserModel();
		}else{
			this.userModel = this.readFacebookTurtle("FacebookUser.ttl");
			this.model = this.readFacebookTurtle("FacebookFriends.ttl");
		}
		return this.model;
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

	public void addFacebookModelsToFinalModel(Model finalModel){
		finalModel.add(this.model);
		finalModel.add(this.userModel);
	}

	/**
	 * This met
	 * @return
     */
	public boolean checkIfKeyExists(){
		return !data.getAccessToken().equals("");
	}


	/**
	 * Getter for the jena rdf freidnsModel.
	 * @return the friendsModel
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
		Model finalModel = ModelFactory.createDefaultModel();

		cm.parse();
		cm.addFacebookModelsToFinalModel(finalModel);
		rdfHandler.addModel(finalModel);
		String query =  "PREFIX schema: <http://schema.org/>" +
				"SELECT  * " +
				"WHERE {" +
				"       ?name  ?o ?value  " +

				"    }" +
				"ORDER BY ASC(?o) ";

		rdfHandler.runSparql(query);
	}
}
