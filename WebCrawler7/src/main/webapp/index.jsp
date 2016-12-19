<html>
<head>
	<title>Home page</title>
</head>
<body bgcolor="AA8888">
	<h1>Welcome to WebCrowler</h1>
	
	<form action="rest/crawler/default" method="post" >
		<br>Enter the URL: <input type="text" name="url">
		<br>Select the output type: 
			<select name="requiredtype">
				<option value="text">Text</option>
				<option value="xml">XML</option>
				<option value="json">JSON</option>
			</select>
		<br><input type="submit" value="submit"> 
	</form>
</body>
</html>