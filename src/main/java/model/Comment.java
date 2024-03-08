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
    private List<Comment> comments; // Lista de comentarios anidados a este comentario

    /**
     * Constructor por defecto de la clase Comment.
     */
    public Comment() {
    }

    /**
     * Constructor completo de la clase Comment.
     *
     * @param commentId Identificador único del comentario.
     * @param post      Publicación a la que pertenece el comentario.
     * @param author    Autor del comentario.
     * @param content   Contenido textual del comentario.
     * @param dateTime  Fecha y hora en que se hizo el comentario.
     */
    public Comment(Long commentId, Post post, User author, String content, LocalDateTime dateTime) {
        this.commentId = commentId;
        this.post = post;
        this.author = author;
        this.content = content;
        this.dateTime = dateTime;
    }

    // Getters y setters

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

    /**
     * Método equals para comparar objetos Comment.
     *
     * @param o Objeto a comparar.
     * @return true si los objetos son iguales, false en caso contrario.
     */
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

    /**
     * Método hashCode para calcular el código hash del objeto Comment.
     *
     * @return Código hash del objeto Comment.
     */
    @Override
    public int hashCode() {
        return Objects.hash(commentId, post, author, content, dateTime);
    }

    /**
     * Método toString para obtener una representación en forma de cadena del objeto Comment.
     *
     * @return Representación en forma de cadena del objeto Comment.
     */
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
