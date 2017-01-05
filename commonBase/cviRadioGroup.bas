Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@

#Event: ItemCheck(it as String)
#DesignerProperty: Key:isHorizontal, DisplayName: isHorizontal, FieldType: Boolean, DefaultValue: True, Description: is Horizontal?
#DesignerProperty: Key: nSelected, DisplayName: nSelected, FieldType: Int, DefaultValue: 0, MinRange: 0, MaxRange: 100, Description: nSelected
#DesignerProperty: Key: Items, DisplayName: Items, FieldType: String, DefaultValue: 1|2|3
#DesignerProperty: Key: clrCommon, DisplayName: clrCommon, FieldType: Color, DefaultValue: Null, Description: You can use the built-in color picker to find the color values.
#DesignerProperty: Key: clrSelected, DisplayName: clrSelected, FieldType: Color, DefaultValue: Null, Description: You can use the built-in color picker to find the color values.
Sub Class_Globals
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private mBase As WeakRef
	Private Const DefaultColorConstant As Int = -984833 'ignore
	Public clrCommon,clrSelected As Int,isHorizontal As Boolean=True
	Private items As List
	Public nSelect As Int
	Private tf As Font
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	items.Initialize
End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase.Value = Base
    tf=Lbl.Font
	clrCommon=Props.GetDefault("clrCommon",Colors.Black)
	clrSelected=Props.GetDefault("clrSelected",0xff009688)
	nSelect=Props.GetDefault("nSelected",0)
	isHorizontal=Props.GetDefault("isHorizontal",True)
	Dim titems As String=Props.GetDefault("Items","")
	If titems.Length>0 Then
		Dim strs() As String
		strs=Regex.Split("\|",titems)
		For Each s As String In strs
			items.Add(s)
		Next
	End If
'	refush
End Sub
Public Sub SetItems(lst As List)
	items=lst
	refush
End Sub
Public Sub refush
	Dim nh,nw As Int
	Log("refush")
	If items.IsInitialized And items.Size>0 Then
		If isHorizontal Then
			nh=GetBase.Height
			nw=GetBase.Width/items.Size
		Else
			nw=GetBase.Width
			nh=GetBase.Height/items.Size
		End If
		GetBase.RemoveAllViews
		Dim nLT As Int=5dip
		For i=0 To items.Size-1
			Dim lbl As Label
			lbl.Initialize("rbitem")
			lbl.Font=tf
			Dim m As Map
			m.Initialize
			m.Put("idx",i)
			If nSelect=i Then
				lbl.Text=Chr(0xF192)&" "&items.Get(i)'选中
				lbl.TextColor=clrSelected
				m.Put("flg",1)
				lbl.Tag=m
			Else
				lbl.Text=Chr(0xF1DB)&" "&items.Get(i)'未选中
				lbl.TextColor=clrCommon
				m.Put("flg",0)
				lbl.Tag=m
			End If
			
			If isHorizontal Then
				GetBase.AddView(lbl,nLT,0,nw,nh)
				nLT=nLT+nw
			Else
				GetBase.AddView(lbl,0,nLT,nw,nh)
				nLT=nLT+nw
			End If
		Next
	End If
	
End Sub
Private Sub updateCheck
	For i=0 To GetBase.NumberOfViews-1
		Dim lbl As Label=GetBase.GetView(i)
		Dim m As Map=lbl.Tag
		If i==nSelect Then
			lbl.Text=Chr(0xF192)&" "&items.Get(i)'选中
			lbl.TextColor=clrSelected
			m.Put("flg",1)
		Else
			lbl.Text=Chr(0xF1DB)&" "&items.Get(i)'未选中
			lbl.TextColor=clrCommon
			m.Put("flg",0)
		End If
		lbl.Tag=m
	Next
End Sub
Private Sub rbitem_Click
	Dim v As Label=Sender
	Dim m As Map=v.Tag
	nSelect=m.GetDefault("idx",0)
	updateCheck
	If SubExists(CallBack,EventName&"_ItemCheck",1) Then
		CallSub2(CallBack,EventName&"_ItemCheck",items.Get(nSelect))
	End If
End Sub
Private Sub Base_Resize (Width As Double, Height As Double)
	GetBase.Width=Width
	GetBase.Height=Height
	refush
End Sub

Public Sub GetBase As Panel
	Return mBase.Value
End Sub