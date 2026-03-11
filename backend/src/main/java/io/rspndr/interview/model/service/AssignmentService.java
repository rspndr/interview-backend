package io.rspndr.interview.model.service;

import io.rspndr.interview.model.entity.Assignment;

import java.util.List;
import java.util.UUID;

public interface AssignmentService {

    Assignment create(Assignment assignment);

    Assignment getById(UUID id);

    void deleteById(UUID id);

    List<Assignment> getByCompanyCode(String companyCode);
}
