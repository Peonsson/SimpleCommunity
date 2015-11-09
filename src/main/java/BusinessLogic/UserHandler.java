package BusinessLogic;

/**
 * Created by robin on 9/11/15.
 */
public class UserHandler {

    public static boolean registerUser(String username, String password, String firstname, String lastname, String country, String city) {
        System.out.println("Usr handler: username = " + username + "\npassword = " + password + "\nfirstname = " + firstname + "\nlastname = " + lastname + "\ncountry = " + country + "\ncity = " + city);

        return true;
    }
}
