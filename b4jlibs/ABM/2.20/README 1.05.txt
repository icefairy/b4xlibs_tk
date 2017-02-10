Hi all!

Here is the new public version 1.05 of ABMaterial: 

Keep reading, there are some important changes. :-)

NOTE:
----- 
Take a backup of your existing version.  This zip contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

NEW in 1.05:
------------
[FIX] Complete rewrite of the Refresh system
--------------------------------------------
Big one, so make sure you have a copy of everything!!!!

Codie01 (Philip) exposed a serious flaw in the refresh system of ABMaterial.  For a lot of objects, I just 'rebuilded' the HTML code and replaced the old code by it, or only refreshed properties for existing components.   However, in some cases this was not enough (like in a cell refresh).  The result was removed elements were not deleted from the html code, new components were not added. 
In my original design, that was ok, as all components should've been added in the PageBuild() method, and only 'changes' could happen.  But you guys proved me wrong and did a lot more with ABMaterial than I anticipated :-) 

Now, every 'refresh' method should do the following:

1. Is the component removed? Remove the HTML code
2. Is the component new? Build the HTML String, add it to the HTML file and run the needed JavaScript initialisation code
3. Else: just change all properties, classes, attributes etc in the HTML file (like what the old 'Refresh' method did).

I ran a whole battery of tests already, the future will show if this resolution was correct.

Thanks to Codie01 for doing some additional tests!

[FIX] Problem accessing /demo/HelperNavigationBarPage. Reason: Not Found
------------------------------------------------------------------------
This bug is in the unchanged demo of 1.04, when i go to helpers - ABMNavigationBar

For some reason, this line was not in main anymore:
myApp.AddPage(helpernavbarp.Page)

[NEW] Material Icon Fonts now local
-----------------------------------
Make Icon Fonts local (not CDN), so they won't fail if internet access is not available.

For the ABMUpload component and is a bit more complicated, but if you work off line you'll probably will not use this object, ergo it will not be in the html

[FIX] TextArea does not resize when dynamically added
-----------------------------------------------------
When dynamically adding a textarea by code, the box does not resize correctly to the show the full text

This happens when the text area contains multiple lines.

Examples are the notes and this text area in the ABMFeedback app.

[FIX] Button theme for floating buttons
---------------------------------------
When button type of Btn.InitializeFloating(page,  "MoreBtn",  "mdi-file-file-download", "flatgreen" ) - theme doesn't respect the foreground color set. It is always white.

[FIX] Radiobutton click event
-----------------------------
The click event on radio buttons did not work

[NEW] Labels with icon different colors
---------------------------------------
Labels with an icon can have a different color.

Two properties in the label theme:

IconColor & IconColorIntensity

[NEW] Experimental: Disable the back button in the browser
----------------------------------------------------------
Sometimes in you webApp (e.g. if you are using Modal Sheets), you want to prevent the user from pressing the back key in the browser (or mobile device), because this does not close the modal sheet, but goes back one step in the history of the browser.

In the BuildPage() method, set the property page.DisableBackButton = true to disable the back key.

Status is experimental, as we will have to find out in which browsers this trick works.

[NEW] LocalStorage support
--------------------------
3 methods to save, load and delete key/value pairs in the local storage:

ABMaterial.SaveInLocalStorage(page as ABMPage, key as String, value as String)
ABMaterial.LoadFromLocalStorage(page as ABMPage, key as String)
ABMaterial.DeleteFromLocalStorage(page as ABMPage, key as String)

[NEW] ABMModalSheet FULL size option
------------------------------------
A modal sheet can be set "full screen" (actually, full browser window) by setting the .Size property to MODALSHEET_SIZE_FULL

[NEW] Each list item can have an own background color
-----------------------------------------------------
theme.AddListTheme("refer")
theme.List("refer").AddItemTheme("green")
theme.List("refer").Item("green").BackColor = ABM.COLOR_GREEN
theme.List("refer").Item("green").BackColorIntensity = ABM.INTENSITY_LIGHTEN4
theme.List("refer").AddItemTheme("yellow")
theme.List("refer").Item("yellow").BackColor = ABM.COLOR_YELLOW
theme.List("refer").Item("yellow").BackColorIntensity = ABM.INTENSITY_LIGHTEN4

list3.AddItemWithTheme(id, BuildSimpleListItem(...), "green")

