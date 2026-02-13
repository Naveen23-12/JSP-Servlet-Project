package servlet;

import dao.EmployeeDAO;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteEmployeeServelet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmployeeDAO dao = new EmployeeDAO();
        dao.deleteEmployee(id);
        response.sendRedirect("employeeList.jsp");
    }
}
