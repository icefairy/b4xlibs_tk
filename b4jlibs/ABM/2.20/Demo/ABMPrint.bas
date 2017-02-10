Type=StaticCode
Version=4.7
ModulesStructureVersion=1
B4J=true
@EndOfDesignText@
'
Sub Process_Globals
'	Dim PDFjetConstants1 As PDFjetConstants
'	' to access the constants
'	Private ABM As ABMaterial 'ignore	
'	Type RenderImage(row As Int, cellId As String)
'	Private cObject As Object
'	Private IsWorking As Boolean
End Sub

'Sub PrintToPDF(page As ABMPage, callObject As Object, Theme As ABMTheme, ThemeName As String, TreeTable As ABMTreeTable, dir As String, fileName As String)
'	If IsWorking Then Return
'	cObject = callObject
'	IsWorking = True
'	
'	Dim TOP_MARGIN As Int = 25
'    Dim LEFT_MARGIN As Int = 25
'	Dim DefaultfontSize As Float = 10
'	
'	Dim PDFjetPDF1 As PDFjetPDF
'	Dim PDFDestination As OutputStream
'	PDFDestination=File.OpenOutput(dir, "/www/demo/PDF/" & fileName, False)
'	
'	PDFjetPDF1.Initialize("PDFjetPDF1", PDFDestination)
'	PDFjetPDF1.SetAuthor("OneTwo")
'	PDFjetPDF1.SetSubject("OneTwo Report")
'		
'	Dim PDFPage As PDFjetPage
'	PDFPage.Initialize(PDFjetPDF1, PDFjetConstants1.PageSize.A4_PORTRAIT)
'	
'	Dim Scale As Float =  PDFPage.GetWidth / (TreeTable.ColWidthPx*TreeTable.TotalColSpan + LEFT_MARGIN*2)
'	If Scale > 1 Then Scale = 1
'	DefaultfontSize = DefaultfontSize * Scale
'	Dim BlockWidth As Float = TreeTable.ColWidthPx*Scale
'	
'	Dim PDFFont As PDFjetFont
'	PDFFont.Initialize(PDFjetPDF1, PDFjetConstants1.CoreFont.HELVETICA)
'	PDFFont.SetSize(DefaultfontSize)
'	
''	Dim InputFile As InputStream=File.OpenInput(File.DirAssets, "ConnectCode39.ttf") ' op de Z drive, in de root
''	Dim cp As PDFjetCodePage
''	Dim PDFFont2 As PDFjetFont
''	PDFFont2.Initialize4(PDFjetPDF1,InputFile ,cp.UNICODE,True )
'			
'	Dim PDFTable As PDFjetTable
'	PDFTable.Initialize
'	
'	Dim TableData1 As PDFjetTableData
'	TableData1.Initialize
'	
'	Dim PDFCell As PDFjetCell
'	Dim Row As PDFjetCellList
'	
'	TreeTable.ResetPDFStart(0)
'	Dim r As ABMtreeTableRow = TreeTable.NextPDFRow
'	Do While r <> Null		
'		Row.Initialize
'		For i=0 To r.cells.Size - 1
'			Dim c As ABMTreeTableCell = r.cells.Get(i)
'			PDFCell.Initialize2(PDFFont, c.GetCleanStringValue(page))
'			'PDFCell.Initialize2(PDFFont2, "*/012345*")
'			PDFCell.SetBottomPadding(2)
'			PDFCell.SetLeftPadding(2)
'			PDFCell.SetRightPadding(2)
'			PDFCell.SetTopPadding(2)
'			PDFCell.SetBgColor(ABM.GetColorInt(Theme.TreeTable(ThemeName).Cell(c.theme).BackColor, Theme.TreeTable(ThemeName).Cell(c.theme).BackColorIntensity))
'			
'			PDFCell.SetFgColor(ABM.GetColorInt(Theme.TreeTable(ThemeName).Cell(c.theme).ForeColor, Theme.TreeTable(ThemeName).Cell(c.theme).ForeColorIntensity))
'			Dim w As Int = BlockWidth*c.ColSpan
'			PDFCell.SetWidth(w)
'			PDFCell.SetNoBorders
'			
'			Select Case Theme.TreeTable(ThemeName).Cell(c.theme).Align
'				Case ABM.TABLECELL_HORIZONTALALIGN_LEFT
'					PDFCell.SetTextAlignment(PDFjetConstants1.Align.LEFT)	
'				Case ABM.TABLECELL_HORIZONTALALIGN_CENTER
'					PDFCell.SetTextAlignment(PDFjetConstants1.Align.CENTER)
'				Case ABM.TABLECELL_HORIZONTALALIGN_RIGHT
'					PDFCell.SetTextAlignment(PDFjetConstants1.Align.RIGHT)					
'			End Select
'			Select Case Theme.TreeTable(ThemeName).Cell(c.theme).VerticalAlign
'				Case ABM.TABLECELL_VERTICALALIGN_TOP
'					PDFCell.SetTextAlignment(PDFjetConstants1.TextAlign.TOP)		
'				Case ABM.TABLECELL_VERTICALALIGN_MIDDLE
'					PDFCell.SetTextAlignment(PDFjetConstants1.TextAlign.CENTER)		
'				Case ABM.TABLECELL_VERTICALALIGN_BOTTOM
'					PDFCell.SetTextAlignment(PDFjetConstants1.TextAlign.BOTTOM)		
'			End Select			
'			Row.Add(PDFCell)
'		Next
'		
'		TableData1.AddRow(Row)		
'		r = TreeTable.NextPDFRow
'	Loop
'	
'	
'	PDFTable.SetData(TableData1)
'	PDFTable.SetCellBordersWidth(0)
'	PDFTable.SetNoCellBorders
'	PDFTable.SetPosition(LEFT_MARGIN, TOP_MARGIN)
'	PDFTable.WrapAroundCellText
'	
''	Dim code As PDFjetBarCode
''	code.Initialize(code.CODE39, "/123456")
''	code.setPosition(LEFT_MARGIN, TOP_MARGIN)
''    code.setModuleLength(0.75)
''    code.setFont(PDFFont)
''    code.DrawOn(PDFPage)
'	
'	
'	Do While True
'		
'		PDFTable.DrawOn(PDFPage)
'		If Not(PDFTable.HasMoreData) Then
'			PDFTable.ResetRenderedPageCount
'			Exit
'		End If
'		PDFPage.Initialize(PDFjetPDF1, PDFjetConstants1.PageSize.A4_PORTRAIT)		
'	Loop
'	
'	PDFjetPDF1.Close	
'End Sub

'Sub PDFjetPDF1_CloseComplete(Success As Boolean)
'	If Success Then
'		Log("ok")	
'		CallSubDelayed(cObject, "PDFCreated")		
'	Else
'		Log("An error has occurred and creation of the PDF document has failed")
'	End If
'	
'	IsWorking = False
'End Sub




