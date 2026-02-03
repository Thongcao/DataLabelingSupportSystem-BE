package com.anotation.userrole;

import jakarta.validation.Valid;
import java.time.Instant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {
    private final UserRoleRepository repository;

    public UserRoleController(UserRoleRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public UserRole create(@Valid @RequestBody UserRoleCreateRequest request) {
        UserRole userRole = new UserRole();
        userRole.setUserId(request.getUserId());
        userRole.setRoleId(request.getRoleId());
        userRole.setAssignedBy(request.getAssignedBy());
        userRole.setAssignedAt(Instant.now());
        return repository.save(userRole);
    }
}

