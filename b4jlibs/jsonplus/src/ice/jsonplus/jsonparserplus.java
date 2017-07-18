package ice.jsonplus;

import java.util.Iterator;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("JSONParser2")
public class jsonparserplus extends AbsObjectWrapper<Object> {
	public void Initialize(String jsonString) throws  DeserializationException {
		Object obj=Jsoner.deserialize(jsonString);
		setObject(convert2B4XObj(obj));
	}
	public List NextArray() {
		return (List)getObject();
	}
	public Map NextObject() {
		return (Map)getObject();
	}
	public Object NextValue() {
		return getObject();
	}
	private Object convert2B4XObj(Object obj) {
		if (obj instanceof JsonArray) {
			List lst=new List();
			lst.Initialize();
			JsonArray ja=(JsonArray) obj;
			for (Object object : ja) {
				lst.Add(convert2B4XObj(object));
			}
			return lst;
		}else if (obj instanceof JsonObject) {
			Map map=new Map();
			map.Initialize();
			JsonObject jo=(JsonObject) obj;
			Iterator<String> kS=jo.keySet().iterator();
			while (kS.hasNext()) {
				String k=kS.next();
				Object object=jo.get(k);
				map.Put(k, convert2B4XObj(object));
			}
			return map;
		}else{
			return obj.toString();
		}
	}
	public String escape(String str) {
		return Jsoner.escape(str);
	}

}
