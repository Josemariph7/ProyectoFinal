package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una publicación en un foro.
 */
public class Post {
    private Long postId; // Clave Primaria
    private Forum forum; // Sustituir Long forumId por la referencia al objeto Forum
    private User author; // Sustituir Long authorId por la referencia al objeto User
    private String title; // Título de la publicación
    private String content; // Contenido de la publicación
    private LocalDateTime dateTime; // Fecha y hora de la publicación

    public Post(Long postId, Forum forum, User author, String title, String content, LocalDateTime dateTime) {
        this.postId = postId;
        this.forum = forum;
        this.author = author;
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    // Getters y setters actualizados para Forum y User
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

    // ... Resto de getters y setters ...

    @Override
    public boolean equals(Object o) {
        // Método equals actualizado para comparar objetos Forum y User
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(forum, post.forum) && Objects.equals(author, post.author) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(dateTime, post.dateTime);
    }

    @Override
    public int hashCode() {
        // Método hashCode actualizado para incluir objetos Forum y User
        return Objects.hash(postId, forum, author, title, content, dateTime);
    }

    @Override
    public String toString() {
        // Método toString actualizado para incluir objetos Forum y User
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