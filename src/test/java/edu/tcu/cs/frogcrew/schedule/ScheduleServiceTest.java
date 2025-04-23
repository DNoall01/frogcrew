package edu.tcu.cs.frogcrew.schedule;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ScheduleServiceTest {

    @Mock
    ScheduleRepository scheduleRepository;

    @InjectMocks
    ScheduleService scheduleService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testFindByIdSuccess() {}

    @Test
    void testFindByIdNotFound() {}

    @Test
    void testFindBySeasonSuccess() {
    }


    @Test
    void testFindBySeasonNotFound() {}

    @Test
    void testAddGameToScheduleSuccess() {}

    @Test
    void testAddGameToScheduleNotFound() {}

    @Test
    void testSaveSuccess() {}

    @Test
    void testUpdateSuccess() {}

    @Test
    void testUpdateNotFound() {}

    @Test
    void testGetAllSports() {}


}
