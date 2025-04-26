package edu.tcu.cs.frogcrew.creweduser.dto;

import java.time.LocalTime;

public record CrewedMemberDto(
        Integer crewMemberId,
        Integer userId,
        Integer gameId,
        String fullName,
        String position,
        LocalTime reportTime,
        String reportLocation
) {
}
