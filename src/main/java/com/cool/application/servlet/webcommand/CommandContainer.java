package com.cool.application.servlet.webcommand;

import com.cool.application.context.ApplicationContext;
import com.cool.application.operations.UserOperations;
import com.cool.application.servlet.webcommand.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {

    private Map<String, Command> commands;
    private final ApplicationContext applicationContext;

    public CommandContainer(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        populateCommands();
    }

    public Command getCommand(String command) {
        return commands.getOrDefault(command, new DefaultCommand());
    }

    private void populateCommands() {
        commands = new HashMap<>();
        commands.put(UserOperations.UPDATE_USER.getName(), new UpdateUserCommand(applicationContext.getUserService()));
        commands.put(UserOperations.GET_USER_BY_ID.getName(), new GetUserByIdCommand(applicationContext.getUserService()));
        commands.put(UserOperations.CREATE_USER.getName(), new CreateUserCommand(applicationContext.getUserService()));
        commands.put(UserOperations.GET_ALL_USERS.getName(), new GetAllUsersCommand((applicationContext.getUserService())));
        commands.put(UserOperations.GET_USER_BY_FAMILY_NAME.getName(), new GetUserByFamilyNameCommand((applicationContext.getUserService())));
        commands.put(UserOperations.DELETE_USER.getName(), new DeleteUserCommand(applicationContext.getUserService()));
    }

}
