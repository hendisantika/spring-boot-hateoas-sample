package com.hendisantika.repository;

import com.hendisantika.entity.ActorEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.14
 */
public interface ActorRepository extends PagingAndSortingRepository<ActorEntity, Long> {
}
