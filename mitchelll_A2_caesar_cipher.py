### Title:  mitchell_A2_caesar_cipher.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:   10/21/2025
### Description:
### implements differnet functions to preform a caesar cipher

ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def shift_char(ch, k):
    """
    Shift a single character by k positions.
    Steps:
    1. Check if ch is a letter.
    2. Convert it to uppercase for processing.
    3. Find its position in ALPHABET.
    4. Add the shift (or subtract if decrypt), wrap with % 26.
    5. Get the shifted letter from ALPHABET.
    6. Match the original case (upper/lower).
    7. If not a letter, return it unchanged.
    """
    if ch.isalpha():
        up = ch.upper()
        found = ALPHABET.index(up)
        shift = ALPHABET[(found + k) % 26]
        if ch.islower():
            shifted = shift.lower()
        else: 
            shifted = shift
        return shifted
    else:
        return ch

def shift_text(text, k, mode="encrypt"):
    """
    Shift the entire string.
    Algorithm:
    - If decrypting, flip the sign of k.
    - Start with an empty result string.
    - Loop through each character in text.
    - For each character, call shift_char().
    - Add the shifted character to the result string.
    - Return the result string.
    """
    # TODO: implement algorithm
    new_text = ""
    if mode == "decrypt":
        k = - k
        for ch in text:
            new_text += shift_char(ch, k)
        return new_text
    elif mode == "encrypt":
        for ch in text:
            new_text += shift_char(ch, k)
        return new_text
    else:
        return ""

def get_shift():
    """
    Get a valid shift number from the user.
    Algorithm:
    - Prompt the user for a shift value.
    - Validate that the input is a number.
    - Convert to int and wrap with % 26.
    - Return the shift.
    """
    # TODO: implement algorithm
    while True:
        user_num = input("Enter a shift value (0-25): ").strip()
        if user_num.isnumeric():
            num = int(user_num) % 26
            return num
        else:
            print("Please enter an valid number.")
    
    return 0

def brute_force(ciphertext):
    """
    OPTIONAL
    Brute force decryption attempt.
    Algorithm:
    - Loop through all shifts from 0 to 25.
    - For each shift, call shift_text() in decrypt mode.
    - Print the result for each shift.
    """
    for k in range(26):
       encrypted_text = shift_text(ciphertext, k, mode="decrypt")
       print(f"Shift {k:2}: {encrypted_text}") 
    # TODO: implement algorithm
    return

def main():
    while True:
        print("\n=== Caesar Cipher Toolkit ===")
        print("(1) Encrypt")
        print("(2) Decrypt")
        print("(3) Brute-force")
        print("(Q) Quit")
        choice = input("Choice: ").strip().lower()

        if choice == "1":
            text = input("Enter plaintext: ").strip()
            k = get_shift()
            encrypted = shift_text(text, k, "encrypt")
            print(f"Cyphertext: {encrypted}")
        elif choice == "2":
            text = input("Enter cyphertext: ").strip()
            k = get_shift()
            decrypted = shift_text(text, k, "decrypt")
            print(f"Cyphertext: {decrypted}")
        elif choice == "3":
            text = input("Enter encrypted text: ").strip()
            brute_force(text)
        elif choice == "q":
            print("Done!")
            break
        else:
            print("Enter a valid option")

if __name__ == "__main__":
    main()