//B4J WebSockets ABMaterial client library v2.12

var hasEvents=false;
function hasClass(el, className) {
  if (el.classList)
    return el.classList.contains(className)
  else
    return !!el.className.match(new RegExp('(\\s|^)' + className + '(\\s|$)'))
};

function addClass(el, className) {
  if (el.classList)
    el.classList.add(className)
  else if (!hasClass(el, className)) el.className += " " + className
};

function removeClass(el, className) {
  if (el.classList)
    el.classList.remove(className)
  else if (hasClass(el, className)) {
    var reg = new RegExp('(\\s|^)' + className + '(\\s|$)')
    el.className=el.className.replace(reg, ' ')
  }
};

if (typeof Object.assign != 'function') {
  (function () {
    Object.assign = function (target) {
      'use strict';
      // We must check against these specific cases.
      if (target === undefined || target === null) {
        throw new TypeError('Cannot convert undefined or null to object');
      }

      var output = Object(target);
      for (var index = 1; index < arguments.length; index++) {
        var source = arguments[index];
        if (source !== undefined && source !== null) {
          for (var nextKey in source) {
            if (source.hasOwnProperty(nextKey)) {
              output[nextKey] = source[nextKey];
            }
          }
        }
      }
      return output;
    };
  })();
};


(function(global) {

  if (typeof global.CustomEvent === 'function') return

  function CustomEvent(event, params) {
    params = params || {
        bubbles: false,
        cancelable: false,
        detail: undefined
    }

    var evt
    if (typeof document !== 'undefined') {
      evt = document.createEvent('CustomEvent')
      evt.initCustomEvent(event, params.bubbles, params.cancelable, params.detail)
    } else {
      evt = {
        type: event,
        detail: params.detail,
        bubbles: false,
        cancelable: false,
        preventDefault: function() {},
        stopPropagation: function() {}
      }
    }

    return evt
  }

  if (global.Event) {
    CustomEvent.prototype = global.Event.prototype
  }

  global.CustomEvent = CustomEvent
})(this);



