
<%@ page language="java" import="java.util.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'userSave.jsp' starting page</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
  </head>
  
  <body>
  <%
  	String user_id=request.getParameter("user_id");
  	String req=request.getParameter("req");
  %>
  <script language="JavaScript">
			var loc="<%=req%>";
			var s1="";
			var s2="";
			var i=-1;

			for(;loc.indexOf('@')!=-1;)
			{
				i=loc.indexOf('@');
				s1=loc.substring(0,i);
				s2='&'+loc.substring(i+1,loc.length);
				loc=s1+s2;
			}


	window.location=loc;
  </script>
  
  </body>
</html>
