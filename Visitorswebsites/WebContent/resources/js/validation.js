/**
 * http://usejsdoc.org/
 */
function register(){
	
	var username= document.getElementById("username");
	var password= document.getElementById("password");
	var repassword= document.getElementById("repassword");
	var phone= document.getElementById("phone");
	var address= document.getElementById("address");
	if(regform.username.value==""){
		alert("Please Enter your UserName");
		username.focus();
		return false;
	}
	if(regform.password.value==""){
		alert("Please Enter the password");
		password.focus();
		return false;
	}
	if(regform.repassword.value==""){
		alert("Please Enter your Repassword");
		repassword.focus();
		return false;
	}
	if(regform.phone.value==""){
		alert("Please Enter the phone");
		phone.focus();
		return false;
	}
	if(regform.address.value==""){
		alert("Please Enter the  Address");
		address.focus();
		return false;
	}
	return true;
} 

function Login_Check(){
	var username= document.getElementById("username");
	var password= document.getElementById("password");
	if(regform.username.value==""){
		alert("Please Enter your UserName");
		username.focus();
		return false;
	}
	if(regform.password.value==""){
		alert("Please Enter your Password");
		password.focus();
		return false;
	}
	return true;
}
function Visitors_Check(){
	var name= document.getElementById("name");
	var dis= document.getElementById("dis");
	var telephone= document.getElementById("telephone");
	var idnumber= document.getElementById("idnumber");
	var gender= document.getElementById("gender");
	var address= document.getElementById("address");
	var emailAddress= document.getElementById("emailAddress");
	if(regform.name.value==""){
		alert("Please Enter your Name");
		name.focus();
		return false;
	}
	if(regform.dis.value==""){
		alert("Please Enter your  Discription");
		dis.focus();
		return false;
	}
	if(regform.telephone.value==""){
		alert("Please Enter your Phone");
		telephone.focus();
		return false;
	}
	if(regform.idnumber.value==""){
		alert("Please Enter your Idnumber");
		idnumber.focus();
		return false;
	}
	if(regform.gender.value==""){
		alert("Please Enter your Gender");
		gender.focus();
		return false;
	}
	if(regform.address.value==""){
		alert("Please Enter your Address");
		address.focus();
		return false;
	}
	if(regform.emailAddress.value==""){
		alert("Please Enter your EmailAddress");
		emailAddress.focus();
		return false;
	}
	return true;
}
function Edit_Check(){
	var id= document.getElementById("name");
	if(regform.name.value==""){
		alert("Please Enter your Name");
		id.focus();
		return false;
	}
	if(regform.id.value==""){
		alert("Please Enter Number to Edit");
		id.focus();
		return false;
	}
	return true;

}