//var loggedUser;

var orders;
$(document).ready(function(){
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
	// Popunjavanje tabele pursh
	$.ajax({
		async : false,
		url : "rest/order/getOrderByUsername",
		type : 'POST',
		dataType : 'json',
		contentType : "application/json",
		data : JSON.stringify({
			username: loggedUser.username
		}),
			
		success : function(data) {
			if (data) {
				orders = data;
				console.log(orders);

				var tableHeaderRowCount = 1;
				var table = document.getElementById('pursh');
				var rowCount = table.rows.length;
				for (var i = tableHeaderRowCount; i < rowCount; i++) {
				    table.deleteRow(tableHeaderRowCount);
				}
				
				
				var data;
				for(let i = 0; i <= orders.length-1; i++)
				{		
					if(orders[i].status != "DELIVER")
					{
					data += '<tr scope="row">';
				     data += '<td scope="col">'+orders[i].id +'</td>';
				     data += '<td scope="col" style="height:40px;">';
				     for(let j=0; j<= orders[i].articles.length-1; j++)
				     { 

				    	 console.log("YSAO Y FOR");
				    	 console.log(orders[i].articles[j]);
				    	 data += orders[i].articles[j].quantity +' '+ orders[i].articles[j].name + ' - ' + orders[i].articles[j].price +' RSD <br/>' ;
				     
				     }
				     data += ' </td>';
				     data += '<td scope="col">'+orders[i].restaurantName+' </td>';
				     data += '<td scope="col">'+orders[i].date+' </td>';
				     data += '<td scope="col">'+orders[i].price+' </td>';
				     data += '<td scope="col">'+orders[i].status+' </td>';
				     if(orders[i].status == "PROCESSING")
				    	 data += '<td scope="col"><button id="addOrd" style="width:100%;"  class="btn btn-warning" onclick="cancelOrder(orders['+i+'].id); return false;"> X </td>';
				     else
				    	 data += '<td scope="col"></td>';
				     data += '<tr>';
					}
					
				}
				 
			   $('#tableBodyPursh').append(data);
			}
		},
		error : function(errorThrown) {
			toastr.error(errorThrown.responseText);
		}
	});
});

function cancelOrder(id)
{
	console.log(id);
	$.ajax({
		async : false,
		type : "POST",
		url : "rest/order/cancelOrder",
		dataType : 'json',
		contentType : "application/json",
		data : JSON.stringify({
			id: id
		}),
			
		success : function(data) {
			console.log(data);
			alert("Successeffully canceled order. But you lose some of points!");
			location.reload(true);
				},
		error : function(message) {
			$('#error').text(message);
			$('#error').show().delay(3000).hide();
			}
		});
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
			if(data)
				console.log("STA");
			else
				{
				console.log(data.response);
				console.log("DAL UDJE TU UOPSTE?");
				window.location.replace("index.html");
				}
			
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

function creteNewOrder()
{
	window.location.replace("orderingPage.html");
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