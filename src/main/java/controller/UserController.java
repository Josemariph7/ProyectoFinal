package controller;

import dao.UserDAO;
import model.User;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de usuarios.
 */
public class UserController implements CRUD<User> {

    private final UserDAO userDAO = new UserDAO();

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public boolean create(User user) {
        return userDAO.create(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return userDAO.delete(id);
    }
}