(function(factory, global) {
  if (typeof define === 'function' && define.amd) {
    define(function() {
      return factory(global, navigator)
    })
  } else if (typeof exports === 'object' && typeof module === 'object') {
    module.exports = factory(global, navigator)
  } else {
    // mock the navigator object when under test since `navigator.onLine` is read only
    global.RobustWebSocket = factory(global, typeof Mocha !== 'undefined' ? Mocha : navigator)
  }
})(function(global, navigator) {

  var RobustWebSocket = function(url, protocols, userOptions) {
    var realWs = { close: function() {} },
        connectTimeout,
        self = this,
        attempts = 0,
        reconnects = -1,
        reconnectWhenOnlineAgain = false,
        explicitlyClosed = false,
        pendingReconnect,
        opts = Object.assign({},
          RobustWebSocket.defaultOptions,
          typeof userOptions === 'function' ? { shouldReconnect: userOptions } : userOptions
        )

    if (typeof opts.timeout !== 'number') {
      throw new Error('timeout must be the number of milliseconds to timeout a connection attempt')
    }

    if (typeof opts.shouldReconnect !== 'function') {
      throw new Error('shouldReconnect must be a function that returns the number of milliseconds to wait for a reconnect attempt, or null or undefined to not reconnect.')
    }

    ['bufferedAmount', 'url', 'readyState', 'protocol', 'extensions'].forEach(function(readOnlyProp) {
      Object.defineProperty(self, readOnlyProp, {
        get: function() { return realWs[readOnlyProp] }
      })
    })

    function clearPendingReconnectIfNeeded() {
      if (pendingReconnect) {
        pendingReconnect = null
        clearTimeout(pendingReconnect)
      }
    }

    var ononline = function(event) {	
		//console.log("online");
	  if (reconnectWhenOnlineAgain) {
        clearPendingReconnectIfNeeded()
        reconnect(event)
      }
    },
    onoffline = function() {		
		//console.log("offline");
	  reconnectWhenOnlineAgain = true
      realWs.close(1000)
    },
    connectivityEventsAttached = false

    function detachConnectivityEvents() {
      if (connectivityEventsAttached) {
        global.removeEventListener('online', ononline);
        global.removeEventListener('offline', onoffline);
        connectivityEventsAttached = false;
		hasEvents=false;		
      }
    }

    function attachConnectivityEvents() {
	  if (!connectivityEventsAttached) {
        global.addEventListener('online', ononline);
        global.addEventListener('offline', onoffline);
        connectivityEventsAttached = true;
		hasEvents=true;		
      }
    }

    self.send = function() {
      return realWs.send.apply(realWs, arguments)
    }

    self.close = function(code, reason) {
      if (typeof code !== 'number') {
        reason = code
        code = 1000
      }

      clearPendingReconnectIfNeeded()
      reconnectWhenOnlineAgain = false
      explicitlyClosed = true
      detachConnectivityEvents()
	  
      return realWs.close(code, reason)
    }

    self.open = function() {
      if (realWs.readyState !== WebSocket.OPEN && realWs.readyState !== WebSocket.CONNECTING) {
        clearPendingReconnectIfNeeded()
        reconnectWhenOnlineAgain = false
        explicitlyClosed = false

        newWebSocket()
      }
    }
	
	self.startReconnect = function(event) {
		if (reconnectWhenOnlineAgain) {
			clearPendingReconnectIfNeeded()
			reconnect(event)
		}
	}

    function reconnect(event) {
      if (event.code === 1000 || explicitlyClosed) {
	    console.log("Stop reconnecting: " + event.code + "," + explicitlyClosed);
		attempts = 0
		var indicator = document.getElementById('pageconnectedindicator');
		if (indicator === null) {
			var randomNum = Math.round(Math.random() * 1000000);
			RunToastNoConnection(randomNum);
		}
        return
      }
      if (navigator.onLine === false) {
        reconnectWhenOnlineAgain = true
        return
      }

      var delay = opts.shouldReconnect(event, self)
	  if (typeof delay === 'number') {
        pendingReconnect = setTimeout(newWebSocket, delay)
      }
    }

    Object.defineProperty(self, 'listeners', {
      value: {
        open: [function(event) {
          if (connectTimeout) {
            clearTimeout(connectTimeout)
            connectTimeout = null
          }
          event.reconnects = ++reconnects
          event.attempts = attempts
          attempts = 0
          reconnectWhenOnlineAgain = false
        }],
        close: [reconnect]
      }
    })
	
    Object.defineProperty(self, 'attempts', {
      get: function() { return attempts },
      enumerable: true
    })

    Object.defineProperty(self, 'reconnects', {
      get: function() { return reconnects },
      enumerable: true
    })

    function newWebSocket() {		
      pendingReconnect = null
      realWs = new WebSocket(url)
      //realWs.binaryType = self.binaryType

      attempts++
	  
      self.dispatchEvent(Object.assign(new CustomEvent('connecting'), {
        attempts: attempts,
        reconnects: reconnects
      }))
	  

      connectTimeout = setTimeout(function() {
        connectTimeout = null
        detachConnectivityEvents()
		
        self.dispatchEvent(Object.assign(new CustomEvent('timeout'), {
          attempts: attempts,
          reconnects: reconnects
        }))
		
      }, opts.timeout)

      ;['open', 'close', 'message', 'error'].forEach(function(stdEvent) {
        realWs.addEventListener(stdEvent, function(event) {
         self.dispatchEvent(event);

          var cb = self['on' + stdEvent];
          if (typeof cb === 'function') {
            return cb.apply(self, arguments)
          }
        })
      })

      attachConnectivityEvents()
    }

    if (opts.automaticOpen) {
      newWebSocket()
    }
  }

  RobustWebSocket.defaultOptions = {
    // the time to wait before a successful connection
    // before the attempt is considered to have timed out
    timeout: 1000,
    // Given a CloseEvent or OnlineEvent and the RobustWebSocket state,
    // should a reconnect be attempted? Return the number of milliseconds to wait
    // to reconnect (or null or undefined to not), rather than true or false
    shouldReconnect: function(event, ws) {
	  if (event.type === 'online') return 0;	
      if (event.code === 1008 || event.code === 1011) return
      //return [0, 3000, 10000][ws.attempts]
	  return 1000
    },

    // Create and connect the WebSocket when the instance is instantiated.
    // Defaults to true to match standard WebSocket behavior
    automaticOpen: true
  }

  //RobustWebSocket.prototype.binaryType = 'blob'

  // Taken from MDN https://developer.mozilla.org/en-US/docs/Web/API/EventTarget
  RobustWebSocket.prototype.addEventListener = function(type, callback) {
    if (!(type in this.listeners)) {
      this.listeners[type] = []
    }
    this.listeners[type].push(callback)
  }

  RobustWebSocket.prototype.removeEventListener = function(type, callback) {
    if (!(type in this.listeners)) {
      return
    }
    var stack = this.listeners[type]
    for (var i = 0, l = stack.length; i < l; i++) {
      if (stack[i] === callback) {
        stack.splice(i, 1)
        return
      }
    }
  }

  RobustWebSocket.prototype.dispatchEvent = function(event) {	
    if (!(event.type in this.listeners)) {
      return
    }
    event.currentTarget = this
    var stack = this.listeners[event.type]
    for (var i = 0, l = stack.length; i < l; i++) {	 
		stack[i].call(this, event)	 
    }
	
  }

  return RobustWebSocket
}, this)

