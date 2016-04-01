package qcm.models.pojo;

import java.util.List;
import java.util.ArrayList;


/**
* Classe Realisation
*/
public class Realisation {
	private java.sql.Date date;
	private int id;
	private int idQuestionnaire;
	private int idUtilisateur;
	private int score;
	private Questionnaire questionnaire;
	private List<Reponse_utilisateur> reponse_utilisateurs;
	private Utilisateur utilisateur;

	public Realisation() {
		super();
		utilisateur=new Utilisateur();reponse_utilisateurs=new ArrayList<>();questionnaire=new Questionnaire();
	}
	/**
	 * return the value of date
	 * @return date
	 */
	public java.sql.Date getDate(){
		return this.date;
	}
	/**
	 * return the value of id
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * return the value of idQuestionnaire
	 * @return idQuestionnaire
	 */
	public int getIdQuestionnaire(){
		return this.idQuestionnaire;
	}
	/**
	 * return the value of idUtilisateur
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur(){
		return this.idUtilisateur;
	}
	/**
	 * return the value of score
	 * @return score
	 */
	public int getScore(){
		return this.score;
	}
	/**
	 * return the value of questionnaire
	 * @return questionnaire
	 */
	public Questionnaire getQuestionnaire(){
		return this.questionnaire;
	}
	/**
	 * return the value of reponse_utilisateurs
	 * @return reponse_utilisateurs
	 */
	public List<Reponse_utilisateur> getReponse_utilisateurs(){
		return this.reponse_utilisateurs;
	}
	/**
	 * return the value of utilisateur
	 * @return utilisateur
	 */
	public Utilisateur getUtilisateur(){
		return this.utilisateur;
	}

	/**
	 * set the value of date
	 * @param aDate
	 */
	public void setDate(java.sql.Date aDate){
		this.date=aDate;
	}
	/**
	 * set the value of id
	 * @param aId
	 */
	public void setId(int aId){
		this.id=aId;
	}
	/**
	 * set the value of idQuestionnaire
	 * @param aIdQuestionnaire
	 */
	public void setIdQuestionnaire(int aIdQuestionnaire){
		this.idQuestionnaire=aIdQuestionnaire;
	}
	/**
	 * set the value of idUtilisateur
	 * @param aIdUtilisateur
	 */
	public void setIdUtilisateur(int aIdUtilisateur){
		this.idUtilisateur=aIdUtilisateur;
	}
	/**
	 * set the value of score
	 * @param aScore
	 */
	public void setScore(int aScore){
		this.score=aScore;
	}
	/**
	 * set the value of questionnaire
	 * @param aQuestionnaire
	 */
	public void setQuestionnaire(Questionnaire aQuestionnaire){
		this.questionnaire=aQuestionnaire;
	}
	/**
	 * set the value of reponse_utilisateurs
	 * @param aReponse_utilisateurs
	 */
	public void setReponse_utilisateurs(List<Reponse_utilisateur> aReponse_utilisateurs){
		this.reponse_utilisateurs=aReponse_utilisateurs;
	}
	/**
	 * set the value of utilisateur
	 * @param aUtilisateur
	 */
	public void setUtilisateur(Utilisateur aUtilisateur){
		this.utilisateur=aUtilisateur;
	}
	@Override
	public String toString() {
		return " [date] = " + date+" [score] = " + score+" [idQuestionnaire] = " + idQuestionnaire+" [idUtilisateur] = " + idUtilisateur+" [id] = " + id;
	}
}