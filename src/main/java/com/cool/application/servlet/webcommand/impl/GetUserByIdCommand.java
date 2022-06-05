package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.parameters.UserParameters;
import com.cool.application.servlet.webcommand.Command;
import com.cool.application.utils.Utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Dmitriy
 */

public class GetUserByIdCommand implements Command {

    private final UserService userService;

    public GetUserByIdCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        long id = Utils.parseLong(req.getParameter(UserParameters.ID));
        User user = userService.getUserById(id);
        req.setAttribute(GlobalAttributes.USER, user);
        return Pages.USER_DETAILS_PAGE;
    }

}
