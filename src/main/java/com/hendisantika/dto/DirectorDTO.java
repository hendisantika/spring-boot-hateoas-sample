package com.hendisantika.dto;

import com.hendisantika.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 10.26
 */
@Data
@AllArgsConstructor
public class DirectorDTO extends RepresentationModel<DirectorDTO> {
    private Long id;
    private String firstname;
    private String lastname;
    private int year;
    private Set<Movie> movies;
}
