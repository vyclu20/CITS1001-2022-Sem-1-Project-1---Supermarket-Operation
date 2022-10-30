# Java-Project-1---Supermarket Operation

Project was last updated on: 16 Apr 2022

**This was a university project for a basic java object oriented programming unit/module.**

There were more classes to this project but they were not written by me. So only what I have uploaded are my edits of the given skeletons (author name in Java files), and running these Java files alone will not work. The code itself passed all tests and overall received a project grade of over 85%.

## Project Overview:

There are several objects involved in the operation of a supermarket, including a customer, product, order, and store.

This program should be able to read information of products line by line from an input file, take and process orders and generate an invoice displaying order details of a customer after processing the order.

There was an input file (input.txt) in the project which contains the Product ID, Price, Discount(%), Store ID and Product Category as headers. Each line in the input file are product details. It was used for testing.

### There were three classes I needed to edit: Product, Store, and Order. The TO DO's were what I had to edit.

> Product - This class gets product details from the input file and prepares the product information using accessor methods. There are no mutator methods in this class.

> Store - This class makes use of the Product class to gather product information to complete store operations. 

> Order - This class also communicates with the Product class to process the orders for a customer. The constructor in this class takes an Order ID to generate the invoice receipt. 

> Both the Store and Order classes are able to create anonymous product type objects corresponding to the number of products in the input files.
