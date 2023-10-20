package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSession;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String description;

	private String time;

	//bi-directional many-to-one association to Horse
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHorse")
	private Horse horse;

	//bi-directional many-to-one association to Rider
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRider")
	private Rider rider;

	public Session() {
	}

	public int getIdSession() {
		return this.idSession;
	}

	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Horse getHorse() {
		return this.horse;
	}

	public void setHorse(Horse horse) {
		this.horse = horse;
	}

	public Rider getRider() {
		return this.rider;
	}

	public void setRider(Rider rider) {
		this.rider = rider;
	}

}