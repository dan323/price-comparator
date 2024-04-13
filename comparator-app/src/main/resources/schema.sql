create table if not exists product (
    id varchar primary key,
    shopName varchar primary key,
    name varchar not null,
    price double,
    homeSite varchar,
    sendPrice double,
    image varchar
);