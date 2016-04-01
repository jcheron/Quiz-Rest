package qcm.models.pojo;



/**
* Classe Reponse_utilisateur
*/
public class Reponse_utilisateur {
	private int idRealisation;
	private int idReponse;
	private Realisation realisation;
	private Reponse reponse;

	public Reponse_utilisateur() {
		super();
		reponse=new Reponse();realisation=new Realisation();
	}
	/**
	 * return the value of idRealisation
	 * @return idRealisation
	 */
	public int getIdRealisation(){
		return this.idRealisation;
	}
	/**
	 * return the value of idReponse
	 * @return idReponse
	 */
	public int getIdReponse(){
		return this.idReponse;
	}
	/**
	 * return the value of realisation
	 * @return realisation
	 */
	public Realisation getRealisation(){
		return this.realisation;
	}
	/**
	 * return the value of reponse
	 * @return reponse
	 */
	public Reponse getReponse(){
		return this.reponse;
	}

	/**
	 * set the value of idRealisation
	 * @param aIdRealisation
	 */
	public void setIdRealisation(int aIdRealisation){
		this.idRealisation=aIdRealisation;
	}
	/**
	 * set the value of idReponse
	 * @param aIdReponse
	 */
	public void setIdReponse(int aIdReponse){
		this.idReponse=aIdReponse;
	}
	/**
	 * set the value of realisation
	 * @param aRealisation
	 */
	public void setRealisation(Realisation aRealisation){
		this.realisation=aRealisation;
	}
	/**
	 * set the value of reponse
	 * @param aReponse
	 */
	public void setReponse(Reponse aReponse){
		this.reponse=aReponse;
	}
	@Override
	public String toString() {
		return " [idRealisation] = " + idRealisation+" [idReponse] = " + idReponse;
	}
}