package io.rspndr.interview.rest;

import io.rspndr.interview.mapper.UserMapper;
import io.rspndr.interview.model.dto.UserDto;
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
    private final UserMapper userMapper;

    @GetMapping("{id}")
    public UserDto getUser(@PathVariable UUID id) {
        return userMapper.toDto(userService.getById(id));
    }

    @GetMapping("company/{companyCode}")
    public List<UserDto> getUsersByCompany(@PathVariable String companyCode) {
        return userService.getByCompanyCode(companyCode).stream()
                .map(userMapper::toDto)
                .toList();
    }
}
