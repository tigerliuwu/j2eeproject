<!-- Copyright (c) 2002 by ObjectLearn. All Rights Reserved. -->
<%@page contentType="text/html;charset=gb2312"%>
<%@ page language="java"%>

<html>
	<head>
		<title>Error Page</title>

		<%
			String absUrl = request.getContextPath(); 
			String req=request.getRequestURL().toString();
			String un=request.getRemoteUser();
			String message1="";
			String message2="";
			if(un==null){
			    message1="����û�е�½,���ܷ��������Դ,��";
				message2="��¼";
			      
			}else{
				message1="�û�:"+ un +" û��Ȩ�޷��������Դ,��";
				message2="ע��������һ�û���ݵ�½";
			}

		%>
	</head>
	<body>


		<script language="JavaScript">

			function myclick(req,req1) {

				window.location="/portaljapan/index.jsp?req="+req+"&req1="+req1;

			}

			var mytext1="<%=message1%>";
			var loc=location.href;
			var s1="";
			var s2="";
			var i=-1;

			for(;loc.indexOf('&')!=-1;)
			{
				i=loc.indexOf('&');
				s1=loc.substring(0,i);
				s2='@'+loc.substring(i+1,loc.length);
				loc=s1+s2;
			}

			var req1="<%=absUrl%>/userSave.jsp";
			var mytext2="<%=message2%>";
			var param="myclick('"+loc+"','"+req1+"')";
			document.write(mytext1+"<input type='button' onClick="+param+" value='"+mytext2+"' />");
		</script>

	
	</body>

</html>
