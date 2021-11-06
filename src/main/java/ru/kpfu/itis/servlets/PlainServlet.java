package ru.kpfu.itis.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class PlainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
       // response.setCharacterEncoding("UTF-8");
        //String query = request.getParameter("query");
        //if (query != null) {
          //  System.out.println(query);
       // }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("jsp/home.jsp");
        requestDispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String email = req.getParameter("email");
        String status = "";
        if (!password.equals(repassword)) {
            status = "Password does not match!!!";
        }
        req.setAttribute("validation", status);
        req.getRequestDispatcher("jsp/home.jsp").forward(req, resp);
    }
}
