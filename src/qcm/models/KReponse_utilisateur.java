package qcm.models;

import net.ko.persistence.annotation.Entity;
import net.ko.persistence.annotation.Id;
import net.ko.persistence.annotation.Table;

/**
 * Classe KReponse_utilisateur
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "reponse_utilisateur")
public class KReponse_utilisateur extends KRestObject {
	@Id
	private int idRealisation;
	@Id
	private int idReponse;
	private KRealisation realisation;
	private KReponse reponse;

	public KReponse_utilisateur() {
		super();
		// belongsTo(KReponse.class);belongsTo(KRealisation.class);
	}

	/**
	 * return the value of idRealisation
	 * 
	 * @return idRealisation
	 */
	public int getIdRealisation() {
		return this.idRealisation;
	}

	/**
	 * return the value of idReponse
	 * 
	 * @return idReponse
	 */
	public int getIdReponse() {
		return this.idReponse;
	}

	/**
	 * return the value of realisation
	 * 
	 * @return realisation
	 */
	public KRealisation getRealisation() {
		return this.realisation;
	}

	/**
	 * return the value of reponse
	 * 
	 * @return reponse
	 */
	public KReponse getReponse() {
		return this.reponse;
	}

	/**
	 * set the value of idRealisation
	 * 
	 * @param aIdRealisation
	 */
	public void setIdRealisation(int aIdRealisation) {
		this.idRealisation = aIdRealisation;
	}

	/**
	 * set the value of idReponse
	 * 
	 * @param aIdReponse
	 */
	public void setIdReponse(int aIdReponse) {
		this.idReponse = aIdReponse;
	}

	/**
	 * set the value of realisation
	 * 
	 * @param aRealisation
	 */
	public void setRealisation(KRealisation aRealisation) {
		this.realisation = aRealisation;
	}

	/**
	 * set the value of reponse
	 * 
	 * @param aReponse
	 */
	public void setReponse(KReponse aReponse) {
		this.reponse = aReponse;
	}

	@Override
	public String toString() {
		return " [idReponse] = " + idReponse + " [idRealisation] = " + idRealisation;
	}
}