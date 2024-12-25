package az.mspaymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsPaymentServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsPaymentServiceApplication.class, args);
    }

}
