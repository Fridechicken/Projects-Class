### Title:  hw05_exercise2.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:   10/01/2025
### Description:
### Calculates the factorial of the users input

def calculate_factorial(n): # I got the basics for this from Telusko on youtube
    f = 1
    for i in range(1, n+1):
        f = f*i
    return f

def main():
    #loop_break = False
    while True: 
        positive_integer = int(input("Enter a positive integer: "))
        if positive_integer < 0:
            print("Please enter a positive integer.")
        elif positive_integer == 0:
            print("Done!") 
            break
            #loop_break
        else:
            print(f"The factorial of {positive_integer} is: {calculate_factorial(positive_integer)}")
main()