package qcm.models;

import com.google.gson.annotations.Expose;

import net.ko.kobject.KListObject;
import net.ko.persistence.annotation.Entity;
import net.ko.persistence.annotation.Table;

/**
 * Classe KRang
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "rang")
public class KRang extends KRestObject {
	@Expose
	private String libelle;
	private KListObject<KUtilisateur> utilisateurs;

	public KRang() {
		super();
		// hasMany(KUtilisateur.class);
	}

	/**
	 * return the value of libelle
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * return the value of utilisateurs
	 * 
	 * @return utilisateurs
	 */
	public KListObject<KUtilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	/**
	 * set the value of libelle
	 * 
	 * @param aLibelle
	 */
	public void setLibelle(String aLibelle) {
		this.libelle = aLibelle;
	}

	/**
	 * set the value of utilisateurs
	 * 
	 * @param aUtilisateurs
	 */
	public void setUtilisateurs(KListObject<KUtilisateur> aUtilisateurs) {
		this.utilisateurs = aUtilisateurs;
	}

	@Override
	public String toString() {
		return " [libelle] = " + libelle;
	}
}