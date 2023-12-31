package ru.kata.spring.boot_security.demo.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class InitDb {

    private final UserService userService;

    @Autowired
    public InitDb(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    private void init() {
        Set<Role> roles = new HashSet<>(Arrays.asList(new Role("ROLE_ADMIN"), new Role("ROLE_USER")));
        userService.addRoles(roles);
        userService.addUser(new User("Test", "Test", (byte) 1, "admin", "admin",
                roles));
    }
}
