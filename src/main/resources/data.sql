INSERT INTO tbl_user (id, username, enabled) values (1, 'peric', TRUE);
INSERT INTO tbl_user (id, username, enabled) values (2, 'zderic', TRUE);
INSERT INTO tbl_user (id, username, enabled) values (3, 'seric', TRUE);

INSERT INTO tbl_role (id, name) values (1, 'admin');
INSERT INTO tbl_role (id, name) values (2, 'user');

INSERT INTO user_has_roles (user_id, role_id) values (1, 1);
INSERT INTO user_has_roles (user_id, role_id) values (1, 2);
INSERT INTO user_has_roles (user_id, role_id) values (2, 2);
INSERT INTO user_has_roles (user_id, role_id) values (3, 1);


INSERT INTO tbl_product_category (id, name)  values (1, 'Prva kategorija');
INSERT INTO tbl_product_category (id, name)  values (2, 'Druga kategorija');
INSERT INTO tbl_product_category (id, name)  values (3, 'Treca kategorija');

INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (1, 'Prvi 1', 'Prvi prvi 1', 1, 'url 1', 1, '2010-01-01 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (2, 'Prvi 2', 'Prvi prvi 2', 2, 'url 12', 1, '2010-01-02 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (3, 'Prvi 3', 'Prvi prvi 3', 3, 'url 13', 2, '2010-01-03 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (4, 'Prvi 4', 'Prvi prvi 4', 1, 'url 14', 1, '2010-01-04 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (5, 'Prvi 5', 'Prvi prvi 5', 2, 'url 15', 1, '2010-01-05 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (6, 'Prvi 6', 'Prvi prvi 6', 3, 'url 16', 1, '2010-01-06 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (7, 'Prvi 7', 'Prvi prvi 7', 1, 'url 17', 2, '2010-01-07 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (8, 'Prvi 8', 'Prvi prvi 8', 3, 'url 18', 1, '2010-01-08 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (9, 'Prvi 9', 'Prvi prvi 9', 2, 'url 19', 1, '2010-01-09 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (10, 'Prvi 10', 'Prvi prvi 10', 1, 'url 110', 1, '2010-01-10 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (11, 'Prvi 11', 'Prvi prvi 11', 3, 'url 111', 2, '2010-01-11 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (12, 'Prvi 12', 'Prvi prvi 12', 2, 'url 112', 1, '2010-01-12 00:00:00');
INSERT INTO tbl_item (id, name, description, category_id, picture_url, author_id, timestamp)  values (13, 'Prvi 13', 'Prvi prvi 13', 1, 'url 113', 1, '2010-01-13 00:00:00');
