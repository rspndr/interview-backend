package io.rspndr.interview.mapper;

import io.rspndr.interview.model.Position;
import io.rspndr.interview.model.dto.UserDto;
import io.rspndr.interview.model.entity.User;
import io.rspndr.interview.model.service.PositionService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    // Field injection: MapStruct generates the implementing subclass,
    // so constructor injection is not an option for abstract mappers.
    @Autowired
    protected PositionService positionService;

    @Mapping(target = "position", source = "id", qualifiedByName = "lastKnownPosition")
    public abstract UserDto toDto(User user);

    @Named("lastKnownPosition")
    protected Position lastKnownPosition(UUID userId) {
        return positionService.getLastKnownPosition(userId).orElse(null);
    }
}
