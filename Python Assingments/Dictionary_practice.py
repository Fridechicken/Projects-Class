### Title:  hw07-Exercise2.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:  11/11/2025
### Description:
### This program displays users settings and allows them to change their settings
settings = {"Volume": 75, "Theme": "Light", "Notifications": True}
def volume_change(user_choice):
        update_volume = int(input("How loud do you want (1-100): "))
        settings[user_choice] = update_volume
def theme_change(user_choice):
        update_theme = input("Light or dark theme: ")
        settings[user_choice.capitalize()] = update_theme
def notifications_change(user_choice):
        update_notifications = input("Would you like your notifications on or off: ").strip().lower()
        if update_notifications == "on":
            settings[user_choice] = True
        elif update_notifications == "off":
            settings[user_choice] = False
        else:
            print("Please enter a valid option: ")
def main():
    while True:
        for key, value in settings.items():
            print(f"The {key} is {value}")
        user_choice = input("Choose what setting you would like to change or type Exit to exit: ").strip().capitalize()
        if user_choice == "Exit":
            for key, value in settings.items():
                print(f"The {key} is {value}")
            break
        elif user_choice == "Volume":
            volume_change(user_choice)
        elif user_choice == "Theme":
            theme_change(user_choice)
        elif user_choice == "Notifications":
            notifications_change(user_choice)
        else:
            print("This setting does not exist") 
main()     
