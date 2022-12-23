package PreProject.Task_312.springboot.dao;

import PreProject.Task_312.springboot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

}
