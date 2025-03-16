# ReadMe File for the "Calculator" Project

## Project Description

This project is a console-based calculator written in Java. The calculator supports basic arithmetic operations (addition, subtraction, multiplication, division, and modulus) as well as additional functions such as exponentiation, square root, absolute value, and rounding. The program also includes a calculation history feature that saves all performed operations.

## How I Came to This Solution

At first, I thought it would be simple: take two numbers, perform an operation, and output the result. However, as I started writing the code, I realized it wasn't that straightforward.

### First Steps

I began by implementing basic operations like addition, subtraction, multiplication, and division. This was easy to do simple mathematical operations in Java. Then, I added error handling to ensure the program wouldn't crash if the user entered invalid input, such as dividing by zero.

### Adding Advanced Functions

Next, I decided to add more complex functions like exponentiation, square root, absolute value, and rounding. This is where I encountered my first major challenge, how to handle expressions containing multiple operations and functions and add priorities. I watched YouTube videos and got some way of solutions.

### Parsing Expressions

I started researching how to parse mathematical expressions.I found examples of using recursive descent parsing. This was challenging for me. I wrote code that breaks down the expression into parts and evaluates it while respecting operation precedence. This took a lot of time, and I had to rewrite the code several times to make it work correctly.

### Calculation History

I added the calculation history feature. This was easier: I used a list (`ArrayList`) to store each expression and its result. At the end of the program, I display the entire history.

### Errors and Fixes

While working on the project, Intelij was finding several errors. For example, the program didn't always handle expressions with negative numbers correctly. There was also an issue with using variables inside anonymous classes, which resulted in the error `"local variables referenced from an inner class must be final or effectively final"`. I fixed this by making the `expression` variable final.

## Some probles which I got

1. **Parsing Expressions**: This was the most difficult part. I had to learn how parsers work and how to correctly parse expressions while respecting operation precedence.
2. **Error Handling**: I spent a lot of time figuring out how to prevent the program from crashing when invalid data was entered. Eventually, I added checks and exceptions.
3. **Using Anonymous Classes**: I didn't immediately understand why variables inside anonymous classes had to be final. This required additional research.

## Conclusion

This project was an excellent way for me to apply my Java knowledge in practice. I learned a lot, such as how to work with recursive descent parsing and how to handle errors. The program that we are given to study at the university is only a small part of everything that we need to know. Even a simple calculator causes me great difficulties. It seemed to me that I already knew the basics of programming and that I could master the calculator among other projects. However, there were great difficulties here too.  Although it was challenging, I'm happy with the result.
