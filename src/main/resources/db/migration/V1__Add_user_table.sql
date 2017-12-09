CREATE TABLE user (
  id         BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  user_name VARCHAR(100),
  password  VARCHAR(255),
  active BOOLEAN,
  udid BIGINT
);