// Copyright (c) Microsoft Corporation. All rights reserved.

var BindingsVersion="0.090405.0";

Function.eventHelper=function(b,c)

{

function e()

{

    if(Web.Type.isBoolean(c))event.cancelBubble=c;

    if(b!=null)

    {

        event.returnValue=b;

        if(Web.Type.isBoolean(b))return b;

    }

}

return e;

};

Function.KillEvent=Function.eventHelper(false,true);

Function.CancelBubble=Function.eventHelper(null,true);

Function.CancelDefault=Function.eventHelper(false);

Web.Type.Descriptor=function()

{

};

Web.Type.Descriptor.create=function(g)

{

if(g==null||g==undefined)throw "The p_vType parameter is null or undefined";

var obj=new Web.Type.Descriptor();

var strTypeOf=typeof g;

if(strTypeOf=="string")

{

    obj.strType=g;

    obj.fncType=Object.getFromName(obj.strType);

}

else

{

    if(strTypeOf=="object")obj.fncType=g.constructor;

    else obj.fncType=g;

}

return obj;

};

Web.Dom=new function()

{

    var objDom=this;

    objDom.getAnyElementByTagName=function(tagName,root,bForceNoCompat)

    {

        if(!root)root=document;

        var elList=new Array();

        var idx=tagName.indexOf(":");

        if(idx>=0)

        {

            if(!Web.Browser.isMozilla())

            {

                var ns=tagName.substring(0,idx);

                var tagName=tagName.substring(idx+1);

                if(ns!=""&&document.namespaces&&!document.namespaces[ns])alert("IE Requirement - Add xmlns:"+ns+" to the HTML tag.");

                var propName="scopeName";

                var elTemp=root.getElementsByTagName(tagName);

                if(Web.Browser.isOpera())propName="prefix";

                var iCount=elTemp.length;

                for(var i=0;i<iCount;i++)

                {

                    var objItem=elTemp[i];

                    if(objItem[propName]&&objItem[propName].toLowerCase()==ns.toLowerCase())elList.push(objItem);

                }

            }

            else

            {

                if(Web.Browser.MozillaCompatMode&&!bForceNoCompat)

                {

                    elList=new Array();

                    var elTemp=root.getElementsByTagName("div");

                    for(var i=0;i<elTemp.length;i++)

                    {

                        if(elTemp[i].className.indexOf(tagName)>-1)elList.push(elTemp[i]);

                    }

                }

                else elList=root.getElementsByTagName(tagName);

            }

        }

        else elList=root.getElementsByTagName(tagName);

        return elList;

    };

    objDom.resolveTagName=function(p_el)

    {

        var strTagName=p_el.tagName;

        if(strTagName)

        {

            if(Web.Browser.isIE())

            {

                if(p_el.scopeName!="")strTagName=p_el.scopeName+":"+strTagName;

            }

        }

        return strTagName;

    };

    objDom.getElementsByCssSelector=function(p_strSelector,p_elRoot)

    {

        return objDom.Css.getElementsByCssSelectorRules(objDom.Css.createRules(p_strSelector),p_elRoot);

    };

objDom.Css=new function()

{

    var objCss=this;

    objCss.Rule=function(p_strSingleSelector)

    {

        objCss.Rule.reCssSelector.lastIndex=0;

        objCss.Rule.reCssSelector.exec(p_strSingleSelector);

        this.strTagName=RegExp.$1.toLowerCase();

        this.strClassName=RegExp.$2.toLowerCase();

        this.strID=RegExp.$3;

    };

    objCss.Rule.reCssSelector=new RegExp("([^\\.#]*)\\.?([^#]*)#?(.*)");

    objCss.createRules=function(p_strSelector)

    {

        if(!p_strSelector)return new Array();

        var aSelectorTerms=p_strSelector.trim().split(objCss.createRules.reWhiteSpace);

        for(var i=0;i<aSelectorTerms.length;i++)

        {

            aSelectorTerms[i]=new objCss.Rule(aSelectorTerms[i]);

        }

        return aSelectorTerms;

    };

    objCss.createRules.reWhiteSpace=new RegExp("\\s+");

function GetPotentialElementsByRule(p_objRule,p_elRoot)

{

    var elPotentials=new Array();

    if(p_objRule)

    {

        if(p_objRule.strID)

        {

            var elByID=document.getElementById(p_objRule.strID);

            if(p_elRoot==document||p_elRoot.tagName&&p_elRoot.contains(elByID))elPotentials=new Array(document.getElementById(p_objRule.strID));

        }

        else

        {

            if(p_objRule.strTagName)elPotentials=Web.Dom.getAnyElementByTagName(p_objRule.strTagName,p_elRoot);

            else

            {

                if(p_objRule.strClassName)elPotentials=p_elRoot.getElementsByTagName("*");

            }

        }

    }

    return elPotentials;

}

objCss.doesElementPassRule=function(p_el,p_objRule)

{

    var blnValid=false;

    if(p_objRule)

    {

        blnValid=!p_objRule.strTagName||p_objRule.strTagName==p_el.tagName.toLowerCase();

        var strClassName=" "+p_el.className.toLowerCase()+" ";

        blnValid=blnValid&&(!p_objRule.strClassName||strClassName.indexOf(" "+p_objRule.strClassName+" ")!=-1);

        blnValid=blnValid&&(!p_objRule.strID||p_objRule.strID==p_el.id);

    }

    return blnValid;

};

objCss.doesElementPassRules=function(p_el,p_aobjRules,p_elRoot)

{

    if(!p_aobjRules||p_aobjRules.length==0)return false;

    var iRuleIndex=p_aobjRules.length-1;

    if(!objCss.doesElementPassRule(p_el,p_aobjRules[iRuleIndex--]))return false;

    if(!p_elRoot)p_elRoot=document.documentElement;

    var blnMustContain=p_elRoot==document.documentElement;

    while(p_el&&(blnMustContain||p_elRoot.contains(p_el))&&iRuleIndex>=0)

    {

        p_el=p_el.parentElement;

        if(p_el&&objCss.doesElementPassRule(p_el,p_aobjRules[iRuleIndex]))iRuleIndex--;

    }

    return p_el&&(blnMustContain||p_elRoot.contains(p_el));

};

objCss.getElementsByCssSelectorRules=function(p_aRules,p_elRoot)

{

    var aElements=new Array();

    p_elRoot=p_elRoot||document;

function GetElements(p_elScope,p_iIndex)

{

    var elPotentials=GetPotentialElementsByRule(p_aRules[p_iIndex],p_elScope);

    var intCount=elPotentials.length;

    for(var i=0;i<intCount;i++)

    {

        var elItem=elPotentials[i];

        if(objCss.doesElementPassRule(elItem,p_aRules[p_iIndex]))

        {

            if(p_iIndex+1<p_aRules.length)GetElements(elItem,p_iIndex+1);

            else aElements.push(elItem);

        }

    }

}

if(p_aRules.length>0)GetElements(p_elRoot,0);

return aElements;

};

}

();

}

