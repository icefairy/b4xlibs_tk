Hi all!

The new version 1.08 of ABMaterial! 

Same goes as before, keep this one to yourself.  I'll release it on the forum when it's ready for public release. Thank you!

Donators will receive a personalized DONATOR KEY in a seperate mail to activate some exclusive functionalities.

As the size of ABMaterial is getting rather big, I've seperated the assets (mp3, video, images etc...) from the main zip file.  So in the next release (or update) you would not have to download it again.

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/20160401w1335.zip
2. Download Demo Assets: http://gorgeousapps.com/DemoAssets.zip
3. After downloading, unzip them and copy all folders for (2) to the www folder of Demo (1) (overwriting the existing empty ones).
4. Copy the library files to your b4j library folder
5. Copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

NEW/CHANGES
-----------

[NEW] The Need for Speed
------------------------
This release has a lot of changes to speed-up your WebApps. Using Google Insights and several little tools, I've optimized about everything to speed-up JavaScripts,HTML,CSS and even PNG images! Everything is minimized, GZipped and cached. (GZipping and PNG optimization is a Donators exclusive).

All you have to do to get this working is this (see the demo source code):

1. in ABMApplication, Initialize() add:

	#If RELEASE
		ABM.PreloadAllJavascriptAndCSSFiles=True ' NEW, When the WebApp start, ALL JS/CSS files are pre-loaded 
		ABM.ActivateGZip("YOURDONATORKEY", 1000) ' NEW, All files bigger than 1000bytes will be pre GZipped
		ABM.AppDefaultPageCSSInline=True ' NEW, generated CSS included in the HTML, not in seperate files
		ABM.AppDefaultPageJSInline=True ' NEW, generated JS included in the HTML, not in seperate files
	
		Dim folders As List ' NEW, add the folders where your images are (PNG files) and they will be optimized for you
		folders.Initialize
		folders.Add(File.DirApp & "/www/" & AppName & "/images")	
		ABM.ActivatePNGOptimize("YOURDONATORKEY", folders, False , 9, False)
	#End If

2. In ABMApplication, StartServer() and StartServerHTTP2()

	#If RELEASE
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":True,"dirAllowed":False, "maxIdleTime":"300000"))
	#Else
		srvr.SetStaticFilesOptions(CreateMap("cacheControl": "max-age=604800,public","gzip":False,"dirAllowed":False, "maxIdleTime":"300000"))
	#End If

