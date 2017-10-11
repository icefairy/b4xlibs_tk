Type=Activity
Version=7.3
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Region Module Attributes
	#FullScreen: False
	#IncludeTitle: True
#End Region

'Setup Activity module
'This module uses the Scale module to scale a Setup layout.
Sub Process_Globals

End Sub

Sub Globals
	Dim pnlSetupGPS, pnlGPSPathUnits, pnlMapDefaultLocation, pnlGPSSetup, pnlMapSetup, pnlMapLine, pnlMapMarkers As Panel
	Dim pnlSetup As Panel
	Dim cbxMapDraggable, cbxDispMapTypeControl, cbxDispMapZoomControl, cbxDispMapScaleControl As CheckBox
	Dim cbxDispMapCenterMarker, cbxDispMapMarkers, cbxDispMapPolyline As CheckBox
	Dim cbxMapMarkersClickable, cbxMapMarkersDragable, cbxShowGPSOnMap As CheckBox
	Dim cbxDrawGPSPath, cbxSaveGPSPath, cbxGPSDispSpeed, cbxGPSDispBearing, cbxGPSDispWindrose As CheckBox
	
	Dim edtMapDefaultLocationLng, edtMapDefaultLocationLat, edtGPSMinTime, edtGPSMinDistance As EditText
	
	Dim spnMapZoomLevel, spnMapLineWidth, spnMapLineColor, spnMapLineOpacity As Spinner
	Dim spnMapTypeControlID, spnMapZoomControlType As Spinner
	Dim spnAltitudeUnit, spnSpeedUnit, spnDistanceUnit As Spinner

	Dim scvSetup As ScrollView
	
End Sub

Sub Activity_Create(FirstTime As Boolean)
	Dim Left, Width, Width1, Space As Int

	Scale.SetRate(0.5)
	
	Width = 312dip * Scale.GetScaleX
	Width1 = 320dip * Scale.GetScaleX
	Space = 4dip * Scale.GetScaleX
	
	scvSetup.Initialize(0)
	Activity.AddView(scvSetup, (100%x - Width1) / 2, 0, Width1, 100%y)
	scvSetup.Color = Colors.RGB(255, 205, 250)
	scvSetup.Panel.LoadLayout("setup")
	
	Scale.ScaleAll(Activity, True)
	
	scvSetup.Height = 100%y
	If 100%x < 2 * Width + 3 * Space Then
		' setup panels in one column
		scvSetup.Width = Width1
		scvSetup.Left = 50%x - Width1 / 2
		pnlSetup.Width = scvSetup.Width
		scvSetup.Panel.Width = pnlSetup.Width
		pnlSetup.Height = pnlMapMarkers.Top + pnlMapMarkers.Height + Space
		scvSetup.Panel.Height = pnlSetup.Height
		DoEvents
	Else
		' setup panels in two columns
		Left = Width + 2 * Space
		
		scvSetup.Width = 2 * Width + 3 * Space
		scvSetup.Panel.Width = scvSetup.Width
		pnlSetup.Width = scvSetup.Width
		scvSetup.Left = 50%x - scvSetup.Width / 2
		
		pnlMapSetup.Top = Space
		pnlMapSetup.Left = Left
		
		pnlMapLine.Top = pnlMapSetup.Top + pnlMapSetup.Height + Space
		pnlMapLine.Left = Left
		
		pnlMapMarkers.Top = pnlMapLine.Top + pnlMapLine.Height + Space
		pnlMapMarkers.Left = Left
		scvSetup.Panel.Height = pnlGPSSetup.Top + pnlGPSSetup.Height + Space
	End If
	FillSpinners
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub FillSpinners
	spnMapZoomLevel.Add("15")
	spnMapLineWidth.Add("5")
	spnMapLineColor.Add("Red")
	spnMapLineOpacity.Add("1")
	spnMapTypeControlID.Add("MAP")
	spnMapZoomControlType.Add("15")
	spnAltitudeUnit.Add("m")
	spnSpeedUnit.Add("km/h")
	spnDistanceUnit.Add("km")
End Sub

