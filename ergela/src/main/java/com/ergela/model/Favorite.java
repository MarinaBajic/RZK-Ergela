package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the favorite database table.
 * 
 */
@Entity
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFavorite;

	//bi-directional many-to-one association to Horse
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idHorse")
	private Horse horse;

	//bi-directional many-to-one association to Rider
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRider")
	private Rider rider;

	public Favorite() {
	}

	public int getIdFavorite() {
		return this.idFavorite;
	}

	public void setIdFavorite(int idFavorite) {
		this.idFavorite = idFavorite;
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