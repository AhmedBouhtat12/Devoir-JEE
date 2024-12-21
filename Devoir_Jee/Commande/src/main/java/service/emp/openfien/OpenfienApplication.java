package service.emp.openfien;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class OpenfienApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenfienApplication.class, args);
    }

}
