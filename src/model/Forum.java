package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un foro en el sistema.
 */
public class Forum {
    private Long forumId; // Clave Primaria
    private String name; // Nombre del foro
    private List<Post> posts; // Publicaciones dentro del foro

    public Forum(Long forumId, String name) {
        this.forumId = forumId;
        this.name = name;
        this.posts = new ArrayList<>(); // Inicialización de la lista de publicaciones
    }

    // Getters y setters adicionales
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // Métodos para agregar y quitar publicaciones
    public void addPost(Post post) {
        this.posts.add(post);
    }

    public void removePost(Post post) {
        this.posts.remove(post);
    }

    // toString, equals, y hashCode actualizados
    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(forumId, forum.forumId) &&
                Objects.equals(name, forum.name) &&
                Objects.equals(posts, forum.posts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumId, name, posts);
    }
}
