Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@

#Event: ItemClick (st as Subject)
#DesignerProperty: Key: colNum, DisplayName: colNum, FieldType: Int, DefaultValue: 4, MinRange: 1, MaxRange: 10, Description: colNum.
#DesignerProperty: Key: colRow, DisplayName: colRow, FieldType: Int, DefaultValue: 2, MinRange: 1, MaxRange: 10, Description: colRow.
'#DesignerProperty: Key: divH, DisplayName: divH, FieldType: Int, DefaultValue: 0, MinRange: 0, MaxRange: 1000, Description: divH.
'#DesignerProperty: Key: divV, DisplayName: divV, FieldType: Int, DefaultValue: 0, MinRange: 0, MaxRange: 1000, Description: divV
Sub Class_Globals
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private mBase As WeakRef
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Private sv As ScrollView
	Public Items As List
	Public colNum As Int=4,colRow As Int=2,nCurPtr As Int=0
	Private nTmrIntval As Int=100
	Private tmr As Timer '用来解决奇妙问题的~
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
	sv.Panel.Color=Base.Color
	colNum=Props.GetDefault("colNum",4)
	colRow=Props.GetDefault("colRow",2)
	Base.AddView(sv,0,0,Base.Width,Base.Height)
	sv.Visible=False
End Sub

Private Sub Base_Resize (Width As Double, Height As Double)
	sv.Width=Width
	sv.Height=Height
	sv.ContentWidth=GetBase.Width
	sv.ContentHeight=Height
End Sub
Public Sub refush
	Dim dw As Double=GetBase.Width
	Dim dh As Double=GetBase.Height
	sv.ContentWidth=dw*2
	sv.Width=GetBase.Width
	sv.ScrollOffsetX=0
	Dim nItemWidth As Int=sv.Width/4
	Dim nItemHeight As Int=70dip'=sv.Height/2
	Dim nDivH As Int=(dw-nItemWidth*colNum)/(colNum+1)
	Dim nDivV As Int=(dh-nItemHeight*colRow)/(colRow+1)
	If nDivV<0 Then nDivV=0
'	Log("h:"&nDivH&" v:"&nDivV)
	Dim nl=nDivH,lt=nDivV As Int
	sv.Panel.RemoveAllViews
	Dim nPtr As Int=0
	Dim nPageIdx As Int=0
	For i=0 To Items.Size-1
		Dim p As Panel
		p.Initialize("ivitem")
		p.LoadLayout("item_kemu")
		p.Color=sv.Panel.Color
		Dim iv As ImageView=p.GetView(0)
		Dim lbl As Label=p.GetView(1)
		Dim st As Subject=Items.Get(i)
		p.Tag=st
		comm.loadimg(st.img,iv)
		lbl.Text=st.name
		sv.Panel.AddView(p,nl,lt,nItemWidth,nItemHeight)
		iv.SetBorder(0,0,iv.Width/3)
		nl=p.Width+p.Left
		If nPtr=3 Then
			If nPageIdx=0 Then
			 	nl=nDivH
			Else
				nl=nDivH+sv.Width
			End If
			lt=GetSV.Height/2
		else if nPtr=7 Then
			nPtr=-1
			nPageIdx=nPageIdx+1
			nl=nDivH+sv.Width
			lt=nDivV
		End If
'		Log("idx:"&i&" nPtr:"&nPtr&st.name&" L:"&nl&" T:"&lt)
		nPtr=nPtr+1
'		If i=12 Then Exit
	Next
	InitializePS(comm.jin1(Items.Size,colRow*colNum))
	SetPageIndicator(0)
	Add2Parent(GetBase)
	If nTmrIntval =100 Then
		tmr.Initialize("tmr",nTmrIntval)
		tmr.Enabled=True
	End If
	sv.Visible=True
End Sub
private Sub tmr_Tick
	tmr.Enabled=False
	nTmrIntval=-1
	refush
End Sub
Public Sub GetSV As ScrollView
	Return sv
End Sub
Public Sub GetBase As Panel
	Return mBase.Value
End Sub
Sub ivitem_Click
	If SubExists(CallBack,EventName&"_ItemClick",1) Then
		Dim iv As Panel=Sender
		Dim st As Subject=iv.Tag
		CallSub2(CallBack,EventName&"_ItemClick",st)
	End If
End Sub
private Sub sv_ScrollChanged (OffsetX As Int, OffsetY As Int)
	SetPageIndicator(OffsetX/sv.Width)
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