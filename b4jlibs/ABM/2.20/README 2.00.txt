Hi all!

The new version 2.00 of ABMaterial! 

Same goes as before, keep this one to yourself.  I'll release it on the forum when it's ready for public release. Thank you!

2.00 is a major release.  Lots of new stuff and some changes that were really needed in preparation of the upcoming (ABMaterial Abstract Desinger) ABMAD tool.
I've tried to limit it as much as possible, but there as some changes to some methods.  Do not panic when you compile and you see some red messages :-)
I've made the changes to the demo projects under 10 mins.  If someone has a particular problem, do not hesitate to mail me.  I'll help you through it.

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/20161012jh1527.zip
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).
Also if you use AppVersion in ABMShared, increase it with a number!

The changed methods are in the following components:
----------------------------------------------------

ABMActionButton:
----------------
The Initialize has now one extra parameter at the end: iconAwesomeExtra (You can pass "" if you do not use it)
In case the icon is an Awesome Icon, you can use the extra classes the Awesome Icon library provides:
examples: "fa-3x fa-pull-left fa-border"

see for more info: http://fontawesome.io/examples/

ABMTabs:
--------
The Initialize has now one extra parameter at the end: iconAwesomeExtra (You can pass "" if you do not use it). Same as above.

ABMCalendar:
------------
There was a Typo in the name: CALENDAR_FISTDAYOFWEEK...

While I made the change to FIRSTDAY I also removed the CALENDAR prefix:

FIRSTDAYOFWEEK_MONDAY
FIRSTDAYOFWEEK_TUESDAY
FIRSTDAYOFWEEK_WEDNESDAY
FIRSTDAYOFWEEK_THURSDAY
FIRSTDAYOFWEEK_FRIDAY
FIRSTDAYOFWEEK_SATURDAY
FIRSTDAYOFWEEK_SUNDAY

ABMAudioPlayerSong:
-------------------
Instead of song.Lyrcis.Add("lyrics") use:  song.AddLyrics("lyrics")
And to clear use:  song.ClearLyrics

ABMInput:
---------
Instead of inp5.AutoComplete.Add("alain") use:   inp5.AddAutoComplete("alain")
To clear the list use:  inp5.ClearAutoComplete

ABMTreeTable:
-------------
Instead of row.cells.Add(cell) use:    row.AddCell(cell)

Also:

cell = row.GetCell(index)
row.GetCellsSize
row.ClearCells

ABMChart (see also 'Plugins for Chartist' further in this text for more info):
------------------------------------------------------------------------------
Instead of cont.Labels.Add("alain") use:   

cont.AddLabel("alain")
cont.AddLabels(Array As String("Mon", "The", "Wed", "Thu", "Fri", "Sat", "Sun"))

And to clear use:    cont.ClearLabels

Also:
SetValues() and SetValuesXY()


NEW/FIXES
---------

[NEW] ABMParallax scaling to fit the device (phone, tab, desktop).
------------------------------------------------------------------
Added the new methods parallax.InitializeScaled() and parallax.InitializeScaledWithContainer() that take 3 parameters (height small, height medium, height large).  The image is 'scaled' (it is actually more like 'stretch' to 100% width and using the heights specified.

Best I can do, as by definition Parallax needs a specific height to work.

[NEW] ABMCard supports the same formatting as an ABMLabel.
----------------------------------------------------------
{B} and {/B}    	Bold
{I} and {/I}		Italic
{U} and {/U}		Underlined
{SUB} and {/SUB}	Subscript
{SUP} and {/SUP}	Superscript
{BR}				Line Break
{NBSP}				Non breakable space
{AL}{AT}{/AL}		Hyperlink e.g. {AL}http://alwaysbusyscorner.com{AT}Alwaysbusy's Corner{/AL}

If you want to have more complex formatted Cards, you'll need to build them yourself (e.g. using an ABMContainer).

[FIX] Divider cannot be added to ABMContainer
---------------------------------------------
In a container, the width appeared to be 0 and should be 100%.

[NEW] Change step in ABMInput of the type number
------------------------------------------------
Now the step of a inputbox with ABM.INPUT_NUMBER has a step op 1, the step should be changeable to something else (0.1, 0.01, 2, ...)

[FIX] ABMeditor cannot be added to an ABMModalSheet
---------------------------------------------------
Now it should.

[FIX] If a number is accounted for 100% of the total. chart is abnormal. eg:(0,0,2,0)
-------------------------------------------------------------------------------------
There was a bug in the Chartist library. I think I fixed it, but we'll have to check it as it is always hard to make changes in someone else's code.

[NEW] Right aligned sidebars
----------------------------
EXPERIMENTAL]

