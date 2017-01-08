Type=StaticCode
Version=2.51
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Code module

Sub Process_Globals
	Private aSubName As String
	Private aModule As Object
	Private aLIV As LoadingIndicatorView
	Private aRF As Object
End Sub

'Sets the RefreshControl to a TV
'Pass Null for LIV to use the default RefreshControl

'Events:
'Sub EventName_Refreshing
Public Sub SetToTV(Module As Object, EventName As String,TV As TableView,LIV As LoadingIndicatorView)
	aModule = Module
	aSubName = EventName
	aLIV = LIV
	CallSubDelayed2(Me,"AddRefresh",TV)
End Sub

Public Sub EndRefreshing
	If aLIV.IsInitialized Then aLIV.StopAnimating
		
	Dim NaObj As NativeObject= aRF
    NaObj.RunMethod("endRefreshing",Null)
End Sub

Private Sub AddRefresh (TableView As TableView)
	Dim NativeMe As NativeObject=Me 
	NativeMe.RunMethod("AddRefresh::",Array(TableView,aLIV.IsInitialized))
End Sub

Private Sub AddIndicator(aRefreshControl As Object)
	Dim V As View = aRefreshControl
	Dim pn As Panel
	pn.Initialize("")
	pn.Width = V.Width
	pn.Height = V.Height
	
	aLIV.Size = V.Height - 20
	
	pn.AddView(aLIV,(V.Width - aLIV.Width)/2,(V.Height - aLIV.Height)/2,aLIV.Width,aLIV.Height)
	
	Dim NaObj As NativeObject = V
	NaObj.RunMethod("addSubview:",Array(pn))
	
	aLIV.Visible = True
End Sub

Private Sub aRefreshing(RF As Object)
	aRF = RF
	If aLIV.IsInitialized Then aLIV.StartAnimating
	CallSubDelayed(aModule,aSubName & "_Refreshing")
End Sub

#IF OBJC

-(void)AddRefresh: (UITableView*)tbl :(BOOL)B{
    UITableViewController *tableViewController = [[UITableViewController alloc] init];
    tableViewController.tableView = tbl;
    UIRefreshControl *refreshControl = [[UIRefreshControl alloc] init];
    [refreshControl addTarget:self action:@selector(refresh:) forControlEvents:UIControlEventValueChanged];
	tableViewController.refreshControl = refreshControl;
	if (B){
		refreshControl.tintColor = [UIColor clearColor];
		[self.bi raiseEvent:nil event:@"addindicator:" params:@[refreshControl]];
	}
}

- (void)refresh:(id)sender {
    UIRefreshControl *refreshControl=sender;
    [self.bi raiseUIEvent:nil event:@"arefreshing:" params:@[(refreshControl)]];
}
#END IF