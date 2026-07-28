package io.rspndr.interview.model;

import java.time.Instant;
import java.util.UUID;

public record Position(UUID userId, double latitude, double longitude, Instant recordedAt) {
}
