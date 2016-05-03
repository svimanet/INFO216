package no.uib.info216.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

/**
 * Created by marius on 01.05.2016.
 */
public class FacebookData{

    // These are the fields for the main class.
    private String appId = "1565029937145946";
    private String appSecret = "69fec6df69ae3da5a308d62005f85976";
    private String accessToken = "";//"EAAWPYu13aFoBAAra0ZBcGf7aeYVKcTBveiR45Hf5aKpUr46ZCiO2sfdtMVEYwMarUKNRYzV5lZCOjEPe2YJKLWWQuUJDEfehHGrQfWlxr5qo0pmr6Xd47jwqEMutZA91iWKr13huOZAlFIZBarDjZCgrt141CUnqMIZD";
    private String appToken = "1565029937145946|RVWOId2jQZjW89yHa9fONbi4rto";
    private Facebook user = new FacebookFactory().getInstance();
    private Interests ir = new Interests();

    public FacebookData(){
        setupUser();
    }


    /**
     * This method sets up the facebook user and
     * gets all the interests and puts them in the lists
     * in the interests class.
     */
    public void setupUser(){
        user.setOAuthAppId(appId, appSecret);
        user.setOAuthPermissions(appToken);
        user.setOAuthAccessToken(new AccessToken(accessToken));
        //getUserInterests(); <<<<<<<-----------------------

    }

    /**
     * This method fetches the interests from the users
     * and puts them in the lists in Interests class
     */
    public void getUserInterests(){
        try {
            ir.getInterests(user);
        } catch (FacebookException e) {
            e.printStackTrace();
        }
    }

    public Interests getIr() {
        return ir;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Facebook getUser(){
        return user;
    }
}
