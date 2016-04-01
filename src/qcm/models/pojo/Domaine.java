package qcm.models.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe Domaine
 */
public class Domaine {
	private int id;
	private String libelle;
	private List<Questionnaire> questionnaires;

	public Domaine() {
		super();
		questionnaires = new ArrayList<>();
	}

	/**
	 * return the value of id
	 * 
	 * @return id
	 */
	public int getId() {
		return this.id;
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
	 * return the value of questionnaires
	 * 
	 * @return questionnaires
	 */
	public List<Questionnaire> getQuestionnaires() {
		return this.questionnaires;
	}

	/**
	 * set the value of id
	 * 
	 * @param aId
	 */
	public void setId(int aId) {
		this.id = aId;
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
	 * set the value of questionnaires
	 * 
	 * @param aQuestionnaires
	 */
	public void setQuestionnaires(List<Questionnaire> aQuestionnaires) {
		this.questionnaires = aQuestionnaires;
	}

	@Override
	public String toString() {
		return libelle;
	}
}