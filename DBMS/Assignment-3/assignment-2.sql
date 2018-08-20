use storefront;

-- Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories

SELECT 
    t1.category_name AS Parent_Cat, t2.category_name as Category
FROM
    category AS t1
        INNER JOIN
    category AS t2 ON t2.parent_category = t1.category_id;

insert into category_relation(category_id, product_id) values (2,5);

SELECT 
    p.product_id,
    p.product_name,
    COUNT(cr.product_id) AS category_count
FROM
    product AS p
        LEFT JOIN
    category_relation AS cr ON p.product_id = cr.product_id
GROUP BY cr.product_id
HAVING COUNT(cr.product_id) > 1;

/*Display Count of products as per below price range:
Range in Rs.    Count
0 - 100
101 - 500
Above 500
*/

select 
    '0 - 100' as 'Range in Rs.', count(product_id) as 'Count'
FROM
    product
where
    product_price BETWEEN 0 AND 100 
UNION select 
    '101 - 500' as 'Range in Rs.', count(product_id) as 'Count'
FROM
    product
where
    product_price BETWEEN 101 AND 500 
UNION select 
    'Above 500' as 'Range in Rs.', count(product_id) as 'Count'
FROM
    product
where
    product_price > 500;

-- Display the Categories along with number of products under each category

select 
    category_id, count(product_id)
from
    category_relation
group by category_id;