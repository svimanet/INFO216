package no.uib.info216.Models;

/**
 * Created by fox on 5/20/16.
 */
public class Event {
    private String name;
    private String location;
    private String description;
    private String category;
    private String url;
    private String doorTime;
    private String date;

    public Event(String name, String location, String description, String category, String url, String doorTime, String date) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.category = category;
        this.url = url;
        this.doorTime = doorTime;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDoorTime() {
        return doorTime;
    }

    public void setDoorTime(String doorTime) {
        this.doorTime = doorTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
