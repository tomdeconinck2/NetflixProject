CREATE TABLE users (
        id BIGINT NOT NULL,
        firstName VARCHAR,
        lastName VARCHAR,
        email VARCHAR,
        dateCreated DATETIME,
        dateLastChanged DATETIME,
        PRIMARY KEY (id)
    );

CREATE TABLE hibernate_sequence (
        next_val BIGINT
    );

INSERT INTO bike (id, firstname, lastname, email, dateCreated, dateLastChanged)
  VALUES (1, 'roy', 'deprins', 'roy@user.com', 4419619200000, 4419619200000);
INSERT INTO bike (id, firstname, lastname, email, dateCreated, dateLastChanged)
  VALUES (2, 'tom', 'deconinck', 'tom@user.com', 4419619200000, 4419619200000);
INSERT INTO bike (id, firstname, lastname, email, dateCreated, dateLastChanged)
  VALUES (1, 'jasper', 'maes', 'jasper@user.com', 4419619200000, 4419619200000);

INSERT INTO hibernate_sequence (next_val) VALUES (4);