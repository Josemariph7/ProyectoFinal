package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un foro en el sistema.
 */
public class Forum {
    private final Long forumId; // Clave Primaria
    private final String name; // Nombre del foro
    private List<Post> posts; // Publicaciones dentro del foro

    /**
     * Constructor de la clase Forum.
     *
     * @param forumId Identificador único del foro.
     * @param name    Nombre del foro.
     */
    public Forum(Long forumId, String name) {
        this.forumId = forumId;
        this.name = name;
        this.posts = new ArrayList<>();
    }

    /**
     * Obtiene la lista de publicaciones dentro del foro.
     *
     * @return La lista de publicaciones.
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * Establece la lista de publicaciones dentro del foro.
     *
     * @param posts La lista de publicaciones a establecer.
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Agrega una publicación al foro.
     *
     * @param post La publicación a agregar.
     */
    public void addPost(Post post) {
        this.posts.add(post);
    }

    /**
     * Elimina una publicación del foro.
     *
     * @param post La publicación a eliminar.
     */
    public void removePost(Post post) {
        this.posts.remove(post);
    }

    /**
     * Obtiene el identificador único del foro.
     *
     * @return El identificador único del foro.
     */
    public Long getForumId() {
        return forumId;
    }

    /**
     * Obtiene el nombre del foro.
     *
     * @return El nombre del foro.
     */
    public String getName() {
        return name;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto Forum.
     *
     * @return La representación en forma de cadena del objeto Forum.
     */
    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    /**
     * Indica si el objeto Forum es igual a otro objeto dado.
     *
     * @param o Objeto a comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(forumId, forum.forumId) &&
                Objects.equals(name, forum.name) &&
                Objects.equals(posts, forum.posts);
    }

    /**
     * Calcula el código hash del objeto Forum.
     *
     * @return El código hash del objeto Forum.
     */
    @Override
    public int hashCode() {
        return Objects.hash(forumId, name, posts);
    }
}