();

Web.Network.Fpp=function(h,j,k,l)

{

var oFppHeaders=new Object();

oFppHeaders["Content-Type"]="application/x-www-form-urlencoded";

if(typeof l!="undefined")oFppHeaders["FPPRPURL"]=l;

if(j==null)j=0;

function m(n,o)

{

    Web.Network.onfinished.fire(o);

    if(n==null)

    {

        if(o.cbTimeout)o.cbTimeout();

        else Web.Network.ontimeout.fire(o);

    }

    else

    {

        if(n.responseText==null||n.responseText==""||n.status!=200)Web.Network.onhttperror.fire(n);

        else

        {

            var oFppPkg=eval(n.responseText);

            try

            {

                var strUrl=n.getResponseHeader("FPPRPURL");

                if(strUrl!="")oFppHeaders["FPPRPURL"]=strUrl;

            }

            catch(ex)

            {

            }

            if(o.oProfile!=null)o.oProfile.EndProfile(oFppPkg.ProfilingInfo);

            if(oFppPkg.Status==0)

            {

                var arrArgs=oFppPkg.OutRefParams;

                arrArgs.unshift(o.context);

                arrArgs.unshift(oFppPkg.Value);

                o.callback.apply(null,arrArgs);

            }

            else

            {

                if(oFppPkg.Status==1)

                {

                    if(o.cbErr)o.cbErr(oFppPkg.Error,o.oContext);

                    else Web.Network.onerror.fire(oFppPkg.Error);

                }

            }

        }

    }

}

this.invoke=function(p,q,r,d,s,t,u,v,w,x)

{

    if(q==null||r==null||s==null)throw new Error("invalid arguments for Fpp.invoke");

    if(typeof s!="function")throw new Error("FPP arg list mismatch: cb must be of type function.");

    var p_enumFlags=null;

    var strData="cn="+q+"&"+"mn="+r+"&"+"d="+d;

    var strPost=null;

    var strUrl=null;

    var objContext=new Object();

    objContext.context=t;

    objContext.callback=s;

    objContext.cbErr=u;

    objContext.cbTimeout=v;

    if(p==Web.Network.Type.XMLPost)

    {

        strPost=strData;

        strUrl=h+"?cnmn="+q+"."+r+"&ptid="+j+"&a="+k;

    }

    else

    {

        if(p==Web.Network.Type.XMLGet)strUrl=h+"?"+strData+"&ptid="+j+"&a="+k;

    }

    if(typeof FireAnt!="undefined"&&typeof FireAnt.Debug!="undefined"&&FireAnt.Debug!=null)

    {

        objContext.oProfile=FireAnt.Debug.StartProfile(q+"."+r);

        FireAnt.Debug.Trace(q+"."+r);

    }

    if(w)Web.Network.abortGroup(w);

    var request=Web.Network.createRequest(p,strUrl,objContext,m,x,strPost,oFppHeaders,p_enumFlags,2000,w);

    request.execute();

    return request;

};

};

