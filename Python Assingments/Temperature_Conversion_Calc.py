### Title:  hw03_exercise2.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:   9/11/2025
### Description:
### This program takes the user input for a temperature in farhrenheit, converts it to celsuis, round the output down to one decimal, and then prints it 

def temp_conversion():
    while True:
        user_input = input("Enter F for Fahrenheit to Celsius, C for Celsius to Fahrenheit, or X to exit: ").upper().strip()
        if user_input == "X":
            print("Done")
            break
        elif user_input == "F":
            user_temp_F = float(input("Enter a temperature in Fahrenheit: "))
            Celsius = round((user_temp_F-32)*0.556, 2)
            print(f"The temperature in Celsius is: {Celsius}")
        elif user_input == "C":
            user_temp_C = float(input("Enter a temperature in Celsius: "))
            Fahrenheit = round((user_temp_C*(9/5))+32, 2)
            print(f"The temperature in Fahrenheit is: {Fahrenheit}")
            
def main():
    temp_conversion()

main()