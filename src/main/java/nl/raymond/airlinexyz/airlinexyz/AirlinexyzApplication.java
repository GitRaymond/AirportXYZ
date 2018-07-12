package nl.raymond.airlinexyz.airlinexyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AirlinexyzApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirlinexyzApplication.class, args);
	}
}
