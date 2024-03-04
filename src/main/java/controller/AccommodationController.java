package controller;

import dao.AccommodationDAO;
import model.Accommodation;

import java.util.List;

/**
 * Controlador para gestionar las operaciones CRUD de alojamientos.
 */
public class AccommodationController implements CRUD<Accommodation> {

    private AccommodationDAO accommodationDAO = new AccommodationDAO();

    @Override
    public List<Accommodation> getAll() {
        return accommodationDAO.getAll();
    }

    @Override
    public Accommodation getById(Long id) {
        return accommodationDAO.getById(id);
    }

    @Override
    public boolean create(Accommodation accomodation) {
        return accommodationDAO.create(accomodation);
    }

    @Override
    public boolean update(Accommodation accomodation) {
        return accommodationDAO.update(accomodation);
    }

    @Override
    public boolean delete(Long id) {
        return accommodationDAO.delete(id);
    }
}
