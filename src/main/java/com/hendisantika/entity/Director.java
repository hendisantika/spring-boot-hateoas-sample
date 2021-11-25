package com.hendisantika.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.31
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Director extends RepresentationModel<Director> {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private int year;
    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;
}
