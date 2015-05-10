// Util OLS
//Add by Bobby , Change the baseUrl

var urls  = window.location.href.split('/');

var baseUrl = urls[0]+'//'+urls[2]+'/'+urls[3]+'/';

var currentid;
var detailList = new Array();

function changeColor(id,num,color){

	var id = id;
	
	var num = num;
	
	$(id).style.backgroundColor=color;
	
	for(i=0;i<num-1;i++){
		var line_id=id+'_'+i;
		$(line_id).style.backgroundColor=color;
	}
}

function resetSuccessForm(id,errorid) {

	var current_form = document.getElementById(id);	
	
	childList = current_form.getElementsByTagName('*');
				  
	for( var e = 0; e < childList.length; e++ ) {
	
	 	thisInput = childList[e];
		if( thisInput.nodeName.toLowerCase() == 'input' ) {
		
		  thisElmStyle = thisInput.getAttribute('style');			  

		  if (thisElmStyle.backgroundColor == "yellow") {
		  
		  	thisElmStyle.backgroundColor = '#FFFFFF'; 
		  			  
		  }
		  
		}					
		
	}
	
	$(errorid).innerHTML = '';
}

function addLine(request) {
		
	    var root = request.responseXML.documentElement;
	    
	    var responseNodes = root.getElementsByTagName("response");
	    
	    if (responseNodes.length > 0) {

	      var responseNode = responseNodes[0];
	      var itemNodes = responseNode.getElementsByTagName("item");
		  var valueNodes = itemNodes[0].getElementsByTagName("value");


//Bobby delete , there is no delete button in the first row at all, stony said.
	//	  var flags = valueNodes[0].firstChild.nodeValue.split('%');

	//	  var success = flags[0];
	
		  var success = valueNodes[0].firstChild.nodeValue;
			
		  resetSuccessForm('addLineForm','addLine_errors');
	      
	      if(success == 'Y'){    
	      
	          var displayTable = $('displayTable');
			  
			  var firstValueNodes = itemNodes[1].getElementsByTagName("value");
			  var firstValue = firstValueNodes[0].firstChild.nodeValue;
			  
			  var newRow = displayTable.insertRow();
			  		          
			  newRow.id= 'tr1_'+firstValue;
			  newRow.onMouseOut = "this.style.backgroundColor='#FFFFFF'";
			  newRow.onMouseOver = "this.style.backgroundColor='#DDDDDD'";
			  
			  num_cell = newRow.insertCell();
			  num_cell.align = 'center';
			  num_cell.innerHTML = Math.round((displayTable.rows.length - 2) / 2);
			  
			  var sencondValueNodes = itemNodes[2].getElementsByTagName("value");
			  var sencondValue = sencondValueNodes[0].firstChild.nodeValue;	
			  
			  var secondNameNodes = itemNodes[2].getElementsByTagName("name");
			  var secondName = secondNameNodes[0].firstChild.nodeValue;
			  
			  first_cell = newRow.insertCell();
			  first_cell = setCellStyle(first_cell,secondName);
			  
			  first_cell.innerHTML = '<a href="#" onclick="javascript:dropContent('+firstValue+');">'+sencondValue+'</a>';
			
			
			  for (var i=3; i<itemNodes.length; i++) { 
			  
			  	  new_cell = newRow.insertCell();	
			  	  new_cell.align = 'center'; 
		      
		          var valueNodes = itemNodes[i].getElementsByTagName("value");
		          var nameNodes  = itemNodes[i].getElementsByTagName("name");          
		        
		       
		          if (nameNodes.length > 0 && valueNodes.length > 0) {		
		          
		          	  if(valueNodes[0].firstChild != null) 
					      new_cell.innerHTML = valueNodes[0].firstChild.nodeValue;
					  setCellStyle(new_cell, nameNodes[0].firstChild.nodeValue);		 
					              
		          }
		      }		      
			  
			  new Effect.Highlight(newRow);
			  
			  var newHiddenRow = displayTable.insertRow();
			  
			  newHiddenRow.id = 'tr2_'+firstValue;
			  newHiddenRow.style.display="none";
			  
			  newHiddenRow.insertCell().innerHTML = "";
			  
			  dropDownCell = newHiddenRow.insertCell();
			  
			  dropDownCell.id = 'tr2_td_'+firstValue;
			  dropDownCell.align='left';
			  dropDownCell.colSpan=20;
			  
			  dropDownCell.innerHTML = "";
			  		      
		   } else {
		   
		      var error_contents = '';
		      for (var i=1; i<itemNodes.length; i++) {
		        var nameNodes = itemNodes[i].getElementsByTagName("name");
		        var valueNodes = itemNodes[i].getElementsByTagName("value");
		        if (nameNodes.length > 0 && valueNodes.length > 0) {
		          var name = nameNodes[0].firstChild.nodeValue;		          
		          var value = valueNodes[0].firstChild.nodeValue;
				  var current_form = document.getElementById('addLineForm');	
				  childList = current_form.getElementsByTagName('*');
				  for( var e = 0; e < childList.length; e++ ) {
				 	thisInput = childList[e];
					if( thisInput.nodeName.toLowerCase() == 'input' ) {
					  thisElmName = thisInput.getAttribute('name');
					  thisElmStyle = thisInput.getAttribute('style');			  


					  if (name == thisElmName) {
						
						
						thisElmStyle.backgroundColor = 'yellow';                   

					  }					  
					}					
					
				  }
					
		          error_contents += '<li>' + value + '</li>';	          
		          
		        }
		      }
		      
		      $('addLine_errors').innerHTML = error_contents;
		   
		   }           
		     
	    }
	    
}
	
