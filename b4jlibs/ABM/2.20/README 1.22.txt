Hi all!

The new version 1.20 of ABMaterial! 

Same goes as before, keep this one to yourself.  I'll release it on the forum when it's ready for public release. Thank you!

As to many people has problems with the splitted DemoAssets, I've gone back to the original way it was done.  Guess bandwidth is quite big everywhere.

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/20160713vqr1646.zip
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your won projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).
Also if you use AppVersion in ABMshared, increase it with a number.

NEW/CHANGES
-----------
[NEW] Finished ABMSVGSurface and ABMSVGElement
----------------------------------------------
Could be useful instead of the ABMCanvas to create inline SVG.

Note: although the attribute strings look very much like CSS, they are not. Check out https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute for more info.

Check the demo app for some examples.

[FIX] ABMPivot points to wrong js and css files
-----------------------------------------------
ABMPivot points to pivot.js and pivot.css and should point to pivot.min.js and pivot.min.css

[FIX] ABMCombo single quote in inputText failed
-----------------------------------------------
When you used a single quote like in:

 C.AddItem("1", "Danno's",bldItem("1-L","Danno's"))

The script to select failed

[NEW] New component ABMFileInput
--------------------------------
ABMFileInput is an alternative control to let the user select a file and upload it.  It is made up by an ABMInput control and a ABMButton control.  It does not upload automatically on selecting the file and has no progress feedback.

Usage:

Dim inp1 As ABMFileInput
inp1.Initialize(page, "inp1", "Select a file", "Open", True, "", "")	
page.CellR(0,1).AddComponent(inp1)

Sub inp1_Changed(value As String)
	Log("value : " & value)
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.UploadToServer 'Here the file is uploading
End Sub

Sub Page_FileUploaded(FileName As String, success As Boolean)	
	Dim inp1 As ABMFileInput  = page.Component("inp1")
	inp1.Clear
	Log(FileName & " = " & success)
End Sub

[NEW] Table: cell input numeric mask 
------------------------------------
Just like the ABMinput has an inputMask, you can add an inputMask to a ediatable table cell with the theme properties.  Extra is also an option to disable the ENTER key (e.g. if the user needs to enter a numeric value, he should not be allowed to have an enter in it).

See for mask options: https://github.com/RobinHerbots/jquery.inputmask 

Usage: (example mask is for an integer)

theme.Table("tbl1theme").AddCellTheme("nocoloredit")
theme.Table("tbl1theme").Cell("nocoloredit").IsEditable = True
theme.Table("tbl1theme").Cell("nocoloredit").InputMask = "'alias':'decimal', 'digits': 0"
theme.Table("tbl1theme").Cell("nocoloredit").AllowEnterKey = False

For i = 0 To 9
	Dim r As List
	Dim rCellThemes As List
	r.Initialize
	rCellThemes.Initialize
	r.Add("100")
	rCellThemes.Add("nocoloredit")
	...
	tbl1.AddRow("uid" & i, r)
	tbl1.SetRowThemes(rCellThemes) ' make sure you have as many items in rCellThemes as in r!
Next

Sub tbl1_Changed(Params As Map)
	Dim row As String = Params.Get("row")
        Dim Value As String = Params.Get("value")
    
        Dim tbl As ABMTable = page.Component("tbl1")
   
        Dim cCantidad As String = "$" & (Value * 100)
        tbl.SetString(row, 2, cCantidad)        
        tbl.RefreshCell(row, 2)
End Sub

[NEW] ABMCheckbox, ABMswitch and ABMRadioButton events in table
---------------------------------------------------------------
There are very few components that can use their events in a table

[NEW] RefreshCell and RefreshRow
--------------------------------
Added RefreshCell(row, column) to only refresh one cell, not the whole table:

Usage:

value = value + 10
tbl.SetString(tblCellInfo.row, 2,"$" & value)
tbl.RefreshCell(tblCellInfo.Row, 2)

Also added RefreshRow(row) to only refresh a complete row

[FIX] ABMGenerator: 
-------------------
There was a bug in the generated code:

