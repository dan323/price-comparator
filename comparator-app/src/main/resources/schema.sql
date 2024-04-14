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

CREATE TABLE if not exists "priceRel" (
  "product" bigint,
  "shop" varchar,
  "date" timestamptz(6),
  "price" numeric(5,2),
  "buyUrl" varchar,
  PRIMARY KEY ("product", "shop", "date")
);

CREATE TABLE if not exists "productName" (
  "product" bigint PRIMARY KEY,
  "name" varchar
);

CREATE TABLE if not exists "productCategory" (
  "product" bigint PRIMARY KEY,
  "category" varchar
);

CREATE TABLE if not exists "shopCategory" (
  "shop" varchar,
  "category" varchar,
  "shopCategoryName" varchar,
  PRIMARY KEY ("shop", "category")
);

CREATE TABLE if not exists "category" (
  "id" varchar PRIMARY KEY,
  "categoryName" varchar
);

CREATE TABLE if not exists "subCategory" (
  "category" varchar PRIMARY KEY,
  "subcategory" varchar
);

ALTER TABLE "priceRel" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");

ALTER TABLE "priceRel" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "productCategory" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "subCategory" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "subCategory" ADD FOREIGN KEY ("subcategory") REFERENCES "category" ("id");

ALTER TABLE "productCategory" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");

ALTER TABLE "productName" ADD FOREIGN KEY ("product") REFERENCES "product" ("ean");

ALTER TABLE "shopCategory" ADD FOREIGN KEY ("shop") REFERENCES "shop" ("id");

ALTER TABLE "shopCategory" ADD FOREIGN KEY ("category") REFERENCES "category" ("id");