### Title:  hw06-Exercise.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:  11/1/2025
### Description:
### This program is an inventory mangment system that can add, remove, check inventory, and clear everyting
def add_item(inventory):
    new_item = input("Enter the item to add: ").strip().lower()
    if new_item not in inventory:
        inventory.append(new_item)
        print(f"'{new_item}' has been added to the inventory")
        return 
    else:
        print(f"'{new_item}' is already in your inventory")
def remove_item(inventory):
    item_remove = input("Enter an item to remove: ").strip().lower()
    if item_remove in inventory:
        inventory.remove(item_remove)
        print(f"{item_remove} has been removed.")
    else:
        print(f"'{item_remove}' is not in the inventory")
    return
def display_inventory(inventory):
    if not inventory:
        print("Your inventory is currently empty")
    else:
        for i, row in enumerate(inventory):
            print(f"{row} is in your inventory")
    return
def clear_inventory(inventory):
    inventory.clear()
    return
def main ():
    inventory = []
    while True:
        print("\nInventory Management System")
        print("1. Add item to inventory")
        print("2. Remove item from inventory")
        print("3. Display inventory")
        print("4. Exit")
        print("5. Clear inventory")
        menu_input= int(input("Enter your choice 1-5: "))
        if menu_input == 1:
            add_item(inventory)
        elif menu_input == 2:
            remove_item(inventory)
        elif menu_input == 3:
            display_inventory(inventory)
        elif menu_input == 4:
            print("Done!")
            break
        elif menu_input == 5:
            clear_inventory(inventory)
            print("Inventory cleared")
        else:
            print("Invaild choice. Please enter a number between 1-5.")
main()
