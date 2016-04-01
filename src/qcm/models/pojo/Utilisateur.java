package qcm.models.pojo;

import java.util.List;
import java.util.ArrayList;


/**
* Classe Utilisateur
*/
public class Utilisateur {
	private int id;
	private int idRang;
	private String login;
	private String mail;
	private String nom;
	private String password;
	private String prenom;
	private Rang rang;
	private List<Questionnaire> questionnaires;
	private List<Realisation> realisations;
	private List<Utilisateur_groupe> utilisateur_groupes;

	public Utilisateur() {
		super();
		utilisateur_groupes=new ArrayList<>();realisations=new ArrayList<>();questionnaires=new ArrayList<>();rang=new Rang();
	}
	/**
	 * return the value of id
	 * @return id
	 */
	public int getId(){
		return this.id;
	}
	/**
	 * return the value of idRang
	 * @return idRang
	 */
	public int getIdRang(){
		return this.idRang;
	}
	/**
	 * return the value of login
	 * @return login
	 */
	public String getLogin(){
		return this.login;
	}
	/**
	 * return the value of mail
	 * @return mail
	 */
	public String getMail(){
		return this.mail;
	}
	/**
	 * return the value of nom
	 * @return nom
	 */
	public String getNom(){
		return this.nom;
	}
	/**
	 * return the value of password
	 * @return password
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * return the value of prenom
	 * @return prenom
	 */
	public String getPrenom(){
		return this.prenom;
	}
	/**
	 * return the value of rang
	 * @return rang
	 */
	public Rang getRang(){
		return this.rang;
	}
	/**
	 * return the value of questionnaires
	 * @return questionnaires
	 */
	public List<Questionnaire> getQuestionnaires(){
		return this.questionnaires;
	}
	/**
	 * return the value of realisations
	 * @return realisations
	 */
	public List<Realisation> getRealisations(){
		return this.realisations;
	}
	/**
	 * return the value of utilisateur_groupes
	 * @return utilisateur_groupes
	 */
	public List<Utilisateur_groupe> getUtilisateur_groupes(){
		return this.utilisateur_groupes;
	}

	/**
	 * set the value of id
	 * @param aId
	 */
	public void setId(int aId){
		this.id=aId;
	}
	/**
	 * set the value of idRang
	 * @param aIdRang
	 */
	public void setIdRang(int aIdRang){
		this.idRang=aIdRang;
	}
	/**
	 * set the value of login
	 * @param aLogin
	 */
	public void setLogin(String aLogin){
		this.login=aLogin;
	}
	/**
	 * set the value of mail
	 * @param aMail
	 */
	public void setMail(String aMail){
		this.mail=aMail;
	}
	/**
	 * set the value of nom
	 * @param aNom
	 */
	public void setNom(String aNom){
		this.nom=aNom;
	}
	/**
	 * set the value of password
	 * @param aPassword
	 */
	public void setPassword(String aPassword){
		this.password=aPassword;
	}
	/**
	 * set the value of prenom
	 * @param aPrenom
	 */
	public void setPrenom(String aPrenom){
		this.prenom=aPrenom;
	}
	/**
	 * set the value of rang
	 * @param aRang
	 */
	public void setRang(Rang aRang){
		this.rang=aRang;
	}
	/**
	 * set the value of questionnaires
	 * @param aQuestionnaires
	 */
	public void setQuestionnaires(List<Questionnaire> aQuestionnaires){
		this.questionnaires=aQuestionnaires;
	}
	/**
	 * set the value of realisations
	 * @param aRealisations
	 */
	public void setRealisations(List<Realisation> aRealisations){
		this.realisations=aRealisations;
	}
	/**
	 * set the value of utilisateur_groupes
	 * @param aUtilisateur_groupes
	 */
	public void setUtilisateur_groupes(List<Utilisateur_groupe> aUtilisateur_groupes){
		this.utilisateur_groupes=aUtilisateur_groupes;
	}
	@Override
	public String toString() {
		return " [password] = " + password+" [mail] = " + mail+" [idRang] = " + idRang+" [id] = " + id+" [login] = " + login+" [nom] = " + nom+" [prenom] = " + prenom;
	}
}