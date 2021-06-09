var loggedUser;
$(document).ready(function(){
	  $.getJSON("http://localhost:8080/PocetniREST/rest/users/getAllUsers", function(data){
	    var employee_data = '';
	    $.each(data, function(key, value){
	    	console.log(value.gender);
	      employee_data += '<tr>';
	      employee_data += '<td>'+value.role+'</td>';
	      employee_data += '<td>'+value.username+'</td>';
	      employee_data += '<td>'+value.name+ ' ' + value.lastname +'</td>';	      
	      
	      if(value.gender == "FEMALE")
	    	  employee_data += '<td> Female</td>';
	      
	      else
	    	  employee_data += '<td> Male</td>';
	      employee_data += '<td>'+ (new Date(value.birthday)).toISOString().split('T')[0]+'</td>';

		
	      employee_data += '<tr>';
	    });
	    $('#allUsers').append(employee_data);
	  });
	  document.getElementById("save").disabled = true;
	document.getElementById("cancel").disabled = true;
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
			toastr.error(errorThrown.responseText);
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

				},
		error : function(message) {
			alert("Error!");
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
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