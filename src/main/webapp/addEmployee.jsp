<%@ page session="true" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="js/script.js"></script>
</head>
<body>

<div class="glass-card form-card">
    <h2>Add Employee</h2>

    <form action="AddEmployeeServlet" method="post" onsubmit="return validateForm();">

        <div class="input-group">
            <input type="text" name="name" required />
            <label>Name</label>
        </div>

        <div class="input-group">
            <input type="email" name="email" required />
            <label>Email</label>
        </div>

        <div class="input-group">
            <input type="text" name="department" />
            <label>Department</label>
        </div>

        <div class="input-group">
            <input type="number" name="salary" required step="0.01" />
            <label>Salary</label>
        </div>

        <button class="btn-glossy" type="submit">Add Employee</button>
        <a href="employeeList.jsp" class="btn-danger small">Cancel</a>
    </form>

    <p class="error-message">
        ${errorMessage}
    </p>
</div>

</body>
</html>
