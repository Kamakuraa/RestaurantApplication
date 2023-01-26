package ro.rarom.RestaurantApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.rarom.RestaurantApplication.model.ReservationTable;

public interface ReservationRepository extends JpaRepository<ReservationTable, Integer> {

}
