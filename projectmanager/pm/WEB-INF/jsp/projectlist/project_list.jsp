<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>

<%@ page import="edu.pm.constants.PMConstants" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>


<html:html>

	<head>

		<title></title>
		
		<link rel="stylesheet" href="././css/public.css">
		
	</head>


<script type="text/javascript" src="./js/prototype-1.4.0.js"></script>

<script type="text/javascript" src="./js/scriptaculous.js"></script>

<script type="text/javascript" src="./js/overlibmws.js"></script>

<script type="text/javascript" src="./js/ajaxtags.js"></script>

<script type="text/javascript" src="./js/olsUtil.js"></script>

<script language="JavaScript">

	
	var dropUrl = 'targetListProjectAction.do';

	var currentPars = 'id';	
	
	function FindTarget(projectId)
	{
		open_close=document.getElementById("open_close_"+projectId);
		
		if(open_close.src.indexOf("open")==-1){
			open_close.src="././images/open0.gif";
		}
		else{
			open_close.src="././images/close0.gif";
		}
		dropContentArray(projectId);	

	}
	
</script>




<body>




	<table width="98%" cellpadding="0" cellspacing="0" align="center">

	<br>



		<tr>

			<td valign="top">

				<img src="././images/misc_arrow.gif">
				<strong><font color="#040466">当前项目列表</font></strong>

				<hr noshade width="100%" size="1">

				
					<br>



<table width="100%" border="1" id="results_table_1" align="center" cellpadding="2" cellspacing="0" borderColor="silver" class="datatable">


<tr bgcolor="E9EBEF">

	<td width="2%"><div align="center">序号</div></td>
	<td width="5%"><div align="center">项目编号</div></td>
	<td width="10%"><div align="center">项目名称</div></td>
	<td width="5%"><div align="center">项目经理</div></td>
	<td width="5%"><div align="center">开始日期</div></td>
	<td width="5%"><div align="center">结束日期</div></td>
	<td width="5%"><div align="center">剩余天数</div></td>
	<td width="5%"><div align="center">项目成员</div></td>
	<td width="5%"><div align="center">状态</div></td>
	<td width="5%"><div align="center">操作</div></td>
	
</tr>




<logic:iterate id="item" name="result" indexId="index">

<bean:define name="item" property="id" id="projectId"/>

<tr onMouseOut="this.style.backgroundColor='#FFFFFF'" onMouseOver="this.style.backgroundColor='#DDDDDD'" >
	
	<td align="left">
	
		<logic:greaterThan name="item" property="targetCount" value="0">
		<img src="././images/close0.gif" style="cursor:hand" onclick="FindTarget('<bean:write name="item" property="id" />')"
		id="open_close_<bean:write name="item" property="id" />">
		</logic:greaterThan>
	
		<gdc:iteratorNO indexId="index" />
	</td>
	
	<td align="center"><bean:write name="item" property="projectCode" /></td>
	
	<td align="center">
	
		<logic:equal name="item" property="status" value="<%=PMConstants.StatusProjectInit%>">
		
			<bean:write name="item" property="projectName" />
			<gdc:Permission  permissionId="<%="1000_"+projectId.toString()%>" >
			-- <a href="main2.do?projectId=<%=projectId.toString()%>" >初始化</a>
			</gdc:Permission>
		
		</logic:equal>
		
		<logic:notEqual name="item" property="status" value="<%=PMConstants.StatusProjectInit%>">
		
			<a href="main2.do?projectId=<%=projectId.toString()%>" ><bean:write name="item" property="projectName" /></a>
		
		</logic:notEqual>
	
	</td>
	
	<td align="center"><gdc:write name="item" property="pmId" labelvalue="Users"/></td>
	<td align="center"><bean:write name="item" property="startDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="closeDate" formatKey="date.formkey"/></td>
	<td align="center"><bean:write name="item" property="leftDays" /></td>
	<td align="center">
		<a href="userListAction.do?projectId=<bean:write name="item" property="id" />" >
			<bean:write name="item" property="userCount" />
		</a>
	</td>
	<td align="center"><gdc:write name="item" property="status" labelvalue="ProjectStatus"/></td>
	<td align="center">
		<gdc:Permission  permissionId="<%="1001_"+projectId.toString()%>" >
			<img src="././images/operate1.gif" style="cursor:hand" alt="查看组织资源"
			onClick="location.href('humanResPreAction.do?projectId=<%=projectId.toString()%>');" >
		</gdc:Permission>
		&nbsp;&nbsp;
		<gdc:Permission  permissionId="<%="1002_"+projectId.toString()%>" >
			<img src="././images/operate2.gif" style="cursor:hand" alt="查看项目进展"
			onClick="location.href('workloadStaAction.do?projectId=<%=projectId.toString()%>');" >
		</gdc:Permission>
	</td>
	
</tr>

<tr style="display:none" id="tr2_<bean:write name="item" property="id" />"  >
	<td align="center">&nbsp;</td>
	<td align="left" colspan="10" id="tr2_td_<bean:write name="item" property="id" />" >&nbsp;
	</td>
</tr>

</logic:iterate>		

</table>




<br>
  <html:form styleId="formpage" action="/projectListAction">
			<gdc:pages />
  </html:form>
<br>



			</td>

		</tr>

	</table>

 </body>


</html:html>




