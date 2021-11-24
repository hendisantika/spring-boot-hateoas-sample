package com.hendisantika.service;

import com.hendisantika.assembler.CarAssembler;
import com.hendisantika.assembler.UserAssembler;
import com.hendisantika.repository.UserRepository;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.stereotype.Service;

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

}
