package io.rspndr.interview.rest;

import io.rspndr.interview.model.entity.User;
import io.rspndr.interview.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UsersRestController {

    private final UserService userService;

    @GetMapping("{id}")
    public User getAssignment(@PathVariable UUID id) {
        return userService.getById(id);
    }

    @GetMapping("company/{companyCode}")
    public List<User> getAssignments(@PathVariable String companyCode) {
        return userService.getByCompanyCode(companyCode);
    }
}
