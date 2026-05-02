### Title:  hw07-Exercise1.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:  11/11/2025
### Description:
### This program takes employe data and calulates their pay

employees = (("John", 20, 40), ("Jane", 25, 35), ("Doe", 30, 45))

def calculate_payroll():
    payroll = []
    for info in employees:
        name, wage, hours = info
        pay = wage * hours
        payroll.append((name, pay))
    return payroll

def display_payroll(payroll):
    payroll = calculate_payroll()
    for name, pay in payroll:
        print(f"{name} earned ${pay} this week.")
def main():
    payroll_list = calculate_payroll()
    display_payroll(payroll_list)

main()