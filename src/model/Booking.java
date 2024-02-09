package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una reserva (booking) en la aplicación.
 */
public class Booking {
    private Long bookingId; // Identificador único de la reserva
    private Long accommodationId; // Identificador del alojamiento reservado
    private Long userId; // Identificador del usuario que realiza la reserva
    private LocalDateTime startDate; // Fecha de inicio de la reserva
    private LocalDateTime endDate; // Fecha de fin de la reserva
    private BookingStatus status; // Estado de la reserva (pendiente, confirmada, cancelada)

    public Booking() {
    }

    public Booking(Long bookingId, Long accommodationId, Long userId, LocalDateTime startDate, LocalDateTime endDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.accommodationId = accommodationId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) && Objects.equals(accommodationId, booking.accommodationId) && Objects.equals(userId, booking.userId) && Objects.equals(startDate, booking.startDate) && Objects.equals(endDate, booking.endDate) && status == booking.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, accommodationId, userId, startDate, endDate, status);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", accommodationId=" + accommodationId +
                ", userId=" + userId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                '}';
    }

    // Estado de la reserva como Enum
    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