Web.Network.Fpp.arrayToString=function(y)

{

var retValue="";

if(y==null)return retValue;

if(Web.Type.isArray(y))

{

    var joinArray=new Array();

    for(var i=0;i<y.length;i++)

    {

        if(Web.Type.IsString(y[i]))joinArray.push(Web.Network.Fpp.escape(y[i]));

        else joinArray.push(y[i].toString());

    }

    retValue=joinArray.join(",");

    return retValue;

}

else throw new Error("p_array = "+y+" is not an array");

};

Web.Network.Fpp.escape=function(z)

{

if(z==null)return z;

else

{

    var someString=z.toString();

    someString=encodeURIComponent(someString.replace(/([\{|\}\[|\]\,\\])/g,"\\$1"));

    return someString;

}

};

Web.Network.FppProxy=function()

{

var m_obj=this;

var proxy=null;

this.initialize=function(A,B,C,D)

{

    proxy=new Web.Network.Fpp(A,B,C,D);

    return m_obj;

};

function E(F)

{

function G()

{

    var m_this=new Object();

    for(var i=0;i<F.length;i++)

    {

        m_this[F[i]]=arguments[i];

    }

    m_this.toString=function()

    {

        var sbProps=new Array();

        for(var i=0;i<F.length;i++)

        {

            sbProps.push(F[i].escape(m_this[F[i]]));

        }

        return "{"+sbProps.join(",")+"}";

    };

    return m_this;

}

return G;

}

function H(I,J,K,L,M)

{

function N()

{

    var sbArgs=new Array();

    var intMembers=J.length;

    for(var i=0;i<intMembers;i++)

    {

        sbArgs.push(J[i].escape(arguments[i]));

    }

    return proxy.invoke(K||Web.Network.Type.XMLPost,M,I,sbArgs.join(","),arguments[intMembers],arguments[intMembers+1],arguments[intMembers+2],arguments[intMembers+3],L);

}

return N;

}

this.registerFppClass=function(O,P)

{

this[O]=E(P);

};

this.registerFppMethod=function(Q,R,S,T,U,V)

{

this[Q]=H(S||Q,R,T||Web.Network.Type.XMLPost,U,V||strDefaultNamespace);

};

this.seal=function()

{

this.RegisterClass=this.RegisterMethod=this.Seal=null;

};

};

Web.Network.FppProxy.TypeSystem=function(W,X)

{

this.toString=function()

{

return X;

};

this.type=W;

return this;

};

Web.Network.FppProxy.TypeSystem.prototype.escape=function(Y)

{

if(Y==null||typeof Y=="undefined")return "null";

switch(this.type)

{

case "__string":return Web.Network.Fpp.escape(Y);

case "__array":var intermediate="[";

intermediate+=Web.Network.Fpp.arrayToString(Y);

intermediate+="]";

return intermediate;

case "__primitive":case "__object":case "__enum":return Y;

default:return Y;

}

};

Web.Network.FppProxy.__string=function(Z)

{

return new Web.Network.FppProxy.TypeSystem("__string",Z);

};

