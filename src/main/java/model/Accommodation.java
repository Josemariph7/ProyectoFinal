package model;

import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un alojamiento en la aplicación.
 */
public class Accommodation {
    private Long accommodationId; // Identificador único del alojamiento
    private User owner; // Referencia al propietario del alojamiento
    private String address; // Dirección del alojamiento
    private Double price; // Precio del alojamiento
    private String description; // Descripción del alojamiento
    private List<Booking> bookings; // Lista de reservas para este alojamiento
    private List<Review> reviews; // Lista de reseñas para este alojamiento

    // Constructor completo
    public Accommodation(Long accommodationId, User owner, String address, Double price, String description) {
        this.accommodationId = accommodationId;
        this.owner = owner;
        this.address = address;
        this.price = price;
        this.description = description;
    }

    // Constructor por defecto
    public Accommodation() {
    }

    // Getters y setters
    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // Métodos equals, hashCode y toString adaptados para el nuevo campo owner

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(accommodationId, that.accommodationId) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(address, that.address) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accommodationId, owner, address, price, description);
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accommodationId=" + accommodationId +
                ", owner=" + owner +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}