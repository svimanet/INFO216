/**
 * 
 */
package no.uib.info216.facebook;

import java.util.ArrayList;
import java.util.Random;

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
public class CreatingRdf {

	//Fields
	private Model model = ModelFactory.createDefaultModel();
	private Interests ir = new Interests();
	//Properties
	private Property tvShow = model.createProperty("https://schema.org/TVSeries");
	private Property movie = model.createProperty("http://schema.org/Movie");
	private Property music = model.createProperty("https://schema.org/MusicRecording");
	private Property book = model.createProperty("https://schema.org/Book");
	private Property games = model.createProperty("http://schema.org/Game");
	private Property events = model.createProperty("http://schema.org/Event");
	private Property likes = model.createProperty("https://schema.org/UserLikes"); //This URI is not exactly what we're looking for, but it works for now.

		
	/**
	 * This method creates the jena model by adding all the interests to the
	 * model using the method created below.
	 */
	public void createModel() {
		addRes(ir.getTvShows(), tvShow, model, "TV-shows");
		addRes(ir.getMovies(), movie, model, "Movie");
		addRes(ir.getMusic(), music, model, "Music");
		addRes(ir.getGames(), games, model, "Game");
		addRes(ir.getBook(), book, model, "Book");
		addRes(ir.getEvents(), events, model, "Event");
		addRes(ir.getLikes(), likes, model, "Like");

	}

	
	public void addRes(ArrayList<String> a, Property p, Model m, String name){
		for (String s : a) {
			Resource res = m.createResource(name);
			res.addProperty(p, s);
		}
	}


	/**
	 * @return the model
	 */
	public Model getModel() {

		return model;
	}


	/**
	 * @return the ir
	 */
	public Interests getIr() {

		return ir;
	}

}
