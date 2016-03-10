package qcm.rest.service;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.ko.framework.KoHttp;
import net.ko.kobject.KListObject;
import qcm.adapters.KlistObjectAdapter;

public class RestBase {

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
}
