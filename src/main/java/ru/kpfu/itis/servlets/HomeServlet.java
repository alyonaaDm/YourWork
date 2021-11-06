package ru.kpfu.itis.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        //String query = request.getParameter("query");
        //if (query != null) {
        //  System.out.println(query);
        // }

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("HTML/mainPage.jsp");
//        requestDispatcher.forward(req, resp);
//        resp.sendRedirect("/WEB-INF/HTML/mainPage.jsp");
        req.getRequestDispatcher(("/WEB-INF/HTML/mainPage.jsp")).forward(req, resp);
    }
}
