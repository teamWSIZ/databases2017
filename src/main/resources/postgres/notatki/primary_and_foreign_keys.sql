ALTER TABLE xxx.orderdetail
  ADD CONSTRAINT orderdetail_orderdetailid_pk PRIMARY KEY (orderdetailid);


ALTER TABLE xxx.orderdetail
ADD CONSTRAINT orderdetail___fk
FOREIGN KEY (orderid) REFERENCES xxx.orders (orderid) ON DELETE CASCADE;
