CREATE TABLE if not exists "product" (
  "ean" bigint PRIMARY KEY,
  "name" varchar,
  "image" varchar
);

CREATE TABLE if not exists "shop" (
  "id" varchar PRIMARY KEY,
  "name" varchar,
  "homesite" varchar
);

CREATE TABLE if not exists "price_rel" (
  "product" bigint,
  "shop" varchar,
  "date" timestamptz(6),
  "price" numeric(5,2),
  "buy_url" varchar,
  PRIMARY KEY ("product", "shop", "date")
);

CREATE TABLE if not exists "product_name" (
  "product" bigint PRIMARY KEY,
  "name" varchar
);

CREATE TABLE if not exists "product_category" (
  "product" bigint PRIMARY KEY,
  "category" varchar
);

CREATE TABLE if not exists "shop_category" (
  "shop" varchar,
  "category" varchar,
  "shop_category_name" varchar,
  PRIMARY KEY ("shop", "category")
);

CREATE TABLE if not exists "category" (
  "id" varchar PRIMARY KEY,
  "name" varchar
);

CREATE TABLE if not exists "subcategory" (
  "category" varchar PRIMARY KEY,
  "subcategory" varchar
);

ALTER TABLE "price_rel" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");

ALTER TABLE "price_rel" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "product_category" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "subcategory" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "subcategory" ADD FOREIGN KEY ("subcategory") REFERENCES "category" ("id");

ALTER TABLE "product_category" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "product_name" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "shop_category" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");

ALTER TABLE "shop_category" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");