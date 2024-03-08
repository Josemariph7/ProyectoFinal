package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una reseña de un alojamiento.
 */
public class Review {
    private Long reviewId; // Identificador único de la reseña
    private Accommodation accommodation; // Alojamiento al que pertenece la reseña
    private User author; // Usuario que escribió la reseña
    private Integer rating; // Puntuación de la reseña
    private String comment; // Comentario de la reseña
    private LocalDateTime dateTime; // Fecha y hora de la reseña

    /**
     * Constructor de la clase Review.
     *
     * @param reviewId      Identificador único de la reseña.
     * @param accommodation Alojamiento al que pertenece la reseña.
     * @param author        Usuario que escribió la reseña.
     * @param rating        Puntuación de la reseña.
     * @param comment       Comentario de la reseña.
     * @param dateTime      Fecha y hora de la reseña.
     */
    public Review(Long reviewId, Accommodation accommodation, User author, Integer rating, String comment, LocalDateTime dateTime) {
        this.reviewId = reviewId;
        this.accommodation = accommodation;
        this.author = author;
        this.rating = rating;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public Review() {
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewId, review.reviewId) &&
                Objects.equals(accommodation, review.accommodation) &&
                Objects.equals(author, review.author) &&
                Objects.equals(rating, review.rating) &&
                Objects.equals(comment, review.comment) &&
                Objects.equals(dateTime, review.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, accommodation, author, rating, comment, dateTime);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", accommodation=" + (accommodation != null ? accommodation.getAccommodationId() : null) +
                ", author=" + (author != null ? author.getUserId() : null) +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
