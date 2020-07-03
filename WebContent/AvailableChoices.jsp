<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Available Services</title>
</head>
<script>
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
	<p>Hello:${uid} ${phrase}</p>
<form action="" method="POST">
	<br>
		<br> <label for="cars">Choose a car:</label> <select
			name="services" id="services">
			<option value="0">--Please choose an option--</option>
			<option value="1">Celcius to ferenheit converter</option>
			<option value="2">Ferenheit to Celcius converter</option>
			<option value="3">Calculate a Date Value</option>
		</select> 
		<br>
		<br> <input type="number" id="numberEntered" name="numberEntered"
			size="10px" value="98.5"></input>Enter a from number please.<br>
		<input type="text" id="textInput" name="textInput" size="10px"
			value="98.5"></input>Enter value in mm/dd/yyyy format.<br>
	<input type="submit" value="submit">
	</form>
</body>
</html>