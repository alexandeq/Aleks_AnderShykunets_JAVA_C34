CREATE TABLE movies (
    id UUID PRIMARY KEY,
     title VARCHAR(255) NOT NULL,
      year INT NOT NULL,
      description TEXT,
      rating FLOAT DEFAULT 0

);

 CREATE TABLE comments (
     id UUID PRIMARY KEY,
     movie_id UUID NOT NULL,
     comment TEXT,
     rating FLOAT CHECK (rating >= 1 AND rating <= 10),
     CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES movies (id) ON DELETE CASCADE
 );


 CREATE TABLE posters (
     id UUID PRIMARY KEY,
     image BYTEA NOT NULL,
     movie_id UUID NOT NULL UNIQUE,
     CONSTRAINT fk_movie
         FOREIGN KEY(movie_id)
         REFERENCES movies(id)
         ON DELETE CASCADE
 );

