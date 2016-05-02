package no.uib.info216.facebook;

import no.uib.info216.RDF.RDFHandler;


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
    public void AllInsterestsFromUser(String user){
       String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + ">  ?property ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";

        rdfHandler.runSparql(query);
    }

    /**
     * This method finds all the Users and their interests
     * in the given Category from the parameter.
     * @param category
     */
    public void AllFromOneCategory(String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name  schema:" + category + " ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        rdfHandler.runSparql(query);
    }

    /**
     * This method finds all the users who has one given
     * interest and the given category it is in.
     * @param interest
     */
    public void UserInterestsFromOneCategory(String interest){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name ?property " + "\"" + interest + "\"  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        rdfHandler.runSparql(query);
    }

    /**
     * This method finds all interests for a given user
     * in a given category.
     * @param user
     * @param category
     */
    public void UserInterestsFromOneCategory(String user, String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + "> schema:" + category + " ?value" + //<Maggy_Kallestad>
                "      }" +
                "ORDER BY ASC(?o) ";


        rdfHandler.runSparql(query);
    }


}
