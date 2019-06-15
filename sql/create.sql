CREATE DATABASE db_bed;

USE db_bed;

CREATE TABLE Profiles
(
    id       INT(11)                NOT NULL AUTO_INCREMENT,
    login    VARCHAR(25)            NOT NULL UNIQUE,
    email    VARCHAR(128)           NOT NULL UNIQUE,
    name     VARCHAR(128)           NOT NULL,
    surname  VARCHAR(128)           NOT NULL,
    password VARCHAR(128)           NOT NULL,
    ip       VARCHAR(15),
    regstamp TIMESTAMP              NOT NULL DEFAULT now(),
    role     ENUM ('admin', 'user') NOT NULL,
    PRIMARY KEY (id)
);
INSERT INTO Profiles(login, email, name, surname, password, ip, role)
VALUES ('lukas', 'bed46@wp.pl', 'Lukasz', 'Bednarski', 'root', '255.255.255.12', 'user');
INSERT INTO Profiles(login, email, name, surname, password, ip, role)
VALUES ('pangeon', 'pangeon@tlen.pl', 'Kamil', 'Cecherz', 'root', '255.255.255.9', 'admin');

DESCRIBE Profiles;
SELECT * FROM Profiles;