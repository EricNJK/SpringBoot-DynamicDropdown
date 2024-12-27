-- using "GENERATED ALWAYS AS IDENTITY" to replace "SERIAL"

/*
-- postgres create account :
CREATE ROLE gfg WITH
    LOGIN
    NOSUPERUSER
    CREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION
    NOBYPASSRLS
    CONNECTION LIMIT -1
    PASSWORD 'xxxxxx';
COMMENT ON ROLE gfg IS 'GeeksForGeeks practice account.';

-- postgres create database :
CREATE DATABASE kenya_counties
    WITH OWNER = gfg
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

COMMENT ON DATABASE kenya_counties
    IS 'Inaccurate sample data of counties, sub-counties and villages in Kenya.';
*/

-- county to replace district
CREATE TABLE county
(
    id          int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name        varchar(50),
    county_code varchar(4)
);
insert into county (name, county_code)
VALUES ('Mombasa', 1),
       ('Kwale', 2),
       ('Kilifi', 3),
       ('Tana River', 4),
       ('Lamu', 5);

-- sub_county to replace taluk
CREATE TABLE sub_county
(
    id              int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            varchar(50),
    sub_county_code varchar(4),
    county_code     varchar(4)
);

insert into sub_county (name, sub_county_code, county_code)
VALUES ('Changamwe', '11', '1'),
       ('Jomvu', '12', '1'),
       ('Kisauni', '13', '1'),
       ('Nyali', '14', '1'),
       ('Likoni', '15', '1'),

       ('Kinango', '21', '2'),
       ('Kubo', '22', '2'),
       ('Matuga', '23', '2'),
       ('Msambweni', '24', '2'),
       ('Shimba Hills', '25', '2'),

       ('Kaloleni', '31', '3'),
       ('Rabai', '32', '3'),
       ('Ganze', '33', '3'),
       ('Malindi', '34', '3'),
       ('Magarini', '35', '3'),

       ('Bangale', '41', '4'),
       ('Bura', '42', '4'),
       ('Galole', '43', '4'),
       ('Garsen', '44', '4'),
       ('Kipini', '45', '4'),

       ('Amu', '51', '5'),
       ('Faza', '52', '5'),
       ('Hindi', '53', '5'),
       ('Kiunga', '54', '5'),
       ('Kizingitini', '55', '5');

CREATE TABLE village
(
    id              int GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name            varchar(50),
    sub_county_code varchar(4)
);

insert into village (name, sub_county_code)
VALUES ('Bangladesh', '11'),
       ('Changamwe 1', '11'),
       ('Jomvu y', '12'),
       ('Jomvu x', '12'),
       ('Kisauni 1', '13'),
       ('Kisauni 2', '13'),
       ('Nyali a', '14'),
       ('Nyali b', '14'),
       ('Likoni A', '15'),
       ('Likoni B', '15'),

       ('Kinango N', '21'),
       ('Kinango S', '21'),
       ('Kubo E', '22'),
       ('Kubo W', '22'),
       ('Matuga q', '23'),
       ('Matuga r', '23'),
       ('Msambweni main', '24'),
       ('Msambweni hall', '24'),
       ('Shimba Hills mt', '25'),
       ('Shimba Hills pl', '25'),

       ('Kaloleni good', '31'),
       ('Kaloleni bad', '31'),
       ('Rabai up', '32'),
       ('Rabai down', '32'),
       ('in Ganze', '33'),
       ('near Ganze', '33'),
       ('Malindi beach', '34'),
       ('Malindi dry', '34'),
       ('Magarini margarita', '35'),
       ('Magarini sober', '35'),

       ('Bangale forest', '41'),
       ('Bangale desert', '41'),
       ('Bura open', '42'),
       ('Bura old', '42'),
       ('Galole city', '43'),
       ('Galole deep', '43'),
       ('Garsen hq', '44'),
       ('Garsen lake', '44'),
       ('Kipini N', '45'),
       ('Kipini S', '45'),

       ('Amu yangu', '51'),
       ('Amu yako', '51'),
       ('Gate Faza', '52'),
       ('Faza exit', '52'),
       ('Hindi camp', '53'),
       ('Hindi reserve', '53'),
       ('Kiunga booster', '54'),
       ('Kiunga hill', '54'),
       ('Kizingitini border', '55'),
       ('Kizingitini fence', '55');

