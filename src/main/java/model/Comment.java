package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un comentario en la aplicación.
 */
public class Comment {
    private Long commentId; // Identificador único del comentario
    private Post post; // Publicación a la que pertenece el comentario
    private User author; // Autor del comentario
    private String content; // Contenido textual del comentario
    private LocalDateTime dateTime; // Fecha y hora en que se hizo el comentario

    private List<Comment> comments;

    public Comment() {
    }

    // Asumiendo que las clases Post y User ya están definidas en el paquete model
    public Comment(Long commentId, Post post, User author, String content, LocalDateTime dateTime) {
        this.commentId = commentId;
        this.post = post;
        this.author = author;
        this.content = content;
        this.dateTime = dateTime;
    }

    // Getters y setters actualizados para trabajar con objetos relacionados
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // Asegúrate de actualizar los métodos equals y hashCode para usar las referencias de objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) &&
                Objects.equals(post, comment.post) &&
                Objects.equals(author, comment.author) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(dateTime, comment.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, post, author, content, dateTime);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", post=" + (post != null ? post.getPostId() : null) +
                ", author=" + (author != null ? author.getUserId() : null) +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