function deleteLine(request)
{
	
		var root = request.responseXML.documentElement;	
	    
	    var responseNodes = root.getElementsByTagName("response");
	    
	    if (responseNodes.length > 0) {
	    
	        var responseNode = responseNodes[0];
	        
	        var itemNodes = responseNode.getElementsByTagName("item");
		    var valueNodes = itemNodes[0].getElementsByTagName("value");

		    var success = valueNodes[0].firstChild.nodeValue;

	        if(success == 'Y'){    
	      
	            var displayTable = $('displayTable');  
	            var deleteRowId = $('tr1_'+currentid);
	            
	            for(var i=2; i<displayTable.rows.length; i++){
	            
	            	if (displayTable.rows[i].id == 'tr1_'+currentid )
	            		displayTable.deleteRow(i);     
	            	if (displayTable.rows[i].id == 'tr2_'+currentid )     
	            		displayTable.deleteRow(i);  	            	  		
	            
	            }
	            
	            var num = 1; 
	            
	            for(var j=2; j<displayTable.rows.length; j++){
	            
	            	displayTable.rows[j].cells[0].innerHTML = '<div align="center">'+ Math.round(num/2) +'</div>';	 
	            	num++;          
	            
	            }
	        
	        } else {
		   
		          var error_contents = '';
			      for (var i=1; i<itemNodes.length; i++) {
			        var nameNodes = itemNodes[i].getElementsByTagName("name");
			        var valueNodes = itemNodes[i].getElementsByTagName("value");
			        if (nameNodes.length > 0 && valueNodes.length > 0) {
			          var name = nameNodes[0].firstChild.nodeValue;		          
			          var value = valueNodes[0].firstChild.nodeValue;
					  var current_form = document.getElementById(currentid);	
					  childList = current_form.getElementsByTagName('*');
					  for( var e = 0; e < childList.length; e++ ) {
					 	thisInput = childList[e];
						if( thisInput.nodeName.toLowerCase() == 'input' ) {
						  thisElmName = thisInput.getAttribute('name');
						  thisElmStyle = thisInput.getAttribute('style');			  
	
	
						  if (name == thisElmName) {
							
							
							thisElmStyle.backgroundColor = 'yellow';                   
	
						  }					  
						}					
						
					  }
						
			          error_contents += '<li>' + value + '</li>';	          
		          
		        }
		      }
		      
		      $('errors_'+currentid).innerHTML = error_contents;
		   
		    }		    
		}		
}         


