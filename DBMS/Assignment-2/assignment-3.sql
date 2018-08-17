use storefront;

/*Q.1. Display Recent 50 Orders placed (Id, Order Date, Order Total).*/
SELECT 
    po.order_id, DATE(PO.order_date), SUM(pod.amount)
FROM
    product_order po
        JOIN
    product_order_detail pod ON po.order_id = pod.order_id
GROUP BY pod.order_id
ORDER BY po.order_date DESC
LIMIT 50;

/*Q.2. Display 10 most expensive Orders.*/

SELECT T.id, T.OrderDate, T.OrderTotal
FROM (
 SELECT PO.order_id as Id, DATE(PO.order_date) as OrderDate, SUM(OT.amount) as OrderTotal
 FROM product_order PO JOIN product_order_detail OT
 ON PO.order_id = OT.order_id
 GROUP BY OT.order_id
) T
ORDER BY T.OrderTotal DESC
LIMIT 10;

/*Q.3. Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.*/
SELECT order_id, DATE(order_date)
FROM product_order
WHERE order_id IN (SELECT detail_id FROM product_order_detail WHERE status = 'SHIPPED') AND DATEDIFF(Now(),order_date) > 10;

/*Q.4. Display list of shoppers which haven't ordered anything since last month.*/
SELECT user_id, user_name 
FROM user
WHERE user_id NOT IN (
	SELECT user.user_id FROM user JOIN address ON user.user_id = address.address_id
	WHERE address.address_id IN (SELECT order_id FROM product_order WHERE DATEDIFF(Now(),order_date) < 30)
);

/* Q.5. Display list of shopper along with orders placed by them in last 15 days. */
SELECT userId, id, order_item.order_id, product_id
FROM product_order_detail
JOIN (
	SELECT product_order.Id as order_id, order_time, userId FROM product_order JOIN address ON address.id = shipping_address_id
) UserOrder
ON order_item.order_id = UserOrder.order_id
WHERE DATEDIFF(Now(),order_time) < 15
Order BY userId;

/*Q.6. Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))*/
SELECT order_id
FROM product_order_detail
WHERE order_id = 1 AND status = 'SHIPPED';

/*Q.7. Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price*/
SELECT Item.order_id
FROM product_order_detail Item JOIN product_order PO
ON Item.order_id = PO.order_id
WHERE Item.amount BETWEEN 100 AND 5000;


/*Q.8. Update first 20 Order items status to “Shipped” which are placed today*/
UPDATE product_order_detail 
SET status = 'SHIPPED'
WHERE order_id IN (SELECT order_id FROM product_order WHERE DATE(order_date) = CURDATE());
