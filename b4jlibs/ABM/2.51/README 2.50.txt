INTRO:
------
A lot of new stuff in this release! And I'm happy to say in this one no big changes you need to make like in the previous versions :-) 
If you're upgraded to 2.20 already, then there are only 2 or so changes (like an extra param in the Pivot initialization)

Note: from now on, there is a general section in this document for people who are switching from a lower version (2.03 or less). All others can just jump to the Install section.

GENERAL
-------
If you are upgrading from 2.03 or earlier versions of ABMaterial, take also the time to read the included README files for 2.00+.  (you can ignore the parts on connecting/reconnecting problems as they have been changed in 2.17 anyway)
please see the document(s). I saved it in a couple of formats, so you can copy/paste code:

		ABMaterial 2.17 Checklist.docx
		ABMaterial 2.17 Checklist.pdf
		ABMaterial 2.17 Checklist.htm

Version 2.20+ of ABMaterial introduces the ABMGridBuilder!

The ABMGridBuilder is a tool to make grids easy.  It is based on the excellent system introduced by Shoelace.io.  I adapted the system so it is usefull for ABMaterial and added some specific functionalities like adding rows and cells before others.
With the tool, you can generate the needed AddRow and AddCell B4J methods.  Using the Clipboard, you can then paste it at the relevant place in your code.
But even more! You can copy your AddRow and AddCell methods to the clipboard, and ABMGridBuilder can parse this code an 'rebuild' the visual representation. Cool, no?

A video demonstration can be found here: https://www.youtube.com/watch?v=rQvbq9BVoTI

You can find the ABMGridBuilder in the zip file.  I've created two .bat files to start them: one for a 'light' themed version and one for a 'dark' themed version:

Start.bat
StartDark.bat

The code in the bat file contains a very important parameter: -Dprism.order=sw
This parameter is needed because I use a very big canvas, and without it, it will not work.

----------------------------------------------
java -jar -Dprism.order=sw ABMGridBuilder.jar
----------------------------------------------

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download:  http://gorgeousapps.com/ABM250R170205pab1127.zip or on DropBox: https://www.dropbox.com/s/6fkao2fylbw6fuj/ABM250R170205pab1127.zip?dl=1 
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

Some other fixes in this version:

NEW/FIXES
---------
[NEW] ABMTabs can use formatting in the title
---------------------------------------------
You can use the {B}, {I} etc tags in the title of the tabs.

e.g. tabs.AddTab("persons", "{B}Person{/B}", BuildSideBarContainer("persons"),4,4,4,12,12,12,True,True, "mdi-action-face-unlock", "")

[NEW] ABMSideBar can be initialized as a simple panel (ABMContainer)
--------------------------------------------------------------------
Can be handy if you want to use it as some kind of 'Toolbox' panel

Instead of adding items, you use the sb.Content (which is an ABMcontainer) to add content:

    Dim sb As ABMSideBar
	sb.InitializeAsPanel(page, "sb", 400,58,Null, "", "sbcontent", "")
	
	Dim tabs As ABMTabs
	tabs.Initialize2(page, "tabs",58, "")
	tabs.AddTab("persons", "{NBSP}Person", BuildSideBarContainer("persons"),4,4,4,12,12,12,True,True, "mdi-action-face-unlock", "")
	tabs.AddTab("projects", "Project", BuildSideBarContainer("projects"),4,4,4,12,12,12,True,True, "mdi-action-room", "")
	tabs.AddTab("activities", "Activity", BuildSideBarContainer("activities"),4,4,4,12,12,12,True,True, "mdi-content-content-cut", "")
	
	sb.Content.AddRowsM(1,False, 0,0,"").AddCells12(1,"")
	sb.Content.BuildGrid
	
	sb.Content.Cell(1,1).AddComponent(tabs)

[NEW] ABMTabs can be initialized with a fixed height
----------------------------------------------------
	Dim tabs As ABMTabs
	tabs.Initialize2(page, "tabs",58,7, "") ' <-----
	tabs.AddTab("persons", "{NBSP}Person", BuildSideBarContainer("persons"),4,4,4,12,12,12,True,True, "mdi-action-face-unlock", "")
	tabs.AddTab("projects", "Project", BuildSideBarContainer("projects"),4,4,4,12,12,12,True,True, "mdi-action-room", "")
	tabs.AddTab("activities", "Activity", BuildSideBarContainer("activities"),4,4,4,12,12,12,True,True, "mdi-content-content-cut", "")

[NEW] Undo in ABMGridBuilder
----------------------------
Support for [Ctrl] [Z] or similar "undo" option.  Allows for easier experimentation between saves.

[FIX] Combo list not dismissed when user TAB's to next field
------------------------------------------------------------
Pressing TAB while combo picklist is displayed does not dismiss the picklist.  

[FIX] HTML quote shown with combo.SetActiveItemId()
---------------------------------------------------
There appears to be a bug in the ABMCombo.SetActiveItemId() method when items contain quotes. For the most part quotes are displayed correctly by the control. It's only when you specify an item with SetActiveItemId() that the HTML quote shows.

