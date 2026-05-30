### Title:  hw04_exercise2.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:   9/18/2025
### Description:
### This code checks the length of a password
def is_special_found(str):
    special_char = "!@#$%&*"
    for ch in special_char:
        if (str.find(ch) > -1):
            return True
    return False

password = input("Enter your Password: ")
lenght = len(password)
if lenght >= 8:
    if (is_special_found(password)):
        print("Vaild")
    else:
        print("Incorrect")
    print("Password is Valid - Exceeds the Minimum Length of 8 and at least one special character.")
else:
    print("Password is Invalid - Is less than 8 and is too short and is missing a special character.")