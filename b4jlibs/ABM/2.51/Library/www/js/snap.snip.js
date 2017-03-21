/*
Snap.snip.js 0.17
This plugin will make Snap.svg a bit useful.
support version Snap.svg 0.2.0
tested on firefox/chrome only.

see http://www.h2.dion.ne.jp/~defghi/snapsvg/snapsnip.xhtml
http://defghi1977-onblog.blogspot.jp/

Copyright 2014 DEFGHI1977@xbox.live

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

"use strict";
/*
Snap.snip version
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var version = "0.17";
	Snap.snip = {};
	Snap.snip.toString = function(){
		return "Snap.snip v" + version + "/" + Snap.toString();
	};
});

/*
Extend attr method at stroke-dasharray property.
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var map = {
		"-"	   : [3,1],
		"."	   : [1,1],
		"-."   : [3,1,1,1],
		"-.."  : [3,1,1,1,1,1],
		". "   : [1,3],
		"- "   : [4,3],
		"--"   : [8,3],
		"- ."  : [4,3,1,3],
		"--."  : [8,3,1,3],
		"--.." : [8,3,1,3,1,3]
	};
	function setStrokeDasharray(value){
		var translated = map[value];
		if(translated){
			translated = translated.slice();
			var strokeWidth = +this.attr("stroke-width") || 1;
			for(var i = 0, len = translated.length; i<len; i++){				
				translated[i] *= strokeWidth;
			}
			eve.stop();
			this.node.style.strokeDasharray = translated.toString();
		}
	}
	eve.on("snap.util.attr.strokeDasharray", setStrokeDasharray)(-1);
	eve.on("snap.util.attr.stroke-dasharray", setStrokeDasharray)(-1);
});

/*
Element.setter(template)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	function push(obj, arr){
		var i = 0;
		for(var key in obj){
			obj[key] = arr[i];
			i++;
		}
	}
	function clone(template){
		var result = {};
		for(var key in template){
			result[key] = template[key];
		}
		return result;
	}
	Snap.setter = function(template, func, thisArg){
		func.call(thisArg, template);
		var c = clone(template);
		var f = function(){
			var i = 0;
			for(var key in c){
				if(c[key] != arguments[i]){
					push(c, arguments);
					func.call(thisArg, c);
					return;
				}
				i++;
			}
		};
		f.current = c;
		return f;
	}

	Element.prototype.setter = function(template){
		var f = Snap.setter(template, this.attr, this);
		f.element = this;
		return f;
	};
});

/*
Element.children()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.children = function(){
		var set = Snap.set();
		Array.prototype.forEach.call(this.node.childNodes, function(elem, i){
			set.push(Snap(elem));
		});
		return set;
	};
});

/*
Element.prev()
Element.next()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.prev = getWraper("previousElementSibling");
	Element.prototype.next = getWraper("nextElementSibling");
	
	function getWraper(attr){
		return function(){
			var node = this.node[attr];
			if(node){
				return Snap(node);
			}
		};
	}
});

/*
Element.replaceWith(elem)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.replaceWith = function(elem){
		return this.before(elem).remove();
	};
});

/*
Element.wrap(elem)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.wrap = function(elem){
		elem = typeof elem == "string" ? this.paper.el(elem) : Snap(elem);
		return this.before(elem).appendTo(elem);
	};
});

/*
Element.toFront()
Element.toBack()
Element.forward()
Element.backword()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.toFront = function(){
		return this.appendTo(this.parent());
	};
	Element.prototype.toBack = function(){
		return this.prependTo(this.parent());
	};
	Element.prototype.backward = function(){
		if(this.node.previousElementSibling){
			this.insertBefore(this.node.previousElementSibling);
		}
		return this;
	};
	Element.prototype.forward = function(){
		if(this.node.nextElementSibling){
			this.insertAfter(this.node.nextElementSibling);
		}
		return this;
	};
});

/*
Element.link(src, target)
Element.unlink()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.link = function(src, target){
		target = target || "";
		var a = this.type == "a" ? this : this.parent().type == "a" 
			? this.parent() : this.paper.el("a").before(this).append(this);
		a.node.href.baseVal = src;
		a.node.target.baseVal = target;
		return this;
	};
	Element.prototype.unlink = function(){
		var a = this.type == "a" ? this : this.parent().type == "a" 
			? this.parent() : null;
		if(!a){return this;}
		a.node.removeAttributeNS("http://www.w3.org/1999/xlink", "href");
		a.node.removeAttribute("target");
		return this;
	};
});

/*
Element.stack()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.stack = function(n){
		this.wrap("g").wrap("g");
		var main = this.parent().parent().attr({"group-type":"stack"});
		for(var i = 1; i<n; i++){
			main.append(this.use());
		}
		return main;
	};
});

/*
Element.snip(xcnt,ycnt,pathStr)
pathStr:tile shape on 10x10 size(default:rect)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.snip = function(xcnt,ycnt,pathStr,crisp){
		pathStr = pathStr || "M0,0h10v10h-10z";
		xcnt = xcnt || 2;
		ycnt = ycnt || 2;
		var bbox = this.getBBox();
		var main = this.stack(xcnt * ycnt);
		var children = main.children();
		var unitX = bbox.width/xcnt;
		var unitY = bbox.height/ycnt;
		var sx = unitX/10;
		var sy = unitY/10;
		var transformStr = "translate({0},{1}) scale({2},{3})";
		for(var j = 0; j<ycnt; j++){
			for(var i = 0; i<xcnt; i++){
				var x = bbox.x + unitX*i;
				var y = bbox.y + unitY*j;
				var path = this.paper.path(pathStr)
					.transform(Snap.format(transformStr, [x,y,sx,sy]));
				children[j * xcnt + i].attr({clipPath: path});
			}
		}
		return main;
	};
	Element.prototype.snipAt = function(x,y){
		var bbox = this.getBBox();
		var paper = this.paper;
		var rects = [];
		if(Snap.path.isPointInsideBBox(bbox, x, y)){
			rects.push(paper.rect(bbox.x, bbox.y, x - bbox.x, y - bbox.y));
			rects.push(paper.rect(x, bbox.y, bbox.x + bbox.width - x, y-bbox.y));
			rects.push(paper.rect(bbox.x, y, x - bbox.x, bbox.y + bbox.height - y));
			rects.push(paper.rect(x, y, bbox.x + bbox.width - x, bbox.y + bbox.height - y));
		}else if(bbox.x <= x && x <= bbox.x + bbox.width){
			rects.push(paper.rect(bbox.x, bbox.y, x - bbox.x, bbox.height));
			rects.push(paper.rect(x, bbox.y, bbox.x + bbox.width - x,bbox.height));
		}else if(bbox.y <= y && y <= bbox.y + bbox.height){
			rects.push(paper.rect(bbox.x, bbox.y, bbox.width, y - bbox.y));
			rects.push(paper.rect(bbox.x, y, bbox.width, bbox.y + bbox.height - y));
		}else{
			return;
		}
		var main = this.stack(rects.length);
		var children = main.children();
		rects.forEach(function(rect, i){
			children[i].attr({clipPath: rect});
		});
		return main;
	};
});

/*
Element.getStartPoint()
Element.getEndPoint()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.getStartPoint = function(){
		return this.getPointAtLength(0);
	};
	Element.prototype.getEndPoint = function(){
		return this.getPointAtLength(this.getTotalLength()-0.01);
	};
	Element.prototype.getPointAtRate = function(rate){
		return this.getPointAtLength(this.getTotalLength()*rate-0.01);
	};
});

/*
Paper.getSVGPoint(e)
Paper.getSVGPoint(clientX, clientY)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Paper.prototype.getSVGPoint = function(clientX, clientY){
		if(clientX instanceof Object){
			var e = clientX;
			clientX = e.clientX;
			clientY = e.clientY;
		}
		var m = new Snap.Matrix(this.node.getScreenCTM().inverse());
		return {x: m.x(clientX, clientY),y:m.y(clientX, clientY)};
	};
});

/*
Element.hide()
Element.show()
Set.hide()
Set.show()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	//var setproto = Snap.set().__proto__;
	var setproto = Snap.set().constructor.prototype;
	var hideParam = {display: "none"};
	var showParam = {display: "inline"};
	Element.prototype.hide = function(){
		return this.attr(hideParam);
	};
	setproto.hide = function(){
		return this.attr(hideParam);
	};
	Element.prototype.show = function(){
		return this.attr(showParam);
	};
	setproto.show = function(){
		return this.attr(showParam);
	};
});

/*
Snap.path.invert(pathStr)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.path.invert = function(path){
		//繝代せ譁・ｭ怜・縺ｮ蜀・ｮｹ繧呈ｭ｣隕丞喧
		path = Snap.path.toAbsolute(path);
		path = Snap.path.toCubic(path);
		//蜊倅ｸ縺ｮ繝代せ縺ｫ蛻・ｧ｣
		var singlePaths = path.toString().match(/M[^M]+/g);
		var result = [];
		result.toString = path.toString;
		for(var i = singlePaths.length-1; i>=0; i--){
			result = result.concat(invertSinglePath(singlePaths[i]));
		}
		return result;
	};
	function invertSinglePath(spath){
		var arr = Snap.parsePathString(spath);
		var result = [];
		var first = arr[0];
		var last = arr[arr.length-1];
		var z = last[0] == "z";
		if(arr.length == 1){
			//M縺縺代↓繧医ｋ菴咲ｽｮ繧ｹ繧ｭ繝・・
			result.push(first);
			return result;
		}else{
			if(z){
				result.push(["M", first[1], first[2]]);
			}else{
				result.push(["M", last[5], last[6]]);
			}
			for(var i = arr.length-2; i>=0; i--){
				var current = arr[i];
				var prev = arr[i+1];
				result.push(["C", prev[3], prev[4], 
					prev[1], prev[2], 
					current[5]||current[1], current[6]||current[2]])
			}
			if(z){
				result.push(["z"]);
			}
		}
		return result;
	};
});

/*
Element.toggle(onFunc,offFunc,isOn)
Element.toggle(isOn)
Element.toggle()
Element.toggleState()
Element.removeToggle()
default:show/hide
default state:true
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var funcKey = "__snip.toggle.func";
	var stateKey = "__snip.toggle.state";
	Element.prototype.toggle = function(onFunc, offFunc, isOn){
		var funcs = this.data(funcKey);
		var state = this.data(stateKey);
		if(onFunc === undefined){
			if(state === undefined){state = true;}
			return this.toggle(!state);
		}else if(offFunc === undefined){
			if(!funcs){
				this.toggle(this.show, this.hide);
			}
			state = !!onFunc;
			this.data(funcKey)[state].apply(this);
			return this.data(stateKey, state);
		}else{
			funcs = {true: onFunc,false: offFunc};
			this.data(funcKey, funcs);
			return this.toggle(isOn===undefined? true: isOn);
		}
	};
	Element.prototype.toggleState = function(){
		return !!this.data(stateKey);
	};
	Element.prototype.removeToggle = function(){
		return this.removeData(funcKey).removeData(stateKey);
	};
});

/*
Snap.do(func)
Element.do(func)
Element.pause()
Element.resume()
Element.stop()
Element.doings()
Snap.watch()
Element.watch()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.do = function(set){
		set();
		var anim = mina(0,1,0,1,function(){return 0.5;},set,mina.linear);
		return anim;
	};
	var key = "__snip.do";
	Element.prototype.doings = function(func){
		var doings = this.data(key);
		if(!doings){doings=[]; this.data(key, doings);}
		return doings;
	};
	Element.prototype.do = function(func){
		var self = this;
		this.doings().push(Snap.do(function(){func.call(self);}));
		return this;
	};
	Element.prototype.pause = function(){
		this.doings().forEach(function(anim){
			anim.pause();
		});
		return this;
	};
	Element.prototype.resume = function(){
		this.doings().forEach(function(anim){
			anim.resume();
		});
		return this;
	};
	Element.prototype.stop = function(){
		this.doings().forEach(function(anim){
			anim.stop();
		});
		this.doings().length = 0;
		return this;
	};
	Snap.watch = function(template, knock, func, thisArg){
		var f = Snap.setter(template, func, thisArg);
		return Snap.do(function(){knock(f);});
	}
	Element.prototype.watch = function(template, checker){
		var f = this.setter(template);
		return this.do(function(){checker(f);});
	};
});

/*
Element.animateMotion(path,orient,dur,easing,callback)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.animateMotion = function(path, orient, dur, easing, callback){
		easing = easing || mina.linear;
		var self = this;
		var pathStr = Snap.is(path, "string") ? path: path.attr("path");
		var len = Snap.path.getTotalLength(pathStr);
		var setter = function(pos){
			var pt = Snap.path.getPointAtLength(pathStr,pos);
			self.transform("t" + [pt.x,pt.y] + "r" + getOrient(pt) + ",0,0");
		};
		var getOrients = {
			"auto": function(pt){return pt.alpha+180;},
			"auto-reverce": function(pt){return pt.alpha;}
		};
		var getOrient = getOrients[orient] || function(){return orient;};
		return Snap.animate(0, len-0.01, setter, dur, easing, callback);
	};
});

/*
Snap.translateTimeline(settings, delay, total, easing,callback)
Snap.animateTimeline(settings, delay, total, easing,callback)
Snap.animateTimeline(timeline)
settings = [
	//function notation.
	{begin:, dur:, func:, easing:} 
	//simple notation.
	{begin:, dur:, elem:, attr:, from:, to:, easing:} 
	//keyframes notation.
	{begin:, dur:, elem:, attr:, keyframes:[ 
		{rate:, value:, easing: or discrete:true},
		...
	]}
	...
}
Snap.interpolate(attrs, p)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.translateTimeline = function(settings, delay, total, callback){
		var funcs = functionsFactory(settings, delay, total);
		return {
			f: function(t){
				funcs.forEach(function(f){
					f(t);
				});
			},
			delay: delay,
			total: total,
			callback: callback
		};
	};
	Snap.animateTimeline = function(settings, delay, total, callback){
		var tl = arguments.length==1 ? settings
			: Snap.translateTimeline(settings, delay, total, callback);
		return Snap.animate(-tl.delay, tl.total, 
			tl.f, tl.delay + tl.total, mina.linear, tl.callback);
	}
	function functionsFactory(settings, delay, total){
		var funcs = [];
		settings.forEach(function(s, i){
			s.easing = s.easing || mina.linear;
			setFunc(s);
			funcs.push(function(t){
				if(!s.dur||s.dur<=0){
					s.func(t<s.begin? 0:1);
				}else{
					var p = (t-s.begin)/s.dur;
					p = p<0 ? 0 : p>1 ? 1 :p;
					s.func(s.easing(p));
				}
			});
		});
		return funcs;
	}
	function setFunc(s){
		if(s.func){return;}
		if(!s.keyframes){
			setFuncSimple(s);
		}else{
			setFuncKeyframes(s);
		}
	}
	function setFuncSimple(setting){
		var elem = setting.elem;
		var attr = setting.attr;
		var from = setting.from;
		var to = setting.to;

		var param = {};
		var setValue = function(value){
			param[attr] = value;
			elem.attr(param);
		};

		setValue(from);
		var eq = elem.equal(attr, to);
		setting.func = function(p){
			if(p==0){
				setValue(from);
			}else if(p==1){
				setValue(to);
			}else{
				setValue(getValue(eq.from, eq.to, p, eq.f));
			}
		};
	}
	function setFuncKeyframes(setting){
		var elem = setting.elem;
		var attr = setting.attr;
		var keyframes = setting.keyframes;

		var param = {};
		var setValue = function(value){
			param[attr] = value;
			elem.attr(param);
		};

		var funcs = [];
		var iValue = keyframes[0].value;
		var iRate = keyframes[0].rate;
		funcs.push(function(p){
			if(p<=iRate){
				setValue(iValue);
				return true;
			}
		});
		for(var i = 0,len=keyframes.length; i<len-1; i++){
			var current = keyframes[i];
			var next = keyframes[i+1];
			setValue(current.value);
			funcs.push(createMiddleFunction(
				setValue, 
				elem.equal(attr, next.value),
				current.rate, 
				next.rate,
				current.value,
				current.easing || mina.linear,
				current.discrete)
			);
		}
		var fValue = keyframes[keyframes.length-1].value;
		var fRate = keyframes[keyframes.length-1].rate;
		funcs.push(function(p){
			if(fRate<=p){
				setValue(fValue);
				return true;
			}
		});
		setting.func = function(p){
			for(var i=0, len=funcs.length; i<len; i++){
				if(funcs[i](p)){break;}
			}
		};
		setValue(iValue);
	}

	function createMiddleFunction(setValue, eq, begin, end, value, easing, discrete){
		if(!discrete){
			return function(p){
				if(begin<=p && p<end){
					setValue(getValue(eq.from, eq.to,
						easing((p-begin)/(end-begin)), eq.f));
					return true;
				}
			};
		}else{
			return function(p){
				if(begin<=p && p<end){
					setValue(value);
					return true;
				}
			};
		}
	}
	function getValue(from, to, p, f){
		if(Array.isArray(from)){
			var result = [];
			from.forEach(function(from, i){
				result.push(getSingleValue(from, to[i], p));
			});
			return f(result);
		}else{
			return f(getSingleValue(from, to, p));
		}
	}
	function getSingleValue(from, to, p){
		from *=1; to *=1;
		return from + (to-from)*p;
	}
	Element.prototype.interpolate = function(attrs, p){
		for(var attr in attrs){
			var value = attrs[attr];
			var eq = this.equal(attr, value);
			var param = {};
			param[attr] = getValue(eq.from, eq.to, p, eq.f);
			this.attr(param);
		}
		return this;
	};
});

/*
easing function decorator
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.easing = {};
	Snap.easing.times = function(easing, times){
		return function(t){
			if(t>=1){return 1;}
			return easing((t * times)%1);
		};
	}
	Snap.easing.delay = function(easing, delay, duration, cooldown){
		cooldown = cooldown || 0
		return function(t){
			var s = t * (delay + duration + cooldown);
			if(s<delay){
				return 0;
			}else if(delay + duration<s){
				return 1;
			}else{
				return (s-delay)/duration;
			}
		};
	}
	Snap.easing.shift = function(easing, shift, scale){
		shift = shift || 0;
		scale = scale || 1;
		return function(t){
			return easing(t) * scale + shift;
		}
	}
	Snap.easing.reverse = function(easing){
		return function(t){
			return 1 - easing(t);
		}
	}
	Snap.easing.mirror = function(easing){
		return function(t){
			return easing(1-t);
		}
	}
	Snap.easing.join = function(easings){
		var len = easings.length;
		return function(t){
			var s = t * len;
			if(t >=1){
				return 1;
			}else{
				return easings[Math.floor(s)](s%1);
			}
		}
	}
	Paper.prototype.displayEasing = function(easing, x, y, width, height){
		x = x || 0;
		y = y || 0;
		width = width || 200;
		height = height || 200;
		var points = [];
		var count = 100;
		var xUnit = width/count;
		var yUnit = height/count;
		for(var i = 0; i<=count; i++){
			points.push(x + xUnit * i);
			points.push(y + (1-easing(i/count))*height);
		}
		return this.path("M" + points)
			.attr({fill:"none", stroke:"black", strokeLinejoin:"round"});
	};
});

/*
Snap.copy(obj)
returns shallow copy of simple object.
Snap.copies(obj)
returns array of shallow copies of simple object.
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.copy = function(obj){
		var result = {};
		for(var i in obj){
			result[i] = obj[i];
		}
		Object.defineProperty(result, "set", descriptor);
		return result;
	};
	Snap.copies = function(obj, count){
		var result = [];
		for(var i = 0;i<count;i++){
			result.push(Snap.copy(obj));
		}
		return result;
	};
	var descriptor = {
		enumerable: false,
  		writable: false,
  		configurable: false,
		value: function(json, value){
			if(value !== undefined){
				var j = {};
				j[json] = value;
				return this.set(j);
			}
			for(var i in json){
				this[i] = json[i];
			}
			return this;
		}
	};
});

/*
Snap.limitToPath(pathStr,x,y,pt)
Snap.limitToRange(s,e,v)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var arr = [];
	arr.length = 4;
	Snap.limitToPath = function(pathStr, x, y, pt){
		pt = pt || {};
		pathStr = Snap.path.toAbsolute(pathStr);
		if(Snap.path.isPointInside(pathStr, x, y)){
			pt.x = x;
			pt.y = y;
			return pt;
		}else{
			var bbox = Snap.path.getBBox(pathStr);
			arr[0] = x;
			arr[1] = y;
			arr[2] = bbox.cx;
			arr[3] = bbox.cy;
			var lineStr = "M"+arr;
			var p = Snap.path.intersection(lineStr,pathStr)[0];
			if(p){
				pt.x = p.x;
				pt.y = p.y;
			}else{
				throw "point not found.";
			}
			return pt;
		}
	};
	Snap.limitToRange = function(s, e, v){
		return v<s ? s : (e<v ? e : v);
	};
});

/*
Snap.defineAttr(attrName, func, isList, beforeDOMWrite)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.defineAttr = function(attrName, func, isList, beforeDOMWrite, getter){
		eve.on("snap.util.attr." + attrName, function(){
			if(beforeDOMWrite){eve.stop();};
			func.apply(this, arguments);
		})(beforeDOMWrite ? -2: 1);
		if(getter){
			eve.on("snap.util.getattr." + attrName, function(){
				eve.stop();
				return getter.apply(this);
			})(-2);
		}
		if(isList){
			listTypes[attrName] = true;
		}
	};
	var listTypes = {};
	var originalEqual = Element.prototype.equal;
	Element.prototype.equal = function(name, b){
		if(listTypes[name]){
			var f = this.attr(name);
			//f = f ? f.split(","): [0];
			var t = typeof b == "array" ? b: b.split(",");
			return {
				from: f,
				to: t,
				f: function(arr){return arr.toString();}
			}
		}else{
			return originalEqual.apply(this, arguments);
		}
	};
});

/*
Element.animateCustom(func, dur, easing)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var fKey = "__snip.customAnimate.func";
	var vKey = "__snip.customAnimate.value";
	var nullFunc = function(){};
	Snap.defineAttr("customAnimate", function(value){
		value = +value;
		value = value<0 ? 0 : value>1 ? 1: value;
		this.data(vKey, value);
		(this.data(fKey) || nullFunc).call(this, value);
	}, false, true, function(){
		return this.data(vKey);
	});
	Element.prototype.animateCustom = function(func, dur, easing){
		this.data(fKey, func);
		return this.attr({customAnimate: 0})
			.animate({customAnimate: 1}, dur, easing);
	};
});

/*
Snap.defineShape()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var SHAPE_TYPE = "shape-type";
	//shared converter function.(use to convert dom value to js value.)
	function whenNumber(value){return +(value || 0);}
	function whenList(value){return value ? value: [0];}
	function whenString(value){return value;}

	Snap.defineShape = function(funcName, template, attrs){
		//define creator function.
		if(Paper.prototype[funcName]){
			throw "Snap.defineShape was failed. The Paper."+funcName+" already existed.";
		}
		Paper.prototype[funcName] = function(){
			var shape = this.path();
			shape.attr(SHAPE_TYPE, funcName);
			var param = arguments[0];
			if(!Snap.is(param, "object") || Snap.is(param, "array")){
				param = {};
				var i = 0;
				for(var key in attrs){
					var arg = arguments[i++];
					if(!arg){continue;}
					param[key] = arg;
				}
			}
			return shape.attr(param);
		};
		var templateToPath = typeof template == "string" ?
			function(param){
				return Snap.format(template, param);
			}: function(param){
				return template(param);
			};
		
		var converters = {};
		for(var i in attrs){
			var type = attrs[i];
			if(!type){
				converters[i] = whenNumber;
			}else if(type=="list"){
				converters[i] = whenList;
			}else{
				converters[i] = whenString;
			}
		}
		function converter(value, key){
			return converters[key](value);
		}
		//drawing function will be caused by custom events.
		var p = {};
		function drawer(){
			if(this.type != "path" || this.attr(SHAPE_TYPE) != funcName){return;}
			eve.stop();
			p["path"] = templateToPath(this.copyAttr(Snap.copy(attrs), converter));
			this.attr(p);
		};
		//define custom events.
		for(var i in attrs){
			Snap.defineAttr(i, drawer, attrs[i]=="list");}
	};
});

/*
Paper.pie(cx,cy,r1,r2,start,end)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var sin = Math.sin;
	var cos = Math.cos;
	var PI = Math.PI;
	var piePath =
		[
			"M{r1sx},{r1sy}A{r1},{r1} 0 0,{f} {r1mx},{r1my}A{r1},{r1} 0 0,{f} {r1ex},{r1ey}",
			"L{r2ex},{r2ey}A{r2},{r2} 0 0,{b} {r2mx},{r2my}A{r2},{r2} 0 0,{b} {r2sx},{r2sy}",
			"z"
		].join("");
	Snap.defineShape("pie", function(p){
		if(p.end-p.start>=360){
			p.end = p.start + 360;
		}else if(p.end-p.start<=-360){
			p.end = p.start - 360;
		}
		var srad = p.start*PI/180;
		var erad = p.end*PI/180;
		var mrad = (srad + erad)/2;
		var cs = cos(srad), cm = cos(mrad), ce = cos(erad);
		var ss = sin(srad), sm = sin(mrad), se = sin(erad);
		p.r1sx = p.r1 * cs + p.cx; p.r1sy = p.r1 * ss + p.cy;
		p.r1mx = p.r1 * cm + p.cx; p.r1my = p.r1 * sm + p.cy;
		p.r1ex = p.r1 * ce + p.cx; p.r1ey = p.r1 * se + p.cy;
		p.r2sx = p.r2 * cs + p.cx; p.r2sy = p.r2 * ss + p.cy;
		p.r2mx = p.r2 * cm + p.cx; p.r2my = p.r2 * sm + p.cy;
		p.r2ex = p.r2 * ce + p.cx; p.r2ey = p.r2 * se + p.cy;
		p.f = srad<erad ? 1 : 0;
		p.b = p.f==0 ? 1: 0;
		return Snap.format(piePath, p);
	}, 
	{cx:null, cy:null, r1:null, r2:null, start:null, end:null});
});

/*
Paper.lineLike(x1,y1,x2,y2)
Paper.rectLike(x,y,width,height)
Paper.circleLike(cx,cy,r)
Paper.ellipseLike(cx,cy,r1,r2,rotate)
Paper.polylineLike(points)
Paper.polygonLike(points)
Element.toPathString()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var sin = Math.sin;
	var cos = Math.cos;
	var rectLike = "M{x},{y}h{width}v{height}h{m_width}z";
	var lineLike = "M{x1},{y1} {x2},{y2}";
	var circleLike = "M{sx},{cy}A{r},{r} 0 0,1 {mx},{cy}A{r},{r} 0 0,1 {sx},{cy}z";
	var ellipseLike = "M{sx},{sy}A{rx},{ry} {rotate} 0,1 {mx},{my}A{rx},{ry} {rotate} 0,1 {sx},{sy}z";
	var paramToPaths = {
		rect: function(p){
			p.m_width = -p.width;
			return Snap.format(rectLike, p);
		},
		line: function(p){return Snap.format(lineLike, p);},
		circle :function(p){
			p.sx = p.cx + p.r;
			p.mx = p.cx - p.r;
			return Snap.format(circleLike, p);
		},
		ellipse :function(p){
			var rad = Snap.rad(p.rotate);
			var c = p.rx * cos(rad);
			var s = p.rx * sin(rad);
			p.sx = p.cx + c;
			p.sy = p.cy + s;
			p.mx = p.cx - c;
			p.my = p.cy - s;
			return Snap.format(ellipseLike, p);
		},
		polyline: function(p){return "M" + p.points;},
		polygon: function(p){return "M" + p.points + "z";},
	};
	var paramDefs = {
		rect: {x:null, y:null, width:null, height:null},
		line: {x1:null, y1:null, x2:null, y2:null},
		circle: {cx:null, cy:null, r:null},
		ellipse: {cx:null, cy:null, rx:null, ry: null, rotate:null},
		polyline: {points:"list"},
		polygon: {points:"list"}
	};
	for(var i in paramDefs){
		Snap.defineShape(i + "Like", paramToPaths[i], paramDefs[i]);
	}

	Element.prototype.toPathString = function(){
		var type = this.type;
		if(type == "path"){return this.attr("d");}
		var paramDef = paramDefs[type];
		if(!paramDef){return "";}
		var param = this.copyAttr(Snap.copy(paramDef), function(value, key){
			return !paramDef[key] ? +(value||0) : value ? value.split(","): [0];
		});
		return paramToPaths[type](param);
	};
});

/*
Paper.arc(cx,cy,r,start,end)
Paper.bow(cx,cy,r,start,end)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var sin = Math.sin;
	var cos = Math.cos;
	var PI = Math.PI;
	var arcPath = "M{sx},{sy}A{r},{r} 0 0,{f} {mx},{my}A{r},{r} 0 0,{f} {ex},{ey}";
	function pToPath(p){
		if(p.end-p.start>=360){
			p.end = p.start + 360;
		}else if(p.end-p.start<=-360){
			p.end = p.start - 360;
		}
		var srad = p.start*PI/180;
		var erad = p.end*PI/180;
		var mrad = (srad + erad)/2;
		p.sx = p.r * cos(srad) + p.cx; p.sy = p.r * sin(srad) + p.cy;
		p.mx = p.r * cos(mrad) + p.cx; p.my = p.r * sin(mrad) + p.cy;
		p.ex = p.r * cos(erad) + p.cx; p.ey = p.r * sin(erad) + p.cy;
		p.f = srad<erad ? 1 : 0;
		return Snap.format(arcPath, p);
	}
	Snap.defineShape("arc",
		pToPath,{cx:null, cy:null, r:null, start:null, end:null});
	Snap.defineShape("bow",
		function(p){
			return pToPath(p) + "z";
	},{cx:null, cy:null, r:null, start:null, end:null});
});

/*
Paper.rpolygon(n,cx,cy,r)
Paper.rstar(n,cx,cy,r)
Paper.star(n,cx,cy,r1,r2)
Paper.radar(cx,cy,rs)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var sin = Math.sin;
	var cos = Math.cos;
	var PI = Math.PI;
	function toCamel(text){
		return text.substr(0,1).toUpperCase() + text.substr(1);
	}
	function defineRadarTypeShape(funcName, attrs, pusher, counter, smooth){
		if(smooth === undefined){
			defineRadarTypeShape(funcName, attrs, pusher, counter, false);
			defineRadarTypeShape("smooth"+toCamel(funcName), attrs, pusher, counter, true);
			return;
		}
		var toPath = !smooth ? function(points){return "M" + points + "z";}
			: function(points){return "M" + points.shift() + "," + points.shift() + 
				"R" + (points.length == 0 ? "0,0 0,0": points) + "z"};
		counter = counter || function(p){return p.n;}
		Snap.defineShape(funcName, function(p){
			var rs = [];
			for(var i=0, len=counter(p); i<len; i++){
				pusher(p, i, rs);
			}
			return toPath(rsToPoints(rs, p.cx, p.cy));
		},attrs);
	};
	function rsToPoints(rs, cx, cy){
		var points = [];
		for(var i = 0, len=rs.length; i<len; i++){
			var r = rs[i];
			points.push(cx + r * sin(PI*2/len*i));
			points.push(cy + r * -cos(PI*2/len*i));
		}
		return points;
	}
	defineRadarTypeShape("rpolygon", {n:null,cx:null,cy:null,r:null}, function(p, i, rs){
		rs.push(p.r);
	});
	defineRadarTypeShape("rstar", {n:null,cx:null,cy:null,r:null}, function(p, i, rs){
		var spoke = cos(PI*2/p.n)/cos(PI/p.n);
		rs.push(p.r);
		rs.push(p.r * spoke);
	});
	defineRadarTypeShape("star", {n:null,cx:null,cy:null,r:null,spoke:null}, function(p, i, rs){
		rs.push(p.r);
		rs.push(p.r * p.spoke);
	});
	defineRadarTypeShape("radar", {cx:null,cy:null,rs:"list"}, function(p, i, rs){
		rs.push(+p.rs[i]);
	},function(p){
		return p.rs.length;
	});
});

/*
Element.textLength()
Element.substr(i, nchars)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.textLength = function(){
		return this.node.textContent.length;
	}
	Element.prototype.substr = function(i, nchars){
		return this.node.textContent.substr(i, nchars);
	}
});

/*
Element.getBBoxOfChar(i)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.getBBoxOfChar = function(i){
		var text = this.node;
	    var rect = text.getExtentOfChar(i);
		var start = text.getStartPositionOfChar(i);
		var end = text.getEndPositionOfChar(i);
		var bbox = {
			x: rect.x,
			y: rect.y,
			width: rect.width,
			height: rect.height,
			sx: start.x,
			sy: start.y,
			ex: end.x,
			ey: end.y,
			rotate: text.getRotationOfChar(i),
	    	cWidth: text.getSubStringLength(i, 1)
		}
		push(bbox);
		return bbox;
	};
	function push(bbox){
	    var rect = bbox;
	    var rotate = bbox.rotate;
	    var cWidth = Math.sqrt(Math.pow(bbox.sx-bbox.ex,2) + Math.pow(bbox.sy-bbox.ey,2)); //bbox.cWidth;
	    var p = [];
	    var cos = Math.abs(Math.cos(rotate * Math.PI/180));
	    var sin = Math.abs(Math.sin(rotate * Math.PI/180));
	    switch(Math.floor(rotate/90)%2){
	        //隨ｬ1,3雎｡髯�
	        case 0:
	            p.push([rect.x + rect.width - cWidth * cos, rect.y]);
	            p.push([rect.x + rect.width, rect.y + cWidth * sin]);
	            p.push([rect.x + cWidth * cos, rect.y + rect.height]);
	            p.push([rect.x, rect.y + rect.height - cWidth * sin]);
	            break;
	        //隨ｬ2,4雎｡髯�
	        default:
	            p.push([rect.x + cWidth * cos, rect.y]);
	            p.push([rect.x + rect.width, rect.y + rect.height - cWidth * sin]);
	            p.push([rect.x + rect.width - cWidth * cos, rect.y + rect.height]);
	            p.push([rect.x, rect.y + cWidth * sin].join(","));
	            break;
	    }
		bbox.points = p;
	    bbox.path = "M" + p + "z";
	};
});

/*
Element.attr({skipx: value})
Element.attr({skipy: value})
null to cancel.
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var prefix = "__snip.attr.";
	function define(attrName, attr, isstack){
		var key = prefix + attrName;
		var param = {};
		var toArr = isstack?stack:times;
		Snap.defineAttr(attrName, function(value){
			eve.stop();
			this.data(key, value);
			var start = firstValue(this.node[attr].baseVal);
			if(value !==undefined && value !== null){
				param[attr] = toArr(start, value, this.textLength());
			}else{
				param[attr] = start;
			}
			this.attr(param);
		}, false, true, function(){
			eve.stop();
			return this.data(key);
		});
	}
	function firstValue(vl){
		return vl.numberOfItems == 0 ? 0: vl.getItem(0).value;
	}
	function stack(start, value, count){
		var result = [];
		for(var i=0; i<count; i++){
			result.push(start + value*i);
		}
		return result;
	}
	function times(start, value, count){
		var result = [0];
		for(var i=1; i<count; i++){
			result.push(value);
		}
		return result;
	}
	define("skipx", "x", true);
	define("skipy", "y", true);
	define("skipdx", "dx", false);
	define("skipdy", "dy", false);
});

/*
Paper.imageAsDataScheme(url, x, y, width, height)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var img = document.createElementNS("http://www.w3.org/1999/xhtml", "img");
	var canvas = document.createElementNS("http://www.w3.org/1999/xhtml", "canvas");
	var ctx = canvas.getContext("2d");
	function toDataScheme(src, callback, thisarg){
		if(src.match(/\.svg$/)){
			Snap.ajax(src, function(request){
				var source = request.responseText;
				var svg = request.responseXML.documentElement;
				callback.call(thisarg, "data:image/svg+xml;charset=utf-8," + encodeURIComponent(source),
					svg.getAttribute("width"),
					svg.getAttribute("height"));
			});
		}else{
			img.onload = function(){
				var w = canvas.width = img.width;
				var h = canvas.height = img.height;
				ctx.drawImage(img, 0, 0);
				callback.call(thisarg, canvas.toDataURL(), w, h);
				img.onload = undefined;
			}
			img.src = src;
		}
	};
	Paper.prototype.imageAsDataScheme = function(){
		var args = {};
		var arg0 = arguments[0];
		var src;
		if(typeof arg0 == "object"){
			src = arg0.src || arg0["xlink:href"];
			args.x = arg0.x || 0;
			args.y = arg0.y || 0;
			args.width = arg0.width || 0;
			args.height = arg0.height || 0;
		}else{
			src = arguments[0];
			args.x = arguments[1] || 0;
			args.y = arguments[2] || 0;
			args.width = arguments[3] || 0;
			args.height = arguments[4] || 0;
		}
		if(src.match(/^data\:image\//)){return this.image.apply(this, arguments);}
		var image = this.image().attr(args);
		toDataScheme(src, function(src, width, height){
			var node = this.node;
			node.href.baseVal = src;
			fix(node, "width", width);
			fix(node, "height", height);
		}, image);
		return image;
	};
	function fix(node, attrName, value){
		var attr = node[attrName].baseVal;
		if(attr.valueAsString == 0){attr.valueAsString = value;}
	}
});

/*
Paper.toDataURL()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var serializer = new XMLSerializer();
	Paper.prototype.toDataURL = function(){
		var serializer = new XMLSerializer();
		var source = serializer.serializeToString(this.node);
		//add namespace・�
		//NOTE:some browser(ie) duplicates namespace atteibutes.
		source = source.replace(/xmlns="http\:\/\/www\.w3\.org\/2000\/svg"/g,"");
		source = source.replace(/xmlns\:xlink="http\:\/\/www\.w3\.org\/1999\/xlink"/g,"");
		source = source.replace(/^<svg/, 
			'<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"');
		source = '<?xml version="1.0" standalone="no"?>\r\n' + source;
		//return "data:image/svg+xml;charset=utf-8," + encodeURIComponent(source);
		return source;
	}
});

/*
Element.copyAttr(obj)
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var serializer = new XMLSerializer();
	var defFunc = function(value){return value;};
	Element.prototype.copyAttr = function(obj, func){
		for(var i in obj){
			obj[i] = (func || defFunc)(this.attr(i), i);
		}
		return obj;
	}
});

/*
Set.toArray()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Snap.set().constructor.prototype.toArray = function(){
		return Array.prototype.slice.call(this);
	};
});

/*
Fragment.append()
Fragment.prepend()
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	var originalFragment = Snap.fragment;
	Snap.fragment = function(){
		return originalFragment.apply(null, arguments.length==0 ? [""] :arguments);
	};
	var fragmentProto = Snap.fragment("").constructor.prototype;
	fragmentProto.append = function(elem){
		this.node.appendChild(elem.node);
		return this;
	};
	fragmentProto.prepend = function(elem){
		this.node.insertBefore(elem.node, this.node.firstChild);
		return this;
	};
});

/*
Element.release()
release object cache.
NOTE:this method is not enough to release memory.
*/
Snap.plugin(function(Snap, Element, Paper, glob){
	Element.prototype.release = function(){
		//NOTE:need deleting this from element cache but Snap.svg has no api to access the cache.
		//delete Snap._.glob.hub[this.node.snap];
		for(var i in this){
			delete this[i];
		}
	};
});

