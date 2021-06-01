INSERT INTO parameter_type
(name, creation, last_update, version)
VALUES
('Electronic', current_date ,current_date ,1),
('Food', current_date ,current_date ,1);

INSERT INTO languages
(name)
VALUES
('English'),
('Russian');

INSERT INTO currency
(name, multyplier, creation, last_update, version)
VALUES
('RUB', 70, current_date, current_date, 1),
('DOLLAR', 1, current_date , current_date , 1);