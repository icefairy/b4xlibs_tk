Type=Class
Version=3.2
@EndOfDesignText@
'Class module
Sub Class_Globals
	Private fromAssets As Boolean
End Sub

Public Sub Initialize (FromAssetsFile As Boolean)
	fromAssets = FromAssetsFile
End Sub

Public Sub LoadFileFileFromJar(FileName As String) As InputStream
	if fromAssets then return File.OpenInput(File.DirAssets, FileName)
	Dim r As Reflector
	r.Target = Me
	r.Target = r.RunMethod("getClass")
	Dim In As InputStream = r.RunMethod2("getResourceAsStream", "/" & FileName, "java.lang.String")
	If In.IsInitialized = False Then
		LogColor("Cannot find file: " & FileName, Colors.Red)
	End If
	Return In
End Sub

Public Sub LoadBitmapFromJar(FileName As String) As Bitmap
	Dim bmp As Bitmap
	Dim In As InputStream = LoadFileFileFromJar(FileName)
	bmp.Initialize2(In)
	In.Close
	Return bmp
End Sub