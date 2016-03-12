package qcm.rest.service;

import java.sql.SQLException;
import java.util.function.Function;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import net.ko.framework.KoSession;
import net.ko.kobject.KListObject;
import net.ko.kobject.KObject;
import net.ko.utils.KString;

public abstract class CrudRestBase extends RestBase {
	protected Class<? extends KObject> kobjectClass;
	protected String displayName;

	/**
	 * Affecte les paramètres de la requête aux membres du même nom de l'objet
	 * 
	 * @param obj
	 * @param formParams
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException
	 */
	protected void setValuesToKObject(KObject obj, MultivaluedMap<String, String> formParams) throws SecurityException, IllegalAccessException {
		obj.setAttributes(formParams, new Function<String, String>() {
			@Override
			public String apply(String t) {
				return t.replaceFirst("^\\[(.*)\\]$", "$1");
			}
		}, false);
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		KListObject<? extends KObject> objects = KoSession.kloadMany(kobjectClass);
		String result = gson.toJson(objects.asAL());
		return result;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOne(@PathParam("id") int id) {
		KObject object = KoSession.kloadOne(kobjectClass, id);
		String result = "";
		if (object.isLoaded())
			result = gson.toJson(object);
		else
			result = returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		return result;
	}

	/**
	 * Update a object
	 * 
	 * @return String message
	 */
	@POST
	@Path("/update/{id}")
	@Consumes("application/x-www-form-urlencoded")
	public String update(MultivaluedMap<String, String> formParams, @PathParam("id") int id) throws SQLException {
		KObject object = KoSession.kloadOne(kobjectClass, id);
		String message = "";
		if (!object.isLoaded())
			return returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		try {
			setValuesToKObject(object, formParams);
			KoSession.update(object);
			message = returnValue(KString.capitalizeFirstLetter(displayName) + " `" + object + "` mis à jour", displayName, object);
		} catch (SecurityException | IllegalAccessException | SQLException e) {
			message = returnMessage(e.getMessage(), true);
		}
		return message;
	}

	/**
	 * Create a object
	 * 
	 * @return String message
	 */
	@POST
	@Path("add")
	@Consumes("application/x-www-form-urlencoded")
	public String add(MultivaluedMap<String, String> formParams) {
		KObject object = null;
		String message = "";
		try {
			object = kobjectClass.newInstance();
			setValuesToKObject(object, formParams);
			KoSession.add(object);
			message = returnValue(KString.capitalizeFirstLetter(displayName) + " `" + object + "` inséré", displayName, object);
		} catch (SecurityException | IllegalAccessException | SQLException | InstantiationException e) {
			message = returnMessage(e.getMessage(), true);
		}
		return message;
	}

	/**
	 * Delete a object
	 * 
	 * @return String message
	 */
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String delete(@PathParam("id") int id) {
		KObject object = KoSession.kloadOne(kobjectClass, id);
		String message = "";
		if (!object.isLoaded())
			return returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		try {
			KoSession.delete(object);
			message = returnValue(KString.capitalizeFirstLetter(displayName) + " `" + object + "` supprimé", displayName, object);
		} catch (SQLException e) {
			message = returnMessage(e.getMessage(), true);
		}
		return message;
	}
}
