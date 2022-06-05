package com.cool.application.controller;

import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.GlobalParams;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.servlet.webcommand.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author Alexander
 */

@WebServlet("/user")
public class UserController extends HttpServlet {

    private CommandContainer commandContainer;
    private Command command;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        commandContainer = (CommandContainer) req.getServletContext().getAttribute(GlobalAttributes.COMMAND_CONTAINER);
        String address = Pages.ERROR_PAGE;
        try {
            command = commandContainer.getCommand(req.getParameter(GlobalParams.COMMAND));
            address = command.execute(req);
        } catch (RuntimeException e) {
            req.getSession().setAttribute(GlobalAttributes.MESSAGE, e.getMessage());
        }
        req.getRequestDispatcher(address).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        commandContainer = (CommandContainer) req.getServletContext().getAttribute(GlobalAttributes.COMMAND_CONTAINER);
        String address = Pages.ERROR_PAGE;
        try {
            command = commandContainer.getCommand(req.getParameter(GlobalParams.COMMAND));
            address = command.execute(req);
        } catch (RuntimeException e) {
            req.getSession().setAttribute(GlobalAttributes.MESSAGE, e.getMessage());
        }
        resp.sendRedirect(address);
    }

}
