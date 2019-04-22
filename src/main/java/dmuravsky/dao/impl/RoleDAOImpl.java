package dmuravsky.dao.impl;

import dmuravsky.dao.RoleDAO;
import dmuravsky.model.Role;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addRole(Role role) {
        entityManager.persist(role);
    }
    @Override
    @Transactional
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(Role role) {
        Query query = entityManager.createNativeQuery("DELETE FROM roles WHERE id=?");
        query.setParameter(1, role.getId());
        query.executeUpdate();
    }

    @Override
    public Role getRoleByName(String name) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r from Role r WHERE r.name = :name", Role.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("SELECT r FROM Roles r", Role.class).getResultList();
    }
}
