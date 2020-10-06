//#TODO - This needs to be revisited

Setup of tables:

1) Item table will be pre populated. ItemController(Rest API endpoints) has created to populate the items in the table.

Assumptions:
1) Customer's shipping address and billing address will be same for now from implementation perspective.

Tables used in this scenario:
1) Item
2) CustomerOrder
3) Address
4) customer
5) payment

Relation between tables:
1) address table address_id (Primary Key) -> customer table (Foreign key)
)2 customer table customer_id (Primary Key) -> order table (Foreign key)
3) address table address_id (Primary Key) -> payment table (Foreign key)
4) customer table customer_id (Primary Key) -> payment table (Foreign Key)

Endpoints:

1) /ecommerce/item/create: to create data in item table.
2) /ecommerce/item/{orderId}: to fetch data from item table.
3) /ecommerce/order/create: to create order of cuetomer.
4) /ecommerce/order/{orderId}: to fetch customer record.
5) /ecommerce/order/update/{updateOrderId}: to cancel customer's order. For this, soft_delete field in customerorder table has been set to false which will indicate that order has been cancelled.

