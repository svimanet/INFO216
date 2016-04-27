/**
 * 
 */
package no.uib.info216.facebook;

import java.io.FileWriter;
import java.io.IOException;

import com.hp.hpl.jena.ontology.OntModelSpec;
import facebook4j.*;
import facebook4j.auth.AccessToken;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.*;
import static com.hp.hpl.jena.assembler.JA.OntModelSpec;


/**
 * @author Marius This is the class which runs the program.
 */
public class FacebookFriends {

	// These are the fields for the main class.
	private static String appId = "1565029937145946";
	private static String appSecret = "69fec6df69ae3da5a308d62005f85976";
	private static String accessToken = "CAAWPYu13aFoBANPxUeh3v3mv5GA5eMv6s69PcpJzWugJu0u5dq8anPeETqOQiaZCeZBhH0AKEcdRDKmpTs9JXQZC0UO2Fzf3lSJ7ZBXsSkMqXQxG3JA4bFHZCQVdtrhG7UYr9BNh6VCbkOoSv43c5QwehhnOZA9aRBij7iNR2ZCZB70veAMajfcc";
	private static String appToken = "1565029937145946|RVWOId2jQZjW89yHa9fONbi4rto";
	private static String SOURCE = "http://www.eswc2006.org/technologies/ontology";
	private static Facebook user = new FacebookFactory().getInstance();
	private static no.uib.info216.facebook.CreatingRdf cr = new no.uib.info216.facebook.CreatingRdf();
	private static OntModel m = ModelFactory.createOntologyModel(com.hp.hpl.jena.ontology.OntModelSpec.OWL_MEM, cr.getModel());

	/**
	 * This is the main method which runs the program.
	 * 
	 * @param args
	 * @throws FacebookException
	 */
	public static void main(String[] args) throws FacebookException {
		user.setOAuthAppId(appId, appSecret);
		user.setOAuthPermissions(appToken);
		user.setOAuthAccessToken(new AccessToken(accessToken));

		cr.getIr().getInterests(user);
		cr.createModel();
		writeToFile(user);
	}

	/**
	 * This method writes the ontolgy model to a .ttl file. Which is rdf turtle
	 * syntax.
	 * @throws FacebookException 
	 * @throws IllegalStateException 
	 */
	public static void writeToFile(facebook4j.Facebook fb) throws IllegalStateException, FacebookException {
		FileWriter out = null;

		try {
			out = new FileWriter(fb.getId() + ".ttl");
			m.write(out, "TURTLE");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException ignore) {
				}
			}
		}
	}
}
