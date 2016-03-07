/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.util.ArrayList;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

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
	private Property tvShow = model.createProperty("http://info216.uib.no/resource/tvShow");
	private Property movie = model.createProperty("http://info216.uib.no/resource/movie");
	private Property music = model.createProperty("http://info216.uib.no/resource/music");
	private Property book = model.createProperty("http://info216.uib.no/resource/book");
	private Property games = model.createProperty("http://info216.uib.no/resource/game");
	private Property events = model.createProperty("http://info216.uib.no/resource/event");
	private Property likes = model.createProperty("http://info216.uib.no/resource/likes");
		
	/**
	 * This method creates the jena model by adding all the interests to the
	 * model using the method created below.
	 */
	public void createModel() {
		addRes(ir.getTvShows(), tvShow, model);
		addRes(ir.getMovies(), movie, model);
		addRes(ir.getMusic(), music, model);
		addRes(ir.getGames(), games, model);
		addRes(ir.getBook(), book, model);
		addRes(ir.getEvents(), events, model);
		addRes(ir.getLikes(), likes, model);
	}

	
	public void addRes(ArrayList<String> a, Property p, Model m){
		for (String s : a) {
			Resource res = m.createResource(s);
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
