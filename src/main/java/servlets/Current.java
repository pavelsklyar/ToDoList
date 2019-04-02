package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "current", urlPatterns = "/current/")
public class Current extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        System.out.println(session.getAttribute("auth"));

        if (session.getAttribute("auth") != null) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/current.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
            resp.sendRedirect("/");
        }
    }
}
