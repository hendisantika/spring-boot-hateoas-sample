package com.hendisantika.assembler;

import com.hendisantika.entity.AlbumEntity;
import com.hendisantika.model.AlbumModel;
import com.hendisantika.resource.WebController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.17
 */
@Component
public class AlbumModelAssembler extends RepresentationModelAssemblerSupport<AlbumEntity, AlbumModel> {

    public AlbumModelAssembler() {
        super(WebController.class, AlbumModel.class);
    }

    @Override
    public AlbumModel toModel(AlbumEntity entity)
    {
        AlbumModel albumModel = instantiateModel(entity);

        albumModel.add(linkTo(
                methodOn(WebController.class)
                        .getActorById(entity.getId()))
                .withSelfRel());

        albumModel.setId(entity.getId());
        albumModel.setTitle(entity.getTitle());
        albumModel.setDescription(entity.getDescription());
        albumModel.setReleaseDate(entity.getReleaseDate());
        albumModel.setActors(toActorModel(entity.getActors()));
        return albumModel;
    }
}
