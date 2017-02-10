Hi gang!

INTRO:
------
Small note to people who upgrade from 1.x -> 2.17, take also the time to read the included README files for 2.00+.  (you can ignoer the parts on connecting/reconnecting problems as they have been changed in 2.17 anyway)

Everyone, please see the document(s). I saved it in a couple of formats, so you can copy/paste code:

ABMaterial 2.17 Checklist.docx
ABMaterial 2.17 Checklist.pdf
ABMaterial 2.17 Checklist.htm

This document will help you to update to the latest version.  Read them CAREFULLY, and as always, do not hesitate to mail me (alain.bailleul@telenet.be) if you need some assistance.  Hopefully this is the last big transition we have to do with 2.00+.  I used the document myself to do the conversion for about 10 WebApps I have, (including the demo app who has over 60 pages) and I did it in just a couple of hours. It is mostly a matter of copy/paste and deleting code.  Still, sorry for the inconvenience, but it was absolutely needed if we want to have a stable framework.

Mindful and I have been tossing ideas around quite a bit (hence we now have version 2.17).  Some looked very promissing, and sometimes we did have to take a couple of steps back.  Especially the browsers on iPad, iPhone and Stock Android proved to be quite challenging.  Thanks for keeping me sane!

Most notably is that we got rid of the Page_Ready() event.  This had bothered me from the beginning and never proofed being 100% reliable.  So now it is gone and when you get the WebSocket_Connected() event, you know the page and all the libraries are loaded.  So to update to 2.17, you have to copy this code into the ConnectPage() method at the end. Then DELETE Page_ready() as it will NEVER be called again.

2.03 users will notice the code is a lot cleaner in 2.17.  Moreover, as shown in part 3 of the document, if you want to, your code can represent a lot more like a normal B4J app: 

	Initialize() is where you put the BuildTheme() and BuildPage() code.

	WebSocket_Connected() where you put the ConnectPage() code.  See the feedback app where I did it that way.  
	The demo is still using BuildPage() and ConnectPage(), as I have a slight preference to do it this way.

You also notice a speed increasement. In time, a lot of unneeded ws.flush statements were added into the framework.  Thanks to our Friendly-Neighbourhood-MagicMan Erel, who allowed me to access the jServer library code, I could build in some methods in the library which allowed me to identify those problems.  ABMaterial is becoming a vast library and without this, it would have been a small nightmare.  Thanks!

INSTALL NOTES:
--------------
Take a backup of your existing version.  These zips contains the library files AND the new javascript/css files.
1. Download: http://gorgeousapps.com/ABM217RD161208t1403.zip or on Dropbox: https://www.dropbox.com/s/xjv66np5wx0360i/ABM217RD161208t1403.zip?dl=1
2. Copy the library files to your b4j library folder (all jars and xml)
5. For your own projects, copy the www folder to your project www folder and overwrite the files

Refreshing the browser (F5) may be needed! (Or pulling down on your mobile device to refresh the browser).

A small breakdown on what now happens in ABMaterial 2.17:
---------------------------------------------------------
When a user connects/reconnects, a cache map of your page classes is consulted to see if it is a reconnect.  If yes, then the page is refreshed, but not reloaded.  If not, the page is build and saved in the cache.

Periodically, the browser sends a heartbeat to the server.  As long as this happens, the page stays in the cache.  If not, and the websocket gets rid of its session, a scavenger cleans up your cache to preserve memory.  If the user navigates in your app, the original page is also removed from the cache.

Two parameters let you regulate this whole process:

CacheScavengePeriodSeconds: this is the interval the Scavenger will try to clean up disconnected pages.  They will not be cleaned up as long as the websocket has a 'working' session. (Default 15 minutes)

SessionMaxInactiveIntervalSeconds: this is an important one where you have to decide how you want your app to work.  In case of an app with little new connection, you can put this up rather high (days).  But if you have a lot of new/different connections, you better set this lower to free up meomory in the server app. (Default 30 minutes)

ABMaterial 2.17 also allows you to open multiple times the same page in a browsers tab, but beware, each page keeps has a cached member so be careful if you allow this.

Although this is all about the inner workings of ABMaterial, it may be interesting to know a little bit about it.


--------------------------------------------------------------------------
This morning I did also clean up some other cases I could quickly resolve:

NEW/FIXES
---------

[FIX] FontAwesome Icons on ABMButton - IconAwesomeExtra needs extra space
--------------------------------------------------------------------------
If I do this:
btnRecover.IconName = "fa fa-question-circle-o"
btnRecover.IconAwesomeExtra = "fa-fw"
it doesn't work as it translates in html like this: fa-fwfa fa-question-circle-o

if I place at the end of IconAwesomeExtra = "fa-fw "
it works

[NEW] WrongMessage looks weird
------------------------------
Also the when the control has no focus the WrongMessage Font is kind of big.

This is limitation of the Materialize CSS framework.  Title and Wrong/Success message font size are linked.  I rather don't dive in this CSS hell to try to change it (probably would mean a complete rewrite of the input CSS).  A workaround is using a PlaceHolder.  I've added the possibility to use {NBSP} as placeholder text so it appears empty.

        Dim combo1 As ABMCombo
	combo1.Initialize(page, "combo1", "Select a {B}person{/B}", 650, "")
	combo1.Valid = ABM.VALID_FALSE
	combo1.PlaceHolderText = "{NBSP}"
	combo1.WrongMessage = "My Wrong Message"
	combo1.IconName = "mdi-action-account-circle"
	
	' add items
	combo1.AddItem("combo1S1", "Mom", BuildSimpleItem("S1", "mdi-action-account-circle", "{NBSP}{NBSP}Mom"))
	combo1.AddItem("combo1S2", "Dad", BuildSimpleItem("S2", "mdi-action-account-circle", "{NBSP}{NBSP}Dad"))
	combo1.AddItem("combo1S3", "Brother", BuildSimpleItem("S3", "mdi-action-dashboard", "{NBSP}{NBSP}Brother"))
	combo1.AddItem("combo1S4", "Sister", BuildSimpleItem("S4", "mdi-action-dashboard", "{NBSP}{NBSP}Sister"))
	
	page.cell(2,1).AddComponent(combo1)

[NEW] The title on an imput/combo component can also use formatting
-------------------------------------------------------------------
You can now also use the formatting tags like {B}, {I}, etc in the Title of an input and combo.

[FIX] WrongMessage isn't displayed on Combo
-------------------------------------------
The Valid method works but the WrongMessage isn't displayed, for ABMInput works correctly.

This was indeed not forseen 100% (no messages, only validation).  I added this possibility to the combo too.

[FIX] when fileinput comonent in modalsheet, user can't open "dialog box" to select file.(version 2.00)
-------------------------------------------------------------------------------------------------------
Was a mistake in the refresh procudure when the functionality of the button was removed.  Is fixed.

Happy programming!

Alain Bailleul
Alwaysbusy's Corner











