use storefront;

-- Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days.

CREATE VIEW order_information
AS
SELECT o.order_id as 'Id', p.product_name as 'Title', p.product_price as 'Price', 
       u.user_name as 'Shopper_Name', u.user_email as 'E-Mail', o.order_date as 'Order_Date', opr.status as 'Status'
FROM product_order AS o
LEFT JOIN product_order_detail AS opr ON o.order_id = opr.order_id
LEFT JOIN product AS p ON opr.product_id = p.product_id
LEFT JOIN user AS u ON o.user_id = u.user_id
WHERE o.order_date > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY o.order_date DESC;

-- Use the above view to display the Products(Items) which are in ‘shipped’ state.

SELECT Title FROM order_information WHERE Status='SHIPPED';


-- Use the above view to display the top 5 most selling products.

Select Title
FROM order_information
ORDER BY price DESC
LIMIT 5;