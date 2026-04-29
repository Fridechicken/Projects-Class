secret = input("Input secret word: ")
sentence = input("Type your sentence: ")
cleaned_secret = secret.lower().strip()
cleaned_sentence = sentence.lower().strip()
Code = cleaned_secret.replace(cleaned_secret, "***")
hidden_word = ""
for ch in cleaned_secret:
    hidden_word = hidden_word + "*"
final_code = cleaned_sentence.replace(cleaned_secret, hidden_word)
print(final_code)
