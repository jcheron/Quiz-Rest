package qcm.adapters;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import net.ko.kobject.KListObject;
import net.ko.kobject.KObject;

public class KlistObjectAdapter
		implements JsonSerializer<KListObject<? extends KObject>> {

	@Override
	public JsonElement serialize(KListObject<? extends KObject> list, Type arg1, JsonSerializationContext context) {
		JsonElement elm = context.serialize(list.asAL());
		return elm;
	}

}
