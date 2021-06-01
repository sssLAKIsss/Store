INSERT INTO card
(client_id, currency_id, creation, last_update, version)
VALUES
(1, 1, current_date, current_date, 1);


INSERT INTO card_product
(card_id, product_id, quantity, creation, last_update, version)
VALUES
(1, 1, 2, current_date, current_date, 1),
(1, 2, 2, current_date, current_date, 1);

INSERT INTO shipment
(card_id, address, creation, last_update, version)
VALUES
(1, 'GOGOL9 106', current_date, current_date, 1);