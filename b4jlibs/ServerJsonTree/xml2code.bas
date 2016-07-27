Type=Class
Version=4.2
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Handler class
Sub Class_Globals
	Private mResp As ServletResponse
	Private resMap As Map
	Dim sb_code,sb_findcode,sb_findcode2 As StringBuilder
	Dim jsg As JSONGenerator
End Sub

Public Sub Initialize
	
End Sub

Sub Handle(req As ServletRequest, resp As ServletResponse)
	resp.ContentType = "application/json"
	resp.CharacterEncoding="UTF-8"
	mResp=resp
	Dim data() As Byte = Bit.InputStreamToBytes(req.InputStream)
	Dim text As String = BytesToString(data, 0, data.Length, "UTF8")
	sb_code.Initialize
	sb_code.Append("//Views").Append(CRLF)
	sb_findcode.Initialize
	sb_findcode.Append($"/* add this to your base class
	public <T> T mFindView(int resId) {
        Return (T)getActivity().findViewById(resId);
    }

    Public <T> T mFindView(View v, int resId) {
        Return (T) v.findViewById(resId);
    } */"$).Append(CRLF).Append("//find view type1 for activity").Append(CRLF)
	sb_findcode2.Initialize
	sb_findcode2.Append("//find view type2 for fragment or adapter ").Append(CRLF)
	parseViews(text)
	resMap.Initialize
	resMap.Put("code",sb_code.ToString&CRLF&CRLF&sb_findcode.ToString&CRLF&CRLF&sb_findcode2.ToString)
	resMap.Put("tree","")
	resMap.Put("success", True)
	
	jsg.Initialize(resMap)
	mResp.Write(jsg.ToString)
End Sub
Public Sub parseViews(str As String)
	Dim strs() As String=Regex.Split("<",str)
	Try
		For i=0 To strs.Length-1
			If strs(i).Length>2 Then
				'Log(strs(i))
				Dim a As Int=strs(i).IndexOf(" ")
				If a>-1 Then
					Dim typName As String=strs(i).SubString2(0,a-1)
					Dim ids() As String=Regex.Split("@\+id/",strs(i))'=会被识别为正则表达式组成元素需要加转义符
					Dim idname As String
					'Log(ids.Length)
					If ids.Length>1 Then
						idname=ids(1).SubString2(0,ids(1).IndexOf(""""))
						sb_code.Append("private "&typName&" "&idname&";").Append(CRLF)	
						sb_findcode.Append(idname&" = mFindView(R.id."&idname&");").Append(CRLF)
						sb_findcode.Append(idname&".setOnClickListener(this);").Append(CRLF)
						sb_findcode2.Append(idname&" = mFindView(v,R.id."&idname&");").Append(CRLF)
						sb_findcode2.Append(idname&".setOnClickListener(this);").Append(CRLF)
					End If
				End If
			End If
			
		Next
	Catch
		Log(LastException.Message)
	End Try
	'Log(sb_code.ToString)
End Sub