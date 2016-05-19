package no.uib.info216.RDF.Queries;

import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.query.ResultSet;


/**
 * Created by goat on 02.05.16.
 */
public class FacebookQueries {

    private RDFHandler rdfHandler;


    public FacebookQueries(RDFHandler rdfHandler){
        this.rdfHandler = rdfHandler;

    }

    /**
     * This method finds all the interests of
     * the given user in the parameter.
     * @param user
     */
    public ResultSet AllInsterestsFromUser(String user){
       String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + ">  ?property ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";

        return rdfHandler.runSparql(query);

    }


    public ResultSet AllUsers(){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                " ?res a foaf:Person ;" +
                " foaf:name ?name." +
                "      }";

        return rdfHandler.runSparql(query);

    }



    /**
     * This method finds all the Users and their interests

    /**
     * This method finds all the Users and their interests
     * in the given Category from the parameter.
     * @param category
     */
    public ResultSet AllFromOneCategory(String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name  schema:" + category + " ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        return rdfHandler.runSparql(query);
    }

    /**
     * This method finds all the users who has one given
     * interest and the given category it is in.
     * @param interest
     */
    public ResultSet UserInterestsFromOneCategory(String interest){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name ?property " + "\"" + interest + "\"  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        return rdfHandler.runSparql(query);
    }

    /**
     * This method finds all interests for a given user
     * in a given category.
     * @param user
     * @param category
     */
    public ResultSet UserInterestsFromOneCategory(String user, String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + "> schema:" + category + " ?value" + //<Maggy_Kallestad>
                "      }" +
                "ORDER BY ASC(?o) ";


        return rdfHandler.runSparql(query);

    }


}
