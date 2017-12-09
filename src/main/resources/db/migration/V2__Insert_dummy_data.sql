INSERT INTO user (id, user_name, active, password, udid) VALUES (1, 'rftadmin', true, '$2a$12$BVFMhIW9BQJtg/niwjx1BOajHSfsspmsR4vmPSdymDabpophd7i.6', 1);
INSERT INTO user (id, user_name, active, password, udid) VALUES (2, 'rftuser', true, '$2a$12$BVFMhIW9BQJtg/niwjx1BOajHSfsspmsR4vmPSdymDabpophd7i.6', 2);

INSERT INTO role (id, name) VALUES (1, 'admin');
INSERT INTO role (id, name) VALUES (2, 'user');

INSERT INTO users_roles(id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO users_roles(id, user_id, role_id) VALUES (2, 1, 2);
INSERT INTO users_roles(id, user_id, role_id) VALUES (3, 2, 2);

INSERT INTO address(aid, country, city, street, house_no, zipcode) VALUES (1, 'Hungary', 'Nyiregyhaza', 'Bodrogi', '19', '4551');
INSERT INTO address(aid, country, city, street, house_no, zipcode) VALUES (2, 'Hungary', 'Nyiregyhaza', 'Filler', '62/A', '4400');

INSERT INTO user_details(udid, first_name, last_name, email, aid) VALUES (1, 'Mark', 'Budai', 'admin@transporthub.com', 1);
INSERT INTO user_details(udid, first_name, last_name, email, aid) VALUES (2, 'John', 'Doe', 'johndoe@transporthub.com', 2);