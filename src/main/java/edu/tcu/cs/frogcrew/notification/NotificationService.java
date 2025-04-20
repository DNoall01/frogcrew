package edu.tcu.cs.frogcrew.notification;

import edu.tcu.cs.frogcrew.system.exception.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public Notification findById(Integer notificationId) {
        return notificationRepository.findById(notificationId).orElseThrow(() -> new ObjectNotFoundException("notification", notificationId));
    }

    public List<Notification> findNotificationsByUserId(Integer userId) {
        return notificationRepository.findByUserId(userId);
    }

    public Notification markAsRead(Integer notificationId) {
        Notification notification = this.notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ObjectNotFoundException("notification", notificationId));
        notification.setRead(true);
        return this.notificationRepository.save(notification);
    }

    public void delete(Integer notificationId) {
        this.notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ObjectNotFoundException("notification", notificationId));
        this.notificationRepository.deleteById(notificationId);
    }
}
