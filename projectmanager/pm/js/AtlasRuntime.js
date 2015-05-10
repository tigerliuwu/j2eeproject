// Copyright (c) Microsoft Corporation. All rights reserved.

var RuntimeVersion="0.090405.0";

if(!document.head)document.head=document.getElementsByTagName("HEAD")[0];

function registerNamespace(b)

{

    var rootObject=window;

    var namespaceParts=b.split(".");

    for(var i=0;i<namespaceParts.length;i++)

    {

        var currentPart=namespaceParts[i];

        if(!rootObject[currentPart])rootObject[currentPart]=new Object();

        rootObject=rootObject[currentPart];

    }

}

registerNamespace("Web.Debug.Performance");

if(!Web.Debug.enabled)

{

    Web.Debug.enabled=false;

    Web.Debug.trace=function()

    {

    };

    Web.Debug.ASSERT=function()

    {

        return Web.Debug.ASSERT;

    };

    Web.Debug.Performance.start=function()

    {

        this.end=function()

        {

        };

        return this;

    };

}

String.prototype.lTrim=function()

{

    return this.replace(/^\s*/,"");

};

String.prototype.rTrim=function()

{

    return this.replace(/\s*$/,"");

};

String.prototype.trim=function()

{

    return this.rTrim().lTrim();

};

String.prototype.endsWith=function(c)

{

    return this.substr(this.length-c.length)==c;

};

String.prototype.startsWith=function(e)

{

    return this.substr(0,e.length)==e;

};

String.prototype.format=function()

{

    var s=this;

    for(var i=0;i<arguments.length;i++)

    {

        s=s.replace("{"+i+"}",arguments[i]);

    }

    return s;

};

String.prototype.removeSpaces=function()

{

    return this.replace(/ /ig,"");

};

String.prototype.removeExtraSpaces=function()

{

    return this.replace(String.prototype.removeExtraSpaces.re," ");

};

String.prototype.removeExtraSpaces.re=new RegExp("\\s+","g");

String.prototype.removeSpaceDelimitedString=function(r)

{

    var s=" "+this.trim()+" ";

    return s.replace(" "+r,"").rTrim();

};

String.prototype.encodeURI=function()

{

    var returnString;

    returnString=escape(this);

    returnString=returnString.replace(/\+/g,"%2B");

    return returnString;

};

String.prototype.decodeURI=function()

{

    return unescape(this);

};

Web.StringBuilder=function(g)

{

    var arrParts=new Array();

    this.append=function(h)

    {

        if(!(h==null||typeof h=="undefined"||typeof h=="string"&&h.length==0))arrParts.push(h);

    };

    this.appendLine=function(j)

    {

        this.append(j);

        arrParts.push("\r\n");

    };

    this.clear=function()

    {

        arrParts.clear();

    };

    this.isEmpty=function()

    {

        return arrParts.length==0;

    };

    this.toString=function(k)

    {

        return arrParts.join(k||"");

    };

    this.append(g);

    return this;

};

registerNamespace("Web.Type");

Web.Type.resolve=function(l)

{

    try

    {

        if(typeof l=="string")l=eval(l);

        else

        {

            if(typeof l=="object")l=l.constructor;

            else

            {

                if(typeof l!="function")l=null;

            }

        }

    }

    catch(ex)

    {

        return null;

    }

    return l;

};

Web.Type.compare=function(m,n)

{

    var fncTypeA=Web.Type.resolve(m);

    var fncTypeB=Web.Type.resolve(n);

    return fncTypeA&&fncTypeA==fncTypeB;

};

Web.Type.IsString=function(o)

{

    return typeof p_var=="string";

};

Web.Type.isArray=function(p)

{

    return p instanceof Array;

};

Web.Type.isBoolean=function(q)

{

    return typeof q=="boolean";

};

Object.getFromName=function(r)

{

    var obj;

    try

    {

        eval("obj = "+r);

    }

    catch(ex)

    {

        return undefined;

    }

    return obj;

};

Function.prototype.registerBaseMethod=function(s,t)

{

    if(!s._baseMethods)s._baseMethods=

    {

    };

    var methodKey=this._typeName+"."+t;

    s._baseMethods[methodKey]=s[t];

};

Function.prototype.getBaseMethod=function(u,v,w)

{

    if(w)

    {

        if(u)

        {

            if(u._baseMethods)

            {

                var strKey=w+"."+v;

                return u._baseMethods[strKey];

            }

        }

        else

        {

            var fncClass=Function.parse(w);

            return fncClass.prototype[v];

        }

    }

    return null;

};

Function.prototype.inheritsFrom=function(x)

{

    if(this==x)return true;

    else

    {

        if(this.bases)for(var i=0;

        i<this.bases.length;

        i++)

        {

            if(this.bases[i].inheritsFrom(x))return true;

        }

    }

    return false;

};

Function.prototype.implementsInterface=function(y)

{

    var interfaces=this._interfaces;

    if(interfaces)

    {

        if(interfaces.contains(y))return true;

    }

    else

    {

        if(this.bases)for(var i=0;

        i<this.bases.length;

        i++)

        {

            if(this.bases[i].implementsInterface(y))return true;

        }

    }

    return false;

};

