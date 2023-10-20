package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rider database table.
 * 
 */
@Entity
@NamedQuery(name="Rider.findAll", query="SELECT r FROM Rider r")
public class Rider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRider;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@Temporal(TemporalType.DATE)
	private Date dateOfEnrollment;

	private String name;

	private String surname;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="rider")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Coach
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCoach")
	private Coach coach;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="rider")
	private List<Session> sessions;

	public Rider() {
	}

	public int getIdRider() {
		return this.idRider;
	}

	public void setIdRider(int idRider) {
		this.idRider = idRider;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfEnrollment() {
		return this.dateOfEnrollment;
	}

	public void setDateOfEnrollment(Date dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setRider(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setRider(null);

		return favorite;
	}

	public Coach getCoach() {
		return this.coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}

	public List<Session> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	public Session addSession(Session session) {
		getSessions().add(session);
		session.setRider(this);

		return session;
	}

	public Session removeSession(Session session) {
		getSessions().remove(session);
		session.setRider(null);

		return session;
	}

}