package Repository;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_query")
    private String userQuery;

    @Column(name = "chatbot_response")
    private String chatbotResponse;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    // Default constructor
    public Conversation() {}

    // Parameterized constructor
    public Conversation(String userQuery, String chatbotResponse, Timestamp timestamp) {
        this.userQuery = userQuery;
        this.chatbotResponse = chatbotResponse;
        this.timestamp = timestamp;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserQuery() {
        return userQuery;
    }

    public void setUserQuery(String userQuery) {
        this.userQuery = userQuery;
    }

    public String getChatbotResponse() {
        return chatbotResponse;
    }

    public void setChatbotResponse(String chatbotResponse) {
        this.chatbotResponse = chatbotResponse;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
