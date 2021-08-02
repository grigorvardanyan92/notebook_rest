DROP TABLE IF EXISTS note;
DROP TABLE IF EXISTS category;

CREATE TABLE category
(
    id   BIGSERIAL    NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE note
(
    id           BIGSERIAL NOT NULL PRIMARY KEY,
    category_id  BIGINT    NOT NULL REFERENCES category (id),
    text         TEXT,
    is_completed BOOLEAN   NOT NULL
);

INSERT INTO category (name)
VALUES ('work'),
       ('home'),
       ('studies'),
       ('personal');

INSERT INTO note (category_id, text, is_completed)
VALUES (1, 'test text', false);