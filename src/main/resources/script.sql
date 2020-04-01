CREATE TABLE movies (id int, title varchar(255), runtime int, genre varchar(255), imdb_score float, rating varchar(255));
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (1, 'Howard The Duck', 110, 'Sci-Fi', 4.6, 'PG');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (2, 'Lavalantula', 83, 'Horror', 4.7, 'TV-14');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (3, 'Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (4, 'Waltz with Bashir', 90, 'Documentary', 8.0, 'R');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (5, 'Spaceballs', 96, 'Comedy', 7.1, 'PG');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (6, 'Monsters Inc', 92, 'Animation', 7.1, 'G');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (7, 'Whiplash', 106, 'Drama', 8.5, 'R');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (8, 'The Lion King', 88, 'Animation', 8.5, 'G');
INSERT INTO movies(id, title, runtime, genre, imdb_score, rating) VALUES (9, 'Old School', 88, 'Comedy', 7.1, 'R');

SELECT * FROM movies WHERE genre = 'Sci-Fi';
SELECT * FROM movies WHERE imdb_score  > 6.4;
SELECT * FROM movies WHERE rating IN ('G', 'PG') AND runtime < 100;
SELECT AVG(runtime), genre FROM movies WHERE imdb_score < 7.5 GROUP BY genre;
UPDATE movies SET rating = 'R' WHERE title = 'Starship Troopers';
SELECT id, rating FROM movies WHERE genre IN ('Horror', 'Documentary');
SELECT rating, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY rating;
SELECT rating, AVG(imdb_score), MAX(imdb_score), MIN(imdb_score) FROM movies GROUP BY rating HAVING COUNT(*) > 1;
DELETE FROM movies WHERE rating = 'R';

