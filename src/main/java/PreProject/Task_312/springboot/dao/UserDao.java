package PreProject.Task_312.springboot.dao;

import PreProject.Task_312.springboot.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    void updateUser(User updateUser);

    void removeById(Long id);

    List<User> getAllUsers();

    User getById(Long id);

}