Function.prototype.applyClass=function(z)

{

function A(o)

{

    var str=o._typeName&&o._typeName.replace(/\./g,"_")||"";

    if(o.bases)for(var i=0;

    i<o.bases.length;

    i++)

    {

        str+=" "+A(o.bases[i]);

        if(z)o.Events=Web.Enum.extend(o.Events,o.bases[i].Events);

    }

    return str;

}

if(!this._className)this._className=A(this);

return this._className;

};

Function.prototype.removeClass=function(B)

{

if(this.constructor._className)

{

    if(!this.constructor._arrClasses)this.constructor._arrClasses=this.constructor._className.split(" ");

    for(var intApplied=0;intApplied<this.constructor._arrClasses.length;intApplied++)

    {

        B=B.removeSpaceDelimitedString(this.constructor._arrClasses[intApplied]);

    }

    return B;

}

else return B;

};

Function.parse=function(C)

{

if(!Function._htClasses)Function._htClasses=new Object();

var fncClass=Function._htClasses[C];

if(!fncClass)fncClass=Function._htClasses[C]=Object.getFromName(C);

return fncClass;

};

Function.prototype._copyProps=function(D)

{

for(var strName in D.prototype)

{

    var vValue=D.prototype[strName];

    if(!this.prototype[strName])this.prototype[strName]=vValue;

}

};

Function.prototype._setBases=function(E)

{

var astrPending=this.prototype._astrPendingInherits;

if(astrPending)for(var i=0;

i<astrPending.length;

i++)

{

    var fncType=Function.parse(astrPending[i]);

    if(!fncType._parentBase)fncType._parentBase=new Array();

    fncType._parentBase.push(E._typeName);

    E._childBase.push(fncType._typeName);

    if(fncType&&this!=fncType&&!this.inheritsFrom(fncType)&&!fncType.inheritsFrom(this)&&!fncType._sealed)

    {

        if(!fncType._typeName)fncType._typeName=typeof astrPending[i]=="function"?astrPending[i]._typeName:astrPending[i];

        if(!this.bases)this.bases=new Array();

        this.bases.push(fncType);

        fncType._setBases(E);

        this._copyProps(fncType);

    }

}

this.prototype._astrPendingInherits=null;

};

Function.prototype._callBaseConstructors=function(F,G)

{

if(this.bases)for(var i=0;

i<this.bases.length;

i++)

{

    if(G)this.bases[i].apply(F,G);

    else this.bases[i].apply(F);

}

};

Function.prototype.initializeBase=function(H,I)

{

if(!this._parentBase)

{

    this._parentBase=new Array();

    this._parentBase.push(this._typeName);

    this._childBase=new Array();

    this._childBase.push(this._typeName);

}

this._setBases(this);

if(this._interfaces)for(var i=0;

i<this._interfaces.length;

i++)

{

    this._interfaces[i].apply(H);

}

this._callBaseConstructors(H,I);

return H;

};

Function.abstractMethod=function()

{

throw "Abstract method should be implemented";

};

Function.emptyFunction=function()

{

};

Function.prototype.registerClass=function(J,K,L)

{

this._typeName=J;

if(K)

{

    this._baseType=K;

    if(!Web.Type.isArray(K))K=[K];

    if(!this.prototype._astrPendingInherits)this.prototype._astrPendingInherits=new Array();

    for(var i=0;i<K.length;i++)

    {

        this.prototype._astrPendingInherits.push(K[i]);

    }

    this._basePrototypePending=true;

}

if(L)

{

    this._interfaces=[];

    for(var i=2;i<arguments.length;i++)

    {

        var interfaceType=arguments[i];

        this._interfaces.add(interfaceType);

    }

}

return this;

};

Function.prototype.registerAbstractClass=function(M,N)

{

this.registerClass.apply(this,arguments);

this._abstract=true;

return this;

};

Function.prototype.registerSealedClass=function(O,P)

{

this.registerClass.apply(this,arguments);

this._sealed=true;

return this;

};

Function.prototype.registerInterface=function(Q)

{

this._typeName=Q;

this._interface=true;

this._abstract=true;

this._sealed=true;

return this;

};

Array.prototype.indexOf=function(R)

{

for(var i=0;i<this.length;i++)

{

    if(this[i]==R)return i;

}

return -1;

};

Array.prototype.exists=function(S)

{

return this.indexOf(S)!=-1;

};

Array.prototype.add=Array.prototype.queue=function(T)

{

this.push(T);

};

Array.prototype.addRange=function(U)

{

var length=U.length;

if(length!=0)for(var index=0;

index<length;

index++)

{

    this.push(U[index]);

}

};

Array.prototype.contains=function(V)

{

var index=this.indexOf(V);

return index>=0;

};

Array.prototype.dequeue=function()

{

return this.shift();

};

Array.prototype.insert=function(W,X)

{

this.splice(W,0,X);

};

Array.prototype.clone=function()

{

var clonedArray=[];

var length=this.length;

for(var index=0;index<length;index++)

{

    clonedArray[index]=this[index];

}

return clonedArray;

};

Array.prototype.removeAt=function(Y)

