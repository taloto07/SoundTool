template(title, var, body, contextPath, url) ::= "
<html>
	<head>
		<title>$title$</title>
		<link href=\"$contextPath$css/base.css\" rel=\"stylesheet\">
	</head>
	<body>
		this is $var$.<br>
		new line with body: $body$
		<br/>ContextPath: $contextPath$
		<br/>URL: $url$
	</body>
</html>";