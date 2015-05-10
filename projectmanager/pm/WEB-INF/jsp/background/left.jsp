<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
 <title>left</title>
 
 <script LANGUAGE="JavaScript">
   function clearRB(){
   	parent.rbFrame.location.href="back_rb00.do";
   }
   
   function clearR(){
    parent.rtFrame.location.href="back_rt0.do";
   	parent.rbFrame.location.href="back_rb00.do";
   }
 </script>
 
</head>

<script type="text/javascript" src="./js/alai_tree.js"></script>

<script type="text/javascript" src="./js/alai_tree_help.js"></script>


<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF" onLoad="clearR()">

<TABLE width="100%"  border=0>
<TBODY >
<TR align=middle >
    <TD vAlign=top width=230 height=500 bgColor=#a8c8f9>
   
    <div  id="divTree1" style="width:284;border:1 inset;padding:4;height:520;overflow:auto "></div>
    
    <script LANGUAGE="JavaScript">
	//add pictures
	var tree1=new alai_tree_help(divTree1);
	//add notes
	var root=tree1.root;
	var all=tree1.add(root,"last","后台维护","root");
	var pro0=tree1.add(tree1.nodes["root"],"last","项目列表","pro0");
	var use0=tree1.add(tree1.nodes["root"],"last","用户列表","use0");
	var rol0=tree1.add(tree1.nodes["root"],"last","角色列表","rol0");
	</script>
	
    <logic:present scope="request" name="nodes">
	<logic:iterate id="node" name="nodes" indexId="index" > 
	
	   <script LANGUAGE="JavaScript">
		node=tree1.add(tree1.nodes['<bean:write name="node" property="parentid"/>'],"last","<bean:write name="node" property="text"/>","<bean:write name="node" property="treeid"/>");
		node.execute=function(){
		}
	   </script>
	  
    </logic:iterate>
	</logic:present>

 <script LANGUAGE="JavaScript">
 
     tree1.expandToTier(2);
     
     tree1.onclick=function(srcNode){
     	  parent.rtFrame.location.href="backHrefAction.do?treeid="+srcNode.getKey();
	      clearRB();
     }
 </script>
  
    </TD>
</TR>
 </TBODY>
 </TABLE>

</body>
</html>
