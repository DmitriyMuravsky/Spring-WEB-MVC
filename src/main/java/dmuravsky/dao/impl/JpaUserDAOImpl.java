package dmuravsky.dao.impl;

import dmuravsky.dao.UserDAO;
import dmuravsky.model.User;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class JpaUserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        Query query = entityManager.createNativeQuery("DELETE FROM user WHERE id=?");
        query.setParameter(1, user.getId());
        query.executeUpdate();
    }

    @Override
    public User getOneUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getOneUserByLogin(String login) {
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
}
