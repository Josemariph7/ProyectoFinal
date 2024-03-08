package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una publicación en un foro.
 */
public class Post {
    private Long postId; // Clave Primaria
    private Forum forum; // Foro al que pertenece la publicación
    private User author; // Autor de la publicación
    private final String title; // Título de la publicación
    private final String content; // Contenido de la publicación
    private final LocalDateTime dateTime; // Fecha y hora de la publicación

    /**
     * Constructor de la clase Post.
     *
     * @param postId   Identificador único de la publicación.
     * @param forum    Foro al que pertenece la publicación.
     * @param author   Autor de la publicación.
     * @param title    Título de la publicación.
     * @param content  Contenido de la publicación.
     * @param dateTime Fecha y hora de la publicación.
     */
    public Post(Long postId, Forum forum, User author, String title, String content, LocalDateTime dateTime) {
        this.postId = postId;
        this.forum = forum;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Forum getForum() {
        return forum;
    }

    public void setForum(Forum forum) {
        this.forum = forum;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    /**
     * Indica si el objeto Post es igual a otro objeto dado.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) &&
                Objects.equals(forum, post.forum) &&
                Objects.equals(author, post.author) &&
                Objects.equals(title, post.title) &&
                Objects.equals(content, post.content) &&
                Objects.equals(dateTime, post.dateTime);
    }

    /**
     * Calcula el código hash del objeto Post.
     *
     * @return El código hash del objeto Post.
     */
    @Override
    public int hashCode() {
        return Objects.hash(postId, forum, author, title, content, dateTime);
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Post.
     *
     * @return La representación en forma de cadena del objeto Post.
     */
    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", forum=" + forum +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
