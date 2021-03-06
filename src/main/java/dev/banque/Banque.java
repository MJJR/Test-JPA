package dev.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Banque.java
 * 
 * @author matth
 */
@Entity
@Table(name = "BANQUE")
public class Banque {

	/**
	 * id : int
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	/**
	 * clients : Set<Client>
	 */
	@OneToMany(mappedBy = "banque")
	private Set<Client> clients;

	/**
	 * nom : String
	 */
	@Column(name = "NOM", length = 50, nullable = false, unique = true)
	private String nom;

	/**
	 * Constructor of Banque.java
	 */
	public Banque() {
		clients = new HashSet<Client>();
	}

	/**
	 * @return the clients
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients
	 *            the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
