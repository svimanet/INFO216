/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.util.ArrayList;

/**
 * @author mariuslillevik
 *
 *The intention for this class is to create some sort of 
 *structure for the different interests for the different users.
 *
 */
public class Interests {
	
	private ArrayList<String> tvShows;
	private String movies;
	private String music;
	private String book;
	private String games;
	private String events;
	private ArrayList<Interests> interests = new ArrayList<Interests>();
	
	
	/**
	 * Constructor for the 
	 * @param shows
	 * @param movies
	 * @param music
	 * @param book
	 * @param games
	 * @param events
	 */
	public Interests(){//String shows, String movies, String music, String book, String games, String events

	}


	/**
	 * @return the tvShows
	 */
	public ArrayList<String> getTvShows() {
		return tvShows;
	}


	/**
	 * @param tvShows the tvShows to set
	 */
	public void setTvShows(ArrayList<String> tvShows) {
		this.tvShows = tvShows;
	}


	/**
	 * @return the movies
	 */
	public String getMovies() {
		return movies;
	}


	/**
	 * @param movies the movies to set
	 */
	public void setMovies(String movies) {
		this.movies = movies;
	}


	/**
	 * @return the music
	 */
	public String getMusic() {
		return music;
	}


	/**
	 * @param music the music to set
	 */
	public void setMusic(String music) {
		this.music = music;
	}


	/**
	 * @return the book
	 */
	public String getBook() {
		return book;
	}


	/**
	 * @param book the book to set
	 */
	public void setBook(String book) {
		this.book = book;
	}


	/**
	 * @return the games
	 */
	public String getGames() {
		return games;
	}


	/**
	 * @param games the games to set
	 */
	public void setGames(String games) {
		this.games = games;
	}


	/**
	 * @return the events
	 */
	public String getEvents() {
		return events;
	}


	/**
	 * @param events the events to set
	 */
	public void setEvents(String events) {
		this.events = events;
	}


	/**
	 * @return the interests
	 */
	public ArrayList<Interests> getInterests() {
		return interests;
	}


	/**
	 * @param interests the interests to set
	 */
	public void setInterests(ArrayList<Interests> interests) {
		this.interests = interests;
	}
	
	
	
	
	

}
