
var gdc_ajax_url_bases  = window.location.href.split('/');
var gdc_ajax_url_base = gdc_ajax_url_bases[0] + '//' + gdc_ajax_url_bases[2] + '/'+gdc_ajax_url_bases[3] + '/';
var gdc_ajax_parno;
var gdc_ajax_id_form;

var gdc_ajax_expand_lists = new Array();
var gdc_ajax_id_expand = 'empty';

function gdc_ajax_line_expand_modify(parno) {
		
		gdc_ajax_parno = parno;
		
		var tr2 = $('gdc_ajax_id_tr2_' + gdc_ajax_parno);
		
		var url = gdc_ajax_url_base + gdc_ajax_url_expand;

		var pars = gdc_ajax_parname + '=' + gdc_ajax_parno + '&randnum=' + Math.random();	
		
		if (tr2.style.display == "none")  {
		
			var options = {asynchronous: true,
			    method:'get', parameters:pars, onComplete:gdc_ajax_line_expand_response
			};		
		
			var request = new Ajax.Request(url, options);
				
			tr2.style.display = "block";
			new Effect.Highlight(tr2);
		} else {
			tr2.style.display = "none";	
			if(gdc_ajax_id_expand != 'empty'){
				$(gdc_ajax_id_expand).innerHTML = "";
			}else{
				$('gdc_ajax_id_expand_' + gdc_ajax_parno).innerHTML = "";
			}
		}
}
		
function gdc_ajax_line_expand_view(parno, index) {
		
		gdc_ajax_parno = parno;
		
		var tr2 = $('gdc_ajax_id_tr2_' + gdc_ajax_parno);
		
		var url = gdc_ajax_url_base + gdc_ajax_url_expand;

		var pars = gdc_ajax_parname + '=' + gdc_ajax_parno + '&randnum=' + Math.random();	
		
		if (tr2.style.display == "none")  {
			if (gdc_ajax_expand_lists[index] == null) {
		
				var options = {asynchronous: true,
				    method:'get', parameters:pars, onComplete:gdc_ajax_line_expand_response
				};		
		
				var request = new Ajax.Request(url, options);
				
				gdc_ajax_expand_lists[index] = 'Y';
			} 

			tr2.style.display = "block";
			new Effect.Highlight(tr2);
		} else {
			tr2.style.display = "none";	
		}
}

function gdc_ajax_line_expand_response(request){

	if(gdc_ajax_id_expand != 'empty'){
		$(gdc_ajax_id_expand).innerHTML = request.responseText;
	}else{
		$('gdc_ajax_id_expand_' + gdc_ajax_parno).innerHTML = request.responseText;
	}
}

function gdc_ajax_line_modify(parno) {

		gdc_ajax_parno = parno;
		
		gdc_ajax_id_form = 'gdc_ajax_id_form_' + parno;

		var url = gdc_ajax_url_base + gdc_ajax_url_modify;
		
    	gdc_ajax_line_form_reset();
		$('gdc_ajax_id_error_modify_' + parno).innerHTML = '';

		var options = {
		    method:'post',
		    postBody:Form.serialize($('gdc_ajax_id_form_' + parno)),
		    onComplete:gdc_ajax_line_modify_response
		};		

		var request = new Ajax.Request(url, options);
		
}


function gdc_ajax_line_delete(parno){

		gdc_ajax_parno = parno;
		
		var url = gdc_ajax_url_base + gdc_ajax_url_delete;

		var pars = gdc_ajax_parname + '=' + gdc_ajax_parno + '&randnum=' + Math.random();	
		
		var options = {asynchronous: true,
		    method:'get', parameters:pars, onComplete:gdc_ajax_line_delete_response
		};		
	
		var request = new Ajax.Request(url, options);

}


