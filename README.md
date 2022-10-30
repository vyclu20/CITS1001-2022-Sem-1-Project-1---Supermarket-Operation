# Java-Project-1---Supermarket Operation

Last updated: 16 Apr 2022

**This was a university project for a basic object oriented unit/module. Was graded above 85% for it, program passes all tests and works.**

## Project Overview:

There are several objects involved in the operation of a supermarket, including a customer, product, order, and store.

This program should be able to read information of products line by line from an input file, take and process orders and generate an invoice displaying order details of a customer after processing the order.

There is an input file (input.txt) in this repository which contains the Product ID, Price, Discount(%), Store ID and Product Category as headers. Each line in the input file are product details. It is used for testing.

### There were three classes I needed to edit: Product, Store, and Order.

> Product - This class gets product details from the input file and prepares the product information using accessor methods. There are no mutator methods in this class.

> Store - This class makes use of the Product class to gather product information to complete store operations. 

> Order - This class also communicates with the Product class to process the orders for a customer. The constructor in this class takes an Order ID to generate the invoice receipt. 

> Both the Store and Order classes are able to create anonymous product type objects corresponding to the number of products in the input files.

> FileReader: This class is used by the three classes above to read the input file. I did not write this class, it was written by the unit coordinator.

This repository also contains 3 JUNIT test classes to test the Product, Store and Order codes. I did not write these test classes either, they were written by my unit coordinator.
