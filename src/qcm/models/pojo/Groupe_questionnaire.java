package qcm.models.pojo;



/**
* Classe Groupe_questionnaire
*/
public class Groupe_questionnaire {
	private int idGroupe;
	private int idQuestionnaire;
	private Groupe groupe;
	private Questionnaire questionnaire;

	public Groupe_questionnaire() {
		super();
		questionnaire=new Questionnaire();groupe=new Groupe();
	}
	/**
	 * return the value of idGroupe
	 * @return idGroupe
	 */
	public int getIdGroupe(){
		return this.idGroupe;
	}
	/**
	 * return the value of idQuestionnaire
	 * @return idQuestionnaire
	 */
	public int getIdQuestionnaire(){
		return this.idQuestionnaire;
	}
	/**
	 * return the value of groupe
	 * @return groupe
	 */
	public Groupe getGroupe(){
		return this.groupe;
	}
	/**
	 * return the value of questionnaire
	 * @return questionnaire
	 */
	public Questionnaire getQuestionnaire(){
		return this.questionnaire;
	}

	/**
	 * set the value of idGroupe
	 * @param aIdGroupe
	 */
	public void setIdGroupe(int aIdGroupe){
		this.idGroupe=aIdGroupe;
	}
	/**
	 * set the value of idQuestionnaire
	 * @param aIdQuestionnaire
	 */
	public void setIdQuestionnaire(int aIdQuestionnaire){
		this.idQuestionnaire=aIdQuestionnaire;
	}
	/**
	 * set the value of groupe
	 * @param aGroupe
	 */
	public void setGroupe(Groupe aGroupe){
		this.groupe=aGroupe;
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
		return " [idQuestionnaire] = " + idQuestionnaire+" [idGroupe] = " + idGroupe;
	}
}