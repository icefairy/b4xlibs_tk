/**
 * Created by Alain Bailleul for B4J (2016)
 */

var ABMXPlay = function(){
var controlID;
var isRunning=true;
var viewLeft=0;
var viewTop=0;
var viewWidth=0;
var viewHeight=0;
var renderer;
var stage;
var scaleType=0;
var displayObjects = {};
var showFPS=false;
var stats;
var scene = new PIXI.DisplayObjectContainer();
var mouseEventObjects = [];
var dragObject;
var tweens = [];
var activeTweens = {};
var removeTweens = {};
var ABXPAssets = {};
var isDragging = false;
var isPreloading = false;
var preloadimage;
var audios = {};
var emitterTextures = {};
var emitterConfigs = {};
var emitterElapsed;
var hasAssetLoader = false;
var buildToTextures = [];
var buildToTextureWidths = [];
var buildToTextureHeights = [];
var buildToFonts = [];
var buildToFontsXML = [];
var buildToFontsTextures = [];
var buildToMovies = [];
var buildToMoviesJSON = [];
var buildToMoviesTextures = [];
var pressed = {};
var unpressed = [];
var useBox2D=false;
var b2Vec2 = Box2D.Common.Math.b2Vec2;
var b2BodyDef = Box2D.Dynamics.b2BodyDef;
var b2Body = Box2D.Dynamics.b2Body;
var b2FixtureDef = Box2D.Dynamics.b2FixtureDef;
var b2Fixture = Box2D.Dynamics.b2Fixture;
var b2World = Box2D.Dynamics.b2World;
var b2MassData = Box2D.Collision.Shapes.b2MassData;
var b2PolygonShape = Box2D.Collision.Shapes.b2PolygonShape;
var b2CircleShape = Box2D.Collision.Shapes.b2CircleShape;
var box2dPhysics;
var box2dLastFrame=new Date().getTime();
var mouseJoint;
var contactsBegin = [];
var contactsEnd = [];
var ToRemoveObjects =[];

var Physics = window.Physics = function(iScale, iGravity, iDoSleep, iPixPerMeter, iVelocityIterations, iPositionIterations) {
    var gravity = new b2Vec2(0,iGravity);
    this.world = new b2World(gravity, iDoSleep);
    this.pixPerMeter = iPixPerMeter;
    this.scale = iScale || iPixPerMeter;
    this.dtRemaining = 0;
    this.stepAmount = 1/60;
    this.VelocityIterations=iVelocityIterations;
    this.PositionIterations=iPositionIterations;

    Physics.prototype.step = function (dt) {
        this.dtRemaining += dt;
        while (this.dtRemaining > this.stepAmount) {
            this.dtRemaining -= this.stepAmount;
            this.world.Step(this.stepAmount,
                this.VelocityIterations, // velocity iterations
                this.PositionIterations); // position iterations
        }
        if (this.debugDraw) {
            this.world.DrawDebugData();
        }
    }

    Physics.prototype.debug = function() {
        this.debugDraw = new b2DebugDraw();
        this.debugDraw.SetSprite(this.context);
        this.debugDraw.SetDrawScale(this.scale);
        this.debugDraw.SetFillAlpha(0.3);
        this.debugDraw.SetLineThickness(1.0);
        this.debugDraw.SetFlags(b2DebugDraw.e_shapeBit | b2DebugDraw.e_jointBit);
        this.world.SetDebugDraw(this.debugDraw);
    };

    Physics.prototype.collision = function () {
        this.listener = new Box2D.Dynamics.b2ContactListener();

        this.listener.BeginContact = function(contact) {
            //console.log("Begin: " + contact.GetFixtureA().GetBody().GetUserData());
            contactsBegin.push(contact.GetFixtureA().GetBody().GetUserData() + ";" + contact.GetFixtureB().GetBody().GetUserData());
        }

        this.listener.EndContact = function(contact) {
            //console.log("End: " + contact.GetFixtureA().GetBody().GetUserData());
            contactsEnd.push(contact.GetFixtureA().GetBody().GetUserData() + ";" + contact.GetFixtureB().GetBody().GetUserData());
        }

        /*
        this.listener.PostSolve = function (contact, impulse) {
            var bodyA = context.GetFixtureA().GetBody().GetUserData(),
                bodyB = context.GetFixtureB().GetBody().GetUserData();

            if (bodyA.contact) {
                bodyA.contact(contact, impulse, true)
            }
            if (bodyB.contact) {
                bodyB.contact(contact, impulse, false)
            }

        };
        */

        /*
        this.listener.PreSolve = function(contact, oldManifold) {
            // PreSolve
        }
        */

        this.world.SetContactListener(this.listener);
    };


};

var Body = window.Body = function (pixiObj, details) {
    this.details = details = details || {};

// Create the definition
    this.definition = new b2BodyDef();

// Set up the definition
    for (var k in this.definitionDefaults) {
        this.definition[k] = details[k] || this.definitionDefaults[k];
    }
    this.definition.position = new b2Vec2(details.x || 0, details.y || 0);
    this.definition.linearVelocity = new b2Vec2(details.vx || 0, details.vy || 0);
    this.definition.userData = pixiObj.ABXPName;
    this.definition.type = details.type == "static" ? b2Body.b2_staticBody : b2Body.b2_dynamicBody;

// Create the Body
    this.body = box2dPhysics.world.CreateBody(this.definition);

// Create the fixture
    this.fixtureDef = new b2FixtureDef();
    for (var l in this.fixtureDefaults) {
        this.fixtureDef[l] = details[l] || this.fixtureDefaults[l];
    }
    this.fixtureDef.isSensor = details.isSensor;

    details.shape = details.shape || this.defaults.shape;

    switch (details.shape) {
        case "circle":
            details.radius = details.radius || this.defaults.radius;
            this.fixtureDef.shape = new b2CircleShape(details.radius);
            break;
        case "polygon":
            this.fixtureDef.shape = new b2PolygonShape();
            var vertices =[];
            for (var i=0;i<details.points.length;i+=2) {
                vertices.push(new b2Vec2(details.points[i], details.points[i+1]));
            }
            this.fixtureDef.shape.SetAsArray(vertices, vertices.length);
            break;
            //this.fixtureDef.shape.SetAsArray(details.points, details.points.length);
            //break;
        case "block":
        default:
            details.width = details.width || this.defaults.width;
            details.height = details.height || this.defaults.height;

            this.fixtureDef.shape = new b2PolygonShape();
            this.fixtureDef.shape.SetAsBox(details.width / 2, details.height / 2);
            break;
    }

    this.body.CreateFixture(this.fixtureDef);

    //console.log("Body created");
};


Body.prototype.defaults = {
    shape: "block",
    width: 5,
    height: 5,
    radius: 2.5
};

Body.prototype.fixtureDefaults = {
    density: 1,
    friction: 1,
    isSensor: false,
    restitution: 0.8
};

Body.prototype.definitionDefaults = {
    active: true,
    allowSleep: true,
    angle: 0,
    angularVelocity: 0,
    angularDamping: 0,
    awake: true,
    bullet: false,
    linearDamping: 0,
    vx: 0,
    vy: 0,
    fixedRotation: false
};

/*
var Body = window.Body = function (pixiObj, details) {
    this.details = details = details || {};

    // Create the definition
    this.definition = new b2BodyDef();
    this.definition.active = details.active;
    this.definition.allowSleep = details.allowSleep;
    this.definition.angle = details.angle;
    this.definition.angularDamping = details.angularDamping;
    this.definition.angularVelocity = details.angularVelocity;
    this.definition.awake = details.awake;
    this.definition.bullet = details.bullet;
    this.definition.fixedRotation = details.fixedRotation;
    this.definition.linearDamping = details.linearDamping;
    this.definition.linearVelocity = new b2Vec2(details.vx || 0, details.vy || 0);
    this.definition.position = new b2Vec2(details.x || 0, details.y || 0);
    //this.definition.type = details.type; // == "static" ? b2Body.b2_staticBody : b2Body.b2_dynamicBody;
    switch (details.type) {
        case "static":
            this.definition.type = b2Body.b2_staticBody;
            break;
        case "dynamic":
            this.definition.type = b2Body.b2_dynamicBody;
            break;
        case "kinetic":
            this.definition.type = b2Body.b2_kinematicBody;
            break;
    }
    this.definition.userData = pixiObj.ABXPName;

    // Create the Body
    this.body = box2dPhysics.world.CreateBody(this.definition);

    // Create the fixture
    this.fixtureDef = new b2FixtureDef();
    this.fixtureDef.density = 0; //.density = details.density;
    this.fixtureDef.friction = details.friction;
    this.fixtureDef.isSensor = details.isSensor;
    this.fixtureDef.restitution = details.restitution;

    switch (details.shape) {
        case "circle":
            this.fixtureDef.shape = new b2CircleShape(details.radius);
            break;
        case "polygon":
            this.fixtureDef.shape = new b2PolygonShape();
            var vertices =[];
            for (var i=0;i<details.points.length;i+=2) {
                vertices.push(new b2Vec2(details.points[i], details.points[i+1]));
            }
            this.fixtureDef.shape.SetAsArray(vertices, vertices.length);
            break;
        case "block":
            this.fixtureDef.shape = new b2PolygonShape();
            this.fixtureDef.shape.SetAsBox(details.width / 2, details.height / 2);
            break;
    }

    this.body.CreateFixture(this.fixtureDef);
};
*/

function KeyonKeydown(event) {
    pressed[event.keyCode] = true;
}

function KeyonKeyup(event) {
    unpressed.push(event.keyCode);
    delete pressed[event.keyCode];
}

// list of fonts: http://www.google.com/fonts/

function ABTween(params, tweenType, tweendedObject, name) {
    this.name=name;
    this.tweentype=tweenType;
    this.easetype = params[0];
    this.duration = params[1]/1000;
    this.looped = params[2];
    this.stop = false;
    this.value1 = params[3];
    this.value2 = params[4];
    this.endvalue1 = params[5];
    this.endvalue2 = params[6];
    this.startValue1=params[3];
    this.startValue2=params[4];
    this.startTime=new Date().getTime();
    this.stepValue1=(this.endvalue1-this.startValue1);
    this.stepValue2=(this.endvalue2-this.startValue2);
    this.direction=1;
    this.numOfTimes=0;
    this.tweendedObject=tweendedObject;

    ABTween.prototype.update = function update() {
        var nuTime = new Date().getTime();
        var t = (nuTime - this.startTime)/1000;
        if (this.direction == -1) {
            t = this.duration - t;
        }
        if (t <= 0 || t >= this.duration) {
            if (this.stop != true) {
                switch (this.looped) {
                    case 0: // stop
                        this.value1 = this.endvalue1;
                        this.value2 = this.endvalue2;
                        switch (this.tweentype) {
                            case "0": //"ABXPPosition":
                                if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                    this.tweendedObject.tilePosition.x = this.value1;
                                    this.tweendedObject.tilePosition.y = this.value2;
                                } else {
                                    this.tweendedObject.position.x = this.value1;
                                    this.tweendedObject.position.y = this.value2;
                                }
                                break;
                            case "5": //"ABXPPositionX":
                                if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                    this.tweendedObject.tilePosition.x = this.value1;
                                } else {
                                    this.tweendedObject.position.x = this.value1;
                                }
                                break;
                            case "6": //"ABXPPositionY":
                                if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                    this.tweendedObject.tilePosition.y = this.value1;
                                } else {
                                    this.tweendedObject.position.y = this.value1;
                                }
                                break;
                            case "1": //"ABXPScale":
                                this.tweendedObject.scale.x = this.value1;
                                this.tweendedObject.scale.y = this.value2;
                                break;
                            case "7": //"ABXPScaleX":
                                this.tweendedObject.scale.x = this.value1;
                                break;
                            case "8": //"ABXPScaleY":
                                this.tweendedObject.scale.y = this.value1;
                                break;
                            case "2": //"ABXPRotation":
                                this.tweendedObject.rotation = this.value1;
                                break;
                            case "3": //"ABXPAlpha":
                                this.tweendedObject.alpha = this.value1;
                                break;
                            default: // custom variable
                                //this.tweendedObject.ABXPVariableValues[this.tweendedObject.ABXPVariableKeys[this.tweentype]] = this.value1;
                                break;
                        }
                        this.stop = true;
                        break;
                    case 1: //restart continuous
                        this.startTime = new Date().getTime();
                        this.direction *= 1;
                        break;
                    case 2: // return
                        this.numOfTimes++;
                        if (this.numOfTimes == 2) {
                            this.value1 = this.startValue1;
                            this.value2 = this.startValue2;
                            switch (this.tweentype) {
                                case "0": //"ABXPPosition":
                                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                        this.tweendedObject.tilePosition.x = this.value1;
                                        this.tweendedObject.tilePosition.y = this.value2;
                                    } else {
                                        this.tweendedObject.position.x = this.value1;
                                        this.tweendedObject.position.y = this.value2;
                                    }
                                    break;
                                case "5": //"ABXPPositionX":
                                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                        this.tweendedObject.tilePosition.x = this.value1;
                                    } else {
                                        this.tweendedObject.position.x = this.value1;
                                    }
                                    break;
                                case "6": //"ABXPPositionY":
                                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                                        this.tweendedObject.tilePosition.y = this.value1;
                                    } else {
                                        this.tweendedObject.position.y = this.value1;
                                    }
                                    break;
                                case "1": //"ABXPScale":
                                    this.tweendedObject.scale.x = this.value1;
                                    this.tweendedObject.scale.y = this.value2;
                                    break;
                                case "7": //"ABXPScaleX":
                                    this.tweendedObject.scale.x = this.value1;
                                    break;
                                case "8": //"ABXPScaleY":
                                    this.tweendedObject.scale.y = this.value1;
                                    break;
                                case "2": //"ABXPRotation":
                                    this.tweendedObject.rotation = this.value1;
                                    break;
                                case "3": //"ABXPAlpha":
                                    this.tweendedObject.alpha = this.value1;
                                    break;
                                default: // custom variable
                                    //this.tweendedObject.ABXPVariableValues[this.tweendedObject.ABXPVariableKeys[this.tweentype]] = this.value1;
                                    break;
                            }
                            this.stop = true;
                        } else {
                            this.startTime = new Date().getTime();
                            this.direction = -1;
                        }
                        break;
                    case 3: // return continuous
                        this.startTime = new Date().getTime();
                        this.direction *= -1;
                        break;
                    default:
                }
            }
        } else {
            switch (this.tweentype) {
                case "0": //"ABXPPosition":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.value2 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue2, this.stepValue2, this.duration);
                    //}
                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                        this.tweendedObject.tilePosition.x = this.value1;
                        this.tweendedObject.tilePosition.y = this.value2;
                    } else {
                        this.tweendedObject.position.x = this.value1;
                        this.tweendedObject.position.y = this.value2;
                    }
                    break;
                case "5": //"ABXPPositionX":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                        this.tweendedObject.tilePosition.x = this.value1;
                    } else {
                        this.tweendedObject.position.x = this.value1;
                    }
                    break;
                case "6": //"ABXPPositionY":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    if (this.tweendedObject instanceof PIXI.TilingSprite) {
                        this.tweendedObject.tilePosition.y = this.value1;
                    } else {
                        this.tweendedObject.position.y = this.value1;
                    }
                    break;
                case "1": //"ABXPScale":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.value2 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue2, this.stepValue2, this.duration);
                    this.tweendedObject.scale.x = this.value1;
                    this.tweendedObject.scale.y = this.value2;
                    break;
                case "7": //"ABXPScaleX":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.tweendedObject.scale.x = this.value1;
                    break;
                case "8": //"ABXPScaleY":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.tweendedObject.scale.y = this.value1;
                    break;
                case "2": //"ABXPRotation":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.tweendedObject.rotation = this.value1;
                    break;
                case "3": //"ABXPAlpha":
                    this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    this.tweendedObject.alpha = this.value1;
                    break;
                default: // custom variable
                    //this.value1 = ABTween.easingFunctions[tweens[this.easetype]](t, this.startValue1, this.stepValue1, this.duration);
                    //this.tweendedObject.ABXPVariableValues[this.tweendedObject.ABXPVariableKeys[this.tweentype]] = this.value1;
                    break;
            }
        }
    };

    ABTween.easingFunctions =
    {
        /*
         t - current time of tween
         b - starting value of property
         c - change needed in value
         d - total duration of tween
         */
        easeNone: function(t, b, c, d) {
            return c*t/d + b;
        },
        easeInQuad: function(t, b, c, d) {
            return c*(t/=d)*t + b;
        },
        easeOutQuad: function(t, b, c, d) {
            return -c *(t/=d)*(t-2) + b;
        },
        easeInOutQuad: function(t, b, c, d) {
            if((t/=d/2) < 1) return c/2*t*t + b;
            return -c/2 *((--t)*(t-2) - 1) + b;
        },
        easeInCubic: function(t, b, c, d) {
            return c*(t/=d)*t*t + b;
        },
        easeOutCubic: function(t, b, c, d) {
            return c*((t=t/d-1)*t*t + 1) + b;
        },
        easeInOutCubic: function(t, b, c, d) {
            if((t/=d/2) < 1) return c/2*t*t*t + b;
            return c/2*((t-=2)*t*t + 2) + b;
        },
        easeOutInCubic: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutCubic(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInCubic((t*2)-d, b+c/2, c/2, d);
        },
        easeInQuart: function(t, b, c, d) {
            return c*(t/=d)*t*t*t + b;
        },
        easeOutQuart: function(t, b, c, d) {
            return -c *((t=t/d-1)*t*t*t - 1) + b;
        },
        easeInOutQuart: function(t, b, c, d) {
            if((t/=d/2) < 1) return c/2*t*t*t*t + b;
            return -c/2 *((t-=2)*t*t*t - 2) + b;
        },
        easeOutInQuart: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutQuart(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInQuart((t*2)-d, b+c/2, c/2, d);
        },
        easeInQuint: function(t, b, c, d) {
            return c*(t/=d)*t*t*t*t + b;
        },
        easeOutQuint: function(t, b, c, d) {
            return c*((t=t/d-1)*t*t*t*t + 1) + b;
        },
        easeInOutQuint: function(t, b, c, d) {
            if((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
            return c/2*((t-=2)*t*t*t*t + 2) + b;
        },
        easeOutInQuint: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutQuint(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInQuint((t*2)-d, b+c/2, c/2, d);
        },
        easeInSine: function(t, b, c, d) {
            return -c * Math.cos(t/d *(Math.PI/2)) + c + b;
        },
        easeOutSine: function(t, b, c, d) {
            return c * Math.sin(t/d *(Math.PI/2)) + b;
        },
        easeInOutSine: function(t, b, c, d) {
            return -c/2 *(Math.cos(Math.PI*t/d) - 1) + b;
        },
        easeOutInSine: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutSine(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInSine((t*2)-d, b+c/2, c/2, d);
        },
        easeInExpo: function(t, b, c, d) {
            return(t==0) ? b : c * Math.pow(2, 10 *(t/d - 1)) + b - c * 0.001;
        },
        easeOutExpo: function(t, b, c, d) {
            return(t==d) ? b+c : c * 1.001 *(-Math.pow(2, -10 * t/d) + 1) + b;
        },
        easeInOutExpo: function(t, b, c, d) {
            if(t==0) return b;
            if(t==d) return b+c;
            if((t/=d/2) < 1) return c/2 * Math.pow(2, 10 *(t - 1)) + b - c * 0.0005;
            return c/2 * 1.0005 *(-Math.pow(2, -10 * --t) + 2) + b;
        },
        easeOutInExpo: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutExpo(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInExpo((t*2)-d, b+c/2, c/2, d);
        },
        easeInCirc: function(t, b, c, d) {
            return -c *(Math.sqrt(1 -(t/=d)*t) - 1) + b;
        },
        easeOutCirc: function(t, b, c, d) {
            return c * Math.sqrt(1 -(t=t/d-1)*t) + b;
        },
        easeInOutCirc: function(t, b, c, d) {
            if((t/=d/2) < 1) return -c/2 *(Math.sqrt(1 - t*t) - 1) + b;
            return c/2 *(Math.sqrt(1 -(t-=2)*t) + 1) + b;
        },
        easeOutInCirc: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutCirc(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInCirc((t*2)-d, b+c/2, c/2, d);
        },
        easeInElastic: function(t, b, c, d, a, p) {
            var s;
            if(t==0) return b;  if((t/=d)==1) return b+c;  if(!p) p=d*.3;
            if(!a || a < Math.abs(c)) { a=c; s=p/4; } else s = p/(2*Math.PI) * Math.asin(c/a);
            return -(a*Math.pow(2,10*(t-=1)) * Math.sin((t*d-s)*(2*Math.PI)/p )) + b;
        },
        easeOutElastic: function(t, b, c, d, a, p) {
            var s;
            if(t==0) return b;  if((t/=d)==1) return b+c;  if(!p) p=d*.3;
            if(!a || a < Math.abs(c)) { a=c; s=p/4; } else s = p/(2*Math.PI) * Math.asin(c/a);
            return(a*Math.pow(2,-10*t) * Math.sin((t*d-s)*(2*Math.PI)/p ) + c + b);
        },
        easeInOutElastic: function(t, b, c, d, a, p) {
            var s;
            if(t==0) return b;  if((t/=d/2)==2) return b+c;  if(!p) p=d*(.3*1.5);
            if(!a || a < Math.abs(c)) { a=c; s=p/4; }       else s = p/(2*Math.PI) * Math.asin(c/a);
            if(t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin((t*d-s)*(2*Math.PI)/p )) + b;
            return a*Math.pow(2,-10*(t-=1)) * Math.sin((t*d-s)*(2*Math.PI)/p )*.5 + c + b;
        },
        easeOutInElastic: function(t, b, c, d, a, p) {
            if(t < d/2) return ABTween.easingFunctions.easeOutElastic(t*2, b, c/2, d, a, p);
            return ABTween.easingFunctions.easeInElastic((t*2)-d, b+c/2, c/2, d, a, p);
        },
        easeInBack: function(t, b, c, d, s) {
            if(s == undefined) s = 1.70158;
            return c*(t/=d)*t*((s+1)*t - s) + b;
        },
        easeOutBack: function(t, b, c, d, s) {
            if(s == undefined) s = 1.70158;
            return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
        },
        easeInOutBack: function(t, b, c, d, s) {
            if(s == undefined) s = 1.70158;
            if((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
            return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
        },
        easeOutInBack: function(t, b, c, d, s) {
            if(t < d/2) return ABTween.easingFunctions.easeOutBack(t*2, b, c/2, d, s);
            return ABTween.easingFunctions.easeInBack((t*2)-d, b+c/2, c/2, d, s);
        },
        easeInBounce: function(t, b, c, d) {
            return c - ABTween.easingFunctions.easeOutBounce(d-t, 0, c, d) + b;
        },
        easeOutBounce: function(t, b, c, d) {
            if((t/=d) <(1/2.75)) {
                return c*(7.5625*t*t) + b;
            } else if(t <(2/2.75)) {
                return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
            } else if(t <(2.5/2.75)) {
                return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
            } else {
                return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
            }
        },
        easeInOutBounce: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeInBounce(t*2, 0, c, d) * .5 + b;
            else return ABTween.easingFunctions.easeOutBounce(t*2-d, 0, c, d) * .5 + c*.5 + b;
        },
        easeOutInBounce: function(t, b, c, d) {
            if(t < d/2) return ABTween.easingFunctions.easeOutBounce(t*2, b, c/2, d);
            return ABTween.easingFunctions.easeInBounce((t*2)-d, b+c/2, c/2, d);
        }
    };
}

this.init = function(iControlID, iBackColor, iViewLeft, iViewTop, iViewWidth, iViewHeight, iScaleType, iShowFPS, iIsInteractive, iGoogleFonts, preloadimageFile, iUseBox2D, iMode) {
    if (iGoogleFonts.length>0) {

        WebFont.load({
            google: {
                families: iGoogleFonts //['Aclonica', 'Acme', 'Alegreya'] //iGoogleFonts
            }
        });
    }
    PIXI.scaleModes.DEFAULT=iMode;

    controlID=iControlID;
    viewLeft=iViewLeft;
    viewTop=iViewTop;
    viewWidth=iViewWidth;
    viewHeight=iViewHeight;
    scaleType = iScaleType;
    showFPS =iShowFPS;
    useBox2D=iUseBox2D;
    if (useBox2D) {
        box2dPhysics = new Physics(1.0, 10,  true, 30, 8, 3);
    }

    tweens.push('easeNone');
    tweens.push('easeInQuad');
    tweens.push('easeOutQuad');
    tweens.push('easeInOutQuad');
    tweens.push('easeInCubic');
    tweens.push('easeOutCubic');
    tweens.push('easeInOutCubic');
    tweens.push('easeOutInCubic');
    tweens.push('easeInQuart');
    tweens.push('easeOutQuart');
    tweens.push('easeInOutQuart');
    tweens.push('easeOutInQuart');
    tweens.push('easeInQuint');
    tweens.push('easeOutQuint');
    tweens.push('easeInOutQuint');
    tweens.push('easeOutInQuint');
    tweens.push('easeInSine');
    tweens.push('easeOutSine');
    tweens.push('easeInOutSine');
    tweens.push('easeOutInSine');
    tweens.push('easeInExpo');
    tweens.push('easeOutExpo');
    tweens.push('easeInOutExpo');
    tweens.push('easeOutInExpo');
    tweens.push('easeInCirc');
    tweens.push('easeOutCirc');
    tweens.push('easeInOutCirc');
    tweens.push('easeOutInCirc');
    tweens.push('easeInElastic');
    tweens.push('easeOutElastic');
    tweens.push('easeInOutElastic');
    tweens.push('easeOutInElastic');
    tweens.push('easeInBack');
    tweens.push('easeOutBack');
    tweens.push('easeInOutBack');
    tweens.push('easeOutInBack');
    tweens.push('easeInBounce');
    tweens.push('easeOutBounce');
    tweens.push('easeInOutBounce');
    tweens.push('easeOutInBounce');

    var tmpView;
    tmpView = document.getElementById(controlID);

    stage = new PIXI.Stage(iBackColor, false);
    scene.position.x = viewWidth/2;
    scene.position.y = viewHeight/2;
    scene.pivot.x = viewWidth/2;
    scene.pivot.y = viewHeight/2;
    scene.ApplyFilters = [];
    scene.interactive = iIsInteractive;
    scene.emitters = {};
    scene.ABXPMaskGraphics = [];
    scene.ABXPMaskGraphicParams = [];
    scene.ABXPName = "ABScene";
    if (scene.interactive) {
        window.addEventListener('keyup', function(event) { KeyonKeyup(event); }, false);
        window.addEventListener('keydown', function(event) { KeyonKeydown(event); }, false);

        scene.buttonMode = true;
        scene.hitArea = new PIXI.Rectangle(0, 0, viewWidth, viewHeight);

        scene.mousedown = scene.touchstart = function (data) {
            scene.data = data;
            mouseEventObjects.push(scene);
        };
        scene.mouseup = scene.mouseupoutside = scene.touchend = scene.touchendoutside = function (data) {
            if (mouseEventObjects.length == 1) {
				b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_clickedself','eventparams': 'x,y', 'x': parseInt(data.getLocalPosition(scene).x,10), 'y': parseInt(data.getLocalPosition(scene).y,10) });
                if (data.stopPropagation)    data.stopPropagation();
                if (data.cancelBubble!=null) data.cancelBubble = true;
                scene.data = null;
                mouseEventObjects.length = 0;
            }
        };

        /*
        scene.mousemove = scene.touchmove = function (data) {

        };
        */
    }

    preloadimage = PIXI.Sprite.fromImage(preloadimageFile);
    preloadimage.position.x = (viewWidth-320)/2;
    preloadimage.position.y = (viewHeight-207)/2;
    scene.addChild(preloadimage);

    //scene.setInteractive(true);
    stage.addChild(scene);

    renderer = PIXI.autoDetectRenderer(viewWidth, viewHeight);
    PIXI.DOM.Setup(renderer, true);

    tmpView.appendChild(renderer.view);

    if (iShowFPS) {
        stats = new Stats();
        stats.setMode(0); // 0: fps, 1: ms

        // Align top-left
        stats.domElement.style.position = 'absolute';
        stats.domElement.style.left = '0px';
        stats.domElement.style.top = '0px';

        document.body.appendChild( stats.domElement );
    }


    window.addEventListener('resize', resize);

    resize();
    render();

	//console.log(controlID);
    if (renderer instanceof PIXI.WebGLRenderer) {
		b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_initialized','eventparams': 'graphicstype', 'graphicstype': 'WebGL'});        
    } else {
		b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_initialized','eventparams': 'graphicstype', 'graphicstype': 'Canvas2D'});        
    }

};

function resize() {
    switch (scaleType) {
        case 0: // none
            renderer.view.setAttribute("style", "position: absolute; display: block; left:" + viewLeft + "px; top:" + viewTop + "px;");
            break;
        case 1: // scale to fill
            renderer.view.setAttribute("style", "position: absolute; display: block; width:100%; height:100%;");
            break;
        case 2: // scale to keep ratio
            var screen_height = window.innerHeight;
            var screen_width = window.innerWidth;
            var ratio = Math.min(screen_width/viewWidth, screen_height/viewHeight);
            var width = viewWidth*ratio;
            var height = viewHeight*ratio;
            var tmpView;
            tmpView = document.getElementById(controlID);
            tmpView.style.left = (screen_width-width)/2+'px' ;
            tmpView.style.top = (screen_height-height)/2+'px';
            renderer.view.style.width = width+'px';
            renderer.view.style.height = height+'px';
            break;
        case 3: // no scale center
            viewLeft = (window.innerWidth - viewWidth)/2;
            viewTop = (window.innerHeight - viewHeight)/2;
            renderer.view.setAttribute("style", "position: absolute; display: block; left:" + viewLeft + "px; top:" + viewTop + "px;");
            for (var doKey in displayObjects) {
                var doObject = displayObjects[doKey];
                if (doObject instanceof PIXI.DOM.Sprite) {
                    doObject.position.x = doObject.ABXPLeft + viewLeft;
                    doObject.position.y = doObject.ABXPTop + viewTop;
                }
            }
            break;
        default:
            renderer.view.setAttribute("style", "position: absolute; display: block; left:" + viewLeft + "px; top:" + viewTop + "px;");
            break;
    }
}

function drawMask(maskObject) {
    var newMask = new PIXI.Graphics();
    newMask.UpdateScript = '';
    newMask.emitters = {};
    newMask.isTweening=false;
    newMask.isMask=true;
    newMask.ABXPName = maskObject.ABXPMaskName;
    var maskx=0;
    var masky=0;
    displayObjects[maskObject.ABXPMaskName] = newMask;
    for (var nn=0;nn<maskObject.ABXPMaskGraphics.length;nn++) {
        //console.log(maskObject.ABXPMaskGraphics[nn]);
        var params = maskObject.ABXPMaskGraphicParams[nn];
        switch (maskObject.ABXPMaskGraphics[nn]) {
            case 0: // clear
                newMask.clear();
                break;
            case 1: // lineStyle
                newMask.lineStyle(params[0], params[1], params[2]);
                break;
            case 2: // moveTo
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.moveTo(params[0]+maskx, params[1]+masky);
                break;
            case 3: // lineTo
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.lineTo(params[0]+maskx, params[1]+masky);
                break;
            case 4: // quadraticCurveTo
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.quadraticCurveTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky);
                break;
            case 5: // bezierCurveTo
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.bezierCurveTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky, params[4]+maskx, params[5]+masky);
                break;
            case 6: // arcTo
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.arcTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky, params[4]);
                break;
            case 7: // arc
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.arc(params[0]+maskx, params[1]+masky, params[2], params[3], params[4], params[5]);
                break;
            case 8: // drawPath
                var pts = [];
                var n=0;
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                for (n = 0; n < params.length; n += 2) {
                    pts.push(params[n]);
                    pts.push(params[n + 1]);
                }
                newMask.drawPath(pts);
                break;
            case 9: // beginFill
                newMask.beginFill(params[0], params[1]);
                break;
            case 10: // endFill
                newMask.endFill();
                break;
            case 11: // drawRect
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.drawRect(params[0]+maskx, params[1]+masky, params[2], params[3]);
                break;
            case 12: // drawRoundedRect
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.drawRoundedRect(params[0]+maskx, params[1]+masky, params[2], params[3], params[4]);
                break;
            case 13: // drawCircle
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.drawCircle(params[0]+maskx, params[1]+masky, params[2]);
                break;
            case 14: // drawEllipse
                maskx=(maskObject.position.x-maskObject.pivot.x)*maskObject.scale.x;
                masky=(maskObject.position.y-maskObject.pivot.y)*maskObject.scale.y;
                newMask.drawEllipse(params[0]+maskx, params[1]+masky, params[2], params[3]);
                break;
            case 16: // lineStyle only width
                newMask.lineStyle(params[0]);
                break;
            case 17: // lineStyle only width and color
                newMask.lineStyle(params[0], params[1]);
                break;
            case 18: // beginFill, only color
                newMask.beginFill(params[0]);
                break;
            case 19: // cache as bitmap
                newMask.cacheAsBitmap = true;
                break;

        }
    }
    newMask.ABXPParent = maskObject;
    maskObject.mask = newMask;
}

