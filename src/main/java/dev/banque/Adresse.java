package dev.banque;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
public class Adresse {
	
	
	@Column(name = "NUMERO", nullable = false, unique = false)
	private int numero;
	@Column(name = "RUE",length = 100, nullable = false, unique = false)
	private String rue;
	@Column(name = "CODE_POSTAL", nullable = false, unique = false)
	private int codePostal;
	@Column(name = "VILLE",length = 50, nullable = false, unique = false)
	private String ville;
	
	public Adresse(){
		
	}

	/**
	 * @return the id
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param id the id to set
	 */
	public void setNumero(int id) {
		this.numero = id;
	}

	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
}
