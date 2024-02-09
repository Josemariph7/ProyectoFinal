package model;

import java.util.Objects;

/**
 * Clase que representa un foro en el sistema.
 */
public class Forum {
    private Long forumId; // Clave Primaria
    private String name; // Nombre del foro

    public Forum(Long forumId, String name) {
        this.forumId = forumId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Forum{" +
                "forumId=" + forumId +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getForumId() {
        return forumId;
    }

    public void setForumId(Long forumId) {
        this.forumId = forumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forum forum = (Forum) o;
        return Objects.equals(forumId, forum.forumId) && Objects.equals(name, forum.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forumId, name);
    }
}
