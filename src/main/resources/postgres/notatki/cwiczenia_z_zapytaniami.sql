set SEARCH_PATH to xxx;

SELECT count(*)/1000 from orders;


-- Ile zamówień zrealizował pracownik nr 5 w roku 2015
SELECT count(*)
FROM orders
WHERE employeeid = 5 and orderdate BETWEEN '2015-01-01' AND '2016-12-31';


-- Ile razy pracownik nr 5 w 2015 roku wykonał sprzedaż produktu nr 10
SELECT count(*)
FROM orders o, orderdetail od
WHERE od.orderid = o.orderid AND
      o.employeeid = 5 AND
      o.orderdate BETWEEN '2015-01-01' AND '2016-12-31' AND
      od.productid = 10;

SELECT count(*)
FROM orders o, orderdetail od
WHERE od.orderid = o.orderid AND
      o.employeeid = 5 AND
      od.productid = 10;



-- Ile produktów typu 10 sprzedał pracownik nr 5 w 2015 roku
SELECT sum(od.quantity)
FROM orders o, orderdetail od
WHERE od.orderid = o.orderid AND
      o.employeeid = 5 AND
      o.orderdate BETWEEN '2015-01-01' AND '2016-12-31' AND
      od.productid = 10;

-- Ile było sprzedaży od klientów z argentyny w 2015r ?
SELECT count(*) FROM orders o, customers c
WHERE o.customerid = c.customerid and
 c.country='Argentina' and
      o.orderdate BETWEEN '2015-01-01' AND '2016-12-31';


--prosta: ile zamówień w 2015r wykonał przewoźnik 'Speedy Express'

--trudniejsza: ile zamówień w 2015r przewoźnik 'Speedy Express' przewiózł do
-- Argentyny