Dim ABMGenwaistorageBadInputMessage As ABMLabel = ABMGenwaistorageBadInput.Component("ABMGenwaistorageBadInputMessage")

should be:

Dim ABMGenwaistorageBadInputMessage As ABMLabel = ABMGenwaistorageBadInput.content.Component("ABMGenwaistorageBadInputMessage")

[NEW] StrikeThrough for ABMLabel and Table text cell
----------------------------------------------------
In the theme for an ABMLabel and Table Cell you can use StrikeTrough.

Usage:

tmpTheme.Table("tbltheme").AddCellTheme("deleted")
tmpTheme.Table("tbltheme").Cell("deleted").UseStrikethrough = True
tmpTheme.Table("tbltheme").Cell("deleted").StrikethroughColor = ABM.COLOR_RED

See attachement for result

Same properties for the ABMLabel theme.

[NEW] Firebase Auth support
---------------------------
Just like Erel has added the Firebase Auth Service to B4A (https://www.b4x.com/android/forum/threads/firebaseauth-authenticate-your-users.67875/) you can also use it to login with your ABMaterial (1.20) WebApp.

See for more info: https://www.b4x.com/android/forum/threads/abmaterial-firebase-auth-for-users-in-1-20.67957/#post-430514

[NEW] Firebase Storage Support
------------------------------
The next service you can use in WebApps using ABMaterial 1.20: Storage. With storage you can upload/download files with ease. Here is an example using it together with the new ABMFileInput component.

See for more info: https://www.b4x.com/android/forum/threads/abmaterial-firebase-storage-in-1-20.67978/

[NEW] New component ABMTableMutable
-----------------------------------
[WORK IN PRGRESS] ABMTableMutable is an alternative for the ABMTable (it is 90% compatible).  As requested a couple of times, it can do stuff like InsertRowBefore() and RemoveRow().  

As explained in anotehr post, this means all methods have to be changed to use UniqueId as string everywhere instead of row as integer.

e.g. in:

UseCellTheme(UniqueId as String, Column as Integer, ThemeName as String)
GetCellTheme(UniqueId as String, Column as Integer) as String
SetCellTag(UniqueId as String, Column as Integer, Tag as Object)
GetCellTag(UniqueId as String, Column as Integer) as Object
GetComponent(UniqueId as String, String componentId) as ABMComponent
SetString(UniqueId as String, Column as Integer, Value as String)
GetString(UniqueId as String, Column as Integer) as String

ABMTableCell as used in event Table_Clicked(PassedRowsAndColumns As List) has a also a row 'Uniqueid'

Note: ABMTableMutable can NOT be scrollable!  It is not possible to have both.

Usage:

      ' create the TableItemProduced1 table
	Dim TableItemProduced1 As ABMTableMutable
	
	TableItemProduced1.Initialize(page, "TableItemProduced1", False, False, True, "tbltheme") 'GENTODOC
	'TableItemProduced1.IsResponsive = True

	TableItemProduced1.SetHeaders(         Array As String ("regID",page.XTR("0002","Date"),page.XTR("0003","Person"),page.XTR("0004","Client")       ,page.XTR("0005","Article")  ,page.XTR("0006","Number")   ,page.XTR("0007","Edit")     ,page.XTR("0008","Delete"))) 'GENTODOC
	TableItemProduced1.SetHeaderThemes(    Array As String (""     ,""    ,""      ,""             ,""         ,""         ,"hc"       ,"hc"    ))
	TableItemProduced1.SetHeaderHeights(   Array As Int    (0      ,0     ,0       ,0              ,0          ,0          ,0          ,0       ))
	TableItemProduced1.SetColumnWidths(    Array As Int    (0      ,0     ,0       ,0              ,0          ,0          ,70         ,70      ))
	TableItemProduced1.SetColumnVisible(   Array As Boolean(False  ,True  ,True    ,True           ,True       ,True       ,True       ,True    )) 'GENTODOC
	TableItemProduced1.SetColumnSortable(  Array As Boolean(False  ,False ,False   ,False          ,False      ,False      ,False      ,False   )) 'GENTODOC
	TableItemProduced1.SetColumnDataFields(Array As String (""     ,""    ,""      ,""             ,""         ,""         ,""         ,""      )) 'GENTODOC
	TableItemProduced1.SetFooter(page.XTR("0009","Number added: 0"), 12,"")
	TableItemProduced1.Visibility = ABM.VISIBILITY_HIDE_ALL
	
	page.CellR(2,1).AddComponent(TableItemProduced1)
	
[NEW] ABMContainer can collapse
-------------------------------
ABMContainer can be initialized as a collapsable component.  As a collapsable has a header and a body and clicking on the header will collapse/expand the body.  This can be used as an alternative for an ABMCard so you can build your own.

Usage:

Sub BuildCard(res As Map) As ABMContainer
	Dim tmpCard As ABMContainer
	tmpCard.Tag = res.Get("regid")
	tmpCard.InitializeCollapsable(page, "Card" & res.Get("regid"), "zdepthgrey", "", "white", False )
	
       ' initialize header
	tmpCard.CollapsableHeading.AddRowsM(1, False, 0,0,"").AddCellsOSMP(1,0,0,0,12,4,4,0,0,20,20,"").AddCellsOSMP(1,0,0,0,12,8,8,0,0,20,20,"")
	tmpCard.CollapsableHeading.BuildGrid
	
       ' initialize body
	tmpCard.CollapsableBody.AddRowsM(1, False,0 ,0,"").AddCellsOSMP(1,0,0,0,10,11,11,0,0,20,20,"").AddCellsOSMP(1,0,0,0,2,1,1,20,0,0,20,"")
	'tmpCard.CollapsableBody.AddRowsM(1, True ,20,10, "").AddCellsOS(1,6,6,6,3,3,3,"cellright").AddCellsOS(1,0,0,0,3,3,3,"cellright")
	tmpCard.CollapsableBody.BuildGrid
		
	DateTime.DateFormat = "yyyy-MM-dd"
	DateTime.TimeFormat = "HH:mm:ss"	
	Dim tmpStr As String = res.Get("regtimestamp")
	Dim tmpDate As Long = DateTime.DateTimeParse(tmpStr.SubString2(0,10),tmpStr.SubString2(11,19))		
	DateTime.DateFormat = "dd/MM/yyyy"
	DateTime.TimeFormat = "HH:mm"		
	Dim tmpCardDate As ABMLabel
	tmpCardDate.Initialize(page, "CardDate" & res.Get("regid"), DateTime.Date(tmpDate) & " " & DateTime.Time(tmpDate), ABM.SIZE_H6, True, "")
	'tmpCardDate.IsBlockQuote = True
	tmpCard.CollapsableHeading.Cell(1,1).AddComponent(tmpCardDate)
		
	Dim tmpCardType As ABMLabel
	tmpCardType.Initialize(page, "CardType" & res.Get("regid"), res.Get("itcode"), ABM.SIZE_H6, True, "")
	tmpCardType.IconName = "fa fa-expand"
	tmpCardType.IconSize = ABM.ICONSIZE_SMALL
	tmpCardType.IconAlign = ABM.ICONALIGN_RIGHT
	'tmpCardType.IsBlockQuote = True
	tmpCard.CollapsableHeading.Cell(1,2).AddComponent(tmpCardType)
		
	Dim tmpCardEditor As ABMEditor
	tmpCardEditor.Initialize(page, "CardEditor" & res.Get("regid"), False, False, "")
	tmpCard.CollapsableBody.Cell(1,1).AddComponent(tmpCardEditor)
	
	Dim tmpCardEdit As ABMButton
	tmpCardEdit.InitializeFloating(page, res.Get("regid"), "mdi-action-visibility", "")
	tmpCard.CollapsableBody.Cell(1,2).AddArrayComponent(tmpCardEdit, "tmpCardEdit")
	
	Return tmpCard
End Sub

[NEW] Support for Font-Awesome icons
------------------------------------
If you set: 

page.UseFontAwesome = true 

then you can, next to the material icons, also use the Font Awesome Icon library (634 icons in used version Font Awesome 4.6.3)
See fontawesome.io for a list of icons.

Usage:
 
tmpLabel.IconName = "fa fa-expand"

Note: you can also use .IconAlign in an ABMLabel to align the icon. (left/right)

[FIX] ABMEditor not working in Edge and IE
------------------------------------------
ABMEditor sometimes has problems keeping the focus so you are unable to type text

[NEW] A couple of new Theme settings for the navigation bar
-----------------------------------------------------------
String TopBarFontSize=""
String TopBarIconSize="1.6rem"
String SideBarFontSize=""
String SideBarIconSize="1.6rem"
String SideBarSubFontSize=""
String SideBarSubIconSize="1.6rem"

[NEW] Possibility to set cursors for components that do not have one set hardcoded
----------------------------------------------------------------------------------
Has no effect when set in BuildPage()!

Usage:

dim cont as ABMContainer
...
page.cell(1,1).AddComponet(cont)
page.cell(1,1).refresh
' must happen after the refresh!
cont.SetCursor(ABM.CURSOR_CELL)

[NEW] New method RefreshOnlyNew() on cell
-----------------------------------------
cell.RefreshOnlyNew() is a slimmed down version of Refresh().  It can be used if you add components to a cell and do not want to refresh all existing components.  e.g. in an infinite scrolling page, you are adding new ABMCards on the fly.  There is no reason you would need to refresh the preceding cards when you add a new one.  Using this method smart, you can gain a lot of speed.

Usage:

page.Cell(2,1).RefreshOnlyNew

[NEW] A couple of useful methods...
-----------------------------------
NOTE: These methods are moved to ABMaterial.Util to keep ABMaterial itself clean!

a. Util.GetDatePrettyPrint(testDate as long, locale as string, calcPrecise as boolean) as String

Returns a 'human' readable representation of a date compared with Now. e.g.

2 months from now
3 hours ago
a moment ago

It supports a number of languages.

Usage: dim s as String = ABM.Util.GetDatePrettyPrint(tmpDate, "en", False)

b. Util.GetImageDimensions(dir as String, fileName as String) as String

As ABMaterial runs in a Non-UI, it is sometimes hard to find the image dimensions.  This returns a string WidthxHeight.  You can then parse it.

Usage:

Dim SizeStr As String = ABM.Util.GetImageDimensions(File.DirApp & "/www/" & ABMShared.AppName & "/portfolio/","file.jpg")
Dim width As Int = 1024
Dim height As Int = 768
If SizeStr <> "" Then
	Dim spl() As String = Regex.Split("x", SizeStr)
	width = spl(0)
	height = spl(1)
End If

c. Util.GetYoutubeIDFromUrl(youtubeUrl as String) as String

Extracts the video ID of a youtube url.  Is useful is a user has to pick a video and you need to convert it to another kind of youtube url (e.g. from watch -> Embed for ABMVideo)

Usage: (returns HC2VriINKLU)

Log(ABM.Util.GetYoutubeIDFromUrl("https://www.youtube.com/embed/HC2VriINKLU"))
Log(ABM.Util.GetYoutubeIDFromUrl("https://www.youtube.com/watch?v=HC2VriINKLU"))

d. Util.GetTOTP(key as String, encryption as String, Time as long, validTimeSeconds as int, returnDigits as int) as String

Generates a Time-based One-time Password. Encryption must be a TOTP_ENCRYPT_ constant.

Usage: 

Log(ABM.Util.GetTOTP("AlainsSuperSecretKey", ABM.TOTP_ENCRYPT_SHA256, DateTime.Now,30, 8))

Will generate a 8 digit code using SHA256 encryption, valid for 30 seconds.

So if you run this method within 30 seconds for another DateTime.Now, it will give you the same 8 digit number.

THE FOLLOWING METHODS ARE USED IN OUR COMPANY AND ARE AS IS, BUT COULD BE USEFUL FOR OTHERS:

e. Util.GetBrowserTimeZone(ABMPage as Page) as String

Returns the timezone the users browser is in.

f. Util.GetDateConvertToUTC(dateISO as String, fromTimeZone as String) 

Converts an ISO date to the UTC time, given a certain Timezone.

DateISO is the ISO the date isn ISO format: "yyyy-MM-dd'T'HH:mm:ss"
fromTimeZone is a string like: 'Europe/Paris' or 'America/New_York"

g. Util.GetDateConvertTimeZone(dateISO as String, fromTimeZone as String, toTimeZone as String) as String

Converts a dateISO string from one timezone to another

h. Util.GetSecondsBetween(fromDateISO as String, fromTimeZone as String, toDateISO as String, toTimeZone as String) as long

Returns the number of seconds between two ISO dates, each given their own timezone.  Takes care of Daylight savingstime too

i. Util.DateISOAddPeriod(dateISO as String, timeZone as String, years as int, months as int, weeks as int, days as int, hours as int, minutes as int, seconds as int) as String

Adds/Subtracts a given number of units from an ISO date string and returns the new ISO Date string

[NEW] ABMEditor got a Loaded() event
------------------------------------
Sometimes (e.g. in Firefox) setting the content with SetHTML() failed in a dynamic created ABMEditor because it was not fully loaded.

Now an event is raised where you can fill in the content.

[NEW] ABMSocialShare extra button types
---------------------------------------
Add, next to flat, 3 other button types:

SOCIALSHARTHEMETYPE_CLASSIC
SOCIALSHARTHEMETYPE_MINIMA
SOCIALSHARTHEMETYPE_PLAIN

Usage: 

Because in a page, all button types have to be the same (loading one CSS), you must set the property on the page in BuildPage():

page.SocialShareTheme = ABM.SOCIALSHARTHEMETYPE_PLAIN

[FIX] Fix for label overlap if two inputs in one row
----------------------------------------------------
Two inputs in a row caused one label to overlap the other input field

[FIX] page.ShowModalSheetAbsolute() should use window top, not page top
-----------------------------------------------------------------------
If you scroll the page and open a modal sheet with ShowModalSheetAbsolute(), the modal sheet is positioned from the page top

[NEW] ABMDateTimePicker and ABMDateTimeScroller support ISO string dates
------------------------------------------------------------------------
Next to being able to use a long, the date time pickers now als support ISO strings as input/output.  Format "yyyy-MM-dd'T'HH:mm:ss"

[NEW] ABMDateTimePicker supports Week selection
-----------------------------------------------
You can now also select weeks. See https://www.b4x.com/android/forum/threads/abmaterial-datetimepicker-extented-for-weeks-1-20.68547/

[NEW] New component ABMPatternLock
----------------------------------
ABMPatternLock is yet another authentication method you can use based on the popular Pattern Lock you see in e.g. Android.

For more info see: https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmpatternlock-1-20.68866/

[NEW] Moved Utility Methods from ABMaterial to ABMaterial.Util
--------------------------------------------------------------
To keep ABMaterial clean, I've moved the following helping methods to ABMaterial.Util:

ConvertToDateTimeString(long, String)
ConvertFromDateTimeString(String, String)
BINGActivateTranslator(ABMPage, String, String, String)
BINGTranslate(String, String, String)
BINGTranslateMultipleTexts(List, String, String)
BINGCreateTranslationFiles(String, String, List)
GetDatePrettyPrint(long, String, boolean)
GetImageDimensions(String, String)
GetYoutubeIDFromUrl(String)
GetTOTP(String, String, long, int, int)
GetDateConvertTimeZone(String, String, String)
GetDateConvertToUTC(String, String)
GetSecondsBetween(String, String, String, String)
DateISOAddPeriod(String, String, int, int, int, int, int, int, int)
GetBrowserTimeZone(ABMPage)
GEOGetDistanceVincentyMeters(double, double, double, double)
GEOGetBoundingBox(double, double, double, double)
GEOToRadians(double)
GEOToDegrees(double)
GEOPrepareSQLWHEREClause(String, String, double, double, double, double)
GEOCheckLocationInRadius(double, double, double, double, double, double)
ReplaceAll(String, String, String)

e.g. the usage is now: 

Dim ABM as ABMaterial
Dim TZ as String = ABM.Util.GetBrowserTimeZone(page)

Happy programming!

Alain Bailleul
Alwaysbusy's Corner