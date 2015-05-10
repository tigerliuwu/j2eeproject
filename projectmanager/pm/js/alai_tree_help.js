function getScriptPath(js)
{
	js=js.toLowerCase()
	var script=document.getElementsByTagName("SCRIPT");
	for(var i=0;i<script.length;i++)
	{
		var s=script[i].src.toLowerCase()
		if(s.indexOf(js)!=-1)return s.replace(js,"")
	}
	return null
}

function alai_tree_help(toObject)
{
	var icons=new alai_imagelist()
	icons.path="./img/"
	icons.add("hfile","default")
	icons.add("hfold_open")
	icons.add("hfold_close")
	icons.add("plus_m","expand")
	icons.add("plus_top","expand_top")
	icons.add("plus_end","expand_end")
	icons.add("minus_m","collapse")
	icons.add("minus_top","collapse_top")
	icons.add("minus_end","collapse_end")
	icons.add("branch","leaf")
	icons.add("branch_end","twig")
	icons.add("vline","line")
	icons.add("blank")
	var tree=new alai_tree(icons,0,toObject)
	
	tree.afteradd=function(srcNode)
	{
		if(srcNode.parent!=tree.root)srcNode.parent.icon.src=icons.item["hfold_open"].src
	}
	tree.onexpand=function(srcNode)
	{
		srcNode.icon.src=icons.item["hfold_open"].src
	}
	tree.oncollapse=function(srcNode)
	{
		srcNode.icon.src=icons.item["hfold_close"].src
	}
	return tree
}
