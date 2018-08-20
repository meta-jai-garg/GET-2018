use storefront;

/*Display Shopper’s information along with number of orders he/she placed during last 30 days.*/
SELECT 
    u.user_name,
    u.user_email,
    COUNT(o.order_id) AS 'Total Orders'
FROM
    user u
        INNER JOIN
    product_order o ON u.user_id = o.user_id
WHERE
    o.order_date > DATE_SUB(NOW(), INTERVAL 30 DAY)
GROUP BY o.user_id;

/*Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.*/
SELECT 
    u.user_name,
    u.user_email,
    SUM(p.product_price) as 'Total_Purchase'
FROM
    user u
        LEFT JOIN
    product_order po ON u.user_id = po.user_id
        LEFT JOIN
    product_order_detail pod ON po.order_id = pod.order_id
        LEFT JOIN
    product p ON pod.product_id = p.product_id
WHERE
    po.order_date > DATE_SUB(NOW(), INTERVAL 30 DAY)
GROUP BY u.user_id
ORDER BY 'Total_Purchase'
LIMIT 10;


/*Display top 20 Products which are ordered most in last 60 days along with numbers.*/
select 
    p.product_name, COUNT(pod.product_id) AS 'Product_Count'
from
    product p
        INNER JOIN
    product_order_detail pod ON p.product_id = pod.product_id
        INNER JOIN
    product_order po ON pod.order_id = po.order_id
where
    po.order_date > DATE_SUB(NOW(), INTERVAL 60 DAY)
group by p.product_id
order by 'Product_Count'
LIMIT 20;

/*Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.*/
select MONTHNAME(po.order_date) AS 'MONTH' , SUM(pod.amount) AS 'Total_Amount'
From product_order po INNER JOIN product_order_detail pod ON pod.order_id = po.order_id
GROUP BY MONTH(po.order_date);

/*Mark the products as Inactive which are not ordered in last 90 days.*/
ALTER TABLE product ADD active tinyint(1) DEFAULT 1 after description;

UPDATE product p
LEFT JOIN product_order_detail pod ON p.product_id = pod.product_id
LEFT JOIN product_order po ON pod.order_id = po.order_id
SET p.active = 0
WHERE po.order_date < DATE_SUB(NOW(), INTERVAL 60 DAY)
AND p.product_id NOT IN
(Select product_id
FROM product_order_detail pod
LEFT JOIN product_order po ON pod.order_id = po.order_id
where po.order_date>=DATE_SUB(NOW(), INTERVAL 90 DAY));


/*Given a category search keyword, display all the Products present in this category.*/
SELECT 
    p.product_name
FROM
    product p
        INNER JOIN
    category_relation cr ON p.product_id = cr.product_id
        INNER JOIN
    category c ON  c.category_id = cr.category_id 
where
    c.category_name LIKE 'Mobile';
    
/*Display top 10 Items which were cancelled most.*/

SELECT 
    p.product_name, count(pod.status) AS 'cancelled_count'
FROM
    product p
        INNER JOIN
    product_order_detail pod ON pod.product_id = p.product_id
WHERE
    pod.status = 'CANCELLED'
GROUP BY p.product_name
ORDER BY cancelled_count
LIMIT 10;