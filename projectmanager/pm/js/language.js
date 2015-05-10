// Copyright (c) Microsoft Corporation. All rights reserved.

registerNamespace("Start");

Start.LanguagePreference=function(b,c,e)

{

    Start.LanguagePreference.initializeBase(this,arguments);

    var m_el=b;

    var m_this=this;

    this.initialize=function(g)

    {

        Start.LanguagePreference.getBaseMethod(this,"initialize","Web.Bindings.Base").call(this,g);

        var hdr=document.createElement("div");

        hdr.innerHTML=L_LanguagePrompt_Text;

        m_el.appendChild(hdr);

        var markets=[

        {

            "id":"de-de","lang":"Deutsch","loc":"Deutschland"

        }

        ,

        {

            "id":"en-au","lang":"English","loc":"Australia"

        }

        ,

        {

            "id":"en-gb","lang":"English","loc":"United Kingdom"

        }

        ,

        {

            "id":"en-us","lang":"English","loc":"United States"

        }

        ,

        {

            "id":"es-es","lang":"Espa&#241;ol","loc":""

        }

        ,

        {

            "id":"es-us","lang":"Espa&#241;ol","loc":"Estados Unidos"

        }

        ,

        {

            "id":"fr-fr","lang":"Fran&#231;ais","loc":""

        }

        ,

        {

            "id":"it-it","lang":"Italiano","loc":""

        }

        ,

        {

            "id":"ja-jp","img":"loc/ja/language.gif"

        }

        ];

        for(var i=0;i<markets.length;i++)

        {

            var el=document.createElement("div");

            m_el.appendChild(el);

            var item=Web.Bindings.attachElementBindingSync(el,Start.LanguagePreference.LanguageItem,m_this,

            {

                "config":markets[i]

            }

            );

        }

    };

};



Start.LanguagePreference.registerClass("Start.LanguagePreference","Web.Bindings.Base");



Start.LanguagePreference.LanguageItem=function(j,k,l)

{

    Start.LanguagePreference.LanguageItem.initializeBase(this,arguments);

    var m_el=j;

    var m_this=this;

    var m_config=k.config;

    this.initialize=function(m)

    {

        Start.LanguagePreference.LanguageItem.getBaseMethod(this,"initialize","Web.Bindings.Base").call(this,m);

        m_el.className="languageSelector";

        if(m_config.img)

        {

            m_el.innerHTML="<img src='"+m_config.img+"'>";

            m_el.style.paddingTop="3px";

            m_el.style.paddingBottom="3px";

        }

        else

        {

            m_el.innerHTML=m_config.lang;

            if(m_config.loc)m_el.innerText+=" ("+m_config.loc+")";

        }

        m_el.attachEvent("onmousedown",o);

    };

    this.dispose=function(n)

    {

        Start.LanguagePreference.LanguageItem.getBaseMethod(this,"dispose","Web.Bindings.Base").call(this,n);

        m_el.detachEvent("onmousedown",o);

    };

	function o()

	{

		function p()

		{

		    var h=location.href.split("?")[0];

		    location.replace(h);

		}

		theApp.SetPreference(Start.Const.PrefPrefix+"market",m_config.id,p);

	}

};



Start.LanguagePreference.LanguageItem.registerClass("Start.LanguagePreference.LanguageItem","Web.Bindings.Base");

