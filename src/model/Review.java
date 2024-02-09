package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una reseña de un alojamiento.
 */
public class Review {
    private Long reviewId; // Identificador único de la reseña
    private Long accommodationId; // Identificador del alojamiento que se reseña (clave foránea)
    private Long authorId; // Identificador del autor de la reseña (clave foránea)
    private Integer rating; // Puntuación de la reseña
    private String comment; // Comentario de la reseña
    private LocalDateTime dateTime; // Fecha y hora de la reseña

    public Review(Long reviewId, Long accommodationId, Long authorId, Integer rating, String comment, LocalDateTime dateTime) {
        this.reviewId = reviewId;
        this.accommodationId = accommodationId;
        this.authorId = authorId;
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

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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
        return Objects.equals(reviewId, review.reviewId) && Objects.equals(accommodationId, review.accommodationId) && Objects.equals(authorId, review.authorId) && Objects.equals(rating, review.rating) && Objects.equals(comment, review.comment) && Objects.equals(dateTime, review.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, accommodationId, authorId, rating, comment, dateTime);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", accommodationId=" + accommodationId +
                ", authorId=" + authorId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}