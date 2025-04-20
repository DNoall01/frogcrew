package edu.tcu.cs.frogcrew.game.converter;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.game.dto.GameDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameToGameDtoConverter implements Converter<Game, GameDto> {


    @Override
    public GameDto convert(Game source) {
        return new GameDto(source.getGameId(), source.getSchedule().getId(), source.getGameDate(), source.getVenue(), source.getOpponent(), source.isFinalized());
    }
}
