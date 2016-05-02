package no.uib.info216.facebook;

/**
 * Created by goat on 02.05.16.
 */
public class QueryFactory {

    public static String AllInsterestsFromUser(String user){
       String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + ">  ?property ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        return query;
    }

    public static String AllFromOneCategory(String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name  schema:" + category + " ?value  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        return query;
    }

    public static String UserInterestsFromOneCategory(String interest){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       ?name ?property " + "\"" + interest + "\"  " + //<Maggy_Kallestad>

                "      }" +
                "ORDER BY ASC(?o) ";


        return query;
    }

    public static String UserInterestsFromOneCategory(String user, String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + "> schema:" + category + " ?value" + //<Maggy_Kallestad>
                "      }" +
                "ORDER BY ASC(?o) ";


        return query;
    }

    //And so on... This does not nessesarily need to be static.


}