{

return this.splice(Y,1);

};

Array.prototype.remove=function(o)

{

var i=this.indexOf(o);

if(i>-1)this.splice(i,1);

return i>-1;

};

Array.prototype.clear=function()

{

if(this.length>0)this.splice(0,this.length);

};

Web.Event=function(Z)

{

this.afncCallbacks=new Array();

this.vPackage=undefined;

this.blnRunOnce=Z;

this.blnExecuteImmediately=false;

this.isActive=function()

{

    return this.afncCallbacks.length!=0;

};

Web.Event.registerBaseMethod(this,"isActive");

return this;

};

Web.Event.prototype.isActive=function()

{

return this.afncCallbacks.length!=0;

};

Web.Event.prototype.dispose=function()

{

this.clear();

};

Web.Event.prototype.initialize=function()

{

};

Web.Event.create=function(ab)

{

return new Web.Event(ab);

};

Web.Event.prototype.reset=function()

{

this.blnExecuteImmediately=false;

};

Web.Event.prototype.add=Web.Event.prototype.attach=function(bb)

{

var objEvent=this;

function cb()

{

    if(bb)bb(objEvent.vPackage);

}

if(this.blnExecuteImmediately)

{

    window.setTimeout(cb,1);

    return true;

}

else

{

    if(bb&&!this.afncCallbacks.exists(bb))

    {

        this.afncCallbacks.queue(bb);

        return true;

    }

}

return false;

};

Web.Event.prototype.remove=Web.Event.prototype.detach=function(eb)

{

return this.afncCallbacks.remove(eb);

};

Web.Event.prototype.invoke=function(gb,hb)

{

if(this.isActive())

{

    var handlers=this.afncCallbacks;

    for(i=0;i<handlers.length;i++)

    {

        handlers[i](gb,hb);

    }

}

};

Web.Event.prototype.fire=function(jb,kb)

{

var objEvent=this;

function lb()

{

    if(objEvent.blnRunOnce)

    {

        objEvent.clear();

        objEvent.vPackage=jb;

        objEvent.blnExecuteImmediately=true;

    }

    if(kb)kb();

}

function mb(nb)

{

    if(nb)try

    {

        nb(jb);

    }

    catch(ex)

    {

        if(ex.number!="-2146823277")throw ex;

    }

}

Web.Utility.applyFunctionOverArray(mb,objEvent.afncCallbacks,kb?lb:null);

if(!kb)lb();

};

Web.Event.prototype.clear=function()

{

this.afncCallbacks.clear();

this.afncCallbacks=new Array();

};

Web.Event.registerClass("Web.Event");

Web.EventArgs=function()

{

};

Web.EventArgs.registerClass("Web.EventArgs");

Web.EventArgs.Empty=new Web.EventArgs();

Web.CancelEventArgs=function()

{

Web.CancelEventArgs.initializeBase(this);

var _canceled=false;

this.getCanceled=function()

{

    return _canceled;

};

this.setCanceled=function(ob)

{

    _canceled=ob;

};

};

Web.CancelEventArgs.registerClass("Web.CancelEventArgs",Web.EventArgs);

Web.Conversion=function()

{

};

Web.Conversion.coerceInt=function(pb)

{

pb=parseInt(pb);

return isNaN(pb)?0:pb;

};

Web.Conversion.coerceFloat=function(qb)

{

qb=parseFloat(qb);

return isNaN(qb)?0:qb;

};

registerNamespace("Web.Enum");

Web.Enum=function(rb)

{

this.parse=function(s)

{

    for(var f in this)

    {

        if(f==s)return this[f];

    }

    throw "Invalid Enumeration Value";

};

this.toString=function(sb)

{

    for(var i in this)

    {

        if(this[i]==sb)return i;

    }

    throw "Invalid Enumeration Value";

};

this.getValues=function()

{

    if(!this._values)

    {

        var values=

        {

        };

        for(var f in this)

        {

            if(typeof this[f]!="function")values[f]=this[f];

        }

        this._values=values;

    }

    return this._values;

};

for(var i=0;i<rb.length;i++)

{

    this[rb[i]]=Web.Enum._value(this,rb[i],rb[i],"Enum");

}

};

Web.Enum.getValue=function(tb,ub)

{

if(tb&&ub)for(var strName in tb)

{

    if(strName.toLowerCase()==ub.toLowerCase())return tb[strName];

}

return null;

};

Web.Enum.create=function()

{

return new Web.Enum(arguments);

};

Web.Enum.createEnumeration=Web.Enum.create;

Web.Enum.extend=function(vb,wb)

{

if(!vb)vb=Web.Enum.create();

if(wb)for(var i in wb.getValues())

{

    vb[i]=Web.Enum._value(this,i,i,"Enum");

}

return vb;

};

Web.Enum._value=function(xb,yb,zb,Ab)

{

var obj=new Object(yb);

obj.e=xb;

obj.strType=Ab;

obj.strName=zb;

obj.is=function(Bb)

{

    Web.Debug.ASSERT(this.e[Bb],Bb+" is invalid for this enum")();

    return this.e[Bb]==this;

};

return obj;

};

