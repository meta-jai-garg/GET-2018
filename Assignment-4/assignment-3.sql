/*
There is no need to create index in product
and category relation as both the relation have primary key to uniquely identify a tuple
so it make no sense to create duplicate primary key as index.
*/


-- adding index to product_order_table
ALTER TABLE product_order ADD INDEX order_date_index (order_date);
