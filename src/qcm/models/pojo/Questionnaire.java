package qcm.models.pojo;

import java.util.List;
import java.util.ArrayList;


/**
* Classe Questionnaire
*/
public class Questionnaire {
	private java.sql.Date date;
	private int id;
	private int idDomaine;
	private int idUtilisateur;
	private String libelle;
	private Domaine domaine;
	private List<Groupe_questionnaire> groupe_questionnaires;
	private List<Question> questions;
	private List<Realisation> realisations;
	private Utilisateur utilisateur;

	public Questionnaire() {
		super();
		utilisateur=new Utilisateur();realisations=new ArrayList<>();questions=new ArrayList<>();groupe_questionnaires=new ArrayList<>();domaine=new Domaine();
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
	 * return the value of idDomaine
	 * @return idDomaine
	 */
	public int getIdDomaine(){
		return this.idDomaine;
	}
	/**
	 * return the value of idUtilisateur
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur(){
		return this.idUtilisateur;
	}
	/**
	 * return the value of libelle
	 * @return libelle
	 */
	public String getLibelle(){
		return this.libelle;
	}
	/**
	 * return the value of domaine
	 * @return domaine
	 */
	public Domaine getDomaine(){
		return this.domaine;
	}
	/**
	 * return the value of groupe_questionnaires
	 * @return groupe_questionnaires
	 */
	public List<Groupe_questionnaire> getGroupe_questionnaires(){
		return this.groupe_questionnaires;
	}
	/**
	 * return the value of questions
	 * @return questions
	 */
	public List<Question> getQuestions(){
		return this.questions;
	}
	/**
	 * return the value of realisations
	 * @return realisations
	 */
	public List<Realisation> getRealisations(){
		return this.realisations;
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
	 * set the value of idDomaine
	 * @param aIdDomaine
	 */
	public void setIdDomaine(int aIdDomaine){
		this.idDomaine=aIdDomaine;
	}
	/**
	 * set the value of idUtilisateur
	 * @param aIdUtilisateur
	 */
	public void setIdUtilisateur(int aIdUtilisateur){
		this.idUtilisateur=aIdUtilisateur;
	}
	/**
	 * set the value of libelle
	 * @param aLibelle
	 */
	public void setLibelle(String aLibelle){
		this.libelle=aLibelle;
	}
	/**
	 * set the value of domaine
	 * @param aDomaine
	 */
	public void setDomaine(Domaine aDomaine){
		this.domaine=aDomaine;
	}
	/**
	 * set the value of groupe_questionnaires
	 * @param aGroupe_questionnaires
	 */
	public void setGroupe_questionnaires(List<Groupe_questionnaire> aGroupe_questionnaires){
		this.groupe_questionnaires=aGroupe_questionnaires;
	}
	/**
	 * set the value of questions
	 * @param aQuestions
	 */
	public void setQuestions(List<Question> aQuestions){
		this.questions=aQuestions;
	}
	/**
	 * set the value of realisations
	 * @param aRealisations
	 */
	public void setRealisations(List<Realisation> aRealisations){
		this.realisations=aRealisations;
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
		return " [date] = " + date+" [idDomaine] = " + idDomaine+" [libelle] = " + libelle+" [idUtilisateur] = " + idUtilisateur+" [id] = " + id;
	}
}