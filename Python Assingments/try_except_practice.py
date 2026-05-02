def try_except(user_input):
    try:
        with open(user_input, "r") as file:
            for line in file:
                print(line, end='') 
            print()
    except FileNotFoundError:
        print(f"No such file or directory: {file}")
    else:
        pass
    finally:
        print("Python is so helpful!")

def main():
    user_input = input("Enter a File to Open: ")
    try_except(user_input)

main()