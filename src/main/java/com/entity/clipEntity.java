package com.entity;

public class clipEntity {
	String videoID;
	String title;
	String poster;
	int views;
	String description;
	Boolean active;
	
	public clipEntity() {
		
	}
	
	public clipEntity(String videoID, String title, String poster, int views, String description, Boolean active) {
        this.videoID = videoID;
        this.title = title;
        this.poster = poster;
        this.views = views;
        this.description = description;
        this.active = active;
    }
	
	// Getter for videoID
    public String getVideoID() {
        return videoID;
    }

    // Setter for videoID
    public void setVideoID(String videoID) {
        this.videoID = videoID;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for poster
    public String getPoster() {
        return poster;
    }

    // Setter for poster
    public void setPoster(String poster) {
        this.poster = poster;
    }

    // Getter for views
    public int getViews() {
        return views;
    }

    // Setter for views
    public void setViews(int views) {
        this.views = views;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for active
    public Boolean isActive() {
        return active;
    }

    // Setter for active
    public void setActive(Boolean active) {
        this.active = active;
    }
}
