<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<head>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<!-- <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.0/css/jquery.dataTables_themeroller.css">
 --> <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<!-- link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );

function DeleteConfirm(){
	var txt;
	var r = confirm("Are you sure you want to delete?");
	if (r == true) {
	    txt = "You pressed OK!";
	} else {
	    txt = "You pressed Cancel!";
	    event.preventDefault();
	}
}
</script>
</head>

<body>	
	<h1>PhoneBook App</h1>
	
<a href="registerContact">Add Contact</a>
	<table border="1" id="example" class="table">
		<thead>
         <tr>
          <th>Contact Name</th>
          <th>Contact Email</th>
          <th>Contact Number</th>
          <th>Action(s)</th>
         </tr>
         </thead>
         <tbody>
         <c:forEach items="${list}" var="c">
         <tr>
         <td>${c.contactName}</td>
         <td> ${c.contactEmail}</td>
         <td> ${c.contactNumber}</td>
         <td><a href="updateContact?cid=${c.contactId}">Edit</a>
            <a href="deleteContact?ccid=${c.contactId}" onclick="DeleteConfirm();">Delete</a> 
		</td>
         </tr>
         </c:forEach>
         </tbody>
  	</table>
  	<a href="registerContact">Home Page</a>
</body>

</html>
