package pit.app.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pit.app.test.entity.Reminder;
import pit.app.test.repository.ReminderRepository;
import pit.app.test.service.impl.ReminderServiceImpl;

import java.util.Date;
import java.util.List;

@Service
public class ReminderService implements ReminderServiceImpl {

    private final ReminderRepository reminderRepository;

    @Autowired
    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public List<Reminder> getAllReminder() {
        return reminderRepository.findAll();
    }

    @Override
    public Reminder getReminderById(long id) {
        return reminderRepository.findById(id).get();
    }

    @Override
    public Reminder saveReminder(Reminder reminder) {
        return reminderRepository.saveAndFlush(reminder);
    }

    @Override
    public void deleteReminder(long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public int updateReminder(Date dateOfReminder, String title, String message, String music, long id) {
        return reminderRepository.updateReminder(dateOfReminder, title, message, music, id);
    }
}
