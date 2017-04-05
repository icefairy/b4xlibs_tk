Type=Class
Version=5
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private te As WPTemplateEngine
End Sub

Public Sub Initialize
	te.Initialize
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	te.bindResponse(resp)
	te.putData("headertitle","WebPlusTitle")
	te.putData("title","网页中的标题")
	te.putData("bodyhtml","<script>alert('test');</script>")
	te.putData("bodytext","普通的￥文本<br>$3331'")
	te.putData("my",CreateMap("username":"icefairy","comefrom":"China"))
	te.putData("footertext","关于我们（尾部）")
	te.renderTPL("/live/live")
End Sub