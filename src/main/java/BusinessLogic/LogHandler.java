package BusinessLogic;

import Entity.User;
import Entity.UserLog;

/**
 * Created by Peonsson on 11/11/15.
 */
public class LogHandler {

    public static boolean submit(String subject, String message) {

        return UserLog.submit(new UserLog(subject, message));
    }
}