registerNamespace("Web.Flags");

Web.Flags=function(Cb)

{

this.parse=function(s)

{

    var parts=s.split("|");

    var value=0;

    for(var i=parts.length-1;i>=0;i--)

    {

        var part=parts[i].trim();

        var found=false;

        for(var f in this)

        {

            if(f==part)

            {

                value|=this[f];

                found=true;

                break;

            }

        }

        if(found==false)throw "Invalid Enumeration Value";

    }

    return value;

};

this.toString=function(Db)

{

    var sb=new Web.StringBuilder();

    for(var i in this)

    {

        if((this[i]&Db)!=0)

        {

            if(sb.isEmpty()==false)sb.append(" | ");

            sb.append(i);

        }

    }

    return sb.toString();

};

for(var i=0;i<arguments.length;i+=2)

{

    var name=arguments[i].toString();

    var value=arguments[i+1];

    this[name]=Web.Flags._value(this,Web.Conversion.coerceInt(value,"EnumFlag"));

}

return this;

};

Web.Flags.create=function()

{

return Web.Flags.apply(null,arguments);

};

Web.Flags.prototype.or=function(Eb)

{

return Web.Enum._value(this,this._orValue(arguments));

};

Web.Flags.prototype._orValue=function(Fb)

{

var iFlags=0;

var i=0;

for(i=0;i<Fb.length;i++)

{

    Web.Debug.ASSERT(this[Fb[i]],Fb[i]+" is invalid for this enum")();

    iFlags|=this[Fb[i]];

}

return iFlags;

};

Web.Flags._value=function(Gb,Hb,Ib,Jb)

{

var obj=Web.Enum._value(Gb,Hb,Ib,Jb);

obj.containsAll=function()

{

    var iOrArgs=this.e._orValue(arguments);

    return (this&iOrArgs)==iOrArgs;

};

obj.containsAny=function()

{

    return (this&this.e._orValue(arguments))!=0;

};

return obj;

};

registerNamespace("Web.Browser");

if(!Web.Browser.isMozilla)Web.Browser.isMozilla=function()

{

return false;

};

Web.Browser._isOpera=navigator.userAgent.indexOf("Opera")>=0;

Web.Browser._isIE=!Web.Browser.isMozilla()&&!Web.Browser._isOpera;

Web.Browser.isOpera=function()

{

return Web.Browser._isOpera;

};

Web.Browser.isIE=function()

{

return Web.Browser._isIE;

};

if(!Web.Browser.isMozilla())Web.Browser.Button=

{

"LEFT":1,"RIGHT":2,"MIDDLE":4

};

if(!window.XMLHttpRequest)window.XMLHttpRequest=function()

{

var xmlHttp;

try

{

    xmlHttp=new ActiveXObject("Msxml2.XMLHTTP.4.0");

    return xmlHttp;

}

catch(ex)

{

}

try

{

    xmlHttp=new ActiveXObject("MSXML2.XMLHTTP");

    return xmlHttp;

}

catch(ex)

{

}

try

{

    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");

    return xmlHttp;

}

catch(ex)

{

}

return null;

};

if(Web.Debug.Enabled)Web.Debug.InitEvents();

Web.Runtime=new function()

{

    var objRuntime=this;

    this.readyStateType=Web.Enum.create("Uninitialized","Init","InitComplete");

    this._readyState=this.readyStateType.Uninitialized;

    this.oninit=Web.Event.create(true);

    this.onunload=Web.Event.create(true);

    this.getReadyState=function()

    {

        return this._readyState;

    };

function UnwirePage()

{

    window.detachEvent("onunload",UnwirePage);

    objRuntime.onunload.fire();

}

function VerifyHookupsCalled()

{

    if(objRuntime._readyState.is("Uninitialized"))alert("You failed to call Web.Runtime.init() at the bottom of your page");

    window.detachEvent("onload",VerifyHookupsCalled);

}

window.attachEvent("onload",VerifyHookupsCalled);

window.attachEvent("onunload",UnwirePage);

function BuildEventInvoker(p_objEvent,p_strPreState,p_strRunState,p_strPostState)

{

function Invoke()

{

    if(objRuntime._readyState!=objRuntime.readyStateType[p_strPreState])throw "Invalid state for event to fire";

    else

    {

        objRuntime._readyState=objRuntime.readyStateType[p_strRunState];

        p_objEvent.fire();

        objRuntime._readyState=objRuntime.readyStateType[p_strPostState];

    }

}

return Invoke;

}

this.init=BuildEventInvoker(objRuntime.oninit,"Uninitialized","Init","InitComplete");

}

();

registerNamespace("Web.Utility");

Web.Utility.Prioritizer=function()

