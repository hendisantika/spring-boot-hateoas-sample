package com.hendisantika.controller;

import com.hendisantika.entity.Director;
import com.hendisantika.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.33
 */
@RestController
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping("/directors")
    public ResponseEntity<CollectionModel<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        directors.forEach(director -> {
            director.add(linkTo(methodOn(DirectorController.class).getDirectorById(director.getId())).withSelfRel());
            director.add(linkTo(methodOn(DirectorController.class).getDirectorMovies(director.getId())).withRel(
                    "directorMovies"));
        });
        Link allDirectorsLink = linkTo(methodOn(DirectorController.class).getAllDirectors()).withSelfRel())
        return ResponseEntity.ok(CollectionModel.of(directors, allDirectorsLink));
    }
}
