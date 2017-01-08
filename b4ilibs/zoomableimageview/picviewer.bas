Type=StaticCode
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'Public variables can be accessed from all modules.
	Private pg As Page
	Private cviZoomableImageView1 As cviZoomableImageView
End Sub
Public Sub show
	pg.Initialize("pg")
	pg.RootPanel.LoadLayout("1")
	pg.Title = "ZoomableImageView"
	Main.NavControl.ShowPage(pg)
	'first setting param, if you donot need zoom you can set both min and max =1
	cviZoomableImageView1.MinScale=0.3
	cviZoomableImageView1.MaxScale=2
	'at last set the bitmap
	cviZoomableImageView1.Bitmap=LoadBitmap(File.DirAssets,"img.jpg")
End Sub