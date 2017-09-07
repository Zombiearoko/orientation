<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="nav">
		<h1><center>le volet de navigation sera positionné ici</center></h1>
	</div>
	<div>
		<%
			List<String>  listOfPrincipalActuality =(List<String>) request.getAttribute("listOfPrincipalActuality");
			List<String>  listOfPublication =(List<String>) request.getAttribute("listOfPublication");
		%>
		<h1><center>ceci est le contenu de notre page il pourra 
		etre subdivisé en plusieurs articles</center></h1>
		
		<table>
			<tr>
				<th>les principales actualites</th>
				<th>publications</th>
			</tr>
			<%for(String actuality: listOfPrincipalActuality){
				for(String publication:listOfPublication){%>
					<tr>
						<td><%=actuality %> </td>
						<td><%=publication %> </td>
					</tr>
			<%}
				}%>
		</table>
		
	</div>
	<div>
		<h1><center>ceci est notre footer</center></h1>
	</div>
</body>
</html>