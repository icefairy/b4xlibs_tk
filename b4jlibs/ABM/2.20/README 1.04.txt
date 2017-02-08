Hi all!

Here is the new version 1.04 of ABMaterial: 

NOTE:
----- 
Take a backup of your existing version.  This zip contains the library files AND the new javascript/css files.
1. Copy the library files to your b4j library folder
2. Copy the www folder to your project www folder and overwrite the files

NEW in 1.04:
------------
[NEW] As requested, ABMFeedback has been created to demonstrate CRUD with B4J and ABMaterial
--------------------------------------------------------------------------------------------------------------------------------------------------
You can find the source code in this zip.

[NEW] ABMTable has been reviewed and some changes were needed to facilitate the new requested features like row select.
--------------------------------------------------------------------------------------------------------------------------------------------------
e.g. InitializeWithThemes has been removed and is replaced.  It makes it clearer to write your code.  Using the right spacing, it gives a better overview of what is in each column:

' create a table
Dim tblUsers As ABMTable
' IMPORTANT: we set usingQueriesToSort = true because we are going to handle the sorting, not the javascript sorting library
' When using Pagination, the sorting library does not know all the data
' SetColumnDataFields() is used when the user clicks on a column head to sort to return in the SortChanged() event and the GetSortColumn() And SetSortColumn() methods.
tblUsers.Initialize(page, "tblUsers", True, True, True, "tbltheme")
tblUsers.SetHeaders(         Array As String ("ID"  , "Type"   , "Name"    , "Login"    , "Password"    , "Open/Edit", "Delete"))
tblUsers.SetHeaderThemes(    Array As String ("bg"  ,"bg"      , "bg"      , "bg"       ,"bg"           , "bgc"      , "bgc"   ))
tblUsers.SetColumnVisible(   Array As Boolean(False, True      , True      , True       , True          , True       , True    ))
tblUsers.SetColumnSortable(  Array As Boolean(False, True      , True      , True       , True          , False      , False   ))
tblUsers.SetColumnDataFields(Array As String (""   , "UserType", "UserName", "UserLogin", "UserPassword", ""         , ""      ))
		
tblUsers.SetFooter("Total number of users: 0", 12,"bg")

[NEW] ABMPagination allows you to use pages (e.g for tables, but it can be used for a lot more). Check the ABMFeedback code to see how it is used.
--------------------------------------------------------------------------------------------------------------------------------------------------
Dim pagination As ABMPagination
pagination.Initialize(page, "pagination", 10, True, True, "")
pagination.SetTotalNumberOfPages(0)

Sub pagination_PageChanged(OldPage As Int, NewPage As Int)
	' do your stuff
		
End Sub

[NEW] ABMTreeTable is a component to create collapsable views.  It is more than a tree object, as it allows you to have columns.
--------------------------------------------------------------------------------------------------------------------------------------------------
Check the demo app for an example.  You'll need to download the jPDFJet library to run it as there is also a print example (could be used for simple reports).
This object is still in development as we will use it a lot in our apps internally.  

[FIX] TextArea has some issues showing the correct value.  
--------------------------------------------------------------------------------------------------------------------------------------------------
It is kind of a weird object, known for such problems so we'll if this is fixed now

[FIX] ABMUpload in modal sheet
--------------------------------------------------------------------------------------------------------------------------------------------------
Now works in a modal sheet.

[NEW] ABMCombo setting/getting value has been changed.  
--------------------------------------------------------------------------------------------------------------------------------------------------
.Text is gone and replaced by .SetActiveItemId() and .GetActiveItemId("") where you set/get the current selected value by its key.

Happy programming!

Alain
Alwaysbusy's Corner
	