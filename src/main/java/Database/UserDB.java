package Database;

import Entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by robin on 11/11/15.
 */
public class UserDB {
    public static boolean registerUser(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            em.close();
            return false;
        }

        return true;
    }

    public static boolean loginUser(String username, String password) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            em.persist(user);
//            em.getTransaction().commit();
//        }
//        catch (Exception e) {
//            em.close();
//            return false;
//        }

        return true;
    }
}
