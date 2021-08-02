DROP TABLE IF EXISTS note;
DROP TABLE IF EXISTS "user";
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE role
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE "user"
(
    id       BIGSERIAL    NOT NULL PRIMARY KEY,
    role_id  BIGINT       NOT NULL REFERENCES role (id),
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE note
(
    id           BIGSERIAL NOT NULL PRIMARY KEY,
    category_id  BIGINT    NOT NULL REFERENCES category (id),
    user_id      BIGINT    NOT NULL REFERENCES "user" (id),
    text         TEXT,
    is_completed BOOLEAN   NOT NULL
);

INSERT INTO category (name)
VALUES ('work'),
       ('home'),
       ('studies'),
       ('personal');

INSERT INTO role (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');

INSERT INTO "user" (role_id, username, password)
VALUES (1, 'user', '1234'),
       (2, 'admin', '1234');

INSERT INTO note (category_id, user_id, text, is_completed)
VALUES (1, 1, 'first text', false),
       (2, 1, 'second text', false);