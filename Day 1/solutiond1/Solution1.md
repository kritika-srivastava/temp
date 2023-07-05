# Problem Statement 1

### __Write an algorithm & pseudocode that accepts 2 numbers and a char (operator) to create a simple calculation of addition, division, subtraction and multiplication and displays the output.__

&nbsp;




------------
## Algorithm
------------
1. START
2. Declare two integer variables n1 and n2 and a character variable ch.
3. Take the two numbers, for arithmetic operations and a character for operation.
4. Define the characters for arithmetic operations, i.e.,
   
   - '+' - Addition
   - '-' - Subtraction 
   - '*' - Multiplication
   - '/' - Division

5. Based on the character, perform the arithmetic operation on two numbers and save the result.
   - '+' : n1 + n2
   - '-' : n1 - n2
   - '*' : n1 * n2
   - '/' : n1 / n2

6. Display the result.
7. STOP



&nbsp;

------------
## Pseudo Code
------------

```
INITIALIZE n1 = 0,n2 = 0 and result = 0
INITIALIZE ch to ' '

INPUT n1, n2 and ch

IF ch equals '+' 
        result = n1 + n2
ELSE IF  ch equals '-'
        result = n1 - n2
ELSE IF  ch equals '*'
        result = n1 * n2
ELSE IF  ch equals '/'
        result = n1 / n2
ELSE 
    PRINT 'Invalid Input"

PRINT  result
```

----
----