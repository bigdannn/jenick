package com.cool.application.context;

import com.cool.application.context.impl.PostgresApplicationContextImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.postgres.PostgresDbConnectionProviderImpl;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.webcommand.CommandContainer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        DbConnectionProvider dbConnectionProvider = new PostgresDbConnectionProviderImpl();
        Connection con = dbConnectionProvider.getConnection();

        ApplicationContext applicationContext = new PostgresApplicationContextImpl(dbConnectionProvider);
        CommandContainer commandContainer = new CommandContainer(applicationContext);
        ctx.setAttribute(GlobalAttributes.DB_CONNECTION, con);
        ctx.setAttribute(GlobalAttributes.COMMAND_CONTAINER, commandContainer);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        Connection con = (Connection) ctx.getAttribute(GlobalAttributes.DB_CONNECTION);
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}