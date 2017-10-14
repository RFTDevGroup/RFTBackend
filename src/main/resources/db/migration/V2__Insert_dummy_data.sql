INSERT INTO user (id, user_name, password) VALUES (1, 'rftadmin', '$2a$12$BVFMhIW9BQJtg/niwjx1BOajHSfsspmsR4vmPSdymDabpophd7i.6');
INSERT INTO user (id, user_name, password) VALUES (2, 'rftuser', 'userpassword');

INSERT INTO role (id, name) VALUES (1, 'admin');
INSERT INTO role (id, name) VALUES (2, 'user');

INSERT INTO users_roles(id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO users_roles(id, user_id, role_id) VALUES (2, 1, 2);
INSERT INTO users_roles(id, user_id, role_id) VALUES (3, 2, 2);