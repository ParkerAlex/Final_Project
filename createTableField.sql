-- create Categories
insert into shops.categories (name) values
('FRUITS'),
('VEGETABLES'),
('DAIRY PRODUCTS'),
('CUTTING PRODUCTS'),
('BEVERAGES');

-- create Products
insert into shops.products (name, categories_id) values
('MILK', 2),
('COTTAGE CHEESE', 3),
('JUICE', 1),
('PASTA', 4),
('BEET', 5),
('TOMATOES', 3),
('CHOCOLAD', 1),
('KAKAO', 5),
('TEA', 3),
('BANANAS', 2);

-- create Shops
insert into shops.shops (name) values
('ALMI'),
('GREEN'),
('BELMARKET'),
('EVROOPT'),
('PASTA'),
('KORONA');

-- create intermediates
insert into shops.intermediates (shops_id, products_id) values
(5, 3),
(4, 9),
(3, 8),
(2, 3),
(5, 6),
(2, 1),
(3, 4),
(1, 2),
(4, 5),
(5, 2),
(2, 3);

-- create Price
insert into shops.prices (cost, check_in, intermediates_id) values
(1, '2021-01-05', 2),
(2, '2021-03-05', 3),
(3, '2021-05-06', 6),
(4, '2021-04-06', 4),
(5, '2021-07-07', 8),
(2, '2021-10-05', 7),
(3, '2021-11-15', 6),
(1, '2021-01-05', 5),
(2, '2021-10-19', 4),
(3, '2021-09-22', 3),
(4, '2021-11-05', 2),
(5, '2021-11-11', 2),
(2, '2021-12-12', 1);	
