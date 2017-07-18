package ice.jsonplus;

import java.util.LinkedHashMap;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.objects.collections.List;
import anywheresoftware.b4a.objects.collections.Map;

@ShortName("JSONGenerator2")
@Version(1.1f)
@Author("icefairy333")
@DependsOn(values={"json-simple-2.1.2"})
public class jsonplus extends AbsObjectWrapper<Object> {
	private Object obj=null;
	public void Initialize(Map map){
		LinkedHashMap<String, Object> m=new LinkedHashMap<>();
		for(int i=0;i<map.getSize();i++){
			m.put(map.GetKeyAt(i).toString().toLowerCase().trim(), map.GetValueAt(i));
		}
		obj=new JsonObject(m);
	}
	public void Initialize2(List lst) {
		obj=new JsonArray(lst.getObject());
	}
	public String ToString() {
		return Jsoner.serialize(obj);
	}
	public String escape(String str) {
		return Jsoner.escape(str);
	}
}
