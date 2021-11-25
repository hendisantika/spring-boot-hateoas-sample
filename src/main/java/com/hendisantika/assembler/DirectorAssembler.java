package com.hendisantika.assembler;

import com.hendisantika.dto.DirectorDTO;
import com.hendisantika.entity.Director;
import com.hendisantika.resource.DirectorResource;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
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
public class DirectorAssembler implements RepresentationModelAssembler<Director, DirectorDTO> {
    public void addLinks(EntityModel<Director> resource) {
        Long directorId = resource.getContent().getId();
        resource.add(linkTo(methodOn(DirectorResource.class).getDirectorById(directorId)).withSelfRel());
        resource.add(linkTo(methodOn(DirectorResource.class).getDirectorMovies(directorId)).withRel("directorMovies"
        ));
    }

    public void addLinks(CollectionModel<EntityModel<Director>> resources) {
        resources.add(linkTo(methodOn(DirectorResource.class).getAllDirectors()).withSelfRel());
    }

    @Override
    public DirectorDTO toModel(Director entity) {
        DirectorDTO directorDTO = new DirectorDTO(entity.getId(), entity.getFirstname(), entity.getLastname(),
                entity.getYear(), entity.getMovies());
        directorDTO.add(linkTo(methodOn(DirectorResource.class).getDirectorById(entity.getId())).withSelfRel());
        directorDTO.add(linkTo(methodOn(DirectorResource.class).getDirectorMovies(entity.getId())).withSelfRel());
        return directorDTO;
    }
}
