package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the ergela_role database table.
 * 
 */
@Entity
@Table(name="ergela_role")
@NamedQuery(name="ErgelaRole.findAll", query="SELECT e FROM ErgelaRole e")
public class ErgelaRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String name;

	//bi-directional many-to-one association to ErgelaUserRole
	@OneToMany(mappedBy="ergelaRole")
	private List<ErgelaUserRole> ergelaUserRoles;

	public ErgelaRole() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ErgelaUserRole> getErgelaUserRoles() {
		return this.ergelaUserRoles;
	}

	public void setErgelaUserRoles(List<ErgelaUserRole> ergelaUserRoles) {
		this.ergelaUserRoles = ergelaUserRoles;
	}

	public ErgelaUserRole addErgelaUserRole(ErgelaUserRole ergelaUserRole) {
		getErgelaUserRoles().add(ergelaUserRole);
		ergelaUserRole.setErgelaRole(this);

		return ergelaUserRole;
	}

	public ErgelaUserRole removeErgelaUserRole(ErgelaUserRole ergelaUserRole) {
		getErgelaUserRoles().remove(ergelaUserRole);
		ergelaUserRole.setErgelaRole(null);

		return ergelaUserRole;
	}

}