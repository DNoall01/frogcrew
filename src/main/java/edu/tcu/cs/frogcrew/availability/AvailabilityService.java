package edu.tcu.cs.frogcrew.availability;


import edu.tcu.cs.frogcrew.schedule.ScheduleRepository;
import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import edu.tcu.cs.frogcrew.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
@Transactional
public class AvailabilityService {

    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(UserRepository userRepository, ScheduleRepository scheduleRepository, AvailabilityRepository availabilityRepository) {
        this.userRepository = userRepository;
        this.scheduleRepository = scheduleRepository;
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
        if (!userRepository.existsById(userId)) throw new ObjectNotFoundException("user", userId);
        if (!scheduleRepository.existsById(scheduleId)) throw new ObjectNotFoundException("schedule", scheduleId);
        return this.availabilityRepository.findByUserIdAndGameScheduleId(userId, scheduleId);
    }

    public List<Availability> findByUserIdAndSeason(Integer userId, String season){
        if (!userRepository.existsById(userId)) throw new ObjectNotFoundException("user", userId);
        return this.availabilityRepository.findByUserIdAndSeason(userId, season);
    }


}
