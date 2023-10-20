package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the horse database table.
 * 
 */
@Entity
@NamedQuery(name="Horse.findAll", query="SELECT h FROM Horse h")
public class Horse implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHorse;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String fullName;

	private String gender;

	private String nickname;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="horse")
	@JsonIgnore
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Breed
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idBreed")
	@JsonIgnore
	private Breed breed;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="horse")
	@JsonIgnore
	private List<Session> sessions;

	public Horse() {
	}

	public int getIdHorse() {
		return this.idHorse;
	}

	public void setIdHorse(int idHorse) {
		this.idHorse = idHorse;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setHorse(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setHorse(null);

		return favorite;
	}

	public Breed getBreed() {
		return this.breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setHorse(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setHorse(null);

		return session;
	}

}