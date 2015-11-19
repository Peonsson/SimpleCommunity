package Database;

import Entity.PrivateMessage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Peonsson on 19/11/15.
 */
public class PrivateMessageDB {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("SimpleCommunity");


    public static boolean submit(PrivateMessage pm) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(pm);
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
}