[FIX] ABMCharts not updated if more then 1 chart defined
--------------------------------------------------------
Got the little $*#@.  Some stupid quote error caused it to always take the last one.

[NEW] Open/Close the sidebars with code
---------------------------------------
Using the following methods, you can open and close the sidebars by code.  This is analog to the Modal methods.

page.ShowSideBar("sb")
page.CloseSideBar("sb")

[FIX] Components in Sidebar take to much space
----------------------------------------------
In the sidebar, some components like the ABMTabs could take up to much space.  I reduced this.

[NEW] Optimized ABMTabs refresh
-------------------------------
ABMTabs did a number of flushes that were not needed which could slow down an app.  I optimized the flushes.

[NEW] ABMLabel can have a Clicked event
---------------------------------------
This can come in handy if you just want the user to be able on a label.

Usage:

    Dim lblPerson As ABMLabel
	lblPerson.Initialize(page, "lblPerson", "{NBSP}", ABM.SIZE_PARAGRAPH, True, "")
	lblPerson.SetCursor(ABM.CURSOR_POINTING)
	lblPerson.Clickable = True
	CardCont.Cell(2,2).AddComponent(lblPerson)

Event:

    Sub lblPerson_Clicked(Target As String)
	    ' do your stuff
    End Sub

[NEW] New component ABMChat
---------------------------
ABMChat is a new cool looking ABMaterial component to create a Web based chat program. The inner workings are very much like Erels ChatRoom, but with a slick interface. This can be a useful control if for example you want to give chat-like support within you own app.

for more info and a demo, see: https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmchat-2-50.75039/#post-476346

[NEW] Cell new height method SetFixedHeightFromBottom()
-------------------------------------------------------
This method can be useful as a replacement for SetFixedHeight() so the cell takes up space until bottom of the window.
IMPORTANT: this is useful for pages that are ONE window height.  Bigger pages can give weird results when scrolled!

You have to play with the number to avoid the appearing of a scrollbar.

Usage:

page.Cell(2,1).SetFixedHeightFromBottom(20)

[NEW] Two parameters to set the threshold for small/medium/large
----------------------------------------------------------------
EXPERIMENTAL

As technology keeps creating bigger resolutions, I added two parameters you can set on ABMaterial to set the threshold where a small screen is considered, a medium screen or larger screens.  Note that changing this has a major impact on the Materialize CSS framework ABMaterial is based on.  But as I have already fixed so many bugs and added so many new features in our Materialize CSS, it doesn't matter that much anyway. I did this for e.g. iPads that have a 1024x768 screen.  Default Materialize CSS will show the 'desktop' version on it in landscape mode, and I prefer it to still use the tablet layout.

ABM.ThresholdPxConsiderdSmall = 600
ABM.ThresholdPxConsiderdMedium = 1024

By default, they are the Materialize CSS ones (and if you do not touch them, ABMaterial will use everything as before):

ABM.ThresholdPxConsiderdSmall = 600
ABM.ThresholdPxConsiderdMedium = 992

[NEW] Add support for clicking hyperlinks in Toast messages
-----------------------------------------------------------
I've made it so you can use all {} tags implemented for a label (so you can also add links with the {AL}{AT}{/AL} tags)

[NEW] Certify application to specific ABM version with symbol
-------------------------------------------------------------
ABM is a continuously improving framework where API’s and behaviors are subject change - sometimes in subtle ways which may not be compatible with previous builds. 

It would be valuable to have a compile-time symbol to lock an ABM application to a specific version of the ABM library.   This could be achieved by adding a unique “version” symbol  to each release of the ABM library.     The developer could then reference that symbol indicating that this codebase has been certified with this edition of ABM.

For example: 

Dim  CertifiedVersion as String = ABM.Version220

If the developer attempts to compile an ABM v2.20 certified webapp with ABM v2.50  then the compiler would generate an “Unknown member” error.

The same could be achieved today by checking the version number at runtime, but if implemented as a symbol this could be caught as soon as the project is opened in the IDE.

So for this version, the symbol is: Version250

[NEW] Ability to bold and or italic ABMInput i.e. ABMInput Formatting
---------------------------------------------------------------------
Added three new properties to the InputTheme:

Bold
Italic
Underlined

[FIX] ExtractLine class memory consumption
------------------------------------------
This is not necessarily a bug but more of an observation. 

While profiling the ABM Demo with VisualVM I noticed that there are a number of ExtractLine objects (20,000) created and remain constant while the app is running.   This only happens when launching the app from the IDE so I assume these fellas are linked to the Analyzer process.  If you launch the .JAR outside of the project folder as you would in production there are no ExtractLine objects created.  In the former scenario, I'm guessing these objects could be freed but currently causing no ill effects.

