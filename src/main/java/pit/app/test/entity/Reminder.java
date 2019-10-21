package pit.app.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reminder", schema = "public")
public class Reminder implements Serializable{
    private static final long serialVersionUID = 4420453406378896673L;

    @GenericGenerator(name = "reminderSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "remindersSequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    @Id
    @GeneratedValue(generator = "reminderSequenceGenerator")
    private long id;
    @Column(name = "date_of_reminder", nullable = false, length = 50)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfReminder;
    @Column(name = "title", nullable = false, length = 50)
    private String title;
    @Column(name = "message", nullable = false, length = 50)
    private String message;
    @Column(name = "music", nullable = false, length = 50)
    private String music;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOfReminder() {
        return dateOfReminder;
    }

    public void setDateOfReminder(Date dateOfReminder) {
        this.dateOfReminder = dateOfReminder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
