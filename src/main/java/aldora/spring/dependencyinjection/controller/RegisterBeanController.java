package aldora.spring.dependencyinjection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterBeanController {
    @GetMapping("/{property}")
    public String registerAnimalBean(@PathVariable String property) {
        return "ok";
    }
}
