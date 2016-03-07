/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import facebook4j.*;
import facebook4j.auth.AccessToken;

/**
 * @author Marius This is the class which runs the program.
 */
public class Main {

	// These are the fields for the main class.
	private static String appId = "1565029937145946";
	private static String appSecret = "69fec6df69ae3da5a308d62005f85976";
	private static String accessToken = "CAAWPYu13aFoBANPxUeh3v3mv5GA5eMv6s69PcpJzWugJu0u5dq8anPeETqOQiaZCeZBhH0AKEcdRDKmpTs9JXQZC0UO2Fzf3lSJ7ZBXsSkMqXQxG3JA4bFHZCQVdtrhG7UYr9BNh6VCbkOoSv43c5QwehhnOZA9aRBij7iNR2ZCZB70veAMajfcc";
	private static String appToken = "1565029937145946|RVWOId2jQZjW89yHa9fONbi4rto";
	static Facebook user = new FacebookFactory().getInstance();
	static ArrayList<String> arrayList = new ArrayList<>();
	private static CreatingRdf cr = new CreatingRdf();
	private static OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, cr.getModel());

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
	 * This methid writes the ontolgy model to a .ttl file. Which is rdt turtle
	 * syntax.
	 * @throws FacebookException 
	 * @throws IllegalStateException 
	 */
	public static void writeToFile(Facebook fb) throws IllegalStateException, FacebookException {
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
