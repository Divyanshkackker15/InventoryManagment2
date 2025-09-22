Queries

-- Show all products in the inventory
SELECT * FROM products;

-- Show only product names and categories
SELECT name, category FROM products;

-- Find products where quantity is more than 10
SELECT * FROM products WHERE quantity > 10;

-- Find products where price is less than 5000
SELECT * FROM products WHERE price < 5000;

-- Show all Electronics products
SELECT * FROM products WHERE category = 'Electronics';

-- Show all products sorted by price (highest first)
SELECT * FROM products ORDER BY price DESC;

-- Show the top 3 most expensive products
SELECT * FROM products ORDER BY price DESC LIMIT 3;

-- Find the total number of products (sum of quantity)
SELECT SUM(quantity) AS total_quantity FROM products;

-- Find the average price of products
SELECT AVG(price) AS average_price FROM products;

-- Find the highest priced product
SELECT * FROM products ORDER BY price DESC LIMIT 1;