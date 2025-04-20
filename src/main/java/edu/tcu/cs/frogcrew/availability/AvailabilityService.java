package edu.tcu.cs.frogcrew.availability;


import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@Transactional
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }


    public Availability save(Availability availability) {
        return this.availabilityRepository.save(availability);
    }


    public Availability update(Availability updatedAvailability, AvailabilityId availabilityId) {
        return this.availabilityRepository.findById(availabilityId)
                .map(oldAvailability -> {
                    oldAvailability.setAvailable(updatedAvailability.isAvailable());
                    oldAvailability.setComment(updatedAvailability.getComment());
                    return availabilityRepository.save(oldAvailability);
                })
                .orElseThrow(() -> new ObjectNotFoundException("availability", availabilityId.getUserId(), availabilityId.getGameId()));
    }

    public List<Availability> findByUserIdAndScheduleId(Integer userId, Integer scheduleId) {
        return this.availabilityRepository.findByUserIdAndGameScheduleId(userId, scheduleId);
    }

    public List<Availability> findByUserIdAndSeason(Integer userId, String season){
        return this.availabilityRepository.findByUserIdAndSeason(userId, season);
    }


}
