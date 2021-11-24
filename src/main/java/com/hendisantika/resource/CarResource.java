package com.hendisantika.resource;

import com.hendisantika.dto.CarDTO;
import com.hendisantika.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.56
 */
@RestController
@RequestMapping("/cars")
public class CarResource {

    private final CarService carService;

    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{plate}")
    public ResponseEntity findByPlate(@PathVariable String plate) {
        CarDTO car = carService.findByPlate(plate);
        if (car != null) return ResponseEntity.ok(car);
        return ResponseEntity.notFound().build();
    }
}
