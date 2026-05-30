class EmptyFileError(Exception):
    pass

try:
    numbered_quotes = []
    with open("quotes.txt", 'r') as file1:
        num_of_lines = 0
        for i, line in enumerate(file1, 1):
            titled = line.title().strip()
            numbered_quotes.append(f"{i}: {titled}")
            num_of_lines += 1

    if num_of_lines == 0:
        raise EmptyFileError
    
    for quotes in numbered_quotes:
        print(quotes)

    with open("numbered_quotes.txt", "w") as file2:
        for line in numbered_quotes:
            file2.write(line + "\n")
        print(f"Processed {num_of_lines} quotes and saved them in 'numbered_quotes.txt'.")

except FileNotFoundError:
    print(f"File not found.")
except EmptyFileError:
    print("File is empty")
