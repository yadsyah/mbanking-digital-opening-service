package id.co.diansetiyadi.digitalopeningservice;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableWebFlux
@EnableKafka
public class DigitalOpeningServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalOpeningServiceApplication.class, args);
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}
}
