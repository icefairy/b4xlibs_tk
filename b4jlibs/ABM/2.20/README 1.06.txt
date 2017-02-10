Hi all!

Here is the new version 1.06 of ABMaterial

Keep reading, there are some important changes. :-)

NOTE:
----- 
Take a backup of your existing version.  This zip contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

[BUG] robots.txt was placed in the wrong location/sitemap urls not in subfolders
--------------------------------------------------------------------------------
robots.txt must be placed directly in the root folder, not in the /appName/ folder.

The sitemap also generated the wrong urls.  It placed all html files in the root folder.

More info on:

https://developers.google.com/webmasters/control-crawl-index/docs/robots_txt

[NEW] Input fields have a SetFocus method
-----------------------------------------
Using input1.SetFocus will set the cursor in the input1 field.  Unfortunately, on mobile browsers, it does not autmatically open the keyboard.  Would've been nice, but a browser restriction :-)

[BUG] Page - rowtheme background color
--------------------------------------
Seems rowtheme background color can be over-ridden by a modal sheet rowtheme.  If no color is set in a modal sheet, page rowtheme color (where used) gets un-set (turns white - over what ever default color is)

[NEW] Theme and controls have a Colorize() method to quickly change a theme
---------------------------------------------------------------------------
Getting more out of the Theme system. Just by using the .Colorize() method, you can change the base color of ABMaterial.
Basically what it does is replace all the 'LIGHT_BLUE' values to the color you specify.  Because some objects have lighter or darker version of the base color
you cannot change the Intensity.  You of course still tune it manually.

use:  MyTheme.Colorize(ABM.COLOR_LIME):
        
example screenshots:

https://www.b4x.com/android/forum/threads/abmaterial-framework-for-webapps.60072/page-13#post-395589

[BUG] Error display Naviagion Bar at version v1.05 
--------------------------------------------------
Problem loading icon fonts locally

[NEW] Justify text
------------------
Besides aligning left, right or center, text can now also be aligned justified.

Experimental: justification also possible in cell theme.

[NEW] ABMDataTimeScroller
-------------------------
New component to let the user choose a date through a scroller.  Can be used to get the date, the time or both. See demo. 

[NEW] ABMDateTimePicker
-----------------------
Alternative component to let the user choose a date/time.  The date can be picked on a calendar, the time on a clock.

[NEW] Speed gain by using Minified versions of the javascript/css files
-----------------------------------------------------------------------

Next up for 1.07 are a new control ABMEditor, and ABMGenerator which will allow generating bug chunks of code for you.

Happy programming!

Alain Bailleul
Alwaysbusy's Corner


