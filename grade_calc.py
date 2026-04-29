try:
    while True:
        get_grade = input("Enter your grade or type exit to exit: ").lower().strip()
        if get_grade == "exit":
            print("Done!")
            break
        else:
            grade = float(get_grade)
            if grade >= 90:
                print(f"An average of {grade}% receives a letter grade of A.")
            elif 80.0 <= grade < 90.0:
                print(f"An average of {grade}% receives a letter grade of B.")
            elif 80.0 <= grade < 90.0:
                print(f"An average of {grade}% receives a letter grade of C.")
            elif 80.0 <= grade < 90.0:
                print(f"An average of {grade}% receives a letter grade of D.")
            elif grade < 60.0:
                print(f"An average of {grade}% receives a letter grade of F.")
except ValueError:
    print("please enter a number")
