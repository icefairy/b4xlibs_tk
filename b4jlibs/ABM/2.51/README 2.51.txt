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
1. Download:  http://gorgeousapps.com/ABMaterial2.51.zip
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

Some other fixes in this version:

NEW/FIXES
---------
[NEW] a Top Modal to complement the Bottom Modal
------------------------------------------------
The initialize method has been changed so it accepts a modalsheet type constant instead of the boolean IsBottomSheet.

modalsheetType: use the ABM.MODALSHEET_TYPE_ constants

for backward compatability you can still use true and false: 
	 true = .MODALSHEET_TYPE_BOTTOM
	 false = .MODALSHEET_TYPE_NORMAL 

Usage:

Dim myTopModal As ABMModalSheet
myTopModal.Initialize(page, "topsheet", False, ABM.MODALSHEET_TYPE_TOP, "")

[FIX] Modalsheet with an ABMeditor do not work if build in BuildPage
--------------------------------------------------------------------
You had to move it to connectpage.  Fixed.

[FIX] ABMSidebar overlay keeps getting darker if you press the topnav button multiple times faster than usual
-------------------------------------------------------------------------------------------------------------
the overlay getting blacker and blacker should be fixed.

[FIX] page.ShowSideBar and page.CloseSideBar don't work as they should
----------------------------------------------------------------------
The new behaviours;

ShowSideBar: Opens the sidebar if it was closed, leaves it open if it is the SAME sidebar, else closes the old one and opens the new one.
CloseSideBar: closes the sidebar
ToggleSideBar: this shows the sidebar if closed, closes the sidebar if open and if it is another one than the one it just closed, it opens the new one.

So in your case, using ToggleSideBar like this in Page_NavigationbarClicked() should do the trick:

    If Action = "LogOff" Then
		ABMShared.LogOff(page)
		Return
	Else If Action = "chat" Or Action = "notifications" Then
		page.ToggleSideBar(Action & "sidebar")		
		Return
	End If

[FIX] ABMTabs in extra Sidebar do not vertically center the tab title
---------------------------------------------------------------------
ABMTabs initialize2 does not use the MarginTopPx to set the text position if no icon is used

Now this should work.  Initialize2 has now an extra parameter for the icon top and the value of MarginTopPx has to be the negative version of what you used in the old Initialize2.

So what is changed (new does the same as old in this example)

old: tabs.Initialize2(page, "tabs",58, 7 , "")
new: tabs.Initialize2(page, "tabs",58, -7, 7, "")

[NEW] ABMPlanner, switched position minute button menu
------------------------------------------------------
To make it easier to see the buttons on a touch device, I've switched the menu buttons (cut/copy/paste/delete) to scroll out to the top of the tab instead of under the tap.

[NEW] Add ABMSideBar to the page without adding it with AddTopItemWithSideBar
-----------------------------------------------------------------------------
This can be usefull for me and maybe other if we could created some extra sidebars and call Open and Close when we need just like a modalsheet. Something like (in my case) instead of opening a modal form to edit user details I can click on a user account and open an extra sidebar so we can view/edit it's details - and this is only one scenario that comes to mind.

I also added a shortcut on the page GetSidebar(topItemReturnName as String) as ABMSideBar

[NEW] AddTopItemWithSideBar generate click event in Page_NavigationbarClicked
-----------------------------------------------------------------------------
Q: I'm implementing a chat system which is placed in an ABMSidebar. I need this so I can know if the users opened the sidebar (which means he saw the new messages), because I modify the color of the nav bar top item icon when the users has new messages.

A: I've added a property 'IsOpen' to the sidebar that actually checks in the html if it is open.  This is because you can also open/close it with code and then it would be out of sync.

]NEW] Extra scroll parameter in cell SetFixedHeight and SetFixedHeightFromBottom
--------------------------------------------------------------------------------
EXPERIMENTAL:

I added an extra parameter to these methods which, if set to true, should scroll it contents (vertical) if it becomes bigger.

Setting it to false acts like the version before this parameter.

]NEW] Top icon buttons in the NavigationBar can have a 'badge'
--------------------------------------------------------
Top items WITH an icon in the NavigationBar can show a little 'ios' badge with e.g. a number of unread messages.
Note: you can only start using them AFTER page.FinishedLoading!

Usage (where 'Emails' is the return name of the top button):

Adding/Setting the badge:

page.NavigationBar.SetTopBarBadgeOnIcon("Emails", "5",ABM.ICONBADGE_POSITION_TOPRIGHT, ABM.COLOR_RED, ABM.INTENSITY_NORMAL, ABM.COLOR_WHITE, ABM.INTENSITY_NORMAL, ABM.COLOR_WHITE, ABM.INTENSITY_NORMAL)	

You can rerun the .SetTopBarBadgeOnIcon() method, e.g. if the number has changed.  I did it like this, so you can also change its color depending on the value.

Removing the Badge:

page.NavigationBar.HideTopBarBadgeOnIcon("Emails")

[NEW] ABMDropDownButton
-----------------------
I created a basic dropdown menu under a button (Theme is set on the Buttons Theme).

Usage:

Dim btnDropdown As ABMButton
btnDropdown.InitializeFlat(page, "btnDropdown", "","","Dropdown", "")
btnDropdown.AddMenuItem("One", "One")
btnDropdown.AddMenuItem("Two", "Two")
btnDropdown.AddMenuDivider
btnDropdown.AddMenuItem("Three", "Three")
page.Cell(4,1).AddComponent(btnDropdown)	

Event:

Sub btnDropdown_MenuClicked(Target As String, returnName As String)
	Log(returnName)
End Sub

[NEW] ABMChat not to have fixed height
--------------------------------------
I added a second Initialize2 method, where you can ommit the heightPx property.
NOTE: You can only use this method if the cell has a fixed height or a fixed height from bottom! 

Usage example:

In BuildPage, after Page.BuildGrid()

page.Cell(1,1).SetFixedHeightFromBottom(150, False)

In connectPage()

Dim chat As ABMChat
chat.Initialize2(page, "conversation", 450, 255, "mychat")
chat.AddBubble("Server", "I'm Server, what is your name?", "The Server", "server", "server")
page.Cell(1,1).AddComponent(chat)

[NEW] New text Tag for colors
-----------------------------
You can now use the tags {C:#FFFFFF} {/C} to change the color of a word in text in ABMLabel, ABMButton, etc  (all those who now support {B} tags.

Usage:

Dim lbl As ABMLabel
lbl.Initialize(page, "lbl", "Hello {B}{C:#FF0000}Alain{/C}{/B}, how are you?", ABM.SIZE_H2, True, "")
page.Cell(1,1).AddComponent(lbl)

Note: ABM has a helper method to convert ABMColors to a hex value:

Log(ABM.ABMColorToHex(ABM.COLOR_BLUE, ABM.INTENSITY_ACCENT3))

result: #2979ff

[NEW] Msgbox, Msgbox2 and InputBox
----------------------------------
Sometimes you just need to show a quick msgbox or a single field inputbox to the user. In ABMaterial you can build some quick modal sheets to do this. But in 2.51 I've integrated the possibility for such cases just to do it in one line of code (like a normal msgbox/inputbox).

See for some examples: https://www.b4x.com/android/forum/threads/abmaterial-msgbox-and-inputbox-2-51.76105/#post-482908

Happy programming!
	
Alain Bailleul
Alwaysbusy's Corner











