Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
#Event: ItemClick (idx As Int,it As ImageItem)
#Event: ItemLongClick (idx As Int,it As ImageItem)
#DesignerProperty: Key: BooleanExample, DisplayName: Boolean Example, FieldType: Boolean, DefaultValue: True, Description: Example of a boolean property.
#DesignerProperty: Key: IntExample, DisplayName: Int Example, FieldType: Int, DefaultValue: 10, MinRange: 0, MaxRange: 100, Description: Note that MinRange and MaxRange are optional.
#DesignerProperty: Key: StringWithListExample, DisplayName: String With List, FieldType: String, DefaultValue: Sunday, List: Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday
#DesignerProperty: Key: StringExample, DisplayName: String Example, FieldType: String, DefaultValue: Text
#DesignerProperty: Key: ColorExample, DisplayName: Color Example, FieldType: Color, DefaultValue: Null, Description: You can use the built-in color picker to find the color values.
Sub Class_Globals
	Type ImageItem(url As String,title As String,tag As Object)
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private mBase As WeakRef
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Private sv As ScrollView
	Public Items As List
	Private tmr As Timer
	Private AutoScrolling As Boolean=True
	Public ScrollingIntval As Int=5000
	Private nCurPtr As Int=0
	'pageswitcher
	Private psAdded As Boolean=False
	Private nMax As Int
	Private nCur As Int=0
	Public activebmp As Bitmap=LoadBitmap(File.DirAssets,"indicator_active.png")
	Public inactivebmp As Bitmap=LoadBitmap(File.DirAssets,"indicator_inactive.png")
	Private basePanel As Panel
	Public nHeight As Int=7dip
	Public nWidth As Int=0
	Public njg As Int=5dip
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	Items.Initialize
End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase.Value = Base
	sv.Initialize("sv",Base.Width,Base.Height)
	sv.ScrollEnabled=True
	sv.PagingEnabled=True
	Base.AddView(sv,0,0,Base.Width,Base.Height)
	
End Sub

public Sub GetAutoScrolling As Boolean
	Return AutoScrolling
End Sub
Public Sub SetAutoScrolling(b As Boolean)
	AutoScrolling=b
	If AutoScrolling Then
		If tmr.IsInitialized Then tmr.Enabled=False
		tmr.Initialize("tmr",ScrollingIntval)
		tmr.Enabled=True
	End If
End Sub
Public Sub getCurIndex As Int
	Return nCurPtr
End Sub
Public Sub setCurIndex(idx As Int)
	nCurPtr=idx
	refush
End Sub
private Sub tmr_Tick
	If Items.Size>1 Then
		If nCurPtr<(Items.Size-1) Then
			nCurPtr=nCurPtr+1
		Else
			nCurPtr=0
		End If
		refush
	End If
End Sub
private Sub sv_ScrollChanged (OffsetX As Int, OffsetY As Int)
	SetPageIndicator(OffsetX/sv.Width)
End Sub
Private Sub Base_Resize (Width As Double, Height As Double)
	sv.Width=Width
	sv.Height=Height
	sv.ContentWidth=Width
	sv.ContentHeight=Height
End Sub
Public Sub GetSV As ScrollView
	Return sv
End Sub
Public Sub GetBase As Panel
	Return mBase.Value
End Sub
Public Sub refush
	Dim dw As Double=GetBase.Width
	sv.ContentWidth=dw*Items.Size
	sv.ScrollOffsetX=nCurPtr*dw
	sv.Panel.RemoveAllViews
	For i=0 To Items.Size-1
		Dim it As ImageItem
		Dim iv As ImageView
		iv.Initialize("ivitem")
		Dim m As Map
		m.Initialize
		it=Items.Get(i)
		m.Put("idx",i)
		m.Put("it",it)
		iv.Tag=m
		comm.loadimg(it.url,iv)
		iv.ContentMode=iv.MODE_FILL
		sv.Panel.AddView(iv,i*dw,0,GetBase.Width,GetBase.Height)
	Next
	InitializePS(Items.Size)
	SetPageIndicator(nCurPtr)
	Add2Parent(GetBase)
End Sub
Sub ivitem_Click
	If SubExists(CallBack,EventName&"_ItemClick",2) Then
		Dim iv As ImageView=Sender
		Dim m As Map=iv.Tag
		CallSub3(CallBack,EventName&"_ItemClick",m.Get("idx"),m.Get("it"))
	End If
End Sub
Sub ivitem_LongClick
	If SubExists(CallBack,EventName&"_ItemLongClick",2) Then
		Dim iv As ImageView=Sender
		Dim m As Map=iv.Tag
		CallSub3(CallBack,EventName&"_ItemLongClick",m.Get("idx"),m.Get("it"))
	End If
End Sub
#Region pageswitcher
Public Sub InitializePS(nMaxPage As Int)
	nMax=nMaxPage
	nWidth=nHeight*nMax
	Dim imageSize, maxWidth, Gap, Top As Int
	njg=5dip
	nWidth=nWidth+njg*(nMax-1)
	maxWidth = nWidth / nMax 'org
	If maxWidth < nHeight Then
		imageSize = maxWidth
		Top = (nHeight - maxWidth) / 2
		Gap = 0
	Else
		imageSize = nHeight
		Top = 0
		Gap = (nWidth - nMax * imageSize) / (nMax - 1)
	End If
	If basePanel.IsInitialized Then
		basePanel.RemoveAllViews
	Else
		basePanel.Initialize("")
	End If
	
	For i = 0 To nMax - 1
		Dim iv As ImageView
		iv.Initialize("")
		#if b4i
		iv.ContentMode=iv.MODE_FIT
		#else if b4a
		iv.Gravity=Gravity.FILL
		#end if
		iv.Bitmap = inactivebmp
		basePanel.AddView(iv, i * (imageSize + Gap), Top, imageSize, imageSize)
	Next
	SetPageIndicator(0)
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
	If Not(psAdded) Then
		psAdded=True
		panel.AddView(basePanel,(panel.Width-nWidth)/2,panel.Height-nHeight-njg,nWidth,nHeight)
	End If
End Sub
#End Region