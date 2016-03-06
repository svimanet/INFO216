/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import java.util.ArrayList;

import facebook4j.Book;
import facebook4j.Event;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.Game;
import facebook4j.Like;
import facebook4j.Movie;
import facebook4j.Music;
import facebook4j.Television;

/**
 * @author mariuslillevik
 *
 *         The intention for this class is to create some sort of structure for
 *         the different interests for the different users.
 */
public class Interests {

	private ArrayList<String> tvShows = new ArrayList<String>();
	private ArrayList<String> movies = new ArrayList<String>();
	private ArrayList<String> music = new ArrayList<String>();
	private ArrayList<String> book = new ArrayList<String>();
	private ArrayList<String> games = new ArrayList<String>();
	private ArrayList<String> events = new ArrayList<String>();
	private ArrayList<String> likes = new ArrayList<String>();

	/**
	 * Constructor for the
	 * 
	 * @param shows
	 * @param movies
	 * @param music
	 * @param book
	 * @param games
	 * @param events
	 */
	public Interests() {

	}

	/**
	 * This is a simple method which prints all the interests the current user
	 * has and seperates them with categories.
	 * 
	 * @param fb
	 * @throws FacebookException
	 */
	public void getInterests(Facebook fb) throws FacebookException {

		for (Television t : fb.getTelevision()) {
			getTvShows().add(t.getName());
		}

		for (Movie m : fb.getMovies()) {
			getMovies().add(m.getName());
		}

		for (Music m : fb.getMusic()) {
			getMusic().add(m.getName());
		}

		for (Book b : fb.getBooks()) {
			getBook().add(b.getName());
		}

		for (Game g : fb.getGames()) {
			getGames().add(g.getName());
		}

		for (Event e : fb.getEvents()) {
			getEvents().add(e.getName());

			for (Like l : fb.getUserLikes()) {
				getLikes().add(l.getName());
			}

		}
	}

	/**
	 * @return the tvShows
	 */
	public ArrayList<String> getTvShows() {
		return tvShows;
	}

	/**
	 * @param tvShows
	 *            the tvShows to set
	 */
	public void setTvShows(ArrayList<String> tvShows) {
		this.tvShows = tvShows;
	}

	/**
	 * @return the movies
	 */
	public ArrayList<String> getMovies() {
		return movies;
	}

	/**
	 * @param movies
	 *            the movies to set
	 */
	public void setMovies(ArrayList<String> movies) {
		this.movies = movies;
	}

	/**
	 * @return the music
	 */
	public ArrayList<String> getMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(ArrayList<String> music) {
		this.music = music;
	}

	/**
	 * @return the book
	 */
	public ArrayList<String> getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(ArrayList<String> book) {
		this.book = book;
	}

	/**
	 * @return the games
	 */
	public ArrayList<String> getGames() {
		return games;
	}

	/**
	 * @param games
	 *            the games to set
	 */
	public void setGames(ArrayList<String> games) {
		this.games = games;
	}

	/**
	 * @return the events
	 */
	public ArrayList<String> getEvents() {
		return events;
	}

	/**
	 * @param events
	 *            the events to set
	 */
	public void setEvents(ArrayList<String> events) {
		this.events = events;
	}

	/**
	 * @return the likes
	 */
	public ArrayList<String> getLikes() {
		return likes;
	}

	/**
	 * @param likes
	 *            the likes to set
	 */
	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}

}
