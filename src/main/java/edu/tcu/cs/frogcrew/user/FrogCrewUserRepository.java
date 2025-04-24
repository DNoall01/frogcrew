package edu.tcu.cs.frogcrew.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrogCrewUserRepository extends JpaRepository<FrogCrewUser, Integer> {
}
