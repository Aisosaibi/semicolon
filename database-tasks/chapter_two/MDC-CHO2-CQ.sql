#Solutions:
-- Prerequisite: USE MDC_CHO2 

-- A: Show all data in each of the tables
SELECT * FROM CUSTOMER;
SELECT * FROM INVOICE;
SELECT * FROM INVOICE_ITEM;  

-- B: List the LastName, FirstName, and Phone of all customers
SELECT LastName, FirstName, Phone FROM CUSTOMER;

-- C: List the LastName, FirstName, and Phone for all customers with a FirstName of 'Nikki'
SELECT LastName, FirstName, Phone FROM CUSTOMER
WHERE FirstName = "Nikki";

-- D: List the LastNmae, FirstName, Phone, DateIn and DateOUt of all orders in excess of $100.00 
SELECT LastName, FirstName, Phone, DateIn, DateOut 
FROM CUSTOMER, INVOICE 
WHERE CUSTOMER.CustomerID = INVOICE.CustomerID
	AND TotalAmount > 100.00;

-- E. List the LastName, FirstName, and Phone of all customers whose first name starts with ‘B’.
SELECT LastName, FirstName, Phone 
FROM CUSTOMER 
WHERE FirstName LIKE 'B%';

-- F. List the LastName, FirstName, and Phone of all customers whose last name includes the characters ‘cat’.
SELECT LastName, FirstName, Phone FROM CUSTOMER 
WHERE LastName LIKE '%cat%';

-- G. List the LastName, FirstName, and Phone for all customers whose second and third digits (from the left) of their phone number are 23.
SELECT LastName, FirstName, Phone 
FROM CUSTOMER 
WHERE Phone LIKE '_23%';

-- H. Determine the maximum and minimum TotalAmount.
SELECT MAX(TotalAmount), MIN(TotalAmount) FROM INVOICE;

-- I.Determine the average TotalAmount.
SELECT AVG(TotalAmount) FROM INVOICE;

-- J.Count the number of customers.
SELECT COUNT(*) FROM CUSTOMER;

-- K. Group customers by LastName and then by FirstName.
SELECT LastName, FirstName FROM CUSTOMER
GROUP BY LastName, FirstName;
#can use SELECT DISTINCT...

-- L. Count the number of customers having each combination of LastName and FirstName.
SELECT LastName, FirstName, COUNT(*) AS NumCustomers
FROM Customer
GROUP BY LastName, FirstName;

-- M. Show the LastName, FirstName, and Phone of all customers who have had an order
SELECT LastName, FirstName, Phone
FROM CUSTOMER
WHERE CustomerID IN (SELECT CustomerID FROM INVOICE WHERE TotalAmount > 100.00)
ORDER BY LastName ASC, FirstName DESC;
