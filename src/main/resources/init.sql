CREATE DATABASE IF NOT EXISTS onlineclass;

CREATE TABLE IF NOT EXISTS roles
(
    id SERIAL PRIMARY KEY,
    description CHARACTER VARYING(30)
);

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY,
    last_name CHARACTER VARYING(30),
    first_name CHARACTER VARYING(30),
    middle_name CHARACTER VARYING(30),
    email CHARACTER VARYING(30),
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS classes
(
    id BIGSERIAL PRIMARY KEY,
    name CHARACTER VARYING(30),
    is_active BOOLEAN,
    code CHARACTER VARYING(30)
);

CREATE TABLE IF NOT EXISTS users_to_classes
(
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT, FOREIGN KEY (user_id) REFERENCES users(id),
    class_id BIGINT, FOREIGN KEY (class_id) REFERENCES classes(id),
    role_id INT, FOREIGN KEY (role_id) REFERENCES roles(id),
    is_active BOOLEAN
);