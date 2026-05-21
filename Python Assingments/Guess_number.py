### Title:  hw05_exercise3.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:   10/01/2025
### Description:
### Asks the user to guess a number between one and ten. Loops until correct
import random
def guess_the_number():
    number = random.randint(1,10)#(10,70)
    while True:
        user_guess = int(input("Guess the number between 1 and 10: "))#"Guess the number between 10 and 70: "
        if user_guess == number:
            print(f"Correct! The number was {number}.")
            break
        else:
            print("Try again.")
def main():
    guess_the_number()
main()