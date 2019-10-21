package pit.app.test.service.impl;

import pit.app.test.entity.Reminder;

import java.util.Date;
import java.util.List;

public interface ReminderServiceImpl {
    List<Reminder> getAllReminder();

    Reminder getReminderById(long id);

    Reminder saveReminder(Reminder reminder);

    void deleteReminder(long id);

    int updateReminder(Date dateOfReminder, String title, String message, String music, long id);
}
