<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="d-flex justify-content-center align-items-center">
		<h3>Expense Details</h3>
		<a href="/expenses">Go Back</a>
	
	</div>
	
	<div
		class="container d-flex justify-content-center align-items-center">
		<div class="row">
			<div class="col-md-3">
				<h4>Expense Name:</h4>
				<h6><c:out value="${expense.expensesName}" /></h6>
			</div>
			<div class="col-md-3">
				<h4>Expense Description:</h4>
				 <h6><c:out value="${expense.description}" /></h6>
			</div>
			<div class="col-md-3">
				<h3>Vendor:</h3>
				 <h6><c:out value="${expense.vendor}" /></h6>
			</div>
			<div class="col-md-3">
				<h4>Amount Spent:</h4>
				 <h6><c:out value="${expense.amount}" /></h6>
			</div>
		</div>
	</div>









</body>
</html>