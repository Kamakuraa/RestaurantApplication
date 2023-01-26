package ro.rarom.RestaurantApplication.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ro.rarom.RestaurantApplication.exception.ResourceNotFoundException;
import ro.rarom.RestaurantApplication.model.ReservationTable;
import ro.rarom.RestaurantApplication.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;


    @GetMapping
    List<ReservationTable> getAll(@RequestParam(required = false) ReservationTable reservationTable,
                                  @RequestParam(required = false) Double maxPrice) {
        return service.getAllReservation(reservationTable, maxPrice);
    }

    @GetMapping("{productId}")
    ReservationTable getReservationById(@PathVariable int productId){
        return service.getReservationById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Could not find product with id " + productId));
    }
    @PostMapping
    ReservationTable addReservation(@RequestBody ReservationTable table){
        return service.addReservation(table);
    }
    @DeleteMapping("{productId}")
    void deleteReservationById(@PathVariable int productId){
        service.deleteReservationById(productId);
    }
}
