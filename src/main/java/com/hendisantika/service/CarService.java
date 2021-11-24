package com.hendisantika.service;

import com.hendisantika.dto.CarDTO;
import com.hendisantika.dto.UserDTO;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 20.04
 */
public interface CarService {

    CarDTO findByPlate(String plate);

    UserDTO findCarUser(String plate);
}
