package Entity;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by robin on 19/11/15.
 */
public class UserTest {

    @Test
    public void testBrowse() throws Exception {
        List<User> users = User.browse();

        assertTrue(users.size() > 0);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = User.getUser(1);

        assertTrue(user != null);
    }
}