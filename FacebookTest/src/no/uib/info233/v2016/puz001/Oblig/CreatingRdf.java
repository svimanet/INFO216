/**
 * 
 */
package no.uib.info233.v2016.puz001.Oblig;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;

/**
 * @author mariuslillevik
 *
 *         This class will be creating an RDF file that represents the users and
 *         their interests. Nothing yet.
 */
public class CreatingRdf {

	private Model model = ModelFactory.createDefaultModel();
	private Interests ir = new Interests();
	private Resource person = model.createProperty("http://info216.uib.no/resource/hellojuna");
	private Resource res = model.createResource("http://info216.uib.no/resource/hellojuna");

	private Property tvShow = model.createProperty("http://info216.uib.no/resource/tvShow");
	private Property movie = model.createProperty("http://info216.uib.no/resource/movie");
	private Property music = model.createProperty("http://info216.uib.no/resource/music");
	private Property book = model.createProperty("http://info216.uib.no/resource/book");
	private Property games = model.createProperty("http://info216.uib.no/resource/game");
	private Property events = model.createProperty("http://info216.uib.no/resource/event");
	private Property likes = model.createProperty("http://info216.uib.no/resource/likes");

	/**
	 * This method creates the jena model by adding all the interests to the
	 * model using the method created below.
	 */
	public void createModel() {
		addTvShows();
		addMovies();
		addMusic();
		addGames();
		addBooks();
		addEvent();
		addLike();

	}

	/**
	 * This is a method which adds all the games of the current user to the jena
	 * model and adds a uri to it.
	 */
	public void addGames() {
		for (int i = 0; i < ir.getGames().size(); i++) {

			String gameName = ir.getGames().get(i);
			String name = ir.getGames().get(i);

			@SuppressWarnings("unused")
			Resource game = this.model.createResource(gameName).addProperty(games, name);
		}
	}

	/**
	 * This is a method which adds all the movies of the current user to the
	 * jena model and adds a uri to it.
	 */
	public void addMovies() {
		for (int i = 0; i < ir.getMovies().size(); i++) {

			String gameName = ir.getMovies().get(i);
			String name = ir.getMovies().get(i);

			@SuppressWarnings("unused")
			Resource movies = this.model.createResource(gameName).addProperty(movie, name);
		}
	}

	/**
	 * This is a method which adds all the tvShows of the current user to the
	 * jena model and adds a uri to it.
	 */
	public void addTvShows() {
		for (int i = 0; i < ir.getTvShows().size(); i++) {

			String gameName = ir.getTvShows().get(i);
			String name = ir.getTvShows().get(i);

			@SuppressWarnings("unused")
			Resource movies = this.model.createResource(gameName).addProperty(tvShow, name);
		}
	}

	/**
	 * This is a method which adds all the music of the current user to the jena
	 * model and adds a uri to it.
	 */
	public void addMusic() {
		for (int i = 0; i < ir.getMusic().size(); i++) {

			String gameName = ir.getMusic().get(i);
			String name = ir.getMusic().get(i);

			@SuppressWarnings("unused")
			Resource musics = this.model.createResource(gameName).addProperty(music, name);
		}
	}

	/**
	 * This is a method which adds all the books of the current user to the jena
	 * model and adds a uri to it.
	 */
	public void addBooks() {
		for (int i = 0; i < ir.getBook().size(); i++) {

			String gameName = ir.getBook().get(i);
			String name = ir.getBook().get(i);

			@SuppressWarnings("unused")
			Resource books = this.model.createResource(gameName).addProperty(book, name);
		}
	}

	/**
	 * This is a method which adds all the events of the current user to the
	 * jena model and adds a uri to it.
	 */
	public void addEvent() {
		for (int i = 0; i < ir.getEvents().size(); i++) {

			String gameName = ir.getEvents().get(i);
			String name = ir.getEvents().get(i);

			@SuppressWarnings("unused")
			Resource movies = this.model.createResource(gameName).addProperty(events, name);
		}
	}

	/**
	 * This is a method which adds all the likes of the current user to the jena
	 * model and adds a uri to it.
	 */
	public void addLike() {
		for (int i = 0; i < ir.getLikes().size(); i++) {

			String gameName = ir.getLikes().get(i);
			String name = ir.getLikes().get(i);

			@SuppressWarnings("unused")
			Resource likesPages = this.model.createResource(gameName).addProperty(likes, name);
		}

	}

	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 * @return the person
	 */
	public Resource getPerson() {
		return person;
	}

	/**
	 * @param person
	 *            the person to set
	 */
	public void setPerson(Resource person) {
		this.person = person;
	}

	/**
	 * @return the tvShow
	 */
	public Property getTvShow() {
		return tvShow;
	}

	/**
	 * @param tvShow
	 *            the tvShow to set
	 */
	public void setTvShow(Property tvShow) {
		this.tvShow = tvShow;
	}

	/**
	 * @return the movie
	 */
	public Property getMovie() {
		return movie;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(Property movie) {
		this.movie = movie;
	}

	/**
	 * @return the music
	 */
	public Property getMusic() {
		return music;
	}

	/**
	 * @param music
	 *            the music to set
	 */
	public void setMusic(Property music) {
		this.music = music;
	}

	/**
	 * @return the book
	 */
	public Property getBook() {
		return book;
	}

	/**
	 * @param book
	 *            the book to set
	 */
	public void setBook(Property book) {
		this.book = book;
	}

	/**
	 * @return the games
	 */
	public Property getGames() {
		return games;
	}

	/**
	 * @param games
	 *            the games to set
	 */
	public void setGames(Property games) {
		this.games = games;
	}

	/**
	 * @return the events
	 */
	public Property getEvents() {
		return events;
	}

	/**
	 * @param events
	 *            the events to set
	 */
	public void setEvents(Property events) {
		this.events = events;
	}

	/**
	 * @return the res
	 */
	public Resource getRes() {
		return res;
	}

	/**
	 * @param res
	 *            the res to set
	 */
	public void setRes(Resource res) {
		this.res = res;
	}

	/**
	 * @return the ir
	 */
	public Interests getIr() {
		return ir;
	}

	/**
	 * @param ir
	 *            the ir to set
	 */
	public void setIr(Interests ir) {
		this.ir = ir;
	}

}
