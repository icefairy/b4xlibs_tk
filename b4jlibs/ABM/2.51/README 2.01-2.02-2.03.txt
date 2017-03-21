Hi all!

This is version 2.03 of ABMaterial! Finally, I hear you say. I know...

Same goes as before, keep this one to yourself.  I'll release it on the forum when it's ready for public release. Thank you!

VERY IMPORTANT: Read the included document ABMaterial Getting Started-Upgrade 2.00+.pdf!

There has been an exceptional co-operation with some forum members to get this update.  So, a big hand for Mindful, Harris and Billyrudi!
This will be a continuing quest, and we'll work intensively to get this better.

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/ABM2.03Release161123DON1256.zip or dropbox: https://www.dropbox.com/s/1397v8fipq8rkng/ABM2.03Release161123DON1256.zip?dl=1
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

NEW/FIXES
---------

[FIX] not used .BAS files causes Null pointer exception
-------------------------------------------------------
Added check if the bas file is actually used in the project.

[FIX] analysing code has some problems when the methods are defined without using brackets
------------------------------------------------------------------------------------------
The problem:

You may have a couple of methods written like this (no brackets):

Private Sub GetNewUniqueID As Long
End Sub

When you change them to (with brackets):

Private Sub GetNewUniqueID() As Long
End Sub

the compilation will continue.

[FIX] Collecting data from B4J sources ... ArrayIndexOutofBounds
----------------------------------------------------------------
This code will cause ABM's  .BAS analyzer to generate an out-of-bounds exception at startup.   The code is valid B4J syntax and is formatted with line continuation (_) for readability, aligning the device offsets and cell sizes for the different form factors.

	page.AddRowsM( 10, True, 4, 4, "" ).AddCellsOS(1, 0, 0, 0, 12, 6, 6, "")  _
								       .AddCellsOS(1, 0, 0, 0,  0, 6, 6, "")
	
The workaround is to write as a single line.

page.AddRowsM( 10, True, 4, 4, "" ).AddCellsOS(1, 0, 0, 0, 12, 6, 6, "").AddCellsOS(1, 0, 0, 0, 0, 6, 6, "")

I joined the lines (internal, not in your code) in 2.01 before analysing the bas files.

[FIX] Analysing the .bas files fails to find all needed libraries on first run
------------------------------------------------------------------------------
I looks like I did the Analysing at the wrong time in the WritePageToDisk() method so on first run, the html was written BEFORE the analysing had finished.  Could explain some reports like 'ABMDateTimePicker does not work in ABMTabs'

[NEW] Ability to span a button across a variety of cells
--------------------------------------------------------
Added a new property UseFullCellWith to the button so it is possible to span a button across the cells for a constant look and feel.

[NEW] ABMPivotTable control language
------------------------------------
New property:

pivot.ForcedLanguage = "es"

Build-on for the following languages: 

en, es, fr, nl, pt, ru, tr

for other languages you will need to create and translate pivot.yourlangcode.js and pivot.yourlangcode.min.js

[FIX] ABMInput doesn't display corectly wrong and success message
-----------------------------------------------------------------
The WrongMessage and SuccessMessage seems to have max width same as Placeholder width instead of Field width. See attachment.

[NEW] Page AddRow methods
-------------------------
Currently adding a row with cells is possible in various ways - which seem complex. In looking for an easy (and fast way) to add a row with cells, consider using like Page.AddRow(ncells) where ncells between 1 – 12. The cells width calculated as 100% divided by ncells.

Added a method with the minimum requirements.  However, I really doubt the usage of this as you have absolutely no control over anything.  It is well worth trying to understand how the grid works.  Even with the Abstract Designer I'm building you would benefit from understanding the system behind the grid.

page.AddRow(numberOfCells as Int, centerInPage as boolean, rowThemeName as string, cellThemeName as string) 

[FIX] Title text in the navigation bar is not fully “responsive” 
----------------------------------------------------------------
I have tried to mimic the google page as much as possible (still need to keep the Materialize CSS framework into account).  Title font size adepts to the three device sizes, Title is cut of if it does not fit, button margins are reduced on phone sizes to maximize the estate available.

[NEW] Updateable NavigationBar SideBarTopComponent
--------------------------------------------------
As the SideBarTopComponent can be about anything, you'll need to Cast the Component to the real Component you have added.  e.g. in the demo, in ABMShared we've added a ABMContainer.

So now in ConnectNavigationBar() you can use:

        Dim comp As ABMComponent = page.NavigationBar.SideBarTopComponent
	If comp <> Null Then
		If comp.Type = ABM.UITYPE_ABMCONTAINER Then
			Dim topItem As ABMContainer = ABM.CastABMComponent(comp)
			Dim subContainer As ABMContainer = topItem.Component(comp.ID & "SubItemCont")
			Dim lbl1 As ABMLabel = subContainer.Component(comp.ID & "lbl1")
			lbl1.Text = "I'm changed!"
			topItem.Refresh
		End If
	End If

This changes the lbl1 name to "I'm changed!"

