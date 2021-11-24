package com.hendisantika.resource;

import com.hendisantika.service.CarService;
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
}
