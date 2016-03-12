package qcm.rest.service;

import javax.ws.rs.Path;

import qcm.models.KGroupe;

@Path("/groupe")
public class Groupe extends CrudRestBase {
	public Groupe() {
		kobjectClass = KGroupe.class;
		displayName = "groupe";
	}
}
