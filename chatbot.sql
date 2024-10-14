CREATE DATABASE chatbot_db;
USE chatbot_db;

CREATE TABLE conversations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_query VARCHAR(255),
    chatbot_response VARCHAR(255),
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM conversations;
