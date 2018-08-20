-- Create a function to calculate number of orders in a month. Month and year will be input parameter to function
DROP FUNCTION if exists no_of_orders_in_month;
DROP FUNCTION if exists max_order_month;

DELIMITER |
CREATE FUNCTION no_of_orders_in_month(month INT, year INT) RETURNS INT 
    DETERMINISTIC
        BEGIN
            DECLARE order_count INT;
                    Select count(*) INTO order_count from product_order
                    where EXTRACT(MONTH FROM order_date) = month AND EXTRACT(YEAR FROM order_date) = year;
        RETURN order_count;
    END |
    
select no_of_orders_in_month(7, 2018);

-- Create a function to return month in a year having maximum orders. Year will be input parameter.

DELIMITER |
CREATE FUNCTION max_order_month(in_year INT) RETURNS INT 
    DETERMINISTIC
        BEGIN
            DECLARE max_order_month INT;
                    Select MONTH(order_date) INTO max_order_month
                    from product_order
                    where YEAR(order_date) in (in_year)
                    GROUP BY MONTH(order_date)
                    ORDER BY COUNT(*) DESC
                    LIMIT 1;
        RETURN max_order_month;
    END |
    
select max_order_month(2018);