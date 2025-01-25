package az.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/productServiceFallback")
    public String productFallback() {
        return "Fallback response: Product service is unavailable.";
    }

    @GetMapping("/orderServiceFallback")
    public String orderFallback() {
        return "Fallback response: Order service is unavailable.";
    }

    @GetMapping("/authServiceFallback")
    public String authFallback() {
        return "Fallback response: Auth service is unavailable.";
    }
}
