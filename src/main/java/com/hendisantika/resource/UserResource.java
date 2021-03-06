package com.hendisantika.resource;

import com.hendisantika.dto.CarDTO;
import com.hendisantika.dto.UserDTO;
import com.hendisantika.entity.User;
import com.hendisantika.service.UserService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{code}")
    public ResponseEntity findByCode(@PathVariable String code) {
        UserDTO userDTO = userService.findByCode(code);
        if (userDTO == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/{code}/cars")
    public ResponseEntity findUserCars(@PathVariable String code) {
        CollectionModel<CarDTO> cars = userService.findUserCars(code);
        if (cars != null) return ResponseEntity.ok(cars);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity insertUser(@RequestBody User user) {
        UserDTO userDTO = userService.insert(user);
        return ResponseEntity //
                .created(userDTO.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(userDTO);
    }
}
