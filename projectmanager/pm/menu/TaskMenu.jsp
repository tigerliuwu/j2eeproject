<%@ page language="java" contentType="text/html;charset=GB2312" pageEncoding="GBK"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>



<html:html>

<head>

	<title></title>


</head>


<script src="./menu/TaskMenu.js"></script>

<script>
 
TaskMenu.setStyle("./menu/Blue/BlueStyle.css");



window.onload = function()
{

<logic:iterate id="cate" name="result" indexId="index">
<bean:define id="bigMenu" name="cate" property="permission" />
	var menu;
	
	menu = new TaskMenu('<bean:write name="bigMenu" property="permissionName" />',false);
	
	<logic:iterate id="menu" name="cate" property="menuSet" indexId="index1">
	
	
	var item;
	
	item=new TaskMenuItem('<bean:write name="menu" property="permissionName" />','./menu/Image/<bean:write name="menu" property="imageName" />',"parent.window.mainFrame.location.href="+"'<bean:write name="menu" property="permissionUrl" />'");
	
	menu.add(item);
	
	
	</logic:iterate>
	
	
	menu.init();

</logic:iterate>
	
	
}

</script>


<body id="menu_body">

</body>
</html:html>