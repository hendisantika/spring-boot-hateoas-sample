package com.hendisantika.service;

import com.hendisantika.assembler.CarAssembler;
import com.hendisantika.assembler.UserAssembler;
import com.hendisantika.dto.CarDTO;
import com.hendisantika.dto.UserDTO;
import com.hendisantika.entity.Car;
import com.hendisantika.repository.CarRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 20.05
 */
@Service
public class CarServiceImpl implements CarService {

    private final UserAssembler userAssembler;
    private final CarAssembler carAssembler;
    private final PagedResourcesAssembler pagedResourcesAssembler;
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository, UserAssembler userAssembler, CarAssembler carAssembler,
                          PagedResourcesAssembler pagedResourcesAssembler) {
        this.carRepository = carRepository;
        this.userAssembler = userAssembler;
        this.carAssembler = carAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }


    @Override
    public CarDTO findByPlate(String plate) {
        Car car = carRepository.findByPlate(plate).orElse(null);
        if (car != null) {
            return carAssembler.toModel(car);
        }
        return null;
    }

    @Override
    public UserDTO findCarUser(String plate) {
        Car car = carRepository.findByPlate(plate).orElse(null);
        if (car != null && car.getUser() != null) {
            return userAssembler.toModel(car.getUser());
        }
        return null;
    }
}
