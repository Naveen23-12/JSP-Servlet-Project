<%@ page import="dao.EmployeeDAO,model.Employee" %>

<head>
    <title>Employee List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="js/script.js"></script>
</head>
<body>

<div class="glass-container">
    <div class="header">
        <h2>Employee Management</h2>
        <div>
            <a class="btn-glossy small" href="addEmployee.jsp">Add Employee</a>
            <a class="btn-danger small" href="LogoutServlet">Logout</a>
        </div>
    </div>

    <table class="modern-table">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Department</th><th>Salary</th><th>Actions</th>
        </tr>

        <%
            EmployeeDAO dao = new EmployeeDAO();
            for (Employee e : dao.getAllEmployees()) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getName() %></td>
            <td><%= e.getEmail() %></td>
            <td><%= e.getDepartment() %></td>
            <td>$<%= e.getSalary() %></td>
            <td>
                <a class="btn-glossy small" href="EditEmployeeServlet?id=<%= e.getId() %>">Edit</a>
                <a class="btn-danger small" href="DeleteEmployeeServelet?id=<%= e.getId() %>" onclick="return confirmDelete();">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</div>

</body>
