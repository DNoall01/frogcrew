package edu.tcu.cs.frogcrew.availability.converter;

import edu.tcu.cs.frogcrew.availability.Availability;
import edu.tcu.cs.frogcrew.availability.AvailabilityId;
import edu.tcu.cs.frogcrew.availability.dto.AvailabilityDto;
import edu.tcu.cs.frogcrew.game.GameRepository;
import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import edu.tcu.cs.frogcrew.user.UserRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityDtoToAvailabilityConverter implements Converter<AvailabilityDto, Availability> {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    public AvailabilityDtoToAvailabilityConverter(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
    }

    @Override
    public Availability convert(AvailabilityDto source) {
        Availability availability = new Availability();
        availability.setId(new AvailabilityId(source.userId(), source.gameId()));
        availability.setUser(userRepository.findById(source.userId()).orElseThrow(() -> new ObjectNotFoundException("user", source.userId())));
        availability.setGame(gameRepository.findById(source.gameId()).orElseThrow(() -> new ObjectNotFoundException("game", source.gameId())));
        availability.setAvailable(source.availability());
        availability.setComment(source.comment());
        return availability;
    }
}
