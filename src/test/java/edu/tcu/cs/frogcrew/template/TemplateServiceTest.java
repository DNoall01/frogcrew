package edu.tcu.cs.frogcrew.template;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TemplateServiceTest {

    @Mock
    TemplateRepository templateRepository;

    @InjectMocks
    TemplateService templateService;

    @Test
    void testFindByIdSuccess() {}

    @Test
    void testFindByIdNotFound() {}

    @Test
    void testFindAllSuccess() {}

    @Test
    void testSaveSuccess() {}

    @Test
    void testUpdateSuccess() {}

    @Test
    void testUpdateNotFound() {}

    @Test
    void testDeleteSuccess() {}

    @Test
    void testDeleteNotFound() {}



}
