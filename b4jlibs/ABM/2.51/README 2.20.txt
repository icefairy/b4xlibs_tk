INTRO:
------
If you are upgrading from 2.03 or earlier versions of ABMaterial, take also the time to read the included README files for 2.00+.  (you can ignore the parts on connecting/reconnecting problems as they have been changed in 2.17 anyway)

please see the document(s). I saved it in a couple of formats, so you can copy/paste code:

ABMaterial 2.17 Checklist.docx
ABMaterial 2.17 Checklist.pdf
ABMaterial 2.17 Checklist.htm

ABOUT 2.20
----------
Version 2.20 of ABMaterial introduces the ABMGridBuilder!

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
1. Download: http://gorgeousapps.com/ABM220RD161219Christmas1332.zip or on Dropbox: https://www.dropbox.com/s/xrhjig9qcg2sr3m/ABM220RD161219Christmas1332.zip?dl=1
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

Some other fixes in this version:

NEW/FIXES
---------
[NEW] Make ABMTab Title responsive
----------------------------------
I added a double behaviour.  The text becomes truncted if it does not fit, and if you use an icon and it is 'phone' size, the text is even omitted.

[FIX] PlaceHolderText property doesn't work well on ABMCombo
------------------------------------------------------------
Hopefully I finally nailed this one.  It appeared to be a long ongoing bug in Materialize CSS but I think I found a solution for it.

[FIX] ShowGridInfo border of each row dissapears
------------------------------------------------
A refresh did remove the red border.

[FIX] label icon is not modified instead it added again when used in an modal sheet
-----------------------------------------------------------------------------------
Bug in the refresh of the label

[FIX] DUMMY SideBarItem NOT REMOVED
-----------------------------------
Now doing a refresh without adding items will remove the DUMMY item



It has been a great year for ABMaterial.  I'm happy where we stand now, and the community has been very helpful in its development.  Thank you!

Happy holidays!

Alain Bailleul
Alwaysbusy's Corner











