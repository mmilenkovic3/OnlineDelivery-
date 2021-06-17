
var sortByUsername;
var sortByLastName;
var sortByPoints;
var sortU = 0;
var sortP;
var sortL; 

$(document).ready(function(){
	
	$.ajax({
		type : "GET",
		url : "rest/users/sortAscUsername",		
		contentType : "application/json",
		dataType : 'json',
		success : function(data) {
			sortByUsername = data;
			},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
	
	$.ajax({
		type : "GET",
		url : "rest/users/sortAscLastName",		
		contentType : "application/json",
		dataType : 'json',
		success : function(data) {
			sortByLastName = data;
			},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
	

	$.ajax({
		type : "GET",
		url : "rest/users/sortAscPoints",		
		contentType : "application/json",
		dataType : 'json',
		success : function(data) {
			sortByPoints = data;
			},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
	
	
	
	
	
});

function sortPoints()
{
	
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
	var employee_data;
	if(sortP == 0)
		{
		sortP = 1;
			 for(let i = 0; i <= sortByPoints.length-1; i++)
				{
					  employee_data += '<tr scope="row">';
				      employee_data += '<td scope="col">'+sortByPoints[i].role +'</td>';
				      employee_data += '<td scope="col">'+sortByPoints[i].username+'</td>';
				      employee_data += '<td scope="col">'+sortByPoints[i].name +'</td>';	      
				      employee_data += '<td scope="col">'+sortByPoints[i].lastname +'</td>';
				      if(sortByPoints[i].gender == "FEMALE")
				    	  employee_data += '<td scope="col"> Female</td>';
				      
				      else
				    	  employee_data += '<td scope="col"> Male</td>';
				      
				      employee_data += '<td scope="col">'+ (new Date(sortByPoints[i].birthday)).toISOString().split('T')[0]+'</td>';
				      employee_data += '<td scope="col">'+sortByPoints[i].points +'</td>';
				      employee_data += '<td scope="col">'+sortByPoints[i].customerType.type +'</td>';
				      employee_data += '<tr>';
				   
					
				}
				 
			   $('#tbodyId').append(employee_data);

			}
	else
		{
		sortP = 0;
			for(let i = sortByPoints.length-1; i >= 0 ; i--)
			{
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+sortByPoints[i].role +'</td>';
			      employee_data += '<td scope="col">'+sortByPoints[i].username+'</td>';
			      employee_data += '<td scope="col">'+sortByPoints[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+sortByPoints[i].lastname +'</td>';
			      if(sortByPoints[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(sortByPoints[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+sortByPoints[i].points +'</td>';
			      employee_data += '<td scope="col">'+sortByPoints[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

		}
		


};





function sortUsername()
{
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
	var employee_data;
	if(sortU == 0)
		{
		sortU = 1;
			 for(let i = 0; i <= sortAscNameList.length-1; i++)
				{
					console.log(sortAscNameList[i].name);
					  employee_data += '<tr scope="row">';
				      employee_data += '<td scope="col">'+sortByUsername[i].role +'</td>';
				      employee_data += '<td scope="col">'+sortByUsername[i].username+'</td>';
				      employee_data += '<td scope="col">'+sortByUsername[i].name +'</td>';	      
				      employee_data += '<td scope="col">'+sortByUsername[i].lastname +'</td>';
				      if(sortByUsername[i].gender == "FEMALE")
				    	  employee_data += '<td scope="col"> Female</td>';
				      
				      else
				    	  employee_data += '<td scope="col"> Male</td>';
				      
				      employee_data += '<td scope="col">'+ (new Date(sortByUsername[i].birthday)).toISOString().split('T')[0]+'</td>';
				      employee_data += '<td scope="col">'+sortByUsername[i].points +'</td>';
				      employee_data += '<td scope="col">'+sortByUsername[i].customerType.type +'</td>';
				      employee_data += '<tr>';
				   
					
				}
				 
			   $('#tbodyId').append(employee_data);

			}
	else
		{
		sortU = 0;
			for(let i = sortAscNameList.length-1; i >= 0 ; i--)
			{
				console.log(sortAscNameList[i].name);
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+sortByUsername[i].role +'</td>';
			      employee_data += '<td scope="col">'+sortByUsername[i].username+'</td>';
			      employee_data += '<td scope="col">'+sortByUsername[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+sortByUsername[i].lastname +'</td>';
			      if(sortByUsername[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(sortByUsername[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+sortByUsername[i].points +'</td>';
			      employee_data += '<td scope="col">'+sortByUsername[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

		}
		

};

function sortLastname()
{
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
	var employee_data;
	if(sortL == 0)
		{
		sortL = 1;
			 for(let i = 0; i <= sortByLastName.length-1; i++)
				{
					console.log(sortAscNameList[i].name);
					  employee_data += '<tr scope="row">';
				      employee_data += '<td scope="col">'+sortByLastName[i].role +'</td>';
				      employee_data += '<td scope="col">'+sortByLastName[i].username+'</td>';
				      employee_data += '<td scope="col">'+sortByLastName[i].name +'</td>';	      
				      employee_data += '<td scope="col">'+sortByLastName[i].lastname +'</td>';
				      if(sortByLastName[i].gender == "FEMALE")
				    	  employee_data += '<td scope="col"> Female</td>';
				      
				      else
				    	  employee_data += '<td scope="col"> Male</td>';
				      
				      employee_data += '<td scope="col">'+ (new Date(sortByLastName[i].birthday)).toISOString().split('T')[0]+'</td>';
				      employee_data += '<td scope="col">'+sortByLastName[i].points +'</td>';
				      employee_data += '<td scope="col">'+sortByLastName[i].customerType.type +'</td>';
				      employee_data += '<tr>';
				   
					
				}
				 
			   $('#tbodyId').append(employee_data);

			}
	else
		{
		sortL = 0;
			for(let i = sortByLastName.length-1; i >= 0 ; i--)
			{
				
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+sortByLastName[i].role +'</td>';
			      employee_data += '<td scope="col">'+sortByLastName[i].username+'</td>';
			      employee_data += '<td scope="col">'+sortByLastName[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+sortByLastName[i].lastname +'</td>';
			      if(sortByLastName[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(sortByLastName[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+sortByLastName[i].points +'</td>';
			      employee_data += '<td scope="col">'+sortByLastName[i].customerType.type +'</td>';
			      employee_data += '<tr>';			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

		}
		

};

/// Search 
function searchByName(n) {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("nameSearch"+ n );
	  filter = input.value.toUpperCase();
	  table = document.getElementById("allUsers");
	  tr = table.getElementsByTagName("tr");

	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[n];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }
	  }
	}

function typeSearch()
{
	}


