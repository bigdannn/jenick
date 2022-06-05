package com.cool.application.servlet.webcommand.impl;

import com.cool.application.notifications.warnings.UserWarnings;
import com.cool.application.servlet.attributes.GlobalAttributes;
import com.cool.application.servlet.pages.Pages;
import com.cool.application.servlet.webcommand.Command;

import javax.servlet.http.HttpServletRequest;

/**
 * Author ****
 */

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest req) {
        req.setAttribute(GlobalAttributes.MESSAGE, UserWarnings.NOTHING_FOUND_PER_YOUR_REQUEST);
        return Pages.ERROR_PAGE;
    }

}
