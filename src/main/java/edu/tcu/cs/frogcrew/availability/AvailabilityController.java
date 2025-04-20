package edu.tcu.cs.frogcrew.availability;

import edu.tcu.cs.frogcrew.availability.converter.AvailabilityDtoToAvailabilityConverter;
import edu.tcu.cs.frogcrew.availability.converter.AvailabilityToAvailabilityDtoConverter;
import edu.tcu.cs.frogcrew.availability.dto.AvailabilityDto;
import edu.tcu.cs.frogcrew.system.Result;
import edu.tcu.cs.frogcrew.system.StatusCode;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/availability")
public class AvailabilityController {

    private final AvailabilityService availabilityService;
    private final AvailabilityDtoToAvailabilityConverter availabilityDtoToAvailabilityConverter;
    private final AvailabilityToAvailabilityDtoConverter availabilityToAvailabilityDtoConverter;

    public AvailabilityController(AvailabilityService availabilityService, AvailabilityDtoToAvailabilityConverter availabilityDtoToAvailabilityConverter, AvailabilityToAvailabilityDtoConverter availabilityToAvailabilityDtoConverter) {
        this.availabilityService = availabilityService;
        this.availabilityDtoToAvailabilityConverter = availabilityDtoToAvailabilityConverter;
        this.availabilityToAvailabilityDtoConverter = availabilityToAvailabilityDtoConverter;
    }

    @PostMapping("")
    public Result addAvailability(@Valid @RequestBody AvailabilityDto availabilityDto) {
        Availability newAvailability = this.availabilityDtoToAvailabilityConverter.convert(availabilityDto);
        Availability savedAvailability = this.availabilityService.save(newAvailability);
        AvailabilityDto savedAvailabilityDto = this.availabilityToAvailabilityDtoConverter.convert(savedAvailability);
        return new Result(true, StatusCode.SUCCESS, "Add Success", savedAvailabilityDto);
    }

    @PutMapping("/{availabilityId}")
    public Result updateAvailability(@PathVariable AvailabilityId availabilityId, @Valid @RequestBody AvailabilityDto availabilityDto) {
        Availability update = this.availabilityDtoToAvailabilityConverter.convert(availabilityDto);
        Availability updatedAvailability = this.availabilityService.update(update, availabilityId);
        AvailabilityDto savedAvailabilityDto = this.availabilityToAvailabilityDtoConverter.convert(updatedAvailability);
        return new Result(true, StatusCode.SUCCESS, "Update Success", savedAvailabilityDto);
    }

    @GetMapping("/{userId}/schedule/{scheduleId}")
    public Result findAvailabilityByUserIdAndScheduleId(@PathVariable Integer userId, @PathVariable Integer scheduleId) {
        List<Availability> foundAvailabilities = this.availabilityService.findByUserIdAndScheduleId(userId, scheduleId);
        List<AvailabilityDto> availabilityDtos = foundAvailabilities.stream()
                .map(this.availabilityToAvailabilityDtoConverter::convert)
                .toList();
        return new Result(true, StatusCode.SUCCESS, "Find Success", availabilityDtos);
    }

    // TODO: Figure out solution to season recognition
    @GetMapping("/{userId}/season/{season}")
    public Result findAvailabilityByUserIdAndSeason(@PathVariable Integer userId, @PathVariable String season) {
        List<Availability> foundAvailability = this.availabilityService.findByUserIdAndSeason(userId, season);
        List<AvailabilityDto> availabilityDtos = foundAvailability.stream()
                .map(this.availabilityToAvailabilityDtoConverter::convert)
                .toList();
        return new Result(true, StatusCode.SUCCESS, "Find Success", availabilityDtos);
    }

}
