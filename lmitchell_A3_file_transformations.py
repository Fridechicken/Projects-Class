### Title:  lmitchell_A3_file_transformations.py
### Author: Logan Mitchell
### Class:  CS120-C
### Date:  12/2/2025
### Description:
### This program takes settings from a specified json file, aplies them to a specified text file and then outputs tat onto another text file

import os
import json
from datetime import datetime #from w3
configuration = {
    "INFILE": "input.txt",
    "OUTFILE": "output.txt",
    "CASE": "Title"
    #"OLD_CHAR": ""
    #"NEW_CHAR": ""
}
statistics = {
    "LinesProcessed": 0, 
    "Date": "YYYY/MM/DD", 
    "Time": "HH:MM:SS", 
    "Errors": 0, 
    "LinesSkipped": 0
}
class EmptyFileError(Exception):
        pass
def load_json_configuration(filename):
    try:
        if os.path.isfile(filename):
            with open(filename, "r") as file:
                data = json.load(file)
                for key, value in data.items():
                    upper_key = key.upper()
                    if upper_key in configuration:
                        configuration[upper_key] = value
                    elif key == "max_list_lenght":
                        configuration["MAX_LIST_LENGTH"] = value
                    else:
                        print(f"{upper_key} not found")
                return 1
        else:
            print(f"'{filename}' file not found.")
            return -1
    except FileNotFoundError:
        print(f"'{filename}' file not found.")
        return -1
    except EmptyFileError:
        print(f"'{filename}' file not found.")
        return -1
    
def display_configuration():
    print("Current Configuration Settings:")
    for key, value in configuration.items():
        print(f"- {key} = {value}")

def file_transformation(infile, outfile, transformation):
    num_of_lines = 0
    lines_skipped = 0
    max_lines = configuration["MAX_LIST_LENGTH"]
    try:
        with open(infile, "r") as ifile, open(outfile, "w") as ofile:
            for line in ifile:
                stripped = line.strip()
                if stripped == "":
                    lines_skipped += 1
                else:
                    if num_of_lines < max_lines:
                        if transformation == "upper":
                            new_line = stripped.upper()
                        elif transformation == "lower":
                            new_line = stripped.lower()
                        elif transformation == "title":
                            new_line = stripped.title()
                        else:
                            print("Please enter a valid option.")
                            return -1, 0
                        #try:
                            #if new_char.isalpha() and old_char.isalpha():
                                #for line in ifile:
                                    #new_line = line.replace(old_char, new_char) ### .replace() found on w3
                                    #ofile.write(new_line)
                            #else:
                                #print("Please enter a valid letter.")
                        #except ValueError:
                            #statistics["Errors"] += 1
                            #print("Please enter a valid letter.") 
                        ofile.write(new_line + "\n")
                        num_of_lines += 1
            return 1, num_of_lines
    except ValueError:
        print("Value error while transforming")
        return -1, 0
    except TypeError:
        print("Type error while transforming")
        return -1, 0
    
def display_statistics(stats):
    print("Program Stats")
    for key, value in stats.items():
        print(f"- {key}: {value}")

def save_statistics(stats):
    try:
        with open('statistics.json', "w") as sfile:
            json.dump(stats, sfile, indent=4)
    except FileNotFoundError():
        print("File was not found")
        return -1

def get_stats(load_result, result_bad, stats):
    now = datetime.now() ### from w3
    stats["Time"] = now.strftime("%H:%M:%S") ### from w3
    stats["Date"] = now.strftime("%Y/%m/%d") ### from w3
    if load_result == -1:
        stats["Errors"] += 1
    if result_bad == -1:
        stats["Errors"] += 1
    return stats

def main():
    while True:
        try:                    
            start = input("Start file transfromation Y/N?: ").upper().strip()
            if start == "Y":
                config_file = input("Enter configuration file to load: ").strip()
                load_result = load_json_configuration(config_file)
                if load_result == -1:
                    print(f"Failed to load '{config_file}'.")
                else:
                    display_configuration()
                    infile = configuration["INFILE"]
                    outfile = configuration["OUTFILE"]
                    transformation = configuration["CASE"].lower()
                    result_bad, lines = file_transformation(infile, outfile, transformation)
                    if result_bad == -1:
                        statistics["Errors"] += 1
                        print("Failed to transform.")
                    else:
                        statistics["LinesProcessed"] += lines
                    get_stats(load_result, result_bad, statistics)
                    display_statistics(statistics)
                    save_statistics(statistics)
            elif start == "N":
                print("Done!")
                break
            else:
                print("Please enter a valid option")
        except ValueError:
            print("Please enter Y/N.")

main()