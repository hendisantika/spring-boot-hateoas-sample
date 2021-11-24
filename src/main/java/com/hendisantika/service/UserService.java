package com.hendisantika.service;

import com.hendisantika.dto.CarDTO;
import com.hendisantika.dto.UserDTO;
import com.hendisantika.entity.User;
import org.springframework.hateoas.CollectionModel;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.55
 */
public interface UserService {

    CollectionModel<UserDTO> findAll(int page, int size, String[] sort, String dir);

    UserDTO findByCode(String code);

    CollectionModel<CarDTO> findUserCars(String code);

    UserDTO insert(User user);
}
