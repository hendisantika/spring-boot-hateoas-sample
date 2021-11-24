package com.hendisantika.repository;

import com.hendisantika.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.35
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
