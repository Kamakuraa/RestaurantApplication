package ro.rarom.RestaurantApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.rarom.RestaurantApplication.model.ReservationTable;
import ro.rarom.RestaurantApplication.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    public List<ReservationTable> getAllReservation(ReservationTable reservationTable, Double maxPrice) {
        return repository.findAll();
    }

    public Optional<ReservationTable> getReservationById(int productId) {
        return repository.findById(productId);
    }

    public ReservationTable addReservation(ReservationTable table) {
        return repository.save(table);
    }
    public ReservationTable deleteReservationById(int productId){
        Optional<ReservationTable> inventoy = repository.findById(productId);
        inventoy.ifPresent(repository::delete);
        return inventoy.orElse(null);
    }
}
