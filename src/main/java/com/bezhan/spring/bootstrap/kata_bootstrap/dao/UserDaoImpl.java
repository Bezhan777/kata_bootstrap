package com.bezhan.spring.bootstrap.kata_bootstrap.dao;

import com.bezhan.spring.bootstrap.kata_bootstrap.entity.Role;
import com.bezhan.spring.bootstrap.kata_bootstrap.entity.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        em.merge(updatedUser);
    }

    @Override
    public void delete(long id) {
        em.createQuery("delete from User user where user.id = ?1")
                .setParameter(1, id)
                .executeUpdate();
    }

    @Override
    public User getUserByUsername(String username) {
        User user = null;
        try {
            TypedQuery<User> query = em.createQuery("from User user where user.email = ?1", User.class);
            user = query.setParameter(1, username)
                    .getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            System.out.printf("User '%s' not found%n", username);
        } finally {
            em.close();
        }
        return user;

    }

    @Override
    public void addRoleToUser(User user, Role role) {

        em.createQuery("insert into User user = ?1 (roles) select role from Role role where role = ?2")
                .setParameter(1, user)
                .setParameter(2, role)
                .executeUpdate();
    }
}