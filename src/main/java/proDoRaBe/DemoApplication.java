package proDoRaBe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.active", "demo");
        System.setProperty("JDBC_DATABASE_URL", "jdbc");
        SpringApplication.run(DemoApplication.class, args);
    }
}