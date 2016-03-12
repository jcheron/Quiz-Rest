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

import net.ko.framework.Ko;
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

	protected KObject loadOne(int id, Integer constraintDepht) {
		if (constraintDepht != null)
			Ko.setTempConstraintDeph(constraintDepht);
		KObject object = KoSession.kloadOne(kobjectClass, id);
		if (constraintDepht != null)
			Ko.restoreConstraintDeph();
		return object;
	}

	protected KObject loadOne(int id) {
		return loadOne(id, null);
	}

	@GET
	@Path("/all/{cd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll(@PathParam("cd") Integer constraintDepht) {
		if (constraintDepht != null)
			Ko.setTempConstraintDeph(constraintDepht);
		KListObject<? extends KObject> objects = KoSession.kloadMany(kobjectClass);
		if (constraintDepht != null)
			Ko.restoreConstraintDeph();
		String result = gson.toJson(objects.asAL());
		return result;
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		return getAll(null);
	}

	@GET
	@Path("/{id}/{cd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOne(@PathParam("id") int id, @PathParam("cd") Integer constraintDepht) {
		KObject object = loadOne(id, constraintDepht);
		String result = "";
		if (object.isLoaded())
			result = gson.toJson(object);
		else
			result = returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		return result;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOne(@PathParam("id") int id) {
		return getOne(id, null);
	}

	/**
	 * Update an object
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

	@GET
	@Path("/{id}/one/{member}/{cd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMember(@PathParam("id") int id, @PathParam("member") String member, @PathParam("cd") Integer constraintDepht) {
		KObject object = loadOne(id, constraintDepht);
		String message = "";
		if (!object.isLoaded())
			return returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		try {
			message = gson.toJson(object.getAttribute(member));
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			message = returnMessage(e.getMessage(), true);
		}
		return message;
	}

	@GET
	@Path("/{id}/one/{member}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMember(@PathParam("id") int id, @PathParam("member") String member) {
		return getMember(id, member, null);
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/{id}/all/{member}/{cd}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListMember(@PathParam("id") int id, @PathParam("member") String member, @PathParam("cd") Integer constraintDepht) {
		if (constraintDepht != null)
			Ko.setTempConstraintDeph(constraintDepht);
		KObject object = KoSession.kloadOne(kobjectClass, id);
		if (constraintDepht != null)
			Ko.restoreConstraintDeph();
		String message = "";
		if (!object.isLoaded())
			return returnMessage("L'objet d'id `" + id + "` n'existe pas", true);
		try {
			KListObject<? extends KObject> kl = null;
			Object list = object.getAttribute(member);
			if (list instanceof KListObject) {
				kl = (KListObject<? extends KObject>) list;
				message = gson.toJson(kl.asAL());
			} else {
				throw new NoSuchFieldException("Le membre `" + member + "` n'est pas une KlistObject valide.");
			}

		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			message = returnMessage(e.getMessage(), true);
		}
		return message;
	}

	@GET
	@Path("/{id}/all/{member}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListMember(@PathParam("id") int id, @PathParam("member") String member) {
		return getListMember(id, member, null);
	}
}
