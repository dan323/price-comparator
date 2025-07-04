CREATE TABLE if not exists "product" (
  "ean" bigint PRIMARY KEY,
  "name" varchar,
  "image" varchar
);

CREATE TABLE if not exists "shop" (
  "id" bigint PRIMARY KEY,
  "name" varchar,
  "homesite" varchar
);

CREATE TABLE if not exists "product_shop" (
  "product" bigint,
  "shop" bigint,
  "buy_url" varchar,
  PRIMARY KEY ("product", "shop")
);

CREATE TABLE if not exists "price_rel" (
  "product" bigint,
  "shop" bigint,
  "date" timestamptz(6),
  "price" numeric(5,2),
  PRIMARY KEY ("product", "shop", "date")
);

CREATE TABLE if not exists "product_name" (
  "product" bigint,
  "name" varchar,
  PRIMARY KEY ("product", "name")
);

CREATE TABLE if not exists "product_category" (
  "product" bigint,
  "category" bigint,
  PRIMARY KEY ("product", "category")
);

CREATE TABLE if not exists "shop_category" (
  "shop" bigint,
  "category" bigint,
  "shop_category_name" varchar,
  PRIMARY KEY ("shop", "category")
);

CREATE TABLE if not exists "category" (
  "id" bigint PRIMARY KEY,
  "name" varchar,
  "description" varchar
);

CREATE TABLE if not exists "subcategory" (
  "category" bigint,
  "subcategory" bigint,
  PRIMARY KEY ("category", "subcategory")
);

ALTER TABLE "price_rel" ADD FOREIGN KEY ("shop","product") REFERENCES "product_shop" ("shop", "product");

ALTER TABLE "subcategory" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");
ALTER TABLE "subcategory" ADD FOREIGN KEY ("subcategory") REFERENCES "category" ("id");

ALTER TABLE "product_category" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");
ALTER TABLE "product_category" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "product_name" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "shop_category" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");
ALTER TABLE "shop_category" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "product_shop" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");
ALTER TABLE "product_shop" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");

CREATE SEQUENCE IF NOT EXISTS shop_seq START WITH 1 INCREMENT BY 50;