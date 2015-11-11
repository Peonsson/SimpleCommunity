package Entity;

import Database.UserDB;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Peonsson and roppe546.
 *
 * This class describes user entities in database.
 */

@Entity
@Table(name = "User")
public class User {
    @Column(name = "UserId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "Email", unique = true)
    @NotNull
    private String email;

    @Column(name = "Username", unique = true)
    @NotNull
    @Min(value = 3, message = "Username must be at least 3 characters long.")
    @Max(value = 32, message = "Username cannot be longer than 32 characters.")
    private String username;

    @Column(name = "Password")
    @Min(value = 3, message = "Password must be at least 3 characters long.")
    @Max(value = 128, message = "Password cannot be longer than 128 characters.")
    private String password;

    @Column(name = "Firstname")
    @NotNull
    @Min(value = 2, message = "First name must be at least 2 characters long.")
    @Max(value = 32, message = "First name cannot be longer than 32 characters.")
    private String firstname;

    @Column(name = "Lastname")
    @NotNull
    @Min(value = 2, message = "Last name must be at least 2 characters long.")
    @Max(value = 32, message = "Last name cannot be longer than 32 characters.")
    private String lastname;

    @Column(name = "Country")
    private String country;

    @Column(name = "City")
    private String city;

    public User() {
        super();
    }

    /**
     * Constructor used to create a user object.
     *
     * @param email     users email address
     * @param username  username
     * @param password  password
     * @param firstname users first name
     * @param lastname  users last name
     * @param country   country where user lives
     * @param city      city where user lives
     */
    public User(String email, String username, String password, String firstname, String lastname, String country, String city) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.city = city;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public static boolean register(User user) {
        return UserDB.registerUser(user);
    }

    public static boolean login(String username, String password) {
        return UserDB.loginUser(username, password);
    }
}
