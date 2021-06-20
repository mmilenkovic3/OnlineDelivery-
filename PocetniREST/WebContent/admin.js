var loggedUser;
var sort = 0;
var sortAscNameList;

$(document).ready(function(){
	
	$.ajax({
		type : "GET",
		url : "rest/users/sortAscName",		
		contentType : "application/json",
		dataType : 'json',
		success : function(data) {
			sortAscNameList = data;	
			console.log(sortAscNameList);
			

				},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
	
	
	sort = 1;
	  $.getJSON("http://localhost:8080/PocetniREST/rest/users/getAllUsers", function(data){
	    var employee_data = '';
	    $.each(data, function(key, value){
	      employee_data += '<tr scope="row">';
	      employee_data += '<td scope="col">'+value.role+'</td>';
	      employee_data += '<td scope="col">'+value.username+'</td>';
	      employee_data += '<td scope="col">'+value.name +'</td>';	      
	      employee_data += '<td scope="col">'+value.lastname +'</td>';
	      if(value.gender == "FEMALE")
	    	  employee_data += '<td scope="col"> Female</td>';
	      
	      else
	    	  employee_data += '<td scope="col"> Male</td>';
	      
	      employee_data += '<td scope="col">'+ (new Date(value.birthday)).toISOString().split('T')[0]+'</td>';
	      employee_data += '<td scope="col">'+value.points +'</td>';
	      employee_data += '<td scope="col">'+value.customerType.type +'</td>';
	      employee_data += '<tr>';
	    });
	    $('#tbodyId').append(employee_data);
	  });
	  document.getElementById("save").disabled = true;
	document.getElementById("cancel").disabled = true;
	loggedUser = getLoggedUser();
	
	var name = document.getElementById("name");
	var lastname = document.getElementById("lastname");	
	var birthday = document.getElementById("birthday");
	var username = document.getElementById("username");
	
	name.value = loggedUser.name;
	name.disabled = true; 
	 
	lastname.value = loggedUser.lastname;
	lastname.disabled = true;
	
	birthday.value = loggedUser.birthday;
	birthday.disabled = true;

	var dateControl = document.querySelector('input[type="date"]');
	dateControl.value = (new Date(loggedUser.birthday)).toISOString().split('T')[0];
	
	

	if(loggedUser.gender == "FEMALE")
	{ 		
		document.getElementById("female").checked = true;
	}
	else
		document.getElementById("male").checked = true;
		
	
		document.getElementById("female").disabled = true;
		document.getElementById("male").disabled = true;


	username.value = loggedUser.username;
	username.disabled = true;



	});

function regManagerAndDeliverer()
{
	$(location).attr('href', 'http://localhost:8080/PocetniREST/registrationManagerAndDeliverer.html');
}
function getLoggedUser() {

	var user = null;

	$.ajax({
		async : false,
		url : "rest/users/getLoggedUser",
		type : 'GET',
		dataType : 'json',
		success : function(data) {
			if (data) {
				user = data;
			}
		},
		error : function(errorThrown) {
			console.log(errorThrown.responseText);
		}
	});
	return user;
}

function logOut() {
	console.log("Pozvan logout js");
	//var loggedUser = getLoggedUser();
	$.ajax({
		async : false,
		type : 'GET',
		url : "rest/users/logout",
		dataType : 'json',
		/*data: {
			user : getLoggedUser()
		},*/
		success : function(data) {
			
				console.log(data.response);
				console.log("DAL UDJE TU UOPSTE?");
				window.location.replace("index.html");
						
		},
		error : function(message) {
			console.log("err");
			$('#error').text(message);
			window.location.replace("index.html");
			$('#error').show().delay(3000).hide();
		}
	})
}

function edit()
{
	document.getElementById("save").disabled = false;
	document.getElementById("cancel").disabled = false;
	document.getElementById("edit").disabled = true;
	document.getElementById("name").disabled = false;
	document.getElementById("lastname").disabled = false;	
	document.getElementById("birthday").disabled = false;
	document.getElementById("username").disabled = false;
	document.getElementById("female").disabled = false;
	document.getElementById("male").disabled = false;
		
	
}

function save()
{
	var name = document.getElementById("name").value;
	var lastname = document.getElementById("lastname").value;	
	var birthday = JSON.stringify(new Date(document.getElementById("birthday").value));

	var username = document.getElementById("username").value;
	var gender = $("input:radio[name=radiobtn]:checked").val();
	if(gender == "Male")
		gender = "MALE";
		else
		gender = "FEMALE";

	$.ajax({
		type : "POST",
		url : "rest/users/editUser",
		data : JSON.stringify({
		username : username,
		name : name,
		lastname : lastname,
		gender : gender,
		birthday : birthday		
	}),
		contentType : "application/json",
		dataType : 'json',
		success : function(data) {	
			console.log("USPESNO?");			
			alert("Successeffully edited!");

			document.getElementById("save").disabled = true;
			document.getElementById("cancel").disabled = true;
			document.getElementById("edit").disabled = false;
			
			document.getElementById("name").disabled = true;
			document.getElementById("lastname").disabled = true;	
			document.getElementById("birthday").disabled = true;
			document.getElementById("username").disabled = true;
			document.getElementById("female").disabled = true;
			document.getElementById("male").disabled = true;
			location.reload(); 
				},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
}


function sortName()
{
	
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
	
	var employee_data;

	if(sort == 1)
		{
		 sort = 0;
		 for(let i = 0; i <= sortAscNameList.length-1; i++)
			{
				console.log(sortAscNameList[i].name);
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+sortAscNameList[i].role +'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].username+'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+sortAscNameList[i].lastname +'</td>';
			      if(sortAscNameList[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(sortAscNameList[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].points +'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

		}
	else
		{
			sort = 1;
			for(let i = sortAscNameList.length-1; i >= 0 ; i--)
			{
				console.log(sortAscNameList[i].name);
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+sortAscNameList[i].role +'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].username+'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+sortAscNameList[i].lastname +'</td>';
			      if(sortAscNameList[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(sortAscNameList[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].points +'</td>';
			      employee_data += '<td scope="col">'+sortAscNameList[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

			
			
			
		}
		
	
	
	
	

}

function cancel()
{
	document.getElementById("save").disabled = true;
	document.getElementById("cancel").disabled = true;
	document.getElementById("edit").disabled = false;	

	loggedUser = getLoggedUser();
	console.log("Ucitavanje stranice");
	
	var name = document.getElementById("name");
	var lastname = document.getElementById("lastname");	
	var birthday = document.getElementById("birthday");
	var username = document.getElementById("username");
	
	
	//var gender = document.getElementById("name");
	//$("input:radio[name=radiobtn]:checked").val() = loggedUser.gender;
	//console.log("gender: " + gender)

	name.value = loggedUser.name;
	name.disabled = true; 
	 
	lastname.value = loggedUser.lastname;
	lastname.disabled = true;
	
	birthday.value = loggedUser.birthday;
	birthday.disabled = true;

	var dateControl = document.querySelector('input[type="date"]');
	dateControl.value = (new Date(loggedUser.birthday)).toISOString().split('T')[0];
	
	console.log(loggedUser.gender);

	if(loggedUser.gender == "FEMALE")
	{ 
		console.log("Zena");
		document.getElementById("female").checked = true;
	}
	else
		document.getElementById("male").checked = true;
		
	
		document.getElementById("female").disabled = true;
		document.getElementById("male").disabled = true;



	username.value = loggedUser.username;
	username.disabled = true;


}

function regNewRest()
{
	$(location).attr('href', 'http://localhost:8080/PocetniREST/registerRestaurant.html');
}

function roleSearch(){
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}

	var role = document.getElementById('byRole').value;
	console.log(role);

	var employList; 

	$.ajax({
		async : false,
		type : 'POST',
		url : "rest/users/fillterByRole",
		dataType : 'json',
		data: JSON.stringify({
			role : role
		}),
		contentType : "application/json",
		success : function(data) {
				console.log("PODACI?");
				employList = data;
		},
		error : function(message) {
			console.log("err");		
		}
	})

	

	
	var employee_data;
	
		 for(let i = 0; i <= employList.length-1; i++)
			{
				console.log(employList[i].name);
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+employList[i].role +'</td>';
			      employee_data += '<td scope="col">'+employList[i].username+'</td>';
			      employee_data += '<td scope="col">'+employList[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+employList[i].lastname +'</td>';
			      if(employList[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(employList[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+employList[i].points +'</td>';
			      employee_data += '<td scope="col">'+employList[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);

}

function cleanFillter()
{
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}

	$.getJSON("http://localhost:8080/PocetniREST/rest/users/getAllUsers", function(data){
	    var employee_data = '';
	    $.each(data, function(key, value){
	      employee_data += '<tr scope="row">';
	      employee_data += '<td scope="col">'+value.role+'</td>';
	      employee_data += '<td scope="col">'+value.username+'</td>';
	      employee_data += '<td scope="col">'+value.name +'</td>';	      
	      employee_data += '<td scope="col">'+value.lastname +'</td>';
	      if(value.gender == "FEMALE")
	    	  employee_data += '<td scope="col"> Female</td>';
	      
	      else
	    	  employee_data += '<td scope="col"> Male</td>';
	      
	      employee_data += '<td scope="col">'+ (new Date(value.birthday)).toISOString().split('T')[0]+'</td>';
	      employee_data += '<td scope="col">'+value.points +'</td>';
	      employee_data += '<td scope="col">'+value.customerType.type +'</td>';
	      employee_data += '<tr>';
	    });
	    $('#tbodyId').append(employee_data);
	  });

	  document.getElementById('nameSearch2').value="";
	  document.getElementById('nameSearch1').value="";
	  document.getElementById('nameSearch3').value="";
}


function userTypeSearch()
{
	userType = document.getElementById('byUserType').value;
	console.log(userType);
	var tableHeaderRowCount = 1;
	var table = document.getElementById('allUsers');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}


	var employList; 

	$.ajax({
		async : false,
		type : 'POST',
		url : "rest/users/fillterByUserType",
		dataType : 'json',
		data: JSON.stringify({
			type : userType
		}),
		contentType : "application/json",
		success : function(data) {
				console.log("PODACI?");
				employList = data;
		},
		error : function(message) {
			console.log("err");		
		}
	})

	

	
	var employee_data;
	
		 for(let i = 0; i <= employList.length-1; i++)
			{
				console.log(employList[i].name);
				  employee_data += '<tr scope="row">';
			      employee_data += '<td scope="col">'+employList[i].role +'</td>';
			      employee_data += '<td scope="col">'+employList[i].username+'</td>';
			      employee_data += '<td scope="col">'+employList[i].name +'</td>';	      
			      employee_data += '<td scope="col">'+employList[i].lastname +'</td>';
			      if(employList[i].gender == "FEMALE")
			    	  employee_data += '<td scope="col"> Female</td>';
			      
			      else
			    	  employee_data += '<td scope="col"> Male</td>';
			      
			      employee_data += '<td scope="col">'+ (new Date(employList[i].birthday)).toISOString().split('T')[0]+'</td>';
			      employee_data += '<td scope="col">'+employList[i].points +'</td>';
			      employee_data += '<td scope="col">'+employList[i].customerType.type +'</td>';
			      employee_data += '<tr>';
			   
				
			}
			 
		   $('#tbodyId').append(employee_data);



}