package qcm.models.pojo;



/**
* Classe Utilisateur_groupe
*/
public class Utilisateur_groupe {
	private int idGroupe;
	private int idUtilisateur;
	private Groupe groupe;
	private Utilisateur utilisateur;

	public Utilisateur_groupe() {
		super();
		utilisateur=new Utilisateur();groupe=new Groupe();
	}
	/**
	 * return the value of idGroupe
	 * @return idGroupe
	 */
	public int getIdGroupe(){
		return this.idGroupe;
	}
	/**
	 * return the value of idUtilisateur
	 * @return idUtilisateur
	 */
	public int getIdUtilisateur(){
		return this.idUtilisateur;
	}
	/**
	 * return the value of groupe
	 * @return groupe
	 */
	public Groupe getGroupe(){
		return this.groupe;
	}
	/**
	 * return the value of utilisateur
	 * @return utilisateur
	 */
	public Utilisateur getUtilisateur(){
		return this.utilisateur;
	}

	/**
	 * set the value of idGroupe
	 * @param aIdGroupe
	 */
	public void setIdGroupe(int aIdGroupe){
		this.idGroupe=aIdGroupe;
	}
	/**
	 * set the value of idUtilisateur
	 * @param aIdUtilisateur
	 */
	public void setIdUtilisateur(int aIdUtilisateur){
		this.idUtilisateur=aIdUtilisateur;
	}
	/**
	 * set the value of groupe
	 * @param aGroupe
	 */
	public void setGroupe(Groupe aGroupe){
		this.groupe=aGroupe;
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
		return " [idUtilisateur] = " + idUtilisateur+" [idGroupe] = " + idGroupe;
	}
}