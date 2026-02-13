<%@ page import="model.Employee" %>
<%@ page session="true" %>
<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
    Employee e = (Employee) request.getAttribute("employee");
%>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="js/script.js"></script>
</head>
<body>

<div class="glass-card form-card">
    <h2>Edit Employee</h2>

    <form action="EditEmployeeServlet" method="post" onsubmit="return validateForm();">

        <input type="hidden" name="id" value="<%= e.getId() %>" />

        <div class="input-group">
            <input type="text" name="name" value="<%= e.getName() %>" required />
            <label>Name</label>
        </div>

        <div class="input-group">
            <input type="email" name="email" value="<%= e.getEmail() %>" required />
            <label>Email</label>
        </div>

        <div class="input-group">
            <input type="text" name="department" value="<%= e.getDepartment() %>" />
            <label>Department</label>
        </div>

        <div class="input-group">
            <input type="number" name="salary" value="<%= e.getSalary() %>" required step="0.01" />
            <label>Salary</label>
        </div>

        <button class="btn-glossy" type="submit">Update Employee</button>
        <a href="employeeList.jsp" class="btn-danger small">Cancel</a>
    </form>

</div>

</body>
</html>