this.update = function (iCommands) {
    var tmpRealContainer;
    var displayObject;
    var tmpGraphics;
    var tmpObj;
    var tmpTexture;
    var tmpSprite;
    var head;
    var js;
    var tmpText;
    var tmpHowl;
    var points = [];
    var j = 0;
    var hitParams;
    var maskx=0;
    var masky=0;
	for (var i=0;i<iCommands.length;i++) {
        var command = iCommands[i];
        var objectName =  command[1];
        var params = command[2];
		//console.log(command[0]);
        switch (command[0]) {
            case 0: // clear
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.clear();
                }
                break;
            case 1: // lineStyle
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.lineStyle(params[0], params[1], params[2]);
                }
                break;
            case 2: // moveTo
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx=(displayObject.ABXPParent.position.x-displayObject.ABXPParent.pivot.x)*displayObject.ABXPParent.scale.x;
                        masky=(displayObject.ABXPParent.position.y-displayObject.ABXPParent.pivot.y)*displayObject.ABXPParent.scale.y;
                        displayObject.moveTo(params[0]+maskx, params[1]+masky);
                    } else {
                        displayObject.moveTo(params[0], params[1]);
                    }
                }
                break;
            case 3: // lineTo
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx=(displayObject.ABXPParent.position.x-displayObject.ABXPParent.pivot.x)*displayObject.ABXPParent.scale.x;
                        masky=(displayObject.ABXPParent.position.y-displayObject.ABXPParent.pivot.y)*displayObject.ABXPParent.scale.y;
                        displayObject.lineTo(params[0]+maskx, params[1]+masky);
                    } else {
                        displayObject.lineTo(params[0], params[1]);
                    }
                }
                break;
            case 4: // quadraticCurveTo
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx=(displayObject.ABXPParent.position.x-displayObject.ABXPParent.pivot.x)*displayObject.ABXPParent.scale.x;
                        masky=(displayObject.ABXPParent.position.y-displayObject.ABXPParent.pivot.y)*displayObject.ABXPParent.scale.y;
                        displayObject.quadraticCurveTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky);
                    } else {
                        displayObject.quadraticCurveTo(params[0], params[1], params[2], params[3]);
                    }
                }
                break;
            case 5: // bezierCurveTo
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.bezierCurveTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky, params[4]+maskx, params[5]+masky);
                    } else {
                        displayObject.bezierCurveTo(params[0], params[1], params[2], params[3], params[4], params[5]);
                    }
                }
                break;
            case 6: // arcTo
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.arcTo(params[0]+maskx, params[1]+masky, params[2]+maskx, params[3]+masky, params[4]);
                    } else {
                        displayObject.arcTo(params[0], params[1], params[2], params[3], params[4]);
                    }
                }
                break;
            case 7: // arc
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.arc(params[0]+maskx, params[1]+masky, params[2], params[3], params[4], params[5]);
                    } else {
                        displayObject.arc(params[0], params[1], params[2], params[3], params[4], params[5]);
                    }
                }
                break;
            case 8: // drawPath
                var pts = [];
                var n=0;
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        for (n = 0; n < params.length; n += 2) {
                            pts.push(params[n]);
                            pts.push(params[n + 1]);
                        }
                        displayObject.drawPath(pts);
                    } else {
                        for (n = 0; n < params.length; n += 2) {
                            pts.push(params[n]+maskx);
                            pts.push(params[n + 1]+masky);
                        }
                        displayObject.drawPath(pts);
                    }
                }
                break;
            case 9: // beginFill
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.beginFill(params[0], params[1]);
                }
                break;
            case 10: // endFill
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.endFill();
                }
                break;
            case 11: // drawRect
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.drawRect(params[0]+maskx, params[1]+masky, params[2], params[3]);
                    } else {
                        displayObject.drawRect(params[0], params[1], params[2], params[3]);
                    }
                }
                break;
            case 12: // drawRoundedRect
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.drawRoundedRect(params[0]+maskx, params[1]+masky, params[2], params[3], params[4]);
                    } else {
                        displayObject.drawRoundedRect(params[0], params[1], params[2], params[3], params[4]);
                    }
                }
                break;
            case 13: // drawCircle
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.drawCircle(params[0]+maskx, params[1]+masky, params[2]);
                    } else {
                        displayObject.drawCircle(params[0], params[1], params[2]);
                    }
                }
                break;
            case 14: // drawEllipse
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                        maskx = (displayObject.ABXPParent.position.x - displayObject.ABXPParent.pivot.x) * displayObject.ABXPParent.scale.x;
                        masky = (displayObject.ABXPParent.position.y - displayObject.ABXPParent.pivot.y) * displayObject.ABXPParent.scale.y;
                        displayObject.drawEllipse(params[0]+maskx, params[1]+masky, params[2], params[3]);
                    } else {
                        displayObject.drawEllipse(params[0], params[1], params[2], params[3]);
                    }
                }
                break;
            case 16: // lineStyle only width
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.lineStyle(params[0]);
                }
                break;
            case 17: // lineStyle only width and color
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.lineStyle(params[0], params[1]);
                }
                break;
            case 18: // beginFill, only color
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.beginFill(params[0]);
                }
                break;
            case 19: // cache as bitmap
                if (displayObject) {
                    if (displayObject.ABXPParent) {
                        displayObject.ABXPParent.ABXPMaskGraphics.push(command[0]);
                        displayObject.ABXPParent.ABXPMaskGraphicParams.push(params);
                    }
                    displayObject.cacheAsBitmap = true;
                }
                break;
            case 199: // assets loader
                var assParamNames = params[0];
                var assParamFiles = params[1];
                var assParamTypes = params[2];
                var assParamWidths = params[3];
                var assParamHeights = params[4];
                var assParamTextures = params[5];
                var realFiles = [];

                for (var ass=0;ass<assParamNames.length;ass++) {
                    //console.log(assParamFiles[ass]);
                    switch (assParamTypes[ass]) {
                        case 1: // bitmaps
                            ABXPAssets[assParamNames[ass]] = assParamFiles[ass];
                            realFiles.push(assParamFiles[ass]);
                            hasAssetLoader = true;
                            buildToTextures.push(assParamNames[ass]);
                            buildToTextureWidths.push(assParamWidths[ass]);
                            buildToTextureHeights.push(assParamHeights[ass]);
                            break;
                        case 2:// xml
                            var domparser = new DOMParser();
                            var responseXML = domparser.parseFromString([assParamFiles[ass].split('$SQ$').join("'")], 'text/xml');
                            buildToFonts.push(assParamNames[ass]);
                            buildToFontsXML.push(responseXML);
                            buildToFontsTextures.push(assParamTextures[ass]);
                            break;
                        case 3: // audio
                            ABXPAssets[assParamNames[ass]] = assParamFiles[ass];
                            break;
                        case 4: // json
                            //console.log(assParamFiles[ass]);
                            var json = JSON.parse([assParamFiles[ass].split('$SQ$').join("'")]);
                            buildToMovies.push(assParamNames[ass]);
                            buildToMoviesJSON.push(json);
                            buildToMoviesTextures.push(assParamTextures[ass]);
                            break;
                        case 5: // json spinedata
                            //console.log(assParamFiles[ass]);
                            ABXPAssets[assParamNames[ass]] = assParamFiles[ass];
                            realFiles.push(assParamFiles[ass]);
                            hasAssetLoader = true;

                    }
                }
                if (hasAssetLoader) {
                    loader = new PIXI.AssetLoader(realFiles);

                    // use callback
                    loader.onComplete = onAssetsLoaded;

                    //begin load
                    loader.load();
                }
                break;
            case 200: // new sound
                var buf = ABXPAssets[params[1]];
                //console.log(buf);
                tmpHowl = new Howl({urls: buf,
                    onend: function () {
                        console.log('Finished!');
                    },
                    onplay: function () {
                        console.log('Playing!');
                    },
                    onloaderror: function () {
                        console.log('loadError!');
                    }
                });
                //console.log('New Howl');
                audios[params[0]] = tmpHowl;
                break;
            case 201: //remove sound
                if (params[0] in audios) {
                    tmpHowl = audios[params[0]];
                    tmpHowl.stop();
                    delete audios[params[0]];
                }
                break;
            case 202: // audio play
                //console.log('start Howl');
                tmpHowl = audios[params[0]];
                tmpHowl.loop(params[1]);
                tmpHowl.volume(params[2] / 100);
                tmpHowl.play();
                //console.log('end start Howl');
                break;
            case 203: // audio stop
                tmpHowl = audios[params[0]];
                tmpHowl.stop();
                break;
            case 204: // mute
                tmpHowl = audios[params[0]];
                tmpHowl.mute();
                break;
            case 205: // unmute
                tmpHowl = audios[params[0]];
                tmpHowl.unmute();
                break;
            case 206: // fade
                tmpHowl = audios[params[0]];
                tmpHowl.fade(params[1] / 100, params[2] / 100, params [3]);
                break;
            case 207: // setVolume
                tmpHowl = audios[params[0]];
                tmpHowl.volume(params[1]);
                break;
            case 208: // set loop
                tmpHowl = audios[params[0]];
                tmpHowl.loop(params[1]);
                break;
            case 300: // load emitter
                var emitTexs = [];
                var par1 = params[1];
                for (var tt=0;tt<par1.length;tt++) {
                    emitTexs.push(ABXPAssets[par1[tt]]);
                }
                emitterTextures[params[0]] = emitTexs;
                emitterConfigs[params[0]] = params[2];
                break;
            case 301: // create emitter
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[0] in tmpObj.emitters) {
                        tmpObj.emitters[params[0]].emit = true;
                        tmpObj.emitters[params[0]].updateOwnerPos(params[2], params[3]);
                    } else {
                        tmpObj.emitters[params[0]] = new cloudkid.Emitter(
                            tmpObj,
                            emitterTextures[params[1]],
                            emitterConfigs[params[1]]
                        );
                        tmpObj.emitters[params[0]].draggable=false;
                        tmpObj.emitters[params[0]].ABXPEnabled = true;
                        tmpObj.emitters[params[0]].updateOwnerPos(params[2], params[3]);
                    }
                }
                break;
            case 302: // stop emitter
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[0] in tmpObj.emitters) {
                        tmpObj.emitters[params[0]].emit = false;
                    }
                }
                break;
            case 400: // movie play
                if (displayObject) {
                    displayObject.loop = params[0];
                    displayObject.animationSpeed = params[1];
                    displayObject.play();
                }
                break;
            case 401: // movie goto and play
                if (displayObject) {
                    displayObject.loop = params[0];
                    displayObject.animationSpeed = params[1];
                    displayObject.gotoAndplay(params[2]);
                }
                break;
            case 402: // movie stop
                if (displayObject) {
                   displayObject.stop();
                }
                break;
            case 403: // movie goto and stop
                if (displayObject) {
                    displayObject.gotoAndStop(params[0]);
                }
                break;
            case 404: // set spine play
                if (displayObject) {
                    //console.log(params[0] + "," + params[1]);
                    displayObject.state.setAnimationByName(params[0], params[1]);
                }
                break;
            case 405: // add spine play
                if (displayObject) {
                    //console.log(params[0] + "," + params[1]);
                    displayObject.state.addAnimationByName(params[0], params[1]);
                }
                break;
            case 406: // spine stop
                if (displayObject) {
                    displayObject.state.clearAnimation();
                }
                break;
            case 500: // set active displayObject
                displayObject = displayObjects[objectName];
                //console.log(displayObject);
                break;
            case 501: // Set mask
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    var maskObj = displayObjects[params[0]];
                    if (maskObj) {
                        maskObj.ABXPParent = tmpObj;
                        tmpObj.mask = maskObj;
                        tmpObj.ABXPMaskName = params[0];
                    } else {
                        tmpObj.mask= null;
                    }
                }
                break;
            case 550: // set world parameters
                if (useBox2D) {
                    box2dPhysics = new Physics(params[0], params[1],  params[2], params[3], params[4], params[5]);
                }
                break;
            case 551: // set object box2d properties
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.ABXPUsesBox2D=true;
                    console.log("create body");
                    tmpObj.ABXPBody = new Body(tmpObj, params[0]);
                    tmpObj.ABXPForce = params[0].ABXPForce;
                }
                break;
            case 552: // start collision detection box2d
                if (useBox2D) {
                    box2dPhysics.collision();
                }
                break;
            case 553: // Apply Forces box2d
                if (useBox2D) {
                    if (objectName == '') {
                        tmpObj = scene;
                    } else {
                        tmpObj = displayObjects[objectName];
                    }
                    if (tmpObj) {
                        if (tmpObj.ABXPBody) {
                            switch (params[0]) {
                                case 1: // force
                                    tmpObj.ABXPBody.body.ApplyForce(params[1],tmpObj.ABXPBody.body.GetWorldCenter());
                                    break;
                                case 2:
                                    tmpObj.ABXPBody.body.ApplyForce(params[1],params[2]);
                                    break;
                                case 3: // impulse
                                    tmpObj.ABXPBody.body.ApplyImpulse(params[1],tmpObj.ABXPBody.body.GetWorldCenter());
                                    break;
                                case 4:
                                    tmpObj.ABXPBody.body.ApplyImpulse(params[1],params[2]);
                                    break;
                                case 5: // torque
                                    tmpObj.ABXPBody.body.ApplyTorque(params[1]);
                                    break;
                            }
                        }
                    }
                }
                break;
            case 560: // Joints
                if (useBox2D) {
                    var def;
                    var joint;
                    var jA, jB;
                    switch (params[0]) {
                        case 1: // create
                            switch (params[1]) {
                                case 1: //Distance
                                    jA = displayObjects[params[2]];
                                    jB = displayObjects[params[3]];
                                    if (jA && jB) {
                                        if (jA.ABXPBody && jB.ABXPBody) {
                                            if (params[5] == -1) {
                                                def = new Box2D.Dynamics.Joints.b2DistanceJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, jA.ABXPBody.body.GetWorldCenter(), jB.ABXPBody.body.GetWorldCenter());
                                                def.collideConnected = params[4];
                                                def.length = params[9];
                                                def.frequencyHz = params[10];
                                                def.dampingRatio = params[11];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            } else {
                                                def = new Box2D.Dynamics.Joints.b2DistanceJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, new b2Vec2(params[5], params[6]), new b2Vec2(params[7], params[8]));
                                                def.collideConnected = params[4];
                                                def.length = params[9];
                                                def.frequencyHz = params[10];
                                                def.dampingRatio = params[11];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            }
                                        }
                                    }
                                    break;
                                case 2: // revolute
                                    jA = displayObjects[params[2]];
                                    jB = displayObjects[params[3]];
                                    if (jA && jB) {
                                        if (jA.ABXPBody && jB.ABXPBody) {
                                            def = new Box2D.Dynamics.Joints.b2RevoluteJointDef();
                                            def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, new b2Vec2(params[5], params[6]));
                                            def.collideConnected = params[4];
                                        }
                                    }
                                    break;
                                case 3: // Prismatic
                                    jA = displayObjects[params[2]];
                                    jB = displayObjects[params[3]];
                                    if (jA && jB) {
                                        if (jA.ABXPBody && jB.ABXPBody) {
                                            if (params[5] == -1) {
                                                def = new Box2D.Dynamics.Joints.b2PrismaticJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, jA.ABXPBody.body.GetWorldCenter(), jB.ABXPBody.body.GetWorldCenter());
                                                def.collideConnected = params[4];
                                                def.localAxisA.Set(params[9], params[10]);
                                                def.enableLimit = params[13];
                                                def.lowerTranslation = params[11];
                                                def.upperTranslation = params[12];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            } else {
                                                def = new Box2D.Dynamics.Joints.b2PrismaticJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, new b2Vec2(params[5], params[6]), new b2Vec2(params[7], params[8]));
                                                def.collideConnected = params[4];
                                                def.localAxisA.Set(params[9], params[10]);
                                                def.enableLimit = params[13];
                                                def.lowerTranslation = params[11];
                                                def.upperTranslation = params[12];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            }
                                        }
                                    }
                                    break;
                                case 4: //Pulley
                                    jA = displayObjects[params[2]];
                                    jB = displayObjects[params[3]];
                                    if (jA && jB) {
                                        if (jA.ABXPBody && jB.ABXPBody) {
                                            if (params[5] == -1) {
                                                def = new Box2D.Dynamics.Joints.b2PulleyJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, new b2Vec2(params[9], params[10]), new b2Vec2(params[11], params[12]), jA.ABXPBody.body.GetWorldCenter(), jB.ABXPBody.body.GetWorldCenter(), params[13]);
                                                def.collideConnected = params[4];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            } else {
                                                def = new Box2D.Dynamics.Joints.b2PulleyJointDef();
                                                def.Initialize(jA.ABXPBody.body, jB.ABXPBody.body, new b2Vec2(params[9], params[10]), new b2Vec2(params[11], params[12]), new b2Vec2(params[5], params[6]), new b2Vec2(params[7], params[8]), params[13]);
                                                def.collideConnected = params[4];
                                                joint = box2dPhysics.world.CreateJoint(def);
                                            }
                                        }
                                    }
                                    break;
                            }
                            break;
                        case 2: // remove

                            break;
                    }
                }
                break;
            case 600: // add new displayObject
                switch (params[0]) {
                    case 0: // graphics
                        tmpGraphics = new PIXI.Graphics();
                        tmpGraphics.UpdateScript = '';
                        tmpGraphics.emitters = {};
                        tmpGraphics.isTweening=false;
                        tmpGraphics.isMask=false;
                        tmpGraphics.hasMask=false;
                        if (objectName == '') {
                            tmpGraphics.ABXPName = params[1];
                            scene.addChild(tmpGraphics);
                            displayObjects[params[1]] = tmpGraphics;
                        } else {
                            tmpGraphics.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpGraphics);
                            displayObjects[objectName + '_' + params[1]] = tmpGraphics;
                        }
                        break;
                    case 1: // container
                        tmpRealContainer = new PIXI.DisplayObjectContainer();
                        tmpRealContainer.position.x = params[2];
                        tmpRealContainer.position.y = params[3];
                        tmpRealContainer.interactive = params[4] || params[5];
                        tmpRealContainer.ApplyFilters = [];
                        tmpRealContainer.emitters = {};
                        tmpRealContainer.isTweening=false;
                        tmpRealContainer.ABXPMaskGraphics = [];
                        tmpRealContainer.ABXPMaskGraphicParams = [];
                        tmpRealContainer.ABXPDragXEnabled = params[13];
                        tmpRealContainer.ABXPDragXUseLimitations = params[14];
                        tmpRealContainer.ABXPDragYEnabled = params[16];
                        tmpRealContainer.ABXPDragYUseLimitations = params[17];
                        tmpRealContainer.ABXPBindings = {};
                        tmpRealContainer.ABXPVarInfo =  params[19];

                        if (tmpRealContainer.interactive) {
                            tmpRealContainer.buttonMode = true;
                            hitParams = params[6];
                            switch (hitParams[0]) {
                                case 0: // none
                                    break;
                                case 1: // rectangle
                                    tmpRealContainer.hitArea = new PIXI.Rectangle(hitParams[1], hitParams[2], hitParams[3], hitParams[4]);
                                    break;
                                case 2: // circle
                                    tmpRealContainer.hitArea = new PIXI.Circle(hitParams[1], hitParams[2], hitParams[3]);
                                    break;
                                case 3: // polygon
                                    points.length = 0;
                                    for (j = 1; j < hitParams.length; j += 2) {
                                        points.push(new PIXI.Point(hitParams[j], hitParams[j + 1]));
                                    }
                                    tmpRealContainer.hitArea = new PIXI.Polygon(points);
                                    break;
                                default:
                                    break;
                            }
                            tmpRealContainer.clickable = params[4];
                            tmpRealContainer.draggable = params[5];

                            tmpRealContainer.mousedown = tmpRealContainer.touchstart = function (data) {
								if (!(this.isTweening)) {
                                    if (this.draggable) {
										this.data = data;
                                        this.sx = (this.data.getLocalPosition(this).x - this.pivot.x) * this.scale.x;
                                        this.sy = (this.data.getLocalPosition(this).y - this.pivot.y) * this.scale.y;
                                        this.cancelClick=false;
                                        if (this.parent) {
                                            var parent = this.parent;
                                            parent.removeChild(this);
                                            parent.addChild(this);
                                        }
                                        mouseEventObjects.push(this);
								
                                    } else {
                                        if (this.clickable) {
                                            this.data = data;
                                            this.cancelClick=false;
                                            if (this.parent) {
                                                var parent = this.parent;
                                                parent.removeChild(this);
                                                parent.addChild(this);
                                            }
                                            mouseEventObjects.push(this);
                                        }
                                    }
                                }
                            };
                            tmpRealContainer.mouseup = tmpRealContainer.mouseupoutside = tmpRealContainer.touchend = tmpRealContainer.touchendoutside = function (data) {
                                    if (isDragging) {
                                        if (dragObject.dragging) {
                                            isDragging = false;
                                            dragObject.dragging = false;
                                            var upd = "";
                                            upd="'[" + (dragObject.ABXPName + ";2;" + (dragObject.position.x) + ";" + (dragObject.position.y)) +"]'";
                                            dragObject.data = null;
                                            if (dragObject.ABXPUsesBox2D) {
                                                if (mouseJoint) {
                                                    box2dPhysics.world.DestroyJoint(mouseJoint);
                                                    mouseJoint = null;
                                                }
                                                console.log("mouseJoint Destroyed");
                                            }
                                            dragObject = null;
                                            mouseEventObjects.length = 0;

											b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_updates','eventparams': 'value', 'value': upd});
                                        }
                                    } else {
                                        isDragging = false;
                                        dragObject = null;
                                        if (mouseEventObjects.length > 1) {
                                            var tmpObject = mouseEventObjects[mouseEventObjects.length - 1];
                                            if (tmpObject) {
                                                if (tmpObject.clickable) {
                                                    if (!(tmpObject.isTweening)) {
                                                        //console.log(tmpObject.ABXPName);
                                                        if (!(tmpObject.cancelClick)) {
                                                            b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_clickedcontainer','eventparams': 'containername,x,y', 'containername': tmpObject.ABXPName, 'x': parseInt(data.getLocalPosition(scene).x,10), 'y': parseInt(data.getLocalPosition(scene).y,10) });
                                                        }
                                                        if (data.stopPropagation)    data.stopPropagation();
                                                        if (data.cancelBubble != null) data.cancelBubble = true;
                                                        tmpObject.data = null;
                                                        mouseEventObjects.length = 0;
                                                    }
                                                }
                                            }
                                        }
                                    }

                            };
                            tmpRealContainer.mousemove = tmpRealContainer.touchmove = function (data) {
									if (!dragObject && mouseEventObjects.length > 0) {
										var tmpObject = mouseEventObjects[mouseEventObjects.length - 1];
                                        if (!(tmpObject.isTweening)) {

                                            if (tmpObject.draggable) {
                                                dragObject = tmpObject; //mouseEventObjects[mouseEventObjects.length - 1];
                                                dragObject.dragging = true;
                                                isDragging = true;

                                                if (dragObject.ABXPUsesBox2D) {
                                                    var newPosition = dragObject.data.getLocalPosition(dragObject.parent);
                                                    var pixPerMeter = box2dPhysics.pixPerMeter;
                                                    var dragBody = tmpObject.ABXPBody.body; //getBodyAtMouse(newPosition.x/pixPerMeter, newPosition.y/pixPerMeter);
                                                    if(dragBody)
                                                    {
                                                        var jointDef = new Box2D.Dynamics.Joints.b2MouseJointDef();
                                                        jointDef.bodyA = box2dPhysics.world.GetGroundBody();
                                                        jointDef.bodyB = dragBody;
                                                        jointDef.target.Set(newPosition.x/pixPerMeter, newPosition.y/pixPerMeter);
                                                        jointDef.collideConnected = true;
                                                        jointDef.maxForce = tmpObject.ABXPForce * dragBody.GetMass();
                                                        mouseJoint = box2dPhysics.world.CreateJoint(jointDef);
                                                        dragBody.SetAwake(true);
                                                        console.log("mouseJoint created");
                                                    }
                                                }
                                            } else {
                                                tmpObject.cancelClick = true;
                                            }

                                        }
                                    }
                                    if (isDragging) {
                                        var tmpBindObject;
                                        var tmpBindKey;
                                        var tmpBind;
                                        var newPosition = dragObject.data.getLocalPosition(dragObject.parent);
                                        /*
                                        if (dragObject.ABXPDragXEnabled) {
                                            if (dragObject.ABXPDragXUseLimitations) {
                                                dragObject.position.x = Math.min(Math.max(Math.floor(newPosition.x - dragObject.sx), dragObject.ABXPDragXMin), dragObject.ABXPDragXMax);
                                                for (tmpBindKey in dragObject.ABXPBindings) {
                                                    tmpBind = dragObject.ABXPBindings[tmpBindKey];
                                                    tmpBind.ABXPValueX = tmpBind.ABXPRangeXMin + ((dragObject.position.x - dragObject.ABXPDragXMin) / (dragObject.ABXPDragXMax - dragObject.ABXPDragXMin) * (tmpBind.ABXPRangeXMax - tmpBind.ABXPRangeXMin));
                                                }
                                            } else {
                                                dragObject.position.x = Math.floor(newPosition.x - dragObject.sx);
                                            }
                                        }
                                        if (dragObject.ABXPDragYEnabled) {
                                            if (dragObject.ABXPDragYUseLimitations) {
                                                dragObject.position.y = Math.min(Math.max(Math.floor(newPosition.y - dragObject.sy), dragObject.ABXPDragYMin), dragObject.ABXPDragYMax);
                                                for (tmpBindKey in dragObject.ABXPBindings) {
                                                    tmpBind = dragObject.ABXPBindings[tmpBindKey];
                                                    tmpBind.ABXPValueY = tmpBind.ABXPRangeYMin + ((dragObject.position.y - dragObject.ABXPDragYMin) / (dragObject.ABXPDragYMax - dragObject.ABXPDragYMin) * (tmpBind.ABXPRangeYMax - tmpBind.ABXPRangeYMin));
                                                }
                                            } else {
                                                dragObject.position.y = Math.floor(newPosition.y - dragObject.sy);
                                            }
                                        }
                                        */
                                        if (dragObject.ABXPDragXEnabled) {
                                            if (dragObject.ABXPDragXUseLimitations) {
                                                dragObject.position.x = Math.min(Math.max(Math.floor(newPosition.x - dragObject.sx), dragObject.ABXPDragXMin), dragObject.ABXPDragXMax);
                                            } else {
                                                dragObject.position.x = Math.floor(newPosition.x - dragObject.sx);
                                            }
                                        }
                                        if (dragObject.ABXPDragYEnabled) {
                                            if (dragObject.ABXPDragYUseLimitations) {
                                                dragObject.position.y = Math.min(Math.max(Math.floor(newPosition.y - dragObject.sy), dragObject.ABXPDragYMin), dragObject.ABXPDragYMax);
                                            } else {
                                                dragObject.position.y = Math.floor(newPosition.y - dragObject.sy);
                                            }
                                        }

                                        for (tmpBindKey in dragObject.ABXPBindings) {
                                            tmpBind = dragObject.ABXPBindings[tmpBindKey];
                                            tmpBindObject = displayObjects[tmpBind.ABXPBindObject];
                                            if (tmpBindObject) {
                                                //console.log("dragObject.ABXPVarInfo: " + dragObject.ABXPVarInfo);
                                                switch (dragObject.ABXPVarInfo) {
                                                    case "X":
                                                        tmpBind.ABXPValueX = tmpBind.ABXPRangeXMin + ((dragObject.position.x - dragObject.ABXPDragXMin) / (dragObject.ABXPDragXMax - dragObject.ABXPDragXMin) * (tmpBind.ABXPRangeXMax - tmpBind.ABXPRangeXMin));
                                                        tmpBind.ABXPValueY = tmpBind.ABXPValueX;
                                                        //tmpBindObject.position.x = tmpBindObject.scale.x * ((tmpBind.ABXPValueX - tmpBind.ABXPSmallestX) * tmpBind.ABXPStepX + tmpBindObject.ABXPDragXMin);
                                                        break;
                                                    case "Y":
                                                        tmpBind.ABXPValueY = tmpBind.ABXPRangeYMin + ((dragObject.position.y - dragObject.ABXPDragYMin) / (dragObject.ABXPDragYMax - dragObject.ABXPDragYMin) * (tmpBind.ABXPRangeYMax - tmpBind.ABXPRangeYMin));
                                                        tmpBind.ABXPValueX = tmpBind.ABXPValueY;
                                                        //tmpBindObject.position.y = tmpBindObject.scale.y * ((tmpBind.ABXPValueY - tmpBind.ABXPSmallestY) * tmpBind.ABXPStepY + tmpBindObject.ABXPDragYMin);
                                                        break;
                                                    case "XY":
                                                        tmpBind.ABXPValueX = tmpBind.ABXPRangeXMin + ((dragObject.position.x - dragObject.ABXPDragXMin) / (dragObject.ABXPDragXMax - dragObject.ABXPDragXMin) * (tmpBind.ABXPRangeXMax - tmpBind.ABXPRangeXMin));
                                                        tmpBind.ABXPValueY = tmpBind.ABXPRangeYMin + ((dragObject.position.y - dragObject.ABXPDragYMin) / (dragObject.ABXPDragYMax - dragObject.ABXPDragYMin) * (tmpBind.ABXPRangeYMax - tmpBind.ABXPRangeYMin));
                                                        //tmpBindObject.position.x = tmpBindObject.scale.x * ((tmpBind.ABXPValueX - tmpBind.ABXPSmallestX) * tmpBind.ABXPStepX + tmpBindObject.ABXPDragXMin);
                                                        //tmpBindObject.position.y = tmpBindObject.scale.y * ((tmpBind.ABXPValueY - tmpBind.ABXPSmallestY) * tmpBind.ABXPStepY + tmpBindObject.ABXPDragYMin);
                                                        break;
                                                }
                                            }
                                            PerformActions(dragObject, tmpBind);
                                            //console.log(tmpBind.ABXPValueX + "," + tmpBind.ABXPValueY);
                                        }

                                        if (dragObject.ABXPUsesBox2D) {
                                            if (mouseJoint) {
                                                var pixPerMeter = box2dPhysics.pixPerMeter;
                                                mouseJoint.SetTarget(new b2Vec2(dragObject.position.x / pixPerMeter, dragObject.position.y / pixPerMeter));
                                                console.log("mouseJoint moved");
                                            }

                                        }
                                        if (dragObject.hasMask) {
                                            drawMask(dragObject);
                                        }
                                    }

                            };

                        }
                        tmpRealContainer.UpdateScript = '';
                        tmpRealContainer.ABXPWidth = params[7]*2;
                        tmpRealContainer.ABXPHeight = params[8]*2;
                        tmpRealContainer.hasMask=false;
                        tmpRealContainer.ABXPDragXSmallest=0;
                        tmpRealContainer.ABXPDragYSmallest=0;
                        if (objectName == '') {
                            tmpRealContainer.position.x = tmpRealContainer.position.x + params[7];
                            tmpRealContainer.position.y = tmpRealContainer.position.y + params[8];
                            tmpRealContainer.pivot.x = params[7];
                            tmpRealContainer.pivot.y = params[8];
                            tmpRealContainer.ABXPDragXMin = params[15].ABXPFrom+params[7];
                            tmpRealContainer.ABXPDragXMax = params[15].ABXPTo+params[7];
                            tmpRealContainer.ABXPDragYMin = params[18].ABXPFrom+params[8];
                            tmpRealContainer.ABXPDragYMax = params[18].ABXPTo+params[8];

                            tmpRealContainer.alpha = params[9];
                            tmpRealContainer.rotation = params[10];
                            tmpRealContainer.scale.x = params[11];
                            tmpRealContainer.scale.y = params[12];

                            tmpRealContainer.ABXPName = params[1];

                            scene.addChild(tmpRealContainer);
                            displayObjects[params[1]] = tmpRealContainer;
                        } else {
                            tmpRealContainer.position.x = tmpRealContainer.position.x + params[7];
                            tmpRealContainer.position.y = tmpRealContainer.position.y + params[8];
                            tmpRealContainer.pivot.x = params[7];
                            tmpRealContainer.pivot.y = params[8];
                            tmpRealContainer.ABXPDragXMin = params[15].ABXPFrom+params[7];
                            tmpRealContainer.ABXPDragXMax = params[15].ABXPTo+params[7];
                            tmpRealContainer.ABXPDragYMin = params[18].ABXPFrom+params[8];
                            tmpRealContainer.ABXPDragYMax = params[18].ABXPTo+params[8];

                            tmpRealContainer.alpha = params[9];
                            tmpRealContainer.rotation = params[10];
                            tmpRealContainer.scale.x = params[11];
                            tmpRealContainer.scale.y = params[12];

                            tmpRealContainer.ABXPName = objectName + '_' + params[1];

                            displayObjects[objectName].addChild(tmpRealContainer);
                            displayObjects[objectName + '_' + params[1]] = tmpRealContainer;
                        }
                        break;
                    case 2: // sprite
                        if (params[11] == 1) {
                            tmpSprite = new PIXI.Sprite.fromImage(params[2]);
                            tmpSprite.position.x = params[3] + params[9] / 2;
                            tmpSprite.position.y = params[4] + params[10] / 2;
                            tmpSprite.ABXPWidth = params[9];
                            tmpSprite.ABXPHeight = params[10];
                        } else {
                            tmpTexture = ABXPAssets[params[2]];
                            tmpSprite = new PIXI.Sprite(tmpTexture);
                            tmpSprite.position.x = params[3] + tmpTexture.ABXPWidth / 2;
                            tmpSprite.position.y = params[4] + tmpTexture.ABXPHeight / 2;
                            tmpSprite.ABXPWidth = tmpTexture.ABXPWidth;
                            tmpSprite.ABXPHeight = tmpTexture.ABXPHeight;
                        }
                        tmpSprite.anchor.x = 0.5;
                        tmpSprite.anchor.y = 0.5;
                        tmpSprite.alpha = params[5];
                        tmpSprite.rotation = params[6];
                        tmpSprite.scale.x = params[7];
                        tmpSprite.scale.y = params[8];
                        tmpSprite.UpdateScript = '';
                        tmpSprite.emitters = {};
                        tmpSprite.isTweening=false;
                        tmpSprite.hasMask=false;
						if (objectName == '') {
                            tmpSprite.ABXPName = params[1];
                            scene.addChild(tmpSprite);
                            displayObjects[params[1]] = tmpSprite;
                        } else {
                            tmpSprite.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpSprite);
                            displayObjects[objectName + '_' + params[1]] = tmpSprite;
                        }
                        break;
                    case 4: // tiling Sprite
                        tmpTexture = ABXPAssets[params[2]];
                        tmpSprite = new PIXI.TilingSprite(tmpTexture, tmpTexture.ABXPWidth, tmpTexture.ABXPHeight);
                        tmpSprite.ABXPWidth = tmpTexture.ABXPWidth;
                        tmpSprite.ABXPHeight = tmpTexture.ABXPHeight;
                        tmpSprite.position.x = params[3] + tmpTexture.ABXPWidth / 2;
                        tmpSprite.position.y = params[4] + tmpTexture.ABXPHeight / 2;
                        tmpSprite.anchor.x = 0.5;
                        tmpSprite.anchor.y = 0.5;
                        tmpSprite.alpha = params[5];
                        tmpSprite.rotation = params[6];
                        tmpSprite.scale.x = params[7];
                        tmpSprite.scale.y = params[8];
                        tmpSprite.tilePosition.x = params[9];
                        tmpSprite.tilePosition.y = params[10];
                        tmpSprite.tileScale.x = params[11];
                        tmpSprite.tileScale.y = params[12];
                        tmpSprite.UpdateScript = '';
                        tmpSprite.emitters = {};
                        tmpSprite.isTweening=false;
                        tmpSprite.hasMask=false;

                        if (objectName == '') {
                            tmpSprite.ABXPName = params[1];
                            scene.addChild(tmpSprite);
                            displayObjects[params[1]] = tmpSprite;
                        } else {
                            tmpSprite.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpSprite);
                            displayObjects[objectName + '_' + params[1]] = tmpSprite;
                        }
                        break;
                    case 5: // text object
                        if (params[10] == 1) {
                            tmpText = new PIXI.Text(params[2], params[3]);
                            tmpText.anchor.x = 0.5;
                            tmpText.anchor.y = 0.5;
                        } else {
                            tmpText = new PIXI.BitmapText(params[2], params[3]);
                            tmpText.pivot.x = tmpText.width / 2;
                            tmpText.pivot.y = tmpText.height / 2;
                        }
                        tmpText.ABXPWidth = tmpText.width;
                        tmpText.ABXPHeight = tmpText.height;
                        tmpText.position.x = params[4] + tmpText.width / 2;
                        tmpText.position.y = params[5] + tmpText.height / 2;

                        tmpText.alpha = params[6];
                        tmpText.rotation = params[7];
                        tmpText.scale.x = params[8];
                        tmpText.scale.y = params[9];

                        tmpText.UpdateScript = '';
                        tmpText.emitters = {};
                        tmpText.isTweening=false;
                        tmpText.hasMask=false;

                        if (objectName == '') {
                            tmpText.ABXPName = params[1];
                            scene.addChild(tmpText);
                            displayObjects[params[1]] = tmpText;
                        } else {
                            tmpText.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpText);
                            displayObjects[objectName + '_' + params[1]] = tmpText;
                        }
                        break;
                    case 8: // dom sprite
                        var tmpSpriteDom = new PIXI.DOM.Sprite(params[2], params[3]);
                        tmpSpriteDom.ABXPLeft = tmpSpriteDom.position.x;
                        tmpSpriteDom.ABXPTop = tmpSpriteDom.position.y;
                        tmpSpriteDom.position.x=tmpSpriteDom.ABXPLeft+viewLeft;
                        tmpSpriteDom.position.y=tmpSpriteDom.ABXPTop+viewLeft;
                        tmpSpriteDom.anchor.x = 0.5;
                        tmpSpriteDom.anchor.y = 0.5;
                        tmpSpriteDom.UpdateScript='';
                        tmpSpriteDom.emitters = {};
                        tmpSpriteDom.isTweening = false;
                        tmpSpriteDom.hasMask=false;
                        if (objectName=='') {
                            tmpSpriteDom.ABXPName = params[1];
                            scene.addChild(tmpSpriteDom);
                            displayObjects[params[1]] = tmpSpriteDom;
                        } else {
                            tmpSpriteDom.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpSpriteDom);
                            displayObjects[objectName+'_'+params[1]] = tmpSpriteDom;
                        }
                        break;
                    case 9: // movieclip
                        var tmpMovie;
                        switch (params[2]) {
                            case 1:  // SpriteSheetMovie
                                var movFrame = ABXPAssets[params[3]];
                                tmpMovie = new PIXI.MovieClip(movFrame);
                                tmpMovie.ABXPWidth = 0; //movFrame.texture.width;
                                tmpMovie.ABXPHeight = 0; //movFrame.texture.height;
                                tmpMovie.position.x = params[4] + tmpMovie.ABXPWidth / 2;
                                tmpMovie.position.y = params[5] + tmpMovie.ABXPHeight / 2;
                                tmpMovie.anchor.x = 0.5;
                                tmpMovie.anchor.y = 0.5;

                                tmpMovie.onComplete = function() {
                                setTimeout(function(t) {
                                         if (!(tmpMovie.loop)) {
                                            tmpMovie.parent.removeChild(t);
                                            b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_objectremoved','eventparams': 'objectname', 'objectname': tmpMovie.ABXPName });
                                         }
                                     }, 15, this);
                                };

                                break;
                            case 2: // spineMovie
                                tmpMovie = new PIXI.Spine(ABXPAssets[params[3]]);
                                tmpMovie = new PIXI.Spine(ABXPAssets[params[3]]);
                                tmpMovie.ABXPWidth = tmpMovie.width;
                                tmpMovie.ABXPHeight = tmpMovie.height;
                                //console.log(tmpMovie.width + "," + tmpMovie.height);
                                tmpMovie.position.x = params[4] + tmpMovie.ABXPWidth / 2;
                                tmpMovie.position.y = params[5] + tmpMovie.ABXPHeight / 2;
                                tmpMovie.pivot.x = tmpMovie.width / 2;
                                tmpMovie.pivot.y = tmpMovie.height / 2;
                                var mixes = params[10];
                                for (var mi=0;mi<mixes.length;mi++) {
                                    var mix = mixes[mi];
                                    //console.log(mix);
                                    tmpMovie.stateData.setMixByName(mix[0], mix[1], mix[2]);
                                }
                                break;
                        }
                        tmpMovie.alpha = params[6];
                        tmpMovie.rotation = params[7];
                        tmpMovie.scale.x = params[8];
                        tmpMovie.scale.y = params[9];
                        tmpMovie.UpdateScript = '';
                        tmpMovie.emitters = {};
                        tmpMovie.isTweening=false;
                        tmpMovie.hasMask=false;
                        if (objectName=='') {
                            tmpMovie.ABXPName = params[1];
                            scene.addChild(tmpMovie);
                            displayObjects[params[1]] = tmpMovie;
                        } else {
                            tmpMovie.ABXPName = objectName + '_' + params[1];
                            displayObjects[objectName].addChild(tmpMovie);
                            displayObjects[objectName+'_'+params[1]] = tmpMovie;
                        }
                        break;
                    case 10: // load tile map and build texture from it
                        tmpRealContainer = new PIXI.DisplayObjectContainer();
                        tmpRealContainer.position.x = params[2];
                        tmpRealContainer.position.y = params[3];
                        tmpRealContainer.interactive = params[4] || params[5];
                        tmpRealContainer.ApplyFilters = [];
                        tmpRealContainer.emitters = {};
                        tmpRealContainer.isTweening=false;
                        tmpRealContainer.ABXPTmxAssets = {};
                        tmpRealContainer.ABXPTmxLayers = {};
                        tmpRealContainer.ABXPMaskGraphics = [];
                        tmpRealContainer.ABXPMaskGraphicParams = [];
                        tmxloader.load(params[13].split('$SQ$').join("'").split('$10$').join("\n"));
                        tmpRealContainer.tmxloader=tmxloader;
                        var tileWidth = 0;
                        var tileHeight = 0;
                        var w = 0;
                        var h = 0;
                        var x=0;
                        var y=0;
                        for (var tsi=0;tsi<tmpRealContainer.tmxloader.map.tilesets.length;tsi++) {
                            var realTileSet = tmpRealContainer.tmxloader.map.tilesets[tsi];
                            var startGid = realTileSet.firstGid;
                            tileWidth = realTileSet.tileWidth*1; // to make sure it is a number, not a string
                            tileHeight = realTileSet.tileHeight*1; // to make sure it is a number, not a string
                            w = realTileSet.width;
                            h = realTileSet.height;
                            var xw = w/tileWidth;
                            var yh = h/tileHeight;

                            var tmpTex = ABXPAssets[realTileSet.name];
                            for (y=0;y<yh;y++) {
                                for (x=0;x<xw;x++) {
                                    //var srcTextureSize = new PIXI.Rectangle(0, 0, tileWidth, tileHeight);
                                    var textureSize = new PIXI.Rectangle(x*tileWidth, y*tileHeight, tileWidth, tileHeight);
                                    var crop = textureSize.clone();
                                    var trim = null;
                                    //console.log(startGid + ":" + x + "," + y + "," + tileWidth + "," + tileHeight);
                                    tmpRealContainer.ABXPTmxAssets[startGid] = new PIXI.Texture(tmpTex, textureSize, crop, trim);
                                    startGid++;
                                }
                            }
                        }
                        for (var li=0;li<tmpRealContainer.tmxloader.map.layers.length;li++) {


                            var tmpLayer = tmpRealContainer.tmxloader.map.layers[li];
                            var tmpVisible = tmpLayer.properties["display"];
                            if (tmpVisible==='true') {
                                tileWidth = tmpRealContainer.tmxloader.map.tileWidth;
                                tileHeight = tmpRealContainer.tmxloader.map.tileHeight;
                                w = tmpLayer.width;
                                h = tmpLayer.height;
                                var tmpTileMap = new PIXI.DisplayObjectContainer();
                                tmpTileMap.tilesWidth = w;
                                tmpTileMap.tilesHeight = h;
                                tmpTileMap.tileWidth = tileWidth;
                                tmpTileMap.tileHeight = tileHeight;
                                tmpTileMap.scale.x = params[11];
                                tmpTileMap.scale.y = params[12];
                                tmpTileMap.startLocation = { x: 0, y: 0 };
                                var gid;
                                var tile;
                                for (y = 0; y < h; y++) {
                                    for (x = 0; x < w; x++) {
                                        gid = tmpLayer.data[y][x];
                                        if (gid > 0) {
                                            tile = new PIXI.Sprite(tmpRealContainer.ABXPTmxAssets[gid]);
                                            tile.position.x = x * tileWidth;
                                            tile.position.y = y * tileHeight;
                                            tile.tileX = x;
                                            tile.tileY = y;
                                            tmpTileMap.addChild(tile);
                                        } else {
                                            tile = new PIXI.Sprite(tmpRealContainer.ABXPTmxAssets[1]);
                                            tile.position.x = x * tileWidth;
                                            tile.position.y = y * tileHeight;
                                            tile.tileX = x;
                                            tile.tileY = y;
                                            tile.visible = false;
                                            tmpTileMap.addChild(tile);
                                        }
                                    }
                                }
                                tmpRealContainer.ABXPTmxLayers[tmpLayer.name] = li;
                                tmpRealContainer.addChild(tmpTileMap);
                            }
                        }

                        if (tmpRealContainer.interactive) {
                            tmpRealContainer.buttonMode = true;
                            hitParams = params[6];
                            switch (hitParams[0]) {
                                case 0: // none
                                    break;
                                case 1: // rectangle
                                    tmpRealContainer.hitArea = new PIXI.Rectangle(hitParams[1], hitParams[2], hitParams[3], hitParams[4]);
                                    break;
                                case 2: // circle
                                    tmpRealContainer.hitArea = new PIXI.Circle(hitParams[1], hitParams[2], hitParams[3]);
                                    break;
                                case 3: // polygon
                                    points.length = 0;
                                    for (j = 1; j < hitParams.length; j += 2) {
                                        points.push(new PIXI.Point(hitParams[j], hitParams[j + 1]));
                                    }
                                    tmpRealContainer.hitArea = new PIXI.Polygon(points);
                                    break;
                                default:
                                    break;
                            }
                            tmpRealContainer.clickable = params[4];
                            tmpRealContainer.draggable = params[5];
                            

                        }
                        tmpRealContainer.UpdateScript = '';
                        tmpRealContainer.ABXPWidth = params[7]*2;
                        tmpRealContainer.ABXPHeight = params[8]*2;
                        tmpRealContainer.hasMask=false;
                        if (objectName == '') {
                            tmpRealContainer.position.x = tmpRealContainer.position.x + params[7];
                            tmpRealContainer.position.y = tmpRealContainer.position.y + params[8];
                            tmpRealContainer.pivot.x = params[7];
                            tmpRealContainer.pivot.y = params[8];

                            tmpRealContainer.alpha = params[9];
                            tmpRealContainer.rotation = params[10];
                            tmpRealContainer.scale.x = params[11];
                            tmpRealContainer.scale.y = params[12];

                            tmpRealContainer.ABXPName = params[1];

                            //console.log("adding: " + params[1]);

                            scene.addChild(tmpRealContainer);
                            displayObjects[params[1]] = tmpRealContainer;
                        } else {
                            tmpRealContainer.position.x = tmpRealContainer.position.x + params[7];
                            tmpRealContainer.position.y = tmpRealContainer.position.y + params[8];
                            tmpRealContainer.pivot.x = params[7];
                            tmpRealContainer.pivot.y = params[8];

                            tmpRealContainer.alpha = params[9];
                            tmpRealContainer.rotation = params[10];
                            tmpRealContainer.scale.x = params[11];
                            tmpRealContainer.scale.y = params[12];

                            tmpRealContainer.ABXPName = objectName + '_' + params[1];

                            //console.log("adding: " + objectName + '_' + params[1]);

                            displayObjects[objectName].addChild(tmpRealContainer);
                            displayObjects[objectName + '_' + params[1]] = tmpRealContainer;
                        }
                        break;
                    case 11: // mask graphics
                        tmpGraphics = new PIXI.Graphics();
                        tmpGraphics.UpdateScript = '';
                        tmpGraphics.emitters = {};
                        tmpGraphics.isTweening=false;
                        tmpGraphics.isMask=true;
                        if (objectName == '') {
                            tmpGraphics.ABXPName = params[1];
                            scene.hasMask=true;
                            //tmpGraphics.visible = false;
                            //scene.addChild(tmpGraphics);
                            displayObjects[params[1]] = tmpGraphics;
                        } else {
                            tmpGraphics.ABXPName = objectName + '_' + params[1];
                            //tmpGraphics.visible = false;
                            //displayObjects[objectName].addChild(tmpGraphics);
                            displayObjects[objectName].hasMask=true;
                            displayObjects[objectName + '_' + params[1]] = tmpGraphics;
                        }
                        break;
                    default:
                }
                break;
            case 601: // set sprite tint
                 if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.tint = params[0];
                }
                break;
            case 602: // set blend mode
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.blendMode = params[0];
                }
                break;
            case 603: // remove object
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    var remChild = displayObjects[params[0]];
                    if (remChild) {
                        ToRemoveObjects.push(remChild);
                    }
                }
                break;
            case 700: // start tween
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.isTweening=true;
                    activeTweens[params[2]] = new ABTween(params[1], params[0], tmpObj, params[2]);
                }
                break;
            case 701: // stop tween
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.stop=true;
                }
                break;
            case 800: // activate filter
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    for (var f=0;f<tmpObj.ApplyFilters.length;f++) {
                        if (tmpObj.ApplyFilters[f].ABXPType==params[0]) {
                            tmpObj.ApplyFilters.splice(f,1);
                            break;
                        }
                    }
                    switch (params[0]) {
                        case 1: // Displacement filter
                            tmpTexture = ABXPAssets[params[1]];
                            tmpFilter = new PIXI.DisplacementFilter(tmpTexture);
                            tmpFilter.scale.x = params[2];
                            tmpFilter.scale.y = params[3];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 2: // blur
                            tmpFilter = new PIXI.BlurFilter();
                            tmpFilter.blurX = params[1];
                            tmpFilter.blurY = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 3: // pixelate
                            tmpFilter = new PIXI.PixelateFilter();
                            tmpFilter.size.x = params[1];
                            tmpFilter.size.y = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 4: // invert
                            tmpFilter = new PIXI.InvertFilter();
                            tmpFilter.invert = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 5: // grayscale
                            tmpFilter = new PIXI.GrayFilter();
                            tmpFilter.gray = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 6: // Sepia
                            tmpFilter = new PIXI.SepiaFilter();
                            tmpFilter.sepia = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 7: // Twist
                            tmpFilter = new PIXI.TwistFilter();
                            tmpFilter.ABXPType = params[0];
                            tmpFilter.angle = params[1];
                            tmpFilter.radius = params[2];
                            tmpFilter.offset.x = params[3];
                            tmpFilter.offset.y = params[4];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 8: // dotScreen
                            tmpFilter = new PIXI.DotScreenFilter();
                            tmpFilter.angle = params[1];
                            tmpFilter.scale = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 9: // ColorStep
                            tmpFilter = new PIXI.ColorStepFilter();
                            tmpFilter.step = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 10: // CrossHatch
                            tmpFilter = new PIXI.CrossHatchFilter();
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 11: // RGBSplitter
                            tmpFilter = new PIXI.RGBSplitFilter();
                            tmpFilter.red.x = params[1];
                            tmpFilter.red.y = params[2];
                            tmpFilter.green.x = params[3];
                            tmpFilter.green.y = params[4];
                            tmpFilter.blue.x = params[5];
                            tmpFilter.blue.y = params[6];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                        case 12: // Smart Blur
                            tmpFilter = new PIXI.SmartBlurFilter();
                            tmpFilter.blur = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter);
                            tmpObj.filters = tmpObj.ApplyFilters;

                            break;
                        /*
                        case 13: // tilt shift
                            var tmpFilter2 = new PIXI.TiltShiftFilter();
                            tmpFilter2.blur = params[1];
                            tmpFilter2.gradientBlur = params[2];
                            tmpFilter2.start = {x:params[3], y:params[4]};
                            tmpFilter2.end = {x:params[5], y:params[6]};
                            //console.log(tmpFilter.blur + "," + tmpFilter.gradientBlur + "," +tmpFilter.start.x + "," + tmpFilter.start.y + "," + tmpFilter.end.x + "," + tmpFilter.end.y);
                            tmpFilter2.ABXPType = params[0];
                            tmpObj.ApplyFilters.push(tmpFilter2);
                            tmpObj.filters = tmpObj.ApplyFilters;
                            break;
                            */
                    }
                }
                break;
            case 801: // deactivate filter
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    for (var f2=0;f2<tmpObj.ApplyFilters.length;f2++) {
                        if (tmpObj.ApplyFilters[f2].ABXPType==params[0]) {
                            tmpObj.ApplyFilters.splice(f2,1);
                            break;
                        }
                    }
                    tmpObj.filters = tmpObj.ApplyFilters.length > 0 ? tmpObj.ApplyFilters : null;
                }
                break;
            case 802: // activate filter (shader)
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.shader = null;
                    var tmpFilter;
                    switch (params[0]) {
                        case 1: // Displacement filter
                            tmpTexture = ABXPAssets[params[1]];
                            tmpFilter = new PIXI.DisplacementFilter(tmpTexture);
                            tmpFilter.scale.x = params[2];
                            tmpFilter.scale.y = params[3];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 2: // blur
                            /*
                            tmpFilter = new PIXI.BlurFilter();
                            tmpFilter.blurX = params[1];
                            tmpFilter.blurY = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            */
                            break;
                        case 3: // pixelate
                            tmpFilter = new PIXI.PixelateFilter();
                            tmpFilter.size.x = params[1];
                            tmpFilter.size.y = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 4: // invert
                            tmpFilter = new PIXI.InvertFilter();
                            tmpFilter.invert = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 5: // grayscale
                            tmpFilter = new PIXI.GrayFilter();
                            tmpFilter.gray = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 6: // Sepia
                            tmpFilter = new PIXI.SepiaFilter();
                            tmpFilter.sepia = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 7: // Twist
                            tmpFilter = new PIXI.TwistFilter();
                            tmpFilter.ABXPType = params[0];
                            tmpFilter.angle = params[1];
                            tmpFilter.radius = params[2];
                            tmpFilter.offset.x = params[3];
                            tmpFilter.offset.y = params[4];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 8: // dotScreen
                            tmpFilter = new PIXI.DotScreenFilter();
                            tmpFilter.angle = params[1];
                            tmpFilter.scale = params[2];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 9: // ColorStep
                            tmpFilter = new PIXI.ColorStepFilter();
                            tmpFilter.step = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 10: // CrossHatch
                            tmpFilter = new PIXI.CrossHatchFilter();
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 11: // RGBSplitter
                            tmpFilter = new PIXI.RGBSplitFilter();
                            tmpFilter.red.x = params[1];
                            tmpFilter.red.y = params[2];
                            tmpFilter.green.x = params[3];
                            tmpFilter.green.y = params[4];
                            tmpFilter.blue.x = params[5];
                            tmpFilter.blue.y = params[6];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 12: // Smart Blur
                            tmpFilter = new PIXI.SmartBlurFilter();
                            tmpFilter.blur = params[1];
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            break;
                        case 13: // tilt shift
                            /*
                            tmpFilter = new PIXI.TiltShiftFilter();
                            tmpFilter.blur = params[1];
                            tmpFilter.gradientBlur = params[2];
                            tmpFilter.start = {x: params[3], y: params[4]};
                            tmpFilter.end = {x: params[5], y: params[6]};
                            tmpFilter.ABXPType = params[0];
                            tmpObj.shader = tmpFilter;
                            */
                    }
                }
                break;
            case 803: // deactivate filter
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.shader = null;
                }
                break;
            case 900: // set custom variable
                /*
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[0] in tmpObj.ABXPVariableKeys) {
                        var tmpIndex = tmpObj.ABXPVariableKeys[params[0]];
                        tmpObj.ABXPVariableValues[tmpIndex] = params[1];
                    } else {
                        tmpObj.ABXPVariableNames.push(params[0]);
                        tmpObj.ABXPVariableValues.push(params[1]);
                        tmpObj.ABXPVariableKeys[params[0]] = tmpObj.ABXPVariableNames.length-1;
                    }
                }
                break;
                */
            case 901: // set object properties
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    switch (params[0]) {
                        case 1: // positionX
                            if (tmpObj instanceof PIXI.DOM.Sprite) {
                                tmpObj.position.x = params[1];
                            }else {
                                tmpObj.position.x = params[1]; // + tmpObj.ABXPWidth / 2;
                            }
                            break;
                        case 2: // positionY
                            if (tmpObj instanceof PIXI.DOM.Sprite) {
                                tmpObj.position.y = params[1];
                            }else {
                                tmpObj.position.y = params[1]; // + tmpObj.ABXPHeight / 2;
                            }
                            break;
                        case 3: // scaleX
                            tmpObj.scale.x = params[1];
                            break;
                        case 4: // scaleY
                            tmpObj.scale.y = params[1];
                            break;
                        case 5: // rotation
                            tmpObj.rotation = params[1];
                            break;
                        case 6: // alpha
                            tmpObj.alpha = params[1];
                            break;
                        case 7: // box2d rotation

                            break;
                        case 8: // box2d position X

                            break;
                        case 9: // box2 position Y

                            break;
                        default:
                    }
                }
                break;
            case 920: // bind an object with the value of another
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                //console.log("Erin " + params[1]);
                if (tmpObj) {
                    var tmpObj2 = displayObjects[params[1]];
                    if (tmpObj2) {
                        //console.log("Erin 2 " + params[1]);
                        var smallestX;
                        var smallestY;
                        var stepX;
                        var stepY;
                        if (params[4].ABXPFrom <= params[4].ABXPTo) {
                            stepX = (tmpObj.ABXPDragXMax - tmpObj.ABXPDragXMin) / (params[4].ABXPTo - params[4].ABXPFrom);
                            smallestX = params[4].ABXPFrom;
                        } else {
                            params[2]*=-1;
                            stepX = (tmpObj.ABXPDragXMax - tmpObj.ABXPDragXMin) / (params[4].ABXPFrom - params[4].ABXPTo);
                            smallestX = params[4].ABXPTo;
                        }
                        if (params[5].ABXPFrom <= params[5].ABXPTo) {
                            stepY = (tmpObj.ABXPDragYMax - tmpObj.ABXPDragYMin) / (params[5].ABXPTo - params[5].ABXPFrom);
                            smallestY = params[5].ABXPFrom;
                        } else {
                            params[3]*=-1;
                            stepY = (tmpObj.ABXPDragYMax - tmpObj.ABXPDragYMin) / (params[5].ABXPFrom - params[5].ABXPTo);
                            smallestY = params[5].ABXPTo;
                        }

                        var tmpBind = {ABXPBindObject: params[1], ABXPBindType: params[0], ABXPBindFactorX: params[2], ABXPBindFactorY: params[3], ABXPRangeXMin: params[4].ABXPFrom, ABXPRangeXMax: params[4].ABXPTo, ABXPRangeYMin: params[5].ABXPFrom, ABXPRangeYMax: params[5].ABXPTo, ABXPSmallestX: smallestX, ABXPSmallestY: smallestY, ABXPStepX: stepX, ABXPStepY: stepY, ABXPValueX: 0, ABXPValueY: 0, ABXPVarInfo: params[6]};

                        switch (tmpBind.ABXPVarInfo) {
                            case "XY":
                                //console.log("Erin 3 " + params[1]);
                                tmpBind.ABXPValueX = tmpBind.ABXPRangeXMin+((tmpObj.position.x - tmpObj.ABXPDragXMin) / (tmpObj.ABXPDragXMax - tmpObj.ABXPDragXMin) * (tmpBind.ABXPRangeXMax - tmpBind.ABXPRangeXMin));
                                tmpBind.ABXPValueY = tmpBind.ABXPRangeYMin+((tmpObj.position.y - tmpObj.ABXPDragYMin) / (tmpObj.ABXPDragYMax - tmpObj.ABXPDragYMin) * (tmpBind.ABXPRangeYMax - tmpBind.ABXPRangeYMin));
                                break;
                            case "XX":
                                //console.log("Erin 4 " + params[1]);
                                tmpBind.ABXPValueX = tmpBind.ABXPRangeXMin+((tmpObj.position.x - tmpObj.ABXPDragXMin) / (tmpObj.ABXPDragXMax - tmpObj.ABXPDragXMin) * (tmpBind.ABXPRangeXMax - tmpBind.ABXPRangeXMin));
                                tmpBind.ABXPValueY = tmpBind.ABXPValueX;
                                break;
                            case "YY":
                                //console.log("Erin 5 " + params[1]);
                                tmpBind.ABXPValueY = tmpBind.ABXPRangeYMin+((tmpObj.position.y - tmpObj.ABXPDragYMin) / (tmpObj.ABXPDragYMax - tmpObj.ABXPDragYMin) * (tmpBind.ABXPRangeYMax - tmpBind.ABXPRangeYMin));
                                tmpBind.ABXPValueX = tmpBind.ABXPValueY;
                                break;
                        }

                        //console.log("Erin 6 " + params[1]);
                        tmpObj.ABXPBindings[params[0]] = tmpBind;
                        PerformActions(tmpObj, tmpBind);

                       //console.log(tmpObj.ABXPBindings[params[0]].ABXPBindObject);
                    }
                }
                break;
            case 921: // Unbind
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[0] in tmpObj.ABXPBindings) {
                        delete tmpObj.ABXPBindings[params[0]];
                    }
                }
                break;
            case 922: // set bind value
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[0] in tmpObj.ABXPBindings) {
                        tmpBind = tmpObj.ABXPBindings[params[0]];
                        switch (tmpObj.ABXPVarInfo) {
                            case "X":
                                tmpBind.ABXPValueX = params[1];
                                tmpBind.ABXPValueY = tmpBind.ABXPValueX;
                                tmpObj.position.x = tmpObj.scale.x * ((tmpBind.ABXPValueX - tmpBind.ABXPSmallestX) * tmpBind.ABXPStepX + tmpObj.ABXPDragXMin);
                                break;
                            case "Y":
                                tmpBind.ABXPValueY = params[2];
                                tmpBind.ABXPValueX = tmpBind.ABXPValueY;
                                tmpObj.position.y = tmpObj.scale.y * ((tmpBind.ABXPValueY - tmpBind.ABXPSmallestY) * tmpBind.ABXPStepY + tmpObj.ABXPDragYMin);
                                break;
                            case "XY":
                                tmpBind.ABXPValueX = params[1];
                                tmpBind.ABXPValueY = params[2];
                                tmpObj.position.x = tmpObj.scale.x * ((tmpBind.ABXPValueX - tmpBind.ABXPSmallestX) * tmpBind.ABXPStepX + tmpObj.ABXPDragXMin);
                                tmpObj.position.y = tmpObj.scale.y * ((tmpBind.ABXPValueY - tmpBind.ABXPSmallestY) * tmpBind.ABXPStepY + tmpObj.ABXPDragYMin);
                                break;
                        }
                        PerformActions(tmpObj, tmpBind);
                    }
                }
                break;
            case 950: // set object script
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    if (params[2]=='') {
                        switch (params[0]) {
                            case 0: // update script
                                tmpObj.UpdateScript = '';
                                break;
                            default:
                        }
                    }
                    head = document.getElementsByTagName("head")[0];
                    var checkme = document.getElementById(params[1]);
                    if (checkme) {
                        head.removeChild(checkme);
                    }

                    if (params[2]!=='') {
                        js = document.createElement("script");
                        js.type = "text/javascript";
                        js.setAttribute("id",params[1]);
                        var st = document.createTextNode(params[2]);
                        js.appendChild(st);
                        head.appendChild(js);
                        switch (params[0]) {
                            case 0: // update script
                                tmpObj.UpdateScript = params[1];
                                break;
                            default:
                        }
                    }
                }
                break;
            case 975: // set text
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                   tmpObj.setText(params[0]);
                }
                break;
            case 976: // set text style
                if (objectName=='') {
                    tmpObj=scene;
                } else {
                    tmpObj=displayObjects[objectName];
                }
                if (tmpObj) {
                    tmpObj.setStyle(params[0]);
                }
                break;

            default:

        }
    }
    if (isPreloading && !hasAssetLoader) {
        isPreloading=false;
		b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_preloadcomplete','eventparams': ''});
    }
};

