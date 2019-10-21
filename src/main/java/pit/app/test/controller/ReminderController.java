package pit.app.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pit.app.test.entity.Reminder;
import pit.app.test.service.ReminderService;

import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    ReminderService reminderService;

    @RequestMapping(value = "/reminders", method = RequestMethod.GET)
    @ResponseBody
    public List<Reminder> getAllReminder() {
        return reminderService.getAllReminder();
    }

    @RequestMapping(value = "/reminder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reminder getReminderById(@PathVariable("id") long reminderId) {
        return reminderService.getReminderById(reminderId);
    }

    @RequestMapping(value = "/reminder/save", method = RequestMethod.POST)
    @ResponseBody
    public Reminder saveReminder(@RequestBody Reminder reminder) {
        return reminderService.saveReminder(reminder);
    }

    @RequestMapping(value = "/reminder/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteReminder(@PathVariable("id") long reminderId) {
        reminderService.deleteReminder(reminderId);
    }

    @RequestMapping(value = "/reminder/update", method = RequestMethod.POST)
    @ResponseBody
    public int updateReminder(@RequestBody Reminder reminder) {
        return reminderService.updateReminder(reminder.getDateOfReminder(), reminder.getTitle(),
                reminder.getMessage(), reminder.getMusic(), reminder.getId());
    }

}









