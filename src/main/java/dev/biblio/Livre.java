package dev.biblio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	
	@Id
	@Column(name="ID")
	private Integer id;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID")
	)
	private Set<Emprunt> emprunts;
	
	@Column(name = "TITRE",length = 255, nullable = false, unique = false)
	private String titre;
	
	@Column(name = "AUTEUR",length = 50, nullable = false, unique = false)
	private String auteur;
	
	public Livre(){
		emprunts = new HashSet<Emprunt>();
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
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
	
	

}
