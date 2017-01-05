Type=StaticCode
Version=5.2
ModulesStructureVersion=1
B4A=true
@EndOfDesignText@
'Code module

'Subs in this code module will be accessible from all modules.
Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.

	Public const VIS_VISIBLE As Int = 0
	Public const VIS_INVISIBLE As Int = 4
	Public const VIS_GONE As Int = 8
End Sub

'Load an XML defined standard Android layout file. It is returned as a normal View object.
'You can add the returned value to a Panel.
'
'Layout - the layout file from the resources directory to load.
Public Sub InflateXmlLayout(Layout As String) As View
	Dim r As Reflector
	Dim id As Int
	
	r.Target = r.GetContext
	r.Target = r.RunMethod2("getSystemService", "layout_inflater", "java.lang.String")

	id = r.GetStaticField(Application.PackageName & ".R$layout", Layout)
	Return r.RunMethod4("inflate", Array As Object(id, Null), Array As String("java.lang.int", "android.view.ViewGroup"))
End Sub

'Find a view by its name
'
'Parent - Parent object hierarchy
'ViewName - The view to search for
Public Sub FindView(Parent As View, ViewName As String) As View
	Dim jo As JavaObject
	
	jo = Parent
	Return jo.RunMethod("findViewById", Array As Object(GetResourceId("id", ViewName)))
End Sub

'Set the text for a View.
'
'Parent - The parent view. The named view is searched from here.
'ViewName - Name of the view to find as defined in the xml Layout file
'Text - The text string to set
Public Sub SetXmlViewText(TargetView As View, Text As String)
	Dim jo As JavaObject
	
	jo = TargetView
	jo.RunMethod("setText", Array As Object(Text))
End Sub

'Sets the text color of a view.
'
' TargetView - The target.
' Color - The color for the text.
Public Sub SetXmlViewTextColor(TargetView As View, Color As Int)
	Dim jo As JavaObject
	
	jo = TargetView
	jo.RunMethod("setTextColor", Array As Object(Color))
End Sub

'Sets the Alpha value of a view. This is only available in API 11 and above.
'
' TargetView - The target.
' Alpha - The alpha value 0..1
Public Sub SetXmlViewAlpha(TargetView As View, Alpha As Int)
	Dim jo As JavaObject
	
	jo = TargetView
	jo.RunMethod("setAlpha", Array As Object(Alpha))
End Sub

'Sets the Visibility of the view
'
' TargetView - The target
' Visibility - One of VIS_GONE, VIS_VISIBLE or VIS_INVISIBLE constants
Public Sub SetXmlViewVisible(TargetView As View, Visibility As Int)
	Dim jo As JavaObject
	
	jo = TargetView
	jo.RunMethod("setVisibility", Array As Object(Visibility))
End Sub

'Sets the color of an view
'
' TargetView - The target
' Color - The color to set.
Public Sub SetXmlViewColor(TargetView As View, Color As Int)
	Dim jo As JavaObject
	
	jo = TargetView
	If Color = -1 Then
		jo.RunMethod("clearColorFilter", Null)
	Else
		jo.RunMethod("setColorFilter", Array As Object(Color))
	End If
End Sub

'Sets the Image for an ImageView.
'
' TargetView - The target
' Icon - A BitmapDrawable with the Image to set.
Public Sub SetXmlViewImage(TargetView As View, Icon As BitmapDrawable)
	Dim jo As JavaObject
	
	jo = TargetView
	jo.RunMethod("setImageDrawable", Array As Object(Icon))	
End Sub

'Get the id of a resource
Private Sub GetResourceId(ResType As String, Name As String) As Int
	Dim r As Reflector
	Return r.GetStaticField(Application.PackageName & ".R$" & ResType, Name)
End Sub
