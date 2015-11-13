package ViewModels;

/**
 * Created by Peonsson on 13/11/15.
 */
public class UserViewModel {

    private String username;
    private String firstname;
    private String lastname;
    private String country;
    private String city;

    public UserViewModel(String username, String firstname, String lastname, String country, String city) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
