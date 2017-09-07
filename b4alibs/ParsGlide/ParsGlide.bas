Type=Class
Version=7.01
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Class_Globals
	Private context As Object
End Sub

Public Sub Initialize(url As Object,img As ImageView,placeholder As Int,error As Int,fallback As Int)As JavaObject
	Dim jo As JavaObject = getCurrentActivity
	context=jo.RunMethod("getContext", Null)
	jo.InitializeContext
	jo=GetRequestOptions.RunMethodJO("placeholder",Array(placeholder)).RunMethodJO("error", Array(error)).RunMethod("fallback",Array(fallback))
	jo=GetGlide.RunMethodJO("load", Array(url)).RunMethodjo("apply",Array(jo)).RunMethodJO("into", Array(img))
	Return jo
End Sub
public Sub AssetFile (FileName As String) As String
	Dim jo As JavaObject
	jo.InitializeStatic("anywheresoftware.b4a.objects.streams.File")
	If jo.GetField("virtualAssetsFolder") = Null Then
		Return "file:///android_asset/" & FileName.ToLowerCase
	Else
		Return "file://" & File.Combine(jo.GetField("virtualAssetsFolder"), _
       jo.RunMethod("getUnpackedVirtualAssetFile", Array As Object(FileName)))
	End If
End Sub
private Sub GetRequestOptions As JavaObject
	Dim jo As JavaObject
	Return jo.InitializeNewInstance("com.bumptech.glide.request.RequestOptions",Null)
End Sub
private Sub GetGlide As JavaObject
	Dim jo As JavaObject
	Return jo.InitializeStatic("com.bumptech.glide.Glide").RunMethod("with", Array(context))
End Sub
Sub getCurrentActivity As Activity
	Dim r As Reflector
	r.Target = r.GetActivityBA
	Return r.GetField("vg")
End Sub
