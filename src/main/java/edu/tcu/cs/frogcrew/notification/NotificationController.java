package edu.tcu.cs.frogcrew.notification;

import edu.tcu.cs.frogcrew.system.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.endpoint.base-url}/notifications")
public class NotificationController {

    private final NotificationService notificationService;


    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{userId}")
    public Result findNotificationsByUserId(@PathVariable Integer userId) {
        return null;
    }

    @PutMapping("/{notificationId}")
    public Result markAsRead(@PathVariable Integer notificationId) {
        return null;
    }

    @DeleteMapping("/{notificationId}")
    public Result deleteNotification(@PathVariable Integer notificationId) {
        return null;
    }
}
