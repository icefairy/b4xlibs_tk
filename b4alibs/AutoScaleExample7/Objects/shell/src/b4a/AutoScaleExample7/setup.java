
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

public class setup implements IRemote{
	public static setup mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public setup() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("setup"), "b4a.AutoScaleExample7.setup");
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
		pcBA = new PCBA(this, setup.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _pnlsetupgps = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlgpspathunits = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmapdefaultlocation = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlgpssetup = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmapsetup = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmapline = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlmapmarkers = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _pnlsetup = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cbxmapdraggable = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmaptypecontrol = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmapzoomcontrol = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmapscalecontrol = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmapcentermarker = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmapmarkers = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdispmappolyline = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxmapmarkersclickable = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxmapmarkersdragable = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxshowgpsonmap = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxdrawgpspath = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxsavegpspath = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxgpsdispspeed = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxgpsdispbearing = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _cbxgpsdispwindrose = RemoteObject.declareNull("anywheresoftware.b4a.objects.CompoundButtonWrapper.CheckBoxWrapper");
public static RemoteObject _edtmapdefaultlocationlng = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edtmapdefaultlocationlat = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edtgpsmintime = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _edtgpsmindistance = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _spnmapzoomlevel = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnmaplinewidth = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnmaplinecolor = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnmaplineopacity = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnmaptypecontrolid = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnmapzoomcontroltype = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnaltitudeunit = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spnspeedunit = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _spndistanceunit = RemoteObject.declareNull("anywheresoftware.b4a.objects.SpinnerWrapper");
public static RemoteObject _scvsetup = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static b4a.AutoScaleExample7.main _main = null;
public static b4a.AutoScaleExample7.about _about = null;
public static b4a.AutoScaleExample7.scale _scale = null;
public static b4a.AutoScaleExample7.dbwebview _dbwebview = null;
public static b4a.AutoScaleExample7.dbutils _dbutils = null;
public static b4a.AutoScaleExample7.dbscrollview _dbscrollview = null;
public static b4a.AutoScaleExample7.keyboard _keyboard = null;
public static b4a.AutoScaleExample7.listview _listview = null;
public static b4a.AutoScaleExample7.calculator _calculator = null;
public static b4a.AutoScaleExample7.calculator1 _calculator1 = null;
public static b4a.AutoScaleExample7.positioning _positioning = null;
  public Object[] GetGlobals() {
		return new Object[] {"About",Debug.moduleToString(b4a.AutoScaleExample7.about.class),"Activity",setup.mostCurrent._activity,"Calculator",Debug.moduleToString(b4a.AutoScaleExample7.calculator.class),"Calculator1",Debug.moduleToString(b4a.AutoScaleExample7.calculator1.class),"cbxDispMapCenterMarker",setup.mostCurrent._cbxdispmapcentermarker,"cbxDispMapMarkers",setup.mostCurrent._cbxdispmapmarkers,"cbxDispMapPolyline",setup.mostCurrent._cbxdispmappolyline,"cbxDispMapScaleControl",setup.mostCurrent._cbxdispmapscalecontrol,"cbxDispMapTypeControl",setup.mostCurrent._cbxdispmaptypecontrol,"cbxDispMapZoomControl",setup.mostCurrent._cbxdispmapzoomcontrol,"cbxDrawGPSPath",setup.mostCurrent._cbxdrawgpspath,"cbxGPSDispBearing",setup.mostCurrent._cbxgpsdispbearing,"cbxGPSDispSpeed",setup.mostCurrent._cbxgpsdispspeed,"cbxGPSDispWindrose",setup.mostCurrent._cbxgpsdispwindrose,"cbxMapDraggable",setup.mostCurrent._cbxmapdraggable,"cbxMapMarkersClickable",setup.mostCurrent._cbxmapmarkersclickable,"cbxMapMarkersDragable",setup.mostCurrent._cbxmapmarkersdragable,"cbxSaveGPSPath",setup.mostCurrent._cbxsavegpspath,"cbxShowGPSOnMap",setup.mostCurrent._cbxshowgpsonmap,"DBScrollView",Debug.moduleToString(b4a.AutoScaleExample7.dbscrollview.class),"DBUtils",Debug.moduleToString(b4a.AutoScaleExample7.dbutils.class),"DBWebView",Debug.moduleToString(b4a.AutoScaleExample7.dbwebview.class),"edtGPSMinDistance",setup.mostCurrent._edtgpsmindistance,"edtGPSMinTime",setup.mostCurrent._edtgpsmintime,"edtMapDefaultLocationLat",setup.mostCurrent._edtmapdefaultlocationlat,"edtMapDefaultLocationLng",setup.mostCurrent._edtmapdefaultlocationlng,"Keyboard",Debug.moduleToString(b4a.AutoScaleExample7.keyboard.class),"ListView",Debug.moduleToString(b4a.AutoScaleExample7.listview.class),"Main",Debug.moduleToString(b4a.AutoScaleExample7.main.class),"pnlGPSPathUnits",setup.mostCurrent._pnlgpspathunits,"pnlGPSSetup",setup.mostCurrent._pnlgpssetup,"pnlMapDefaultLocation",setup.mostCurrent._pnlmapdefaultlocation,"pnlMapLine",setup.mostCurrent._pnlmapline,"pnlMapMarkers",setup.mostCurrent._pnlmapmarkers,"pnlMapSetup",setup.mostCurrent._pnlmapsetup,"pnlSetup",setup.mostCurrent._pnlsetup,"pnlSetupGPS",setup.mostCurrent._pnlsetupgps,"Positioning",Debug.moduleToString(b4a.AutoScaleExample7.positioning.class),"Scale",Debug.moduleToString(b4a.AutoScaleExample7.scale.class),"scvSetup",setup.mostCurrent._scvsetup,"spnAltitudeUnit",setup.mostCurrent._spnaltitudeunit,"spnDistanceUnit",setup.mostCurrent._spndistanceunit,"spnMapLineColor",setup.mostCurrent._spnmaplinecolor,"spnMapLineOpacity",setup.mostCurrent._spnmaplineopacity,"spnMapLineWidth",setup.mostCurrent._spnmaplinewidth,"spnMapTypeControlID",setup.mostCurrent._spnmaptypecontrolid,"spnMapZoomControlType",setup.mostCurrent._spnmapzoomcontroltype,"spnMapZoomLevel",setup.mostCurrent._spnmapzoomlevel,"spnSpeedUnit",setup.mostCurrent._spnspeedunit};
}
}