"use strict";
var b4j_ws;
var b4j_closeMessage = false;
var isOnIOS = navigator.userAgent.match(/iPad/i)|| navigator.userAgent.match(/iPhone/i);
var WebSocketType;
//var ua = navigator.userAgent;
//var isAndroidNative = ((ua.indexOf('Mozilla/5.0') > -1) && (ua.indexOf('Android') > -1) && (!(ua.indexOf('Chrome') > -1) && (ua.indexOf('Version') > -1)) || ((ua.indexOf('Chrome') > -1) && (ua.indexOf('SamsungBrowser') > -1)));
//var isAndroidNative = "";
var mySessionId="";
var reconnectTimeout;
//only called as a result of a server request that is waiting for result.
//this method should not be called in any other case.
function KeepAlive() {
	var xhr = new XMLHttpRequest();
	var randomNum = Math.round(Math.random() * 1000000);
	xhr.open("HEAD", "donotdelete.conn" + "?rand=" + randomNum, true);
	xhr.onload = function (e) {
		if (xhr.readyState === 4) {
			if (xhr.status >= 200 && xhr.status < 304) {
				try {					
					if (b4j_ws.readyState !== 1) {
						
					}
				} catch (e) {
					
				}
			} 
		}
	};
	xhr.onerror = function (e) {
		
	};
	xhr.send(null);
}


function b4j_sendData(data) {
    b4j_ws.send(JSON.stringify({type: "data", data: data}));
}
function b4j_raiseEvent(eventName, parameters) {	
	var indicator = document.getElementById('pageconnectedindicator');
	
	try {
        if (b4j_ws.readyState !== 1) {
            if (b4j_closeMessage === false) {
                //window.console.error("connection is closed.");
				if (typeof RobustWebSocket === 'undefined') {
					//window.alert("Server is currently not available.");
					window.console.error("Server is currently not available.");	
				} else {
					//window.alert("Connection is closed. Please refresh the page to reconnect.");
					window.console.error("Connection is closed. Trying to reconnect.");						
				}
                b4j_closeMessage = true;				
            }			
			if (indicator === null) {
				var randomNum = Math.round(Math.random() * 1000000);
				RunToastNoConnection(randomNum);
			}
        } else {
			b4j_closeMessage = false;
			//console.log("sending: " + parameters.eventname);
            b4j_ws.send(JSON.stringify({type: "event", event: eventName, params: parameters}));		
			
        }
    } catch (e) {
		window.console.error(e);
		if (indicator === null) {
			var randomNum = Math.round(Math.random() * 1000000);
			RunToastNoConnection(randomNum);
		}
    }
	
}
function b4j_addEvent(selector, event, eventName, preventDefault) {
    var obj = $(selector);
    if (obj.length > 0) {
        obj.on(event, function (e) {
            if (preventDefault) {
                e.preventDefault();
                e.stopPropagation();
            }
            if (e.target.id) {
                b4j_raiseEvent(eventName, {which: e.which, target: e.target.id, pageX: e.pageX, pageY: e.pageY, metaKey: e.metaKey});				
            } else {
                b4j_raiseEvent(eventName, {which: e.which, target: selector, pageX: e.pageX, pageY: e.pageY, metaKey: e.metaKey});
            }
        });
    }
}
function b4j_addAutomaticEvents(data) {	
    $.each(data, function (index, value) {		
		b4j_addEvent("#" + value.id, value.event, value.id + "_" + value.event, true);		
    });
	
}
function b4j_runFunction(func, params) {
    //console.log(func);
	return window[func].apply(null, params);
}

