package Database;

import Entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

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

    public static User loginUser(String username, String password) {
        System.out.println("UserDB: GOT HERE");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        User user;
        try {

            Query query = em.createQuery("from User where username = :username");
            query.setParameter("username", username);
            List list = query.getResultList();
            user = (User)list.get(0);

//            System.out.println("UserDB user: " + user.getUsername());
//            System.out.println("UserDB pass: " + user.getPassword());

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
        return user;
    }

    public static List<User> browse() {
        System.out.println("UserDB: GOT HERE");
        List<User> users = new ArrayList<User>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from User");
            List list = query.getResultList();

            for (int i = 0; i < list.size(); i++) {
                users.add((User) list.get(i));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }

        System.out.println(users.toString());
        return users;
    }

    public static User getUser(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        User user = null;

        try {
            Query query = em.createQuery("from User where userId = :id");
            query.setParameter("id", id);
            user = (User) query.getSingleResult();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return user;
    }
}
