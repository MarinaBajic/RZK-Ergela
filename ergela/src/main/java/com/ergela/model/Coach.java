package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the coach database table.
 * 
 */
@Entity
@NamedQuery(name="Coach.findAll", query="SELECT c FROM Coach c")
public class Coach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCoach;

	private String name;

	private String surname;

	private int yearsOfExperience;

	//bi-directional many-to-one association to Rider
	@OneToMany(mappedBy="coach")
	private List<Rider> riders;

	public Coach() {
	}

	public int getIdCoach() {
		return this.idCoach;
	}

	public void setIdCoach(int idCoach) {
		this.idCoach = idCoach;
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

	public int getYearsOfExperience() {
		return this.yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public List<Rider> getRiders() {
		return this.riders;
	}

	public void setRiders(List<Rider> riders) {
		this.riders = riders;
	}

	public Rider addRider(Rider rider) {
		getRiders().add(rider);
		rider.setCoach(this);

		return rider;
	}

	public Rider removeRider(Rider rider) {
		getRiders().remove(rider);
		rider.setCoach(null);

		return rider;
	}

}