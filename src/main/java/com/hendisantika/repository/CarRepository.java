package com.hendisantika.repository;

import com.hendisantika.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.49
 */
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByPlate(String plate);
}
