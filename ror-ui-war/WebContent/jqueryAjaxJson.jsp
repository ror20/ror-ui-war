<html>  
<head>  
<meta content="text/html; charset=utf-8">  
<title>AJAX JSON by Javatpoint</title>  
<script type="application/javascript">  
function load()  
{  
   var url = "http://samplewebapp1.herokuapp.com/rest/json/get";//use any url that have json data  
   var request;  
  
   if(window.XMLHttpRequest){    
    request=new XMLHttpRequest();//for Chrome, mozilla etc  
   }    
   else if(window.ActiveXObject){    
    request=new ActiveXObject("Microsoft.XMLHTTP");//for IE only  
   }    
   request.onreadystatechange  = function(){  
      if (request.readyState == 4  )  
      {  
        var jsonObj = JSON.parse(request.responseText);//JSON.parse() returns JSON object  
        document.getElementById("appName").innerHTML =  jsonObj.appName;  
        document.getElementById("requestCreatedTime").innerHTML = jsonObj.requestCreatedTime;
        document.getElementById("language").innerHTML = jsonObj.language;
      }  
   }  
   request.open("GET", url, true);  
   request.send();  
}  
</script>  
</head>  
<body>  
  
AppName: <span id="appName"></span><br/>  
Language: <span id="language"></span><br/>  
Request Time: <span id="requestCreatedTime"></span><br/>
  
<button type="button" onclick="load()">Load Information</button>  
</body>  
</html>  
