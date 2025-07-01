package qbckrt.qayaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

import java.time.ZoneId;
import java.util.Objects;

@SpringBootApplication
public class QayaApiApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure()
                .directory("src/main/resources")
                .load();

        // Set environment variables from .env file
        System.setProperty("DB_USERNAME", Objects.requireNonNull(dotenv.get("DB_USERNAME")));
        System.setProperty("DB_PASSWORD", Objects.requireNonNull(dotenv.get("DB_PASSWORD")));

        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted()
                .forEach(System.out::println);

        SpringApplication.run(QayaApiApplication.class, args);
    }

}
