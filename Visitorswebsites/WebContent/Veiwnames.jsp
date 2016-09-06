<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<script>
var request;
function sendInfo()
{
var v=document.vinform.id.value;
var url="VeiwnamesServlet?val="+v;

if(window.XMLHttpRequest){
request=new XMLHttpRequest();
}
else if(window.ActiveXObject){
request=new ActiveXObject("Microsoft.XMLHTTP");
}

try
{
request.onreadystatechange=getInfo;
request.open("GET",url,true);
request.send();
}
catch(e)
{
alert("Unable to connect to server");
}
}

function getInfo(){
if(request.readyState==4){
var val=request.responseText;
document.getElementById('amit').innerHTML=val;
}
}

</script>
<body>
<form   name="vinform" action="./VeiwnamesServlet">
SEARCH VISITOR BY ID:<input type="text" name="id" onkeyup="sendInfo()" size="29"><input type="submit" value="submit" onkeyup="sendInfo()">
</form>
<span id="amit"> </span>
</body>
</html>