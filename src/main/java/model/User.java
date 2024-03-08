package model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un usuario en el sistema.
 */
public class User {
    private Long userId; // Identificador único del usuario
    private String name; // Nombre del usuario
    private String email; // Correo electrónico del usuario
    private String password; // Contraseña del usuario
    private String phone; // Número de teléfono del usuario
    private UserRole role; // Rol del usuario en el sistema
    private LocalDateTime registrationDate; // Fecha y hora de registro del usuario
    private String profilePicture; // URL de la imagen de perfil del usuario
    private List<Booking> bookings; // Lista de reservas realizadas por el usuario
    private List<Post> posts; // Lista de publicaciones realizadas por el usuario
    private List<Comment> comments; // Lista de comentarios realizados por el usuario
    private List<Review> reviews; // Lista de reseñas realizadas por el usuario
    private List<Accommodation> accommodations; // Lista de alojamientos gestionados por el usuario

    /**
     * Constructor de la clase User.
     *
     * @param name             Nombre del usuario.
     * @param email            Correo electrónico del usuario.
     * @param password         Contraseña del usuario.
     * @param phone            Número de teléfono del usuario.
     * @param role             Rol del usuario en el sistema.
     */
    public User(String name, String email, String password, String phone, UserRole role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.registrationDate = LocalDateTime.now();
        this.profilePicture = null;
    }

    public User() {
    }

    // Getters y setters

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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(phone, user.phone) &&
                role == user.role &&
                Objects.equals(registrationDate, user.registrationDate) &&
                Objects.equals(profilePicture, user.profilePicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, phone, role, registrationDate, profilePicture);
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
                ", registrationDate=" + registrationDate +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }

    /**
     * Enumeración que representa los roles de usuario en el sistema.
     */
    public enum UserRole {
        STUDENT,
        OWNER,
        ADMINISTRATOR
    }
}
