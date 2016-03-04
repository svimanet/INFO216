/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.util.ArrayList;

import facebook4j.*;
import facebook4j.auth.AccessToken;

/**
 * @author Marius 
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FacebookException 
	 */
	
	private static String appId = "1565029937145946";
	private static String appSecret = "69fec6df69ae3da5a308d62005f85976";
	private static String accessToken = "CAAWPYu13aFoBANPxUeh3v3mv5GA5eMv6s69PcpJzWugJu0u5dq8anPeETqOQiaZCeZBhH0AKEcdRDKmpTs9JXQZC0UO2Fzf3lSJ7ZBXsSkMqXQxG3JA4bFHZCQVdtrhG7UYr9BNh6VCbkOoSv43c5QwehhnOZA9aRBij7iNR2ZCZB70veAMajfcc";
	private static String appToken = "1565029937145946|RVWOId2jQZjW89yHa9fONbi4rto";	
	static Facebook user = new FacebookFactory().getInstance();
	
	
	
	public static void main(String[] args) throws FacebookException {
		CreatingRdf cr = new CreatingRdf();
			
		
		user.setOAuthAppId(appId, appSecret);
		user.setOAuthPermissions(appToken);
		user.setOAuthAccessToken(new AccessToken(accessToken));
		
		printInterests(user);
//		cr.createModel();

	}
	
	/**
	 * This is a simple method which prints all the interests
	 * the current user has and seperates them with categories.
	 * @param fb
	 * @throws FacebookException
	 */
	public static void printInterests(Facebook fb) throws FacebookException{
		System.out.println("TV-Shows");
		System.out.println("*******************************************");
		for(Television f : fb.getTelevision()){
			System.out.println(f.getName());			
		}
		System.out.println("*******************************************");

		System.out.println("Movies");
		System.out.println("*******************************************");
		for(Movie m : fb.getMovies()){
			System.out.println(m.getName());
		}
		System.out.println("*******************************************");
		
		System.out.println("Music");
		System.out.println("*******************************************");
		for(Music m : fb.getMusic()){
			System.out.println(m.getName());
		}
		System.out.println("*******************************************");
		
		System.out.println("Books");
		System.out.println("*******************************************");
		for(Book b : fb.getBooks()){
			System.out.println(b.getName());
		}
		System.out.println("*******************************************");

		System.out.println("Apps and Games");
		System.out.println("*******************************************");
		for(Game g : fb.getGames()){
			System.out.println(g.getName());
		}
		System.out.println("*******************************************");
		
		System.out.println("Events");
		System.out.println("*******************************************");
		for(Event e : fb.getEvents()){
			System.out.println(e.getName());
		}
		System.out.println("*******************************************");	
	}
	
	
	
	/**
	 * This method takes a user as a parameter and adds alle their
	 * interests based on category, into seperare lists.
	 * @param fb
	 * @throws FacebookException
	 */
	public static void addToList(Facebook fb) throws FacebookException{
		ArrayList<String> shows = new ArrayList<String>();
		for(Television t : fb.getTelevision()){
			shows.add(t.getName());
		}

		ArrayList<String> movies = new ArrayList<String>();
		for(Movie m : fb.getMovies()){
			movies.add(m.getName());
		}
		
		ArrayList<String> music = new ArrayList<String>();
		for(Music m : fb.getMusic()){
			music.add(m.getName());
		}

		ArrayList<String> books = new ArrayList<String>();
		for(Book b : fb.getBooks()){
			books.add(b.getName());
		}
		ArrayList<String> games = new ArrayList<String>();
		for(Game g : fb.getGames()){
			games.add(g.getName());
		}

		ArrayList<String> events = new ArrayList<String>();
		for(Event e : fb.getEvents()){
			events.add(e.getName());
		}
	}
		
		
		/**
		 * This is a simple print method which prints some of the values
		 * of all the friends in this currents users friends list, if they use the app.
		 * @throws FacebookException 
		 */
		public void getFriendInterests() throws FacebookException{
		for(Friend f : user.getFriends()){
			System.out.println(f.getName());
			System.out.println(f.getGender());
			System.out.println(f.getRelationshipStatus());
			System.out.println(f.getInterestedIn());  
		}
		}
	
	
	
	
	/**
	 * Getter for the Facebook user "user".
	 * @return
	 */
	public static Facebook user(){
		return user;
	}
	
}
