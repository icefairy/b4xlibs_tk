Type=Class
Version=1.8
ModulesStructureVersion=1
B4i=true
@EndOfDesignText@
'Class module


'''' VERSION : 1.1


Sub Class_Globals
	Private mEventName As String
	Private mHandler As Object
	Public mView As View
	Private nome As NativeObject=Me
	Private Const mSwipeDirectionLeft=2
	Private Const mSwipeDirectionRight=1
	Private Const mSwipeDirectionUp=4
	Private Const mSwipeDirectionDown=8
	
	Private Const mEDGE_Left=2
	Private Const mEDGE_Top=1
	Private Const mEDGE_Right=8
	Private Const mEDGE_Bottom=4
	
	Private Const mSTATE_Begin=1
	Private Const mSTATE_Changed=2
	Private Const mSTATE_End=3

Type Pinch_Attributes (Velocity As Float, Scale As Float, X As Float, Y As Float, Obj As Object)
Type Rotation_Attributes (Velocity As Float, Rotation As Float, X As Float, Y As Float, Obj As Object)
Type Swipe_Attributes (Direction As Int, X As Float, Y As Float, Obj As Object)
Type ScreenEdgePan_Attributes(Edge As Int, X As Float, Y As Float, Obj As Object)
Type Tap_Attributes(NumberOfTaps As Int, NumberOfTouch As Int, X As Float, Y As Float, Obj As Object)
Type LongPress_Attributes(NumberOfTaps As InputStream, NumberOfTouch As Int, X As Float, Y As Float, Obj As Object)
Type Pan_Attributes(X As Float,Y As Float, Obj as Object)
End Sub

'Initializes the object. You can add parameters to this method if needed.
Public Sub Initialize(EventName As String,Handler As Object,V As View)
mEventName=EventName
mHandler=Handler
mView=V
End Sub

Sub AddTapGesture(NumberOfTaps As Int,NumberOfTouch As Int)
nome.RunMethod("grTap:::",Array(NumberOfTaps,NumberOfTouch,mView))
End Sub

Sub AddPinchGesture
nome.RunMethod("grPinch:",Array(mView))
End Sub

Sub AddRotationGesture
nome.RunMethod("grRotation:",Array(mView))
End Sub

Sub AddSwipeGesture(NumberOfTouch As Int,Direction As Int)
nome.RunMethod("grSwipe:::",Array(mView,NumberOfTouch,Direction))
End Sub

Sub AddScreenEdgePanGesture(Edge As Int)
nome.RunMethod("grScreenEdge::",Array(mView,Edge))
End Sub

Sub AddLongPressGesture(NumberOfTaps As Int, NumberOfTouch As Int,Duration As Float)
nome.RunMethod("grLongPress::::",Array(NumberOfTaps,NumberOfTouch,Duration,mView))
End Sub

Sub AddPanGesture(MinimumTouch As Int, MaximumTouch As Int)
nome.RunMethod("grPan:::",Array(mView,MinimumTouch,MaximumTouch))
End Sub

Sub getSWIPE_Direction_Left As Int
Return mSwipeDirectionLeft
End Sub

Sub getSWIPE_Direction_Right As Int
Return mSwipeDirectionRight
End Sub

Sub getSWIPE_Direction_Up As Int
Return mSwipeDirectionUp
End Sub

Sub getSWIPE_Direction_Down As Int
Return mSwipeDirectionDown
End Sub

Sub getEDGE_Top As Int
Return mEDGE_Top
End Sub

Sub getEDGE_Left As Int
Return mEDGE_Left
End Sub

Sub getEDGE_Right As Int
Return mEDGE_Right
End Sub

Sub getEDGE_Bottom As Int
Return mEDGE_Bottom
End Sub

Sub getSTATE_Begin As Int
Return mSTATE_Begin
End Sub

Sub getSTATE_Changed As Int
Return mSTATE_Changed
End Sub

Sub getSTATE_End As Int
Return mSTATE_End
End Sub

Private Sub uigesture_tap(state As Int,numTaps As Int, numTouch As Int, x As Float, y As Float, obj As Object)
Dim att As  Tap_Attributes
att.NumberOfTaps=numTaps
att.NumberOfTouch=numTouch
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_Tap",2) Then
CallSub3(mHandler,mEventName & "_Tap",state,att)
End If
End Sub

Private Sub uigesture_pinch(scale As Float,velocity As Float,state As Int, x As Float,y As Float,obj As Object)
Dim att As  Pinch_Attributes
att.scale=scale
att.velocity=velocity
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_Pinch",2) Then
CallSub3(mHandler,mEventName & "_Pinch",state,att)
End If
End Sub

Private Sub uigesture_rotation(rotation As Float,velocity As Float,state As Int, x As Float, y As Float, obj As Object)
Dim att As  Rotation_Attributes
att.velocity=velocity
att.rotation=rotation
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_Rotation",2) Then
CallSub3(mHandler,mEventName & "_Rotation",state,att)
End If
End Sub

Private Sub uigesture_swipe(state As Int,direction As Int, x As Float, y As Float,obj As Object)
Dim att As  Swipe_Attributes
att.direction=direction
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_Swipe",2) Then
CallSub3(mHandler,mEventName & "_Swipe",state,att)
End If
End Sub

Private Sub uigesture_screenedgepan(state As Int, edge As Int, x As Float,y As Float, obj As Object)
Dim att As  ScreenEdgePan_Attributes
att.edge=edge
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_ScreenEdgePan",2) Then
CallSub3(mHandler,mEventName & "_ScreenEdgePan",state,att)
End If
End Sub

Private Sub uigesture_longpress(state As Int,numtouch As Int, Numtaps As Int, x As Float, y As Float, obj As Object)
Dim att As  LongPress_Attributes
att.NumberOfTaps=Numtaps
att.NumberOfTouch=numtouch
att.x=x
att.y=y
att.Obj=obj
If SubExists(mHandler,mEventName & "_LongPress",2) Then
CallSub3(mHandler,mEventName & "_LongPress",state,att)
End If
End Sub

Private Sub uigesture_pan(state As Int,x As Float, y As Float, obj As Object)
Dim att As  Pan_Attributes
att.x=x
att.y=y
att.obj=obj
If SubExists(mHandler,mEventName & "_Pan",2) Then
CallSub3(mHandler,mEventName & "_Pan",state,att)
End If
End Sub




#If OBJC

/////////TAP//////////

- (BOOL)gestureRecognizer:(UIGestureRecognizer *)gestureRecognizer shouldRecognizeSimultaneouslyWithGestureRecognizer:(UIGestureRecognizer *)otherGestureRecognizer
{
     return TRUE;
}

-(void)grTap: (int)numtaps :(int)numtouch :(UIView*)v
{
UITapGestureRecognizer *Tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(handleTap:)];
Tap.delegate=self;
[Tap setNumberOfTapsRequired:numtaps];
[Tap setNumberOfTouchesRequired:numtouch];


[v addGestureRecognizer:Tap];
}

- (void)handleTap:(UITapGestureRecognizer *)gestureRecognizer {  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;


	int st =gestureRecognizer.state;
    int numtouch =gestureRecognizer.numberOfTouchesRequired;
    int numtap =gestureRecognizer.numberOfTapsRequired;
    [self.bi raiseEvent:nil event:@"uigesture_tap::::::" params:@[@((int)st),@((int)numtap),@((int)numtouch),@((float)x),@((float)y),(gestureRecognizer)]];

  }  


////////////PINCH/////////////

-(void)grPinch :(UIView*)v
{
UIPinchGestureRecognizer *pinch = [[UIPinchGestureRecognizer alloc] initWithTarget:self  action:@selector(handlePinch:)];
 pinch.delegate=self;
 [v addGestureRecognizer:pinch];

}

- (void)handlePinch:(UIPinchGestureRecognizer *)gestureRecognizer 
{  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

	float sc=gestureRecognizer.scale;
	float vl=gestureRecognizer.velocity;
	int st =gestureRecognizer.state;
    [self.bi raiseEvent:nil event:@"uigesture_pinch::::::" params:@[@((float)sc),@((float)vl),@((int)st),@((float)x),@((float)y),(gestureRecognizer)]];


  }  
  

  
  
//////// ROTATION /////////////

-(void)grRotation :(UIView*)v
{
UIRotationGestureRecognizer *Rotation = [[UIRotationGestureRecognizer alloc] initWithTarget:self  action:@selector(handleRotation:)];
 Rotation.delegate=self;
 [v addGestureRecognizer:Rotation];

}

- (void)handleRotation:(UIRotationGestureRecognizer *)gestureRecognizer 
{  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

	float rt=gestureRecognizer.rotation;
	float vl=gestureRecognizer.velocity;
	int st =gestureRecognizer.state;
    [self.bi raiseEvent:nil event:@"uigesture_rotation::::::" params:@[@((float)rt),@((float)vl),@((int)st),@((float)x),@((float)y),(gestureRecognizer)]];


  }  
  
  
///////////// SWIPE //////////////

-(void)grSwipe :(UIView*)v :(int)numtouch :(int)dir
{
UISwipeGestureRecognizer *swipe = [[UISwipeGestureRecognizer alloc] initWithTarget:self  action:@selector(handleSwipe:)];
 
// if (dir==1)
// {
  [swipe setDirection:dir];

// }
 
 
 [swipe setNumberOfTouchesRequired:numtouch];
  swipe.delegate=self;
 [v addGestureRecognizer:swipe];

}


- (void)handleSwipe:(UISwipeGestureRecognizer *)gestureRecognizer {  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

	int st =gestureRecognizer.state;
	int dir=gestureRecognizer.direction;

    [self.bi raiseEvent:nil event:@"uigesture_swipe:::::" params:@[@((int)st),@((int)dir),@((float)x),@((float)y),(gestureRecognizer)]];

  }  

/////////// PAN ///////////

-(void)grPan :(UIView*)v :(int)mintouch :(int)maxtouch
{
UIPanGestureRecognizer *pan = [[UIPanGestureRecognizer alloc] initWithTarget:self  action:@selector(handlePan:)];
 
 [pan setMaximumNumberOfTouches:maxtouch];
 [pan setMinimumNumberOfTouches:mintouch];
pan.delegate=self;
 [v addGestureRecognizer:pan];

}

- (void)handlePan:(UIPanGestureRecognizer *)gestureRecognizer {  

	int st =gestureRecognizer.state;
float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

    [self.bi raiseEvent:nil event:@"uigesture_pan::::" params:@[@((int)st),@((float)x),@((float)y),(gestureRecognizer)]];

  }  

///////////// SCREEN EDGE ///////////

-(void)grScreenEdge :(UIView*)v :(int)dir 
{
UIScreenEdgePanGestureRecognizer *panEdge = [[UIScreenEdgePanGestureRecognizer alloc] initWithTarget:self  action:@selector(handlePanEdge:)];
 
 [panEdge setEdges:dir];
 [v addGestureRecognizer:panEdge];

}

- (void)handlePanEdge:(UIScreenEdgePanGestureRecognizer *)gestureRecognizer {  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

	int st =gestureRecognizer.state;
	int ed =[gestureRecognizer edges];
    [self.bi raiseEvent:nil event:@"uigesture_screenedgepan:::::" params:@[@((int)st),@((int)ed),@((float)x),@((float)y),(gestureRecognizer)]];

  }  
  
  
  
///////////LONG PRESS////////


-(void)grLongPress: (int)numtaps :(int)numtouch :(float)interval :(UIView*)v
{
UILongPressGestureRecognizer *longpress = [[UILongPressGestureRecognizer alloc] initWithTarget:self action:@selector(handleLongPress:)];

[longpress setNumberOfTapsRequired:numtaps];
[longpress setNumberOfTouchesRequired:numtouch];
[longpress setMinimumPressDuration:interval];
longpress.delegate=self;
[v addGestureRecognizer:longpress];
}

- (void)handleLongPress:(UILongPressGestureRecognizer *)gestureRecognizer {  

float x= [gestureRecognizer locationInView:(self._mview).object].x;
float y= [gestureRecognizer locationInView:(self._mview).object].y;

	int st =gestureRecognizer.state;
	int numtouch =gestureRecognizer.numberOfTouchesRequired;
    int numtap =gestureRecognizer.numberOfTapsRequired;
    [self.bi raiseEvent:nil event:@"uigesture_longpress::::::" params:@[@((int)st),@((int)numtouch),@((int)numtap),@((float)x),@((float)y),(gestureRecognizer)]];
  }  

#End If