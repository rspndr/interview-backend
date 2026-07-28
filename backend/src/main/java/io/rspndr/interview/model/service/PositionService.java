package io.rspndr.interview.model.service;

import io.rspndr.interview.model.Position;

import java.util.Optional;
import java.util.UUID;

public interface PositionService {

    Position record(UUID userId, double latitude, double longitude);

    Optional<Position> getLastKnownPosition(UUID userId);

    void deleteAllForUser(UUID userId);
}
