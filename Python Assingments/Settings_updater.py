import json

with open('config.json') as infile:
    data = json.load(infile)
    
print("Current Configuration Settings:")
for key, value in data.items():
    print(f"- {key} = {value}")

while True:
    user_input = input("Would you like to update the settings (Y/N): ").strip().upper()

    if user_input == "Y":
        print("Update The Configuration Settings:")
        update_username = input(f"- Enter new username (or press Enter to keep '{data['username']}'):").strip()
        update_theme = input(f"- Enter new theme (or press Enter to keep '{data['theme']}'):").strip()
        update_autosave = input(f"- Enter new autosave (or press Enter to keep '{data['autosave']}'):").strip().lower()

        if update_username == "":
            pass
        else:
            data['username'] = update_username
        if update_theme == "":
            pass
        else:
            data['theme'] = update_theme
        if update_autosave == "":
            pass
        else: 
            if update_autosave == "true":
                data['autosave'] = True
            elif update_autosave == "false":
                data['autosave'] = False
            else:
                print("Please enter a valid option.")

        print("Updated Configuration Settings:")
        for key, value in data.items():
            print(f"- {key} = {value}")  

    elif user_input == "N":
        with open("updated_config.json", "w") as outfile:
            json.dump(data, outfile, indent=4)
        print("Configuration saved to updated_config.json.")
        break
    else:
        print("Please enter a valid either Y or N")
