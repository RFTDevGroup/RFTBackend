CREATE TABLE address (
  aid BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  city VARCHAR(100),
  country VARCHAR(100),
  house_no VARCHAR(100),
  street VARCHAR(100),
  zipcode VARCHAR(100),
);

CREATE TABLE user_details (
  udid BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  aid BIGINT
);