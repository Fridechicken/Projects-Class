### Title:  hw07-Exercise3.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:  11/11/2025
### Description:
### This program takes a user enerted string and tracks how many times a word is used and displays this information

def  count_words(user_input):
    word_count = {}
    word = ""
    for ch in user_input:
        if ch.isalpha() or ch.isdigit():
            word += ch
        else:
            if word:
                word_count[word] = word_count.get(word, 0) + 1
                word = ""
            if ch.strip():
                word_count[ch] = word_count.get(ch, 0) + 1
    if word:
        word_count[word] = word_count.get(word, 0) + 1
    return word_count
def display_counts(word_count):
    max_word = ""
    max_count = -1
    for key in word_count:
        if word_count[key] > max_count:
            max_count = word_count[key]
            max_word = key
    print(f"the word used the most is {max_word}")
    for key, value in word_count.items():
        print(f"{key}: {value}")
def main():
    while True:
        user_input = input("Enter a sentence or type Quit to exit: ").strip().lower()
        if user_input == "quit":
            print("Done")
            break
        elif not user_input:
            print("Please enter a string")
        else:
            results = count_words(user_input)
            display_counts(results)
main()