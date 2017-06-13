Type=Class
Version=5.45
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'Class module

' USAGE:
' Sub Class_Globals
'    Dim custGauge As CustomGauge
'
' Sub BuildPage()
'   page.AddExtraJavaScriptFile("custom/justgage.js") 
'	page.AddExtraJavaScriptFile("custom/raphael-2.1.4.min.js")
'
' Sub ConnectPage()
'   custGauge.Initialize(page, "custGauge", 25, "Test")
'   page.Cell(7,1).AddComponent(custGauge.ABMComp)
'	
'   Dim custGaugebtn1 As ABMButton
'   custGaugebtn1.InitializeRaised(page, "custGaugebtn1", "", "", "BUTTON", "")
'	page.Cell(7,1).AddComponent(custGaugebtn1)
'
'Sub custGaugebtn1_Clicked(Target As String)
'	custGauge.myValue = Rnd(10,100)
'	custGauge.ABMComp.Refresh
'End Sub

Sub Class_Globals
	Public ABMComp As ABMCustomComponent
    Public myValue As Int
    Public myLabel As String
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(InternalPage As ABMPage, ID As String, value As Int, name As String)
    ABMComp.Initialize("ABMComp", Me, InternalPage, ID)
    myValue = value
    myLabel = name
End Sub

Sub ABMComp_Build(internalID As String) As String
    Return $"<div id="${internalID}"></div><script>var _${internalID};</script>"$
End Sub

' Is useful to run some initalisation script.
Sub ABMComp_FirstRun(InternalPage As ABMPage, internalID As String)
    Dim script As String = $"_${internalID} = new JustGage({
                             id: "${internalID}",
                             value: ${myValue},
                             Min: 0,
                             Max: 100,
                             relativeGaugeSize: true,
                             title: "${myLabel}"
                           });"$

     InternalPage.ws.Eval(script, Array As Object(ABMComp.ID))
    ' flush not needed, it's done in the refresh method in the lib
End Sub

' runs when a refresh is called
Sub ABMComp_Refresh(InternalPage As ABMPage, internalID As String)   
   Dim script As String = $"_${internalID}.refresh(${myValue});"$
   InternalPage.ws.Eval(script, Null)
End Sub

' do the stuff needed when the object is removed
Sub ABMComp_CleanUp(InternalPage As ABMPage, internalID As String)
	
End Sub