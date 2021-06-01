CREATE TABLE card (
    id serial primary key,
    client_id integer references client (id) on delete cascade,
    currency_id integer references currency (id) on delete cascade,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);


CREATE TABLE shipment (
    id serial primary key,
    card_id integer references card (id) on delete cascade,
    address varchar (255) not null,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);


CREATE TABLE card_product (
    id serial primary key,
    card_id integer references card (id) on delete cascade,
    product_id integer references products (id) on delete cascade,
    quantity integer not null,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);

