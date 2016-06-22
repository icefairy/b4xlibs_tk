Type=Class
Version=6
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@

Sub Class_Globals
	Public nMax As Int
	Private nCur As Int=0
	Public activebmp As Bitmap=LoadBitmap(File.DirAssets,"indicator_active.png")
	Public inactivebmp As Bitmap=LoadBitmap(File.DirAssets,"indicator_inactive.png")
	Private basePanel As Panel
	Public nHeight As Int=7dip
	Public Width As Int=0
	Public njg As Int=5dip
End Sub

'Initializes the object. You can add parameters to this method if needed.
'do not forgot init the activebmp and inactivebmp
Public Sub Initialize(nMaxPage As Int)
	nMax=nMaxPage
	Width=nHeight*nMax
	Dim imageSize, maxWidth, Gap, Top As Int
	njg=5dip
	Width=Width+njg*(nMax-1)
	maxWidth = Width / nMax 'org
	If maxWidth < nHeight Then
		imageSize = maxWidth
		Top = (nHeight - maxWidth) / 2
		Gap = 0
	Else
		imageSize = nHeight
		Top = 0
		Gap = (Width - nMax * imageSize) / (nMax - 1)
	End If
	basePanel.Initialize("")
	For i = 0 To nMax - 1
		Dim iv As ImageView
		iv.Initialize("")
		iv.Gravity=Gravity.FILL
		iv.Bitmap = inactivebmp
		basePanel.AddView(iv, i * (imageSize + Gap), Top, imageSize, imageSize)
	Next
	SetPageIndicator(0)
End Sub
Public Sub asView As Panel
	Return basePanel
End Sub
public Sub SetPageIndicator(page As Int)
	Dim v As View
	Dim iv As ImageView
	nCur=page
	For i = 0 To nMax - 1
		v = basePanel.GetView(i)
		If v Is ImageView Then
			iv = v
			If i = page Then
				iv.Bitmap = activebmp
			Else
				iv.Bitmap = inactivebmp
			End If
		End If
	Next
End Sub
Public Sub getCurPage 
	Return nCur
End Sub
Public Sub Add2Parent(panel As Panel)
	panel.AddView(basePanel,(panel.Width-Width)/2,panel.Height-nHeight-njg,Width,nHeight)
End Sub