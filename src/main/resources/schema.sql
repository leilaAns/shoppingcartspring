CREATE table item_table(id INT PRIMARY key ,name VARCHAR(60) ,type VARCHAR(60) ,description VARCHAR(100),price Long);
CREATE table user_table(role VARCHAR(60));
CREATE table client_table(client_id INT PRIMARY key,available_balance Long)