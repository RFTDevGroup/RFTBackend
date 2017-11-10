CREATE TABLE transport (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  owner BIGINT,
  cargo BIGINT,
  place_of_load BIGINT,
  time_of_load TIMESTAMP,
  place_of_unload BIGINT,
  time_of_unload TIMESTAMP,
  starting_price INT,
  current_price INT
);

CREATE TABLE cargo (
  cid BIGINT NOT NULL PRIMARY KEY  AUTO_INCREMENT
);