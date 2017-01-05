Type=Class
Version=5.2
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private context As Object
	Private jopv As JavaObject
End Sub

'Initializes the object. You can add parameters to this method if needed.
'add this to the main:#AdditionalJar:b4aPhotoView
'wrap from :https://github.com/chrisbanes/PhotoView
Public Sub Initialize(act As Activity)
	Dim jo As JavaObject = act
	context=jo.RunMethod("getContext", Null)
	jo.InitializeContext
	jopv=jo.InitializeNewInstance("uk.co.senab.photoview.PhotoView",Array(context))
End Sub
Public Sub asview As View
	Return jopv
End Sub
Public Sub setBitmap(bmp As Bitmap)
	jopv.RunMethod("setImageBitmap",Array As Object(bmp))
End Sub
Public Sub setMinimumScale(minimumScale As Float)
	jopv.RunMethod("setMinimumScale",Array As Object(minimumScale))
End Sub
Public Sub getMinimumScale As Float
	Return jopv.RunMethod("getMinimumScale",Null)
End Sub
Public Sub setMediumScale(MediumScale As Float)
	jopv.RunMethod("setMediumScale",Array As Object(MediumScale))
End Sub
Public Sub getMediumScale As Float
	Return jopv.RunMethod("getMediumScale",Null)
End Sub
Public Sub setMaximumScale(maximumScale As Float)
	jopv.RunMethod("setMaximumScale",Array As Object(maximumScale))
End Sub
Public Sub getMaximumScale As Float
	Return jopv.RunMethod("getMaximumScale",Null)
End Sub
Public Sub canZoom As Boolean
	Return jopv.RunMethod("canZoom",Null)
End Sub
Public Sub setScale(Scale As Float,animate As Boolean)
	jopv.RunMethod("setScale",Array(Scale,animate))
End Sub
Public Sub getScale As Float
	Return jopv.RunMethod("getScale",Null)
End Sub
Public Sub setRotationTo(Rotation As Float)
	jopv.RunMethod("setRotationTo",Array(Rotation))
End Sub
Public Sub setRotationBy(Rotation As Float)
	jopv.RunMethod("setRotationBy",Array(Rotation))
End Sub