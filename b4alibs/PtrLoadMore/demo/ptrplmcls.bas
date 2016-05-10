Type=Class
Version=5.8
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
#Event: loadMore
#Event: reqRefush
#DesignerProperty: Key: hasHeader, DisplayName: hasHeader, FieldType: Boolean, DefaultValue: True, Description: hasHeader
#DesignerProperty: Key: hasTailer, DisplayName: hasTailer, FieldType: Boolean, DefaultValue: True, Description: hasTailer
#DesignerProperty: Key: pullToRefush, DisplayName: pullToRefush, FieldType: Boolean, DefaultValue: False, Description: pullToRefush
#DesignerProperty: Key: loadMore, DisplayName: loadMore, FieldType: Boolean, DefaultValue: true, Description: LoadMoreWhenAtBottom
'#DesignerProperty: Key: IntExample, DisplayName: Int Example, FieldType: Int, DefaultValue: 10, MinRange: 0, MaxRange: 100, Description: Note that MinRange and MaxRange are optional.
'#DesignerProperty: Key: StringWithListExample, DisplayName: String With List, FieldType: String, DefaultValue: Sunday, List: Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday
'#DesignerProperty: Key: StringExample, DisplayName: String Example, FieldType: String, DefaultValue: Text
'#DesignerProperty: Key: ColorExample, DisplayName: Color Example, FieldType: Color, DefaultValue: 0xFFCFDCDC, Description: You can use the built-in color picker to find the color values.
Sub Class_Globals
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private mBase As Panel
	Private sv As ScrollViewEx
	Private pHeader,pTailer,pData As Panel
	Private ref As Reflector
	Private StartY1,StartY2 As Long
	Private IsOverScroll1,IsOverScroll2 As Boolean
	Public nHeaderHeight=30dip,nTailerHeight=30dip As Int
	Public hasHeader=True,hasTailer=True,pullToRefush=False,loadMore=True As Boolean
	Private lastAddItemsTime As Long
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	pHeader.Initialize("")
	pTailer.Initialize("")
	pData.Initialize("")
End Sub

Public Sub DesignerCreateView (Base As Panel, Lbl As Label, Props As Map)
	mBase = Base
	hasHeader=Props.GetDefault("hasHeader",True)
	hasTailer=Props.GetDefault("hasTailer",True)
	pullToRefush=Props.GetDefault("pullToRefush",False)
	loadMore=Props.GetDefault("loadMore",True)
    sv.Initialize2(Base.Height,"sv")

	mBase.AddView(sv,0,0,mBase.Width,mBase.Height)
	If hasHeader Then
		sv.Panel.AddView(pHeader,0,0,sv.Panel.Width,nHeaderHeight)
		'test
		Dim Lbl As Label
		Lbl.Initialize("")
		Lbl.Text="我是头部"
		Lbl.Gravity=Gravity.CENTER
		pHeader.Visible=False
		pHeader.Color=Colors.Gray
		pHeader.AddView(Lbl,0,0,-1,-1)
		
	End If
	sv.Panel.AddView(pData,0,0,sv.Width,sv.Height)
	If hasTailer Then
		sv.Panel.AddView(pTailer,0,mBase.Height-nTailerHeight,sv.Panel.Width,nTailerHeight)
		'test
		Dim Lbl As Label
		Lbl.Initialize("")
		Lbl.Text="我是尾部"
		Lbl.Gravity=Gravity.CENTER
		pTailer.Color=Colors.Gray
		pTailer.Visible=False
		pTailer.AddView(Lbl,0,0,-1,-1)
		
	End If
	ref.Target=sv
	ref.SetOnTouchListener("ScrollView_Touch")
	
End Sub
'绑定触碰监听事件
Public Sub setInnerHeight(nh As Long)
	If nh=-1 Then
		Dim nMax As Int
		For Each v As View In pData.GetAllViewsRecursive
			If (v.Top+v.Height)>nMax Then nMax=v.Top+v.Height
		Next
		setInnerHeight(nMax)
	End If
	If nh<mBase.Height Then Return
	pData.Height=nh
	sv.Panel.Height=nh
End Sub
  Sub ScrollView_Touch (viewtag As Object, action As Int, X As Float, Y As Float, motionevent As Object) As Boolean

    Select Case action
     Case 0
      '按下
      StartY1=-1
      StartY2=-1
      IsOverScroll1=False
      IsOverScroll2=False
     Case 1
      '弹起
      StartY1=-1
      StartY2=-1
      If IsOverScroll1 Then
       SubHeader '移除头部区域
      End If
      If IsOverScroll2 Then
       SubTailer '移除尾部区域
      End If
     Case 2
     '拖动
      If StartY1<>-1 Then
       If Y>StartY1 And IsOverScroll1=False Then
        '向下拖动，准备显示头部
        IsOverScroll1=True
        AddHeader '增加头部区域
       End If
      End If
      If StartY2<>-1 Then
      If Y<StartY2 And IsOverScroll2=False Then
        '向上拖动，准备露出尾部
        IsOverScroll2=True
        AddTailer '增加尾部区域
       End If
      End If
      If sv.ScrollPosition=0 And IsOverScroll1=False Then
       '到顶部
       StartY1=Y
      End If
      If sv.ScrollPosition=sv.Panel.Height-sv.Height And IsOverScroll2=False Then
       '到底部
       StartY2=Y
      End If
    End Select
    Return False '允许继续响应控件事件
End Sub
Private Sub SubHeader
	pHeader.SetVisibleAnimated(1000,False)
	If hasHeader And pullToRefush And SubExists(CallBack,EventName&"_reqRefush") Then CallSubDelayed(CallBack,EventName&"_reqRefush")
End Sub
Private Sub SubTailer
	pTailer.SetVisibleAnimated(1000,False)
	If hasTailer And loadMore And SubExists(CallBack,EventName&"_loadMore") Then CallSubDelayed(CallBack,EventName&"_loadMore")
End Sub
private Sub AddHeader
	pHeader.SetVisibleAnimated(500,True)
	pHeader.BringToFront
	
End Sub
'Sub sv_ScrollChanged(Position As Int)
'   Log(sv.ScrollPosition)
'   If Position + sv.Height >= sv.Panel.Height Then
'     If DateTime.Now > lastAddItemsTime + 200 Then
'       lastAddItemsTime = DateTime.Now
'	   Log("fdsafasd")
'	   If hasTailer And loadMore And SubExists(CallBack,EventName&"_loadMore") Then CallSubDelayed(CallBack, EventName & "_loadMore")
'     End If
'   End If
'End Sub
private Sub AddTailer
'	Log("showTail h:"&pTailer.Height)
	pTailer.Top=pData.Height-nTailerHeight
	pTailer.SetVisibleAnimated(500,True)
	pTailer.BringToFront
	
End Sub
Public Sub GetSV As ScrollView
	Return sv
End Sub
public Sub GetPData As Panel
	Return pData
End Sub