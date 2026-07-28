package io.rspndr.interview.rest;

import io.rspndr.interview.model.Position;
import io.rspndr.interview.model.dto.PositionUpdateRequest;
import io.rspndr.interview.model.exception.NotFoundException;
import io.rspndr.interview.model.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionsRestController {

    private final PositionService positionService;

    @PutMapping("{userId}")
    public Position updatePosition(@PathVariable UUID userId, @RequestBody PositionUpdateRequest request) {
        return positionService.record(userId, request.latitude(), request.longitude());
    }

    @GetMapping("{userId}")
    public Position getPosition(@PathVariable UUID userId) {
        return positionService.getLastKnownPosition(userId)
                .orElseThrow(() -> new NotFoundException("No position recorded for user"));
    }

    @DeleteMapping("{userId}")
    public void deletePositions(@PathVariable UUID userId) {
        positionService.deleteAllForUser(userId);
    }
}
