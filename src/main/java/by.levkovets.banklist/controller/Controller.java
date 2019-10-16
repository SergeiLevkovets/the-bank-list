package by.levkovets.banklist.controller;

import by.levkovets.banklist.service.Service;
import by.levkovets.banklist.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/control.html")
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new ServiceImpl();
        if (req.getParameter("rich") != null) {
            String rich = service.getRichestUser();
            req.setAttribute("rich", rich);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        if (req.getParameter("sum") != null) {
            String sum = service.getSumAllAccounts();
            req.setAttribute("sum", sum);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

}
