package Database;

import Entity.User;
import Entity.UserLog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Peonsson on 11/11/15.
 */
public class LogDB {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");

    public static boolean submit(UserLog log) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.close();
            return false;
        } finally {
            em.close();
            return true;
        }
    }

    public static List<UserLog> fetchLogs(User user) {

        EntityManager em = emf.createEntityManager();

        Query query = em.createQuery("from UserLog where user = :user");
        query.setParameter("user", user);
        return query.getResultList();
    }
}
