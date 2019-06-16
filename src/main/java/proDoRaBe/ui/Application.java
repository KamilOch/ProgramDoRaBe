package proDoRaBe.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("JDBC_DATABASE_URL: " + System.getenv("JDBC_DATABASE_URL"));
        SpringApplication.run(Application.class, args);
    }
}