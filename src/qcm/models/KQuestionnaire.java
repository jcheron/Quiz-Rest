package qcm.models;

import com.google.gson.annotations.Expose;

import net.ko.kobject.KListObject;
import net.ko.persistence.annotation.Entity;
import net.ko.persistence.annotation.Table;

/**
 * Classe KQuestionnaire
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "questionnaire")
public class KQuestionnaire extends KRestObject {
	@Expose
	private java.sql.Date date;
	@Expose
	private int idDomaine;
	@Expose
	private String libelle;
	@Expose
	private KDomaine domaine;
	private KListObject<KGroupe> groupes;
	@Expose
	private KListObject<KQuestion> questions;
	private KListObject<KRealisation> realisations;

	public KQuestionnaire() {
		super();
		hasMany(KRealisation.class);
		belongsTo(KDomaine.class);
		hasMany(KQuestion.class);
		hasAndBelongsToMany(KGroupe_questionnaire.class, KGroupe.class);
	}

	/**
	 * return the value of date
	 * 
	 * @return date
	 */
	public java.sql.Date getDate() {
		return this.date;
	}

	/**
	 * return the value of idDomaine
	 * 
	 * @return idDomaine
	 */
	public int getIdDomaine() {
		return this.idDomaine;
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
	 * return the value of domaine
	 * 
	 * @return domaine
	 */
	public KDomaine getDomaine() {
		return this.domaine;
	}

	/**
	 * return the value of questions
	 * 
	 * @return questions
	 */
	public KListObject<KQuestion> getQuestions() {
		return this.questions;
	}

	/**
	 * return the value of realisations
	 * 
	 * @return realisations
	 */
	public KListObject<KRealisation> getRealisations() {
		return this.realisations;
	}

	/**
	 * set the value of date
	 * 
	 * @param aDate
	 */
	public void setDate(java.sql.Date aDate) {
		this.date = aDate;
	}

	/**
	 * set the value of idDomaine
	 * 
	 * @param aIdDomaine
	 */
	public void setIdDomaine(int aIdDomaine) {
		this.idDomaine = aIdDomaine;
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
	 * set the value of domaine
	 * 
	 * @param aDomaine
	 */
	public void setDomaine(KDomaine aDomaine) {
		this.domaine = aDomaine;
	}

	/**
	 * set the value of questions
	 * 
	 * @param aQuestions
	 */
	public void setQuestions(KListObject<KQuestion> aQuestions) {
		this.questions = aQuestions;
	}

	/**
	 * set the value of realisations
	 * 
	 * @param aRealisations
	 */
	public void setRealisations(KListObject<KRealisation> aRealisations) {
		this.realisations = aRealisations;
	}

	@Override
	public String toString() {
		return " [libelle] = " + libelle + " [date] = " + date + " [idDomaine] = " + idDomaine;
	}

	public KListObject<KGroupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(KListObject<KGroupe> groupes) {
		this.groupes = groupes;
	}

}