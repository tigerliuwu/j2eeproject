/********************************************************************************************
	����Ŀ¼���ؼ�֧��checkbox�ڵ㹦����չ���� �������������2003��7��17�գ���������Ȩ����
**********************************************************************************************/
function alai_tree_check()
{
	if(typeof(alai_tree)!="function")
	{
		alert("run alai_tree_check() fail, please load alai_tree firt!")
		return
	}
	//add(toNode,relation,text,key,ico,exeCategory,exeArg)
	var colChkNode=[]
	alai_tree.prototype.colChkNode=colChkNode
	alai_tree.prototype.addChkNode=function(toNode,last,text,key,checked,ico,exeCategory,exeArg)
	{
		var newNode=this.add(toNode,last,text,key,ico,exeCategory,exeArg)
		//var newNode=this.addNode(toNode,"last",text,key,ico,exeCategory,exeArg)
		var chkBox=document.createElement('<input type="Checkbox" onclick=myCheck(this.name)>')
		chkBox.name=key;
		var tree=this
		newNode.label.insertAdjacentElement("beforeBegin",chkBox)
		newNode.isCheck=true
		if(typeof(checked)=="boolean")chkBox.checked=checked;
		newNode.oncheck=new Function("return true;")
		chkBox.onpropertychange=function(){if(newNode.oncheck())tree.oncheck(newNode)}
		colChkNode[colChkNode.length]=newNode
		newNode.checkBox=chkBox
		return newNode
	}
	alai_tree.prototype.oncheck=new Function("return true;")
}
alai_tree_check()