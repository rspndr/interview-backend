package io.rspndr.interview.repository;

import com.infobip.spring.data.jdbc.QuerydslJdbcRepository;
import io.rspndr.interview.model.entity.User;
import org.springframework.data.repository.query.ListQueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends QuerydslJdbcRepository<User, UUID>, ListQueryByExampleExecutor<User> {

    List<User> findAllByCompanyCode(String companyCode);
}
