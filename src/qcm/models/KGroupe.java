package qcm.models;

import com.google.gson.annotations.Expose;

import net.ko.kobject.KListObject;
import net.ko.persistence.annotation.Entity;
import net.ko.persistence.annotation.Table;

/**
 * Classe KGroupe
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "groupe")
public class KGroupe extends KRestObject {
	@Expose
	private String code;
	@Expose
	private String libelle;
	@Expose
	private KListObject<KQuestionnaire> questionnaires;
	@Expose
	private KListObject<KUtilisateur> utilisateurs;

	public KGroupe() {
		super();
		// hasMany(KGroupe_utilisateur.class);hasMany(KGroupe_questionnaire.class);
		hasAndBelongsToMany(KGroupe_questionnaire.class, KQuestionnaire.class);
		hasAndBelongsToMany(KUtilisateur_Groupe.class, KUtilisateur.class);
	}

	/**
	 * return the value of code
	 * 
	 * @return code
	 */
	public String getCode() {
		return this.code;
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
	 * set the value of code
	 * 
	 * @param aCode
	 */
	public void setCode(String aCode) {
		this.code = aCode;
	}

	/**
	 * set the value of libelle
	 * 
	 * @param aLibelle
	 */
	public void setLibelle(String aLibelle) {
		this.libelle = aLibelle;
	}

	@Override
	public String toString() {
		return " [libelle] = " + libelle + " [code] = " + code;
	}

	public KListObject<KQuestionnaire> getQuestionnaires() {
		return questionnaires;
	}

	public void setQuestionnaires(KListObject<KQuestionnaire> questionnaires) {
		this.questionnaires = questionnaires;
	}

	public KListObject<KUtilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(KListObject<KUtilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}