package dmuravsky.service;

import dmuravsky.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User getOne(int id);
    User getOne(String login);
}
