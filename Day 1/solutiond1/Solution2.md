# Problem Statement 2 

### __Write an algorithm & pseudocode to print prime numbers from 1 to 100.__

&nbsp;




------------
## Algorithm
------------
1. START
2. Declare two integer variables n1 and n2 where n1 is 1 and n2 is 100.
3. For every number i between n1 and n2 check if the number is divisible by any number between 2 and i/2 (both inclusive).

5. If the number is not divisible then display the number and continue. 
6. Otherwise continue without displaying the number.
7. STOP

&nbsp;

------------
## Pseudo Code
------------

```
INITIALIZE n1 = 1 and n2 = 100.
INITIALIZE i = 1 and j = 2

FOR i in BETWEEN 1 and 100
    
    INITIALIZE flag = 0
    
    FOR j in between 2 and i/2

        IF i / j == 0
            flag = 1
            BREAK
        ELSE
            INCREMENT j
        
        
    IF flag == 1
        PRINT i
    
    INCREMENT i

```

----
----