[FIX] ABMTabs background theme was never used
---------------------------------------------
The backcolor could be set in the TabTheme, but was never used in the generation of the HTML and CSS.

[NEW] ABMTab can have an Icon
-----------------------------
In the initalize method there is an extra parameter (IconName).  This can be usefull for e.g. on mobile phones where there is not enough space to show long titel texts. 

[NEW] New method to get the TabPage container control for an ABMTabs component
------------------------------------------------------------------------------
With the method GetTabPage(returnTabName as String) it is possible to get the TabPage container control.  Usefull if you need to manipulate data on a page.

        Dim tabc1 As ABMContainer =tabs.GetTabPage("tab1")
	Dim lbl1 As ABMLabel = tabc1.Component("tab1lbl")
	lbl1.Text = header1
	Dim tabc2 As ABMContainer =tabs.GetTabPage("tab2")
	Dim lbl2 As ABMLabel = tabc2.Component("tab2lbl")
	lbl2.Text = header2
	Dim tabc3 As ABMContainer =tabs.GetTabPage("tab3")
	Dim lbl3 As ABMLabel = tabc3.Component("tab3lbl")
	lbl3.Text = header3

[FIX] Combo list items visible (before adding a scroll bar)
-----------------------------------------------------------
utcombo1.Initialize(page, "utcombo", "Vehicle Type",  20 , "lightblue")	

Is the 20 in the above (maxheight as int) to limit the number of items in the list before a scroll bar is created - or the height of each list item?
However, it would be nice to have a max number of itemRows (then apply scroll bar) since all items are presented and causes the modal form to introduce a scroll bar, Rather than the combo....

Apparently I had commented out the part that uses the MaxHeight param.  (I wonder why...).  Reactivated it and we'll see if it has any impact.

[NEW] ABMPlatform object containing basic info on the users browser and device
------------------------------------------------------------------------------
usage: in WebSocket_Connected, AFTER the page.SetWebsocket(ws), put:

Dim info As ABMPlatform = page.GetPlatform

The result is something like this:

Manufacturer: 
Layout : 
Name : Chrome
Version: 47.0.2526.106
OSArchitecture: 64
OSFamily: Windows
OSVersion: 10
Prerelease: 
Product: 
Description: Chrome 47.0.2526.106 32-bit on Windows 10 64-bit
User Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36

[NEW] Removal or possibility to change <html lang="en"> in the Page-Header and integrate variables for SEO-optimization
-----------------------------------------------------------------------------------------------------------------------
See the Demo app on how it is done.

The turorial can be found on my blog:

http://alwaysbusycorner.com/2016/01/16/b4j-abmaterial-webapps-and-seo-search-engine-optimization/

page will get a couple of properties:

