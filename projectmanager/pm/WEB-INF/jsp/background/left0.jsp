<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
 <title>left</title>
 <STYLE type=text/css>
 .article{
	FONT-SIZE: 14px;  FONT-FAMILY: "宋体"
  }
  .red {
	COLOR: #ff0000
  }
</STYLE>
</head>

<body topmargin="0" leftmargin="0" bgcolor="#FFFFFF">

<TABLE width="100%"  border=0>
<TBODY>
<TR align=middle >
    <TD vAlign=top width=230 height=500 bgColor=#a8c8f9>
      <table class=article>
		<tbody>
		  <form name='form1' action='backLoginAction.do' target="leftFrame">
		  
		  <tr height=10>
		     <td colspan="3"></td>
		  </tr> 
		  <tr class="RED"   >
		 	 <TD width=20></TD>
		     <td colspan="4"><html:errors/></td>
		  </tr> 
		  <tr height=10>
		     <td colspan="3"></td>
		  </tr> 
		  <TR>
		  <TD width=20></TD>
		  <TD align=center>用户名:</TD><TD><input type="text" name="id" ></TD>
		  <TD width=20></TD>
		  </TR>
		  <TR>
		  <TD width=20></TD>
		  <TD align=center>密&nbsp;&nbsp;码:</TD><TD><input type="password" name="password" ></TD>
		  
		  </TR>
		   <tr height=20>
		     <TD width=20></TD>
		     <TD width=20></TD>
		     <TD>
		     <input type="submit" name="Submit" value=" 录 入 " >
		     <input type="reset" name="reset" value=" 清 空 " >
		     </TD>
		  </tr> 
		  </form>
	
	  </TBODY>
	  </TABLE>
    
    </TD>
</TR>
 </TBODY>
 </TABLE>

</body>
</html>
