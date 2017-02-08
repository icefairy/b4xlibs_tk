Hi all!

The new version 1.10-1.11-1.12 of ABMaterial! 

NOTE:
-----
The EnterPressed event has changed to make sure you change it in your existing apps! (see further)

DONATORS: There is an extra functionality for localization.  See further.

NOTE: Where did v1.09 go?
-------------------------
Version 1.09 does not exist.  I've changed it to 1.10 so I can use the major number as the main release update and the minor number for maintenance releases.  e.g. maintenance releases for 1.10 will be 1.11,1.12, etc... The next big release will be 1.20.

As the size of ABMaterial is getting rather big, I've seperated the assets (mp3, video, images etc...) from the main zip file.  So in the next release (or update) you would not have to download it again. But because some users had problems copying the www part, you do not need to do this for the demo projects anymore as I left them in place.  

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/ABMaterial1.12.zip
2. Download Demo Assets: http://gorgeousapps.com/DemoAssets.zip (it is the same as in v1.08)
3. After downloading, unzip them and copy all folders for (2) to the www folder of Demo (1) (overwriting the existing empty ones).
4. Copy the library files to your b4j library folder (ALL jar and XML files!)
5. Copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

NEW/CHANGES
-----------
ABMaterial 1.10 is now fully dynamic and that is a BIG update! Most of the changes happened behind the scenes, but as ABMaterial now contains over 40 components, it was a time consuming job converting them all to be dynamic.  Moreover, I wanted to test at least all basic functionality so I re-wrote the demo app.  It can be found in DemoDynamic. I'm unable to maintain both a dynamic and a static demo so from now on, all new components will be written in the dynamic format. (It's very easy to make it static, just move the code from ConnectPage() to the BuildPage() method.

[NEW] Rewrite so all components become dynamic
----------------------------------------------
The transition from Static to Dynamic is very easy, but there are a couple of important steps you have to follow. Please ask any questions about this topic on the forum. I'll try to follow them up as quick as possible, but I'm counting on the more expericenced users among you to help out a bit.

See the tutorial on the forum:

https://www.b4x.com/android/forum/threads/abmaterial-1-09-all-about-flexibility.65819/

[NEW] Localization framework build-in ABMaterial
------------------------------------------------
Another big addition to make localization of Web Apps a lot easier.

More info see: https://www.b4x.com/android/forum/threads/abmaterial-1-09-localization-using-dynamic-pages.65825/

-----------------------------------------------------------------------------------------------------------------------------
BEGIN Extra for DONATORS:
-----------------------------------------------------------------------------------------------------------------------------
ABMaterial supports a couple of BING auto translate methods.  This can be very usefull if you want to quickly translate your app to see if everything works well.  

First, you need to create a free BING transation key. A good tutorial to get you free key can be found here:

https://blogs.msdn.microsoft.com/translation/gettingstarted1/

When you have your ClientID and ClientSecret, you can initialmize the translator:

Dim ABM As ABMaterial
ABM.BINGActivateTranslator(page, "DONATORKEY", "CLIENTID", "CLIENTSECRET")

Once initialized you can use the actual translate methods:

BINGTranslate(text, srcLanguage, tgtLanguage)
BINGTranslateMultipleTexts(texts as List, srcLanguage, tgtLanguage) As List

And a very powerful batch method:

BINGCreateTranslationFiles(String dirToLanguageFiles, String srcLanguage, anywheresoftware.b4a.objects.collections.List tgtLanguages)

BEWARE! This is a helper method. Do NOT run this method in RELEASE mode or every time your app starts! You'll abuse you're BING account!
But this is a good method if you want to test your app in another language.  Run it once, then disable this code until you REALLY want to run it again (because e.g. a lot of texts has changed).

You can find the language codes here:

https://msdn.microsoft.com/en-us/library/hh456380.aspx?f=255&MSPPError=-2147217396
-----------------------------------------------------------------------------------------------------------------------------
END Extra for DONATORS
-----------------------------------------------------------------------------------------------------------------------------

[NEW] ABMList remove item
-------------------------
ABMList has a new method Remove(returnID) to remove a item from the list without having to rebuild the whole list.

[NEW] ABMTable fixed row height and text font size
--------------------------------------------------
A new method: table.AddRowFixedHeight(UniqueId as String, RowValues as List, Height as int)

And a new property on the TableTheme: FontSize (in px, default 15).

[NEW] AddArrayComponent with ABMDateTimePicker
----------------------------------------------
The ABMDateTimePicker can now also be added as an array components.  Change in the event definition:

sub mytime_changed(target as String, dateMilliseconds as string)

end sub

