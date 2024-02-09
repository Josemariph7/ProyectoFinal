package model;

import java.util.Objects;

/**
 * Clase que representa un usuario en el sistema.
 */
public class User {
    private Long userId; // Clave Primaria
    private String name; // Nombre del usuario
    private String email; // Email del usuario
    private String password; // Contraseña del usuario
    private String phone; // Teléfono del usuario
    private UserRole role; // Rol del usuario (Estudiante, Propietario, Administrador)


    public User(Long userId, String name, String email, String password, String phone, UserRole role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(phone, user.phone) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, phone, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                '}';
    }
}

/**
 * Enumeración de los roles posibles para un usuario.
 */
enum UserRole {
    STUDENT,
    OWNER,
    ADMINISTRATOR
}