package qcm.models.pojo;

import java.util.List;
import java.util.ArrayList;


/**
* Classe Reponse
*/
public class Reponse {
	private boolean good;
	private int id;
	private int idQuestion;
	private String libelle;
	private Question question;
	private List<Reponse_utilisateur> reponse_utilisateurs;

	public Reponse() {
		super();
		reponse_utilisateurs=new ArrayList<>();question=new Question();
	}
	/**
	 * return the value of good
	 * @return good
	 */
	public boolean isGood(){
		return this.good;
	}
	/**
	 * return the value of id
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * return the value of idQuestion
	 * @return idQuestion
	 */
	public int getIdQuestion(){
		return this.idQuestion;
	}
	/**
	 * return the value of libelle
	 * @return libelle
	 */
	public String getLibelle(){
		return this.libelle;
	}
	/**
	 * return the value of question
	 * @return question
	 */
	public Question getQuestion(){
		return this.question;
	}
	/**
	 * return the value of reponse_utilisateurs
	 * @return reponse_utilisateurs
	 */
	public List<Reponse_utilisateur> getReponse_utilisateurs(){
		return this.reponse_utilisateurs;
	}

	/**
	 * set the value of good
	 * @param aGood
	 */
	public void setGood(boolean aGood){
		this.good=aGood;
	}
	/**
	 * set the value of id
	 * @param aId
	 */
	public void setId(int aId){
		this.id=aId;
	}
	/**
	 * set the value of idQuestion
	 * @param aIdQuestion
	 */
	public void setIdQuestion(int aIdQuestion){
		this.idQuestion=aIdQuestion;
	}
	/**
	 * set the value of libelle
	 * @param aLibelle
	 */
	public void setLibelle(String aLibelle){
		this.libelle=aLibelle;
	}
	/**
	 * set the value of question
	 * @param aQuestion
	 */
	public void setQuestion(Question aQuestion){
		this.question=aQuestion;
	}
	/**
	 * set the value of reponse_utilisateurs
	 * @param aReponse_utilisateurs
	 */
	public void setReponse_utilisateurs(List<Reponse_utilisateur> aReponse_utilisateurs){
		this.reponse_utilisateurs=aReponse_utilisateurs;
	}
	@Override
	public String toString() {
		return " [idQuestion] = " + idQuestion+" [libelle] = " + libelle+" [id] = " + id+" [good] = " + good;
	}
}