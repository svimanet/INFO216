/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.io.ObjectOutputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.system.StreamRDFWriter;

/**
 * @author mariuslillevik
 *
 *This class will be creating an RDF file that represents the
 *users and their interests. Nothing yet.
 */
public class CreatingRdf {

//	private File file = new File("Facebook.rdf");
//	private StreamRDFWriter writer = new StreamRDFWriter();
	private ObjectOutputStream os;
	public void createModel(){
		
	Model model = ModelFactory.createDefaultModel();
	Resource res = model.createResource("http://info216.uib.no/resource/hellojuna");	
		//Predicate
			
	Property prop = model.createProperty("http://info216.uib.no/resource/hellojuna");

			
	res.addLiteral(prop, "Hello world");
			
	model.write(System.out, "TURTLE");
	
	
	Property tvShow = model.createProperty("http://info216.uib.no/resource/hellojuna");
	Property movie = model.createProperty("http://info216.uib.no/resource/hellojuna");
	Property music = model.createProperty("http://info216.uib.no/resource/hellojuna");
	Property book = model.createProperty("http://info216.uib.no/resource/hellojuna");
	Property games = model.createProperty("http://info216.uib.no/resource/hellojuna");
	Property events = model.createProperty("http://info216.uib.no/resource/hellojuna");



			Resource person = model.createProperty("http://info216.uib.no/resource/hellojuna");
			person.addLiteral(tvShow, "1");
			person.addLiteral(movie, "1");
			person.addLiteral(music, "1");
			person.addLiteral(book, "1");
			person.addLiteral(games, "1");
			person.addLiteral(events, "1");
			
			System.out.println(person);
			
			
			StreamRDFWriter.write(os, model.getGraph(), Lang.TURTLE) ;

	}

}
