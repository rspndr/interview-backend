package io.rspndr.interview.model.service;

import io.rspndr.interview.model.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User create(User assignment);

    User getById(UUID id);

    void deleteById(UUID id);

    List<User> getByCompanyCode(String companyCode);
}
