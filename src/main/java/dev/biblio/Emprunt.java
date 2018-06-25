package dev.biblio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	@Id
	private Integer id;
	
	@ManyToMany(mappedBy="emprunts")
	private Set<Livre> livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@Column(name = "DATE_DEBUT", nullable = false, unique = false)
	private LocalDate dateDebut;
	
	@Column(name = "DATE_FIN", nullable = true, unique = false)
	private LocalDate dateFin;
	
	@Column(name = "DELAI", nullable = true, unique = false)
	private Integer delai;
	
	public Emprunt(){
		livres = new HashSet<Livre>();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}
	
	
	
}
