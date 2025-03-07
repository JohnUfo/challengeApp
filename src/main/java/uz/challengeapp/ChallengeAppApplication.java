package uz.challengeapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ChallengeAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChallengeAppApplication.class, args);
    }

}
