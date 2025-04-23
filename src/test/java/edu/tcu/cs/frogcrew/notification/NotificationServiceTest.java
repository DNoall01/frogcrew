package edu.tcu.cs.frogcrew.notification;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {

    @Mock
    NotificationRepository notificationRepository;

    @InjectMocks
    NotificationService notificationService;


    @Test
    void testFindByIdSuccess() {}

    @Test
    void testFindByIdNotFound() {}

    @Test
    void testFindNotificationByUserId() {}

    @Test
    void testFindNotificationByUserIdNotFound() {}

    @Test
    void testMarkAsReadSuccess() {}

    @Test
    void testDeleteSuccess() {}

    @Test
    void testDeleteNotFound() {}

}
