package PreProject.Task_312.springboot.service;

import PreProject.Task_312.springboot.dao.UserDao;
import PreProject.Task_312.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }

    @Override
    public void updateUser(User updateUser) {
        userDao.updateUser(updateUser);

    }

    @Override
    public void removeById(Long id) {
        userDao.removeById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }
}
