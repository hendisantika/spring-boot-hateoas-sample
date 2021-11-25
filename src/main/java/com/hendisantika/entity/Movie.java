package com.hendisantika.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.30
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Movie extends RepresentationModel<Movie> {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private int year;
    private Rating rating;
    @ManyToOne
    private Director director;
}
