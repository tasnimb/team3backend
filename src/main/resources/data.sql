DROP TABLE IF EXISTS shows;

CREATE TABLE shows (
  id INT PRIMARY KEY,
  ShowName VARCHAR(250) NOT NULL,
  ShowCountry VARCHAR(250) NOT NULL,
  ShowCity VARCHAR(250) NOT NULL
);
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL
);
INSERT INTO shows (id, ShowName, ShowCountry, ShowCity) VALUES
  (1, 'Mare Of Easttown', 'USA', 'Pennsylvania'),
  (2, 'Chernobyl', 'Ukraine', 'Pripyat'),
  (3, 'Greys Anatomy', 'USA', 'Washington'),
  (4, 'Gangs Of London', 'United Kingdom','London'),
  (5, 'Bulletproof: South Africa', 'South Africa', 'Cape Town'),
  (6, 'Squid Game', 'South Korea', 'Daejeon');

INSERT INTO users (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES
  (1, 'first', 'last 1', 'abc1@gmail.com'),
  (2, 'first', 'last 2', 'abc2@gmail.com'),
  (3, 'first', 'last 3', 'abc3@gmail.com'),
  (4, 'first', 'last 4', 'abc4@gmail.com');