INSERT INTO customers (
    name, surname, age, phone_number)
VALUES ('Alexandr','Alexandrov','31','88115454'),
       ('Alexey','Alexandrov','21','465464654'),
       ('alexey','Alekseev','41','456454654'),
       ('Maxim','Alexandrov','31','88115454'),
       ('ALEXEY','Maximov','64','544545454');

INSERT INTO orders (
    date, customer_id, product_name, amount)
VALUES (
           '16.02.2023','1','orange','3'),
       ('16.02.2023','2','apple','5'),
       ('16.02.2023','3','paper','1'),
       ('16.02.2023','4','meat','2'),
       ('16.02.2023','5','carrot','4');