{

var pList=new Object();

this.queue=function(Kb,Lb)

{

if(!Lb)Lb=Web.Utility.Prioritizer.Priorities.Medium;

if(pList[Lb.strName])pList[Lb.strName].queue(Kb);

else throw "Error: Invalid Priority Specified";

};

this.dequeue=function()

{

for(var p in pList)

{

    if(pList[p].length>0)return pList[p].dequeue();

}

return null;

};

this.removeItem=function(Mb)

{

var bRemoved=false;

for(var p in pList)

{

    bRemoved=pList[p].remove(Mb)||bRemoved;

}

return bRemoved;

};

this.findByProperty=function(Nb,Ob)

{

for(var p in pList)

{

    for(var item in pList[p])

    {

        if(pList[p][item][Nb]==Ob)return pList[p][item];

    }

}

return null;

};

this.getList=function()

{

return pList;

};

this.clear=function()

{

for(var p in Web.Utility.Prioritizer.Priorities.getValues())

{

    pList[p]=new Array();

}

};

this.clear();

return this;

};

Web.Utility.Prioritizer.Priorities=Web.Enum.create("High","Medium","Low","Lowest");

Web.Utility.applyFunctionOverArray=function(Pb,Qb,Rb)

{

var i=0;

function Sb()

{

    if(i<Qb.length)

    {

        Pb(Qb[i++]);

        window.setTimeout(Sb,1);

    }

    else

    {

        if(Rb)Rb();

    }

}

if(Rb)Sb();

else

{

    while(i<Qb.length)

    {

        Pb(Qb[i++]);

    }

    if(Rb)Rb();

}

};

Web.Utility.extractHost=function(Tb,Ub)

{

if(Ub)

{

    Web.Utility.extractHost.reProtocolAndHost.lastIndex=0;

    var rMatch=Web.Utility.extractHost.reProtocolAndHost.exec(Tb);

    return rMatch?rMatch[1]:"";

}

else

{

    Web.Utility.extractHost.reHost.lastIndex=0;

    var rMatch=Web.Utility.extractHost.reHost.exec(Tb);

    return rMatch?rMatch[2]:"";

}

};

Web.Utility.extractHost.reProtocolAndHost=new RegExp("((http|https|ftp)://[^\\/]*).*","ig");

Web.Utility.extractHost.reHost=new RegExp("(http|https|ftp)://([^\\/]*).*","ig");

Web.Utility.resolveUrl=function(Vb)

{

if(Vb==null)return "";

if(!Web.Utility.resolveUrl.Base)

{

    var elBases=document.getElementsByTagName("base");

    if(elBases.length>0&&elBases[0].href!="")Web.Utility.resolveUrl.Base=elBases[0].href;

    else Web.Utility.resolveUrl.Base=location.href.substring(0,location.href.lastIndexOf("/")+1);

}

if(Vb.startsWith("/"))Vb=location.protocol+"//"+location.host+Vb;

if(Vb.indexOf("//")==-1)Vb=Web.Utility.resolveUrl.Base+Vb;

function Wb(Xb)

{

    while(Wb.reDoubleDot.test(Xb))

    {

        Xb=Xb.replace(Wb.reDoubleDot,"");

    }

    return Xb;

}

Wb.reDoubleDot=/\/[^\/]*\/\.\./;

return Wb(Vb);

};

function FindUrl(Yb,Zb,ac)

{

    if(ac)

    {

        var iCount=Yb.length;

        var strSource=Web.Utility.resolveUrl(ac).toLowerCase();

        var i=0;

        for(i=0;i<iCount;i++)

        {

            var strCompare=Yb[i]["__"+Zb];

            if(!strCompare)strCompare=Yb[i]["__"+Zb]=Web.Utility.resolveUrl(Yb[i].getAttribute(Zb)).toLowerCase();

            if(strCompare==strSource)return Yb[i];

        }

    }

    return null;

}

Web.Utility.CSS=new function()

{

    var objCSS=this;

    objCSS.findElement=function(p_strSrc)

    {

        return FindUrl(document.getElementsByTagName("link"),"href",p_strSrc);

    };

}

();

Web.Utility.loadSources=function(bc,cc,ec,gc)

{

function hc(jc)

{

    var aelScriptToAttach=new Array();

    for(var i=0;i<jc.length;i++)

    {

        if(jc[i].resource)aelScriptToAttach.push(jc[i].resource);

    }

    Web.Utility.Script.attachBulkScript(aelScriptToAttach,document.head,gc);

}

if(bc.length==0&&cc.length==0)gc();

else

{

    var objRequest=Web.Network.createBatch(ec);

    var blnFetch=false;

    for(var i=0;i<bc.length;i++)

    {

        var el=null;

        if(Web.Browser.isIE())el=Web.Utility.Script.findElement(bc[i]);

        if(bc[i]!=""&&!el)

        {

            blnFetch=true;

            objRequest.add(Web.Network.Type.Script,bc[i],null,null);

        }

    }

    for(var i=0;i<cc.length;i++)

    {

        var el=Web.Utility.CSS.findElement(cc[i]);

        if(!el)

        {

            blnFetch=true;

            objRequest.add(Web.Network.Type.CSS,cc[i],null,null);

        }

    }

    if(blnFetch)objRequest.execute(hc);

    else

    {

        objRequest=null;

        gc();

    }

}

};

Web.Utility.Script=new function()

