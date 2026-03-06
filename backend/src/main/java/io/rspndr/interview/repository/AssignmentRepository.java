package io.rspndr.interview.repository;

import io.rspndr.interview.model.Assignment;
import com.infobip.spring.data.jdbc.QuerydslJdbcRepository;
import org.springframework.data.repository.query.ListQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AssignmentRepository extends QuerydslJdbcRepository<Assignment, UUID>, ListQueryByExampleExecutor<Assignment> {

    List<Assignment> findAllByCompanyCode(String companyCode);
}
