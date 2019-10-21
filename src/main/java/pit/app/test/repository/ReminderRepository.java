package pit.app.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pit.app.test.entity.Reminder;

import java.util.Date;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {
    @Modifying
    @Transactional
    @Query("update Reminder r set r.dateOfReminder = ?1, r.title = ?2, r.message = ?3, r.music = ?4"+
            " where r.id = ?5")
    int updateReminder(Date dateOfReminder, String title, String message, String music, long id);
}
