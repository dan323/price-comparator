-- Categories
insert into category(id,name) values ('1','Eurogame'),
('2','War'),
('3','Abstract'),
('4','Cards'),
('5','Miniatures'),
('6','Dados'),
('7','LCG') ON CONFLICT DO NOTHING;

-- Category order relation
insert into subcategory(category,subcategory) values ('3','1'), ('4','7') ON CONFLICT DO NOTHING;

-- Shops
insert into shop(id,name,homesite) values ('1','Mathom','http://mathom.es/'),
 ('2','Dungeon Marvels','https://dungeonmarvels.com/') ON CONFLICT DO NOTHING;

