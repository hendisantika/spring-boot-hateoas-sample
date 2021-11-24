package com.hendisantika.config;

import com.hendisantika.controller.DirectorController;
import com.hendisantika.entity.Director;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.39
 */
@Component
public class DirectorAssembler implements SimpleRepresentationModelAssembler<Director> {
    @Override
    public void addLinks(EntityModel<Director> resource) {
        Long directorId = resource.getContent().getId();
        resource.add(linkTo(methodOn(DirectorController.class).getDirectorById(directorId)).withSelfRel());
        resource.add(linkTo(methodOn(DirectorController.class).getDirectorMovies(directorId)).withRel("directorMovies"
        ));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Director>> resources) {
        resources.add(linkTo(methodOn(DirectorController.class).getAllDirectors()).withSelfRel());

    }
}
