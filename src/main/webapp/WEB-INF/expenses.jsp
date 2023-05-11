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

<div class="d-flex justify-content-center">
    <table class="table table-dark text-center">
        <thead>
            <tr>
                <th scope="col">Expenses</th>
                <th scope="col">Vendor</th>
                <th scope="col">Amount</th>
                <th scope="col">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="expense" items="${allExpense}">
                <tr>
                    <td><a href="/expenses/${expense.id}"><c:out value="${expense.expensesName}" /></a></td>
                    <td><c:out value="${expense.vendor}" /></td>
                    <td><c:out value="${expense.amount}" /></td>
						<td class="d-flex align-items-center">
							<form class="delete-form" action="/delete/${expense.id}"
								method="post">
								<input type="hidden" name="_method" value="delete">
								<button class="btn btn-outline-danger" type="submit">Delete</button>
							</form> <a href="/expenses/edit/${expense.id}" class="ms-3">Edit</a>
						</td>
					</tr>
            </c:forEach>
        </tbody>
    </table>
</div>

	<form:form action="/process/expenses" method="post"
		modelAttribute="expense">
		<div
			class="container vh-100 d-flex justify-content-center align-items-center">
			<div class="row">
				<div class="col-md-3">
					<form:label path="expensesName">Expense Name:</form:label>
				</div>
				<div class="col-md-9">
					<div class="form-floating mb-3">
						<form:input type="text" class="form-control" path="expensesName"
							placeholder="Expense Name" />
						<form:label path="expensesName">Expense Name</form:label>
						<form:errors path="expensesName" class="text-danger" />
					</div>
				</div>
				<div class="col-md-3">
					<form:label path="vendor">Vendor:</form:label>
				</div>
				<div class="col-md-9">
					<div class="form-floating mb-3">
						<form:input type="text" path="vendor" class="form-control"
							placeholder="Vendor" />
						<form:label path="vendor">Vendor</form:label>
						<form:errors path="vendor" class="text-danger" />
					</div>
				</div>
				<div class="col-md-3">
					<form:label path="amount">Amount:</form:label>
				</div>
				<div class="col-md-9">
					<div class="form-floating mb-3">
						<form:input type="text" class="form-control" path="amount"
							placeholder="amount" />
						<form:label path="amount">$</form:label>
						<form:errors path="amount" class="text-danger" />
					</div>
				</div>
				<div class="col-md-3">
					<form:label path="description">Description:</form:label>
				</div>
				<div class="col-md-9">
					<div class="form-floating mb-3">
						<form:textarea class="form-control" path="description"
							placeholder="description"></form:textarea>
						<form:label path="description">Description</form:label>
						<form:errors path="vendor" class="text-danger" />
					</div>
				</div>
			<button type="submit" class="btn btn-dark btn-sm mx-auto">Submit</button>
			</div>
		</div>
	</form:form>

</body>
</html>