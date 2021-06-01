CREATE TABLE products (
    id serial primary key,
    title varchar (50) not null,
    price_ue integer not null,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);


CREATE TABLE parameter (
    id serial primary key,
    parameter_type_id integer REFERENCES parameter_type (id),
    product_id integer REFERENCES products (id)  ON UPDATE RESTRICT ON DELETE CASCADE
);


CREATE TABLE info (
    id serial primary key,
    title varchar (50) not null,
    description varchar (255),
    product_id integer REFERENCES products (id)  ON UPDATE RESTRICT ON DELETE CASCADE ,
    language_id integer REFERENCES languages (id)
);

INSERT INTO products
(title, price_ue, creation, last_update, version)
VALUES
('GOOGLE PIXEL', 1000, current_date, current_date, 1),
('Iphone 12 pro', 1100, current_date, current_date, 1);

INSERT INTO info
(title, description, product_id, language_id)
VALUES
('Description Google pixel', 'Best smartphone ever', 1, 1),
('Description Google pixel', 'Действительно крутой смартфон', 1, 2),
('Description Iphone 12 Pro', 'Not best smartphone ever', 2, 1);

INSERT INTO parameter
(parameter_type_id, product_id)
VALUES
(1, 1),
(1, 2);