Web.Network.FppProxy.__array=function(ab)

{

return new Web.Network.FppProxy.TypeSystem("__array",ab);

};

Web.Network.FppProxy.__primitive=function(bb)

{

return new Web.Network.FppProxy.TypeSystem("__primitive",bb);

};

Web.Network.FppProxy.__object=function(cb)

{

return new Web.Network.FppProxy.TypeSystem("__object",cb);

};

Web.Network.FppProxy.__enum=function(eb)

{

return new Web.Network.FppProxy.TypeSystem("__enum",eb);

};

Web.Network.FppProxy.__custom=function(gb,hb)

{

return new Web.Network.FppProxy.TypeSystem(gb,hb);

};

registerNamespace("Web.Bindings");

Web.Bindings=new function()

{

    var objWebBinding=this;

    var m_unloading=false;

function Scope()

{

    var objOwner=null;

    var childBindings=new Object();

    childBindings["_untyped"]=new Array();

    var aobjRegistrations=new Object();

    var aobjDefinitions=new Array();

    this.initialize=function(p_objBinding)

    {

        objOwner=p_objBinding;

    };

    this.getBinding=function()

    {

        return objOwner||this;

    };

function CheckRegistration(p_objBinding,p_blnLoad)

{

    var childList=p_objBinding.constructor._childBase;

    if(childList)for(var iClass=0;

    iClass<childList.length;

    iClass++)

    {

        var objReg=aobjRegistrations[childList[iClass]];

        if(objReg)for(var i=objReg.length-1;

        i>=0;

        i--)

        {

            if(objReg[i].elRoot.contains(p_objBinding._element))objReg[i].fnCallback(p_objBinding,p_blnLoad);

        }

    }

}

this.add=function(p_objBinding)

{

    var objConstructor=p_objBinding.constructor;

    var strType=objConstructor._typeName;

    if(!strType)childBindings["_untyped"].push(p_objBinding);

    else

    {

        if(!childBindings[strType])childBindings[strType]=new Array();

        childBindings[strType].push(p_objBinding);

    }

    CheckRegistration(p_objBinding,true);

};

this.addDefinition=function(p_objDefinition)

{

    aobjDefinitions.push(p_objDefinition);

};

this.getDefinitions=function()

{

    return aobjDefinitions;

};

this.remove=function(p_objBinding)

{

    CheckRegistration(p_objBinding,false);

    var strType=p_objBinding.constructor._typeName;

    if(!strType)strType="_untyped";

    childBindings[strType].remove(p_objBinding);

    if(p_objBinding.scope)p_objBinding.scope.dispose();

};

function RunNewRegistration(p_objItem,p_objBaseList)

{

    if(p_objBaseList)for(var i=0;

    i<p_objBaseList.length;

    i++)

    {

        var objRef=childBindings[p_objBaseList[i]];

        if(objRef)for(var iRef=0;

        iRef<objRef.length;

        iRef++)

        {

            if(p_objItem.elRoot.contains(objRef[iRef]._element))p_objItem.fnCallback(objRef[iRef],true);

        }

    }

}

this.unregisterFor=function(objItem)

{

    aobjRegistrations[objItem.strBinding].remove(objItem);

};

this.registerFor=function(p_vBinding,p_fnCallback,p_elRoot)

{

    var strBinding=p_vBinding;

    if(typeof p_vBinding=="function")strBinding=p_vBinding._typeName;

    else p_vBinding=Object.getFromName(p_vBinding);

    if(strBinding=="*")strBinding="Web.Bindings.Base";

    var objItem=

    {

        "fnCallback":p_fnCallback,"elRoot":p_elRoot||document.documentElement,"strBinding":strBinding

    };

    if(!aobjRegistrations[strBinding])aobjRegistrations[strBinding]=new Array();

    aobjRegistrations[strBinding].push(objItem);

    if(p_vBinding)RunNewRegistration(objItem,p_vBinding._parentBase);

    return objItem;

};

this.dispose=function()

{

    for(var strType in childBindings)

    {

        for(var i=childBindings[strType].length-1;i>=0;i--)

        {

            if(childBindings[strType][i])childBindings[strType][i].dispose(m_unloading);

        }

    }

    for(var iReg in aobjRegistrations)

    {

        aobjRegistrations[iReg].clear();

    }

    for(var i=aobjDefinitions.length-1;i>=0;i--)

    {

        aobjDefinitions[i].dispose();

    }

    childBindings=aobjRegistrations=aobjDefinitions=objOwner=null;

};

}

var m_rootScope=new Scope();

this.Base=function(p_element,p_htParams,p_strNamespace)

{

var blnMerge=false;

var m_this=this;

var aobjRegistrations;

this.parentBinding=null;

this.scope=null;

this._element=p_element;

p_element.className+=" "+m_this.constructor.applyClass(true);

if(!p_element.webBindings)p_element.webBindings=new Array();

this._element.webBindings.push(this);

this.getParameters=function()

{

    if(!blnMerge)

    {

        if(p_strNamespace&&this.constructor.Params)p_htParams=MergeArguments(p_element,p_strNamespace,p_htParams,this.constructor.Params);

        blnMerge=true;

    }

    return p_htParams;

};

this.registerFor=function(fnType,p_fncCallback,p_elScope)

{

    if(!aobjRegistrations)aobjRegistrations=new Array();

    aobjRegistrations.push(this.parentScope.registerFor(fnType,p_fncCallback,p_elScope));

};

this.initialize=function(p_owner)

{

    if(!this._objDeclaration)

    {

        this._objDeclaration=CreateDefinition(new Array(this._element),this.constructor,null,null,null,p_owner||m_rootScope,p_strNamespace?p_strNamespace.toLowerCase():null,p_htParams);

        if(p_owner&&p_owner!=m_rootScope)p_owner=p_owner.scope;

    }

    if(p_owner&&p_owner!=m_rootScope)this.parentScope=p_owner;

    else this.parentScope=m_rootScope;

    this.parentScope.add(this);

    BindingChangedNotification(this,false);

};

objWebBinding.Base.registerBaseMethod(this,"initialize");

this.dispose=function(p_blnUnloading)

{

    this.parentScope.remove(this);

    this._element.webBindings.remove(this);

    if(!p_blnUnloading)

    {

        BindingChangedNotification(this,true);

        var strReplace=m_this.constructor.removeClass(this._element.className);

        if(strReplace!=this._element.className)this._element.className=strReplace;

    }

    for(var strEventName in this._htEvents)

    {

        this._htEvents[strEventName].clear();

    }

    if(aobjRegistrations)

    {

        var objReg=aobjRegistrations.pop();

        while(objReg)

        {

            this.parentScope.unregisterFor(objReg);

            objReg=aobjRegistrations.pop();

        }

    }

    p_element=p_htParams=this._element=this.parentScope=this._objDeclaration=null;

};

objWebBinding.Base.registerBaseMethod(this,"dispose");

};

var objPrototype=this.Base.prototype;

objPrototype.attachEvent=function(p_strEventName,p_fncCallback)

{

if(this.constructor.Events&&this.constructor.Events[p_strEventName])

{

    if(!this._htEvents)this._htEvents=new Object();

    if(!this._htEvents[p_strEventName])this._htEvents[p_strEventName]=Web.Event.create();

    this._htEvents[p_strEventName].attach(p_fncCallback);

}

else throw "Invalid Event Name Specified";

};

objPrototype.detachEvent=function(p_strEventName,p_fncCallback)

{

if(this.constructor.Events&&this.constructor.Events[p_strEventName])

{

    if(this._htEvents&&this._htEvents[p_strEventName])this._htEvents[p_strEventName].detach(p_fncCallback);

}

else throw "Invalid Event Name Specified";

};

objPrototype.fire=function(p_strEventName,p_objPackage)

{

var returnValue=null;

if(this.constructor.Events&&this.constructor.Events[p_strEventName])

{

    if(this._htEvents&&this._htEvents[p_strEventName])

    {

        var objPackage=

        {

            "srcBinding":this,"eventName":p_strEventName,"Package":p_objPackage,"returnValue":null

        };

        this._htEvents[p_strEventName].fire(objPackage);

        if(objPackage.returnValue!=null)returnValue=objPackage.returnValue;

    }

}

else throw "Invalid Event Name Specified";

return returnValue;

};

objPrototype.getIdentity=function()

{

return this._element.getAttribute(this._objDeclaration.strNamespace+":id")||"";

};

objPrototype.getType=function()

{

return this.constructor._typeName;

};

objPrototype._objDeclaration=null;

objPrototype.onbinding=function(p_objBinding)

{

};

objPrototype.onunbinding=function(p_objBinding)

{

};

this.Base.registerClass("Web.Bindings.Base");

this.extendBinding=function(p_el,p_objBindingScope)

{

if(p_el)

{

    var objScope=p_objBindingScope&&p_objBindingScope.scope||m_rootScope;

    while(objScope)

    {

        var aDecls=objScope.getDefinitions();

        for(var i=0;i<aDecls.length;i++)

        {

            var aobjCssSelectorRules=aDecls[i].objElementQuery.aobjCssSelectorRules;

            var elScope=aDecls[i].objElementQuery.elScope;

            if(aobjCssSelectorRules&&elScope)

            {

                if(Web.Dom.Css.doesElementPassRules(p_el,aobjCssSelectorRules,elScope))CreateAndBind(p_el,aDecls[i]);

            }

        }

        objScope=objScope.parentScope;

    }

}

};

this.revalidateBinding=function(p_el,p_objBindingScope)

{

if(p_el)

{

    if(p_el.webBindings)for(var i=p_el.webBindings.length-1;

    i>=0;

    i--)

    {

        var objElementQuery=p_el.webBindings[i]._objDeclaration.objElementQuery;

        var aobjCssSelectorRules=objElementQuery.aobjCssSelectorRules;

        var elScope=objElementQuery.elScope;

        if(aobjCssSelectorRules&&elScope&&!Web.Dom.Css.doesElementPassRules(p_el,aobjCssSelectorRules,elScope))p_el.webBindings[i].dispose(false);

    }

    objWebBinding.extendBinding(p_el,p_objBindingScope);

}

};

this.removeBindings=function(p_el)

{

if(p_el&&p_el.webBindings)

{

    var intCount=p_el.webBindings.length;

    for(var i=intCount-1;i>=0;i--)

    {

        p_el.webBindings[i].dispose(false);

    }

    p_el.webBindings=null;

    return true;

}

return false;

};

this.dispose=function()

{

m_rootScope.dispose();

};

function pageDestroy()

{

    m_unloading=true;

    objWebBinding.dispose();

}

Web.Runtime.onunload.attach(pageDestroy);

this.Definition=function()

{

};

this.Definition.create=function(p_objElementQuery,p_objTypeDescriptor,p_objScope,p_strNamespace,p_htParams,p_objImportInfo,p_elScope)

{

    var objDecl=new objWebBinding.Definition();

    objDecl.objElementQuery=p_objElementQuery;

    objDecl.objTypeDescriptor=p_objTypeDescriptor;

    objDecl.objScope=p_objScope;

    objDecl.strNamespace=p_strNamespace;

    objDecl.htParams=p_htParams;

    objDecl.objImportInfo=p_objImportInfo;

    objDecl.elScope=p_elScope;

    return objDecl;

};

this.Definition.prototype.dispose=function()

{

    this.objImportInfo=this.htParams=this.objScope=this.objTypeDescriptor=this.objElementQuery=this.elScope=null;

};

function CreateDefinition(p_vSelector,p_vBindingType,p_astrBindingSources,p_astrStyleSources,p_ePriority,p_objScope,p_strNamespace,p_htParams,p_elScope)

{

    var objImportInfo=null;

    if(p_astrBindingSources&&p_astrBindingSources.length>0||p_astrStyleSources&&p_astrStyleSources.length>0)

    {

        var objPriorities=Web.Utility.Prioritizer.Priorities;

        var ePriority=Web.Enum.getValue(objPriorities,p_ePriority);

        if(!ePriority)ePriority=objPriorities.High;

        if(!p_astrBindingSources)p_astrBindingSources=new Array();

        if(!p_astrStyleSources)p_astrStyleSources=new Array();

        objImportInfo=

        {

            "astrSources":p_astrBindingSources,"eBindingPriority":ePriority,"astrStyles":p_astrStyleSources

        };

    }

    var objElementQuery;

    if(!p_vSelector||typeof p_vSelector=="string")objElementQuery=

    {

        "aobjCssSelectorRules":Web.Dom.Css.createRules(p_vSelector),"elScope":p_objScope&&p_objScope._element||document.documentElement

    };

    else objElementQuery=

    {

        "elements":p_vSelector

    };

    var objTypeDescriptor=Web.Type.Descriptor.create(p_vBindingType);

    var objScope;

    if(p_objScope&&p_objScope!=m_rootScope)

    {

        if(!p_objScope.scope)

        {

            p_objScope.scope=new Scope();

            p_objScope.scope.initialize(p_objScope);

        }

        objScope=p_objScope.scope;

    }

    else objScope=m_rootScope;

    var objDeclaration=objWebBinding.Definition.create(objElementQuery,objTypeDescriptor,objScope,p_strNamespace,p_htParams,objImportInfo,p_elScope);

    objScope.addDefinition(objDeclaration);

    return objDeclaration;

}

function BindingChangedNotification(p_objChangedBinding,p_blnRemoved)

{

    if(p_objChangedBinding&&p_objChangedBinding._element)

    {

        var strEventName=p_blnRemoved?"onunbinding":"onbinding";

        var blnFireBack=!p_blnRemoved&&p_objChangedBinding[strEventName];

        var aobjBindings=p_objChangedBinding._element.webBindings;

        for(var i=0;i<aobjBindings.length;i++)

        {

            if(aobjBindings[i]!=p_objChangedBinding)

            {

                if(aobjBindings[i][strEventName])aobjBindings[i][strEventName](p_objChangedBinding);

                if(blnFireBack)p_objChangedBinding[strEventName](aobjBindings[i]);

            }

        }

    }

}

this.attachElementBindingSync=function(p_elItem,p_vBindingType,p_objScope,p_htParams,p_strNamespace)

{

    var fncType=Web.Type.resolve(p_vBindingType);

    var objBinding=new fncType(p_elItem,p_htParams,p_strNamespace);

    objBinding.initialize(p_objScope);

    return objBinding;

};

this.attachElementBinding=function(p_elItem,p_vBindingType,p_objScope,p_htParams,p_strNamespace,p_fncCallback,p_astrBindingSource,p_astrStyleSource,p_ePriority)

{

    return objWebBinding.attachSelectorBinding(new Array(p_elItem),p_vBindingType,p_objScope,p_htParams,p_strNamespace,null,p_fncCallback,p_astrBindingSource,p_astrStyleSource,p_ePriority)[0];

};

this.attachSelectorBindingSync=function(p_vSelector,p_vBindingType,p_objScope,p_htParams,p_strNamespace,p_elScope)

{

    return objWebBinding.attachSelectorBinding(p_vSelector,p_vBindingType,p_objScope,p_htParams,p_strNamespace,p_elScope);

};

this.attachSelectorBinding=function(p_vSelector,p_vBindingType,p_objScope,p_htParams,p_strNamespace,p_elScope,p_fncCallback,p_astrBindingSource,p_astrStyleSource,p_ePriority)

{

    var objDeclaration=CreateDefinition(p_vSelector,p_vBindingType,p_astrBindingSource,p_astrStyleSource,p_ePriority,p_objScope,p_strNamespace?p_strNamespace.toLowerCase():null,p_htParams,null,p_elScope);

    return objWebBinding.bindDeclaration(objDeclaration,p_fncCallback);

};

function CreateAndBind(p_element,p_objDeclaration)

{

    var fncType=p_objDeclaration.objTypeDescriptor.fncType;

    if(p_element.webBindings)for(var i=0;

    i<p_element.webBindings.length;

    i++)

    {

        if(fncType==p_element.webBindings[i].constructor)return p_element.webBindings[i];

    }

    var objBinding=new fncType(p_element,p_objDeclaration.htParams||new Object(),p_objDeclaration.strNamespace);

    objBinding._objDeclaration=p_objDeclaration;

    objBinding.initialize(p_objDeclaration.objScope);

    return objBinding;

}

this.bindDeclaration=function(p_objDeclaration,p_fncAsyncCallback)

{

function SourcesLoaded()

{

    var arrMatch=new Array();

    var fncType=p_objDeclaration.objTypeDescriptor.fncType;

    if(!fncType)fncType=Object.getFromName(p_objDeclaration.objTypeDescriptor.strType);

    if(!fncType)

    {

        throw "Binding class ("+p_objDeclaration.objTypeDescriptor.strType+") could not be found";

        return;

    }

    p_objDeclaration.objTypeDescriptor.fncType=fncType;

    var aelTargets=p_objDeclaration.objElementQuery.elements;

    if(!aelTargets)

    {

        if(p_objDeclaration.objElementQuery.aobjCssSelectorRules.length==0)aelTargets=new Array(document.documentElement);

        else aelTargets=Web.Dom.Css.getElementsByCssSelectorRules(p_objDeclaration.objElementQuery.aobjCssSelectorRules,p_objDeclaration.objElementQuery.elScope);

    }

    var iTargets=aelTargets.length;

    for(var i=0;i<iTargets;i++)

    {

        var objBinding=CreateAndBind(aelTargets[i],p_objDeclaration);

        if(p_fncAsyncCallback)p_fncAsyncCallback(objBinding);

        arrMatch.push(objBinding);

    }

    aelTargets=null;

    return arrMatch;

}

if(p_objDeclaration.objImportInfo&&(p_objDeclaration.objImportInfo.astrSources.length>0||p_objDeclaration.objImportInfo.astrStyles.length>0))

{

    Web.Utility.loadSources(p_objDeclaration.objImportInfo.astrSources,p_objDeclaration.objImportInfo.astrStyles,p_objDeclaration.objImportInfo.eBindingPriority,SourcesLoaded);

    return new Array();

}

else return SourcesLoaded();

};

function MergeArguments(p_el,p_strNamespace,p_htSource,p_objList)

{

    var htMerged=new Object();

    if(p_strNamespace)for(var i in p_objList)

    {

        var strAttribName=i.toLowerCase();

        try

        {

            var strValue=p_el.getAttribute(p_strNamespace+":"+strAttribName);

            if(strValue)

            {

                htMerged[strAttribName]=new String(strValue);

                htMerged[strAttribName].Default=p_htSource[strAttribName];

            }

            else htMerged[strAttribName]=p_htSource[strAttribName];

        }

        catch(ex)

        {

            htMerged[strAttribName]=p_htSource&&p_htSource[strAttribName];

        }

    }

    return htMerged;

}

function Init()

{

    var strPrefix="web:";

    var aelwebBinding=Web.Dom.getAnyElementByTagName(strPrefix+"binding",null,true);

    var iBindingCount=aelwebBinding.length;

    for(var i=0;i<iBindingCount;i++)

    {

        var astrSources=new Array();

        var astrStyles=new Array();

        var strPriority="";

        var htParams=new Object();

        var iChildCount=aelwebBinding[i].childNodes.length;

        for(var iGroups=0;iGroups<iChildCount;iGroups++)

        {

            var elGroup=aelwebBinding[i].childNodes[iGroups];

            var strGroupName=Web.Dom.resolveTagName(elGroup);

            if(strGroupName)switch(strGroupName.toLowerCase())

            {

                case strPrefix+"references":strPriority=elGroup.getAttribute("priority");

                var iSourceCount=elGroup.childNodes.length;

                for(var iSources=0;iSources<iSourceCount;iSources++)

                {

                    var elSource=elGroup.childNodes[iSources];

                    var strSourceName=Web.Dom.resolveTagName(elSource);

                    if(strSourceName&&strSourceName.toLowerCase()==strPrefix+"add")

                    {

                        var strType=elSource.getAttribute("type");

                        if(!strType)strType="script";

                        switch(strType.toLowerCase())

                        {

                            case "css":astrStyles.push(elSource.getAttribute("src"));

                            break;

                            case "script":astrSources.push(elSource.getAttribute("src"));

                            break;

                        }

                    }

                }

                break;

                case strPrefix+"defaults":var iParamCount=elGroup.childNodes.length;

                for(var iParams=0;iParams<iParamCount;iParams++)

                {

                    var elParam=elGroup.childNodes[iParams];

                    var strParamName=Web.Dom.resolveTagName(elParam);

                    if(strParamName&&strParamName.toLowerCase()==strPrefix+"param")

                    {

                        var strName=elParam.getAttribute("name");

                        if(strName)htParams[strName.toLowerCase()]=elParam.getAttribute("value");

                    }

                }

                break;

            }

        }

        if(aelwebBinding[i].getAttribute("type"))

        {

            var objDeclaration=CreateDefinition(aelwebBinding[i].getAttribute("selector"),aelwebBinding[i].getAttribute("type"),astrSources,astrStyles,strPriority,m_rootScope,aelwebBinding[i].getAttribute("namespace"),htParams);

            objWebBinding.bindDeclaration(objDeclaration,null);

        }

        else Web.Utility.loadSources(astrSources,astrStyles,null,null);

    }

}

Web.Runtime.oninit.attach(Init);

}

();

