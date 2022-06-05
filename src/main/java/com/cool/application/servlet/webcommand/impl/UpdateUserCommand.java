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
 * Author Alexander
 */

public class UpdateUserCommand implements Command {

    private final UserService userService;

    public UpdateUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        AbstractUserBuilder builder = new HttpUserBuilder(req);
        User user = builder.buildUserWithAllFields();
        userService.updateUser(user);
        req.getSession().setAttribute(GlobalAttributes.MESSAGE, String.format(UserMessages.UPDATE_SUCCESS, user.getFamilyName()));
        return String.format("user?command=%s&id=%d", UserOperations.GET_USER_BY_ID.getName(), user.getId());
    }

}