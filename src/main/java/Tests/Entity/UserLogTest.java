package Entity;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by robin on 24/11/15.
 */
public class UserLogTest {
    @Test
    public void testCreateNewLogEntrySuccess() throws Exception {
        boolean success = UserLog.submit(13, "test", "test");

        assertTrue(success);
    }

    @Test
    public void testCreateNewLogEntryFail() throws Exception {
        boolean success = UserLog.submit(-1, "test", "test");

        assertTrue(!success);
    }

    @Test
    public void testFetchUserLogsSuccess() throws Exception {
        User user = User.getUser(13);
        List<UserLog> logs = UserLog.fetchLogs(user.getUserId());

        assertTrue(logs.size() > 0);
    }
}