You can assign a right sidebar to a topbar item using the page.NavigationBar.AddTopItemWithSideBar() method.
Muttiple sidebars can be created that react to different top items.  

They can be opened/closed by clicking on the topitem button.  They can also be closed by clicking outside.

Note: An open right sidebar will be closed on phones and tablets when the 'real' navigationbar on the left opens.

More info: https://www.b4x.com/android/forum/threads/abmaterial-new-in-2-00-multiple-sidebars.71933/#post-457167

[NEW] The new Google Material Icons can be used
-----------------------------------------------
Made the needed changes so the new Google Material Icons can be used.  See https://design.google.com/icons/

[NEW] Configurable App and Content folders
------------------------------------------
see https://www.b4x.com/android/forum/threads/abmaterial-request-for-configurable-app-and-content-folders.71018 for a discussion on this topic.

[FIX] ModalSheet Overlay not closing when keypress
--------------------------------------------------
Took some serious hacking because the Materialize CSS does have issues with modals upon modals but I think I got it by playing with the focus.  Let's see how this works out...

[FIX] ABMCanvas remove object not working
-----------------------------------------
In the ABMCanvas, removeObject does no remove the object.  May lead to a memory leak.

[NEW] New component ABMChronologyList
-------------------------------------
The ABMChronologyList is a vertical timeline component.  Useful to give an overview of a limited period.

more info: https://www.b4x.com/android/forum/threads/abmaterial-new-component-abmchronologylist-2-00.70712/#content

[NEW] Possibility to create your own (alpha) colors
---------------------------------------------------
Goes a bit against the Material philosophy, but could be useful if you want to make Websites and colors need to match company logos.

In 2.00 you can create your own colors with an Alpha channel.  Note that it has to be set for every INTENSITY you are going to need:

tmpTheme.Page.AddColorDefinition("myred", ABM.INTENSITY_DARKEN4, "#B71C1C", 0.18)
tmpTheme.Page.AddColorDefinition("myred", ABM.INTENSITY_LIGHTEN2, "#B71C1C", 0.18)

Then you can use it as:

tmpTheme.Container("zdepthred").BackColor = "myred"
tmpTheme.Container("zdepthred").BackColorIntensity = ABM.INTENSITY_DARKEN4

[FIX] Mask not always set if an input is used in a modal sheet
--------------------------------------------------------------
When using an InputMask for an ABMInput, the input mask was not always set when the modalsheet was opened.

[NEW] ABMPlatform retina detection
----------------------------------
New return value DevicePixelRatio to find out if you are running on a high-res device (retina).

You can then act accordingly and e.g. use different images.  Use them as background@2x.png

1 = normal
2 = retina

[NEW] Utility: Lorem Ipsum Generator
------------------------------------
Lorem ipsum is a filler text used to demonstrate the graphic elements of a document or visual presentation.

Available methods:

Get a random word
	randomWord()

Get a random punctuation mark
	randomPunctuation()

Get a string of words
	words(count as int)

Get a sentence fragment
	sentenceFragment() 

Get a sentence
	sentence() 

Get multiple sentences
	sentences(count as int)

