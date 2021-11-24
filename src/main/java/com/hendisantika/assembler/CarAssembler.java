package com.hendisantika.assembler;

import com.hendisantika.dto.CarDTO;
import com.hendisantika.entity.Car;
import com.hendisantika.resource.CarResource;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.55
 */
@Component
public class CarAssembler implements RepresentationModelAssembler<Car, CarDTO> {

    @Override
    public CarDTO toModel(Car entity) {
        CarDTO carDTO = new CarDTO(entity.getPlate(), entity.getName());
        carDTO.add(linkTo(methodOn(CarResource.class).findCarUser(entity.getPlate())).withRel("user"));
        carDTO.add(linkTo(methodOn(CarResource.class).findByPlate(entity.getPlate())).withSelfRel());
        return carDTO;
    }
}
