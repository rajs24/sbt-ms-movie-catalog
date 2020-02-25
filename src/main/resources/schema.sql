DROP TABLE IF EXISTS MOVIE_RATING;
DROP TABLE IF EXISTS MOVIE_INFO;

-- create movie info table
CREATE TABLE MOVIE_INFO
(
   movie_id INT AUTO_INCREMENT PRIMARY KEY,
   movie_name VARCHAR (250) NOT NULL,
   movie_desc VARCHAR (250) NOT NULL
);

-- create movie rating table
CREATE TABLE MOVIE_RATING
(
   rating_id INT AUTO_INCREMENT PRIMARY KEY,
   user_id INT NOT NULL,
   movie_id INT NOT NULL,
   rating INT,
   foreign key (movie_id) references MOVIE_INFO (movie_id)
);