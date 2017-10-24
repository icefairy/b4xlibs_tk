
package b4a.AutoScaleExample7;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class dbscrollview implements IRemote{
	public static dbscrollview mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public dbscrollview() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("dbscrollview"), "b4a.AutoScaleExample7.dbscrollview");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, dbscrollview.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _numberofcolumns = RemoteObject.createImmutable(0);
public static RemoteObject _numberofrows = RemoteObject.createImmutable(0);
public static RemoteObject _rowheight = RemoteObject.createImmutable(0);
public static RemoteObject _rowlinewidth = RemoteObject.createImmutable(0);
public static RemoteObject _rowheight_1 = RemoteObject.createImmutable(0);
public static RemoteObject _collinewidth = RemoteObject.createImmutable(0);
public static RemoteObject _columnwidth = null;
public static RemoteObject _columnwidth_1 = null;
public static RemoteObject _totalcolumnwidth = null;
public static RemoteObject _columnname = null;
public static RemoteObject _headercolor = RemoteObject.createImmutable(0);
public static RemoteObject _headerfontcolor = RemoteObject.createImmutable(0);
public static RemoteObject _headerlinecolor = RemoteObject.createImmutable(0);
public static RemoteObject _cellcolor = RemoteObject.createImmutable(0);
public static RemoteObject _fontcolor = RemoteObject.createImmutable(0);
public static RemoteObject _fontsize = RemoteObject.createImmutable(0f);
public static RemoteObject _alignment = RemoteObject.createImmutable(0);
public static RemoteObject _scvpersons = RemoteObject.declareNull("flm.b4a.scrollview2d.ScrollView2DWrapper");
public static RemoteObject _pnlheader = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static b4a.AutoScaleExample7.main _main = null;
public static b4a.AutoScaleExample7.setup _setup = null;
public static b4a.AutoScaleExample7.about _about = null;
public static b4a.AutoScaleExample7.scale _scale = null;
public static b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public static b4a.AutoScaleExample7.dbutils _dbutils = null;
public static b4a.AutoScaleExample7.keyboard _keyboard = null;
public static b4a.AutoScaleExample7.listview _listview = null;
public static b4a.AutoScaleExample7.calculator _calculator = null;
public static b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public static b4a.AutoScaleExample7.positioning _positioning = null;
  public Object[] GetGlobals() {
		return new Object[] {"About",Debug.moduleToString(b4a.AutoScaleExample7.about.class),"Activity",dbscrollview.mostCurrent._activity,"Alignment",dbscrollview._alignment,"Calculator",Debug.moduleToString(b4a.AutoScaleExample7.calculator.class),"Calculator1",Debug.moduleToString(b4a.AutoScaleExample7.calculator1.class),"CellColor",dbscrollview._cellcolor,"ColLineWidth",dbscrollview._collinewidth,"ColumnName",dbscrollview._columnname,"ColumnWidth",dbscrollview._columnwidth,"ColumnWidth_1",dbscrollview._columnwidth_1,"DBUtils",Debug.moduleToString(b4a.AutoScaleExample7.dbutils.class),"DBWebView",Debug.moduleToString(b4a.AutoScaleExample7.dbwebview.class),"FontColor",dbscrollview._fontcolor,"FontSize",dbscrollview._fontsize,"HeaderColor",dbscrollview._headercolor,"HeaderFontColor",dbscrollview._headerfontcolor,"HeaderLineColor",dbscrollview._headerlinecolor,"Keyboard",Debug.moduleToString(b4a.AutoScaleExample7.keyboard.class),"ListView",Debug.moduleToString(b4a.AutoScaleExample7.listview.class),"Main",Debug.moduleToString(b4a.AutoScaleExample7.main.class),"NumberOfColumns",dbscrollview._numberofcolumns,"NumberOfRows",dbscrollview._numberofrows,"pnlHeader",dbscrollview.mostCurrent._pnlheader,"Positioning",Debug.moduleToString(b4a.AutoScaleExample7.positioning.class),"RowHeight",dbscrollview._rowheight,"RowHeight_1",dbscrollview._rowheight_1,"RowLineWidth",dbscrollview._rowlinewidth,"Scale",Debug.moduleToString(b4a.AutoScaleExample7.scale.class),"scvPersons",dbscrollview.mostCurrent._scvpersons,"Setup",Debug.moduleToString(b4a.AutoScaleExample7.setup.class),"TotalColumnWidth",dbscrollview._totalcolumnwidth};
}
}