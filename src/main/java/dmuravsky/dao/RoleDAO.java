package dmuravsky.dao;

import dmuravsky.model.Role;
import dmuravsky.model.User;

import java.util.List;

public interface RoleDAO {
    void addRole(Role role);
    void editRole(Role role);
    void deleteRole(Role role);
    Role getRoleByName(String name);
    List<Role> getAllRoles();
}
