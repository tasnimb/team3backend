DROP TABLE IF EXISTS shows;
DROP TABLE IF EXISTS users;

CREATE TABLE shows (
  id INT PRIMARY KEY,
  ShowName VARCHAR(250) NOT NULL,
  ShowCountry VARCHAR(250) NOT NULL,
  ShowCity VARCHAR(250) NOT NULL,
  showLatitude VARCHAR(250) NOT NULL,
  showLongitude VARCHAR(250) NOT NULL
);

CREATE TABLE users (
  id INT PRIMARY KEY,
  FIRST_NAME VARCHAR(250) NOT NULL,
  LAST_NAME VARCHAR(250) NOT NULL,
  EMAIL VARCHAR(250) NOT NULL
);
INSERT INTO shows (id, ShowName, ShowCountry, ShowCity, showLatitude, showLongitude) VALUES
  (1, 'Mare Of Easttown', 'USA', 'Pennsylvania', '41.2033', '77.1945'),
  (2, 'Chernobyl', 'Ukraine', 'Pripyat', '51.2763', '30.2219'),
  (3, 'Greys Anatomy', 'USA', 'Washington', '47.7511', '120.7401'),
  (4, 'Gangs Of London', 'United Kingdom','London', '51.5072', '0.1276'),
  (5, 'Bulletproof: South Africa', 'South Africa', 'Cape Town', '-33.918861', '18.423300'),
  (6, 'Squid Game', 'South Korea', 'Daejeon', '36.351002', '127.385002');

INSERT INTO users (ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES
  (1, 'first', 'last 1', 'abc1@gmail.com'),
  (2, 'first', 'last 2', 'abc2@gmail.com'),
  (3, 'first', 'last 3', 'abc3@gmail.com'),
  (4, 'first', 'last 4', 'abc4@gmail.com');