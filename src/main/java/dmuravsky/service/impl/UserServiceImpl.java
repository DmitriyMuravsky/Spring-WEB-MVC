package dmuravsky.service.impl;

import dmuravsky.dao.UserDAO;
import dmuravsky.model.User;
import dmuravsky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public User getOne(int id) {
        return userDAO.getOne(id);
    }

    @Override
    public User getOne(String login) {
        return userDAO.getOne(login);
    }
}
