package com.hendisantika.assembler;

import com.hendisantika.dto.UserDTO;
import com.hendisantika.entity.User;
import com.hendisantika.resource.UserResource;
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
 * Time: 19.52
 */
@Component
public class UserAssembler implements RepresentationModelAssembler<User, UserDTO> {

    @Override
    public UserDTO toModel(User entity) {
        UserDTO userDTO = new UserDTO(entity.getName(), entity.getSurname(), entity.getCode(), entity.getAddress());
        userDTO.add(linkTo(methodOn(UserResource.class).findUserCars(entity.getCode())).withRel("cars"));
        userDTO.add(linkTo(methodOn(UserResource.class).findByCode(entity.getCode())).withSelfRel());
        return userDTO;
    }
}
