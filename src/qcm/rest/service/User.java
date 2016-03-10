package qcm.rest.service;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import net.ko.framework.Ko;
import net.ko.framework.KoHttp;
import net.ko.framework.KoSession;
import net.ko.kobject.KListObject;
import net.ko.utils.KScriptTimer;
import qcm.models.KGroupe;
import qcm.models.KQuestionnaire;
import qcm.models.KUtilisateur;

@Path("/user")
public class User extends RestBase {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		KScriptTimer.start();
		Ko.setTempConstraintDeph(2);
		KListObject<KUtilisateur> users = KoSession.kloadMany(KUtilisateur.class);
		String result = gson.toJson(users.asAL());
		KScriptTimer.stop();
		result = "[{\"time\":" + KScriptTimer.get() + "}," + result + "]";
		Ko.restoreConstraintDeph();
		return result;
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOne(@PathParam("id") int id) {
		KUtilisateur user = KoSession.kloadOne(KUtilisateur.class, id);
		String result = gson.toJson(user);
		return result;
	}

	@GET
	@Path("/{id}/groupes")
	@Produces(MediaType.APPLICATION_JSON)
	public String getGroupes(@PathParam("id") int id) {
		KUtilisateur user = KoSession.kloadOne(KUtilisateur.class, id);
		String result = gson.toJson(user.getGroupes().asAL());
		return result;
	}

	@GET
	@Path("/{id}/quiz")
	@Produces(MediaType.APPLICATION_JSON)
	public String getQuiz(@PathParam("id") int id) {
		Ko.setTempConstraintDeph(2);
		KUtilisateur user = KoSession.kloadOne(KUtilisateur.class, id);
		KListObject<KQuestionnaire> quizes = new KListObject<>(KQuestionnaire.class);
		KListObject<KGroupe> groupes = user.getGroupes();
		for (KGroupe gr : groupes) {
			quizes.addAll(gr.getQuestionnaires());
		}
		String result = gson.toJson(quizes.asAL());
		Ko.restoreConstraintDeph();
		return result;
	}

	@GET
	@Path("/{id}/realisations")
	@Produces(MediaType.APPLICATION_JSON)
	public String getRealisations(@PathParam("id") int id) {
		KUtilisateur user = KoSession.kloadOne(KUtilisateur.class, id);
		String result = gson.toJson(user.getRealisations().asAL());
		return result;
	}

	@POST
	@Path("/connect")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String connect(@FormParam("login") String login, @FormParam("password") String password) {
		KUtilisateur user = KoSession.kloadOne(KUtilisateur.class, "login='" + login + "'");
		String result = "{\"connected\":false,\"message\":\"Nom d'utilisateur ou mot de passe incorrect\"}";

		if (user.isLoaded()) {
			if (user.getPassword().equals(password)) {
				result = "{\"connected\":true,\"user\":" + gson.toJson(user) + "}";
			}
		}
		return result;
	}

	@POST
	@Path("add")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.APPLICATION_JSON)
	public String addOne(MultivaluedMap<String, String> formParams) {
		KUtilisateur user = new KUtilisateur();
		String message = "{\"message\":\"Insertion réussie\"}";
		for (String param : formParams.keySet()) {
			try {
				String value = formParams.get(param) + "";
				value = value.replaceFirst("^\\[(.*)\\]$", "$1");
				user.setAttribute(param, value, false);
			} catch (SecurityException | IllegalArgumentException | NoSuchFieldException | IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
			}
		}
		try {
			KoHttp.getDao(KUtilisateur.class).create(user);
		} catch (Exception e) {
			message = "{\"erreur\":\"" + e.getMessage() + "\"}";
		}
		return message;
	}
}
