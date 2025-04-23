package edu.tcu.cs.frogcrew.position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PositionServiceTest {

    @Mock
    PositionRepository positionRepository;

    @InjectMocks
    PositionService positionService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testFindAllPositionNamesSuccess() {}

    @Test
    void testFindAllPositionNamesNotFound() {}

    @Test
    void testSaveSuccess() {}

    @Test
    void testUpdateSuccess() {
    }

    @Test
    void testUpdateNotFound() {}

    @Test
    void testFindByPositionName() {}

    @Test
    void testFindByPositionNameNotFound() {}
}
