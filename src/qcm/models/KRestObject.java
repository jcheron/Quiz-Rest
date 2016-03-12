package qcm.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.ko.kobject.KObject;

@SuppressWarnings("serial")
public class KRestObject extends KObject {

	/**
	 * 
	 */

	@Expose
	@SerializedName("id")
	protected Object key;

	public KRestObject() {
		super();
		this.key = id;
	}

	@Override
	public void setId(Object id) {
		super.setId(id);
		key = id;
	}

}