[NEW] ABMPivotTable export to Excel
-----------------------------------
Notes:
1. on OSX or iOS, this may not work due to limitations Apple has set!
2. Can not be used with the new google charts

You can use two methods to export to Excel:

ExportToXLS(): This creates a .xls file and tries to take the formatting (Except for the Table with Barcharts, as this cannot be presented in Excel).  As this is kind of a html file, Excel will give a warning when opened.  I urge you to use this only for printing purposes, not to work with in Excel.
ExportToXLSX(): This creates a native Ecel file, but without formatting.  Useful if the user wants to manipulate it in Excel.

More info: https://www.b4x.com/android/forum/threads/abmaterial-abmpivottable-new-functionalities-2-50.75625/

[NEW] ABMPivotTable preset the table type and the aggregation method
--------------------------------------------------------------------
You can preset the table type and aggregation method (and its values).  Together with the readOnly property, you can so create some kind of 'report' very quickly.  If you then do an ExportToXLS(), you can use use Excels print functionality.

Usage (multiple aggregation values have to be seperated by a comma.

pivot.SetPreselection(ABM.PIVOT_TABLETYPE_ROWHEATMAP, ABM.PIVOT_AGGRTYPE_SUM, "Prijs")

[NEW] ABMPivotTable new Initialization method to use all available space
------------------------------------------------------------------------
This initialization method works ONLY if you use page.Cell(x,y).SetFixedHeightFromBottom() or page.Cell(x,y).SetFixedHeight()!

It expands the pivot table (height) to the above specified height.  Usefull if your page in one screen heigh.

Usage:

pivot.InitializeAutoHeight(page, "pivot", "../pivots/OneTwo_Export2020.csv", "Jaar", "Project naam", "Prijs,Aantal,Persoon code,Project code,Activiteit code", False, "pivot")	

[NEW] ABMPivotTable can have collapsable/expandable rows and columns
--------------------------------------------------------------------
By setting the property pivot.UsesSubTotals = True, the rows and column header are collapsable/expandable

[NEW] ABMPivotTable new presentations
-------------------------------------
Some google charts are now also build in:

Line Chart
Bar Chart
Stacked Bar Chart
Area Chart
Scatter Chart

These can be added by setting one property:

pivot.UsesGoogleCharts = True

[NEW] ABMPivotTable set read only
---------------------------------
The initialize method got one new parameter, so the component is read only:

e.g (True at the end).

pivot.Initialize(page, "pivot", 800, "../pivots/OneTwo_Export2020.csv", "Jaar", "Project naam", "Prijs,Aantal,Persoon code,Project code,Activiteit code", True, "pivot")

[NEW] ABMButton can also use the formatting tags
------------------------------------------------
You can also use the formatting tags {B}, {I}, etc on a button (flat and raised)

[NEW] new loading/pause animations
----------------------------------
for some examples, see: https://www.b4x.com/android/forum/threads/abmaterial-6-new-loading-pause-animations-2-50.75656/

[NEW] Pause a page delayed
--------------------------
A method to pause your app if there was no page.Resume within the specified milliSeconds.  Useful for example if on your desktop it goes fast and the pause/resume cycle is very short (the user can see the 'pause animation' for a flash, which is annoying.  E.g. on your phone it takes several seconds to do the same task, the 'pause animation' is useful.

Usage:

page.PauseDelayed(2000)

[NEW] New property IsTextSelectable
-----------------------------------
Default = false, this is how ABMaterial worked before this property.

When setting  IsTextSelectable=false, the user will not be able to select the text by dragging over it.  This can make you Webapp look more slick :-)
Is build in for a couple of components now + ABMTable, ABMTableMutable, ABMContainer, ABMModalSheet and the navigation bar.

We'll see if other components will need this too.

[NEW] ABMPivot let user download the raw CSV or JSON data file
--------------------------------------------------------------
Additional to ExportToXLS and ExportToXLSX, which retrieves the pivot generated data, you can use ExportRaw method that returns the unaltered data.

usage:

pivot.ExportRaw(TargetFileNameWithoutExtension)

[NEW] New component ABMPercentSlider
------------------------------------
ABMPercentSlider is an alternative 'radiogroup' component that can show the selection in a sliding 'time bar'.  Each selection can be between 5% and 100%, in 5% intervals.

For more info see: https://www.b4x.com/android/forum/threads/abmaterial-new-abmplanner-and-abmpercentslider-2-50.75779/

[NEW] New Component ABMPlanner
------------------------------
ABMPlanner is a scheduling component that shows a week overview and allows copying/moving/deling/adding of 'tasks'.
It is a new component written from the ground up and was build for a specific client.  It may or may not work in a modalsheet for example.

See for more info: https://www.b4x.com/android/forum/threads/abmaterial-new-abmplanner-and-abmpercentslider-2-50.75779/

[FIX] Fix google analytics
--------------------------
Updated the analytics library link to https instead of http, as Google instructed.

Happy programming!
	
Alain Bailleul
Alwaysbusy's Corner











