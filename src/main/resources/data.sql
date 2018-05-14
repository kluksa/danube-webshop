INSERT INTO tbl_user (id, username, password, enabled) values (1, 'prvi', '$2a$10$uKNzFDk6rppd4LVl5lWMSuezgVkr3c5fL4bTUji4E4ZnKY5McVozC', TRUE);
INSERT INTO tbl_user (id, username, password, enabled) values (2, 'drugi', '$2a$10$HTNRHCkRkKpi8j80eSCsTedTcwhVcA2ZQqT0WjxgjecoA73uQq.7a', TRUE);
INSERT INTO tbl_user (id, username, password, enabled) values (3, 'treci', '$2a$10$zB9BM1F4WypNzMUQ/GO1w.zxNPT9y5rAixAwP0QRLDH5Ozln3cnR2', TRUE);





INSERT INTO tbl_role (id, name) values (1, 'ROLE_ADMIN');
INSERT INTO tbl_role (id, name) values (2, 'ROLE_USER');

INSERT INTO user_has_roles (user_id, role_id) values (1, 1);
INSERT INTO user_has_roles (user_id, role_id) values (1, 2);
INSERT INTO user_has_roles (user_id, role_id) values (2, 2);
INSERT INTO user_has_roles (user_id, role_id) values (3, 1);


INSERT INTO tbl_product_category (id, name)  values (1, 'Prva kategorija');
INSERT INTO tbl_product_category (id, name)  values (2, 'Druga kategorija');
INSERT INTO tbl_product_category (id, name)  values (3, 'Treca kategorija');
INSERT INTO tbl_product_category (id, name)  values (4, 'Nekoristena kategorija');

INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (14, 'Cudni', 'veliki mali najmanji', 1, 'pictures/car.jpg', 1, '2010-01-01 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (1, 'Prvi 1', 'Prvi prvi 1', 1, 'pictures/car.jpg', 1, '2010-01-01 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (2, 'Prvi 2', 'Drugi prvi 2', 2, 'pictures/phone.jpg', 1, '2010-01-02 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (3, 'Prvi 3', 'Treci prvi 3', 3, 'pictures/computer.jpg', 2, '2010-01-03 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (4, 'Prvi 4', 'Prvi cetvrti 4', 1, 'pictures/car.jpg', 1, '2010-01-04 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (5, 'Prvi 5', 'Peti 5', 2, 'pictures/phone.jpg', 1, '2010-01-05 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (6, 'Prvi 6', 'Sesti 6', 3, 'pictures/computer.jpg', 1, '2010-01-06 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (7, 'Prvi 7', 'Peti 7', 1, 'pictures/car.jpg', 2, '2010-01-07 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (8, 'Prvi 8', 'Cetvrti 8', 3, 'pictures/phone.jpg', 1, '2010-01-08 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (9, 'Prvi 9', 'Drugi 9', 2, 'pictures/computer.jpg', 1, '2010-01-09 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (10, 'Prvi 10', 'Prvi prvi 10', 1, 'pictures/car.jpg', 1, '2010-01-10 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (11, 'Prvi 11', 'Prvi prvi 11', 3, 'pictures/phone.jpg', 2, '2010-01-11 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (12, 'Prvi 12', 'Prvi prvi 12', 2, 'pictures/computer.jpg', 1, '2010-01-12 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (13, 'Prvi 13', 'Prvi prvi 13', 1, 'pictures/car.jpg', 1, '2010-01-13 00:00:00');
