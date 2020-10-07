CREATE TABLE user (
        id BIGINT NOT NULL,
        first_name VARCHAR,
        last_name VARCHAR,
        email VARCHAR,
        date_created DATETIME,
        date_last_changed DATETIME,
        PRIMARY KEY (id)
    );

CREATE TABLE hibernate_sequence (
        next_val BIGINT
    );

INSERT INTO user (id, first_name, last_name, email, date_created, date_last_changed)
  VALUES (1, 'roy', 'deprins', 'roy@user.com', 4419619200000, 4419619200000);
INSERT INTO user (id, first_name, last_name, email, date_created, date_last_changed)
  VALUES (2, 'tom', 'deconinck', 'tom@user.com', 4419619200000, 4419619200000);
INSERT INTO user (id, first_name, last_name, email, date_created, date_last_changed)
  VALUES (3, 'jasper', 'maes', 'jasper@user.com', 4419619200000, 4419619200000);

INSERT INTO hibernate_sequence (next_val) VALUES (4);