drop procedure if exists average_sales;
drop procedure if exists order_in_period;

-- Create a Stored procedure to retrieve average sales of each product in a month. Month and year will be input parameter to function.
DELIMITER $$

CREATE PROCEDURE average_sales(in_month TINYINT(2), in_year TINYINT(4))
BEGIN
    SELECT p.product_id, p.product_name, COUNT(pod.product_id) AS 'AVERAGE'
    FROM product p, product_order po, product_order_detail pod
    WHERE
    p.product_id = pod.product_id AND pod.order_id = po.order_id AND MONTH(po.order_date) = in_month AND YEAR(po.order_date) = in_year
    GROUP BY p.product_id;
END $$

call average_sales(7, 2018);


/*
Create a stored procedure to retrieve table having order detail with status for a given period.
Start date and end date will be input parameter.
Put validation on input dates like start date is less than end date.
If start date is greater than end date take first date of month as start date.
*/
DELIMITER $$
create procedure order_in_period(in_start_date DATE, in_end_date DATE)
BEGIN
    SET in_start_date = IF(in_start_date > in_end_date, in_end_date-INTERVAL DAY(in_end_date) DAY,in_start_date);
    Select *from product_order_detail WHERE last_update BETWEEN in_start_date AND in_end_date;
END $$

call order_in_period('2018-07-01', '2018-07-31');
call order_in_period('2018-08-01', '2018-07-31');