function b4j_eval(params, script) {
	//console.log(script);
	
	var f = new Function(script);
    return f.apply(null, params);
}

function b4j_connect(absolutePath) {		
    if (typeof WebSocket === 'undefined') {
        window.alert("WebSockets are not supported by your browser.");
        return;
    }
    var l = window.location, fullpath;
	if  (l.port != 0) {
        fullpath = ((l.protocol === "https:") ? "wss://" : "ws://") + l.hostname + ":" + l.port + absolutePath + l.search;
    } else {
        fullpath = ((l.protocol === "https:") ? "wss://" : "ws://") + l.hostname  + absolutePath + l.search;
    }
	
	
	if (typeof RobustWebSocket === 'undefined') {
		console.log("Using normal WebSocket");
		WebSocketType = "normal";
		b4j_ws = new WebSocket(fullpath);
	} else {	
		console.log("Using RobustWebSocket");
		WebSocketType = "robust";
		b4j_ws = new RobustWebSocket(fullpath);		
	}
	b4j_ws.addEventListener('message', function(event) {
        var ed = JSON.parse(event.data);
        if (ed.etype === "runmethod") {
            $(ed.id)[ed.method].apply($(ed.id), ed.params);
        } else if (ed.etype === "runmethodWithResult") {
            b4j_sendData($(ed.id)[ed.method].apply($(ed.id), ed.params));
        } else if (ed.etype === "setAutomaticEvents") {
            b4j_addAutomaticEvents(ed.data);
        } else if (ed.etype === "runFunction") {
            b4j_runFunction(ed.prop, ed.value);
        } else if (ed.etype === "runFunctionWithResult") {
            b4j_sendData(b4j_runFunction(ed.prop, ed.value));
        } else if (ed.etype === "eval") {
            b4j_eval(ed.value, ed.prop);
        } else if (ed.etype === "evalWithResult") {
            b4j_sendData(b4j_eval(ed.value, ed.prop));
        } else if (ed.etype === "alert") {
            window.alert(ed.prop);
        }
        
    });
	b4j_ws.addEventListener('open', function(event) {
		//console.log("WebSocket opened - Page_Ready already send? " + PageReadyAlreadySend);
		console.log("WebSocket opened");
		if (reconnectTimeout) {
			clearInterval(reconnectTimeout);
		}		
		var el = document.body;
		var elIsLoading = document.getElementById('isloaderwrapper');
		if (elIsLoading) {
			if (!hasClass(elIsLoading, 'isloading')) {		
				if (!hasClass(el, 'loaded')) {
					addClass(el, 'loaded');
					var loader_el = document.getElementById('loader-wrapper');
					if (loader_el) {
						loader_el.parentElement.removeChild(loader_el);
					}
				} 
			} 			
		} 
		var indicator = document.getElementById('pageconnectedindicator');
		if (indicator) {
			removeClass(indicator, 'indicatorinactive');
			addClass(indicator, 'indicatoractive');
		}
		
	});
	
	b4j_ws.addEventListener('close', function(event) {	
		console.log("closed - navigator.onLine:" + navigator.onLine);
		
		if (reconnectTimeout) {
			clearInterval(reconnectTimeout);
			
		}
		var indicator = document.getElementById('pageconnectedindicator');
		if (indicator) {
			removeClass(indicator, 'indicatoractive');
			addClass(indicator, 'indicatorinactive');
		}	
		if (!navigator.onLine) {
			reconnectTimeout = setInterval(function() {
				if (navigator.onLine) {
					clearInterval(reconnectTimeout);
					if (WebSocketType=='robust') {
						b4j_ws.startReconnect(event);
					} 
				}    
			}, 1000);
		}
		
		
		
		
		
		
	});	
	
	
	
	var eventName = isOnIOS ? "pagehide" : "beforeunload";

	window.addEventListener(eventName, function (event) { 
		//window.event.cancelBubble = true; // Don't know if this works on iOS but it might!
		b4j_raiseEvent('page_parseevent', {'eventname':'beforeunload','eventparams':''});
    } );
	
	
	
	
}



