package com.cool.application.servlet.webcommand.impl;

import com.cool.application.entity.User;
import com.cool.application.service.UserService;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllUsersCommand implements Command {

    private final UserService userService;

    public GetAllUsersCommand(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req) {
        List<User> users = userService.findAllUsers();
        req.setAttribute(GlobalAttributes.USER_LIST, users);
        return Pages.SHOW_ALL_USERS;
    }

}