package com.hendisantika.service;

import com.hendisantika.assembler.CarAssembler;
import com.hendisantika.assembler.UserAssembler;
import com.hendisantika.dto.UserDTO;
import com.hendisantika.entity.User;
import com.hendisantika.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-hateoas-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/11/21
 * Time: 19.59
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserAssembler userAssembler;

    private final CarAssembler carAssembler;

    private final PagedResourcesAssembler pagedResourcesAssembler;


    public UserServiceImpl(UserRepository userRepository, UserAssembler userAssembler,
                           PagedResourcesAssembler pagedResourcesAssembler, CarAssembler carAssembler) {
        this.userRepository = userRepository;
        this.userAssembler = userAssembler;
        this.carAssembler = carAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @Override
    public CollectionModel<UserDTO> findAll(int page, int size, String[] sort, String dir) {
        PageRequest pageRequest;
        Sort.Direction direction;
        if (sort == null) {
            pageRequest = PageRequest.of(page, size);
        } else {
            if (dir.equalsIgnoreCase("asc")) direction = Sort.Direction.ASC;
            else direction = Sort.Direction.DESC;
            pageRequest = PageRequest.of(page, size, Sort.by(direction, sort));
        }
        Page<User> users = userRepository.findAll(pageRequest);
        if (!CollectionUtils.isEmpty(users.getContent())) return pagedResourcesAssembler.toModel(users, userAssembler);
        return null;
    }
}
