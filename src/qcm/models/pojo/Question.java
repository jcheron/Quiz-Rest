package qcm.models.pojo;

import java.util.List;
import java.util.ArrayList;


/**
* Classe Question
*/
public class Question {
	private int id;
	private int idQuestionnaire;
	private String libelle;
	private List<Reponse> reponses;
	private Questionnaire questionnaire;

	public Question() {
		super();
		questionnaire=new Questionnaire();reponses=new ArrayList<>();
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
	 * return the value of libelle
	 * @return libelle
	 */
	public String getLibelle(){
		return this.libelle;
	}
	/**
	 * return the value of reponses
	 * @return reponses
	 */
	public List<Reponse> getReponses(){
		return this.reponses;
	}
	/**
	 * return the value of questionnaire
	 * @return questionnaire
	 */
	public Questionnaire getQuestionnaire(){
		return this.questionnaire;
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
	 * set the value of libelle
	 * @param aLibelle
	 */
	public void setLibelle(String aLibelle){
		this.libelle=aLibelle;
	}
	/**
	 * set the value of reponses
	 * @param aReponses
	 */
	public void setReponses(List<Reponse> aReponses){
		this.reponses=aReponses;
	}
	/**
	 * set the value of questionnaire
	 * @param aQuestionnaire
	 */
	public void setQuestionnaire(Questionnaire aQuestionnaire){
		this.questionnaire=aQuestionnaire;
	}
	@Override
	public String toString() {
		return " [libelle] = " + libelle+" [idQuestionnaire] = " + idQuestionnaire+" [id] = " + id;
	}
}