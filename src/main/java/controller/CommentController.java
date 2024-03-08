package controller;

import dao.CommentDAO;
import model.Comment;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de comentarios.
 */
public class CommentController implements CRUD<Comment> {

    private final CommentDAO commentDAO = new CommentDAO();

    @Override
    public List<Comment> getAll() {
        return commentDAO.getAll();
    }

    @Override
    public Comment getById(Long id) {
        return commentDAO.getById(id);
    }

    @Override
    public boolean create(Comment comment) {
        return commentDAO.create(comment);
    }

    @Override
    public boolean update(Comment comment) {
        return commentDAO.update(comment);
    }

    @Override
    public boolean delete(Long id) {
        return commentDAO.delete(id);
    }
}
