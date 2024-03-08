package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Booking {
    private Long bookingId;
    private Accommodation accommodation;
    private User user;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BookingStatus status;

    public Booking() {
    }

    public Booking(Long bookingId, Accommodation accommodation, User user, LocalDateTime startDate, LocalDateTime endDate, BookingStatus status) {
        this.bookingId = bookingId;
        this.accommodation = accommodation;
        this.user = user;
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

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, accommodation, user, startDate, endDate, status);
    }

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

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
