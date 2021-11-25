package com.hendisantika.resource;

import com.hendisantika.assembler.ActorModelAssembler;
import com.hendisantika.assembler.AlbumModelAssembler;
import com.hendisantika.entity.ActorEntity;
import com.hendisantika.entity.AlbumEntity;
import com.hendisantika.model.ActorModel;
import com.hendisantika.repository.ActorRepository;
import com.hendisantika.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

}
