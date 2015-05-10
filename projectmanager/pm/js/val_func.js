function IsYear( str )
{
	if ( str.length!=4)
       		return false;

	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
			return false;
	}
	
	if ((str<1900) || (str>3000)) return false;
	return true;
      		  	
}    

 function IsIntegerProfitAndLoss( str )
{	
	if ( str.length == 0 )
		return false;	
			if ( str.length == 1&&str.charAt(i)=="0")
		return false;
		
		if ( (str.charAt(0) < "0" || str.charAt(0) > "9")&& str.charAt(0) != "-" )
				return false;
				
	for ( var i = 1 ; i < str.length; i ++ )
	{	
		
			if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
				return false;
			
	}
	return true;
}     

function IsMonth( str )
{
	if (( str.length==0) ||(str.length>2))
       		return false;

	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
			return false;
	}
	
	if ((str<1) || (str>12)) return false;
	return true;
      		  	
}

function IsDay( str )
{
	if (( str.length==0) ||(str.length>2))
       		return false;

	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
			return false;
	}
	
	if ((str<1) || (str>31)) return false;
	return true;
}

function IsDouble( str1 )
{	  var str = str1 + '';
	if ( str.length == 0 )
		return false;
	var docnum = 0;
	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( str.charAt(i) == "." ){
			docnum ++;
			continue;
		}else{
			if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
			return false;
		}
	}
	if (docnum > 1){
		return false;
	}
	return true;
}
function IsInteger( str )
{	
	if ( str.length == 0 )
		return false;	
		
	for ( var i = 0 ; i < str.length; i ++ )
	{		
		if ( str.charAt(i) < "0" || str.charAt(i) > "9" )
			return false;
	}
	return true;
}
	
function IsAlpha( str )
{	
	if ( str.length == 0 )
		return false;
		
	str = str.toUpperCase();
	
	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( str.charAt(i) < "A" || str.charAt(i) > "Z" )
			return false;
	}
	return true;
}
	
function IsAlnum( str )
{	
	if ( str.length == 0 )
		return false;
		
	str = str.toUpperCase();
		
	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( !( ( (str.charAt(i) >= "A") && (str.charAt(i) <= "Z") ) || 
			( (str.charAt(i) >= "0") && (str.charAt(i) <= "9") ) ) )
			return false;
	}
	return true;
}
	
function IsTel( str )
{	
	if ( str.length == 0 )
		return false;
		
	for ( var i = 0 ; i < str.length; i ++ )
	{
		if ( ( str.charAt(i) < "0" || str.charAt(i) > "9" ) && str.charAt(i) != "-" )
			return false;
	}
	return true;
}
	
function IsEMail( str )
{	
	var pos;
		
	if ( ( pos = str.indexOf( "@" ) ) == -1 )
	{	
		return false;
	}
	else if ( ( pos = str.indexOf("@", pos + 1) )  != -1 )
	{
		return false;
	}
			
	return true;
}
	
	function ShowMsg(Msg, Obj)
	{
		alert( Msg );
		Obj.focus();
		return false;
	}
	
function trim(inputStr) {
	var result = inputStr
	while (result.substring(0,1) == " ") {
		result = result.substring(1,result.length)
	}
	
	while (result.substring(result.length-1, result.length) == " ") {
		result = result.substring(0, result.length-1)
	}
		
	return result
}
	