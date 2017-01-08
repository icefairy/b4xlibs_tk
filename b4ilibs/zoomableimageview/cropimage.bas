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
	Private cvzi As cviZoomableImageView
	Private prect As Panel
	Private bMove As Boolean=False
	Private fx,fy As Float
End Sub
Public Sub show
	pg.Initialize("pg")
	pg.RootPanel.LoadLayout("crop")
	Main.NavControl.ShowPage(pg)
	'first setting param, if you donot need zoom you can set both min and max =1
	cvzi.MinScale=0.3
	cvzi.MaxScale=2
	'at last set the bitmap
	cvzi.Bitmap=LoadBitmap(File.DirAssets,"img.jpg")
	
End Sub

Sub prect_Touch(Action As Int, X As Float, Y As Float)
'	Log(Action)
	Select Action
	Case prect.ACTION_DOWN
			bMove=True
			fx=X-prect.Left
			fy=Y-prect.Top
	Case prect.ACTION_UP
			prect.Left=x-fx
			prect.Top=y-fy
			bMove=False
	Case prect.ACTION_MOVE
			If bMove Then
				prect.Left=X-fx
				prect.Top=y-fy
			End If
	End Select
'	Log("fx:"&fx&" fy:"&fy)
End Sub
Sub pg_BarButtonClick (Tag As String)
	If Tag.EqualsIgnoreCase("ok") Then
		Main.gotimg(cvzi.ZoomedImageArea(prect.Left,prect.Top,prect.Width,prect.Height))
		Main.NavControl.RemoveCurrentPage
	End If
End Sub