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
	 * @param message
	 *            message de retour
	 * @param key
	 *            clé de l'objet affecté
	 * @param value
	 *            objet affecté
	 * @param keyValues
	 *            fin de chaîne JSON à ajouter à la réponse
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
	 * @param message
	 *            contenu du message
	 * @param hasError
	 *            présence d'une erreur
	 * @return
	 */
	protected String returnMessage(String message, boolean hasError) {
		return "{\"message\":\"" + message + "\",\"error\":" + hasError + "}";
	}

	/*
	 * private static void addAnnotation(CtClass clazz, String fieldName, String
	 * annotationName) throws Exception { ClassFile cfile =
	 * clazz.getClassFile(); ConstPool cpool = cfile.getConstPool(); CtField
	 * cfield = clazz.getField(fieldName);
	 * 
	 * AnnotationsAttribute attr = new AnnotationsAttribute(cpool,
	 * AnnotationsAttribute.visibleTag); Annotation annot = new
	 * Annotation(annotationName, cpool); attr.addAnnotation(annot);
	 * cfield.getFieldInfo().addAttribute(attr); }
	 * 
	 * private void addExposeToKoId() throws Exception { ClassPool cp =
	 * ClassPool.getDefault(); cp.insertClassPath(this.context.getRealPath(
	 * "/WEB-INF/lib/koLibrary-1.0.0.27-beta1.jar")); String pkgName =
	 * "net.ko.kobject"; CtClass cc = cp.get(pkgName + ".KObject"); // Without
	 * the call to "makePackage()", package information is lost
	 * cp.makePackage(cp.getClassLoader(), pkgName); addAnnotation(cc, "id",
	 * "com.google.gson.annotations.Expose"); // Changes are not persisted
	 * without a call to "toClass()" Class<?> c = cc.toClass(); }
	 */
}
