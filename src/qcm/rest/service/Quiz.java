package qcm.rest.service;

import javax.ws.rs.Path;

import qcm.models.KQuestionnaire;

@Path("/quiz")
public class Quiz extends CrudRestBase {

	public Quiz() {
		super();
		kobjectClass = KQuestionnaire.class;
		displayName = "questionnaire";
	}

}