function PerformActions(tmpObj, tmpBind) {
        var tmpBindObject;

        tmpBindObject = displayObjects[tmpBind.ABXPBindObject];
        if (tmpBindObject) {
                switch (tmpBind.ABXPBindType) {
                    case 0: // position
                        switch (tmpBind.ABXPVarInfo) {
                            case "XY":
                                tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.position.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                            case "XX":
                                tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.position.y = tmpBindObject.scale.y * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPHeight / 2);
                                break;
                            case "YY":
                                tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.position.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 1: // scale
                        switch (tmpBind.ABXPVarInfo) {
                            case "XY":
                                tmpBindObject.scale.x = tmpBind.ABXPValueX * Math.abs(tmpBind.ABXPBindFactorX);
                                tmpBindObject.scale.y = tmpBind.ABXPValueY * Math.abs(tmpBind.ABXPBindFactorY);
                                break;
                            case "XX":
                                tmpBindObject.scale.x = tmpBind.ABXPValueX * Math.abs(tmpBind.ABXPBindFactorX);
                                tmpBindObject.scale.y = tmpBindObject.scale.x;
                                break;
                            case "YY":
                                tmpBindObject.scale.y = tmpBind.ABXPValueY * Math.abs(tmpBind.ABXPBindFactorY);
                                tmpBindObject.scale.x = tmpBindObject.scale.y;
                                break;
                        }
                        break;
                    case 2: // rotation
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.rotation = tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX * Math.PI / 180;
                                break;
                            case "YY":
                                tmpBindObject.rotation = tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY * Math.PI / 180;
                                break;
                        }
                        break;
                    case 3: // alpha
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.alpha = tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX / 255;
                                break;
                            case "YY":
                                tmpBindObject.alpha = tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY / 255;
                                break;
                        }
                        break;
                    case 4: // custom variable
                        // not used yet
                        break;
                    case 5: // positionX
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                // werkt als Eric start op scale 2, en ik tmpBind.ABXPBindFactorX dan ook op 2 zet
                                //tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX*2 + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                break;
                            case "YY":
                                tmpBindObject.position.x = tmpBindObject.scale.x * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 6: // positionY
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.position.y = tmpBindObject.scale.y * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                break;
                            case "YY":
                                tmpBindObject.position.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 7: // scaleX
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.scale.x = tmpBind.ABXPValueX * Math.abs(tmpBind.ABXPBindFactorX);
                                break;
                            case "YY":
                                tmpBindObject.scale.x = tmpBind.ABXPValueY * Math.abs(tmpBind.ABXPBindFactorY);
                                break;
                        }
                        break;
                    case 8: // scaleY
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.scale.y = tmpBind.ABXPValueX * Math.abs(tmpBind.ABXPBindFactorX);
                                break;
                            case "YY":
                                tmpBindObject.scale.y = tmpBind.ABXPValueY * Math.abs(tmpBind.ABXPBindFactorY);
                                break;
                        }
                        break;
                    case 9: // tilePosition
                        switch (tmpBind.ABXPVarInfo) {
                            case "XY":
                                tmpBindObject.tilePosition.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.tilePosition.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                            case "XX":
                                tmpBindObject.tilePosition.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.tilePosition.y = tmpBindObject.scale.y * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPHeight / 2);
                                break;
                            case "YY":
                                tmpBindObject.tilePosition.x = tmpBindObject.scale.x * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPWidth / 2);
                                tmpBindObject.tilePosition.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 10: // tilePositionX
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.tilePosition.x = tmpBindObject.scale.x * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                break;
                            case "YY":
                                tmpBindObject.tilePosition.x = tmpBindObject.scale.x * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 11: // tilePositionY
                        switch (tmpBind.ABXPVarInfo) {
                            case "XX":
                                tmpBindObject.tilePosition.y = tmpBindObject.scale.y * (tmpBind.ABXPValueX * tmpBind.ABXPBindFactorX + tmpBindObject.ABXPWidth / 2);
                                break;
                            case "YY":
                                tmpBindObject.tilePosition.y = tmpBindObject.scale.y * (tmpBind.ABXPValueY * tmpBind.ABXPBindFactorY + tmpBindObject.ABXPHeight / 2);
                                break;
                        }
                        break;
                    case 12: // filter

                        break;

            }
            if (tmpBindObject.ABXPBindings) {
                for (var tmpBindKey in tmpBindObject.ABXPBindings) {
                    var tmpBind2 = tmpBindObject.ABXPBindings[tmpBindKey];
                    switch (tmpBindObject.ABXPVarInfo) {
                        case "X":
                            tmpBind2.ABXPValueX = tmpBind2.ABXPRangeXMin + ((tmpBindObject.position.x - tmpBindObject.ABXPDragXMin) / (tmpBindObject.ABXPDragXMax - tmpBindObject.ABXPDragXMin) * (tmpBind2.ABXPRangeXMax - tmpBind2.ABXPRangeXMin));
                            tmpBind2.ABXPValueY = tmpBind2.ABXPValueX;
                            break;
                        case "Y":
                            tmpBind2.ABXPValueY = tmpBind2.ABXPRangeYMin + ((tmpBindObject.position.y - tmpBindObject.ABXPDragYMin) / (tmpBindObject.ABXPDragYMax - tmpBindObject.ABXPDragYMin) * (tmpBind2.ABXPRangeYMax - tmpBind2.ABXPRangeYMin));
                            tmpBind2.ABXPValueX = tmpBind2.ABXPValueY;
                            break;
                        case "XY":
                            tmpBind2.ABXPValueX = tmpBind2.ABXPRangeXMin + ((tmpBindObject.position.x - tmpBindObject.ABXPDragXMin) / (tmpBindObject.ABXPDragXMax - tmpBindObject.ABXPDragXMin) * (tmpBind2.ABXPRangeXMax - tmpBind2.ABXPRangeXMin));
                            tmpBind2.ABXPValueY = tmpBind2.ABXPRangeYMin + ((tmpBindObject.position.y - tmpBindObject.ABXPDragYMin) / (tmpBindObject.ABXPDragYMax - tmpBindObject.ABXPDragYMin) * (tmpBind2.ABXPRangeYMax - tmpBind2.ABXPRangeYMin));
                            break;
                    }
                    PerformActions(tmpBindObject, tmpBind2);
                }
            }
        }

}

