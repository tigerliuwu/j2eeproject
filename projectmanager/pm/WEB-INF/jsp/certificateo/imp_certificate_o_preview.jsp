<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="GBK"%>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/struts-gdc.tld" prefix="gdc"%>




<html>

	<head>

		<title></title>

		<link rel="stylesheet" href="././css/public.css">
		
		<style type="text/css">
		<!--
		.STYLE14 {font-size: 14px}
		.STYLE16 {font-family: "宋体", Tahoma, verdana; font-size: 24px; font-weight: bold; }
		-->
		</style>

	</head>

	

<script src="././js/StringUtil.js"></script>

<script src="././js/val_func.js"></script>

<script src="././js/xmlRequest.js"></script>





	<script language="JavaScript">


	

	function Back1()

	{

		document.forms[0].action = 'impCertificateOSearchAction.do';

		document.forms[0].submit();		

	}

	

	</script>



	<body>
	<%
		String total=(String)request.getAttribute("total");
	%>
	<html:form action="/impCertificateOSearchPreAction">

		<table width="90%" cellpadding="0" cellspacing="0" align="center">
<br>
<tr>
	<td valign="top"><strong><font color="#040466">&nbsp;&nbsp;Certificate O&nbsp;->&nbsp;Preview</font></strong></td>
</tr>
<tr>
	<td><hr noshade width="100%" size="1"></td>
</tr>
<tr>
<td>
<!-- 正文开始 ----------------------------------------------------------------------------------------------------->
<style>
TABLE
{
    font-family:Tahoma,verdana;
	FONT-SIZE: 8pt;
	cursor: default;
	 
	border-color:black;
	border-collapse:collapse;
}
.STYLE4 {font-size:16.0pt;}
.STYLE5 {font-size:10.0pt;}
.STYLE6 {font-size:10.0pt;}
</style>
<table width="838" height="113" border="0">
  <tr>
    <td width="832" height="109">
									<P align="center" class="STYLE4">
										<STRONG>中华人民共和国自动进口许可证 </STRONG></P><DIV align="right">
										<DIV align="center" class="STYLE6" >
											<STRONG> AUTOMATIC IMPORT LICENCE OF THE PEOPLE'S REPUBLIC OF CHINA</STRONG> &nbsp;
										</DIV>
									</DIV></td>
  </tr>
</table>
<table width="838" border="1" cellpadding="2" cellspacing="2" >
  <tr>
    <td width="358" height="58" valign="top" class="STYLE5">1 .进口商：<br>
    Importer<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="importer" labelvalue="Importer" /></td>
    <td width="464" valign="top" class="STYLE5">3.自动进口许可证号：<br>Automatic inport licence No.<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="certificateNo" /></td>
  </tr>
  <tr>
    <td height="59" valign="top" class="STYLE5">2.进口用户：<br>
    Consignee<br>
    <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="consignee" labelvalue="Consignee" /></td>
    <td valign="top" class="STYLE5">4.自动进口许可证有效截止日期：<br>Automatic import licence expiry date<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="expiredDate" format="yyyy年MM月dd日"/></td>
  </tr>
  <tr>
    <td valign="top" class="STYLE5">5.贸易方式：<br> Terms of trade<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="termsOfTrade" labelvalue="ImpTradeTerm" /></td>
    <td valign="top" class="STYLE5">8.贸易国（地区）：<br>Country/Ragion of exporation<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="countryOfExportation" labelvalue="Country" /> </td>
  </tr>
  <tr>
    <td valign="top" class="STYLE5">6.外汇来源：<br>Terms of foreign exchange<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="temsOfForeignExchange" labelvalue="OForeignExchange" /></td>
    <td valign="top" class="STYLE5">9.原产地国（地区）：<br>Country/Region of origin<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="countryOfOrigin" /></td>
  </tr>
  <tr>
    <td height="69" valign="top" class="STYLE5">7. 报关口岸:<br />
      Place of clearance<br />
      <br />
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="importPort" labelvalue="ImportPort" /> </td>
    <td valign="top" class="STYLE5">10.商品用途：<br>Use of goods<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="goodsUse" labelvalue="GoodUse"/></td>
  </tr>
  <tr>
    <td  colspan="2" valign="middle" class="STYLE5"><table width="823"  border="0" style="Border-color
