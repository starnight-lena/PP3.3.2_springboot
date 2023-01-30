package PreProject.Task_312.springboot.service;

import PreProject.Task_312.springboot.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void update(User updateUser);

    void removeById(Long id);
    List<User> listUsers();
    User getById(Long id);

}
