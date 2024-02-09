package controller;

import dao.ForumDAO;
import model.Forum;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de foros.
 */
public class ForumController implements CRUD<Forum> {

    private ForumDAO forumDAO = new ForumDAO();

    @Override
    public List<Forum> getAll() {
        return forumDAO.getAll();
    }

    @Override
    public Forum getById(Long id) {
        return forumDAO.getById(id);
    }

    @Override
    public boolean create(Forum forum) {
        return forumDAO.create(forum);
    }

    @Override
    public boolean update(Forum forum) {
        return forumDAO.update(forum);
    }

    @Override
    public boolean delete(Long id) {
        return forumDAO.delete(id);
    }
}
