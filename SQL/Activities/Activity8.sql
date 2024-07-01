select customer_id, max(purchase_amount) from orders group by customer_id;
select salesman_id, max(purchase_amount), order_date from orders where order_date = to_date('2012/08/17', 'YYYY/MM/DD')  group by salesman_id, order_date;
select customer_id, order_date, max(purchase_amount) from orders group by customer_id, order_date having max(purchase_amount) in (2030, 3450, 5760, 6000);




select customers.customer_name, customers.city, salesman.name, salesman.commission from
  customers inner join salesman on customers.salesman_id = salesman.salesman_id;

select customers.customer_name, customers.city, customers.grade, salesman.name, salesman.city from customers left outer join salesman
on customers.salesman_id = salesman.salesman_id where customers.grade<300 order by customers.customer_id;

select customers.customer_name, customers.city, salesman.name, salesman.commission from customers inner join salesman on 
  customers.salesman_id = salesman.salesman_id where salesman.commission>12;