function onAssetsLoaded() {
    var i=0;
    var tmpTexture;
    //console.log("assets loaded")
    for (i=0;i<buildToTextures.length;i++) {
        tmpTexture = new PIXI.Texture.fromImage(ABXPAssets[buildToTextures[i]]);
        tmpTexture.ABXPWidth = buildToTextureWidths[i];
        tmpTexture.ABXPHeight = buildToTextureHeights[i];
        ABXPAssets[buildToTextures[i]] = tmpTexture;
    }
    for (i=0;i<buildToFonts.length;i++) {
        tmpTexture = ABXPAssets[buildToFontsTextures[i]];
        var responseXML = buildToFontsXML[i];

        var data = {};
        var info = responseXML.getElementsByTagName('info')[0];
        var common = responseXML.getElementsByTagName('common')[0];
        data.font = info.getAttribute('face');
        data.size = parseInt(info.getAttribute('size'), 10);
        data.lineHeight = parseInt(common.getAttribute('lineHeight'), 10);
        data.chars = {};

        //parse letters
        var letters = responseXML.getElementsByTagName('char');

        var i2=0;
        for (i2 = 0; i2 < letters.length; i2++)
        {
            var charCode = parseInt(letters[i2].getAttribute('id'), 10);

            var textureRect = new PIXI.Rectangle(
                parseInt(letters[i2].getAttribute('x'), 10),
                parseInt(letters[i2].getAttribute('y'), 10),
                parseInt(letters[i2].getAttribute('width'), 10),
                parseInt(letters[i2].getAttribute('height'), 10)
            );

            data.chars[charCode] = {
                xOffset: parseInt(letters[i2].getAttribute('xoffset'), 10),
                yOffset: parseInt(letters[i2].getAttribute('yoffset'), 10),
                xAdvance: parseInt(letters[i2].getAttribute('xadvance'), 10),
                kerning: {},
                texture: PIXI.TextureCache[charCode] = new PIXI.Texture(tmpTexture, textureRect)

            };
        }

        //parse kernings
        var kernings = responseXML.getElementsByTagName('kerning');
        for (i2 = 0; i2 < kernings.length; i2++)
        {
            var first = parseInt(kernings[i2].getAttribute('first'), 10);
            var second = parseInt(kernings[i2].getAttribute('second'), 10);
            var amount = parseInt(kernings[i2].getAttribute('amount'), 10);

            data.chars[second].kerning[first] = amount;

        }

        PIXI.BitmapText.fonts[data.font] = data;
    }

    for (i=0;i<buildToMovies.length;i++) {
        tmpTexture = ABXPAssets[buildToMoviesTextures[i]];
        var json = buildToMoviesJSON[i];
        var frameData = json.frames;
        var currTextures = [];
        if(json.frames) {
            for (var j in frameData)
            {
                var rect = frameData[j].frame;
                //console.log(j);

                if (rect)
                {
                    var textureSize = new PIXI.Rectangle(rect.x, rect.y, rect.w, rect.h);
                    var crop = textureSize.clone();
                    var trim = null;

                    //  Check to see if the sprite is trimmed
                    if (frameData[j].trimmed)
                    {
                        var actualSize = frameData[j].sourceSize;
                        var realSize = frameData[j].spriteSourceSize;
                        trim = new PIXI.Rectangle(realSize.x, realSize.y, actualSize.w, actualSize.h);
                    }
                    PIXI.TextureCache[j] = new PIXI.Texture(tmpTexture, textureSize, crop, trim);
                    currTextures.push(PIXI.Texture.fromFrame(j));
                }
            }
            //console.log(buildToMovies[i]);
            ABXPAssets[buildToMovies[i]] = currTextures;
        }
        else if(json.bones)
        {
            // spine animation
            var spineJsonParser = new spine.SkeletonJson();
            var skeletonData = spineJsonParser.readSkeletonData(json);
            //console.log(buildToMovies[i]);
            PIXI.AnimCache[buildToMovies[i]] = skeletonData;

        }
    }

	b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_preloadcomplete','eventparams': ''});
}

