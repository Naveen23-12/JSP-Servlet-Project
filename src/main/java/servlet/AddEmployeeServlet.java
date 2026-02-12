package servlet;

import dao.EmployeeDAO;
import model.Employee;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee e = new Employee();
        e.setName(name);
        e.setEmail(email);
        e.setDepartment(department);
        e.setSalary(salary);

        EmployeeDAO dao = new EmployeeDAO();
        if (dao.addEmployee(e)) {
            response.sendRedirect("employeeList.jsp");
        } else {
            request.setAttribute("errorMessage", "Error adding employee");
            RequestDispatcher rd = request.getRequestDispatcher("addEmployee.jsp");
            rd.forward(request, response);
        }
    }
}
