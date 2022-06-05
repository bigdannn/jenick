package com.cool.application.servlet.webcommand.impl;

import com.cool.application.builder.userbuilder.AbstractUserBuilder;
import com.cool.application.builder.userbuilder.HttpUserBuilder;
import com.cool.application.entity.User;
import com.cool.application.notifications.warnings.messages.UserMessages;
import com.cool.application.operations.UserOperations;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author Artem
 */

public class CreateUserCommand implements Command {

    private final UserService userService;

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }

    //TODO create user command fails when input fields remain empty. Find bug and fix it

    @Override
    public String execute(HttpServletRequest req) {
        AbstractUserBuilder builder = new HttpUserBuilder(req);
        User user = builder.buildUserWithAllFields();
        userService.createUser(user);
        req.setAttribute(GlobalAttributes.USER, user);
        req.getSession().setAttribute(GlobalAttributes.MESSAGE, String.format(UserMessages.CREATE_SUCCESS, user.getFamilyName()));
        return String.format("user?command=%s", UserOperations.GET_ALL_USERS.getName());

    }

}