this.start = function() {
	//console.log("starting");
    isRunning=true;
    box2dLastFrame=new Date().getTime();
		(render);
};

this.showpreload = function() {
    isRunning=true;
    isPreloading =true;
};

this.hidepreload = function() {
    isPreloading=false;
    scene.removeChild(preloadimage);
};

this.stop = function() {
    isRunning=false;
};

function render() {
	//console.log("rendering");
    if (showFPS) stats.begin();

    if (useBox2D) {
        if (box2dPhysics) {
            for (var torem=0;torem<ToRemoveObjects.length;torem++) {
                var remChild = ToRemoveObjects[torem];
                if (remChild) {
                    if (remChild.ABXPBody) {
                        box2dPhysics.world.DestroyBody(remChild.ABXPBody);
                    }
                    remChild.parent.removeChild(remChild);
                }
            }

            var tm = new Date().getTime();
            var dt = (tm - box2dLastFrame) / 1000;
            if (dt > 1 / 15) {
                dt = 1 / 15;
            }
            box2dPhysics.step(dt);
            box2dPhysics.world.ClearForces();
            box2dLastFrame = tm;
            var box2dObjs = box2dPhysics.world.GetBodyList();
            var pixPerMeter = box2dPhysics.pixPerMeter;
            while (box2dObjs) {
                var realObj = displayObjects[box2dObjs.GetUserData()];
                if (realObj) {
                    var pos = box2dObjs.GetPosition();
                    //console.log(pos.x);
                    realObj.position.x = pos.x * pixPerMeter;
                    realObj.position.y = pos.y * pixPerMeter;
                    realObj.rotation = box2dObjs.GetAngle();
                }
                box2dObjs = box2dObjs.GetNext();
            }
        } else {
            for (var torem=0;torem<ToRemoveObjects.length;torem++) {
                var remChild = ToRemoveObjects[torem];
                if (remChild) {
                    remChild.parent.removeChild(remChild);
                }
            }
        }
    } else {
        for (var torem=0;torem<ToRemoveObjects.length;torem++) {
            var remChild = ToRemoveObjects[torem];
            if (remChild) {
                remChild.parent.removeChild(remChild);
            }
        }
    }



    var updates = "'";
    var upd;

    for (var aKey in activeTweens) {
        var aTween = activeTweens[aKey];
        if (!aTween.stop) {
            aTween.update();
            if (aTween.stop) {
                removeTweens[aKey] = '1';
                aTween.tweendedObject.isTweening=false;
                if (!(aTween.tweendedObject instanceof PIXI.Graphics)) {
                   upd = aTween.tweendedObject.ABXPName + ";1;" + aTween.tweentype + ";" + aTween.value1 + ";" + aTween.value2;
                   updates+="[" + upd + "],";
                }
            }
        } else {
            removeTweens[aKey]='1';
        }
    }
    for (var key in removeTweens) {
        delete activeTweens[key];
    }

    removeTweens = {};

    var now = Date.now();
    var emKey;
    var emObject;
    for (var doKey in displayObjects) {
        var doObject = displayObjects[doKey];
        if (doObject && doObject.UpdateScript!=='') {
            window[doObject.UpdateScript](doObject);
        }
        for (emKey in doObject.emitters) {
            emObject = doObject.emitters[emKey];
            if (emObject.ABXPEnabled) {
                emObject.update((now - emitterElapsed) * 0.001);
            }
        }
    }



    for (emKey in scene.emitters) {
        emObject = scene.emitters[emKey];
        if (emObject.ABXPEnabled) {
            emObject.update((now - emitterElapsed) * 0.001);
        }
    }
    emitterElapsed = now;

    renderer.render(stage);

    for (var keyKey in pressed) {
        updates+="[" + ("ABScene;3;" + keyKey) + "],";
    }

    for (var keyKey2=0;keyKey2<unpressed.length;keyKey2++) {
        updates+="[" + ("ABScene;4;" + unpressed[keyKey2]) + "],";
    }
    unpressed.length = 0;

    if (useBox2D) {
        for (var beginC=0;beginC<contactsBegin.length;beginC++) {
            updates+="[" + ("ABScene;5;" + contactsBegin[beginC]) + "],";
        }
        contactsBegin.length = 0;
        for (var endC=0;endC<contactsEnd.length;endC++) {
            updates+="[" + ("ABScene;6;" + contactsEnd[endC]) + "],";
        }
        contactsEnd.length = 0;
    }

	if (updates!="'") {        
		updates=updates.substring(0, updates.length-1);
		updates+="'";
		b4j_raiseEvent('page_parseevent', {'eventname': controlID + '_updates','eventparams': 'value', 'value': updates});
    }

    if (isRunning) {
        requestAnimationFrame(render);
    }
    if (showFPS) stats.end();
};

};
