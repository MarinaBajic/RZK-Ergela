package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the breed database table.
 * 
 */
@Entity
@NamedQuery(name="Breed.findAll", query="SELECT b FROM Breed b")
public class Breed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBreed;

	private String coatColor;

	private String name;

	//bi-directional many-to-one association to Horse
	@OneToMany(mappedBy="breed")
	@JsonIgnore
	private List<Horse> horses;

	public Breed() {
	}

	public int getIdBreed() {
		return this.idBreed;
	}

	public void setIdBreed(int idBreed) {
		this.idBreed = idBreed;
	}

	public String getCoatColor() {
		return this.coatColor;
	}

	public void setCoatColor(String coatColor) {
		this.coatColor = coatColor;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Horse> getHorses() {
		return this.horses;
	}

	public void setHorses(List<Horse> horses) {
		this.horses = horses;
	}

	public Horse addHors(Horse hors) {
		getHorses().add(hors);
		hors.setBreed(this);

		return hors;
	}

	public Horse removeHors(Horse hors) {
		getHorses().remove(hors);
		hors.setBreed(null);

		return hors;
	}

}