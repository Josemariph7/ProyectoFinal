package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa un comentario en la aplicación.
 */
public class Comment {
    private Long commentId; // Identificador único del comentario
    private Long postId; // Identificador de la publicación a la que pertenece el comentario
    private Long authorId; // Identificador del autor del comentario
    private String content; // Contenido textual del comentario
    private LocalDateTime dateTime; // Fecha y hora en que se hizo el comentario

    public Comment() {
    }

    public Comment(Long commentId, Long postId, Long authorId, String content, LocalDateTime dateTime) {
        this.commentId = commentId;
        this.postId = postId;
        this.authorId = authorId;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(postId, comment.postId) && Objects.equals(authorId, comment.authorId) && Objects.equals(content, comment.content) && Objects.equals(dateTime, comment.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, postId, authorId, content, dateTime);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", authorId=" + authorId +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}

