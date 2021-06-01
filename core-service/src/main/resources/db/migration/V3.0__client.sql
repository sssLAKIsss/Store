CREATE TABLE client (
    id serial primary key,
    name varchar (50),
    phone varchar (12) not null,
    region varchar (30) not null,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);

INSERT INTO client
(name, phone, region, creation, last_update, version)
VALUES
('Boris', '+79999999999', 'Samara', current_date, current_date, 1);