function gdc_ajax_line_delete_response(request) {
	
	var root = request.responseXML.documentElement;	
    
    var responseNodes = root.getElementsByTagName("response");
    
    if (responseNodes.length > 0) {
    
        var responseNode = responseNodes[0];
        var itemNodes = responseNode.getElementsByTagName("item");
	    var valueNodes = itemNodes[0].getElementsByTagName("value");
	    var success = valueNodes[0].firstChild.nodeValue;

        if(success == 'Y'){    
      
            var displayTable = $('gdc_ajax_id_table');  
            
            for(var i = 2; i < displayTable.rows.length; i++){
            
            	if (displayTable.rows[i].id == 'gdc_ajax_id_tr1_' + gdc_ajax_parno)
            		displayTable.deleteRow(i);     
            	if (displayTable.rows[i].id == 'gdc_ajax_id_tr2_' + gdc_ajax_parno)     
            		displayTable.deleteRow(i);  	            	  		
            
            }
            
            var num = 1; 
            for(var j = 2; j < displayTable.rows.length; j++){
            	displayTable.rows[j].cells[0].innerHTML = '<div align="center">'+ Math.round(num/2) +'</div>';	 
            	num++;          
            }
        
        } else {
			  $('gdc_ajax_id_error_delete').innerHTML = gdc_ajax_line_form_error_only_content(itemNodes);
	    }		    
	}		
}         

function gdc_ajax_line_modify_response(request) {

	var root = request.responseXML.documentElement;
	var responseNodes = root.getElementsByTagName("response");
	      
	if (responseNodes.length > 0) {

		var responseNode = responseNodes[0];
	      
		var itemNodes = responseNode.getElementsByTagName("item");
		var valueNodes = itemNodes[0].getElementsByTagName("value");
		var success = valueNodes[0].firstChild.nodeValue;
		  
		var itemlength = itemNodes.length;

		if (success == 'Y') {
	      
			var tr1_row = $('gdc_ajax_id_tr1_' + gdc_ajax_parno);	      	  
			var tr2_row = $('gdc_ajax_id_tr2_' + gdc_ajax_parno);
	      	  
			for (var i = 2; i < itemlength; i++) { 
			
		      	if (getNeedCell(i) == false){
	            	continue;
	            }		

				tr1_cell =  tr1_row.cells[i-1];

		    	var valueNodes = itemNodes[i].getElementsByTagName("value");
		        var nameNodes  = itemNodes[i].getElementsByTagName("name");    

		        if (nameNodes.length > 0 && valueNodes.length > 0) {		        
										
					if(valueNodes[0].firstChild != null){ 
						tr1_cell.innerHTML = valueNodes[0].firstChild.nodeValue;     
					}
					else{
						tr1_cell.innerHTML ="";
					}  
		          }
		      }
		      
		      tr2_row.style.display = "none";	
		      new Effect.Highlight(tr1_row);
		      
	      }else{
			  $('gdc_ajax_id_error_modify_' + gdc_ajax_parno).innerHTML = gdc_ajax_line_form_error(itemNodes);
	      }
	    }
			
}
		

function gdc_ajax_line_select(parno)
{
		gdc_ajax_parno = parno;
		
		gdc_ajax_id_form = 'gdc_ajax_form_select_' + parno;

		var url = gdc_ajax_url_base + gdc_ajax_url_select;

    	gdc_ajax_line_form_reset();
		$('gdc_ajax_id_error_select').innerHTML = '';

		var options = {
		    method:'post',
		    postBody:Form.serialize($('gdc_ajax_form_select_' + parno)),
		    onComplete:gdc_ajax_line_add_response
		};		

		var request = new Ajax.Request(url, options);
		
}


function gdc_ajax_line_add()
{
		gdc_ajax_id_form = gdc_ajax_id_form_add;
    	gdc_ajax_line_form_reset();
		$('gdc_ajax_id_error_add').innerHTML = '';
		
		var url = gdc_ajax_url_base + gdc_ajax_url_add;
		
		var options = {
			method:'post',
			postBody:Form.serialize($('gdc_ajax_id_form_add')),
			onComplete:gdc_ajax_line_add_response
		};
		
		var request = new Ajax.Request(url, options);
		
}


