package com.hendisantika.assembler;

import com.hendisantika.entity.AlbumEntity;
import com.hendisantika.model.AlbumModel;
import com.hendisantika.resource.WebController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/11/21
 * Time: 12.17
 */
@Component
public class AlbumModelAssembler extends RepresentationModelAssemblerSupport<AlbumEntity, AlbumModel> {

    public AlbumModelAssembler() {
        super(WebController.class, AlbumModel.class);
    }
}
