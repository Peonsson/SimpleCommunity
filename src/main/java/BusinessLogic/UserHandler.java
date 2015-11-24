package BusinessLogic;

import Entity.User;

import java.util.List;

/**
 * Created by robin on 9/11/15.
 */
public class UserHandler {

    public static boolean registerUser(String email, String username, String password, String firstname, String lastname, String country, String city) {
        System.out.println("Usr handler: email = " + email + "\nusername = " + username + "\npassword = " + password + "\nfirstname = " + firstname + "\nlastname = " + lastname + "\ncountry = " + country + "\ncity = " + city);
        User usr = new User(email, username, password, firstname, lastname, country, city);

        return User.register(usr);
    }

    public static int loginUser(String username, String password) {
        System.out.println("Usr handler: username = " + username + "\npassword = " + password);

        return User.login(username, password);
    }

    public static List<User> browse() {
        return User.browse();
    }

    public static User getUser(int id) {
        return User.getUser(id);
    }

    public static void addFriend() {
        User.addFriend();
    }
}
