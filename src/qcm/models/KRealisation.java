package qcm.models;

import com.google.gson.annotations.Expose;

import net.ko.kobject.KListObject;
import net.ko.persistence.annotation.Entity;
import net.ko.persistence.annotation.Table;

/**
 * Classe KRealisation
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "realisation")
public class KRealisation extends KRestObject {
	@Expose
	private java.sql.Date date;
	private int idQuestionnaire;
	private int idUtilisateur;
	@Expose
	private int score;
	@Expose
	private KQuestionnaire questionnaire;
	private KListObject<KReponse_utilisateur> reponse_utilisateurs;
	private KUtilisateur utilisateur;

	public KRealisation() {
		super();
		// belongsTo(KUtilisateur.class);hasMany(KReponse_utilisateur.class);belongsTo(KQuestionnaire.class);
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
	 * return the value of idQuestionnaire
	 * 
	 * @return idQuestionnaire
	 */
	public int getIdQuestionnaire() {
		return this.idQuestionnaire;
	}

	/**
	 * return the value of idUtilisateur
	 * 
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	/**
	 * return the value of score
	 * 
	 * @return score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * return the value of questionnaire
	 * 
	 * @return questionnaire
	 */
	public KQuestionnaire getQuestionnaire() {
		return this.questionnaire;
	}

	/**
	 * return the value of reponse_utilisateurs
	 * 
	 * @return reponse_utilisateurs
	 */
	public KListObject<KReponse_utilisateur> getReponse_utilisateurs() {
		return this.reponse_utilisateurs;
	}

	/**
	 * return the value of utilisateur
	 * 
	 * @return utilisateur
	 */
	public KUtilisateur getUtilisateur() {
		return this.utilisateur;
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
	 * set the value of idQuestionnaire
	 * 
	 * @param aIdQuestionnaire
	 */
	public void setIdQuestionnaire(int aIdQuestionnaire) {
		this.idQuestionnaire = aIdQuestionnaire;
	}

	/**
	 * set the value of idUtilisateur
	 * 
	 * @param aIdUtilisateur
	 */
	public void setIdUtilisateur(int aIdUtilisateur) {
		this.idUtilisateur = aIdUtilisateur;
	}

	/**
	 * set the value of score
	 * 
	 * @param aScore
	 */
	public void setScore(int aScore) {
		this.score = aScore;
	}

	/**
	 * set the value of questionnaire
	 * 
	 * @param aQuestionnaire
	 */
	public void setQuestionnaire(KQuestionnaire aQuestionnaire) {
		this.questionnaire = aQuestionnaire;
	}

	/**
	 * set the value of reponse_utilisateurs
	 * 
	 * @param aReponse_utilisateurs
	 */
	public void setReponse_utilisateurs(KListObject<KReponse_utilisateur> aReponse_utilisateurs) {
		this.reponse_utilisateurs = aReponse_utilisateurs;
	}

	/**
	 * set the value of utilisateur
	 * 
	 * @param aUtilisateur
	 */
	public void setUtilisateur(KUtilisateur aUtilisateur) {
		this.utilisateur = aUtilisateur;
	}

	@Override
	public String toString() {
		return " [score] = " + score + " [idUtilisateur] = " + idUtilisateur + " [idQuestionnaire] = " + idQuestionnaire + " [date] = " + date;
	}
}