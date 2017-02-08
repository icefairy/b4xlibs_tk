NOTE:
----- 
Take a backup of your existing version.  This zip only contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

Quite some improvements/fixes and a new control.

I've noticed it is not that easy to get a grip on the grid topic and CableGuy made a suggestion about showing the grid that could improve this.

[NEW] page.ShowGridInfo = True
-----------------------------
while developing, set this property to true and a red grid will appear on your page so you can see the structure.

[NEW] next to the page.cell(row,cell) there is now also the method page.cellR(moveNumberOfRow, cell).  
-----------------------------------------------------------------------------------------------------
The R stands for relative. This new method could greatly improve development when you need to add a row in between.  Instead of specifying the row, you just set in the first param how many rows it should 'move' relative to the previous one.  You can mix both methods. Using cell() will position it absolutely, cellR() relatively.

[CHANGED] the method .Component() has been changed!  
---------------------------------------------------
You do not need to specify the row and cell any more.  When you first run your app with the new library, you'll have a lot of errors.  But DO NOT panic :-)  I did the syntax change of the Component() method in the demo app under two minutes! (you just have to remove the first two numerical params).  In the long run, again, when you use the CellR() methods, you won't have to worry about moving the other lines in your code. The old method is now called ComponentRowCell() if you still want to use it.

[NEW] ABMChart
--------------
Now we have charts in ABMaterial! Check out the ABMChart page in the demo app.  All the above changes are also demonstrated in this page. A fun one with this object is e.g. Raspberry Pi, you can give 'real-time' telemetry updates using the ABMChart control (see the last example).

[FIX]. Several bug fixes while I was writing the new stuff. 
-------------------------------------------------------------
There was a rather big one in Firefox where the ready() event was never raised.

[FIX]:Refresh ABMList and ABMTable.  
-----------------------------------
You should avoid using page.refresh() as this refreshes everything, also the stuff that is not changed.  I know you had to use it because list.refresh() and table.refresh() did not work, but test it without page.refresh().

With tables, you have to to a .refresh() of all of them in the WebSocket_Connected() event.

e.g. in the demo it looks like this:

Private Sub WebSocket_Connected (WebSocket1 As WebSocket)
    Log("Connected")
    ws = WebSocket1    
    If ABMShared.NeedsAuthorization Then
        If ws.Session.GetAttribute2("IsAuthorized", "") = "" Then
            ABMShared.NavigateToPage(ws, "../")
            Return
        End If
    End If
    ' connect our page with the websocket    
    page.SetWebSocket(ws)
    ' Prepare the page IMPORTANT!
    page.Prepare    
    
    ' so it represents the correct values, not the ones saved in the .html file IMPORTANT!
    Dim tbl1 As ABMTable = page.Cell(2,1).Component("tbl1")
    Dim tbl2 As ABMTable = page.Cell(4,1).Component("tbl2")
    Dim tbl3 As ABMTable = page.Cell(6,1).Component("tbl3")
    tbl1.Refresh
    tbl2.Refresh
    tbl3.Refresh
End Sub

Why? Well let me explain.  When you start your server app, the HTML files are written to disk. This is the version that is first loaded in the users browser.  So, if there is data in it, this is also the data that is shown. 
However, we want to show the data this specific user needs to see.  (In the BuildPage() you are probably running a SELECT query to load data for that user.)  But until you do tbl.Refresh(), although the correct values are in the loaded html, the data has not been flushed to the screen.

Also: There are two new methods:
tbl.SetString(row, column value) that allows you to change the text in a column.  (if it is a component, it already worked using the GetComponent() method).
tbl.Clear(): deletes all the rows in the table.

[NEW]: ABMGoogleMap now has a new method to do reverse geocoding
----------------------------------------------------------------

Sub btn12_Clicked(Target As String)
    Dim gm1 As ABMGoogleMap = page.Component("gm1")
    gm1.ReverseGeoCode(50.8500, 2.8833)
    gm1.refresh ' IMPORTANT
End Sub

and the event:

Sub gm1_ReverseGeoCodeResult(Address As String)
    myToastId = myToastId + 1    
    page.ShowToast("toast" & myToastId, "toastred", Address, 5000)    
End Sub

[NEW]: When doing heavy things on the server and the user must wait, you can now use page.pause and page.resume. 
----------------------------------------------------------------------------------------------------------------
A black transparent overlay with the 'loading' animation will be shown over the page.  IMPORTANT! You have to resume the action with Page.Resume.
You could e.g. when someone clicks on a button do:

Sub btn12_Clicked(Target As String)
    page.pause
    callsubdelayed(mypage, "mylongfunc")
End Sub

Sub mylongfunc()
  ' do some really time consuming stuff
 
  ...

  page.resume
End Sub