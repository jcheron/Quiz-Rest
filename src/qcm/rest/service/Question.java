package qcm.rest.service;

import javax.ws.rs.Path;

import qcm.models.KQuestion;

@Path("/question")
public class Question extends CrudRestBase {

	public Question() {
		super();
		kobjectClass = KQuestion.class;
		displayName = "question";
	}

}
