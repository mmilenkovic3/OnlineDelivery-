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