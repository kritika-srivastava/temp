# Practice Exercises - JDBC with My SQL

## Problem Statement

Sales management app which is used to store Sales_Rep, Customer,and Invoice. Create the necessary tables, relationships and add sample data into each table.

---

## Tables

1. __Sales_rep__

|Rep_ID |	Name |	City |	commision |
|:---:|:---:|:---:|:---:|
|1001 |	Anthony G |	New Delhi |	0.25 |
|1002 |	Rejina R |	Bangalore |	0.15 |
|1003 |	Santhosh |	Mumbai |	0.12 |
|1005 |	Jaya Prasad |	Chennai |	0.11 |
|1006 |	Diptish |	Kolkatta |	0.12 |
|1007 |	Abbas |	Hyderabad |	0.1 |

2. __Consumer__

| Consumer_ID |	Consumer_Name |	City |	Grade |	Rep_ID |
|:---:|:---:|:---:|:---:|:---:|
|3001 |	Mary |	Chennai |	NULL |	1005 |
|3002 |	Nirav Parmar |	New Delhi |	100 |	1001 |
|3003 |	Ram Sangeeth |	Hyderabad |	200 |	1007 |
|3004 |	Somsubhra |	Kolkatta |	300 |	1006 |
|3005 |	James |	Bangalore |	200 |	1002 |
|3007 |	Harish Manana |	New Delhi |	200 |	1001 |
|3008 |	Rajesh Kumar |	Bangalore |	300 |	1002 |
|3009 |	Sharon George |	Mumbai |	100 |	1003 |

3. __Invoice__

|Invoice_ID |	Invoice_amount |	Invoice_Date 	|Consumer_ID 	| Rep_ID |
|:---:|:---:|:---:|:---:|:---:|
| 10001 |	1500.5 |	2017-10-05 |	3005 	| 1002 |
| 10002 |	6560.2 |	2017-10-05 |	3002 |	1001 |
|10003 |	2480.4 |	2017-10-10 |	3009 |	1003 |
|10004 |	1100.5 |	2017-08-17 |	3009 |	1003 |
|10005 |	2400.6 |	2017-07-27 |	3007 |	1001 |
|10007 |	9480.5 |	2017-09-10 |	3005 |	1002 |
|10008 |	5760 |	2017-09-10 |	3002 |	1001 |
|10009 |	2700.6 |	2017-09-10 |	3001 |	1005 |
|10010 |	1983.43 |	2017-10-10 |	3004 |	1006 |
|10011 |	7500.29 |	2017-08-17 |	3003 |	1007 |
|10012 |	2500.45 |	2017-06-27 |	3008 |	1002 |
|10013 |	3045.6 |	2017-04-25 |	3002 |	1001 |

---
---
&nbsp;

## Solution

---
### SELECTION
---

- _Write a SQL Query to retrieve the details of the Consumer like Consumer_ID, Consumer_Name, City , Grade , Rep_ID who are from Bangalore and Kolkatta._

```
SELECT Consumer_ID, Consumer_Name, City , Grade , Rep_ID FROM Consumer WHERE City IN ('Bangalore', 'Kolkatta');

```

- _Write a SQL Query to retrieve the details of the Invoice like Invoice_ID, Invoice_Date, Consumer_ID, Rep_ID, Invoice_Amount whose Invoice_Amount is more than 5000._

```
SELECT Invoice_ID, Invoice_Date, Consumer_ID, Rep_ID, Invoice_Amount FROM Invoice WHERE Invoice_Amount > 5000;

```

- _Write a SQL Query to retrieve the details of the Sales Rep like Rep_ID, Name, City ,Commision who are from city that ends with ‘i’._

```
SELECT Rep_ID, Name, City ,Commision FROM Sales_Rep WHERE City LIKE '%i';

```
---
### PROJECTION
---

- _Write a SQL statement to display specific columns like name, city and commision for all the salesmen._

```
SELECT Rep_ID, Name, City ,Commision FROM Sales_Rep;

```

- _Write a query to display all the details of the Invoice like Invoice_Date, Rep_ID, Invoice_ID and Invoice_Amount._

```
SELECT Invoice_Date, Rep_ID, Invoice_ID, Invoice_Amount FROM Invoice;

```
---
### Group By , Order By Clauses
---

- _Write a SQL Statement to fetch the Details Consumer like Consumer_ID, Consumer_Name , City , Grade in alphabetical order of Name._

```
SELECT Consumer_ID, Consumer_Name , City , Grade FROM Consumer ORDER BY Name ASC;

```

---
---