function add()
{
		var url = baseUrl + addUrl;
		var options = {
			method:'post',
			postBody:Form.serialize($('addLineForm')),
			onComplete:addLine
		};
		
		var request = new Ajax.Request(url, options);
		
}
	
function del(id)
{
		currentid = id;	
		
		var url = baseUrl + deleteUrl;
		
		var pars = '?' + currentPars + '=' + id;
		
		var options = {
			method:'post',
			onComplete:deleteLine
		};
		
		var request = new Ajax.Request(url+pars, options);

}
	
function updateComplete(request) 
{		
	    var root = request.responseXML.documentElement;
	    
	    var responseNodes = root.getElementsByTagName("response");
	      
	    if (responseNodes.length > 0) {

	      var responseNode = responseNodes[0];
	      var itemNodes = responseNode.getElementsByTagName("item");
		  var valueNodes = itemNodes[0].getElementsByTagName("value");

		  var success = valueNodes[0].firstChild.nodeValue;

	      if(success == 'Y'){
	      
	      	 	      	  
	      	  var tr2_row = $('tr2_'+currentid);
// Modify by ZhouLiang 10-12-2006
// if(itemNodes.length >1) was added
     	  
	      	  if(itemNodes.length >1){
	      	  
	      	   var tr1_row = $('tr1_'+currentid);
	      	  
	      	  var firstValueNodes = itemNodes[1].getElementsByTagName("value");		      
		      var sencondValueNodes = itemNodes[2].getElementsByTagName("value");
		      
		      var firstValue = firstValueNodes[0].firstChild.nodeValue;	
		      var sencondValue = sencondValueNodes[0].firstChild.nodeValue;		
		         
		      tr1_row.cells[1].innerHTML =  '<a href="#" onclick="javascript:dropContent('+firstValue+');">'+sencondValue+'</a>';      

		      for (var i=3; i<itemNodes.length; i++) {
		      
		      	tr1_cell = tr1_row.cells[i-1];
		      	
		        var valueNodes = itemNodes[i].getElementsByTagName("value");
		        var nameNodes  = itemNodes[i].getElementsByTagName("name");
		       	
		        if (nameNodes.length > 0 && valueNodes.length > 0) {	
		        
		        	if(valueNodes[0].firstChild != null){ 
						tr1_cell.innerHTML = valueNodes[0].firstChild.nodeValue;  
						setCellStyle(tr1_cell,nameNodes[0].firstChild.nodeValue);	   
					}
					else{
						tr1_cell.innerHTML ="";
					} 
		        }		         
		      }
		      new Effect.Highlight(tr1_row);
		     } 
		      tr2_row.style.display = "none";	
		     
		      
	      }else{
		      var error_contents = '';
		      for (var i=1; i<itemNodes.length; i++) {
		        var nameNodes = itemNodes[i].getElementsByTagName("name");
		        var valueNodes = itemNodes[i].getElementsByTagName("value");
		        if (nameNodes.length > 0 && valueNodes.length > 0) {
		          var name = nameNodes[0].firstChild.nodeValue;		          
		          var value = valueNodes[0].firstChild.nodeValue;
				  var current_form = document.getElementById(currentid);	
				  childList = current_form.getElementsByTagName('*');
				  for( var e = 0; e < childList.length; e++ ) {
				 	thisInput = childList[e];
					if( thisInput.nodeName.toLowerCase() == 'input' ) {
					  thisElmName = thisInput.getAttribute('name');
					  thisElmStyle = thisInput.getAttribute('style');			  


					  if (name == thisElmName) {
						
						
						thisElmStyle.backgroundColor = 'yellow';                   

					  }					  
					}					
					
				  }
					
		          error_contents += '<li>' + value + '</li>';	          
		          
		        }
		      }
		      
		      $('errors_'+currentid).innerHTML = error_contents;
	      }
	    }
			
}
		
