CREATE TABLE transport (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  owner BIGINT,
  cargo BIGINT,
  place_of_load BIGINT,
  time_of_load DATE,
  place_of_unload BIGINT,
  time_of_unload DATE,
  starting_price INT,
  current_price INT
);

CREATE TABLE cargo (
  cid BIGINT NOT NULL PRIMARY KEY  AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255),
  weight BIGINT,
  width DOUBLE,
  height DOUBLE,
  depth DOUBLE
);