function gdc_ajax_line_add_response(request) {

	var root = request.responseXML.documentElement;
	
	var responseNodes = root.getElementsByTagName("response");
	    
	if (responseNodes.length > 0) {

		var responseNode = responseNodes[0];
	      
	    var itemNodes = responseNode.getElementsByTagName("item");
		var valueNodes = itemNodes[0].getElementsByTagName("value");
		var success = valueNodes[0].firstChild.nodeValue;
		
		var itemlength = itemNodes.length;

			
	    if (success == 'Y') {    
	      	    	
	        var displayTable = $('gdc_ajax_id_table');
			  
			var firstValueNodes = itemNodes[1].getElementsByTagName("value");
			var firstValue = firstValueNodes[0].firstChild.nodeValue;
			  
			var newRow = displayTable.insertRow();
			  		          
		    newRow.id = 'gdc_ajax_id_tr1_' + firstValue;
			newRow.onMouseOut = "this.style.backgroundColor='#FFFFFF'";
			newRow.onMouseOver = "this.style.backgroundColor='#DDDDDD'";
			newRow.height="20"
			  
			num_cell = newRow.insertCell();
			num_cell.align = 'center';
			num_cell.innerHTML = Math.round((displayTable.rows.length - 2) / 2);
				
			
			for (var i = 2; i < itemlength; i++) {  
		      
		      	if (getNeedCell(i) == false){
	            	continue;
	            }		

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
			  
			  newHiddenRow.id = 'gdc_ajax_id_tr2_' + firstValue;
			  newHiddenRow.style.display="none";

			  newHiddenRow.insertCell().innerHTML = "";
			  
			  dropDownCell = newHiddenRow.insertCell();
			  dropDownCell.id = 'gdc_ajax_id_expand_' + firstValue;
			  dropDownCell.align = 'left';
			  dropDownCell.colSpan = itemlength - 3;
			  dropDownCell.innerHTML = "";
			  		      
			  $('gdc_ajax_id_error_add').innerHTML = "";
		   } else {
			  $('gdc_ajax_id_error_add').innerHTML = gdc_ajax_line_form_error(itemNodes);
		   }           
		     
	    }

	    
}

function gdc_ajax_line_form_reset() {

	fields = $(gdc_ajax_id_form).getElementsByTagName('*');
				  
	for( var i = 0; i < fields.length; i++ ) {
	
		thisElmStyle = fields[i].getAttribute('style');			  
		if(thisElmStyle.backgroundColor != null && thisElmStyle.backgroundColor == "yellow") {
			thisElmStyle.backgroundColor = '#FFFFFF'; 
		}
		
	}
	
}

function gdc_ajax_line_form_error_only_content(itemNodes) {

	var error_contents = '<UL>';
	
	for (var i = 1; i < itemNodes.length; i++) {
	
	    var nameNodes = itemNodes[i].getElementsByTagName("name");
	    var valueNodes = itemNodes[i].getElementsByTagName("value");
	    
	    if (nameNodes.length > 0 && valueNodes.length > 0) {
	    	
			if(valueNodes[0].firstChild != null) {
	    		var value = valueNodes[0].firstChild.nodeValue;
	      		error_contents += '<LI><font color="#FF0000">' + value + '</font></LI>';	   
	      	}       
	      
	    }
    }		    
    
    return error_contents + '</UL>';
}

function gdc_ajax_line_form_error(itemNodes) {

	var error_contents = '<UL>';
	
	for (var i = 1; i < itemNodes.length; i++) {
	
	    var nameNodes = itemNodes[i].getElementsByTagName("name");
	    var valueNodes = itemNodes[i].getElementsByTagName("value");
	    
	    if (nameNodes.length > 0 && valueNodes.length > 0) {
	    	
	    	var name = nameNodes[0].firstChild.nodeValue;		          

			if(valueNodes[0].firstChild != null) {
	    		var value = valueNodes[0].firstChild.nodeValue;
	      		error_contents += '<LI><font color="#FF0000">' + value + '</font></LI>';	   
	      	}       
	      
			fields = $(gdc_ajax_id_form).getElementsByTagName('*');
			
			for( var j = 0; j < fields.length; j++ ) {
				thisElmName = fields[j].getAttribute('name');
			    thisElmStyle = fields[j].getAttribute('style');			  
			  	if (thisElmName != null && name == thisElmName) {
					thisElmStyle.backgroundColor = 'yellow';                   
			  	}					  
			}
	    }
    }		  
    
    return error_contents + '</UL>';
}

function hidden_conditions()
{
	var conditions_table = $("conditions_table");
	var hidden_img = $("hidden_img");
	
	if ( conditions_table.style.display == "none" ) {
		conditions_table.style.display = "block";
		hidden_img.src = "./images/splitter_d.gif";
	} else {
		conditions_table.style.display = "none";	
		hidden_img.src="./images/splitter_u.gif";
	}
				
}