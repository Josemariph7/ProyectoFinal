package controller;

import dao.BookingDAO;
import model.Booking;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de reservas.
 */
public class BookingController implements CRUD<Booking> {

    private final BookingDAO bookingDAO = new BookingDAO();

    @Override
    public List<Booking> getAll() {
        return bookingDAO.getAll();
    }

    @Override
    public Booking getById(Long id) {
        return bookingDAO.getById(id);
    }

    @Override
    public boolean create(Booking booking) {
        return bookingDAO.create(booking);
    }

    @Override
    public boolean update(Booking booking) {
        return bookingDAO.update(booking);
    }

    @Override
    public boolean delete(Long id) {
        return bookingDAO.delete(id);
    }
}
