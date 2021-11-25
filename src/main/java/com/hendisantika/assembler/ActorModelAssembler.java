package com.hendisantika.assembler;

import com.hendisantika.entity.ActorEntity;
import com.hendisantika.entity.AlbumEntity;
import com.hendisantika.model.ActorModel;
import com.hendisantika.model.AlbumModel;
import com.hendisantika.resource.WebController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.15
 */
@Component
public class ActorModelAssembler extends RepresentationModelAssemblerSupport<ActorEntity, ActorModel> {

    public ActorModelAssembler() {
        super(WebController.class, ActorModel.class);
    }

    @Override
    public ActorModel toModel(ActorEntity entity)
    {
        ActorModel actorModel = instantiateModel(entity);

        actorModel.add(linkTo(methodOn(WebController.class)
                .getActorById(entity.getId()))
                .withSelfRel());

        actorModel.setId(entity.getId());
        actorModel.setFirstName(entity.getFirstName());
        actorModel.setLastName(entity.getLastName());
        actorModel.setBirthDate(entity.getBirthDate());
        actorModel.setAlbums(toAlbumModel(entity.getAlbums()));
        return actorModel;
    }

    @Override
    public CollectionModel<ActorModel> toCollectionModel(Iterable<? extends ActorEntity> entities)
    {
        CollectionModel<ActorModel> actorModels = super.toCollectionModel(entities);
        actorModels.add(linkTo(methodOn(WebController.class).getAllActors()).withSelfRel());

        return actorModels;
    }

    private List<AlbumModel> toAlbumModel(List<AlbumEntity> albums) {
        if (albums.isEmpty())
            return Collections.emptyList();

        return albums.stream()
                .map(album -> AlbumModel.builder()
                        .id(album.getId())
                        .title(album.getTitle())
                        .build()
                        .add(linkTo(
                                methodOn(WebController.class)
                                        .getAlbumById(album.getId()))
                                .withSelfRel()))
                .collect(Collectors.toList());
    }
}
