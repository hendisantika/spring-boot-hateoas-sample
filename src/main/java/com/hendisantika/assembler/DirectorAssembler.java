package com.hendisantika.assembler;

import com.hendisantika.entity.Director;
import com.hendisantika.resource.DirectorResource;
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
        resource.add(linkTo(methodOn(DirectorResource.class).getDirectorById(directorId)).withSelfRel());
        resource.add(linkTo(methodOn(DirectorResource.class).getDirectorMovies(directorId)).withRel("directorMovies"
        ));
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<Director>> resources) {
        resources.add(linkTo(methodOn(DirectorResource.class).getAllDirectors()).withSelfRel());

    }
}