pageTitle
pageDescription
pageLanguage: (which can be set to a specific language (or an empty string if wanted). Default "en"
pageCharset: default "UTF-8" (previously was a "App" property, moved to a page property
pageKeywords: a comma delimited string containing your page keywords
pageHTMLName: it was always index.html, but it better to give it some name using keywords, like abmaterial-custom-component.html
pageSiteMapPriority: a value between 0.00 and 1.00
pageSiteMapFrequency: how frequently the page is updated (never, none, always, hourly, weekly, yearly, ...)

Added is also the creation of sitemap.xml. The generated file looks like this:

<?xml version="1.0" encoding="UTF-8"?>
<urlset
      xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.sitemaps.org/schemas/sitemap/0.9
            http://www.sitemaps.org/schemas/sitemap/0.9/sitemap.xsd">
<!-- created with ABMaterial and B4J -->
<url>
<loc>http://www.one-two.com/index.html</loc>
<lastmod>2016-01-16T11:11:16+00:00</lastmod>
<changefreq>monthly</changefreq>
<priority>1.00</priority>
</url>
<url>
<loc>http://www.one-two.com/onetwo-introduction.html</loc>
<lastmod>2016-01-16T11:11:16+00:00</lastmod>
<changefreq>monthly</changefreq>
<priority>0.50</priority>
</url>
<url>
<loc>http://www.one-two.com/onetwo-custom-component.html</loc>
<lastmod>2016-01-16T11:11:16+00:00</lastmod>
<changefreq>yearly</changefreq>
<priority>0.50</priority>
</url>
</urlset>

[NEW] Have the ability to center an object (button, image, etc) within a cell
-----------------------------------------------------------------------------
A cell theme can set the alignment: 

CELL_ALIGN_LEFT (default)
CELL_ALIGN_CENTER
CELL_ALIGN_RIGHT

theme.AddCellTheme("aligncenter")
theme.Cell("aligncenter").Align = ABM.CELL_ALIGN_CENTER

This theme can be used desingning the grid:

page.AddRows(1,True, "").AddCellsOS(3,0,0,0,4,4,4,"aligncenter")

OR set BEFORE adding components:

page.cell(2,1).UseTheme("aligncenter")
page.cell(2,1).AddComponent(mycomp)

It had quite an impact on the original Materialize CSS javascript framework, and I only tested it with a couple of controls.

Note: There is no inheritance.  Meaning, If you set an alignment to a cell and add a ABMContainer control, only the container control 
itself we follow the alignment.  You'll have to reset it on the containers cell level if you want the content to follow the rule.

[NEW] Responsive table
----------------------
A table has a new property: IsResponsive

Set to true, it will 'change' the look of the table if running on a small device like a mobile phone.  

See the screenshots (attachments).  This is exactly the same table (nothing had to be changed in code) in a PC browser and on a mobile phone with the setting tblClients.IsResponsive = true

This param required another method (in my case, because of the Edit button): SetHeaderHeights().
As the button is heigher than a 'text' line, I'll needed to be able to set the heigth of the header item.

My code now looks like this:

Dim tblKlanten As ABMTable
tblKlanten.IsResponsive = True
tblKlanten.Initialize(page, "tblKlanten", True, True, True, "tbltheme")
tblKlanten.SetHeaders(         Array As String ("ID"   , "Open"   , "Naam"   , "Contact"          , "Straat"   , "Stad"     , "Relatie"     , "Verkoper"))
tblKlanten.SetHeaderThemes(    Array As String ("bg"   , "bgc"    , "bg"     , "bg"               , "bg"       , "bg"       , "bg"          , "bg"      ))
tblKlanten.SetHeaderHeights(   Array As Int    (0      , 48       , 0        , 0                  , 0          , 0          , 0             , 0         ))
tblKlanten.SetColumnVisible(   Array As Boolean(False  , True     , True     , True               , True       , True       , True          , True      ))
tblKlanten.SetColumnSortable(  Array As Boolean(False  , False    ,True      , True               , True       , True       , True          , True      ))
tblKlanten.SetColumnDataFields(Array As String ("conID", ""       ,"conNaam" , "conContactPersoon", "stdNaam"  , "conStraat", "conrelCode"  , "vrkNaam "))

Use '0' as value if nothing should be changed (using the normal table cell height).
	
Note: Not sure if this will work with all type of tables. It does work with sortable (tested), but I think with scrollable this will not work.  You'll have to make a choice what to use I'm afraid.

[NEW] [Experimental] AppVersion to force reload of .js and .css files
---------------------------------------------------------------------
ABMaterial has an AppVersion property.  Changing this version should force the clients browser to reload all .js and all .css files.
See the ABMFeedback app on how it is done.

[NEW] New ABMCustomComponent component
--------------------------------------
Potential big one! ABMCustomCompont will make it easier to write your own components and integrate it into the ABMaterial framework.  
Using a couple of methods (Build, Refresh, FirstRun, CleanUp) you'll be able to add other objects that are specific for your project.  

Good knowledge of javascript, css, html is required!

Example is the noUISlider in the ABMCustomComponent page in the demo

[FIX] AddExtraCSSFile() pointed to the wrong folder
--------------------------------------------------
It should point to the shared css folder, and it didn't

[NEW] New ABMRange Component
----------------------------
New component to select a range.  Only horizontal as it is based on Materialize CSS and until they implement it, it can not change.

[NEW] New ABMSlider Component
-----------------------------
New slider control. Because it is based on Materialize CSS, it is only available as a horizontal slider. Until Materialize CSS changes it, that is how it stays.

Note: Because we now have a slider, and as some of you may recall ABMImageSlider used to be called ABMSlider in some early versions, some constants had to be renamed for ABMImageSlider:

SLIDER_LEFT -> IMAGESLIDER_LEFT
SLIDER_RIGHT -> IMAGESLIDER_RIGHT
SLIDER_CENTER -> IMAGESLIDER_CENTER

[NEW] Vimeo as ABMVideo option
------------------------------
Is implemented now in 1.05, but it does not allow to create custom controls.  The Vimeo API is rather limited,especially on mobile devices.

Happy programming!

Alain
Alwaysbusy's Corner

