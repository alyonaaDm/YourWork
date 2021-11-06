package ru.kpfu.itis.listeners;

import ru.kpfu.itis.repositories.UsersRepository;
import ru.kpfu.itis.repositories.UsersRepositoryImpl;
import ru.kpfu.itis.services.UsersService;
import ru.kpfu.itis.services.UsersServicesImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@WebListener
//Обрабатывает события создания/удаления контекста сервлета
public class ComponentsListener implements ServletContextListener {

    private final String URL = "jdbc:postgresql://localhost:5432/YourWork";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "postgres";

    //Получает уведомление, что процесс инициализации веб-приложения запускается.

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            UsersRepository usersRepository = new UsersRepositoryImpl(connection);
            UsersService usersService = new UsersServicesImpl(usersRepository);
            servletContextEvent.getServletContext().setAttribute("usersService", usersService);

        } catch (SQLException | ClassNotFoundException e) {

        }
    }
    //Получает уведомление, что ServletContext собирается быть выключенным.

    //Все сервлеты и фильтры уничтожаются прежде, чем любые ServletContextListeners уведомляются относительно разрушения контекста.
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
