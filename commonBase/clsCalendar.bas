Type=Class
Version=3.48
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'version 1.00
'author icefairy333
#Event: CellClick (Value As Int,Str as String)
#DesignerProperty: Key: SingleSelect, DisplayName: SingleSelect, FieldType: Boolean, DefaultValue: True, Description: SingleSelect
#DesignerProperty: Key: IntExample, DisplayName: Int Example, FieldType: Int, DefaultValue: 10, MinRange: 0, MaxRange: 100, Description: Note that MinRange and MaxRange are optional.
#DesignerProperty: Key: StringWithListExample, DisplayName: String With List, FieldType: String, DefaultValue: Sunday, List: Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday
#DesignerProperty: Key: StringExample, DisplayName: String Example, FieldType: String, DefaultValue: Text
#DesignerProperty: Key: ColorExample, DisplayName: Color Example, FieldType: Color, DefaultValue: 0xFFCFDCDC, Description: You can use the built-in color picker to find the color values.
Sub Class_Globals
	Private EventName As String 'ignore
	Private CallBack As Object 'ignore
	Private mBase As Panel
	Type tColorDrawable(color As Int,radius As Int,boardwidth As Int,boardcolor As Int)
	Public month,year,nCurYear,nCurMonth,nCurDay As Int
	' 每一格的宽度
	Private mWidth As Float
	'每一格的高度
	Private mHeight As Float
	Public cellNormalTextColor As Int=Colors.Black
	Public cellNormalTextBgColor As Int=Colors.White
	Public SingleSelect As Boolean=True
	Public lstSelected As List
	Public cellSelectedTextColor As Int=Colors.White
	Public cellSelectedBgColor As Int=0xFF009688
	Public cellTodayTextColor As Int=Colors.Red
	Public cellTodayBgColor As Int=Colors.White
	Public sTitleWords() As String=Array As String("日","一","二","三","四","五","六")
	Public TitleTextColor As Int=Colors.Blue
	Private lbls(7,7) As Label'x,y x行 y 列
	#if b4a
	Private cdNormal,cdPressed,cdToday As ColorDrawable
	#end if
	#if b4i
	Private cdNormal,cdPressed,cdToday As tColorDrawable
	#end if
	
End Sub

Public Sub Initialize (vCallback As Object, vEventName As String)
	EventName = vEventName
	CallBack = vCallback
	lstSelected.Initialize
	nCurYear=DateTime.GetYear(DateTime.Now)
	nCurMonth=DateTime.GetMonth(DateTime.Now)
	nCurDay=DateTime.GetDayOfMonth(DateTime.Now)
End Sub
Public Sub DesignerCreateView (Base As Panel, lbl As Label, Props As Map)
	mBase = Base
	mWidth= Base.Width/7
	mHeight=Base.Height/7
	SingleSelect=Props.GetDefault("SingleSelect",True)
	'正方形
	Dim nDivder As Int=(Base.Width-(mHeight*7))/8
	Dim nL,nT As Int
	For i=0 To 6
		For j=0 To 6
			lbls(i,j).Initialize("lbl")
			#if b4a
			lbls(i,j).Gravity=Gravity.CENTER
			#end if
			#if b4i
			lbls(i,j).TextAlignment=lbls(i,j).ALIGNMENT_CENTER
			#end if
			lbls(i,j).Textcolor=cellNormalTextColor
			nT=i*mHeight
			nL=j*mWidth+nDivder/2
			mBase.AddView(lbls(i,j),nL,nT,mHeight,mHeight)
		Next
	Next
	For j=0 To 6
		lbls(0,j).Text=sTitleWords(j)
		lbls(0,j).Tag=0
		lbls(0,j).TextColor=TitleTextColor
	Next
