package dev.josk.movies.mapper;

import dev.josk.movies.dto.WatchlistDto;
import dev.josk.movies.entity.Watchlist;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WatchlistMapper {
    WatchlistDto toDto(Watchlist watchlist);

    @InheritInverseConfiguration
    Watchlist toEntity(WatchlistDto watchlistDTO);
}
