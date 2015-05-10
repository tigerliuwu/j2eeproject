

var seqNumber=0;


function setMainId(selectedId){
	top.frames[4].setMainId(selectedId);
}
function getMainId(){
	return top.frames[4].getMainId();
}

function add_table_row(tableid,data){
	insert_row(tableid,data);

}
function insert_row(tableid, values){	

	var the_table = document.getElementById(tableid);
		// add to end of table, can be modified to insert anywhere in table
	var new_row_index = the_table.rows.length;

	seqNumber++;
	
	the_table.insertRow(new_row_index);
	var rowid="row["+seqNumber+"]";

	the_table.rows[new_row_index].id=rowid;
	

	the_table.rows[new_row_index].align="center";
	
	
	for(var i=0;i<values.length;i++)
	{	
		the_table.rows[new_row_index].insertCell(i);
		if (i==0){	
			the_table.rows[new_row_index].cells[i].innerHTML = new_row_index;
		}else{
			var index_str = values[i].indexOf('DEL');
			if (index_str != -1)
			{
				values[i] = replaceString(values[i], 'INDEX', seqNumber);
			}
			the_table.rows[new_row_index].cells[i].innerHTML =  values[i];
		}
	}


}

function replaceString(inputString, reg, replaceval){
	var index_str = inputString.indexOf(reg);
	var inputStringTmp = inputString;
	var i=0;
	while (index_str != -1){
		var length = inputStringTmp.length;
		var left = inputStringTmp.substring(0, index_str);
		var right = inputStringTmp.substring(index_str+reg.length, length);
		inputStringTmp = left + replaceval + right;
		index_str = inputStringTmp.indexOf(reg);
		i ++;
		if (i==10)
		break;
	}
	return inputStringTmp;
}

function deleteRow(rowIndex,selectedId,tableid){

	//top.frames[4].deleteSelectedId(selectedId);

	var the_table = document.getElementById(tableid);

	the_table.deleteRow(rowIndex);

	for(aRow=1;aRow<the_table.rows.length;aRow++){

		var oldRow = the_table.rows[aRow].cells[0].innerHTML;
		the_table.rows[aRow].cells[0].innerHTML=aRow;		
		the_table.rows[aRow].id='row['+aRow+']';

		for (var i=0; i<the_table.rows[aRow].cells.length; i++){
			var source = the_table.rows[aRow].cells[i].innerHTML;
			var index_str = source.indexOf('DEL');
				if (index_str != -1)
				{
					the_table.rows[aRow].cells[i].innerHTML = replaceString(source, oldRow, aRow);
				}

		}

	}
	seqNumber = the_table.rows.length-1;
}

