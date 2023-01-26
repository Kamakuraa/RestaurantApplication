package ro.rarom.RestaurantApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ReservationTable {
    @Id
    @GeneratedValue
    private int id;
    private double stars;
    private String description;
    private RestaurantType category;

    public ReservationTable(double price, String description, RestaurantType category) {
        this.stars = price;
        this.description = description;
        this.category = category;
    }
}
