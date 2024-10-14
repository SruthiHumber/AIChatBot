package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import Repository.Conversation;
import Repository.HibernateUtil;
import Service.ConversationDAO;

/**
 * Servlet implementation class ChatServlet
 */
public class ChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ConversationDAO conversationDAO = new ConversationDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userQuery = request.getParameter("query");

        String chatbotResponse = simulateResponse(userQuery);

        // Store conversation in the database
        Conversation conversation = new Conversation();
        conversation.setUserQuery(userQuery);
        conversation.setChatbotResponse(chatbotResponse);
        conversation.setTimestamp(new Timestamp(System.currentTimeMillis()));
        conversationDAO.saveConversation(conversation);
        request.setAttribute("conversation", conversation);
        RequestDispatcher dispatcher = request.getRequestDispatcher("chatbot.jsp");
        dispatcher.forward(request, response);
    }

    private String simulateResponse(String query) {
        // Simulate responses 
        if (query.toLowerCase().contains("hello")) {
            return "Hi! Nice to meet you.";
        } else if (query.toLowerCase().contains("day")) {
            return "It's Sunday!";
        } else {
            return "I don't know";
        }
    }

}