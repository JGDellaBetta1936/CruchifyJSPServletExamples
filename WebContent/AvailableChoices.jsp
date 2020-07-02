<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Available Services</title>
</head>
<script >
function EnableCtoF() {
	
	var x = document.getElementById("hiddenNumber");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	} 
</script>
<body>
<p>
Hello:${uid} 
	  ${phrase} </p>

<br>
<form method="post">
<br>
 <label for="cars">Choose a car:</label>
<select name="services" id="services">
  <option value="0">--Please choose an option--</option>
  <option value="1">Celcius to ferenheit converter</option>
  <option value="2">Ferenheit to Celcius converter</option>
  <option value="3">Calculate a Date Value</option>
</select> 
<br><br>
<input type="hidden" name="AvailableChoices" value="AvailableChoices" onclick="EnableTtoF();">
</form>
<div id="hiddenNumber" class="hiddenNumber" hidden="true">
<p>
<input type="number" id="numberEntered" name="numberEntered" size="10px" value="98.5">Enter a number please.<br>
</p>
</div>

</body>
</html>