Get a paragraph
	paragraph(useStandard as boolean)

Get multiple paragraphs
	paragraphs(count as int, useStandard as boolean)
	
[FIX] SubTopItems in the naviationbar sometimes not shown on click
------------------------------------------------------------------
There are cases where a click on an item with subitems does not open the dropdown list.  

[NEW] ABMPDFViewer optimized script files
-----------------------------------------
Optimized (mimified) the internal used javascript and css files. Almost 50% gain.

[FIX] abmInput.LostFocus is not working
---------------------------------------
In ABMMaterial version 1.20 has stopped working abmInput.LostFocus event which was working in ABMaterial version 1.11

[NEW] ABMPdfViewer.ForcedLanguage property
------------------------------------------
By default, the pdf component picks the language of the user.  Added a new property ForcedLanguage to force the component to use a certain locale.

e.g. pdf1.ForcedLanguage="nl"

[NEW] Force vertical scrollbar always visible on page
-----------------------------------------------------
Sometimes, when you reload a page by removing and adding components the page 'jumps' a little because now it fits, then it doesn't on one screen.

Setting page.AlwaysShowVerticalScrollBar=True in BuildPage() will force the scrollbar to be visible at all time.

[NEW] Plugins for Chartist
--------------------------
In a ABMChartSerie:

SerieC.Values.AddAll(Array As Int(100,120,180,150,190,100,70))   becomes:
SerieC.SetValues(Array As Int(100,120,180,150,190,100,70))

And for the zoom we'll need to set, next to the Y values, also the X values:

Serie2A.SetValuesXY(Array As Int(10,20,30,40,50,60,70,80), Array As Int(1,2,3,1,-2,0,1,0))

With this change, we got two extra plugins (total of 5):

1. Zoom

page.AddExtraJavaScriptFile("chartist-plugin-zoom.min.js")

You must set some properties to your chart to make this work:

chart2.OptionsLine.AxisYLow=-3 ' must be set if you use 'Chartist.AutoScaleAxis' as type
chart2.OptionsLine.AxisYHigh=3 ' must be set if you use 'Chartist.AutoScaleAxis' as type
chart2.OptionsLine.AxisYOnlyInteger=True ' optional
chart2.OptionsLine.AxisYAxisType = "Chartist.AutoScaleAxis" ' must be set if you want to use the zoom plugin
chart2.OptionsLine.AxisXLow=10 ' must be set if you use 'Chartist.AutoScaleAxis' as type
chart2.OptionsLine.AxisXHigh=80 ' must be set if you use 'Chartist.AutoScaleAxis' as type
chart2.OptionsLine.AxisXAxisType = "Chartist.AutoScaleAxis" ' must be set if you want to use the zoom plugin
chart2.OptionsLine.AxisXOnlyInteger=True ' optional

chart2.AddPluginDefinition("Chartist.plugins.zoom({ onZoom : onZoom })") ' cannot be changed, must be like this

2. Tooltips on hover

You can modify the css file to your own liking.

page.AddExtraCSSFile("chartist-plugin-tooltip.css")
page.AddExtraJavaScriptFile("chartist-plugin-tooltip.min.js")

Give the ChartSerie a name.  It will also be shown in the tooltip (plugin limitation):

SeriaA.Name = "Red Pill"

[FIX] Split up b4j_ws.min.js and core.min.js again
--------------------------------------------------
This may be the cause of several problems you encounter (loops, sessions lost, slow connections):

It appears in the latest version I did add the b4j_ws.min.js to the core.min.js library. The result was sessioncreator was NEVER used. It was first noticed on Apple devices (loops in reloading) and once I've split them up again, ABMSessionCreator was used and everything is fine. Maybe on slow connections, it does something similar (not getting the right GetSession).


------------------------------------------------------------------------------

That's it for now.  Next big release will be all about ABMAD.

Happy programming!

Alain Bailleul
Alwaysbusy's Corner