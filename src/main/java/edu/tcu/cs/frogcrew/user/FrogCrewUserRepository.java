package edu.tcu.cs.frogcrew.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrogCrewUserRepository extends JpaRepository<FrogCrewUser, Integer> {
    public List<FrogCrewUser> findFrogCrewUsersByQualifiedPositionsContaining(String position);
}
