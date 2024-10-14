package Service;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Repository.Conversation;
import Repository.HibernateUtil;

import java.sql.Timestamp;
import java.util.List;

public class ConversationDAO {

    public void saveConversation(Conversation conversation) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession(); // Open a new session
            tx = session.beginTransaction();
            session.save(conversation); // Save the conversation
            tx.commit(); // Commit the transaction
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback(); // Rollback in case of an error
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Close the session
            }
        }
    }


    public Conversation getConversationWithDetails(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        Conversation conversation = null;
        try {
            conversation = session.get(Conversation.class, id);
            
        } finally {
            session.close(); 
        }
        return conversation;
    }

}