Thats all! When you now run in release mode, you'll notice a couple of new lines in the IDE log:

	>>	GZipping HTML, JavaScript and CSS files...
	>>	Optimizing new and updated PNG files...
		2016-04-01 13:52:45.854:INFO::main: Logging initialized @12100ms
		2016-04-01 13:52:45.997:INFO:oejs.Server:main: jetty-9.3.z-SNAPSHOT
		2016-04-01 13:52:46.119:INFO:oejsh.ContextHandler:main: Started o.e.j.s.ServletContextHandler@3788f3{/,file:///Z:/DATA/Ideas/ABMaterial/Demo/Objects/www/,AVAILABLE}
		2016-04-01 13:52:46.138:INFO:oejs.AbstractNCSARequestLog:main: Opened Z:\DATA\Ideas\ABMaterial\Demo\Objects\logs\b4j-2016_04_01.request.log
		2016-04-01 13:52:46.158:INFO:oejs.ServerConnector:main: Started ServerConnector@151b3e0{HTTP/1.1,[http/1.1]}{0.0.0.0:51042}
		2016-04-01 13:52:46.159:INFO:oejs.Server:main: Started @12405ms

[NEW] Use componentsin the SideBar of the ABMNavigationBar Component
--------------------------------------------------------------------	
I got a couple of requests for the Navigation Bar since the first release. I've tried to make as little changes to the B4J code as possible for you, but still, there are some important ones.
e.g. the Initalize lost some params, and a couple are added.

	Old declaration:
	page.NavigationBar.Initialize(page, "nav1", Title, ABM.TEXTALIGN_LEFT, False, True, False,True, 330, 48, logo, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	New declarations:
	
	' we have to make an ABMImage from our logo url
	Dim sbtopimg As ABMImage
	sbtopimg.Initialize(page, "sbtopimg", logo, 1)
	sbtopimg.SetFixedSize(236, 49)
	
	' our top component can be a more complex component than an image
	' Dim sbtopimg As ABMContainer = BuildSideBarTopComponent(page, "sbtopimg", "../images/me.jpg", "Me", "Simply the best")
	' ' we have to adjust the 'logo' height
	' page.NavigationBar.SideBarLogoHeight = 245
	
	
	' behaviour as the old declaration	
	page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_MANUAL_HIDEMEDIUMSMALL, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	' new behaviour, the sidebar is ALWAYS hidden
	' page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_MANUAL_ALWAYSHIDE, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	
	
	' new behaviour, the sidebar is created automatically from the top items if the device size is tablet or mobile
	' note in this case, ALL AddSideBarItem(), AddSideBarSubItem(), AddSideBarDivider() and AddSideBarSubDivider() calls will be IGNORED, as the sidebar will be build dynamically from the top items!
	' page.NavigationBar.Initialize(page, "nav1", ABM.SIDEBAR_AUTO, Title, True, True, 330, 48, sbtopimg, ABM.COLLAPSE_ACCORDION, "nav1theme")	

	' new behaviour: on each top item you can set if it should hide of not on a medium or small device.
	page.NavigationBar.AddTopItem("Contact", "", "mdi-action-account-circle", "", False)

A new method AddSideBarComponent() is introduced.

Usage: page.NavigationBar.AddSideBarComponent("TestComp1", BuildSideBarComponent(page, "tcS1", "../images/mom.jpg", "Mom", "The loving one"), "")	

for more info see the demo source code and https://www.b4x.com/android/forum/threads/abmaterial-abmnavigationbar-changes-in-1-08.65237/

[NEW] ABMTable ScrollTo method
------------------------------
tbl3.ScrollTo("uid9", False) where "uid9" is the unique row id and True/False to scroll smooth or not.

[NEW] ABMInput Alignment
------------------------
ABMInput property Align:

INPUT_TEXTALIGN_START
INPUT_TEXTALIGN_END
INPUT_TEXTALIGN_CENTER
INPUT_TEXTALIGN_LEFT
INPUT_TEXTALIGN_RIGHT

[NEW] Tag property for an ABMTable Cell
---------------------------------------
Like any component has a tag property, each cell in an ABMtable has a celltag property (object) too.

[FIX] ABMRange and ABMSlider don't work in modal sheets
-------------------------------------------------------

[FIX] Saved login information is over the input field placeholders
------------------------------------------------------------------
Tough one! Took a hack into the original Materialize CSS library so we have to keep an eye on this if it has further impacts on the framework.

[NEW] add or remove highlight on ABMTable(sync with activerow)
--------------------------------------------------------------
SetActiveRow() can take an uniqueId, and an empty string like asked.

But you have to manually do it when the user changes pages:

e.g. in a pagination event:

Sub pagination_PageChanged(OldPage As Int, NewPage As Int)
    ' do your stuff
    Dim pagination As ABMPagination = page.Component("pagination")
    pagination.SetActivePage(NewPage) ' IMPORTANT!
    pagination.Refresh ' IMPORTANT!
    Dim tbl As ABMTable = page.Cell(2,1).Component("tbl1")
    tbl.SetActiveRow("")
    tbl.Refresh
End Sub

The reason why it has to be done like this: I cannot build it in automatically as the pagination control and table are not linked (it can be used for other things too).

Still, I think it is kind of an elegant solution. :-)

Use SetActiveRow("") to clear the current selection.
Use SetActiveRow("uniqueid") to activate a selection.

[FIX] Problem with the colors WHITE, BLACK and TRANSPARENT
----------------------------------------------------------
If the intensity is different than INTENSITY_NORMAL with these colors, it sometimes returns a black color.

[NEW] Support for Open Graph Meta tags and Twitter Summary Card
---------------------------------------------------------------
The Open Graph protocol enables any web page to become a rich object in a social graph. For instance, this is used on Facebook to allow any web page to have the same functionality as any other object on Facebook.

On each page there is a new Map property: OpenGraphMetaTags. The key is the property name, the value is the content.

e.g.  OpenGraphMetaTags.Put("og:title", "mytitle")

creates: "<meta property="og:title" content="mytitle"/>

Check the Open Graph protocol http://ogp.me/ to find out what tags you can use.

Note you can also add this for the Twitter Summary Card: https://dev.twitter.com/cards/types/summary

[FIX] ABMTable does not fully work in a container
-------------------------------------------------
When the ABMtable is in a container, some functionalities do not work (like row selection)


[NEW] Autocomplete inputfield
-----------------------------
see for more info: 

https://www.b4x.com/android/forum/threads/abmaterial-possible-to-use-autocompletion.65003/ 

[NEW] New component ABMAudioPlayer
----------------------------------
ABMAudioPlayer is a new component for ABMaterial v1.08 that allows to play mp3 files in WebApps. This component can play individual mp3 files, or playlists (see video). It can also show lyrics (in the lrc file format). I cannot record audio in my videos, but it shows how it works. 

This is the APlayer library, materialized with bigger buttons, themeable, being responsive etc...

More info: https://www.b4x.com/android/forum/threads/abmmaterial-new-component-abmaudioplayer-in-1-08.64527/

[NEW] New component ABMPivotTable
---------------------------------
ABMPivotTable allows the user to view data in a dynamic pivot table. It can answer quick questions that are e.g. not findable in a report. Note that it can only handle a couple of thousand records. You have to provide it with a csv file, so you may have to filter the records on the server side before sending it over to the browser.

I have tried to materialize it as much as possible, but as for now, I have not found a solution for the dropdown combos.

More info: https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmpivottable-in-1-08.64531/

[FIX] ABMeditor URLS do not work
--------------------------------
clicking on the link did not work

[NEW] New component ABMPDFViewer
--------------------------------
It allows viewing, printing, downloading, localizing, a side view to show pages and more.

Completely materialized so it works on mobile devices (big buttons, menu addaptation etc...)

This could work great together with another library I'm writing (a donator exclusive) for JasperReports.

[FIX] Material icons on ABMCard/ABMChip not shown
-------------------------------------------------
Since the update in ABMaterial to local host the fonts, the icons in ABMCard/ABMChip did show text instead of an icon.  

[NEW] Ordination incorrect symbol headers tables
------------------------------------------------
It's debatable, but I've switched the symbols

[NEW] radiobuttongroup can't remove the button( can add or change)
------------------------------------------------------------------
Added a method RemoveRadioButton(index as int)

[FIX] upload in modal sheet
---------------------------
it seems can't select the file by clicking "browser" in uploadcomponent  which is added in the modal sheet. but drag file  work well.

[NEW] Add chips at runtime
--------------------------
This was only partially implemented.  You could already add chips at runtime, however there was a problem with the refresh of the existing chips.

[NEW] Expand optional nodes in TreeView after refresh
-----------------------------------------------------
Added two methods: Expand(rowId as String) and Collapse(rowId as String)

[NEW] Support for Browser side Cookies
--------------------------------------
On the page object three new methods:

Page.CookieSet("test", "testvalue", "expires: '01/01/2017'") ' set the cookie
Log(Page.CookieGet("test")) ' get the cookie
Page.CookieExpire("test", "") ' remove the cookie

[BUG] ABMTable in a container returns wrong component name for the event
------------------------------------------------------------------------
When an ABMTable is set in a container (like in an ABMTabs), the full name including the containers name is returned. e.g mycont-tbl1_Clicked() instead of tbl1_Clicked()

[BUG] CRUD Generator Issues
---------------------------
1. Removed ABM.GEN_NUMBER and replaced by ABM.GEN_DOUBLE and ABM.GEN_INTEGER
2. Added DBM.CloseSQL(SQL) in the Edit method
3. 'pk not in INSERT': Because for some Databases, you may not do this, I've introduced a new param to the ABMGeneratorCRUDDefinition: IgnoreAutoNumberInINSERT (default=false).  So in most cases it will be added to the insert, but you can overrule this.

[BUG] Page is not full width on large and medium screens when navigation bar has barType set to ABM.SIDEBAR_AUTO
----------------------------------------------------------------------------------------------------------------
If I set the navigation bar to the new behaviour so that the sidebar is created automatically from the top items if the device size is tablet or mobile then the sidebar is just invisible and the page content is not full width of the browser 

[NEW] NavigationBar TopSubItems are not shown correctly if they have larger width than the parent TopItem
---------------------------------------------------------------------------------------------------------
If the TopItem width is smaller than a TopSubItem width then the TopSubItems are not rendered correctly
Also a WISH - It would be great if we can change the font size of the TopSubItems Text - It is bigger than the TopItem.

 can't make the fontsize variable, but I've changed it to the same height as the topbar item.  Don't know why the original Materialize CSS used a bigger font for the dropdown items (1.2 rem  submenu <-> 1rem menu).  I also added a new property:

page.NavigationBar.TopBarDropDownConstrainWidth = False

This will override the default behaviour of constraining the width of the sub items to the size of the topbar menu item.

[BUG] Image toggle not working anymore
--------------------------------------
The image toggle only works once.

Happy programming!

Alain Bailleul
Alwaysbusy's Corner


