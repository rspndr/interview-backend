package io.rspndr.interview.model.dto;

import io.rspndr.interview.model.Position;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * DEMO (resolved): position lives on the DTO, not the entity.
 * The User entity stays a pure persistence object, so UserService never
 * needs PositionService — enrichment happens at the REST boundary.
 */
public record UserDto(
        UUID id,
        Instant createdAt,
        String username,
        String firstName,
        String lastName,
        String email,
        String companyCode,
        List<Double> location,
        Position position) {
}
