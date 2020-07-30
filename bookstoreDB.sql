
// bookstore admin insertion queries

INSERT ALL
INTO bookstore_admin6 (admin_id,email,full_name,password) VALUES (101,'vermaakhil97@gmail.com','Akhil Verma','Euphoria@10')
INTO bookstore_admin6 (admin_id,email,full_name,password) VALUES (102,'kiranrajput@gmail.com','Kiran Rajput','Kiran@10')
INTO bookstore_admin6 (admin_id,email,full_name,password) VALUES (103,'satyamsingh@gmail.com','Satyam Singh','Sinha@10')
INTO bookstore_admin6 (admin_id,email,full_name,password) VALUES (105,'himanshurai@gmail.com','Himanshu Rai','Himanshu@10') SELECT * FROM DUAL;


// book store book category

INSERT ALL
INTO bookstore_book_category6(category_id,category_name) VALUES (100,'fiction')
INTO bookstore_book_category6(category_id,category_name) VALUES (101,'non-fiction')
INTO bookstore_book_category6(category_id,category_name) VALUES (102,'novel')
SELECT * FROM DUAL;

// book-store book

INSERT ALL
INTO bookstore_book6 (book_id,author,description,isbn_number,last_update_time,price,publish_date,rating,title,category_id) 
VALUES (1000,'Stephen Hawking','The Journey of time','1457896','30-APR-2019',124,'30-DEC-2004',4,'The discovery of time',101)
INTO bookstore_book6 (book_id,author,description,isbn_number,last_update_time,price,publish_date,rating,title,category_id) 
VALUES (1001,'George R.R Martin','The seven kingdoms','1457876','30-APR-2017',1244,'30-APR-2002',4,'The Game of Throne - Volume 1',100)
INTO bookstore_book6 (book_id,author,description,isbn_number,last_update_time,price,publish_date,rating,title,category_id) 
VALUES (1002,'George R.R Martin','The seven kingdoms','1457877','30-APR-2018',1248,'05-MAY-2003',4,'The Game of Throne - Volume 2',100)
INTO bookstore_book6 (book_id,author,description,isbn_number,last_update_time,price,publish_date,rating,title,category_id) 
VALUES (1003,'George R.R Martin','The seven kingdoms','1457878','30-APR-2016',1249,'30-AUG-2005',4,'The Game of Throne - Volume 3',100)
SELECT * FROM DUAL;


// book-store customer

INSERT ALL

INTO bookstore_customer6 (customer_id,address,city,country,email,full_name,password,phone_no,register_date,zip_code) 
VALUES (100,'226/126 Ga Prakash Puram','Lucknow','India','vermaakhil04@gmail.com','Akhil Verma','Euphoria@10','9454545454','23-MAY-2002',226004)

INTO bookstore_customer6 (customer_id,address,city,country,email,full_name,password,phone_no,register_date,zip_code) 
VALUES (101,'14441 Law Gate','Phagwara','India','sinhaSatyam@gmail.com','Satyam Sinha','Eureka@10','9450955454','14-DEC-2002',144411)

SELECT * FROM DUAL;

//book-store cart

INSERT ALL
INTO bookstore_cart6 (cart_id,customer_id,quantity,status,book_id,sub_total) 
VALUES (1000,100,12,'Delivered',1000,17856.00)

INTO bookstore_cart6 (cart_id,customer_id,quantity,status,book_id,sub_total) 
VALUES (1001,100,12,'Delivered',1001,14928.00)

INTO bookstore_cart6 (cart_id,customer_id,quantity,status,book_id,sub_total) 
VALUES (1002,101,13,'Delivered',1002,16244.00)

INTO bookstore_cart6 (cart_id,customer_id,quantity,status,book_id,sub_total) 
VALUES (1003,102,14,'Delivered',1003,17472.00)

SELECT * FROM DUAL;

// bookstore-order

INSERT ALL
INTO bookstore_order6 (order_id,city,country,order_date,order_status,payment_method,quantity,recipient_name,recipient_phone_no,shipping_address,street_address,total_price,zip_code,customer_id) 
VALUES (1000,'Lucknow','India','30-APR-2020','Delivered','COD',4,'Akhil Verma','9450652121','266/126 Ga Prakash Puram','Near Ranjana Nursing Home',5000,226004,100)
INTO bookstore_order6 (order_id,city,country,order_date,order_status,payment_method,quantity,recipient_name,recipient_phone_no,shipping_address,street_address,total_price,zip_code,customer_id) 
VALUES (1001,'Agra','India','03-DEC-2019','Delivered','COD',4,'Satyam Sinha','9434443434','232/11 Tikait Ganj, Jaipuria School Gate No. 2','LIG, lakhan',6000,226005,100)
INTO bookstore_order6 (order_id,city,country,order_date,order_status,payment_method,quantity,recipient_name,recipient_phone_no,shipping_address,street_address,total_price,zip_code,customer_id) 
VALUES (1002,'Jalandhar','India','30-APR-2020','Delivered','COD',4,'Akhil Verma','9450652121','266/126 Ga Prakash Puram','Near Ranjana Nursing Home',5000,226004,100)
INTO bookstore_order6 (order_id,city,country,order_date,order_status,payment_method,quantity,recipient_name,recipient_phone_no,shipping_address,street_address,total_price,zip_code,customer_id) 
VALUES (1003,'Hyderabad','India','30-APR-2020','Delivered','COD',4,'Himanshu Rai','9450652121','266/126 Ga Prakash Puram','Near Ranjana Nursing Home',5000,226004,100)
INTO bookstore_order6 (order_id,city,country,order_date,order_status,payment_method,quantity,recipient_name,recipient_phone_no,shipping_address,street_address,total_price,zip_code,customer_id) 
VALUES (1004,'Bangalore','India','03-DEC-2019','Delivered','COD',4,'Kiran Rajput','9434443434','232/11 Tikait Ganj, Jaipuria School Gate No. 2','LIG, lakhan',6000,226005,100) SELECT * FROM DUAL;


// 

INSERT ALL
INTO bookstore_order6_cart (order_information_order_id,cart_cart_id) 
VALUES (1000,1001)
INTO bookstore_order6_cart (order_information_order_id,cart_cart_id) 
VALUES (1000,1002) SELECT * FROM DUAL;