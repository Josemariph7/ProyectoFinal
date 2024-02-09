package controller;

import dao.ReviewDAO;
import model.Review;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de comentarios.
 */
public class ReviewController implements CRUD<Review> {

    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    public List<Review> getAll() {
        return reviewDAO.getAll();
    }

    @Override
    public Review getById(Long id) {
        return reviewDAO.getById(id);
    }

    @Override
    public boolean create(Review review) {
        return reviewDAO.create(review);
    }

    @Override
    public boolean update(Review review) {
        return reviewDAO.update(review);
    }

    @Override
    public boolean delete(Long id) {
        return reviewDAO.delete(id);
    }
}
