package servlets;

import database.tables.Users;
import model.Authentication;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "auth", urlPatterns = "/")
public class Auth extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/auth.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Authentication auth = new Authentication();
        if (req.getParameter("email") != null) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (auth.authUser(email, password)) {
                HttpSession session = req.getSession();
                session.setMaxInactiveInterval(86400);  // 1 день
                User user = Users.getUserByEmail(email);

                assert user != null;
                session.setAttribute("auth", true);
                session.setAttribute("email", user.getEmail());

                System.out.println("Пользователь успешно авторизован!");
                System.out.println("user status: " + session.getAttribute("auth"));
                System.out.println("user email: " + session.getAttribute("email"));
            }
            else {
                req.setAttribute("error", "Вы ввели неверный логин и/или пароль!");
            }
        }
        else {
            String email = req.getParameter("reg_email");
            String password = req.getParameter("reg_password");
            String confirm_password = req.getParameter("reg_confirm_password");

            if (password.equals(confirm_password))
                if (auth.regUser(email, password))
                    System.out.println("Пользователь успешно зарегистрирован!");
                else
                    System.out.println("Ошибка при регистрации!");
        }

        doGet(req, resp);
    }
}
