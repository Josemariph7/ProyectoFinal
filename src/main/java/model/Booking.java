package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una reserva de alojamiento en la aplicación.
 */
public class Booking {
    private Long bookingId; // Identificador único de la reserva
    private Accommodation accommodation; // Referencia al alojamiento reservado
    private User user; // Referencia al usuario que realiza la reserva
    private LocalDateTime startDate; // Fecha de inicio de la reserva
    private LocalDateTime endDate; // Fecha de fin de la reserva
    private BookingStatus status; // Estado de la reserva

    /**
     * Constructor por defecto de la clase Booking.
     */
    public Booking() {
    }

    /**
     * Constructor completo de la clase Booking.
     *
     * @param bookingId     Identificador único de la reserva.
     * @param accommodation Referencia al alojamiento reservado.
     * @param user          Referencia al usuario que realiza la reserva.
     * @param startDate     Fecha de inicio de la reserva.
     * @param endDate       Fecha de fin de la reserva.
     * @param status        Estado de la reserva.
     */
    public Booking(Long bookingId, Accommodation accommodation, User user, LocalDateTime startDate, LocalDateTime endDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.accommodation = accommodation;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // Getters y setters

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    /**
     * Método equals para comparar objetos Booking.
     *
     * @param o Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(accommodation, booking.accommodation) &&
                Objects.equals(user, booking.user) &&
                Objects.equals(startDate, booking.startDate) &&
                Objects.equals(endDate, booking.endDate) &&
                status == booking.status;
    }

    /**
     * Método hashCode para calcular el código hash del objeto Booking.
     *
     * @return Código hash del objeto Booking.
     */
    @Override
    public int hashCode() {
        return Objects.hash(bookingId, accommodation, user, startDate, endDate, status);
    }

    /**
     * Método toString para obtener una representación en forma de cadena del objeto Booking.
     *
     * @return Representación en forma de cadena del objeto Booking.
     */
    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", accommodation=" + (accommodation != null ? accommodation.getAccommodationId() : "null") +
                ", user=" + (user != null ? user.getUserId() : "null") +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }

    /**
     * Enumeración que representa los posibles estados de una reserva.
     */
    public enum BookingStatus {
        PENDING,    // Pendiente
        CONFIRMED,  // Confirmada
        CANCELLED   // Cancelada
    }
}
