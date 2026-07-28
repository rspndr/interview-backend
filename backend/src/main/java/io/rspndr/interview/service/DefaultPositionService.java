package io.rspndr.interview.service;

import io.rspndr.interview.model.Position;
import io.rspndr.interview.model.service.PositionService;
import io.rspndr.interview.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class DefaultPositionService implements PositionService {

    // DEMO: PositionService depends on UserService...
    private final UserService userService;

    private final Map<UUID, Position> lastKnownPositions = new ConcurrentHashMap<>();

    @Override
    public Position record(UUID userId, double latitude, double longitude) {
        // validate the user exists before recording a position
        userService.getById(userId);

        Position position = new Position(userId, latitude, longitude, Instant.now());
        lastKnownPositions.put(userId, position);

        return position;
    }

    @Override
    public Optional<Position> getLastKnownPosition(UUID userId) {
        return Optional.ofNullable(lastKnownPositions.get(userId));
    }

    @Override
    public void deleteAllForUser(UUID userId) {
        lastKnownPositions.remove(userId);
    }
}
