package model;


import java.util.Objects;

/**
 * Clase que representa un alojamiento en la aplicación.
 */
public class Accommodation {
    private Long accommodationId; // Identificador único del alojamiento
    private Long ownerId; // Identificador del propietario del alojamiento (clave foránea)
    private String address; // Dirección del alojamiento
    private Double price; // Precio del alojamiento
    private String description; // Descripción del alojamiento

    public Accommodation(Long accommodationId, Long ownerId, String address, Double price, String description) {
        this.accommodationId = accommodationId;
        this.ownerId = ownerId;
        this.address = address;
        this.price = price;
        this.description = description;
    }

    public Accommodation() {
    }

    public Long getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Long accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accommodation that = (Accommodation) o;
        return Objects.equals(accommodationId, that.accommodationId) && Objects.equals(ownerId, that.ownerId) && Objects.equals(address, that.address) && Objects.equals(price, that.price) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accommodationId, ownerId, address, price, description);
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accommodationId=" + accommodationId +
                ", ownerId=" + ownerId +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}