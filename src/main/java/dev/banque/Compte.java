package dev.banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="COMPTE")
public class Compte {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "NUMERO",length = 50, nullable = false, unique = false)
	private String numero;
	
	@Column(name = "SOLDE", nullable = false, unique = false)
	private double solde;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns=@JoinColumn(name="ID_CPT", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_CLT", referencedColumnName="ID")
	)
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	
	public Compte(){
		this.operations = new HashSet<Operation>();
		this.clients = new HashSet<Client>();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the operations
	 */
	public Set<Client> getClients() {
		return clients;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setClient(Set<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	
	
	
}
