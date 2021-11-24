package com.hendisantika.resource;

import com.hendisantika.dto.UserDTO;
import com.hendisantika.service.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.52
 */
@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                  @RequestParam(required = false, defaultValue = "3") Integer size,
                                  @RequestParam(required = false) String[] sort,
                                  @RequestParam(required = false, defaultValue = "asc") String dir) {

        CollectionModel<UserDTO> users = userService.findAll(page, size, sort, dir);
        if (users != null) {
            return ResponseEntity.ok(users);
        }
        return ResponseEntity.noContent().build();
    }

}
