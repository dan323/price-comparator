create table if not exists product (
    id varchar,
    shopName varchar,
    name varchar not null,
    price double PRECISION,
    homeSite varchar,
    sendPrice double PRECISION,
    image varchar,
    CONSTRAINT product_pkey PRIMARY KEY (id, shopName)
);