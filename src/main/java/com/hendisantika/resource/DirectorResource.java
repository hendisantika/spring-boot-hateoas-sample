package com.hendisantika.resource;

import com.hendisantika.entity.Director;
import com.hendisantika.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/directors")
public class DirectorResource {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<CollectionModel<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        directors.forEach(director -> {
            director.add(linkTo(methodOn(DirectorResource.class).getDirectorById(director.getId())).withSelfRel());
            director.add(linkTo(methodOn(DirectorResource.class).getDirectorMovies(director.getId())).withRel(
                    "directorMovies"));
        });
        Link allDirectorsLink = linkTo(methodOn(DirectorResource.class).getAllDirectors()).withSelfRel();
        return ResponseEntity.ok(CollectionModel.of(directors, allDirectorsLink));
    }

    @GetMapping("/{id}")
    public ResponseEntity getDirectorById(@PathVariable Long id) {
        Director director = directorService.getDirectorById(id).orElseThrow(RuntimeException::new);
        if (director != null) return ResponseEntity.ok(director);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}/movies")
    public ResponseEntity getDirectorMovies(@PathVariable Long id) {
        Director director = directorService.getDirectorMovies(id).orElseThrow(RuntimeException::new);
        if (director != null) return ResponseEntity.ok(director);
        return ResponseEntity.notFound().build();
    }
}
