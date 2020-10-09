CREATE TABLE feedback (
        id BIGINT NOT NULL,
        user_id BIGINT,
        description VARCHAR,
        date_created DATETIME,
        date_last_changed DATETIME,
        PRIMARY KEY (id)
    );

CREATE TABLE hibernate_sequence (
        next_val BIGINT
    );

INSERT INTO feedback (id, user_id, description, date_created, date_last_changed)
  VALUES (1, 1, 'Bien', 4419619200000, 4419619200000);
INSERT INTO feedback (id, user_id, description, date_created, date_last_changed)
  VALUES (2, 1, 'Matig', 4419619200000, 4419619200000);
INSERT INTO feedback (id, user_id, description, date_created, date_last_changed)
  VALUES (3, 1, 'Goed', 4419619200000, 4419619200000);

INSERT INTO hibernate_sequence (next_val) VALUES (4);