[NEW] Disable swipe down to reload a page (chrome on android, perhaps others)
-----------------------------------------------------------------------------
On request: I have implemented a page.DisablePageReloadOnSwipeDown property.

USE THIS WITH EXTREME CAUTION! THIS IS A HACK! This is the refresh of your mobile browser.  Know that if you put a new version of your webapp, the user will NOT be able to refresh the page to get the latest version.  Extremely difficult to find bugs in your apps as you are not sure anymore the user has the latest version. I DO NOT support this property!

[FIX] ABMTable - Sorting changes , Items with same values
---------------------------------------------------------
The sorttable.js library I used did not take this into account.  I've added a 'hack' in the lib that added, next to the column you want to sort, all the other columns too.  A real sort should have some kind of unique id that should be added to the sortable field, but let's see how this turns out.

[NEW] New component ABMTimeLine
-------------------------------
ABMTimeline is a component to present a time line of events. Using the ABMTimeLineElement you can create events, with some assets like images.

Complete rewrite has been done using the most recent version. I've also' ABMatrialized' it so you can add an ABMContainer as a slide object.  This means you can add almost every ABMComponent to it (buttons, inputs, google maps, pdfviewers, etc).  It has to be seen how far this can go e.g. I've noticed icons do not work as the <i> tag from Materialize CSS overlaps with the Timeline CSS for 'Italic'.  But if you can live with these limitations, I hink this may be a powerfull new 'navigation' component.

Some events have been added (user changed slide, dynamic adding and removing of slides, etc)

See for more info:  https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmtimeline-1-09.66311/ 

[FIX] Images added as an ArrayComponent do not raise the correct event
----------------------------------------------------------------------
Adding images as an ArrayComponent did not raise the correct event.  I've made the changes to 1.10.  

Also a new property "IsClickable" is introduced (default = true), so you can avoid unneeded click raises to your server if you're not doing something with it anyway.

Note that a 'MaterializeBoxed' image still never raises an event (all is taken care of in the materializebox library, so you cannot interfere).

[NEW] More variations of sizes for the ModalSheet
-------------------------------------------------
I added three new methods to show a modal sheet:

1. Opens a modal sheet relative to an ABMComponent (like a button)
page.ShowModalSheetRelativeComponent("fixedsheet", btn4, "60%")

2. Opens a modal sheet relative to a cell (row, cell, numberOfCells or fixed width)
page.ShowModalSheetRelativeCell("fixedsheet",1,1,1,"")

3. Opens a modal sheet with an absolute left, top, width and height
page.ShowModalSheetAbsolute("fixedsheet", "25%", "25%", "50%", "50%")

[NEW] Next step for the CRUD Generator, added possibility to generate overView table
------------------------------------------------------------------------------------
See for more info: https://www.b4x.com/android/forum/threads/abmaterial-crud-generation-the-next-step-in-1-09.66515/

[NEW] ABMTable setting column widths for non-scrollable tables (Experimental)
-----------------------------------------------------------------------------
Added a new method to table: ABMGenTableExecutors1.SetColumnWidths(    Array As Int    (0     ,0       ,0              ,0          ,50         ,50      ))

This also means table.InitializeScrollable is depreciated (you can still use it for backwards compatibility)

But from now on, maybe better use:

table.Initialize(...)
table.IsScrollabel = true
table.SetColumnWidths(Array as Int(...))

[NEW] New autocomplete setting for ABMInput
-------------------------------------------
ABMInput has a new autocomplete setting which allows to use google maps autocomplete to enter an address.

Usage:

1. Create a Google API key (You need the Google Maps Javascript API) and set it in the BuildPage() method, using the 'places' library:

        page.GoogleMapsAPIExtras = "key=YOURGOOGLEAPIKEY&libraries=places"

2. Create the google autocomplete input:

        Dim googleInp As ABMInput
	googleInp.Initialize(page, "googleInp", ABM.INPUT_TEXT, "Search Address via Google", False, "")
	googleInp.AutoCompleteType = ABM.AUTOCOMPLETE_GOOGLE
	myModal.Content.Cell(1,1).AddComponent(googleInp)

