package com.cool.application.service.impl;

import com.cool.application.dao.UserDao;
import com.cool.application.entity.User;
import com.cool.application.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> findAllUsers() {return userDao.findAllUsers();}

  @Override
  public void deleteUser(long id) {
    userDao.deleteUser(id);
  }

  @Override
  public User getUserById(long id) {
    return userDao.getUserById(id);
  }

  @Override
  public List<User> getUserByFamilyName(String name) {
    return userDao.getUserByFamilyName(name);
  }

  @Override
  public void updateUser(User user) {
    userDao.updateUser(user);
  }

  @Override
  public void createUser(User user) {
    userDao.createUser(user);
  }

}
