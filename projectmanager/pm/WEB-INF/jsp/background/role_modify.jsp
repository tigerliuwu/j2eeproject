<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
 <title>role modify</title>
 
 <script LANGUAGE="JavaScript">
 
   function computeList(){
   
	var form1=document.form1;
	var permissionList=form1.permissionList;
	var node;
	for(i=1;i<tree1.count();i++){
		node=tree1.nodes[i];
		if(node.checkBox.checked){
			permissionList.value=permissionList.value+"/"+node.getKey();
		}
	}
	
	form1.submit();

   }
   
   function myCheck(key){
   
	   	srcNode=tree1.nodes[key];
	   	
	   	if(srcNode.checkBox.checked){
		   	if(srcNode.hasChild){
			   	first=srcNode.getIndex();
		   		last=findLast(key);
			   	for(i=first+1;i<=last;i++){
					node=tree1.nodes[i];
					node.checkBox.checked=true;
				}
		   	}
		   	while(srcNode.parent.getKey()!=0){
   				srcNode.parent.checkBox.checked=true;
   				srcNode=srcNode.parent;
   			}
	   	}
	   	else{
	   		if(srcNode.hasChild){
			   	first=srcNode.getIndex();
		   		last=findLast(key);
			   	for(i=first+1;i<=last;i++){
					node=tree1.nodes[i];
					node.checkBox.checked=false;
				}
		   	}
	   	}
	   
   }
   
   function findLast(key){
   		srcNode=tree1.nodes[key];
   		while(srcNode.last!=null){
   			srcNode=srcNode.last;
   		}
   		return srcNode.getIndex();
   }
   
   
 </script>
 
</head>

<STYLE type=text/css>
 
.button {

	BORDER-RIGHT: #F7F7F7 1px solid;

	BORDER-TOP: #F7F7F7 1px solid;

	FONT-SIZE: 8pt;

	FONT-FAMILY: Tahoma,verdana;

	BORDER-LEFT: #F7F7F7 1px solid;

	background-image:url(././images/Blue.gif);

	BORDER-BOTTOM: #F7F7F7 1px solid;

	cursor: hand;

	HEIGHT: 20px;

}
</STYLE>

<script type="text/javascript" src="./js/alai_tree.js"></script>

<script type="text/javascript" src="./js/alai_tree_check.js"></script>

<script type="text/javascript" src="./js/alai_tree_help.js"></script>


<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF" >

<TABLE width="100%"  border=0>
<TBODY >
<TR align=middle >
    <TD vAlign=top width=720 height=500 >
   
    <div  id="divTree1" style="width:720;border:1 inset;padding:4;height:380;overflow:auto "></div>
    
    <script LANGUAGE="JavaScript">
	//add pictures
	var tree1=new alai_tree_help(divTree1);
	//add notes
	var root=tree1.root;
	var all=tree1.add(root,"last","所有权限","0");
	</script>
	
    <logic:present scope="request" name="result">
	<logic:iterate id="node" name="result" indexId="index" > 
	
	   <script LANGUAGE="JavaScript">
		node=tree1.addChkNode(tree1.nodes['<bean:write name="node" property="parentId"/>'],"last",'<bean:write name="node" property="permissionName"/>','<bean:write name="node" property="id"/>',<bean:write name="node" property="checked"/>);
		
	   </script>
	  
    </logic:iterate>
	</logic:present>

 <script LANGUAGE="JavaScript">
 
      tree1.expandAll(true);
     
     
 </script>
 
 <div align=center>
			
	 <form name="form1" action="backModifyRoleAction.do" >
		 <input type=hidden name="roleId" value='<bean:write name="role" property="id" />'/>
		 <input type=hidden name="permissionList" value=""/>
		 <input type="button" class="button" value="   提  交    " onclick="computeList();" />
	 </form>
	
 </div>  
    </TD>
</TR>
 </TBODY>
 </TABLE>

</body>
</html>
