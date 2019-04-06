package servlets;

import model.TaskService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "add", urlPatterns = "/add/")
public class AddTask extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/addTask.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int priority = Integer.parseInt(req.getParameter("priority"));
        String deadline = req.getParameter("deadline");

        TaskService taskService = new TaskService();
        if (taskService.addTask(name, description, priority, deadline)) {
            System.out.println("Задача успешно добавлена:");
            System.out.println("Название: " + name);
            System.out.println("Описание: " + description);
            System.out.println("Приоритет: " + priority);
            System.out.println("Дедлайн: " + deadline);
        }
        else {
            System.out.println("Ошибка при добавлении задачи!");
        }

        doGet(req, resp);
    }
}
