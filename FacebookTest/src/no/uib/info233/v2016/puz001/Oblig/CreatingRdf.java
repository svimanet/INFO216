/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

/**
 * @author mariuslillevik
 *
 *This class will be creating an RDF file that represents the
 *users and their interests. Nothing yet.
 */
public class CreatingRdf {

	
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

	}

}
