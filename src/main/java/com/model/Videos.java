package com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.model.Favorite;

@Entity
@Table(name = "Videos")
public class Videos {
	@Id
	@Column(name = "Id")
	String id;

	@Column(name = "Title")
	String title;

	@Column(name = "Poster")
	String poster;

	@Column(name = "Description")
	String description;

	@Column(name = "Active")
	Boolean active;

	@Column(name = "Premium")
	Boolean premium;

	@Column(name = "Views")
	int views;

	@Column(name = "Link")
	String link;
	
	@OneToMany(mappedBy = "video")
	List<Favorite> favorites;

	public Videos(String id, String title, String poster, String description, Boolean active, Boolean premium,
			int views, String link) {
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.description = description;
		this.active = active;
		this.premium = premium;
		this.views = views;
		this.link = link;
	}

	// Default Constructor
	public Videos() {
	}

	// Getter and Setter methods
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getPremium() {
		return premium;
	}

	public void setPremium(Boolean premium) {
		this.premium = premium;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}
}
