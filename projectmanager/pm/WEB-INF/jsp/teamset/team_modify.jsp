<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>


<html>

	<head>

		<title></title>

		<link rel="stylesheet" href="././css/public.css">
		

	</head>

	

<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script>

<script type="text/javascript" src="./js/selectDateTime.js"></script>

<SCRIPT LANGUAGE="JavaScript">

function MoveClick(formId,toId)
{
  var fromList = document.getElementById(formId);
  var toList = document.getElementById(toId);
  
  if(fromList.selectedIndex != -1)
  {
    for (var i=0; i < fromList.options.length; ++i)
    {
      if (fromList.options[i].selected)
      {
        toList.options[toList.options.length] = Option(fromList.options[i].text);
        toList.options[toList.options.length-1].value=fromList.options[i].value;
        
        fromList.options[i] = null;
        --i;
      }
    }
  }
}

function SubmitClick()
{
  var teamList,temp;
  temp="";
  teamList=document.getElementById("teamList");
  
  for (var i=0; i < teamList.options.length; ++i)
  {
	  temp= temp+"/"+teamList.options[i].value;
  }

  document.teamForm.userList.value=temp;
  document.teamForm.submit();
}

</script>

<body>
<html:form action="/teamModifyAction">

<html:hidden property="userList"/>

		<table width="98%" cellpadding="0" cellspacing="0" align="center">

			<br>

			<tr>

				<td valign="top">

					<img src="././images/misc_arrow.gif">
					
					<strong><font color="#040466">&nbsp;&nbsp;项目成员管理</font></strong>
					
					<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<strong><font color="#040466">项目名称：</font></strong>
					<bean:write name="project" property="projectName" />&nbsp;&nbsp;&nbsp;&nbsp;
					<strong><font color="#040466">项目经理：</font></strong>
					<gdc:write name="project" property="pmId" labelvalue="Users"/>

					<hr noshade width="100%" size="1">

					

					<table width="80%" border="1" align="left" cellpadding="2"

						cellspacing="0" borderColor="#FFFFFF" class="datatable" style="display:block">


						<tr height="25" bgcolor="#E9EBEF" >
							<td width="5%" align="center">非当前项目成员</td>
							<td width="1%">&nbsp;</td>
							<td width="5%" align="center">当前项目成员</td>
						</tr>
						
						<tr height="200">
							<td align="right">
								<html:select  property="notTeamList" multiple="true" size="20" styleId="notTeamList" style="width:100%">
								<html:optionsCollection name="notTeam" label="label" value="value" />
								</html:select>
							</td>
							<td valign="center" align="center">
							
								<input type="button" value=" >> " onclick="MoveClick('notTeamList','teamList')" class="button"/>
								<br><br>
								<input type="button" value=" << " onclick="MoveClick('teamList','notTeamList')" class="button"/>
							
							</td>
							<td align="left" >
								<html:select  property="teamList" multiple="true" size="20" styleId="teamList" style="width:100%">
								<html:optionsCollection name="team" label="label" value="value" />
								</html:select>
							</td>
						</tr>
						
						<tr>
							<td>&nbsp;</td>
							<td  align="center" height="50">
									<input type="button" class="button" value="  确 定  " onclick="SubmitClick()"/>
							</td>
							<td>&nbsp;</td>
						</tr>



					</table>



			  </td>

			</tr>

		</table>
		

		</html:form>

		</body>

		</html>