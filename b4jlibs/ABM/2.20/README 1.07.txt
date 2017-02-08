Hi all!

Here is the new version 1.07 of ABMaterial: 

Keep reading, there are some important changes. :-)

NOTE:
----- 
Take a backup of your existing version.  This zip contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

[NEW] ABMGenerator object: allows generating CRUD and messagebox modal sheets fast
----------------------------------------------------------------------------------
Given a set of parameters in a couple of lines of code, ABMGenerator can generate several hundreds of lines of B4J code that only need to be tuned by the programmer to its specific wishes.

Refer to this post for more info.

https://www.b4x.com/android/forum/threads/abmaterial-crud-form-builder-designer.62754/

[BUG] Calling ShowModalSheet multiple times not destroyed correctly on close
----------------------------------------------------------------------------
Calling the ShowModalSheet of the same sheet always created a new instance of the sheet, so when you closed it, sometimes the 'darker' layer stayed open 
and you had to refresh the page to continue.  This is a flaw in Materialize CSS, but now ABMaterial does a check if the modal sheet isn't already open.

[BUG] Switch does not work on modal sheet
-----------------------------------------
Using a Switch on a modal sheet did not get initialized correctly.

[BUG] Colorize() fails on some components
-----------------------------------------
On some components, the Colorize method did nothing.

[NEW] ABMModalSheet added theme
-------------------------------
ABMModalSheet was about the only component left that had no theme.  Now you can set the content and footer background and it also reacts to the the colorize() method.

Note: Also means the Initialize method has been changed!

[NEW] Infinite Scrolling pages (e.g. like Twitter or Facebook)
--------------------------------------------------------------
With just a couple of lines code, you can create Infinite Scrolling Pages with ABMaterial.

See for more info and a demo:

https://www.b4x.com/android/forum/threads/abmaterial-infinite-pages-with-1-07.63259/

[NEW] Button .Large depreciated in favour of .Size
--------------------------------------------------
The .Large property is depreciated and replaced by .Size.

values: 

ABM.BUTTONSIZE_SMALL
ABM.BUTTONSIZE_NORMAL
ABM.BUTTONSIZE_LARGE

[NEW] Spinning Circles with "old" page as background
----------------------------------------------------
Unfortunately, the spinning circles start when the new page start loading, not when you leave the old page.  So once they start spinning, the old page is long gone.  
However, I can build an extra method SetShowLoaderWithOpacity(doShow as Boolean, opacity as Double).

The effect will be it will show the new (partially loaded) page transparent in the background and the full refresh will happen once the page is completely loaded.

[BUG] list can't add subitem in abmtabs
---------------------------------------
Adding subitems in a list in a tab page did not work

[NEW] Support for Google Analytics
----------------------------------
more info and a tutorial, check out http://alwaysbusycorner.com/2016/02/17/b4j-using-google-analytics-with-abmaterial/

[NEW] Goto certain date in ABMCalendar component
------------------------------------------------
new method GotoDate(newDate as String) to jump to a certain day/week/month

Note: newDate should be in the ISO8601 format (e.g. 2015-11-18)

[NEW] ABMTreeTable can be dynamic + Drag/Drop features
------------------------------------------------------
Until now, ABMTreeTable could only be used in a static way.  Now, trees can be made on the fly.  A seperate demo project 'folders' has also been created outside 
the demo project to show what is changed and how to use e.. the new drag/drop features.

See the extra demo project 'folders' for its new functionalities

[NEW] New component ABMSocialShare
----------------------------------
A control to allow your users to share content of your WebApp/Website to their social networks.

[NEW] New component ABMEditor
-----------------------------
An alternative input component that allows rich text. Handy for rich mails, articles, etc...

[NEW] Higlight selected node in TreeView when clicked
-----------------------------------------------------
Used together with the new BackColor in the treeview theme, you can darken or lighten the active row


Happy programming!

Alain Bailleul
Alwaysbusy's Corner


