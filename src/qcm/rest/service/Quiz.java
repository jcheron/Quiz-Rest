package qcm.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.ko.framework.KoSession;
import net.ko.kobject.KListObject;
import qcm.models.KQuestionnaire;

@Path("/quiz")
public class Quiz extends RestBase {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		KListObject<KQuestionnaire> questionnaires = KoSession.kloadMany(KQuestionnaire.class);
		String result = gson.toJson(questionnaires.asAL());
		return result;
	}
}
