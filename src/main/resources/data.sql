INSERT INTO tbl_user (id, username, password, enabled, created_by, created_at) values (1, 'prvi', '$2a$10$uKNzFDk6rppd4LVl5lWMSuezgVkr3c5fL4bTUji4E4ZnKY5McVozC', TRUE, 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_user (id, username, password, enabled, created_by, created_at) values (2, 'drugi', '$2a$10$HTNRHCkRkKpi8j80eSCsTedTcwhVcA2ZQqT0WjxgjecoA73uQq.7a', TRUE, 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_user (id, username, password, enabled, created_by, created_at) values (3, 'treci', '$2a$10$zB9BM1F4WypNzMUQ/GO1w.zxNPT9y5rAixAwP0QRLDH5Ozln3cnR2', TRUE, 'luksa', CURRENT_TIMESTAMP());





INSERT INTO tbl_role (id, name, created_by, created_at) values (1, 'ROLE_ADMIN', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_role (id, name, created_by, created_at) values (2, 'ROLE_USER', 'luksa', CURRENT_TIMESTAMP());

INSERT INTO user_has_roles (user_id, role_id) values (1, 1);
INSERT INTO user_has_roles (user_id, role_id) values (1, 2);
INSERT INTO user_has_roles (user_id, role_id) values (2, 2);
INSERT INTO user_has_roles (user_id, role_id) values (3, 1);


INSERT INTO tbl_product_category (id, name, created_by, created_at)  values (1, 'Prva kategorija', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_product_category (id, name, created_by, created_at)  values (2, 'Druga kategorija', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_product_category (id, name, created_by, created_at)  values (3, 'Treca kategorija', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_product_category (id, name, created_by, created_at)  values (4, 'Nekoristena kategorija', 'luksa', CURRENT_TIMESTAMP());

INSERT INTO tbl_item (name, description, category_id, picture_url, created_by, created_at)  values ('Cudni', 'veliki mali najmanji', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 1', 'Prvi prvi 1', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 2', 'Drugi prvi 2', 2, 'images/phone.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 3', 'Treci prvi 3', 3, 'images/computer.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 4', 'Prvi cetvrti 4', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 5', 'Peti 5', 2, 'images/phone.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 6', 'Sesti 6', 3, 'images/computer.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 7', 'Peti 7', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 8', 'Cetvrti 8', 3, 'images/phone.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 9', 'Drugi 9', 2, 'images/computer.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 10', 'Prvi prvi 10', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 11', 'Prvi prvi 11', 3, 'images/phone.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 12', 'Prvi prvi 12', 2, 'images/computer.jpg', 'luksa', CURRENT_TIMESTAMP());
INSERT INTO tbl_item ( name, description, category_id, picture_url, created_by, created_at)  values ( 'Prvi 13', 'Prvi prvi 13', 1, 'images/car.jpg', 'luksa', CURRENT_TIMESTAMP());
