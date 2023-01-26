package ro.rarom.RestaurantApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.rarom.RestaurantApplication.model.ReservationTable;
import ro.rarom.RestaurantApplication.model.RestaurantType;
import ro.rarom.RestaurantApplication.repository.ReservationRepository;

import java.util.List;

@SpringBootApplication
public class RestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApplication.class, args);
	}
	@Bean
	CommandLineRunner atStartUp(ReservationRepository repository){
		return args -> {
			repository.saveAll(List.of(
					new ReservationTable(5, "very Good", RestaurantType.ASIAN)
			));
		};
	}

}
