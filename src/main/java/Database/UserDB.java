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

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");

    public static boolean registerUser(User user) {
        System.out.println("UserDB: registerUser");

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            return false;
        }

        return true;
    }

    public static User loginUser(String username, String password) {
        System.out.println("UserDB: GOT loginUser");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        User user;
        try {

            Query query = em.createQuery("from User where username = :username");
            query.setParameter("username", username);
            List list = query.getResultList();
            user = (User) list.get(0);

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
        System.out.println("UserDB: GOT browse");
        List<User> users = new ArrayList<User>();

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
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
        System.out.println("UserDB: GOT getUser");

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        User user;
        try {

            Query query = em.createQuery("from User where userId = :id");
            query.setParameter("id", id);
            List list = query.getResultList();



            user = (User) list.get(0);
            System.out.println(user.toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
        return user;
    }

    public static void addFriend(User user, User otherUser) {
        EntityManager em = emf.createEntityManager();

        try {
            Query query = em.createQuery("from User where userId = :id");
            query.setParameter("id", user.getUserId());
            User thisUser = (User) query.getResultList().get(0);

            List<User> friends = thisUser.getFriends();
            System.out.println("UserDB: friends: " + friends.toString());

            for (User current : friends) {
                System.out.println("USerDB: otherUser : " + otherUser.toString());
                System.out.println("UserDB: current User: " + current.toString());
                if (current.equals(otherUser)) {
                    // If user already exists in list, don't add again
                    return;
                }
            }

            friends.add(otherUser);

            em.getTransaction().begin();
            em.persist(thisUser);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            em.close();
        }
    }
}