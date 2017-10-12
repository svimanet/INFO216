package no.uib.info216.facebook;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

public class FacebookData{

    // These are the fields for the main class.
    private String appId = "";
    private String appSecret = "";
    private String accessToken = "";
    private String appToken = "";
    private Facebook user = new FacebookFactory().getInstance();
    private Interests ir = new Interests();

    /**
     * This method sets up the facebook user and
     * gets all the interests and puts them in the lists
     * in the interests class.
     */
    public void setupUser(){
        user.setOAuthAppId(appId, appSecret);
        user.setOAuthPermissions(appToken);
        user.setOAuthAccessToken(new AccessToken(accessToken));
        getUserInterests();

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
