package com.hendisantika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.51
 */
@Relation(collectionRelation = "cars")
@Data
@AllArgsConstructor
public class CarDTO extends RepresentationModel<CarDTO> {

    private String plate;

    private String name;
}
