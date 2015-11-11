package Database;

import Entity.UserLog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Peonsson on 11/11/15.
 */
public class LogDB {

    public static boolean submit(UserLog log) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(log);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage();
        } finally {
            em.close();
        }
    }
}
