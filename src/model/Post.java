package model;


import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Clase que representa una publicación en un foro.
 */
public class Post {
    private Long postId; // Clave Primaria
    private Long forumId; // Clave Foránea (Forum)
    private Long authorId; // Clave Foránea (User)
    private String title; // Título de la publicación
    private String content; // Contenido de la publicación
    private LocalDateTime dateTime; // Fecha y hora de la publicación

    public Post(Long postId, Long forumId, Long authorId, String title, String content, LocalDateTime dateTime) {
        this.postId = postId;
        this.forumId = forumId;
        this.authorId = authorId;
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

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(forumId, post.forumId) && Objects.equals(authorId, post.authorId) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(dateTime, post.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, forumId, authorId, title, content, dateTime);
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", forumId=" + forumId +
                ", authorId=" + authorId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}