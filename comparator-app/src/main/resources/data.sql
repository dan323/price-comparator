-- Categories
insert into category(id,name,description) values
(1,'Eurogame','Posicionamiento de meeples'),
(2,'War','Guerra'),
(3,'Abstract','Abstracto'),
(4,'Cards','Con cartas'),
(5,'Miniatures','con muñequitos'),
(6,'Dados','con dados'),
(7,'LCG','con cartas de colección, pero no aleatorias') ON CONFLICT DO NOTHING;

-- Category order relation
insert into subcategory(category,subcategory) values
(3,1),
(4,7) ON CONFLICT DO NOTHING;

-- Shops
insert into shop(id,name,homesite) values
(1,'Mathom','http://mathom.es/'),
(2,'Dungeon Marvels','https://dungeonmarvels.com/') ON CONFLICT DO NOTHING;

insert into shop_category(shop,category,shop_category_name) values
(1,7,'Living Card Game'),
(1,2,'Bélico'),
(2,2,'Bélico') ON CONFLICT DO NOTHING;

-- Products
insert into product(ean,name,image) values
(7545175932419,'LOTR: Core Revised','https://wargenwargames.com/10846-thickbox_default/the-lord-of-the-rings-the-card-game-revised-core-set-spanish.jpg'),
(5576816511924,'LOTR: The Two Towers','https://dungeonmarvels.com/144200-large_default/the-lord-of-the-rings-the-card-game-the-two-towers-saga-expansion-ingles.jpg') ON CONFLICT DO NOTHING;

insert into product_category(product,category) values
(7545175932419,7),
(5576816511924,7) ON CONFLICT DO NOTHING;

insert into product_name(product,name) values
(7545175932419,'Lord of The Rings: Core revised'),
(7545175932419,'Lord of The Rings LCG: Core revised'),
(7545175932419,'LOTR LCG: Core revised'),
(5576816511924,'Lord of The Rings: The Two Towers'),
(5576816511924,'Lord of The Rings LCG: The Two Towers'),
(5576816511924,'LOTR LCG: The Two Towers') ON CONFLICT DO NOTHING;

insert into product_shop(product,shop,buy_url) values
(7545175932419,1,'http://www.test.com/1'),
(5576816511924,2,'http://www.test.com/2'),
(7545175932419,2,'http://www.test.com/3'),
(5576816511924,1,'http://www.test.com/4') ON CONFLICT DO NOTHING;

-- Prices
insert into price_rel(product,shop,date,price) values
(5576816511924,1,'2024-04-24 12:00:00',12),
(5576816511924,1,'2024-04-25 12:00:00',11),
(5576816511924,1,'2024-04-23 12:00:00',10),
(7545175932419,2,'2024-04-24 12:00:00',12),
(7545175932419,1,'2024-04-23 12:00:00',10),
(5576816511924,2,'2024-04-24 12:00:00',12),
(5576816511924,2,'2024-04-25 12:00:00',12),
(5576816511924,2,'2024-04-23 12:00:00',14) ON CONFLICT DO NOTHING;