[NEW] Updateable NavigationBar TopItems and TopItems with sidebar
-----------------------------------------------------------------
Added two methods:

page.NavigationBar.UpdateTopbarItem("LogOff", "mdi-action-delete" , "[" & counter & "]")
page.NavigationBar.UpdateTopbarItemEx("LogOff", "mdi-action-delete" , "[" & counter & "]", ABM.COLOR_GREEN, ABM.INTENSITY_NORMAL)

They will immidiately refresh, so a page.NavigationBar.Refresh() is not needed.   (such a refresh() rebuilds the whole NaviagionBar which looses the current navigation).

[NEW] ABCard Panel text can be truncated e.g. if it contains text without spaces
--------------------------------------------------------------------------------
ONLY if the card is initialized as a panel, I've added a parameter 'PanelTruncateText' which will truncate such text and adding '...' at the end to indicate there is more.

[NEW] Floating Containers/Page Fixed Headers
--------------------------------------------
EXPERIMENTAL:  I've created a method AddFloatingContainer() that you can use in the BuildPage() to define a container area.  You can see this as an empty box floating on top of the page.  You need to add 'visible' components to this container.  You can do this by adding a new container to the floating container.  In this new container you can add other ABMComponents.  This second container is needed, as it 'reactivates' the events who are disabled for the 'empty' container.

NOTE: Floating containers can ONLY be added on page level (not in modal sheets, tabs, etc)

Example:

In BuildPage() we add our 'empty' container:  You can set the distance from the top OR the bottom:

' create a floating container MUST be added in BuildPage!
Dim floatingcont1 As ABMContainer
floatingcont1.Initialize(page, "floatingcont1", "")
floatingcont1.AddRows(1,True, "").AddCellsOS(1,0,2,4,12,8,4,"")
floatingcont1.BuildGrid ' IMPORTANT
page.AddFloatingContainer(floatingcont1, ABM.FLOATING_FROMTOP, "65px")

In ConnectPage() we create another component with a button on it, which we add to the 'empty' floating container:

' get the floating container
Dim floatingcont1 As ABMContainer
floatingcont1 = page.FloatingContainer("floatingcont1")

' create menu container
Dim cont2 As ABMContainer
cont2.Initialize(page, "cont2", "Floatingmenu")
cont2.AddRows(1,True,"").AddCells12(1,"")
cont2.BuildGrid	

' add a button	to this second container
Dim btn4 As ABMButton
btn4.Initializefloating(page, "btn4", "mdi-image-palette", "darkred")
btn4.size = ABM.BUTTONSIZE_LARGE
cont2.Cell(1,1).AddComponent(btn4)
	
' add it to the floating container
floatingcont1.Cell(1,1).AddComponent(cont2)

See also for other examples: https://www.b4x.com/android/forum/threads/abmaterial-how-to-create-a-fixed-header.72830/

[FIX] Vertical scrollbar not visible anymore when you open a modal sheet
------------------------------------------------------------------------
If I set Page.Page.AlwaysShowVerticalScrollBar = True in BuildPage sub when I load the page for the first time the vertical scrollbar is visible, but if I open a modal sheet (dismissible modal sheet in my case) the scrollbar disappears and after i close the modalsheet it is still not shown.

[NEW] in the ABMList, when clicking the item, subitem can collapse.
-------------------------------------------------------------------
Implemented when an opened list item is clicked again, it closes.  So some sort of toggle (open/close), kind of the same as the sidebar of the navigationbar works.

[NEW] Added Header to ModalSheet
--------------------------------
The ModalSheet now also has a .Header container next to a .content and .footer.

[NEW] Enhanced text manipulation in ABMCards 
--------------------------------------------
I created a new component ABMCustomCard so you can create your own Cards.

See for more: https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmcustomcard-in-2-01.72653/

[FIX] Combo gotfocus and lostfocus events report "undefined"  ID
----------------------------------------------------------------
When clicking on or outside of a Combo control gotfocus and lostfocus events are reported but they don't identify the combo control associated with the event.

Combo did not support lost and got focus.  In 2.02 the events are added.

[FIX] Combo items overlap navigation bar
----------------------------------------
Combo item list is not dismissed when navigation bar gains focus.

[NEW] Updated the online feedback app
-------------------------------------
Two new states for a case:

5 - Confirmed = I confirmed this is a bug and it will be attended
6 - On hold = there is no immidiate solution possible, but it is not completely dismissed.

Removed the point system.  It was not used that much and slowed down the app.

Added some more color to easily see the case status.

[NEW] Show Connection Indicator
-------------------------------
New property on page level that shows a bullet (connected/not connected).  You can modifiy the colors using themes.

page.ShowConnectedIndicator = True

[NEW] Complete update of the Reconnect system
---------------------------------------------
THE BIG ONE THAT TOOK ALL OUR TIME.  To much to write here, see the document 'ABMaterial Getting Started/Upgrade 2.00+.pdf' included in the zip!


Happy programming!

Alain Bailleul
Alwaysbusy's Corner