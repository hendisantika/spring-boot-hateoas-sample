CREATE TABLE car
(
    id      bigint AUTO_INCREMENT NOT NULL,
    name    varchar(255),
    plate   varchar(255)          NOT NULL,
    user_id bigint,
    PRIMARY KEY (id)
);

CREATE TABLE director
(
    id        bigint AUTO_INCREMENT NOT NULL,
    firstname varchar(255),
    lastname  varchar(255),
    year      integer               NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movie
(
    id          bigint AUTO_INCREMENT NOT NULL,
    rating      integer,
    title       varchar(255),
    year        integer               NOT NULL,
    director_id bigint,
    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id      bigint AUTO_INCREMENT NOT NULL,
    address varchar(255),
    code    varchar(255)          NOT NULL,
    name    varchar(255),
    surname varchar(255),
    PRIMARY KEY (id)
);

ALTER TABLE car
    ADD CONSTRAINT UK_pvp69n7acjyr5racokd4pdr4t UNIQUE (plate);

ALTER TABLE user
    ADD CONSTRAINT UK_h1vneshxbwkd1ailk02vdy2qu UNIQUE (code);

ALTER TABLE car
    ADD CONSTRAINT FKja1j4mm4rqlv6cnhgp1qqgtuj
        FOREIGN KEY (user_id)
            REFERENCES user (id);

ALTER TABLE movie
    ADD CONSTRAINT FKbi47w3cnsfi30gc1nu2avgra2
        FOREIGN KEY (director_id)
            REFERENCES director (id);

CREATE TABLE hibernate_sequence
(
    next_val bigint
) ENGINE = InnoDB;

INSERT INTO hibernate_sequence
VALUES (1);
