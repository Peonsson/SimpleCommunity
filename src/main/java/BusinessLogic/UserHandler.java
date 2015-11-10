package BusinessLogic;

import Entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by robin on 9/11/15.
 */
public class UserHandler {

    public static boolean registerUser(String email, String username, String password, String firstname, String lastname, String country, String city) {
        System.out.println("Usr handler: email = " + email + "\nusername = " + username + "\npassword = " + password + "\nfirstname = " + firstname + "\nlastname = " + lastname + "\ncountry = " + country + "\ncity = " + city);

        User usr = new User(email, username, password, firstname, lastname, country, city);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usr);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }

        return true;
    }
}
