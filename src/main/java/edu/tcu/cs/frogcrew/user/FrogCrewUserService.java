package edu.tcu.cs.frogcrew.user;

import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FrogCrewUserService {

    private final FrogCrewUserRepository frogCrewUserRepository;

    public FrogCrewUserService(FrogCrewUserRepository frogCrewUserRepository) {
        this.frogCrewUserRepository = frogCrewUserRepository;
    }

    public FrogCrewUser findById(Integer id) {
        return this.frogCrewUserRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("user", id));
    }
}
