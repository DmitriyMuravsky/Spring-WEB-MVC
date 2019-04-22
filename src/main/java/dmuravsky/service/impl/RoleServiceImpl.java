package dmuravsky.service.impl;

import dmuravsky.dao.RoleDAO;
import dmuravsky.model.Role;
import dmuravsky.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    public RoleDAO roleDAO;

    @Override
    public void addRole(Role role) {
        roleDAO.addRole(role);
    }

    @Override
    public void editRole(Role role) {
        roleDAO.editRole(role);
    }

    @Override
    public void deleteRole(Role role) {
        roleDAO.deleteRole(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