:red;Border-style:none;">
      <tr>
        <td width="272" class="STYLE5">11.商品名称</td>
        <td width="228" class="STYLE5">商品编码</td>
        <td width="309" class="STYLE5">商品状态</td>
      </tr>
      <tr>
        <td valign="top" class="STYLE5">Description of goods </td>
        <td valign="top" class="STYLE5">Code of goods </td>
        <td valign="top" class="STYLE5">Status of Goods </td>
      </tr>
      <tr>
        <td height="29" valign="bottom" class="STYLE5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="goodsDescription" /></td>
        <td valign="bottom" class="STYLE5">
        <bean:define id="hscode0" name="o" property="pubHscode" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="hscode0" property="hscode" /></td>
        <td valign="bottom" class="STYLE5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<gdc:write name="o" property="goodsStatus" labelvalue="GoodStatus" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td colspan="2" class="STYLE5">
    
    
    <table width="834"  border="1">
      <tr>
        <td width="130" height="43" align="center" class="STYLE5">12.规格、型号<br>
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Specification</td>
        <td width="130" align="center" class="STYLE5">13.单位<br>
          Unit		</td>
        <td width="130" align="center" class="STYLE5">14.数量<br>Quantity</td>
        <td width="130" align="center" class="STYLE5">15.单价（USD）<br>
          Unit price </td>
        <td width="130" align="center" class="STYLE5">16.总值（USD）<br>
          Amount</td>
        <td width="144" align="center" class="STYLE5">17.总值折美元<br>
          AmountinUSD</td>
      </tr>
      
      
      <logic:iterate id="item" name="o" property="impCertificateOlines" indexId="index">
      
      <tr height="43" >
        <td align="center" class="STYLE5"><bean:write name="item" property="specification" /></td>
        <td align="center" class="STYLE5"><bean:write name="item" property="unit" /></td>
        <td align="center" class="STYLE5">*<bean:write name="item" property="quantity" />*</td>
        <td align="center" class="STYLE5">*<bean:write name="item" property="unitPrice" formatKey="currency.2.formkey"/>*</td>
        <td align="center" class="STYLE5">*<bean:write name="item" property="amount" formatKey="currency.2.formkey"/>*</td>
        <td align="center" class="STYLE5">*<bean:write name="item" property="amount" formatKey="currency.2.formkey"/>*</td>
      </tr>
	
	 </logic:iterate>

      <tr height="43" >
        <td align="center" class="STYLE5">****************</td>
        <td align="center" class="STYLE5">****************</td>
        <td align="center" class="STYLE5">****************</td>
        <td align="center" class="STYLE5">****************</td>
        <td align="center" class="STYLE5">****************</td>
        <td align="center" class="STYLE5">******************</td>
      </tr>
      
      
      <tr height="43" >
        <td align="center" class="STYLE5">18.总计</td>
        <td align="center" class="STYLE5">&nbsp;</td>
        <td align="center" class="STYLE5">*<bean:write name="o" property="totalQuantity" />*</td>
        <td align="center" class="STYLE5">&nbsp;</td>
        <td align="center" class="STYLE5">*<%=total%>*</td>
        <td align="center" class="STYLE5">*<%=total%>*</td>
      </tr>
    </table>
    
    
    </td>
  </tr>
  <tr>
    <td height="138" valign="top" class="STYLE5">19.备注：<br>
    Supplementary details<br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<bean:write name="o" property="remark" /></td>
    <td valign="top"><span class="STYLE5">20.发证机关签章：<br>
      Issuing authority's stamp</span>
      <h2 align="center"><bean:write name="o" property="issueStamp" /></h1>
      <span class="STYLE5">
      </p>21.发证日期：<bean:write name="o" property="licenceDate" format="yyyy年MM月dd日"/><br>
    Licence Date</span></td>
  </tr>
</table>
<p>&nbsp;</p>

 
</table>
<table border="0" width="100%">
 <tr>
    <td align="center"><input name="Back" type="button" class="button" value="  Back  " onClick="Back1()"></td>
  </tr>
  </table>


<!-- 正文结束 ----------------------------------------------------------------------------------------------------->
</td>
</tr>
</table>

		

		<html:errors />
		<gdc:errors />
		</html:form>
	</body>


		</html>