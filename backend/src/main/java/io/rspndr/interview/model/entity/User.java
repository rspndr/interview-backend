package io.rspndr.interview.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User {

    @Id
    @Column("id")
    private UUID id;
    @Column("created_at")
    private Instant createdAt;
    @Column("username")
    private String username;
    @Column("first_name")
    private String firstName;
    @Column("last_name")
    private String lastName;
    @Column("email")
    private String email;
    @Column("company_code")
    private String companyCode;
    @Column("location")
    private List<Double> location;
}
