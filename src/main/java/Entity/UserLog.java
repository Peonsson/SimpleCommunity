package Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Peonsson and roppe546.
 *
 * This class represents a log entry that a user writes.
 */

@Entity
@Table(name = "UserLog")
public class UserLog {
    @Column(name = "UserLogId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userLogId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    @Column(name = "User")
    private User user;

    @Column(name = "Timestamp")
    @NotNull
    private Date timestamp;

    @Column(name = "Subject")
    @NotNull
    @Size(min = 3, max = 32, message = "Subject must be between 3 to 32 characters long.")
    private String subject;

    @Column(name = "Message")
    @NotNull
    @Size(min = 3, max = 128, message = "Message must be between 3 to 128 characters long.")
    private String message;

    public UserLog() {
        super();
    }

    /**
     * Constructor used to create a new UserLog entry.
     *
     * @param user      the user who wrote the entry
     * @param subject   the subject of the entry
     * @param message   the message itself
     */
    public UserLog(User user, String subject, String message) {
        this.user = user;
        this.timestamp = new Date();
        this.subject = subject;
        this.message = message;
    }

    public int getUserLogId() {
        return userLogId;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = user;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
