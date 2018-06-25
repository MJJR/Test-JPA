package dev.banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	private int id;
	
	@Column(name = "NOM",length = 50, nullable = false, unique = false)
	private String nom;
	
	@Column(name = "PRENOM",length = 50, nullable = false, unique = false)
	private String prenom;
	
	@Column(name = "DATE_NAISSANCE",length = 50, nullable = false, unique = false)
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="ID_BANQUE")
	private Banque banque;
	
	public Client(){
		
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
