use storefront;

/**   Q.1.   ********************************************Insertion of data***********************************************************/

-- user tabel 

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/user_details.tsv' INTO TABLE user(user_name, user_type, registration_date);

-- address table

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/user_address.tsv' INTO TABLE address(user_id, phone, house_no, street, city, state,country,zipcode);

/*
Modifying product table to add 'description' column
*/
ALTER TABLE product
ADD COLUMN description VARCHAR(100) after stock;

-- product table
LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/product_details.tsv' INTO TABLE product(product_name, product_price, stock, description,added_date, modify_date);

-- category table

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/category_details.tsv' INTO TABLE category(category_id, category_name, parent_category);

-- category relation table

INSERT INTO category_relation(category_id, product_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(6,6),(6,7),(6,8),(17,9),(17,10),(22,11),(22,12);

-- product image table

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/product_image_details.tsv' INTO TABLE product_image(img_url, img_name, product_id);

-- product order table

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/order.tsv' INTO TABLE product_order(address_id, order_date);

-- product_order_detail table

LOAD DATA LOCAL
INFILE 'C:/Users/User22/Downloads/order_details.tsv' INTO TABLE product_order_detail(order_id, product_id, amount, status, last_update);


/*   Q.2. Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top */
SELECT 
    P.product_id as ID,
    P.product_name as Title,
    Cat.category_name as CategoryTitle,
    P.product_price as Price
FROM
    product P
        JOIN
    (Select 
        PCR.product_id, PCR.category_id, PC.category_name
    from
        category_relation PCR
    Join category PC ON PCR.category_id = PC.category_id) Cat ON P.product_id = Cat.product_id
WHERE
    stock > 0
ORDER BY modify_date DESC;

/*Q.3. Display the list of products which don't have any images*/
SELECT 
    p.product_id, p.product_name
FROM
    product p
WHERE
    p.product_id NOT IN (SELECT 
        product_id
    from
        product_image);

/*Q.4. Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)*/
SELECT 
    a.category_id AS ID,
    a.category_name AS 'Parent Category',
    b.category_name AS 'Category Title'
FROM
    category a
        INNER JOIN
    category b ON a.category_id = b.parent_category
ORDER BY a.category_name,b.category_name;

/* Q.5. Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)*/
SELECT 
    a.category_id AS ID,
    a.category_name As Title,
    b.category_name As Parent
FROM
    category a
        LEFT JOIN
    category b ON a.parent_category = b.category_id
WHERE
    a.parent_category != 0;

/*Q.6. Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”) */
SELECT 
    product.product_name,
    product.product_id,
    product.description
FROM
    product
        LEFT JOIN
    CATEGORY ON Product.Product_id = CATEGORY.category_id
        LEFT JOIN
    Category_Relation ON Category_Relation.Category_id = Category_Relation.Category_id
WHERE
    Category.Category_name = 'MOBILE';

/* Q.7. Display the list of Products whose Quantity on hand (Inventory) is under 50*/

SELECT 
    product_name AS Product
FROM
    product
where
    stock < 50;
    
/*Q.8. Increase the Inventory of all the products by 100*/
update product SET stock = stock+100;