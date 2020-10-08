CREATE TABLE rating (
        id BIGINT NOT NULL,
        user_id BIGINT,
        movie_id BIGINT,
        rating INT,
        date_created DATETIME,
        date_last_changed DATETIME,
        PRIMARY KEY (id)
    );

CREATE TABLE hibernate_sequence (
        next_val BIGINT
    );

INSERT INTO rating (id, user_id, movie_id, rating, date_created, date_last_changed)
  VALUES (1, 1, 1, 8, 4419619200000, 4419619200000);
INSERT INTO rating (id, user_id, movie_id, rating, date_created, date_last_changed)
  VALUES (2, 1, 2, 7, 4419619200000, 4419619200000);
INSERT INTO rating (id, user_id, movie_id, rating, date_created, date_last_changed)
  VALUES (3, 1, 3, 9, 4419619200000, 4419619200000);

INSERT INTO hibernate_sequence (next_val) VALUES (4);