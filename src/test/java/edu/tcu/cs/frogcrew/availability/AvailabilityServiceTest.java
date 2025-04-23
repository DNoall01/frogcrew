package edu.tcu.cs.frogcrew.availability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AvailabilityServiceTest {

    @Mock
    AvailabilityRepository availabilityRepository;

    @InjectMocks
    AvailabilityService availabilityService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testSaveSuccess() {

    }

    @Test
    void testUpdateSuccess() {}

    @Test
    void testFindByUserIdAndScheduleIdSuccess() {}

    @Test
    void testFindByUserIdAndScheduleIdNotFound() {}

    @Test
    void testFindByUserIdAndSeasonSuccess() {}

    @Test
    void testFindByUserIdAndSeasonNotFound() {}

}
