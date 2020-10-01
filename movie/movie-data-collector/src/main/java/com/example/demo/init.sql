CREATE TABLE
	movie
	(id BIGINT NOT NULL,
	title STRING NOT NULL,
	PRIMARY KEY (id)
	);	
	
CREATE TABLE
	hibernate_sequence
	(next_val BIGINT );		
	
INSERT INTO movie (id,title) VALUES (1, 'testmovie');
INSERT INTO hibernate_sequence (next_val) VALUES (2);