package edu.tcu.cs.frogcrew.crewlist;

import edu.tcu.cs.frogcrew.game.Game;
import edu.tcu.cs.frogcrew.game.GameRepository;
import edu.tcu.cs.frogcrew.crewlist.converter.GameToCrewListDtoConverter;
import edu.tcu.cs.frogcrew.crewlist.dto.CrewListDto;
import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CrewListService {

    private final GameRepository gameRepository;
    private final GameToCrewListDtoConverter gameToCrewListDtoConverter;

    public CrewListService(GameRepository gameRepository, GameToCrewListDtoConverter gameToCrewListDtoConverter) {
        this.gameRepository = gameRepository;
        this.gameToCrewListDtoConverter = gameToCrewListDtoConverter;
    }

    public CrewListDto findCrewListByGameId(Integer gameId) {
        Game game = this.gameRepository.findById(gameId).orElseThrow(() -> new ObjectNotFoundException("game", gameId));
        return gameToCrewListDtoConverter.convert(game);
    }
}
