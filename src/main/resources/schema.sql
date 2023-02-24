CREATE TABLE customers
(
    id serial PRIMARY KEY,
    name text NOT NULL,
    surname text NOT NULL,
    age bigint NOT NULL,
    phone_number bigint NOT NULL
);

	CREATE TABLE orders
(
    id serial PRIMARY KEY,
    date DATE NOT NULL,
    customer_id bigint NOT NULL,
    product_name text NOT NULL,
    amount bigint NOT NULL
);
