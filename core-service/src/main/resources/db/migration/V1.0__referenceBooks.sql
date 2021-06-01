CREATE TABLE parameter_type (
    id serial primary key,
    name varchar (50),
    creation timestamp not null,
    last_update timestamp,
    version int not null
);


CREATE TABLE languages (
    id serial primary key,
    name varchar (50)
);


CREATE TABLE currency (
    id serial primary key,
    name varchar (50),
    multyplier integer not null,
    creation timestamp not null,
    last_update timestamp,
    version int not null
);