function updateContent(id) {
	
		currentid = id;	
		
		var url = baseUrl + modifyUrl;
		
		var options = {
		    method:'post',
		    postBody:Form.serialize($(id)),
		    onComplete:updateComplete
		};		

		var request = new Ajax.Request(url, options);
		
}
		
function dropContentArray(id,index) {
		
		currentid = id;
		
		var tr2 = $('tr2_'+id);
		
		var url = baseUrl + dropUrl;
		
		var pars = '?' + currentPars + '=' + id;	

		
	
		if (tr2.style.display == "none")  {
		
			if (detailList[index] == null) {
		
				var options = {asynchronous: true,
				    method:'get', parameters:pars, onComplete:showResponse
				};		
		
				var request = new Ajax.Request(url+pars, options);
				
				tr2.style.display = "block";	
				
				new Effect.Highlight(tr2);
				
				
				detailList[index] = request.responseText;
				
			} else {
			
				tr2.style.display = "block";
				
				new Effect.Highlight(tr2);
		
				$('tr2_td_'+object).innerHTML = detailList[index];	
			
			}
					
		} else {
		
			tr2.style.display = "none";	
		
		}
}


function dropContent(id) {
	
		currentid = id;
	
		var tr2 = $('tr2_'+id);
		
		var url = baseUrl + dropUrl;
		
		var pars = '?' + currentPars + '=' + id;
	
		if (tr2.style.display == "none")  {
		
			var options = {asynchronous: true,
			    method:'get', parameters:pars, onComplete:showResponse
			};		
			
			var request = new Ajax.Request(url+pars, options);
			
			tr2.style.display = "block";	
			new Effect.Highlight(tr2);
					
		} else {
		
			tr2.style.display = "none";	
		
		}
}


function transPY(strs) {
		

		var url = baseUrl + 'pubDriverTransPYAction.do';
		
		var pars = '?' + 'strs' + '=' + strs;		
			
			var options = {asynchronous: true,
			    method:'get', parameters:pars, onComplete:showResponseForTransPY
			};		
			
			var request = new Ajax.Request(url+pars, options);

}


function showResponseForTransPY(request){
	
	$('py').innerHTML = request.responseText;
}

function viewInvoice(no) {

		var url = baseUrl + 'expContractViewInvoiceInfoAction.do';
		
		var pars = '?' + 'invoiceNo' + '=' + no;
	
			var options = {asynchronous: true,
			    method:'get', parameters:pars, onComplete:showResponseForInvoice
			};		
			
			var request = new Ajax.Request(url+pars, options);

}

function showResponseForInvoice(request){
	$('detail').innerHTML = request.responseText;
}
function showResponse(request)
{
        $('tr2_td_'+currentid).innerHTML = request.responseText;
        
}
    
function hidden_conditions()
{
		var conditions_table = document.getElementById("conditions_table");
		var hidden_img = document.getElementById("hidden_img");
		
		if ( conditions_table.style.display == "none" ) {
		
			conditions_table.style.display = "block";
			hidden_img.src = "./images/splitter_d.gif";
		
		} else {
		
			conditions_table.style.display = "none";	
			hidden_img.src="./images/splitter_u.gif";
		
		}
				
}

function validateNumber(Object){
	
	if ( Object.value == "" ){
		return true;
	}
	
	if (!IsDouble( Object.value )){
		Object.style.backgroundColor = "#FFFF00";
	//	Object.focus();
		return false;
	}else{
		var str = Object.value;
		while (str.charAt(0) == "0"){
			if (str.charAt(1) == "." || str.length == 1){
			break;
			}			
			str = str.substring(1, str.length);
		}
		Object.value = str;
		Object.style.backgroundColor = "#F7F8F9";
		return true;	
	}	
}