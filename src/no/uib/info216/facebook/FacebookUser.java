package no.uib.info216.facebook;

import java.util.ArrayList;

/**
 * Created by marius on 29.04.2016.
 */
public class FacebookUser {

    private String name = new String();
    private int id = 0;

    private ArrayList<String> tvShows = new ArrayList<String>();
    private ArrayList<String> movies = new ArrayList<String>();
    private ArrayList<String> music = new ArrayList<String>();
    private ArrayList<String> book = new ArrayList<String>();
    private ArrayList<String> games = new ArrayList<String>();
    private ArrayList<String> events = new ArrayList<String>();
    private ArrayList<String> likes = new ArrayList<String>();


    public FacebookUser(ArrayList<String> tvShows, ArrayList<String> movies, ArrayList<String> music, ArrayList<String> book, ArrayList<String>games, ArrayList<String>events, ArrayList<String> likes){
        this.tvShows = tvShows;
        this.movies = movies;
        this.music = music;
        this.book = book;
        this.games = games;
        this.events = events;
        this.likes = likes;
    }


    public ArrayList<String> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<String> likes) {
        this.likes = likes;
    }

    public ArrayList<String> getEvents() {

        return events;
    }

    public void setEvents(ArrayList<String> events) {
        this.events = events;
    }

    public ArrayList<String> getGames() {

        return games;
    }

    public void setGames(ArrayList<String> games) {
        this.games = games;
    }

    public ArrayList<String> getBook() {

        return book;
    }

    public void setBook(ArrayList<String> book) {
        this.book = book;
    }

    public ArrayList<String> getMusic() {

        return music;
    }

    public void setMusic(ArrayList<String> music) {
        this.music = music;
    }

    public ArrayList<String> getMovies() {

        return movies;
    }

    public void setMovies(ArrayList<String> movies) {
        this.movies = movies;
    }

    public ArrayList<String> getTvShows() {

        return tvShows;
    }

    public void setTvShows(ArrayList<String> tvShows) {
        this.tvShows = tvShows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
