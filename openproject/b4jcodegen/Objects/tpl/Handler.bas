Type=Class
Version=5.9
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private te As WPTemplateEngine
	Public actionkey As String="$uripath$"
	Private db As SQL
	Private tablename As String="$tablename$"
End Sub

Public Sub Initialize
	te.Initialize
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	te.bindResponse(resp)
	db=wpDBUtils.conpool.GetConnection
	Dim routes() As String= G.url2Array(req.RequestURI)
	Dim actionidx As Int=routes.Length-1
	If SubExists(Me,routes(actionidx)) Then
		CallSub3(Me,routes(actionidx),req,resp)
	Else
		unknowaction(req,resp)
	End If
	db.Close
	Return
End Sub
Sub unknowaction(req As ServletRequest,resp As ServletResponse)
	te.renderText("unknow action:"&req.RequestURI)
End Sub
Sub list(req As ServletRequest,resp As ServletResponse)
	Dim pn As Int=G.str2int(req.GetParameter("pageno"),0)
	Dim ps As Int=G.str2int(req.GetParameter("pagesize"),10)
	Dim where As String=""
	Dim ret As Map
	ret.Initialize
	ret.Put("pageno",pn)
	ret.Put("pagesize",ps)
	If req.Method.EqualsIgnoreCase("get") Then
		Dim totalsize As Int=wpDBUtils.Pagination_TotalSize(db,"from "&tablename,where,Null)
		ret.Put("totalsize":totalsize)
		Dim lst As List=wpDBUtils.Pagination(db,"select *","from "&tablename,where,"",Null,pn,ps)
		ret.Put("lines",lst)
		If req.ContentType.IndexOf("json")>-1 Then
			te.renderJson(True,G.toJson(ret))
		Else
			te.putData("data",G.toJson(ret))
			te.renderTPL("$viewname$list")
		End If
		
	Else
		te.renderText("unknow method:"&req.Method)
	End If
End Sub
Sub delete(req As ServletRequest,resp As ServletResponse)
	Dim id As Int=G.str2int(req.GetParameter("id"),-1)
	wpDBUtils.UpdateRecord(db,tablename,"deleted",1,CreateMap("id":id))
	te.renderJson(True,"删除成功")
End Sub
Sub edit(req As ServletRequest,resp As ServletResponse)
	Dim id As Int=G.str2int(req.GetParameter("id"),-1)
	Dim ret As Map
	ret.Initialize
	If req.Method.EqualsIgnoreCase("get") Then
		Dim m As Map=wpDBUtils.ExecuteMap(db,"select * from "&tablename&" where id=? and deleted=0",Array As Object(id))
		ret.Put("info",m)
		te.putData("data",G.toJson(ret))
	Else
		Dim info As Map=reqUtils.getReqMapByModulename(req,"info")
		wpDBUtils.UpdateRecord2(db,tablename,info,CreateMap("id":id))
		te.renderJson(True,"更新成功")
	End If
End Sub