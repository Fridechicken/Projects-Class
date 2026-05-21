class EmptyFileError(Exception):
        pass
try:
    user_file = input("What file would you like to open: ")
    with open(user_file, "r") as file1:
        valid_nums = []
        num_of_lines = 0
        error_count = 0
        for line in file1:
            num_of_lines += 1
            text = line.strip()
            try:
                is_num = float(text)
                valid_nums.append(is_num)
            except ValueError:
                error_count += 1
                print("Warning")
                print(f"- Invalid data on line {num_of_lines} ('{text}')")
    if num_of_lines == 0:
         raise EmptyFileError
    valid_count = len(valid_nums)
    total_sum = sum(valid_nums)
    error_vs_errors = "error" if error_count == 1 else "errors"
    print("Finished Processing:")
    print(f"- Read {valid_count} valid numbers, with {error_count} {error_vs_errors}")
    print(f"- Sum = {total_sum}")
except ValueError:
    print(f"This line could not be ")
except EmptyFileError:
    print("File is empty")
except FileNotFoundError:
    print("That file does not exist.")