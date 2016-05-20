package no.uib.info216.facebook;



import no.uib.info216.RDF.Queries.FacebookQueries;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;


import java.util.ArrayList;

/**
 * Created by marius on 20.05.2016.
 */
public class User {


    private ArrayList<String> knows = new ArrayList<>();
    private CreateModels cm;
    private FacebookQueries fq;

    public User(CreateModels cm, FacebookQueries fq){
        this.cm = cm;
        this.fq = fq;
        getKnows();
        getAllFriends();
    }

    public void getKnows(){
        ResultSet rs = fq.UserKnowns();

        while(rs.hasNext()){
            QuerySolution row = rs.next();
            knows.add(row.get("value").toString());
        }

        for(String s : knows){
            System.out.println(s);
        }
    rs.getResourceModel().close();
    }

    public void getAllFriends(){
        for (String s : knows){
            ResultSet rs = fq.sameInterests(s);

            while(rs.hasNext()){
                QuerySolution row = rs.next();
                System.out.println(row.get("user"));
                System.out.println(row.get("prop"));
                System.out.println(row.get("object"));
            }
        }
    }




}
