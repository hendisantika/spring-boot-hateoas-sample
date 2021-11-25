package com.hendisantika.resource;

import com.hendisantika.assembler.ActorModelAssembler;
import com.hendisantika.assembler.AlbumModelAssembler;
import com.hendisantika.entity.ActorEntity;
import com.hendisantika.entity.AlbumEntity;
import com.hendisantika.model.ActorModel;
import com.hendisantika.model.AlbumModel;
import com.hendisantika.repository.ActorRepository;
import com.hendisantika.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.15
 */
@RestController
public class WebController {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorModelAssembler actorModelAssembler;

    @Autowired
    private AlbumModelAssembler albumModelAssembler;

    @Autowired
    private PagedResourcesAssembler<AlbumEntity> pagedResourcesAssembler;

    @GetMapping("/api/actors")
    public ResponseEntity<CollectionModel<ActorModel>> getAllActors() {
        List<ActorEntity> actorEntities = (List<ActorEntity>) actorRepository.findAll();

        return new ResponseEntity<>(
                actorModelAssembler.toCollectionModel(actorEntities),
                HttpStatus.OK);
    }

    @GetMapping("/api/actors/{id}")
    public ResponseEntity<ActorModel> getActorById(@PathVariable("id") Long id) {
        return actorRepository.findById(id)
                .map(actorModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/api/albums")
    public ResponseEntity<CollectionModel<AlbumModel>> getAllAlbums() {
        List<AlbumEntity> albumEntities = (List<AlbumEntity>) albumRepository.findAll();

        return new ResponseEntity<>(
                albumModelAssembler.toCollectionModel(albumEntities),
                HttpStatus.OK);
    }

    @GetMapping("/api/albums/{id}")
    public ResponseEntity<AlbumModel> getAlbumById(@PathVariable("id") Long id) {
        return albumRepository.findById(id)
                .map(albumModelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
