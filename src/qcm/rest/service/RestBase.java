package qcm.rest.service;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.ko.framework.KoHttp;
import net.ko.kobject.KListObject;
import qcm.adapters.KlistObjectAdapter;

public abstract class RestBase {

	protected Gson gson;
	@Context
	protected ServletContext context;

	public RestBase() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(KListObject.class, new KlistObjectAdapter());
		gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gson = gsonBuilder.excludeFieldsWithoutExposeAnnotation().create();
	}

	@Context
	public void setServletContext(ServletContext context) {
		this.context = context;
		KoHttp.kstart(context);
	}

	/**
	 * retourne un message JSON contenant l'objet affecté
	 * 
	 * @param message message de retour
	 * @param key clé de l'objet affecté
	 * @param value objet affecté
	 * @param keyValues fin de chaîne JSON à ajouter à la réponse
	 * @return
	 */
	protected <T> String returnValue(String message, String key, T value, String keyValues) {
		String jsonEnd = "";
		if (!"".equals(keyValues))
			jsonEnd = "," + keyValues;
		return "{\"message\":\"" + message + "\",\"" + key + "\":" + gson.toJson(value) + jsonEnd + "}";
	}

	/**
	 * retourne une chaîne JSON contenant un message, l'objet affecté et sa clé
	 * 
	 * @param message
	 * @param key
	 * @param value
	 * @return
	 */
	protected <T> String returnValue(String message, String key, T value) {
		return returnValue(message, key, value, "");
	}

	/**
	 * retourne une chaîne JSON contenant un message et l'objet affecté
	 * 
	 * @param message
	 * @param value
	 * @return
	 */
	protected <T> String returnValue(String message, T value) {
		return returnValue(message, "object", value);
	}

	/**
	 * retourne une chaîne JSON contenant un message
	 * 
	 * @param message
	 * @return
	 */
	protected String returnMessage(String message) {
		return returnMessage(message, false);
	}

	/**
	 * retourne une chaîne JSON contenant un message avec erreur ou non
	 * 
	 * @param message contenu du message
	 * @param hasError présence d'une erreur
	 * @return
	 */
	protected String returnMessage(String message, boolean hasError) {
		return "{\"message\":\"" + message + "\",\"error\":" + hasError + "}";
	}

}
