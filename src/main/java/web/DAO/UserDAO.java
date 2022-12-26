package web.DAO;

import web.models.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(int id);

    void saveUser(User user);

    void update(int id, User updatedUser);

    void deleteUser(int id);
}
