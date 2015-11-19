package BusinessLogic;

import Entity.UserLog;

import java.util.List;

/**
 * Created by Peonsson on 11/11/15.
 */
public class LogHandler {

    public static boolean submit(int userId, String subject, String message) {

        return UserLog.submit(userId, subject, message);
    }

    public static List<UserLog> fetchLogs() {
        return UserLog.fetchLogs();
    }

    public static List<UserLog> fetchLogs(int id) {
        System.out.println("LogHandler: id : " + id);
        return UserLog.fetchLogs(id);
    }
}