{

    var objScript=this;

    objScript.findElement=function(p_strSrc)

    {

        return FindUrl(document.scripts,"src",p_strSrc);

    };

    objScript.attachBulkScript=function(p_arrScripts,p_elAttachElement,p_fnCallback)

    {

        var cnt=0;

        var locked=true;

function DoComplete()

{

    cnt--;

    if(!locked&&cnt==0)p_fnCallback();

}

for(var i=0;i<p_arrScripts.length;i++)

{

    if(p_arrScripts[i].tagName=="SCRIPT")

    {

        cnt++;

        objScript.attachScript(p_arrScripts[i],p_elAttachElement,DoComplete);

    }

}

locked=false;

if(cnt==0&&p_fnCallback)p_fnCallback();

};

objScript.attachScript=function(p_elAttachScript,p_elAttachElement,p_fnCallback)

{

var el=Web.Utility.Script.findElement(p_elAttachScript.src);

if(!el)

{

    if(Web.Browser.isMozilla())p_elAttachScript.onload=EvalTest;

    p_elAttachElement.appendChild(p_elAttachScript);

    if(!Web.Browser.isMozilla()&&p_fnCallback)p_fnCallback();

}

else

{

    if(p_fnCallback)

    {

        if(Web.Browser.isMozilla()&&el.onload!=null)

        {

            if(el.callbacks==null)el.callbacks=Web.Event.create(true);

            el.callbacks.attach(p_fnCallback);

        }

        else p_fnCallback();

    }

}

function EvalTest()

{

    if(p_elAttachScript.onload)

    {

        p_elAttachScript.onload=null;

        p_elAttachScript.readyState="complete";

        if(p_fnCallback)p_fnCallback();

        if(p_elAttachScript.callbacks)

        {

            p_elAttachScript.callbacks.fire();

            p_elAttachScript.callbacks=null;

        }

    }

    else p_fnCallback();

}

return p_elAttachScript.readyState=="complete";

};

}

();

registerNamespace("Web.Network");

Web.Network=new function()

