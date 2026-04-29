try:
    while True:
        get_age = input("Enter your age or type exit to exit: ").lower().strip()
        
        if get_age == "exit":
            print("You are free!")
            break 
        else:
            age = int(get_age)
            if age < 18:
                print("You are a minor")
            elif 18 <= age < 65:
                print("You are an adult")
            elif age >= 65:
                print("You are a senior")

except ValueError:
    print("That was not a number >:(")