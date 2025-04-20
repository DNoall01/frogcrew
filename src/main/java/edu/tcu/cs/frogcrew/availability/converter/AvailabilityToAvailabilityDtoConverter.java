package edu.tcu.cs.frogcrew.availability.converter;

import edu.tcu.cs.frogcrew.availability.Availability;
import edu.tcu.cs.frogcrew.availability.dto.AvailabilityDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityToAvailabilityDtoConverter implements Converter<Availability, AvailabilityDto> {

    @Override
    public AvailabilityDto convert(Availability source) {
        return new AvailabilityDto(source.getUser().getId(), source.getGame().getGameId(), source.isAvailable(), source.getComment());
    }

}
