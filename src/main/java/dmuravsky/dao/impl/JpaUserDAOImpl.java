package dmuravsky.dao.impl;

import dmuravsky.dao.UserDAO;
import dmuravsky.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional(readOnly = true)
public class JpaUserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
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
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    @Override
    public User getOne(int id) {
        //TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id = :id", User.class);
        //query.setParameter("id", id);
        //User user = query.getResultList().stream().findAny().orElse(null);
        return entityManager.find(User.class, id);
    }

    @Override
    public User getOne(String login) {
        //TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login = :login", User.class);
        //query.setParameter("login", login);
        //return query.getResultList().stream().findAny().orElse(null);
        return entityManager.find(User.class, login);
    }
}
