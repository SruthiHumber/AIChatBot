<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chatbot Interface</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #647c90;
            color: #ede4e3; 
        }
        .conversation-box {
            border: 1px solid #ccc; 
            background-color: #e2ded0; 
            padding: 15px;
            margin: 10px 0;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .user-query {
            color: #000; 
            font-weight: bold;
        }
        .form-control {
            background-color: #e2ded0; 
        }
        .chatbot-response {
            color: #555; 
        }
        .timestamp {
            color: #888; 
            font-size: 0.85em; 
        }
        .btn-primary {
            background-color: #343a40; 
            border: none; 
        }
        .btn-primary:hover {
            background-color: #495057; 
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">AI Chatbot</h1>
        <form action="ChatServlet" method="post" class="mb-4">
            <div class="input-group">
                <input type="text" name="query" class="form-control" placeholder="Ask me anything" required />
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">Ask</button>
                </div>
            </div>
        </form>
        <h2 class="text-center">Chat History</h2>
        <div class="mb-4">
            <c:forEach var="conversation" items="${conversations}">
                <div class="conversation-box">
                    <p class="user-query">You: ${conversation.userQuery}</p>
                    <p class="chatbot-response">Bot: ${conversation.chatbotResponse}</p>
                    <p class="timestamp">At: ${conversation.timestamp}</p>
                </div>
            </c:forEach>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>