package io.rspndr.interview.model;

import java.util.List;
import java.util.UUID;

public interface AssignmentService {

    Assignment getById(UUID id);

    void deleteById(UUID id);

    List<Assignment> getByCompanyCode(String companyCode);
}
