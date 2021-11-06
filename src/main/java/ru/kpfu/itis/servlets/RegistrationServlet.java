package ru.kpfu.itis.servlets;

import ru.kpfu.itis.form.UserForm;
import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServicesImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/signUp")
public class RegistrationServlet extends HttpServlet {

    private UsersService usersService;
    private UsersRepository usersRepository;

    @Override
    public void init(ServletConfig config) throws ServletException{
        ServletContext servletContext = config.getServletContext();
        usersService = (UsersService) servletContext.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        UserForm userForm = new UserForm();
        userForm.setLogin(req.getParameter("login"));
        userForm.setPassword(req.getParameter("password"));
        userForm.setFirstName(req.getParameter("firstName"));
        userForm.setLastName(req.getParameter("lastName"));

        usersService.register(userForm);

        resp.sendRedirect("/signIn");
    }
}

