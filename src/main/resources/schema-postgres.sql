CREATE TABLE IF NOT EXISTS app_user (
    id       BIGSERIAL    PRIMARY KEY,
    rol_id    BIGINT       NOT NULL,
    name     VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product (
    id    BIGSERIAL    PRIMARY KEY,
    name  VARCHAR(255) NOT NULL,
    price FLOAT        NOT NULL,
    stock BIGINT       NOT NULL
);

CREATE TABLE IF NOT EXISTS wish (
    id         BIGSERIAL PRIMARY KEY,
    user_id    BIGINT    NOT NULL REFERENCES app_user(id),
    product_id BIGINT    NOT NULL REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS wish_history (
    id         BIGINT PRIMARY KEY,
    user_id    BIGINT,
    product_id BIGINT
);
