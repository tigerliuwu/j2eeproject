<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
 <title>rt</title>
 <STYLE type=text/css>
 .blue {
	FONT-SIZE: 14px; COLOR: #000033; FONT-FAMILY: "宋体"
}
</STYLE>

</head>

<script language="JavaScript">
	
	function mySubmit(action)
	{
		parent.rtFrame.form1.action=action;
		parent.rtFrame.form1.submit();
	}
	function myDelete(action)
	{
		if(confirm('确认删除?')){
			parent.rtFrame.form1.target="leftFrame";
			parent.rtFrame.form1.action=action;
			parent.rtFrame.form1.submit();
		}
	}
	
</script>

<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">

     <form name='form1' action='' target="rbFrame">
	    <input type="hidden" name="id" value='<bean:write name="id" />'/>
	 </form>
		 
<TABLE width="100%"  border=0 height=80  >
<TBODY>
<TR align=left >
    <TD vAlign=top  height=80 bgColor=#a8c8f9 valign=center>
    <TABLE>
    <TBODY>
    <TR><TD height=15></TR>
	<TR align=left >
	<TD height=40 width=30></TD>
	
	
	<logic:equal name="kind"  value="pro0">
	
	<TD height=40><DIV align=left><IMG height=9 src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backProjectCreatePreAction.do');">添加项目</A>
         </DIV>
     </TD>
	
	</logic:equal>
	
	<logic:equal name="kind"  value="pro_">
	
	<TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backProjectModifyPreAction.do');">编辑项目</A>
         </DIV>
     </TD>
     <TD height=40><DIV align=left><IMG height=9 src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:myDelete('backProjectDeleteAction.do');" >删除项目</A>
         </DIV>
     </TD>
     <TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backProjectTeamPreAction.do');" >项目成员维护</A>
         </DIV>
     </TD>
	
	</logic:equal>
	
	<logic:equal name="kind"  value="use0">
	
	<TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backUserCreatePreAction.do');" >添加用户</A>
         </DIV>
     </TD>
	
	</logic:equal>
	
	<logic:equal name="kind"  value="use_">
	
	<TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backUserModifyPreAction.do');">编辑用户</A>
         </DIV>
     </TD>
     <TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:myDelete('backUserDeleteAction.do');">删除用户</A>
         </DIV>
     </TD>
	
	</logic:equal>
     
	<logic:equal name="kind"  value="rol_">
	
     <TD height=40><DIV align=left><IMG height=9  src="././img/dian04.gif" width=9></DIV></TD>
     <TD class=blue height=30 width=120>
         <DIV align=left>
         <A class=blue href="javascript:mySubmit('backModifyRolePreAction.do');">角色权限维护</A>
         </DIV>
     </TD>
	
	</logic:equal>
    
    
    
    </TR>
 </TBODY>
 </TABLE>
   
    </TD>
</TR>
 </TBODY>
 </TABLE>

</body>
</html>