End Sub
Private Sub FillData
	#if b4a
	cdNormal.Initialize2(cellNormalTextBgColor,1,0.5dip,cellNormalTextBgColor)
	cdPressed.Initialize2(cellSelectedBgColor,30dip,1dip,cellSelectedTextColor)
	cdToday.Initialize2(cellTodayBgColor,30dip,1dip,cellTodayTextColor)
	#end if
	#if b4i
	cdNormal.Initialize
	cdNormal.color=cellNormalTextBgColor
	cdNormal.radius=0
	cdNormal.boardwidth=0
	cdNormal.boardcolor=cellNormalTextBgColor
	cdPressed.Initialize
	cdPressed.color=cellSelectedBgColor
	'	cdPressed.radius=13dip
	cdPressed.radius=mHeight/2
	cdPressed.boardwidth=0
	cdPressed.boardcolor=cellSelectedTextColor
	cdToday.Initialize
	cdToday.color=cellTodayBgColor
	'	cdToday.radius=13dip
	cdToday.radius=mHeight/2
	cdToday.boardwidth=1dip
	cdToday.boardcolor=cellTodayTextColor
	#end if
	
	Dim nT As Int
	For i=0 To 5
		For j=0 To 6
			nT=getTitle(j,i)
			lbls(i+1,j).Text= getTitleString(nT)
			lbls(i+1,j).Tag=nT
			#if b4a
			If lstSelected.IndexOf(nt)>-1 Then
				lbls(i+1,j).Background=cdPressed
				lbls(i+1,j).TextColor=cellSelectedTextColor
			Else If year=nCurYear And month =nCurMonth And nt=nCurDay Then
				lbls(i+1,j).Background=cdToday
				lbls(i+1,j).TextColor=cellTodayTextColor
			Else
				lbls(i+1,j).Background=cdNormal	
				lbls(i+1,j).TextColor=cellNormalTextColor
			End If
			lbls(i+1,j).Invalidate
			#end if
			#if b4i
			If lstSelected.IndexOf(nT)>-1 Then
				lbls(i+1,j).Color=cdPressed.color
				'				lbls(i+1,j).TintColor=cdPressed.color
				lbls(i+1,j).SetBorder(0,cdPressed.boardcolor,cdPressed.radius)
				'				lbls(i+1,j).SetBorder(cdPressed.boardwidth,cdPressed.boardcolor,1)
				lbls(i+1,j).TextColor=cellSelectedTextColor
			Else If year=nCurYear And month =nCurMonth And nT=nCurDay Then
				lbls(i+1,j).Color=cdToday.color
				'				lbls(i+1,j).TintColor=cdToday.color
				lbls(i+1,j).SetBorder(cdToday.boardwidth,cdToday.boardcolor,cdToday.radius)
				'				lbls(i+1,j).SetBorder(cdToday.boardwidth,cdToday.boardcolor,1)
				lbls(i+1,j).TextColor=cellTodayTextColor
			Else
				lbls(i+1,j).Color=cdNormal.color
				'				lbls(i+1,j).TintColor=cdNormal.color
				'				lbls(i+1,j).SetBorder(cdNormal.boardwidth,cdNormal.boardcolor,cdNormal.radius)
				lbls(i+1,j).SetBorder(cdNormal.boardwidth,cdNormal.boardcolor,1)
				lbls(i+1,j).TextColor=cellNormalTextColor
			End If
			
			#end if
		Next
	Next
End Sub
Sub lbl_Click
	Dim v As Label=Sender
	If v.Tag<1 Then Return
	#if b4a
	If SubExists(CallBack,EventName&"_CellClick") Then
		CallSub3(CallBack,EventName&"_CellClick",v.Tag,v.Text)
	Else
		Log(v.Tag&" sub not exist")
	End If
	#end if
	#if b4i
	If SubExists(CallBack,EventName&"_CellClick",2) Then
		CallSub3(CallBack,EventName&"_CellClick",v.Tag,v.Text)
	Else
		Log(v.Tag&" sub not exist")
	End If
	#end if
	Dim n As Int
	n=lstSelected.IndexOf(v.Tag)
	If n>-1 Then
		lstSelected.RemoveAt(n)
	Else
		If SingleSelect Then
			If lstSelected.Size=0 Then lstSelected.Add("")
			lstSelected.Set(0,v.Tag)
		Else
			lstSelected.Add(v.Tag)
		End If
	End If
	FillData
End Sub
Public Sub GetBase As Panel
	Return mBase
End Sub
Public Sub getDayArray(y As Int,m As Int) As Int()
	DateTime.DateFormat="yyyy-MM-dd"
	Dim dt As Long=DateTime.DateParse(y&"-"&m&"-01")
	Dim day As Int=DateTime.GetDayOfWeek(dt)
	Dim monthday() As Int=Array As Int(31,28,31,30,31,30,31,31,30,31,30,31)
	If y Mod 4==0 And y Mod 100<>0 And y Mod 400=0 Then
		monthday(1)=monthday(1)+1
	End If
	Dim tm(42) As Int
	Dim i As Int=1
	For j=day-1 To monthday(m-1)+day-2
		tm(j)=i
		i=i+1
	Next
	Return tm
End Sub
Public Sub setTime(nYear As Int,nMonth As Int)
	year=nYear
	month=nMonth
	FillData
End Sub
public Sub getTitleString(n As Int) As String
	Dim v As Int=n
	If v<1 Then
		Return ""
	Else
		Return ""&v
	End If
End Sub
Private Sub getTitle(x As Int,y As Int) As Int
	'Dim jo As JavaObject=Me
	Dim intarr() As Int'=jo.RunMethod("getDayArray",Array(year,month))
	intarr=getDayArray(year,month)
	Dim ret=-1 As Int
	Try
		ret=intarr(y*7+x)
	Catch
		ret=-1
		Log(LastException.Message)
	End Try
	Return ret
End Sub