{

    var objNetwork=this;

    var objDomains=new Object();

    var strCurrentDomain=Web.Utility.extractHost(document.location,false);

    this.oninvoke=Web.Event.create();

    this.onfinished=Web.Event.create();

    this.onabort=Web.Event.create();

    this.onhttperror=Web.Event.create();

    this.onerror=Web.Event.create();

    this.ontimeout=Web.Event.create();

    this.onrequest=Web.Event.create();

    this.defaultTimeout=null;

function RunList(p_strDomain)

{

    var intActive=0;

    var objList=new Object();

    var objParallel=new Web.Utility.Prioritizer();

    var objSerializer=new Web.Utility.Prioritizer();

    var boolSerRequest=false;

    var blnCrossDomain=strCurrentDomain!=p_strDomain;

function FetchImage(o)

{

    var img=new Image();

    img.onload=doCallback;

    img.onerror=doError;

    img.blnError=false;

    img.src=o.url;

function doError()

{

    img.blnError=true;

    doCallback();

}

function doCallback()

{

    img.onerror=img.onload=null;

    Finished(img,o);

}

return img;

}

function FetchCSS(o)

{

    var el=Web.Utility.CSS.findElement(o.url);

    if(!el)

    {

        el=document.createElement("link");

        el.rel="stylesheet";

        el.type="text/css";

        el.onreadystatechange=doCallback;

        el.href=o.url;

        document.head.appendChild(el);

        if(Web.Browser.isMozilla())

        {

            el.readyState="complete";

            doCallback();

        }

    }

    else doCallback();

function doCallback()

{

    if(el&&("loaded"==el.readyState||"complete"==el.readyState))

    {

        el.onreadystatechange=null;

        Finished(el,o);

    }

}

return el;

}

function FetchScript(o)

{

    var el=Web.Utility.Script.findElement(o.url);

    if(!el)

    {

        el=document.createElement("script");

        el.onreadystatechange=doCallback;

        el.src=o.url;

        if(!Web.Browser.isIE())

        {

            el.readyState="loaded";

            doCallback();

        }

    }

    else

    {

        if(Web.Browser.isMozilla())el.readyState="loaded";

        doCallback();

    }

function doCallback()

{

    if(el&&("loaded"==el.readyState||"complete"==el.readyState))

    {

        el.onreadystatechange=null;

        Finished(el,o);

    }

}

return el;

}

function FetchXML(o,method)

{

    var xml=new XMLHttpRequest();

    if(o.timeout)o.timer=setTimeout(TimedOut,o.timeout);

    xml.onreadystatechange=doCallback;

    objNetwork.oninvoke.fire(o);

    if(method)

    {

        xml.open("POST",o.url,true);

        if(Web.Browser.isIE())xml.setRequestHeader("Accept-Encoding","gzip, deflate");

    }

    else xml.open("GET",o.url,true);

    if(o.headers)for(var h in o.headers)

    {

        xml.setRequestHeader(h,o.headers[h]);

    }

    xml.send(o.postString);

function doCallback()

{

    if(4==xml.readyState)

    {

        xml.onreadystatechange=Function.emptyFunction;

        if(o.timer)clearTimeout(o.timer);

        Finished(xml,o);

        xml=o=null;

    }

}

function TimedOut()

{

    xml.onreadystatechange=Function.emptyFunction;

    xml.abort();

    Finished(null,o);

    xml=o=null;

}

return xml;

}

function Continue()

{

    var o=null;

    if(intActive<Web.Network.MAXACTIVE)

    {

        if(!boolSerRequest)

        {

            o=objSerializer.dequeue();

            if(o)boolSerRequest=true;

        }

        if(!o)o=objParallel.dequeue();

        if(o)

        {

            intActive++;

            switch(o.type)

            {

                case Web.Network.Type.XMLGet:case Web.Network.Type.XML:o.executing=FetchXML(o,false);

                break;

                case Web.Network.Type.XMLPost:o.executing=FetchXML(o,true);

                break;

                case Web.Network.Type.Image:o.executing=FetchImage(o);

                break;

                case Web.Network.Type.Script:o.executing=FetchScript(o);

                break;

                case Web.Network.Type.CSS:o.executing=FetchCSS(o);

                break;

                default:intActive--;

            }

        }

    }

}

function Finished(el,obj)

{

    if(obj.flags&Web.Network.Flags.SERIALIZE)boolSerRequest=false;

    intActive--;

    if(objList[obj.key])

    {

        for(var i=objList[obj.key].length-1;i>=0;i--)

        {

            var objItem=objList[obj.key][i];

            if(objItem.callback)objItem.callback(el,objItem.context);

        }

        var objItem=objList[obj.key].pop();

        while(objItem)

        {

            objItem=objItem.callback=objItem.context=objItem.executing=null;

            objItem=objList[obj.key].pop();

        }

        delete objList[obj.key];

    }

    obj=obj.executing=el=null;

    setTimeout(Continue,1);

}

function IndexInList(objCheck)

{

    var boolMatch=false;

    var intIndex=0;

    var objCheckList=objList[objCheck.key];

    if(objCheckList)while(!boolMatch&&objCheckList&&intIndex<objCheckList.length)

    {

        var objItem=objCheckList[intIndex];

        boolMatch=objItem&&objItem.callback==objCheck.callback;

        if(!boolMatch)intIndex++;

    }

    return boolMatch?intIndex:-1;

}

function Remove(obj)

{

    var objItem=null;

    if(objList[obj.key])

    {

        var intIndex=IndexInList(obj);

        if(intIndex>-1)objItem=objList[obj.key].splice(intIndex,1)[0];

    }

    return objItem;

}

function AbortRequest(objMatch)

{

    objMatch.callback=null;

    if(objMatch.executing)

    {

        if(objMatch.flags&Web.Network.Flags.SERIALIZE)boolSerRequest=false;

        objNetwork.onabort.fire(objMatch);

        switch(objMatch.type)

        {

            case Web.Network.Type.XML:case Web.Network.Type.XMLPost:case Web.Network.Type.XMLGet:objMatch.executing.onreadystatechange=Function.emptyFunction;

            objMatch.executing.abort();

            break;

            case Web.Network.Type.Image:case Web.Network.Type.Script:case Web.Network.Type.CSS:objMatch.onload=objMatch.onerror=objMatch.onreadystatechange=null;

            objMatch.executing.src="";

            break;

        }

        intActive--;

    }

    objMatch.context=objMatch.executing=null;

}

this.abort=function(obj)

{

    var objMatch=Remove(obj);

    while(objMatch!=null)

    {

        AbortRequest(objMatch);

        objMatch=Remove(obj);

    }

    Continue();

};

function AbortObjectKey(p_objList,p_strKey)

{

    var o=p_objList[p_strKey];

    if(o)

    {

        var objItem=o.pop();

        while(objItem)

        {

            AbortRequest(objItem);

            objItem=o.pop();

        }

    }

    delete o;

}

this.abortGroup=function(p_strGroup)

{

    var objFound=objParallel.findByProperty("strGroup",p_strGroup);

    while(objFound)

    {

        objParallel.removeItem(objFound);

        objFound=objParallel.findByProperty("strGroup",p_strGroup);

    }

    objFound=objSerializer.findByProperty("strGroup",p_strGroup);

    while(objFound)

    {

        objSerializer.removeItem(objFound);

        objFound=objSerializer.findByProperty("strGroup",p_strGroup);

    }

    for(var key in objList)

    {

        var blnAbort=false;

        var intItem=0;

        while(intItem<objList[key].length&&!blnAbort)

        {

            if(objList[key][intItem].strGroup==p_strGroup)

            {

                blnAbort=true;

                break;

            }

            intItem++;

        }

        if(blnAbort)AbortObjectKey(objList,key);

    }

};

this.abortAll=function(p_boolRestart)

{

    if(p_boolRestart)

    {

        objParallel.clear();

        objSerializer.clear();

    }

    for(var strKey in objList)

    {

        AbortObjectKey(objList,strKey);

    }

    objList=new Object();

};

this.add=function(obj)

{

    var boolQueue=false;

    if(objList[obj.key])

    {

        var intIndex=IndexInList(obj);

        boolQueue=intIndex==-1;

    }

    else

    {

        objList[obj.key]=new Array();

        boolQueue=true;

        if(obj.flags&Web.Network.Flags.SERIALIZE)objSerializer.queue(obj,obj.priority);

        else objParallel.queue(obj,obj.priority);

    }

    if(boolQueue)

    {

        objList[obj.key].push(obj);

        Continue();

    }

};

}

function Request(p_enumNetworkType,p_strUrl,p_objContext,p_fnCallback,p_enumPriority,p_postString,p_objHeaders,p_enumFlags,p_intTimeout,p_strTag)

{

    this.type=p_enumNetworkType;

    this.url=Web.Utility.resolveUrl(p_strUrl);

    this.context=p_objContext;

    this.callback=p_fnCallback;

    this.priority=p_enumPriority;

    this.postString=p_postString;

    this.strGroup=p_strTag;

    var strList="";

    for(var h in p_objHeaders)

    {

        strList+=h+":"+p_objHeaders[h];

    }

    this.strHeaders=strList;

    this.key=this.url+"?"+(this.postString||"")+"!"+strList;

    if(p_enumFlags&Web.Network.Flags.DUPLICATE)this.key+="!"+Request.DupCounter++;

    this.headers=p_objHeaders;

    this.flags=p_enumFlags;

    this.executing=null;

    this.timeout=p_intTimeout;

    objNetwork.onrequest.fire(this);

    this.domain=Web.Utility.extractHost(this.url,false);

    if(this.domain=="")this.domain="local";

    if(!objDomains[this.domain])objDomains[this.domain]=new RunList(this.domain);

}

Request.DupCounter=0;

this.abortAll=function(p_blnUnload)

{

    for(var rl in objDomains)

    {

        objDomains[rl].abortAll();

    }

};

this.abortGroup=function(p_strTag)

{

    for(var strDomain in objDomains)

    {

        objDomains[strDomain].abortGroup(p_strTag);

    }

};

this.createRequest=function(p_enumNetworkType,p_strUrl,p_objContext,p_fnCallback,p_enumPriority,p_strPostArgs,p_objHeaders,p_enumFlags,p_intTimeout,p_strTag)

{

    var objRequest=new Object();

    var objPrivRequest=new Request(p_enumNetworkType,p_strUrl,p_objContext,p_fnCallback,p_enumPriority,p_strPostArgs,p_objHeaders,p_enumFlags,p_intTimeout,p_strTag);

    var boolExecuting=false;

    objRequest.execute=function()

    {

        if(!boolExecuting)objDomains[objPrivRequest.domain].add(objPrivRequest);

        boolExecuting=true;

    };

    objRequest.isExecuting=function()

    {

        return boolExecuting;

    };

    objRequest.abort=function()

    {

        objDomains[objPrivRequest.domain].abort(objPrivRequest);

    };

    return objRequest;

};

this.createBatch=function(p_enumPriority,p_objContext)

{

    var objBatch=this;

    var arrBatch=new Array();

    var boolExecuting=false;

    var intReceiveCount=0;

    var boolLockSection=false;

    var arrCallback=new Array();

function CheckComplete()

{

    if(!boolLockSection&&arrBatch.length==intReceiveCount)

    {

        for(var i=0;i<arrCallback.length;i++)

        {

            if(arrCallback[i])arrCallback[i](arrBatch,p_objContext);

        }

        intReceiveCount=0;

        boolExecuting=false;

    }

}

objBatch.add=function(p_enumNetworkType,p_strUrl,p_objContext,p_strPostArgs,p_objHeaders,p_enumFlags)

{

    arrBatch.push(objNetwork.createRequest(p_enumNetworkType,p_strUrl,arrBatch.length,BatchItemReceived,p_enumPriority,p_strPostArgs,p_objHeaders,p_enumFlags));

};

function BatchItemReceived(p_elResource,p_intIndex)

{

    arrBatch[p_intIndex].resource=p_elResource;

    intReceiveCount++;

    CheckComplete();

}

objBatch.execute=function(p_fnCallback)

{

    if(!arrCallback.exists(p_fnCallback))arrCallback.push(p_fnCallback);

    if(!boolExecuting)

    {

        boolExecuting=boolLockSection=true;

        for(var intIndex=0;intIndex<arrBatch.length;intIndex++)

        {

            arrBatch[intIndex].execute();

        }

        boolLockSection=false;

        CheckComplete();

    }

};

objBatch.abort=function(p_fnCallback)

{

    arrCallback.remove(p_fnCallback);

    if(arrCallback.length==0)

    {

        for(var i=0;i<arrBatch.length;i++)

        {

            arrBatch[i].abort();

        }

        boolExecuting=false;

    }

};

return objBatch;

};

function dispose()

{

    objNetwork.abortAll(true);

    objNetwork.oninvoke.clear();

    objNetwork.onfinished.clear();

    objNetwork.onabort.clear();

    objNetwork.onhttperror.clear();

    objNetwork.onerror.clear();

    objNetwork.ontimeout.clear();

    objNetwork.onrequest.clear();

}

Web.Runtime.onunload.attach(dispose);

}

();

Web.Network.Flags=Web.Flags.create("SERIALIZE",1,"DUPLICATE",2);

Web.Network.Type=Web.Enum.create("XML","Image","Script","XMLPost","XMLGet","CSS");

Web.Network.MAXACTIVE=2;

