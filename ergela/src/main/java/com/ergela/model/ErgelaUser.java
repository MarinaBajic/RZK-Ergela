package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ergela_user database table.
 * 
 */
@Entity
@Table(name="ergela_user")
@NamedQuery(name="ErgelaUser.findAll", query="SELECT e FROM ErgelaUser e")
public class ErgelaUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String email;

	private String name;

	private String password;

	private String surname;

	private String username;

	//bi-directional many-to-one association to ErgelaUserRole
	@OneToMany(mappedBy="ergelaUser")
	private List<ErgelaUserRole> ergelaUserRoles;

	public ErgelaUser() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ErgelaUserRole> getErgelaUserRoles() {
		return this.ergelaUserRoles;
	}

	public void setErgelaUserRoles(List<ErgelaUserRole> ergelaUserRoles) {
		this.ergelaUserRoles = ergelaUserRoles;
	}

	public ErgelaUserRole addErgelaUserRole(ErgelaUserRole ergelaUserRole) {
		getErgelaUserRoles().add(ergelaUserRole);
		ergelaUserRole.setErgelaUser(this);

		return ergelaUserRole;
	}

	public ErgelaUserRole removeErgelaUserRole(ErgelaUserRole ergelaUserRole) {
		getErgelaUserRoles().remove(ergelaUserRole);
		ergelaUserRole.setErgelaUser(null);

		return ergelaUserRole;
	}

}