package no.uib.info216.RDF.Queries;

import no.uib.info216.RDF.RDFHandler;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

import java.util.*;


public class FacebookQueries {

    private RDFHandler rdfHandler;
    private ArrayList<String> interestCategories;


    public FacebookQueries(RDFHandler rdfHandler){
        this.interestCategories = new ArrayList<String>();
        interestCategories.add("TVSeries");
        interestCategories.add("Movies");
        interestCategories.add("MusicRecording");
        interestCategories.add("Book");
        interestCategories.add("Game");
        interestCategories.add("Event");
        interestCategories.add("UserLikes");

        this.rdfHandler = rdfHandler;

    }

    public ResultSet sameInterests(){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "        ?bruker schema:Game ?value  " +

                "      }" +
                "ORDER BY ASC(?property) ";

        String test = "\"PREFIX schema: <http://schema.org/>\"" +
                " select * where {\n" +
                "  values * { ?x ?a ?o }\n" +
                "  filter(regex(?x, 'http://schema.org/')" +
                "}";

        return rdfHandler.runSparql(test);
    }

    public ResultSet UserKnowns(){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "        <http://uib.no/info216/User> ?property ?value  " +

                "      }" +
                "ORDER BY ASC(?property) ";

        return rdfHandler.runSparql(query);
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
                "       <" + user + ">  ?property ?value  " +

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

    public ResultSet UserInterestsFromOneCategory(String user, String category){
        String query =  "PREFIX schema: <http://schema.org/>" +
                "SELECT  * " +
                "WHERE {" +
                "       <" + user + "> schema:" + category + " ?value" + //<Maggy_Kallestad>
                "      }" +
                "ORDER BY ASC(?o) ";


        return rdfHandler.runSparql(query);

    }


    /**
     *
     * @param name
     * @param interest
     * @return
     */

    public ArrayList<String> getAllInterestOfFriend(String name, String interest){
        String query = "SELECT  * " +
                "WHERE {" +
                " ?uri a foaf:Person ; " +
                " foaf:name \""+name+"\" ; " +
                " schema:"+interest+" ?interest . " +
                "      }" +
                "";
        ResultSet rs = rdfHandler.runSparql(query);
        ArrayList<String> res = new ArrayList<String>();
        while(rs.hasNext()){
            QuerySolution row = rs.next();
            res.add(row.get("interest").toString());
        }
        return res;
    }

    public ArrayList<String> getAllInterestOfUser(String interest){
        String query = "SELECT  * " +
                "WHERE {" +
                " <http://uib.no/info216/User> a foaf:Person ; " +
                " schema:"+interest+" ?interest . " +
                "      }" +
                "";
        ResultSet rs = rdfHandler.runSparql(query);
        ArrayList<String> res = new ArrayList<String>();
        while(rs.hasNext()){
            QuerySolution row = rs.next();
            res.add(row.get("interest").toString());
        }
        return res;

    }

    public ArrayList<ArrayList<String>> GetFriendInterestScore(){
        HashMap<String, ArrayList<String>> userInterest = new HashMap<String, ArrayList<String>>();
        for(String userInterestItem : this.interestCategories){
            userInterest.put(userInterestItem, this.getAllInterestOfUser(userInterestItem));
        }

        String query = "SELECT  DISTINCT ?name ?friendName " +
                        "WHERE {" +
                        " ?a  foaf:knows ?b ." +
                        " ?a  foaf:name ?name ." +
                        " ?b  foaf:name ?friendName ." +
                        "      }";


        ResultSet rs = rdfHandler.runSparql(query);
        //ResultSetFormatter.out(System.out, rs);
        QuerySolution response = rs.next();

        HashMap<String, Integer> friendScore= new HashMap<String, Integer>();

        while(rs.hasNext()){
            QuerySolution row = rs.next();
            friendScore.put(row.get("friendName").toString(), 0);
            for(String friendInterest: this.interestCategories) {
                ArrayList<String> interestsFromOneCategory = this.getAllInterestOfFriend(row.get("friendName").toString(), friendInterest);
                ArrayList<String> oneInterestFromUser = userInterest.get(friendInterest);
                int score = this.calculateScore(interestsFromOneCategory, oneInterestFromUser);
                friendScore.put(row.get("friendName").toString(), friendScore.get(row.get("friendName").toString())+score);
            }
        }
        Iterator<Map.Entry<String, Integer>> entries = friendScore.entrySet().iterator();
        Map<String, Integer> sorted = this.sortByValue(friendScore);
        entries = sorted.entrySet().iterator();
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        while (entries.hasNext()) {
            ArrayList<String> singleItem = new ArrayList<String>();
            Map.Entry<String, Integer> entry = entries.next();
            singleItem.add(entry.getKey());
            singleItem.add(entry.getValue().toString());
            ret.add(singleItem);
        }
        Collections.reverse(ret);
        return ret;

    }

    private Map sortByValue(Map map) {
         List list = new LinkedList(map.entrySet());
         Collections.sort(list, new Comparator() {
              public int compare(Object o1, Object o2) {
                   return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
              }
         });

        Map result = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry)it.next();
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private int calculateScore(ArrayList<String> friend, ArrayList<String> user) {
        int score = 0;
        for(String item: friend){
            if(user.contains(item)){
                score += 1;
            }
        }
        double finalScore;
        try {
            finalScore = ((double)score / (double)user.size()) * 100.0;
        }catch(ArithmeticException e){
            finalScore = 0.0;
        }
        return (int)Math.ceil(finalScore);
    }
}
