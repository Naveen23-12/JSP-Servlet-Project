package servlet;

import dao.EmployeeDAO;
import model.Employee;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class EditEmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDAO dao = new EmployeeDAO();
        Employee e = dao.getEmployeeById(id);
        request.setAttribute("employee", e);
        RequestDispatcher rd = request.getRequestDispatcher("editEmployee.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        double salary = Double.parseDouble(request.getParameter("salary"));

        Employee e = new Employee(id, name, email, department, salary);
        EmployeeDAO dao = new EmployeeDAO();
        dao.updateEmployee(e);
        response.sendRedirect("employeeList.jsp");
    }
}
