package com.hendisantika.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Relation(collectionRelation = "albums", itemRelation = "album")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlbumModel extends RepresentationModel<AlbumModel>
{
    private Long id;
    private String title;
    private String description;
    private String releaseDate;

    private List<ActorModel> actors;
}
