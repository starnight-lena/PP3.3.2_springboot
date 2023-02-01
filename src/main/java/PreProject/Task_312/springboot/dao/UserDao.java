package PreProject.Task_312.springboot.dao;

import PreProject.Task_312.springboot.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);

    void updateUser(User updateUser);

    void deleteUser(Long id);

    List<User> getAllUsers();

    User getOneUser(Long id);

}
