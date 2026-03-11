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
@Table("assignment")
public class Assignment {

    @Id
    @Column("id")
    private UUID id;
    @Column("created_at")
    private Instant createdAt;
    @Column("name")
    private String name;
    @Column("company_code")
    private String companyCode;
    @Column("location")
    private List<Double> location;
    @Column("deleted")
    private boolean deleted;
}
