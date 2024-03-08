package controller;

import dao.PostDAO;
import model.Post;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de publicaciones.
 */
public class PostController implements CRUD<Post> {

    private final PostDAO postDAO = new PostDAO();

    @Override
    public List<Post> getAll() {
        return postDAO.getAll();
    }

    @Override
    public Post getById(Long id) {
        return postDAO.getById(id);
    }

    @Override
    public boolean create(Post post) {
        return postDAO.create(post);
    }

    @Override
    public boolean update(Post post) {
        return postDAO.update(post);
    }

    @Override
    public boolean delete(Long id) {
        return postDAO.delete(id);
    }
}
