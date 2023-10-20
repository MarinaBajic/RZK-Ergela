package com.ergela.model;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 * The persistent class for the ergela_user_role database table.
 * 
 */
@Entity
@Table(name="ergela_user_role")
@NamedQuery(name="ErgelaUserRole.findAll", query="SELECT e FROM ErgelaUserRole e")
public class ErgelaUserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUserRole;

	//bi-directional many-to-one association to ErgelaRole
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idRole")
	private ErgelaRole ergelaRole;

	//bi-directional many-to-one association to ErgelaUser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idUser")
	private ErgelaUser ergelaUser;

	public ErgelaUserRole() {
	}

	public int getIdUserRole() {
		return this.idUserRole;
	}

	public void setIdUserRole(int idUserRole) {
		this.idUserRole = idUserRole;
	}

	public ErgelaRole getErgelaRole() {
		return this.ergelaRole;
	}

	public void setErgelaRole(ErgelaRole ergelaRole) {
		this.ergelaRole = ergelaRole;
	}

	public ErgelaUser getErgelaUser() {
		return this.ergelaUser;
	}

	public void setErgelaUser(ErgelaUser ergelaUser) {
		this.ergelaUser = ergelaUser;
	}

}