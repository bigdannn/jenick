package com.cool.application.context.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.dao.impl.UserDaoImpl;
import com.cool.application.db.DbConnectionProvider;
import com.cool.application.db.Queries;
import com.cool.application.db.postgres.queries.user.PostgresUserQueries;
import com.cool.application.service.UserService;
import com.cool.application.service.impl.UserServiceImpl;
import com.cool.application.context.ApplicationContext;

public class PostgresApplicationContextImpl implements ApplicationContext {

    private final Queries postgresUserQueries;
    private final UserDao userDao;
    private final UserService userService;

    public PostgresApplicationContextImpl(DbConnectionProvider connectionProvider) {
        this.postgresUserQueries = new PostgresUserQueries();
        this.userDao = new UserDaoImpl(connectionProvider, postgresUserQueries);
        this.userService = new UserServiceImpl(userDao);
    }

    public UserService getUserService() {
        return userService;
    }

}