3. Create the result fields for the search:

	' create the input fields for the content
	Dim inp1 As ABMInput
	inp1.Initialize(page, "inp1", ABM.INPUT_TEXT, "Street", False, "")
	inp1.PlaceHolderText = "Streetname"
	myModal.Content.Cell(2,1).AddComponent(inp1)
	
	Dim inp2 As ABMInput
	inp2.Initialize(page, "inp2", ABM.INPUT_TEXT, "Number", False, "")
	myModal.Content.Cell(2,2).AddComponent(inp2)
	
	Dim inp3 As ABMInput
	inp3.Initialize(page, "inp3", ABM.INPUT_TEXT, "Postal Number", False, "")
	myModal.Content.Cell(3,1).AddComponent(inp3)
	
	Dim inp4 As ABMInput
	inp4.Initialize(page, "inp4", ABM.INPUT_TEXT, "City", False, "")
	myModal.Content.Cell(3,2).AddComponent(inp4)
	
	Dim inp5 As ABMInput
	inp5.Initialize(page, "inp5", ABM.INPUT_TEXT, "Country", False, "")
	myModal.Content.Cell(4,1).AddComponent(inp5)
	
	Dim inp6 As ABMInput
	inp6.Initialize(page, "inp6", ABM.INPUT_TEXT, "Location", False, "")
	myModal.Content.Cell(5,1).AddComponent(inp6)
	
4. Assign the newly created fields to the google autocomplete input:

	googleInp.SetGoogleAutocompleteResultInputComponent(inp1, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNAME)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp2, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_STREETNUMBER)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp3, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_POSTALCODE)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp4, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_CITY)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp5, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_COUNTRY)
	googleInp.SetGoogleAutocompleteResultInputComponent(inp6, ABM.GOOGLE_AUTOCOMLETE_RESULTTYPE_LOCATION)

[NEW] New component ABMFlexWall (helper)
----------------------------------------
ABMFlexWall is a simple galarie component for images.  Together with the IsMaterialBoxed=true setting, it creates an easy to use image wall.

Usage:

        Dim flexWall As ABMFlexWall
	flexWall.Initialize(page, "flexwall", 350) ' 350 is the height of a row
	
	For i = 1 To 20
		flexWall.AddImage(ABMShared.BuildImage(page, "img" & i, "../images2/" & i & ".jpg",1, i & ".jpg"), 1024, 768)		' 1024x768 is the real size of the image
	Next	
	
	page.Cell(2,1).AddComponent(flexWall)



[NEW] ABMInput changed/added events
-----------------------------------
The EnterPressed() event has now a parameter 'value as String'

Two new events to the input component: LostFocus() and GotFocus().  

There is also a new event Changed(value as String).  This is added because a lot of users asked for it, but I STRONGLY discourage you to use it as it will certainly have a big impact on your server!!!

As a matter of fact, by default all input fields will NOT raise this event.  You will have to explicitly set it by setting inputcomponent.RaiseChangedEvent=true

[NEW] ABMContainer can have a border
------------------------------------
You can use container.SetBorder() to set a border around a container.  Use the ABM.CONTAINERBORDER_... constants to set a line type.

e.g.

ItemProduced.SetBorder(ABM.COLOR_BLACK, ABM.INTENSITY_NORMAL, 3, ABM.CONTAINERBORDER_DASHED)

[NEW] New event ModalSheetDismissed in ABMPage
----------------------------------------------
Will be fired if a modal sheet is dismissed or closed after using CloseModal().  The param contains the name (id) of the modal sheet that is closed

Sub Page_ModalSheetDismissed(ModalSheetName As String)

End Sub

[FIX] Height can not be set to the ABMImageSlider component
-----------------------------------------------------------
There was a bug in the code where you could not set the ABMImageSliders height in the theme.  It was always ignored.  Same for Interval, Indicators and Transition.

[NEW] Button tabstop can be disabled
------------------------------------
This is normally not possible. I've searched the net and it seems this is normal behaviour in the browser.

However, I found a hack that should work in most browsers. I've added this hack so you can do btnSearch.TabStop = False, but it may not work in all browsers.

[FIX] Error parsing B4J code when spaces or tabs before 'End Sub' 
-----------------------------------------------------------------
When in the B4J code there is a space or tab before End Sub, the parser crashes when it runs.

[FIX] viewerpdf.html in  the wrong path
---------------------------------------
The file 'viewerpdf.html' is not created in the correct folder (it is created in the root of the disk)

[FIX] ABMCanvas cannot be added to a ModalSheet
-----------------------------------------------
When adding an ABMCanvas to a ModalSheet, the initialize runs AFTER the add components + on a wrong id.

[FIX] ABMCombo floating label does not work
-------------------------------------------
Sometimes, the floating label stays in a closed position after making a selection.

[FIX] ABMCanvas no events if on ModalSheet
------------------------------------------
Events are not raised for a canvas placed on a ModalSheet

[FIX] ABMCombo not closing when selected on Firefox
---------------------------------------------------
On some occasions in Firefox, the combo list does not close properly

[FIX] ABMCombo hover improvements
---------------------------------
Some enhancements on hover in a combo (better positioning and overlapping of the list item)

	


Happy programming!

Alain Bailleul
Alwaysbusy's Corner






