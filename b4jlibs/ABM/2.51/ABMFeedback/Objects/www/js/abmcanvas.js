

var ABMCanvas = function(theCanvas, context, bgColor, scalefit){
    this.context = context;
	this.theCanvas = theCanvas;
	var bgColor = bgColor;
	var scalefit = scalefit;
	var innerScale=1;
	
	var cw=theCanvas.width;
	var ch=theCanvas.height;
			
	init();
	
	var numShapes;
	var shapes;
	var dragIndex;
	var dragType;
	var dragging;
	var mouseX;
	var mouseY;
	var dragHoldX;
	var dragHoldY;
	var timer;
	var targetX;
	var targetY;
	var easeAmount;	
	
	function init() {
		numShapes = 0;
		easeAmount = 0.45; //0.20;		
		
		shapes = [];
		
		theCanvas.addEventListener("mousedown", handleMouseDown, false);
		theCanvas.addEventListener("touchstart", handleTouchDown, false);		
		window.addEventListener("mousemove", handleMouseMove, false);
		theCanvas.addEventListener("touchmove", handleTouchMove, false);		
	}	
	
	this.updatecanvas = function(params, dodraw) {	
		for (var nn=0;nn<params.length;nn++) {
			var operation = params[nn];			
			var tempShape;
			switch (operation[0]) {
				case "0": // add
					if (operation[2]==0) { // rect
						tempShape = {type: 0, id: operation[1], x:operation[5], y:operation[6], width:operation[7], height:operation[8], draggable:operation[10], draggableL:operation[11], draggableT:operation[12], draggableW:operation[13], draggableH:operation[14], commands: operation[15], canvasid: operation[16]};
					} else { // circle
						tempShape = {type: 1, id: operation[1], x:operation[5], y:operation[6], rad:operation[9], draggable:operation[10], draggableL:operation[11], draggableT:operation[12], draggableW:operation[13], draggableH:operation[14], commands: operation[15], canvasid: operation[16]};
					}
					shapes.push(tempShape);
					numShapes = shapes.length; 
					break;
				case "1": // update
					for (i=0; i < numShapes; i++) {
						if(shapes[i].id==operation[1]) {
							if (operation[3]) {
								shapes[i].x = operation[5];
							}
							if (operation[4]) {
								shapes[i].y = operation[6];
							}
							shapes[i].commands=operation[15];
							break;
						}
					}					
					break;
				case "2": // remove
					for (i=0; i < numShapes; i++) {
						if(shapes[i].id==operation[1]) {
							shapes.splice(i,1);
							break;
						}
					}
					numShapes = shapes.length; 
					break;
			}
			if (dodraw) {
				draw();
			}
		}
	}
	
	this.getposition = function(id) {
		var i;
		for (i=0; i < numShapes; i++) {
			if(shapes[i].id==id) {
				return shapes[i].x + ";" + shapes[i].y;
			}			
		}
		return "";
	}
	
	this.drawcanvas = function() {
		draw();
	}
	
	function handleMouseDown(evt) {
		var bRect = theCanvas.getBoundingClientRect();
		mouseX = (evt.clientX - bRect.left)*(theCanvas.width/bRect.width);
		mouseY = (evt.clientY - bRect.top)*(theCanvas.height/bRect.height);
		mouseDownListener(mouseX, mouseY,evt);
	}
	
	function handleTouchDown(evt) {
		var bRect = theCanvas.getBoundingClientRect();
		mouseX = (evt.touches[0].clientX - bRect.left)*(theCanvas.width/bRect.width);
		mouseY = (evt.touches[0].clientY - bRect.top)*(theCanvas.height/bRect.height);
		mouseDownListener(mouseX, mouseY,evt);
	}
	
	function mouseDownListener(mouseX, mouseY, evt) {
		var i;
		
		//getting mouse position correctly 
						
		//find which shape was clicked
		for (i=0; i < numShapes; i++) {
			if	(hitTest(shapes[i], mouseX, mouseY)) {
				dragging = true;
				//the following variable will be reset if this loop repeats with another successful hit:
				dragIndex = i;
				dragType=shapes[i].type;				
			}
		}
		
		if (dragging) {			
			//We now place the currently dragged shape on top by reordering the array which holds these objects.
			//We 'splice' out this array element, then 'push' it back into the array at the end.
			shapes.push(shapes.splice(dragIndex,1)[0]);
			
			//shape to drag is now last one in array. We read record the point on this object where the mouse is "holding" it:
			dragHoldX = mouseX - shapes[numShapes-1].x;
			dragHoldY = mouseY - shapes[numShapes-1].y;
			
			//The "target" position is where the object should be if it were to move there instantaneously. But we will
			//set up the code so that this target position is approached gradually, producing a smooth motion.
			targetX = mouseX - dragHoldX;
			targetY = mouseY - dragHoldY;
			
			//start timer
			timer = setInterval(onTimerTick, 1000/30);
			b4j_raiseEvent('page_parseevent', {'eventname': shapes[numShapes-1].canvasid + '_objectdown','eventparams': 'objectid', 'objectid': shapes[numShapes-1].id});
		} else {	
			if (numShapes>0) {
				b4j_raiseEvent('page_parseevent', {'eventname': shapes[numShapes-1].canvasid + '_canvasdown','eventparams': 'x,y', 'x': parseInt(mouseX,10), 'y': parseInt(mouseY,10)});			
			}
		}
		theCanvas.removeEventListener("mousedown", handleMouseDown, false);
		theCanvas.removeEventListener("touchstart", handleTouchDown, false);
		window.addEventListener("mouseup", mouseUpListener, false);
		window.addEventListener("touchend", mouseUpListener, false);
		
		//code below prevents the mouse down from having an effect on the main browser window:
		if (evt.preventDefault) {
			evt.preventDefault();
		} //standard
		else if (evt.returnValue) {
			evt.returnValue = false;
		} //older IE
		return false;
	}
	
	function onTimerTick() {
		/*
		Because of reordering, the dragging shape is the last one in the array.
		The code below moves this shape only a portion of the distance towards the current "target" position, and 
		because this code is being executed inside a function called by a timer, the object will continue to
		move closer and closer to the target position.
		The amount to move towards the target position is set in the parameter 'easeAmount', which should range between
		0 and 1. The target position is set by the mouse position as it is dragging.		
		*/
		shapes[numShapes-1].x = shapes[numShapes-1].x + easeAmount*(targetX - shapes[numShapes-1].x);
		shapes[numShapes-1].y = shapes[numShapes-1].y + easeAmount*(targetY - shapes[numShapes-1].y);
		
		//stop the timer when the target position is reached (close enough)
		if ((!dragging)&&(Math.abs(shapes[numShapes-1].x - targetX) < 0.1) && (Math.abs(shapes[numShapes-1].y - targetY) < 0.1)) {
			shapes[numShapes-1].x = targetX;
			shapes[numShapes-1].y = targetY;
			//stop timer:
			clearInterval(timer);
		}
		draw();
	}
	
	function mouseUpListener(evt) {
		theCanvas.addEventListener("mousedown", handleMouseDown, false);
		theCanvas.addEventListener("touchstart", handleTouchDown, false);
		window.removeEventListener("mouseup", mouseUpListener, false);
		window.removeEventListener("touchend", mouseUpListener, false);
		if (dragging) {
			dragging = false;
			b4j_raiseEvent('page_parseevent', {'eventname': shapes[numShapes-1].canvasid + '_objectup','eventparams': 'objectid', 'objectid': shapes[numShapes-1].id});		
		} else {
			if (numShapes>0) {
				b4j_raiseEvent('page_parseevent', {'eventname': shapes[numShapes-1].canvasid + '_canvasup','eventparams': 'x,y', 'x': parseInt(mouseX,10), 'y': parseInt(mouseY,10)});
			}
		}
	}

	function handleMouseMove(evt) {
		var bRect = theCanvas.getBoundingClientRect();
		mouseX = (evt.clientX - bRect.left)*(theCanvas.width/bRect.width);
		mouseY = (evt.clientY - bRect.top)*(theCanvas.height/bRect.height);
		mouseMoveListener(mouseX, mouseY);
	}
	
	function handleTouchMove(evt) {
		var bRect = theCanvas.getBoundingClientRect();
		mouseX = (evt.touches[0].clientX - bRect.left)*(theCanvas.width/bRect.width);
		mouseY = (evt.touches[0].clientY - bRect.top)*(theCanvas.height/bRect.height);
		mouseMoveListener(mouseX, mouseY);
	}
	
	function mouseMoveListener(mouseX, mouseY) {
		
	
		var foundobj=false;
		for (i=0; i < numShapes; i++) {			
			if	(hitTest(shapes[i], mouseX, mouseY)) {
				theCanvas.style.cursor = 'pointer';
				foundobj=true;
				break;
			}			
		}
		if (!foundobj) {
			theCanvas.style.cursor = 'default';
		}
		if (dragging) {
			var posX;
			var posY;
			var shapeRad;
			var minX;
			var maxX;
			var minY;
			var maxY;
			if (dragType==0) {
				minX = 0;
				maxX = theCanvas.width - shapes[numShapes-1].width;
				minY = 0;
				maxY = theCanvas.height - shapes[numShapes-1].height;
			} else {
				shapeRad = shapes[numShapes-1].rad;
				minX = shapeRad;
				maxX = theCanvas.width - shapeRad;
				minY = shapeRad;
				maxY = theCanvas.height - shapeRad;
			}			
		
			//clamp x and y positions to prevent object from dragging outside of canvas
			posX = mouseX - dragHoldX;
			posX = (posX < minX) ? minX : ((posX > maxX) ? maxX : posX);
			posY = mouseY - dragHoldY;
			posY = (posY < minY) ? minY : ((posY > maxY) ? maxY : posY);
			
			if (shapes[numShapes-1].draggableW>0) {
				var dL = shapes[numShapes-1].draggableL;
				var dT = shapes[numShapes-1].draggableT;
				var dR = dL + shapes[numShapes-1].draggableW;
				var dB = dT + shapes[numShapes-1].draggableH;
				posX = (posX < dL) ? dL : ((posX > dR) ? dR : posX);
				posY = (posY < dT) ? dT : ((posY > dB) ? dB : posY);
			}
		
			targetX = posX;
			targetY = posY;
		}
	}
	
	
	
	function hitTest(shape,mx,my) {
		if (shape.draggable) {		
			if (shape.type==0) { // rect
				return((mx > shape.x)&&(mx < shape.x + shape.width)&&(my > shape.y)&&(my < shape.y + shape.height));
			} else { // circle
				var dx = mx - shape.x;
				var dy = my - shape.y;
				var ret = (dx*dx + dy*dy < shape.rad*shape.rad)
				return ret;
			}
		}	
		return false;
	}
	
	function draw() {
		//theCanvas.width = theCanvas.width;
		context.setTransform(1, 0, 0, 1, 0, 0);
		if (bgColor=="transparent") {
			context.clearRect(0,0,cw,ch);
		} else {
			context.fillStyle = bgColor;
			context.fillRect(0,0,cw,ch);		
		}
		var i;
		numShapes = shapes.length;
		for (i=0; i < numShapes; i++) {
			var shape = shapes[i];	
			var x = shape.x;
			var y = shape.y;			
			//console.log(x + " " + y);
			var commands = shape.commands;
			for (var nn=0;nn<commands.length;nn++) {
				var command = commands[nn];		
				switch (command[0]) {				
					case 1: // fillstylecolor
						context.fillStyle = command[1];
						break;
					case 2: // fillstylelineargradient
						var grd=context.createLinearGradient(command[1]+x,command[2]+y,command[3]+x,command[4]+y);
						for (var n=0;n<command[5].length;n++) {
							grd.addColorStop(command[5][n],command[6][n]);
						}
						context.fillStyle = grd;
						break;
					case 3: //fillStyleRadialGradient
						var grd=context.createRadialGradient(command[1]+x,command[2]+y,command[3],command[4]+x,command[5]+y,command[6]);
						for (var n=0;n<command[7].length;n++) {
							grd.addColorStop(command[7][n],command[8][n]);
						}
						context.fillStyle = grd;
						break;
					case 4: // strokestylecolor
						context.strokeStyle = command[1];
						break;
					case 5: // strokestylelineargradient
						var grd=context.createLinearGradient(command[1]+x,command[2]+y,command[3]+x,command[4]+y);
						for (var n=0;n<command[5].length;n++) {
							grd.addColorStop(command[5][n],command[6][n]);
						}
						context.strokeStyle = grd;
						break;	
					case 6: //strokeStyleRadialGradient
						var grd=context.createRadialGradient(command[1]+x,command[2]+y,command[3],command[4]+x,command[5]+y,command[6]);
						for (var n=0;n<command[7].length;n++) {
							grd.addColorStop(command[7][n],command[8][n]);
						}
						context.strokeStyle = grd;
						break;	
					case 7: // shadowBlur
						content.shadowBlur = command[1];
						break;
					case 8: // shadowColor
						content.shadowColor = command[1];
						break;						
					case 9: // shadowOffsetX
						context.shadowOffsetX = command[1];
						break;
					case 10: // shadowOffsetY
						context.shadowOffsetY = command[1];
						break;
					case 11: // lineCap
						context.lineCap = command[1];
						break;
					case 12: // lineJoin
						context.lineJoin = command[1];
						break;
					case 13: // lineWidth
						context.lineWidth = command[1];
						break;
					case 14: // miterLimit
						context.miterLimit = command[1];
						break;
					case 15: // rect						
						context.rect(command[1]+x, command[2]+y, command[3], command[4]);
						break;
					case 16: // fillrect						
						context.fillRect(command[1]+x, command[2]+y, command[3], command[4]);
						break;
					case 17: // strokerect					
						context.strokeRect(command[1]+x, command[2]+y, command[3], command[4]);
						break;
					case 18: // clearRect				
						context.clearRect(command[1]+x, command[2]+y, command[3], command[4]);
						break;
					case 19: // fill				
						context.fill();
						break;
					case 20: // stroke				
						context.stroke();
						break;
					case 21: // beginPath			
						context.beginPath();
						break;
					case 22: // moveTo				
						context.moveTo(command[1]+x, command[2]+y);
						break;
					case 23: // closePath				
						context.closePath();
						break;
					case 24: // lineTo				
						context.lineTo(command[1]+x, command[2]+y);
						break;
					case 25: // stroke				
						context.clip();
						break;
					case 26: // quadraticCurveTo				
						context.quadraticCurveTo(command[1]+x, command[2]+y, command[3]+x, command[4]+y);
						break;
					case 27: // bezierCurveTo				
						context.bezierCurveTo(command[1]+x, command[2]+y, command[3]+x, command[4]+y, command[5]+x, command[6]+y);
						break;
					case 28: // arc	
						context.arc(command[1]+x, command[2]+y, command[3], command[4], command[5]);
						break;
					case 29: // arcTo		
						context.arcTo(command[1]+x, command[2]+y, command[3]+x, command[4]+y, command[5]);
						break;
					case 30: // scale				
						context.scale(command[1], command[2]);
						break;
					case 31: // rotate				
						context.rotate(command[1]);
						break;
					case 32: // translate				
						context.translate(command[1], command[2]);
						break;
					case 33: // transform				
						context.transform(command[1], command[2], command[3], command[4], command[5], command[6]);
						break;
					case 34: // settransform				
						context.setTransform(command[1], command[2], command[3], command[4], command[5], command[6]);
						break;
					case 35: // font
						context.font = command[1];
						break;		
					case 36: // textAlign
						context.textAlign = command[1];
						break;	
					case 37: // textBaseLine
						context.textBaseline = command[1];
						break;
					case 38: // fillText
						context.fillText(command[1], command[2]+x, command[3]+y, command[4]);
						break;
					case 39: // strokeText
						context.strokeText(command[1], command[2]+x, command[3]+y, command[4]);
						break;
					case 40: // drawImage		
						if (images[command[1]]) {
							if (images[command[1]].complete) {							
								context.drawImage(images[command[1]], command[2]+x, command[3]+y);
							}
						} else {
							console.log("image '" + command[1] + "' must be loaded in BuildPage()!");
						}
						break;
					case 41: // drawimage2
						if (images[command[1]]) {
							if (images[command[1]].complete) {	
								context.drawImage(images[command[1]], command[2]+x, command[3]+y, command[4], command[5]);
							}
						} else {
							console.log("image '" + command[1] + "' must be loaded in BuildPage()!");
						}
						break;
					case 42: // drawimage3
						if (images[command[1]]) {
							if (images[command[1]].complete) {	
								context.drawImage(images[command[1]], command[2], command[3], command[4], command[5],command[6]+x, command[7]+y, command[8], command[9]);	
							}
						} else {
							console.log("image '" + command[1] + "' must be loaded in BuildPage()!");
						}
						break;
					case 43: // globalAlpha
						context.globalAlpha = command[1];
						break;
					case 44: // globalCompositeOperation
						context.globalCompositeOperation = command[1];
						break;
					case 45: // save
						context.save();
						break;
					case 46: // restore
						context.restore();
						break;
					case 47: // arc2			
						context.arc(command[1]+x, command[2]+y, command[3], command[4], command[5], command[6]);
						break;
				}
			}
		}
	}
};