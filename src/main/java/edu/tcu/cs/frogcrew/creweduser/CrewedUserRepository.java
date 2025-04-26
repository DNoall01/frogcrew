package edu.tcu.cs.frogcrew.creweduser;

import edu.tcu.cs.frogcrew.user.FrogCrewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewedUserRepository extends JpaRepository<CrewedUser, Integer> {
    List<CrewedUser> findByUser(FrogCrewUser user);

    CrewedUser findByUser_Id(Integer userId);

    List<CrewedUser> findByGame_GameId(Integer gameId);

}
