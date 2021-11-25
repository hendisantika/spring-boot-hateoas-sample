package com.hendisantika.service;

import com.hendisantika.assembler.DirectorAssembler;
import com.hendisantika.dto.DirectorDTO;
import com.hendisantika.entity.Director;
import com.hendisantika.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.37
 */
@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private DirectorAssembler directorAssembler;

    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    public Optional<Director> getDirectorMovies(Long id) {
        return directorRepository.findById(id);
    }

    public DirectorDTO insert(Director director) {
        director.getMovies().forEach(movie -> movie.setDirector(director));
        return directorAssembler.toModel(directorRepository.save(director));
    }
}
