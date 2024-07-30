package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NamedQuery;

//@NamedNativeQuery(
//	    name = "favorites.Report",
//	    query = "SELECT VideoId, COUNT(UserId) AS so_lan, MIN(LikeDate) AS minLikeDate, MAX(LikeDate) AS maxLikeDate FROM Favorites GROUP BY VideoId",
//	    resultClass = Object[].class
//	)


@Entity
@Table(name = "Favorites", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"VideoId", "UserId"})
})
public class Favorite {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne @JoinColumn(name = "UserId")
	Users user;
	
	@ManyToOne @JoinColumn(name = "VideoId")
	Videos video;
	
	@Temporal(TemporalType.DATE)
	Date likeDate = new Date();
	
	public Favorite() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Videos getVideo() {
		return video;
	}
	public void setVideo(Videos video) {
		this.video = video;
	}
	public Date getLikeDate() {
		return likeDate;
	}
	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}
}
